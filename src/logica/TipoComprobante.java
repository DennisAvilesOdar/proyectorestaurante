
package logica;

import accesodatos.Conexion;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JComboBox;

public class TipoComprobante extends Conexion{
    
    private int codigoTipoComprobante;
    private String descripcion;
    
    public static ArrayList<TipoComprobante> 
            listaTC = new ArrayList<TipoComprobante>();

    public int getCodigoTipoComprobante() {
        return codigoTipoComprobante;
    }

    public void setCodigoTipoComprobante(int codigoTipoComprobante) {
        this.codigoTipoComprobante = codigoTipoComprobante;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    private void cargarTabla() throws Exception{
        String sql = "select * from tipo_comprobante where compra = '1' order by 2";
        ResultSet resultado = this.ejecutarSQLSelect(sql);
        listaTC.clear();
        while (resultado.next()){
            TipoComprobante objTC = new TipoComprobante();
            objTC.setCodigoTipoComprobante(resultado.getInt("codigo_tipo_comprobante"));
            objTC.setDescripcion(resultado.getString("descripcion"));
            listaTC.add(objTC);
        }
    }
    
    public void llenarCombo(JComboBox objCombo) throws Exception{
        this.cargarTabla();
        objCombo.removeAllItems();
        for (int i = 0; i < listaTC.size(); i++) {
            objCombo.addItem(listaTC.get(i).getDescripcion());
        }
    }
    
    
}
