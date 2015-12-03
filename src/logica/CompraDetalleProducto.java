package logica;
import accesodatos.Conexion;
import java.sql.ResultSet;

public class CompraDetalleProducto extends Conexion{
    private int codigoProducto;
    private int codigoTipoComprobante;
    private int numeroSerie;
    private int numeroDocumento;
    private int cantidad;
    private double precio;
    private double descuento;
    private int rucProveedor;
    private int item;
    private int codigoAlmacen;

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public int getCodigoTipoComprobante() {
        return codigoTipoComprobante;
    }

    public void setCodigoTipoComprobante(int codigoTipoComprobante) {
        this.codigoTipoComprobante = codigoTipoComprobante;
    }

    public int getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(int numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public int getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(int numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
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

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public int getRucProveedor() {
        return rucProveedor;
    }

    public void setRucProveedor(int rucProveedor) {
        this.rucProveedor = rucProveedor;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public int getCodigoAlmacen() {
        return codigoAlmacen;
    }

    public void setCodigoAlmacen(int codigoAlmacen) {
        this.codigoAlmacen = codigoAlmacen;
    }
    
    public ResultSet configurarCabeceraDetalle() throws Exception{
        String sql = "select * from" +
                    "(" +
                    "	select " +
                    "		0 as codigo," +
                    "		''::character varying(100) as producto," +
                    "		0 as cantidad," +
                    "		0.00:: numeric(14,2) as precio," +
                    "		0.00:: numeric(14,2) as descuento" +
                    "		" +
                    ") as tabla_detalle where codigo > 0";
        
        ResultSet resultado = this.ejecutarSQLSelect(sql);
        return resultado;
    }
    
}
