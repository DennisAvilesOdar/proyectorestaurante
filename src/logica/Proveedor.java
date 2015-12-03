package logica;

import accesodatos.Conexion;
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
}
