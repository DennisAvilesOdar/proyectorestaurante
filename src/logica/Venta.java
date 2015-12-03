package logica;

import accesodatos.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author oscar fernando diaz
 */
public class Venta extends Conexion {

    private int numero_venta;
    private int codigo_tipo_comprobante;
    private int numero_serie;
    private int numero_documento;
    private Date fecha_venta;
    private double porcentaje_igv;
    private double sub_total;
    private double igv;
    private double total;
    private String estado;
    private int codigo_usuario;
    private int codigo_sucursal;
    private int codigo_cliente;
    private String modalidad;
    private Date fecha_vencimiento;
    private int dias_vencimiento;

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCodigo_cliente() {
        return codigo_cliente;
    }

    public void setCodigo_cliente(int codigo_cliente) {
        this.codigo_cliente = codigo_cliente;
    }
    

    private ArrayList<Venta_detalle> detalleVentaArticulo;

    public ArrayList<Venta_detalle> getDetalleVentaArticulo() {
        return detalleVentaArticulo;
    }

    public void setDetalleVentaArticulo(ArrayList<Venta_detalle> detalleVentaArticulo) {
        this.detalleVentaArticulo = detalleVentaArticulo;
    }

    public int getNumero_venta() {
        return numero_venta;
    }

    public void setNumero_venta(int numero_venta) {
        this.numero_venta = numero_venta;
    }

    public int getCodigo_tipo_comprobante() {
        return codigo_tipo_comprobante;
    }

    public void setCodigo_tipo_comprobante(int codigo_tipo_comprobante) {
        this.codigo_tipo_comprobante = codigo_tipo_comprobante;
    }

    public int getNumero_serie() {
        return numero_serie;
    }

    public void setNumero_serie(int numero_serie) {
        this.numero_serie = numero_serie;
    }

    public int getNumero_documento() {
        return numero_documento;
    }

    public void setNumero_documento(int numero_documento) {
        this.numero_documento = numero_documento;
    }

