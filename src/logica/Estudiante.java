package logica;

import accesodatos.Conexion;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;
import javax.swing.JComboBox;

/**
 *
 * @author oscar fernando diaz
 */
public class Estudiante extends Conexion{
    private int codigo_estudiante;
    private String nombre;
    private String dni;
    private String sexo;
    private Date fecha_nac;
    private String direccion;
    private String telefono;
    private String tiene_beca;
    private int codigo_pais;
    private int codigo_usuario;
    private double precio_credito;
            public static ArrayList<Estudiante> listaEstudiante = 
            new ArrayList<Estudiante>();
    public int getCodigo_pais() {
        return codigo_estudiante;
    }
    public void setCodigo_pais(int codigo_pais) {
        this.codigo_estudiante = codigo_pais;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo_estudiante() {
        return codigo_estudiante;
    }

    public void setCodigo_estudiante(int codigo_estudiante) {
        this.codigo_estudiante = codigo_estudiante;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(Date fecha_nac) {
        this.fecha_nac = fecha_nac;
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

    public String getTiene_beca() {
        return tiene_beca;
    }

    public void setTiene_beca(String tiene_beca) {
        this.tiene_beca = tiene_beca;
    }

    public int getCodigo_usuario() {
        return codigo_usuario;
    }

    public void setCodigo_usuario(int codigo_usuario) {
        this.codigo_usuario = codigo_usuario;
    }

    public double getPrecio_credito() {
        return precio_credito;
    }

    public void setPrecio_credito(double precio_credito) {
        this.precio_credito = precio_credito;
    }

     private void cargarTabla( ) throws Exception{
        String sql = "select * from estudiante ";
        ResultSet resultado = this.ejecutarSQLSelect(sql);
        listaEstudiante.clear();
        while(resultado.next()){
            Estudiante objS = new Estudiante();
            objS.setCodigo_estudiante(resultado.getInt("codigo") );
            objS.setNombre(resultado.getString("apellidos_nombres") );
            objS.setDni(resultado.getString("dni") );
            objS.setSexo(resultado.getString("sexo"));
            objS.setFecha_nac(resultado.getDate("fecha_nacimiento"));
            objS.setDireccion(resultado.getString("direccion"));
            objS.setTelefono(resultado.getString("telefono"));
            objS.setTiene_beca(resultado.getString("tiene_beca"));
            objS.setCodigo_pais(resultado.getInt("codigo_pais"));
            objS.setCodigo_usuario(resultado.getInt("codigo_usuario"));
            objS.setPrecio_credito(resultado.getDouble("precio_credito"));
            listaEstudiante.add(objS);
        }
        
    }
    
    public void llenarCombo( JComboBox objCombo ) throws Exception{
        cargarTabla();
        objCombo.removeAllItems();
        for (int i = 0; i < listaEstudiante.size(); i++) {
            objCombo.addItem(listaEstudiante.get(i).getNombre());
        }
        System.out.println("combo");
        
    }
}
