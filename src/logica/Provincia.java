package logica;
import accesodatos.Conexion;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JComboBox;

public class Provincia extends Conexion{
    private int codigo_provincia;
    private String nombre;
    private int codigo_departamento;

    public int getCodigo_provincia() {
        return codigo_provincia;
    }

    public void setCodigo_provincia(int codigo_provincia) {
        this.codigo_provincia = codigo_provincia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo_departamento() {
        return codigo_departamento;
    }

    public void setCodigo_departamento(int codigo_departamento) {
        this.codigo_departamento = codigo_departamento;
    }
    
    public static ArrayList<Provincia> listaProvincias = new ArrayList<Provincia>();
    
    private void cargarTabla( int codigoDepartamento ) throws Exception{
        String sql = "select * from provincia where codigo_departamento = " + codigoDepartamento + " order by nombre";
        ResultSet resultado = this.ejecutarSQLSelect(sql);
        listaProvincias.clear();
        while(resultado.next()){
            Provincia objProvincia = new Provincia();
            objProvincia.setCodigo_provincia(resultado.getInt("codigo_provincia") );
            objProvincia.setNombre(resultado.getString("nombre") );
            listaProvincias.add(objProvincia);
        }    
    }
    
    public void llenarCombo( JComboBox objCombo, int codigoDepartamento ) throws Exception{
        this.cargarTabla(codigoDepartamento);
        objCombo.removeAllItems();
        for (int i = 0; i < listaProvincias.size(); i++) {
            objCombo.addItem( listaProvincias.get(i).getNombre());
        }
    }
}
