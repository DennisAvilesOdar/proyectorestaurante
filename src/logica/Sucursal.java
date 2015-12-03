package logica;
import accesodatos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JComboBox;

public class Sucursal extends Conexion{
    private int codigo_sucursal;
    private String nombre;
    private String direccion;
    private String telefono;
    private int codigo_departamento;
    private int codigo_provincia;
    private int codigo_distrito;
    
    public static ArrayList<Sucursal> listaSucursales = new ArrayList<Sucursal>();
    
    public int getCodigo_sucursal() {
        return codigo_sucursal;
    }

    public void setCodigo_sucursal(int codigo_sucursal) {
        this.codigo_sucursal = codigo_sucursal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getCodigo_departamento() {
        return codigo_departamento;
    }

    public void setCodigo_departamento(int codigo_departamento) {
        this.codigo_departamento = codigo_departamento;
    }

    public int getCodigo_provincia() {
        return codigo_provincia;
    }

    public void setCodigo_provincia(int codigo_provincia) {
        this.codigo_provincia = codigo_provincia;
    }

    public int getCodigo_distrito() {
        return codigo_distrito;
    }

    public void setCodigo_distrito(int codigo_distrito) {
        this.codigo_distrito = codigo_distrito;
    }
    
    public String[] obtenerCamposFiltro(){
        String campos[] = {"codigo_sucursal", "nombre", "direccion", "telefono", "departamento", "provincia", "distrito"};
        return campos;
    }
    
    public ResultSet listar() throws Exception{
        String sql="select * from f_listar_sucursal()";
        PreparedStatement sp = this.abrirConexion().prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultado = this.ejecutarSQLSelectSP(sp);
        return resultado;
    }
    
    public boolean agregar() throws Exception{
        String sql = "select * from f_generar_correlativo('sucursal') as correlativo";
        ResultSet rsCorrelativo = this.ejecutarSQLSelect(sql);
        int numeroCorrelativo=0;
        
        if (rsCorrelativo.next()){
            numeroCorrelativo = rsCorrelativo.getInt("correlativo");
            this.setCodigo_sucursal(numeroCorrelativo);
        }else{
            throw new Exception("No se ha configurado el correlativo para la tabla sucursal");
        }
        
        Connection con = this.abrirConexion();
        con.setAutoCommit(false);
        sql= "INSERT INTO sucursal(codigo_sucursal, nombre, dirección, telefono, codigo_departamento, "
                + "codigo_provincia, codigo_distrito) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?);";
        
        PreparedStatement sp = con.prepareStatement(sql);
        sp.setInt(1, this.getCodigo_sucursal());
        sp.setString(2, this.getNombre());
        sp.setString(3, this.getDireccion());
        sp.setString(4, this.getTelefono());
        sp.setInt(5, this.getCodigo_departamento());
        sp.setInt(6, this.getCodigo_provincia());
        sp.setInt(7, this.getCodigo_distrito());
        this.ejecutarSQLsp(sp, con);
        
        sql = "update correlativo set numero = ? where tabla = 'sucursal'";
        PreparedStatement spAC = con.prepareStatement(sql);
        spAC.setInt(1, this.getCodigo_sucursal());
        this.ejecutarSQLsp(spAC, con);
        con.commit();
        con.close();
        return true;
    }
    
    public ResultSet leerDatos( int codigoArticulo ) throws Exception{
        String sql = "select * from f_leer_datos_sucursal(?)";
        
        PreparedStatement sp = this.abrirConexion().prepareStatement(sql);
        sp.setInt(1, codigoArticulo);
        ResultSet resultado = this.ejecutarSQLSelectSP(sp);
        return resultado;
    }
    
    public boolean editar() throws Exception{
        String sql = "UPDATE sucursal SET nombre=?, dirección=?, telefono=?, codigo_departamento=?, "
                + "codigo_provincia=?, codigo_distrito=? WHERE codigo_sucursal=?";
        Connection con = this.abrirConexion();
        con.setAutoCommit(false);
        
        PreparedStatement sp = con.prepareStatement(sql);
        sp.setString(1, this.getNombre());
        sp.setString(2, this.getDireccion());
        sp.setString(3, this.getTelefono());
        sp.setInt(4, this.getCodigo_departamento());
        sp.setInt(5, this.getCodigo_provincia());
        sp.setInt(6, this.getCodigo_distrito());
        sp.setInt(7, this.getCodigo_sucursal());
        this.ejecutarSQLsp(sp, con);
        con.commit();
        con.close();
        return true;
    }
    
    public boolean eliminar() throws Exception{
        String sql = "delete  from sucursal where codigo_sucursal = ?";
        Connection con = this.abrirConexion();
        con.setAutoCommit(false);
        PreparedStatement sp = con.prepareStatement(sql);
        sp.setInt(1, this.getCodigo_sucursal());
        this.ejecutarSQLsp(sp, con);
        
        con.commit();
        con.close();
        return true;
    }
    
    //PARA CARGAR EL COMBOBOX
    private void cargarTabla() throws Exception{
        String sql = "select * from sucursal order by 2";
        ResultSet resultado = this.ejecutarSQLSelect(sql);
        listaSucursales.clear();
        while(resultado.next()){
            Sucursal objS = new Sucursal();
            objS.setCodigo_sucursal(resultado.getInt("codigo_sucursal") );
            objS.setNombre(resultado.getString("nombre") );
            objS.setDireccion(resultado.getString("dirección") );
            objS.setTelefono(resultado.getString("telefono") );
            objS.setCodigo_departamento(resultado.getInt("codigo_departamento") );
            objS.setCodigo_provincia(resultado.getInt("codigo_provincia") );
            objS.setCodigo_distrito(resultado.getInt("codigo_distrito") );
            listaSucursales.add(objS);
        }
        
    }
    
    public void llenarCombo( JComboBox objCombo ) throws Exception{
        this.cargarTabla();
        objCombo.removeAllItems();
        for (int i = 0; i < listaSucursales.size(); i++) {
            objCombo.addItem( listaSucursales.get(i).getNombre());
        }
    }
}
