package logica;
import accesodatos.Conexion;
import java.sql.ResultSet;

public class PlatilloInsumo extends Conexion{
    private int codigo_platillo;
    private int codigo_insumo;
    private int cantidad;

    public int getCodigo_platillo() {
        return codigo_platillo;
    }

    public void setCodigo_platillo(int codigo_platillo) {
        this.codigo_platillo = codigo_platillo;
    }

    public int getCodigo_insumo() {
        return codigo_insumo;
    }

    public void setCodigo_insumo(int codigo_insumo) {
        this.codigo_insumo = codigo_insumo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public ResultSet configurarCabeceraDetalle() throws Exception{
        String sql = "select * from" +
                    "(" +
                    "	select " +
                    "		0 as codigo, " +
                    "		''::character varying(100) as insumo, " +
                    "		0 as cantidad"
                    + ") as tabla_detalle_insumo where codigo > 0 ";
        
        ResultSet resultado = this.ejecutarSQLSelect(sql);
        return resultado;
        
    }
    
    public double calcularCostoInsumos( int cantidad, double precio){
        double costo=cantidad*precio;
        
        return costo;
    }
}
