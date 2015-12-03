package logica;
import accesodatos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JComboBox;

public class Producto extends Conexion{

    private int codigo_producto;
    private String tipo_producto;
    private String nombre;
    private double precio;
    private String descripcion;

    private static ArrayList<Producto> listaProductos = new ArrayList<Producto>();
    
    public int getCodigo_producto() {
        return codigo_producto;
    }

    public void setCodigo_producto(int codigo_producto) {
        this.codigo_producto = codigo_producto;
    }

    public String getTipo_producto() {
        return tipo_producto;
    }

    public void setTipo_producto(String tipo_producto) {
        this.tipo_producto = tipo_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String[] obtenerCamposFiltro(){
        String campos[] = {"codigo_producto", "nombre", "descripcion"};
        return campos;
    }
    
    public ResultSet listar() throws Exception{
        String sql="select * from f_listar_producto()";
        PreparedStatement sp = this.abrirConexion().prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultado = this.ejecutarSQLSelectSP(sp);
        return resultado;
    }
    
    public boolean agregar() throws Exception{
        String sql = "select * from f_generar_correlativo('producto') as correlativo";
        ResultSet rsCorrelativo = this.ejecutarSQLSelect(sql);
        int numeroCorrelativo=0;
        
        if (rsCorrelativo.next()){
            numeroCorrelativo = rsCorrelativo.getInt("correlativo");
            this.setCodigo_producto(numeroCorrelativo);
        }else{
            throw new Exception("No se ha configurado el correlativo para la tabla producto");
        }
        
        Connection con = this.abrirConexion();
        con.setAutoCommit(false);
        sql= "INSERT INTO producto(codigo_producto, tipo_producto, nombre, precio, descripcion) "
                + "VALUES (?, ?, ?, ?, ?);";
        
        PreparedStatement sp = con.prepareStatement(sql);
        sp.setInt(1, this.getCodigo_producto());
        sp.setString(2, this.getTipo_producto());
        sp.setString(3, this.getNombre());
        sp.setDouble(4, this.getPrecio());
        sp.setString(5, this.getDescripcion());
        this.ejecutarSQLsp(sp, con);
        
        sql = "update correlativo set numero = ? where tabla = 'producto'";
        PreparedStatement spAC = con.prepareStatement(sql);
        spAC.setInt(1, this.getCodigo_producto());
        this.ejecutarSQLsp(spAC, con);
        con.commit();
        con.close();
        return true;
    }
    
    public ResultSet leerDatos( int codigoProducto ) throws Exception{
        String sql = "select * from f_leer_datos_producto(?)";
        
        PreparedStatement sp = this.abrirConexion().prepareStatement(sql);
        sp.setInt(1, codigoProducto);
        ResultSet resultado = this.ejecutarSQLSelectSP(sp);
        return resultado;
    }
    
    public boolean editar() throws Exception{
        String sql = "UPDATE producto SET tipo_producto=?, nombre=?, precio=?, descripcion=? WHERE codigo_insumo=?";
        Connection con = this.abrirConexion();
        con.setAutoCommit(false);
        
        PreparedStatement sp = con.prepareStatement(sql);
        sp.setString(1, this.getTipo_producto());
        sp.setString(2, this.getNombre());
        sp.setDouble(3, this.getPrecio());
        sp.setString(4, this.getDescripcion());
        sp.setInt(5, this.getCodigo_producto());
        this.ejecutarSQLsp(sp, con);
        con.commit();
        con.close();
        return true;
    }
    
    public boolean eliminar() throws Exception{
        String sql = "delete  from producto where codigo_producto = ?";
        Connection con = this.abrirConexion();
        con.setAutoCommit(false);
        PreparedStatement sp = con.prepareStatement(sql);
        sp.setInt(1, this.getCodigo_producto());
        this.ejecutarSQLsp(sp, con);
        
        con.commit();
        con.close();
        return true;
    }
    
     private void cargarTabla() throws Exception{
        String sql = "select * from producto order by 2";
        ResultSet resultado = this.ejecutarSQLSelect(sql);
        listaProductos.clear();
        while(resultado.next()){
            Producto objI = new Producto();
            objI.setCodigo_producto(resultado.getInt("codigo_producto") );
            objI.setTipo_producto(resultado.getString("tipo_producto") );
            objI.setNombre(resultado.getString("nombre") );
            objI.setPrecio(resultado.getDouble("precio") );
            objI.setDescripcion(resultado.getString("descripcion") );
            listaProductos.add(objI);
        }        
    }
    public void llenarCombo( JComboBox objCombo ) throws Exception{
        this.cargarTabla();
        objCombo.removeAllItems();
        for (int i = 0; i < listaProductos.size(); i++) {
            objCombo.addItem(listaProductos.get(i).getNombre());
        }
    }

    
}
