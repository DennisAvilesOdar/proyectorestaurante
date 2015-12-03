package logica;
import accesodatos.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Pedido extends Conexion {

    private int nro_comanda;
    private java.sql.Date fecha;
    private int codigo_cliente;
    private int codigo_mesa;
    private String estado;
    private double total;
private ArrayList<PedidoDetalle> detalleComandaProducto;
    public int getNro_comanda() {
        return nro_comanda;
    }

    public void setNro_comanda(int nro_comanda) {
        this.nro_comanda = nro_comanda;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCodigo_cliente() {
        return codigo_cliente;
    }

    public void setCodigo_cliente(int codigo_cliente) {
        this.codigo_cliente = codigo_cliente;
    }

    public int getCodigo_mesa() {
        return codigo_mesa;
    }

    public void setCodigo_mesa(int codigo_mesa) {
        this.codigo_mesa = codigo_mesa;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public ArrayList<PedidoDetalle> getDetalleComandaProducto() {
        return detalleComandaProducto;
    }

    public void setDetalleComandaProducto(ArrayList<PedidoDetalle> detalleComandaProducto) {
        this.detalleComandaProducto = detalleComandaProducto;
    }
     public boolean agregar()throws Exception{
        String sql="select * from f_generar_correlativo('comanda') as numero";
        ResultSet res=this.ejecutarSQLSelect(sql);
        if (res.next()) {
            int nroCompra=res.getInt("numero");
            this.setNro_comanda(nroCompra);
            
            Connection con=this.abrirConexion();
            con.setAutoCommit(false);
            sql="INSERT INTO comanda(nro_comanda, fecha, codigo_cliente, codigo_mesa, estado, total)VALUES (?, ?, ?, ?, ?, ?);";
            PreparedStatement spComanda=con.prepareStatement(sql);
            spComanda.setInt(1, this.getNro_comanda());
            spComanda.setDate(2, this.getFecha());
            spComanda.setInt(3, this.getCodigo_cliente());
            spComanda.setInt(4, this.getCodigo_mesa());
            spComanda.setString(5, "E");
            spComanda.setDouble(6, this.getTotal());
            this.ejecutarSQLsp(spComanda, con);
            
            for (int i = 0; i < detalleComandaProducto.size(); i++) {
//                System.out.println("cod producto:"+detalleComandaProducto.get(i).getCodigoArticulo());
//                System.out.println("cantidad:"+detalleComandaProducto.get(i).getCantidad());
//                System.out.println("precio:"+detalleComandaProducto.get(i).getPrecio());
                sql="INSERT INTO comanda_detalle(nro_comanda, codigo_producto, item, cantidad, precio, importe)VALUES (?, ?, ?, ?, ?, ?);";
                PreparedStatement spDatailBuy=con.prepareStatement(sql);
                spDatailBuy.setInt(1, this.getNro_comanda());
                spDatailBuy.setInt(2, detalleComandaProducto.get(i).getCodigo_producto());
                spDatailBuy.setInt(3, detalleComandaProducto.get(i).getItem());
                spDatailBuy.setInt(4, detalleComandaProducto.get(i).getCantidad());
                spDatailBuy.setDouble(5, detalleComandaProducto.get(i).getPrecio());
                spDatailBuy.setDouble(6, detalleComandaProducto.get(i).getImporte());
                
                this.ejecutarSQLsp(spDatailBuy, con);
                sql="select codigo_producto from producto where codigo_producto=? ";
                PreparedStatement spConsultarStock=this.abrirConexion().prepareStatement(sql);
                spConsultarStock.setInt(1, detalleComandaProducto.get(i).getCodigo_producto());
                ResultSet rsConsultarStock=this.ejecutarSQLSelectSP(spConsultarStock);
                if (rsConsultarStock.next()) {
                    //si la consulta a devuelto registros
                    //significa actualisar
                    sql="update producto set stock=stock-? where codigo_producto=? ";
                    System.out.println( detalleComandaProducto.get(i).getCantidad());
                    PreparedStatement spActuaStock=con.prepareStatement(sql);
                    spActuaStock.setInt(1, detalleComandaProducto.get(i).getCantidad());
                    spActuaStock.setInt(2, detalleComandaProducto.get(i).getCodigo_producto());
                    this.ejecutarSQLsp(spActuaStock, con);
                }
            }
            sql="update correlativo set numero=numero+1 where tabla='comanda'";
            PreparedStatement spActCorr=con.prepareStatement(sql);
            this.ejecutarSQLsp(spActCorr, con);
            
            con.commit();
            con.close();
            
        }else{
            throw new Exception("no se ha congigurado el correlativo para la tabla compra");
        }
        return true;
    }

    public ResultSet listarFiltro(java.sql.Date fecha1, java.sql.Date fecha2, int tipo) throws Exception {
        String sql = "select * from f_listar_comandas(?,?,?);";
        PreparedStatement sp = this.abrirConexion().prepareStatement(sql);
        sp.setDate(1, fecha1);
        sp.setDate(2, fecha2);
        sp.setInt(3, tipo);
        ResultSet rs = this.ejecutarSQLSelectSP(sp);
        //this.ejecutarSQLSelect(sql);
        return rs;
    }

    public boolean anular(int numero_comanda) throws Exception {
        String sql = "select estado from comanda where nro_comanda=?";
        PreparedStatement spValidarEstado = this.abrirConexion().prepareStatement(sql);
        spValidarEstado.setInt(1, numero_comanda);
        ResultSet rsValidar = this.ejecutarSQLSelectSP(spValidarEstado);
        System.out.println("1");
        if (rsValidar.next()) {
            if (rsValidar.getString("estado").equalsIgnoreCase("A")) {
                throw new Exception("la compra que esta intentando anular ya lo a sido anulada ");
            }
        }
        sql = "select codigo_producto,cantidad from comanda_detalle where nro_comanda=?";
        PreparedStatement sp = this.abrirConexion().prepareStatement(sql);
        sp.setInt(1, numero_comanda);
        ResultSet rs = this.ejecutarSQLSelectSP(sp);
        System.out.println("2");
        Connection transaccion = this.abrirConexion();
        transaccion.setAutoCommit(false);
        while (rs.next()) {
            sql = "update producto set stock=stock+? where codigo_producto=?";
            PreparedStatement spRevertirStock = transaccion.prepareStatement(sql);
            spRevertirStock.setInt(1, rs.getInt("cantidad"));
            spRevertirStock.setInt(2, rs.getInt("codigo_producto"));
            this.ejecutarSQLsp(spRevertirStock, transaccion);
        }
        System.out.println("3");
        sql = "update comanda set estado='A' where nro_comanda=?";
        PreparedStatement spAnular = transaccion.prepareStatement(sql);
        spAnular.setInt(1, numero_comanda);
        this.ejecutarSQLsp(spAnular, transaccion);
        System.out.println("4");
        transaccion.commit();
        transaccion.close();
        return true;
    }
}
