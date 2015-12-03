package logica;

import accesodatos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Proveedor extends Conexion{
    private String ruc_proveedor;
    private String razon_social;
    private String direccion;
    private String telefono;
    private String representante_legal;

    public String getRuc_proveedor() {
        return ruc_proveedor;
    }

    public void setRuc_proveedor(String ruc_proveedor) {
        this.ruc_proveedor = ruc_proveedor;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
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

    public String getRepresentante_legal() {
        return representante_legal;
    }

    public void setRepresentante_legal(String representante_legal) {
        this.representante_legal = representante_legal;
    }
    
    public String[] obtenerCamposFiltro(){
        String campos[] = 
                        {
                            "ruc_proveedor",
                            "razon_social", 
                        };
        return campos;
    }
    public ResultSet listar() throws Exception{
        String sql="select * from proveedor";
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
        /*Inicio: Creando una nueva transacción*/
        Connection con = this.abrirConexion();
        con.setAutoCommit(false);
        /*Fin: Creando una nueva transacción*/
        
        /*Inicio: Insertamos en la tabla linea*/
        String sql = "INSERT INTO public.proveedor("
                + "ruc_proveedor, "
                + "razon_social, "
                + "direccion, "
                + "telefono, "
                + "representante_legal) "
                + "VALUES (?, ?, ?, ?, ?);";
        
        PreparedStatement sp = con.prepareStatement(sql);
        sp.setString(1, this.getRuc_proveedor());
        sp.setString(2, this.getRazon_social());
        sp.setString(3, this.getDireccion());
        sp.setString(4, this.getTelefono());
        sp.setString(5, this.getRepresentante_legal());
        this.ejecutarSQLsp(sp, con);
        /*Fin: Insertamos en la tabla linea*/
        
        /*Inicio: Cerrando la transacción*/
        con.commit();
        con.close();
        /*Fin: Cerrando la transacción*/
        
        return true;
    }
    
    public boolean editar() throws Exception{
        String sql = "UPDATE public.proveedor SET "
                + "razon_social=?, "
                + "direccion=?, "
                + "telefono=?, "
                + "representante_legal=? "
                + "WHERE ruc_proveedor=?;";
        
        Connection con = this.abrirConexion();
        con.setAutoCommit(false);
        
        PreparedStatement sp = con.prepareStatement(sql);
        sp.setString(1, this.getRazon_social());
        sp.setString(2, this.getDireccion());
        sp.setString(3, this.getTelefono());
        sp.setString(4, this.getRepresentante_legal());
        sp.setString(5, this.getRuc_proveedor());
        
        this.ejecutarSQLsp(sp, con);
        
        con.commit();
        con.close();
        
        return true;
    }
    public boolean eliminar() throws Exception{
        String sql = "DELETE FROM public.proveedor WHERE ruc_proveedor=?;";
        
        Connection con = this.abrirConexion();
        con.setAutoCommit(false);
        
        PreparedStatement sp = con.prepareStatement(sql);
        sp.setString(1, this.getRuc_proveedor());
        this.ejecutarSQLsp(sp, con);
        
        con.commit();
        con.close();
        
        return true;
    }
    
    public ResultSet leerDatos( String ruc ) throws Exception{
        String sql = "select * from proveedor where ruc_proveedor  = ?";
        
        PreparedStatement sp = 
                this.abrirConexion().prepareStatement(sql);
        sp.setString(1, ruc);
        ResultSet resultado = this.ejecutarSQLSelectSP(sp);
        return resultado;
    }
}
