
package logica;

import accesodatos.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Configuración extends Conexion{
    
    public String obtenerValorConfiguracion(int codigo) throws Exception{
        String sql = "select * from configuracion where codigo_configuracion=?";
        PreparedStatement sentencia = this.abrirConexion().prepareStatement(sql);
        sentencia.setInt(1, codigo);
        
        ResultSet resultado = this.ejecutarSQLSelectSP(sentencia);
        if (resultado.next()) {
            return resultado.getString("Valor");
        }
        return null;
    }
    
}
