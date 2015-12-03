package logica;
import accesodatos.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import logica.CompraDetalleProducto;
import util.Funciones;

public class Compra extends Conexion{
    private String rucProveedor;
    private int codigoTipoComprobante;
    private int numeroSerie;
    private int numeroDocumento;
    private java.sql.Date fechaCompra;
    private double porcentajeIGV;
    private double subTotal;
    private double igv;
    private double total;
    private int cantDiasVencimiento;
    private int idUsuario;
    private java.sql.Date fechaRegistro;
    private java.sql.Timestamp horaRegistro;
    private java.sql.Date fechaVencimiento;
    private String estado;
    
    private ArrayList<CompraDetalleProducto> detalleCompraProducto;

    public String getRucProveedor() {
        return rucProveedor;
    }

    public void setRucProveedor(String rucProveedor) {
        this.rucProveedor = rucProveedor;
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

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public double getPorcentajeIGV() {
        return porcentajeIGV;
    }

    public void setPorcentajeIGV(double porcentajeIGV) {
        this.porcentajeIGV = porcentajeIGV;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
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

    public int getCantDiasVencimiento() {
        return cantDiasVencimiento;
    }

    public void setCantDiasVencimiento(int cantDiasVencimiento) {
        this.cantDiasVencimiento = cantDiasVencimiento;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Timestamp getHoraRegistro() {
        return horaRegistro;
    }

    public void setHoraRegistro(Timestamp horaRegistro) {
        this.horaRegistro = horaRegistro;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public ArrayList<CompraDetalleProducto> getDetalleCompraInsumo() {
        return detalleCompraProducto;
    }

    public void setDetalleCompraInsumo(ArrayList<CompraDetalleProducto> detalleCompraProducto) {
        this.detalleCompraProducto = detalleCompraProducto;
    }

    
    
    public boolean agregar() throws Exception{
        String sql ="select *  from f_generar_correlativo('compra') as numero";
        ResultSet resultado = this.ejecutarSQLSelect(sql);
        if (resultado.next()) {
            int numeroSerie = resultado.getInt("numero");
            this.setNumeroSerie(numeroSerie);
            
            /*Iniciar la transacción*/
            Connection con = this.abrirConexion();
            con.setAutoCommit(false);
            
            sql = "INSERT INTO compra(\n" +
"            ruc_proveedor, codigo_tipo_comprobante, numero_serie, numero_documento, \n" +
"            fecha_compra, porcentaje_igv, sub_total, igv, total, cantidad_dias_vencimiento, \n" +
"            id_usuario, fecha_registro, hora_registro, fecha_vencimiento, \n" +
"            estado)\n" +
"    VALUES (?, ?, ?, ?, \n" +
"            ?, ?, ?, ?, ?, ?, \n" +
"            ?, ?, ?, ?, \n" +
"            ?);";
            
            
            PreparedStatement spCompraI = con.prepareStatement(sql);
            spCompraI.setString(1, this.getRucProveedor());
            spCompraI.setInt(2, this.getCodigoTipoComprobante());
            spCompraI.setInt(3, this.getNumeroSerie());
            spCompraI.setInt(4, this.getNumeroDocumento());
            spCompraI.setDate(5, this.getFechaCompra());
            spCompraI.setDouble(6, this.getPorcentajeIGV());
            spCompraI.setDouble(7, this.getSubTotal());
            spCompraI.setDouble(8, this.getIgv());
            spCompraI.setDouble(9, this.getTotal());
            spCompraI.setInt(10, this.getCantDiasVencimiento());
            spCompraI.setInt(11, this.getIdUsuario());
            spCompraI.setDate(12, this.getFechaRegistro());
            spCompraI.setTimestamp(13, this.getHoraRegistro());
            spCompraI.setDate(14, this.getFechaRegistro());
            spCompraI.setString(15, this.getEstado());
            this.ejecutarSQLsp(spCompraI, con);
            
            for (int i = 0; i < detalleCompraProducto.size(); i++) {

                sql = "INSERT INTO compra_detalle_insumo(\n" +
"            codigo_insumo, codigo_tipo_comprobante, numero_serie, numero_documento, \n" +
"            cantidad, precio, descuento, ruc_proveedor, item)\n" +
"    VALUES (?, ?, ?, ?, \n" +
"            ?, ?, ?, ?, ?);";
                PreparedStatement spDetalleCompraI = con.prepareStatement(sql);
                spDetalleCompraI.setInt(1, detalleCompraProducto.get(i).getCodigoProducto());
                spDetalleCompraI.setInt(2, this.getCodigoTipoComprobante());
                spDetalleCompraI.setInt(3, this.getNumeroSerie());
                spDetalleCompraI.setInt(3, this.getNumeroDocumento());
                spDetalleCompraI.setInt(5, detalleCompraProducto.get(i).getCantidad());
                spDetalleCompraI.setDouble(6, detalleCompraProducto.get(i).getPrecio());
                spDetalleCompraI.setDouble(7, detalleCompraProducto.get(i).getDescuento());
                spDetalleCompraI.setString(8, this.getRucProveedor());
                spDetalleCompraI.setInt(9, i+1);
                this.ejecutarSQLsp(spDetalleCompraI, con);
                
                sql = "select codigo_insumo from almacen_insumo where codigo_insumo = ?";
                PreparedStatement spConsultarStock = this.abrirConexion().prepareStatement(sql);
                spConsultarStock.setInt(1, detalleCompraProducto.get(i).getCodigoProducto());
                ResultSet rsConsultarStock = this.ejecutarSQLSelectSP(spConsultarStock);
                
                if (rsConsultarStock.next()) {
                    //la consulta a devuelto registros significa que debo actualizar
                    sql = "update almacen_insumo set stock_insumo = stock_insumo + ? where codigo_insumo = ?";
                    
                    PreparedStatement spActStock = con.prepareStatement(sql);
                    spActStock.setInt(1, detalleCompraProducto.get(i).getCantidad());
                    spActStock.setInt(2, detalleCompraProducto.get(i).getCodigoProducto());
                    
                    this.ejecutarSQLsp(spActStock, con);
                }
                else {
                    //De lo contrario la consulta no ha devuelto articulos significa que debo insertar en la tabla stock_sucursal
                    sql = "INSERT INTO almacen_insumo(\n" +
"            codigo_almacen, codigo_insumo, stock_insumo)\n" +
"    VALUES (?, ?, ?);";
                    PreparedStatement spInsStock = con.prepareStatement(sql);
                    spInsStock.setInt(1, detalleCompraProducto.get(i).getCodigoAlmacen());
                    spInsStock.setInt(2, detalleCompraProducto.get(i).getCodigoProducto());
                    spInsStock.setInt(3, detalleCompraProducto.get(i).getCantidad());
                    this.ejecutarSQLsp(spInsStock, con);
                }
                
            }
            //recordar: por default aparece una varible *TENER CUIDADO! RECORDAR CAMBIARLO! (preparestatement)
            sql = "update correlativo set numero = numero + 1 where tabla = 'compra'";
            PreparedStatement spActCor = con.prepareStatement(sql);
            this.ejecutarSQLsp(spActCor, con);
            
            con.commit();
            con.close();
            
            /*Finalizar la transacción*/
            
        } else{
            throw new Exception("No se ha configurado el correlativo de compra");
        }
        
        //por borrar
        return true;
        //por borrar
    }
    
    public ResultSet listar(java.sql.Date fecha1, java.sql.Date fecha2, int tipo) throws Exception{
        String sql = "select * from f_listado_compra(?,?,?)";
        PreparedStatement sentencia = this.abrirConexion().prepareStatement(sql);
        sentencia.setDate(1, fecha1);
        sentencia.setDate(2, fecha2);
        sentencia.setInt(3, tipo);
        ResultSet resultado = this.ejecutarSQLSelectSP(sentencia);
        return resultado;
    }
    
    public boolean anular(int codi, int tc, int ns, int nd, int rucp, int item) throws Exception{
        String sql = "select estado from compra where codigo_tipo_comprobante=? and numero_serie=? and numero_documento=? and ruc_proveedor=?";
        PreparedStatement spValidarAnulado = this.abrirConexion().prepareStatement(sql);
        spValidarAnulado.setInt(1, tc);
        spValidarAnulado.setInt(2, ns);
        spValidarAnulado.setInt(3, nd);
        spValidarAnulado.setInt(4, rucp);
        ResultSet rsValidar = this.ejecutarSQLSelectSP(spValidarAnulado);
        if (rsValidar.next()) {
            if (rsValidar.getString("estado").equalsIgnoreCase("A")) {
                throw new Exception("La compra que esta intentando anular ya está anulada");
            }
        }
        
        String sqls = "select codigo_insumo, cantidad from compra_detalle_insumo where codigo_insumo=? and codigo_tipo_comprobante=? and numero_serie=? and numero_documento=? and ruc_proveedor=? and item=? ";
        PreparedStatement sentencia = this.abrirConexion().prepareStatement(sql);
        sentencia.setInt(1, codi);
        sentencia.setInt(2, tc);
        sentencia.setInt(3, ns);
        sentencia.setInt(5, nd);
        sentencia.setInt(6, rucp);
        sentencia.setInt(7, item);
        ResultSet resultado = this.ejecutarSQLSelectSP(sentencia);
        
        Connection transaccion = this.abrirConexion();
        transaccion.setAutoCommit(false);
        
        while (resultado.next()) {
            sql = "update almacen_insumo set stock_insumo = stock_insumo - ? where codigo_insumo = ?";
            PreparedStatement spRevertirStock = transaccion.prepareStatement(sql);
            spRevertirStock.setInt(1, resultado.getInt("cantidad"));
            spRevertirStock.setInt(2, resultado.getInt("codigo_insumo"));;
            this.ejecutarSQLsp(spRevertirStock, transaccion);
        }
        
        //Para cambiar le estado!!!!!!
        sql = "update compra set estado = 'A' where codigo_tipo_comprobante=? and numero_serie=? and numero_documento=? and ruc_proveedor=?";
        PreparedStatement spAnularCompra = transaccion.prepareStatement(sql);
        spAnularCompra.setInt(1, tc);
        spAnularCompra.setInt(2, ns);
        spAnularCompra.setInt(3, nd);
        spAnularCompra.setInt(4, rucp);
        this.ejecutarSQLsp(spAnularCompra, transaccion);
        
        transaccion.commit();
        transaccion.close();
        
        return  true;
    }
    
}