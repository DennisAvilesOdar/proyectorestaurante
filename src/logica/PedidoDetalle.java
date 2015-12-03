package logica;

import accesodatos.Conexion;
import java.sql.ResultSet;

/**
 *
 * @author oscar fernando diaz
 */
public class PedidoDetalle extends Conexion {

    private int nro_comanda;
    private int codigo_producto;
    private int item;
    private int cantidad;
    private double precio;
    private double importe;

    public int getNro_comanda() {
        return nro_comanda;
    }

    public void setNro_comanda(int nro_comanda) {
        this.nro_comanda = nro_comanda;
    }

    public int getCodigo_producto() {
        return codigo_producto;
    }

    public void setCodigo_producto(int codigo_producto) {
        this.codigo_producto = codigo_producto;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public ResultSet configurarCabecera() throws Exception {
        String sql = "select * from ("
                + "select 0 as codigo,"
                + "''::character varying(100) as producto,"
                + "0 as cantidad,"
                + "0.00::numeric(14,2)as precio,"
                + "0.00::numeric(14,2)as importe"
                + ") as tabla_detalle where codigo>0";
        ResultSet resultado = this.ejecutarSQLSelect(sql);
        return resultado;
    }

    public double calcularImporte(int cantidad, double precio) {
        double importe = cantidad * precio;

        return importe;
    }
}
