package logica;

import accesodatos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JComboBox;

/**
 *
 * @author oscar fernando diaz
 */
public class Cliente extends Conexion{
    private int codigo_cliente;
    private String apellidos;
    private String nombre;
    private String direccion;
    
            public static ArrayList<Cliente> listaCliente = 
            new ArrayList<Cliente>();


    public int getCodigo_cliente() {
        return codigo_cliente;
    }
    public void setCodigo_cliente(int codigo_cliente) {
        this.codigo_cliente = codigo_cliente;
    }
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
  
    
     
     private void cargarTabla( ) throws Exception{
        String sql = "select ((apellidos||' '||nombres)::character varying) as nombres,codigo_cliente from cliente";
        ResultSet resultado = this.ejecutarSQLSelect(sql);
        listaCliente.clear();
        while(resultado.next()){
            Cliente objS = new Cliente();
            objS.setNombre(resultado.getString("nombres") );
            objS.setCodigo_cliente(resultado.getInt("codigo_cliente") );
            listaCliente.add(objS);
        }
        
    }

    
    public void llenarCombo( JComboBox objCombo ) throws Exception{
        cargarTabla();
        objCombo.removeAllItems();
        for (int i = 0; i < listaCliente.size()-1; i++) {
            objCombo.addItem(listaCliente.get(i).getNombre());
        }
        System.out.println("tamaño de la lista"+listaCliente.size());
        System.out.println("tamaño de la lista"+listaCliente.size());
        
    }
}