    public Date getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(Date fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public double getPorcentaje_igv() {
        return porcentaje_igv;
    }

    public void setPorcentaje_igv(double porcentaje_igv) {
        this.porcentaje_igv = porcentaje_igv;
    }

    public double getSub_total() {
        return sub_total;
    }

    public void setSub_total(double sub_total) {
        this.sub_total = sub_total;
    }

    public double getIgv() {
        return igv;
    }

    public void setIgv(double igv) {
        this.igv = igv;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getCodigo_usuario() {
        return codigo_usuario;
    }

    public void setCodigo_usuario(int codigo_usuario) {
        this.codigo_usuario = codigo_usuario;
    }

    public int getCodigo_sucursal() {
        return codigo_sucursal;
    }

    public void setCodigo_sucursal(int codigo_sucursal) {
        this.codigo_sucursal = codigo_sucursal;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public Date getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(Date fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public int getDias_vencimiento() {
        return dias_vencimiento;
    }

    public void setDias_vencimiento(int dias_vencimiento) {
        this.dias_vencimiento = dias_vencimiento;
    }

    public ResultSet listarFiltro(java.sql.Date fecha1, java.sql.Date fecha2, int tipoModalidad, int codigoCliente, int codigo_Sucursal) throws Exception {
        String sql = "select * from f_listado_venta(?,?,?,?,?);";
        PreparedStatement sp = this.abrirConexion().prepareStatement(sql);
        sp.setDate(1, fecha1);
        sp.setDate(2, fecha2);
        sp.setInt(3, tipoModalidad);
        sp.setInt(4, codigoCliente);
        sp.setInt(5, codigo_Sucursal);
        ResultSet rs = this.ejecutarSQLSelectSP(sp);
        //this.ejecutarSQLSelect(sql);
        return rs;
    }

    public boolean agregar() throws Exception {
        String sql = "select * from f_generar_correlativo('venta') as numero";
        ResultSet res = this.ejecutarSQLSelect(sql);
        if (res.next()) {
            int nroVenta = res.getInt("numero");
            this.setNumero_venta(nroVenta);

            Connection con = this.abrirConexion();
            con.setAutoCommit(false);
            sql = "INSERT INTO venta(numero_venta, "
                    + "codigo_tipo_comprobante, "
                    + "numero_serie, "
                    + "numero_documento,"
                    + "codigo_cliente, "
                    + "fecha_venta, "
                    + "porcentaje_igv, "
                    + "sub_total, "
                    + "igv,"
                    + "total, "
                    + "codigo_usuario, "
                    + "estado,"
                    + "codigo_sucursal, "
                    + "modalidad, "
                    + "fecha_vencimiento, "
                    + "dias_vencimiento)"
                    + "VALUES (?, ?, ?, ?,?, ?,?,?, ?, ?, ?, ?,?, ?, ?, ?);";
            PreparedStatement spVenta = con.prepareStatement(sql);
            spVenta.setInt(1, this.getNumero_venta());
            spVenta.setInt(2, this.getCodigo_tipo_comprobante());
            spVenta.setInt(3, this.getNumero_serie());
            spVenta.setInt(4, this.getNumero_documento());
            spVenta.setInt(5, this.getCodigo_cliente());
            spVenta.setDate(6, this.getFecha_venta());
            spVenta.setDouble(7, this.getPorcentaje_igv());
            spVenta.setDouble(8, this.getSub_total());
            spVenta.setDouble(9, this.getIgv());
            spVenta.setDouble(10, this.getTotal());
            spVenta.setInt(11, this.getCodigo_usuario());
            spVenta.setString(12, this.getEstado());
            spVenta.setInt(13, this.getCodigo_sucursal());
            spVenta.setString(14, this.getModalidad());
            spVenta.setDate(15, this.getFecha_vencimiento());
            spVenta.setInt(16, this.getDias_vencimiento());
            this.ejecutarSQLsp(spVenta, con);

            for (int i = 0; i < detalleVentaArticulo.size(); i++) {
                System.out.println("cod articulo:" + detalleVentaArticulo.get(i).getCodigo_articulo());
                System.out.println("cantidad:" + detalleVentaArticulo.get(i).getCantidad());
                System.out.println("precio:" + detalleVentaArticulo.get(i).getPrecio());
                sql="INSERT INTO venta_detalle(codigo_articulo, numero_venta, cantidad, precio, descuento, importe)"
                        + "VALUES (?, ?, ?, ?, ?, ?);";
                PreparedStatement spDatailBuy = con.prepareStatement(sql);
                spDatailBuy.setInt(1, detalleVentaArticulo.get(i).getCodigo_articulo());
                spDatailBuy.setInt(2, this.getNumero_venta());
                spDatailBuy.setInt(3, detalleVentaArticulo.get(i).getCantidad());
                spDatailBuy.setDouble(4, detalleVentaArticulo.get(i).getPrecio());
                spDatailBuy.setDouble(5, detalleVentaArticulo.get(i).getDescuento());
                spDatailBuy.setDouble(6, detalleVentaArticulo.get(i).getImporte());

                this.ejecutarSQLsp(spDatailBuy, con);
                sql = "select codigo_articulo from stock_sucursal where codigo_articulo=? and codigo_sucursal=?";
                PreparedStatement spConsultarStock = this.abrirConexion().prepareStatement(sql);
                spConsultarStock.setInt(1, detalleVentaArticulo.get(i).getCodigo_articulo());
                spConsultarStock.setInt(2, this.getCodigo_sucursal());
                ResultSet rsConsultarStock = this.ejecutarSQLSelectSP(spConsultarStock);
                if (rsConsultarStock.next()) {
                    //si la consulta a devuelto registros
                    //significa actualisar
                    sql = "update stock_sucursal set stock=stock-? where codigo_articulo=? and codigo_sucursal=?";
                    PreparedStatement spActuaStock = con.prepareStatement(sql);
                    spActuaStock.setInt(1, detalleVentaArticulo.get(i).getCantidad());
                    spActuaStock.setInt(2, detalleVentaArticulo.get(i).getCodigo_articulo());
                    spActuaStock.setInt(3, this.getCodigo_sucursal());
                    this.ejecutarSQLsp(spActuaStock, con);
                } else {
                    //de lo contrario INSERTAR
                    sql = "insert into stock_sucursal(codigo_articulo,codigo_sucursal,stock)values(?,?,?)";
                    PreparedStatement spInsertStock = this.abrirConexion().prepareStatement(sql);
                    spInsertStock.setInt(1, detalleVentaArticulo.get(i).getCodigo_articulo());
                    spInsertStock.setInt(2, this.getCodigo_sucursal());
                    spInsertStock.setInt(3, detalleVentaArticulo.get(i).getCantidad());
                    ejecutarSQLsp(spInsertStock, con);

                }
            }
            sql = "update correlativo set numero=numero+1 where tabla='venta'";
            PreparedStatement spActCorr = con.prepareStatement(sql);
            this.ejecutarSQLsp(spActCorr, con);

            con.commit();
            con.close();

        } else {
            throw new Exception("no se ha congigurado el correlativo para la tabla compra");
        }
        return true;
    }

    public boolean anular(int numero_venta, int codigo_sucursal) throws Exception {
        String sql = "select estado from venta where numero_venta=?";
        PreparedStatement spValidarEstado = this.abrirConexion().prepareStatement(sql);
        spValidarEstado.setInt(1, numero_venta);
        ResultSet rsValidar = this.ejecutarSQLSelectSP(spValidarEstado);
        if (rsValidar.next()) {
            if (rsValidar.getString("estado").equalsIgnoreCase("A")) {
                throw new Exception("la compra que esta intentando ");
            }
        }
        sql = "select codigo_articulo,cantidad from venta_detalle where numero_venta=?";
        PreparedStatement sp = this.abrirConexion().prepareStatement(sql);
        sp.setInt(1, numero_venta);
        ResultSet rs = this.ejecutarSQLSelectSP(sp);

        Connection transaccion = this.abrirConexion();
        transaccion.setAutoCommit(false);
        while (rs.next()) {
            sql = "update stock_sucursal set stock=stock+? where codigo_articulo=? and codigo_sucursal=?";
            PreparedStatement spRevertirStock = transaccion.prepareStatement(sql);
            spRevertirStock.setInt(1, rs.getInt("cantidad"));
            spRevertirStock.setInt(2, rs.getInt("codigo_articulo"));
            spRevertirStock.setInt(3, codigo_sucursal);
            this.ejecutarSQLsp(spRevertirStock, transaccion);
        }
        sql = "update venta set estado='A' where numero_venta=?";
        PreparedStatement spAnular = transaccion.prepareStatement(sql);
        spAnular.setInt(1, numero_venta);
        this.ejecutarSQLsp(spAnular, transaccion);
        transaccion.commit();
        transaccion.close();
        return true;
    }
}
