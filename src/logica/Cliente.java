package logica;

import accesodatos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Cliente extends Conexion{
    private int codigo_cliente;
    private String tipo_cliente;
    private String ruc;
    private String dni;
    private String razon_social;
    private String nombre_completo;
    private String telefono;
    private String email;
    private String convenio;

    public int getCodigo_cliente() {
        return codigo_cliente;
    }

    public void setCodigo_cliente(int codigo_cliente) {
        this.codigo_cliente = codigo_cliente;
    }

    public String getTipo_cliente() {
        return tipo_cliente;
    }

    public void setTipo_cliente(String tipo_cliente) {
        this.tipo_cliente = tipo_cliente;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public String getNombre_completo() {
        return nombre_completo;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }
    
    public String[] obtenerCamposFiltro(){
        String campos[] = {"ruc","dni","razon_social","nombre_completo"};
        return campos;
    }
    
    public ResultSet listar() throws Exception{
        String sql="select * from cliente";
        PreparedStatement sp = 
                this.abrirConexion().prepareStatement(
                        sql,
                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY
                );
        ResultSet resultado = this.ejecutarSQLSelectSP(sp);
        
        return resultado;
    }
    public boolean agregar() throws Exception{
        
        /*Inicio: Generando un nuevo correlativo*/
        String sql = "select * from f_generar_correlativo('cliente') as correlativo";
        ResultSet rsCorrelativo = this.ejecutarSQLSelect(sql);
        
        int numeroCorrelativo=0;
        
        if (rsCorrelativo.next()){
            numeroCorrelativo = rsCorrelativo.getInt("correlativo");
            this.setCodigo_cliente(numeroCorrelativo);
        }else{
            throw new Exception("No se ha configurado el correlativo para la tabla artículo");
        }
        
        /*Fin: Generando un nuevo correlativo*/
        
        
        /*Inicio: Creando una nueva transacción*/
        Connection con = this.abrirConexion();
        con.setAutoCommit(false);
        /*Fin: Creando una nueva transacción*/
        
        /*Inicio: Insertamos en la tabla linea*/
        sql = "INSERT INTO public.cliente("
                + "codigo_cliente, "
                + "tipo_cliente, "
                + "ruc, "
                + "dni, "
                + "razon_social, "
                + "nombre_completo, "
                + "telefono, "
                + "email, "
                + "convenio) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
        
        PreparedStatement sp = con.prepareStatement(sql);
        sp.setInt(1, this.getCodigo_cliente());
        sp.setString(2, this.getTipo_cliente());
        sp.setString(3, this.getRuc());
        sp.setString(4, this.getDni());
        sp.setString(5, this.getRazon_social());
        sp.setString(6, this.getNombre_completo());
        sp.setString(7, this.getTelefono());
        sp.setString(8, this.getEmail());
        sp.setString(9, this.getConvenio());
        
        this.ejecutarSQLsp(sp, con);
        /*Fin: Insertamos en la tabla linea*/
        
        
        /*Inicio: Actualizamos en la tabla correlativo*/
        sql = "update correlativo set numero = ? where tabla = 'cliente'";
        PreparedStatement spAC = con.prepareStatement(sql);
        spAC.setInt(1, this.getCodigo_cliente() );
        this.ejecutarSQLsp(spAC, con);
        /*Fin: Actualizamos en la tabla correlativo*/
        
        
        /*Inicio: Cerrando la transacción*/
        con.commit();
        con.close();
        /*Fin: Cerrando la transacción*/
        
        return true;
    }
    public ResultSet leerDatos( int codigoCliente ) throws Exception{
        String sql = "select * from cliente where codigo_cliente = ?";
        
        PreparedStatement sp = 
                this.abrirConexion().prepareStatement(sql);
        sp.setInt(1, codigoCliente);
        ResultSet resultado = this.ejecutarSQLSelectSP(sp);
        return resultado;
    }
    public boolean editar() throws Exception{
        String sql = "UPDATE public.cliente SET "
                + "tipo_cliente=?, "
                + "ruc=?, "
                + "dni=?, "
                + "razon_social=?, "
                + "nombre_completo=?, "
                + "telefono=?, "
                + "email=?, "
                + "convenio=? "
                + "WHERE codigo_cliente=?;";
        
        Connection con = this.abrirConexion();
        con.setAutoCommit(false);
        
        PreparedStatement sp = con.prepareStatement(sql);
        sp.setString(1, this.getTipo_cliente());
        sp.setString(2, this.getRuc());
        sp.setString(3, this.getDni());
        sp.setString(4, this.getRazon_social());
        sp.setString(5, this.getNombre_completo());
        sp.setString(6, this.getTelefono());
        sp.setString(7, this.getEmail());
        sp.setString(8, this.getConvenio());
        sp.setInt(9, this.getCodigo_cliente());
        this.ejecutarSQLsp(sp, con);
        
        con.commit();
        con.close();
        
        return true;
    }
    
    public boolean eliminar() throws Exception{
        String sql = "DELETE FROM public.cliente WHERE codigo_cliente = ?";
        
        Connection con = this.abrirConexion();
        con.setAutoCommit(false);
        
        PreparedStatement sp = con.prepareStatement(sql);
        sp.setInt(1, this.getCodigo_cliente());
        this.ejecutarSQLsp(sp, con);
        
        con.commit();
        con.close();
        
        return true;
    }
    
}
