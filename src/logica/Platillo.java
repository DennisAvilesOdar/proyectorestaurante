package logica;
import accesodatos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Platillo extends Conexion{
    private int codigo_platillo;
    private String nombre;
    private String descripcion;
    private double precio;
    private ArrayList<PlatilloInsumo> detalleInsumos;
    private ArrayList<PlatilloArticulo> detalleArticulos;
    
    public int getCodigo_platillo() {
        return codigo_platillo;
    }

    public void setCodigo_platillo(int codigo_platillo) {
        this.codigo_platillo = codigo_platillo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public ArrayList<PlatilloInsumo> getDetalleInsumos() {
        return detalleInsumos;
    }

    public void setDetalleInsumos(ArrayList<PlatilloInsumo> detalleInsumos) {
        this.detalleInsumos = detalleInsumos;
    }

    public ArrayList<PlatilloArticulo> getDetalleArticulos() {
        return detalleArticulos;
    }

    public void setDetalleArticulos(ArrayList<PlatilloArticulo> detalleArticulos) {
        this.detalleArticulos = detalleArticulos;
    }
    
    public ResultSet listar(int insumo, int articulo) throws Exception{
         String sql = "  select * from f_listado_platillo(?, ?);";
         PreparedStatement sentencia = this.abrirConexion().prepareStatement(sql);
         sentencia.setInt(1, insumo);
         sentencia.setInt(2, articulo);
         
         ResultSet resultado = this.ejecutarSQLSelectSP(sentencia);
         return resultado;
     }

      public boolean agregar() throws Exception{
         String sql = "select * from f_generar_correlativo('platillo') as numero";
         ResultSet resultado = this.ejecutarSQLSelect(sql);
         if (resultado.next()){
             int nroPlatillo = resultado.getInt("numero");
             this.setCodigo_platillo(nroPlatillo);
             
             Connection con = this.abrirConexion();
             con.setAutoCommit(false);
             
             sql = "INSERT INTO platillo(codigo_platillo, nombre, descripcion, precio) VALUES (?, ?, ?, ?)";

             PreparedStatement spPlatillo = con.prepareStatement(sql);
             spPlatillo.setInt(1, this.getCodigo_platillo());
             spPlatillo.setString(2, this.getNombre());
             spPlatillo.setString(3, this.getDescripcion());
             spPlatillo.setDouble(4, this.getPrecio());
             this.ejecutarSQLsp(spPlatillo, con);
             
             for (int i = 0; i < detalleInsumos.size(); i++) {
                 sql = "INSERT INTO insumo_platillo(codigo_insumo, codigo_platillo, cantidad) VALUES (?, ?, ?)";
                 PreparedStatement spInsumoPlatillo = con.prepareStatement(sql);
                 spInsumoPlatillo.setInt(1, detalleInsumos.get(i).getCodigo_insumo());
                 spInsumoPlatillo.setInt(2, this.getCodigo_platillo());
                 spInsumoPlatillo.setInt(3, detalleInsumos.get(i).getCantidad());
                 
                 this.ejecutarSQLsp(spInsumoPlatillo, con);
             }
             
             for (int i = 0; i < detalleArticulos.size(); i++) {
                 sql = "INSERT INTO articulo_platillo(codigo_articulo, codigo_platillo, cantidad) VALUES (?, ?, ?)";
                 PreparedStatement spArticuloPlatillo = con.prepareStatement(sql);
                 spArticuloPlatillo.setInt(1, detalleArticulos.get(i).getCodigo_articulo());
                 spArticuloPlatillo.setInt(2, this.getCodigo_platillo());
                 spArticuloPlatillo.setInt(3, detalleArticulos.get(i).getCantidad());
                 
                 this.ejecutarSQLsp(spArticuloPlatillo, con);
             }
             
             sql = "update correlativo set numero = numero + 1 where tabla = 'platillo'";
             PreparedStatement spActCor = con.prepareStatement(sql);
             this.ejecutarSQLsp(spActCor, con);
             
             con.commit();
             con.close();
             
         }else{
             throw new Exception("No se ha configurado el correlativo para la tabla platillo");
         }
         return true;
     }
    
      public boolean anular( int numeroPlatillo) throws Exception{
         String sql = "select estado from platillo where codigo_platillo=? ";
         PreparedStatement spValidarAnulado = this.abrirConexion().prepareStatement(sql);
         spValidarAnulado.setInt(1, numeroPlatillo);
         ResultSet rsValidar = this.ejecutarSQLSelectSP(spValidarAnulado);
         if (rsValidar.next()){
             if (rsValidar.getString("estado").equalsIgnoreCase("I")){
                 throw new Exception("El platillo que está intentando anular ya ha sido anulada.");
             }
         }
         
         sql = "select codigo_platillo, codigo_insumo from insumo_platillo where codigo_platillo = ?";
         PreparedStatement sentencia = this.abrirConexion().prepareStatement(sql);
         sentencia.setInt(1, numeroPlatillo);
         
         Connection transaccion = this.abrirConexion();
         transaccion.setAutoCommit(false);
         
         sql = "update platillo set estado = 'I' where codigo_platillo= ?";
         PreparedStatement spAnularPlatillo = transaccion.prepareStatement(sql);
         spAnularPlatillo.setInt(1, numeroPlatillo);
         this.ejecutarSQLsp(spAnularPlatillo, transaccion);
         
         transaccion.commit();
         transaccion.close();   
         return true;
      }
      
}
