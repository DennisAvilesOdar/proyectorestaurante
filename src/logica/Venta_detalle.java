/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import accesodatos.Conexion;
import java.sql.ResultSet;

/**
 *
 * @author oscar fernando diaz
 */
public class Venta_detalle extends Conexion{
    private int codigo_articulo;
    private int numero_venta;
    private int cantidad;
    private double precio;
    private double descuento;
    private double importe;

    public int getCodigo_articulo() {
        return codigo_articulo;
    }

    public void setCodigo_articulo(int codigo_articulo) {
        this.codigo_articulo = codigo_articulo;
    }

    public int getNumero_venta() {
        return numero_venta;
    }

    public void setNumero_venta(int numero_venta) {
        this.numero_venta = numero_venta;
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

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }
        public ResultSet configurarCabecera() throws Exception {
        String sql = "select * from ("
                + "select 0 as codigo,"
                + "''::character varying(100) as articulo,"
                + "0.00::numeric(14,2)as precio,"
                + "0 as cantidad,"
                + "0.00::numeric(14,2)as descuento,"
                + "0.00::numeric(14,2)as importe"
                + ") as tabla_detalle where codigo>0";
        ResultSet resultado = this.ejecutarSQLSelect(sql);
        return resultado;
    }
public double calcularImporte(int cantidad,double precio,double descuento){
    double importe=cantidad*precio;
    double importeDescuento=(importe*descuento)/100;
    double importeNeto=importe-importeDescuento;
    return importeNeto;
}
}
