package logica;
import accesodatos.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JComboBox;;
import java.sql.Connection;

public class Departamento extends Conexion{
    private int codigo_departamento;
    private String nombre;
    
    public static ArrayList<Departamento> listaDepartamentos = new ArrayList<Departamento>();

    public int getCodigo_departamento() {
        return codigo_departamento;
    }

    public void setCodigo_departamento(int codigo_departamento) {
        this.codigo_departamento = codigo_departamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    private void cargarTabla() throws Exception{
        String sql = "select * from departamento order by 2";
        ResultSet resultado = this.ejecutarSQLSelect(sql);
        listaDepartamentos.clear();
        while(resultado.next()){
            Departamento objD = new Departamento();
            objD.setCodigo_departamento(resultado.getInt("codigo_departamento") );
            objD.setNombre(resultado.getString("nombre") );
            listaDepartamentos.add(objD);
        }
        
    }
    
    public void llenarCombo( JComboBox objCombo ) throws Exception{
        this.cargarTabla();
        objCombo.removeAllItems();
        for (int i = 0; i < listaDepartamentos.size(); i++) {
            objCombo.addItem( listaDepartamentos.get(i).getNombre());
        }
        
    }
}
