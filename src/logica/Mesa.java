package logica;

import accesodatos.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JComboBox;
import static logica.Estudiante.listaEstudiante;

/**
 *
 * @author oscar fernando diaz
 */
public class Mesa extends Conexion{
    private int codigo_mesa;
    private String descripcion;
    private String estado;
public static ArrayList<Mesa> listaMesa = 
            new ArrayList<Mesa>();
    public int getCodigo_mesa() {
        return codigo_mesa;
    }

    public void setCodigo_mesa(int codigo_mesa) {
        this.codigo_mesa = codigo_mesa;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
     private void cargarTabla( ) throws Exception{
        String sql = "select * from mesa";
        ResultSet resultado = this.ejecutarSQLSelect(sql);
        listaMesa.clear();
        while(resultado.next()){
            Mesa objS = new Mesa();
            objS.setCodigo_mesa(resultado.getInt("codigo_mesa") );
            objS.setDescripcion(resultado.getString("descripcion") );
            objS.setEstado(resultado.getString("estado") );
            listaMesa.add(objS);
        }
        
    }

    
    public void llenarCombo( JComboBox objCombo ) throws Exception{
        cargarTabla();
        objCombo.removeAllItems();
        for (int i = 0; i < listaMesa.size(); i++) {
            objCombo.addItem(listaMesa.get(i).getDescripcion());
        }
        System.out.println("tamaño de la lista mesaaa: "+listaMesa.size());
        
    }
}
