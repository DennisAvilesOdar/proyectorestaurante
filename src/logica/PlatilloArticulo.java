package logica;
import accesodatos.Conexion;
import java.sql.ResultSet;

public class PlatilloArticulo extends Conexion{
    private int codigo_platillo;
    private int codigo_articulo;
    private int cantidad;
    
    public int getCodigo_platillo() {
        return codigo_platillo;
    }

    public void setCodigo_platillo(int codigo_platillo) {
        this.codigo_platillo = codigo_platillo;
    }

    public int getCodigo_articulo() {
        return codigo_articulo;
    }

    public void setCodigo_articulo(int codigo_articulo) {
        this.codigo_articulo = codigo_articulo;
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
                    "		''::character varying(100) as articulo, " +
                    "		0 as cantidad"
                    + ") as tabla_detalle_articulo where codigo > 0 ";
        
        ResultSet resultado = this.ejecutarSQLSelect(sql);
        return resultado;
        
    }
    
    public double calcularCostoArticulos( int cantidad, double precio){
        double costo=cantidad*precio;
        return costo;
    }
}
