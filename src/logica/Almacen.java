package logica;
import accesodatos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JComboBox;

public class Almacen extends Conexion{
    private int codigo_almacen;
    private String nombre;
    private String direccion;
    private int codigo_sucursal;
    
    public static ArrayList<Almacen> listaAlmacenes = new ArrayList<Almacen>();
    
    public int getCodigo_almacen() {
        return codigo_almacen;
    }

    public void setCodigo_almacen(int codigo_almacen) {
        this.codigo_almacen = codigo_almacen;
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
    
    public int getCodigo_sucursal() {
        return codigo_sucursal;
    }

    public void setCodigo_sucursal(int codigo_sucursal) {
        this.codigo_sucursal = codigo_sucursal;
    }
    
    //CARGAR COMBOBOX
    private void cargarTabla() throws Exception{
        String sql = "select * from almacen order by 2";
        ResultSet resultado = this.ejecutarSQLSelect(sql);
        listaAlmacenes.clear();
        while(resultado.next()){
            Almacen objA = new Almacen();
            objA.setCodigo_almacen(resultado.getInt("codigo_almacen"));
            objA.setNombre(resultado.getString("nombre"));
            objA.setDireccion(resultado.getString("direccion"));
            objA.setCodigo_sucursal(resultado.getInt("codigo_sucursal"));
            
            listaAlmacenes.add(objA);
        }
    }
    
    public void llenarCombo( JComboBox objCombo ) throws Exception{
        this.cargarTabla();
        objCombo.removeAllItems();
        for (int i = 0; i < listaAlmacenes.size(); i++) {
            objCombo.addItem( listaAlmacenes.get(i).getNombre());
        }
    }
}