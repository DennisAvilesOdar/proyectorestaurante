package logica;
import accesodatos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JComboBox;

public class Articulo extends Conexion{
    private int codigo_articulo;
    private String nombre;
    private double precio_venta;
    private String presentacion;

    public static ArrayList<Articulo> listaArticulos= new ArrayList<Articulo>();
    
    public int getCodigo_articulo() {
        return codigo_articulo;
    }

    public void setCodigo_articulo(int codigo_articulo) {
        this.codigo_articulo = codigo_articulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(double precio_venta) {
        this.precio_venta = precio_venta;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }
    
        public String[] obtenerCamposFiltro(){
        String campos[] = {"codigo_articulo", "nombre", "presentacion"};
        return campos;
    }
        
    public ResultSet listar() throws Exception{
        String sql="select * from f_listar_articulo() as articulo";
        PreparedStatement sp = this.abrirConexion().prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultado = this.ejecutarSQLSelectSP(sp);
        return resultado;
    }
    
    public boolean agregar() throws Exception{
        String sql = "select * from f_generar_correlativo('articulo') as correlativo";
        ResultSet rsCorrelativo = this.ejecutarSQLSelect(sql);
        int numeroCorrelativo=0;
        
        if (rsCorrelativo.next()){
            numeroCorrelativo = rsCorrelativo.getInt("correlativo");
            this.setCodigo_articulo(numeroCorrelativo);
        }else{
            throw new Exception("No se ha configurado el correlativo para la tabla articulo");
        }
        
        Connection con = this.abrirConexion();
        con.setAutoCommit(false);
        sql= "INSERT INTO articulo(codigo_articulo, nombre, precio_venta, presentacion) VALUES (?, ?, ?, ?);";
        
        PreparedStatement sp = con.prepareStatement(sql);
        sp.setInt(1, this.getCodigo_articulo());
        sp.setString(2, this.getNombre());
        sp.setDouble(3, this.getPrecio_venta());
        sp.setString(4, this.getPresentacion());
        this.ejecutarSQLsp(sp, con);
        
        sql = "update correlativo set numero = ? where tabla = 'articulo'";
        PreparedStatement spAC = con.prepareStatement(sql);
        spAC.setInt(1, this.getCodigo_articulo());
        this.ejecutarSQLsp(spAC, con);
        con.commit();
        con.close();
        return true;
    }
    
    public ResultSet leerDatos( int codigoArticulo ) throws Exception{
        String sql = "select * from f_leer_datos_articulo(?)";
        
        PreparedStatement sp = this.abrirConexion().prepareStatement(sql);
        sp.setInt(1, codigoArticulo);
        ResultSet resultado = this.ejecutarSQLSelectSP(sp);
        return resultado;
    }
    
    public boolean editar() throws Exception{
        String sql = "UPDATE articulo SET nombre=?, precio_venta=?, presentacion=? WHERE codigo_articulo=?";
        Connection con = this.abrirConexion();
        con.setAutoCommit(false);
        
        PreparedStatement sp = con.prepareStatement(sql);
        sp.setString(1, this.getNombre());
        sp.setDouble(2, this.getPrecio_venta());
        sp.setString(3, this.getPresentacion());
        sp.setInt(4, this.getCodigo_articulo());
        this.ejecutarSQLsp(sp, con);
        con.commit();
        con.close();
        return true;
    }
    
    public boolean eliminar() throws Exception{
        String sql = "delete  from articulo where codigo_articulo = ?";
        Connection con = this.abrirConexion();
        con.setAutoCommit(false);
        PreparedStatement sp = con.prepareStatement(sql);
        sp.setInt(1, this.getCodigo_articulo());
        this.ejecutarSQLsp(sp, con);
        
        con.commit();
        con.close();
        return true;
    }
    
    private void cargarTabla() throws Exception{
        String sql = "select * from articulo order by 2";
        ResultSet resultado = this.ejecutarSQLSelect(sql);
        listaArticulos.clear();
        while(resultado.next()){
            Articulo objA = new Articulo();
            objA.setCodigo_articulo(resultado.getInt("codigo_articulo") );
            objA.setNombre(resultado.getString("nombre") );
            objA.setPrecio_venta(resultado.getDouble("precio_venta") );
            objA.setPresentacion(resultado.getString("presentacion") );
            listaArticulos.add(objA);
        }        
    }
    public void llenarCombo( JComboBox objCombo ) throws Exception{
        this.cargarTabla();
        objCombo.removeAllItems();
        for (int i = 0; i < listaArticulos.size(); i++) {
            objCombo.addItem( listaArticulos.get(i).getNombre());
        }
    }
}
