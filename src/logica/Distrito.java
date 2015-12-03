package logica;
import accesodatos.Conexion;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JComboBox;

public class Distrito extends Conexion{
    private int codigo_distrito;
    private int codigo_provincia;
    private int codigo_departamento;
    private String nombre;

    public int getCodigo_distrito() {
        return codigo_distrito;
    }

    public void setCodigo_distrito(int codigo_distrito) {
        this.codigo_distrito = codigo_distrito;
    }

    public int getCodigo_provincia() {
        return codigo_provincia;
    }

    public void setCodigo_provincia(int codigo_provincia) {
        this.codigo_provincia = codigo_provincia;
    }

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
    
    public static ArrayList<Distrito> listaDistritos = new ArrayList<Distrito>();
    
    private void cargarTabla( int codigoProvincia ) throws Exception{
        String sql = "select * from distrito where codigo_provincia = " + codigoProvincia + " order by nombre";
        ResultSet resultado = this.ejecutarSQLSelect(sql);
        listaDistritos.clear();
        while(resultado.next()){
            Distrito objDistrito = new Distrito();
            objDistrito.setCodigo_distrito(resultado.getInt("codigo_distrito") );
            objDistrito.setCodigo_provincia(resultado.getInt("codigo_provincia") );
            objDistrito.setCodigo_departamento(resultado.getInt("codigo_departamento") );
            objDistrito.setNombre(resultado.getString("nombre") );
            listaDistritos.add(objDistrito);
        }    
    }
    
    public void llenarCombo( JComboBox objCombo, int codigoProvincia ) throws Exception{
        this.cargarTabla(codigoProvincia);
        objCombo.removeAllItems();
        for (int i = 0; i < listaDistritos.size(); i++) {
            objCombo.addItem( listaDistritos.get(i).getNombre());
        }
    }
}
