package presentacion;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import logica.TipoComprobante;
import logica.Venta;
import logica.Venta_detalle;
import logica.Configuración;
import util.Funciones;

public class RegistrarNuevaVenta extends javax.swing.JInternalFrame {

    int accion = 0;
    public RegistrarNuevaVenta() {
        initComponents();
        this.setLocation(210, 52);
          Calendar c2 = new GregorianCalendar();
        dtFecha.setCalendar(c2);
        // llenarCombo();
//        obtenerTasaIGV();
        //cargarFechaVencimiento();
        tblVentaDetalle.setCellSelectionEnabled(true);
        tblVentaDetalle.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblVentaDetalle.setRowHeight(25);
        rdbContado.doClick();
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jPanel8 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNcompra = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNumSerie = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNumDocumento = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        rdbContado = new javax.swing.JRadioButton();
        rdbCredito = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        rdbTarjeta_debito = new javax.swing.JRadioButton();
        rdbTarjetaCredito = new javax.swing.JRadioButton();
        jPanel6 = new javax.swing.JPanel();
        rdb60dias = new javax.swing.JRadioButton();
        rdb30dias = new javax.swing.JRadioButton();
        rdb45dias = new javax.swing.JRadioButton();
        rdb15dias = new javax.swing.JRadioButton();
        jLabel14 = new javax.swing.JLabel();
        txtNroTarjeta = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        cboTipoComprobante = new javax.swing.JComboBox();
        jLabel20 = new javax.swing.JLabel();
        dtFecha = new com.toedter.calendar.JDateChooser();
        jLabel21 = new javax.swing.JLabel();
        txtIGV_porcentaje = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        dtFechaVencimiento = new com.toedter.calendar.JDateChooser();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtCodigo_cliente = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jToolBar1 = new javax.swing.JToolBar();
        btnBuscar = new javax.swing.JButton();
        txtNombres = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        /*parte 1*/
        final JTextField field = new JTextField("usat");
        final DefaultCellEditor edit = new DefaultCellEditor(field);
        field.setBorder(BorderFactory.createMatteBorder(3,3,3,3,Color.red));
        field.setForeground(Color.blue);
        /*parte 1*/
        tblVentaDetalle = new javax.swing.JTable(){
            /*parte 2*/
            public boolean isCellEditable(int fila, int columna){
                if (columna == 3 || columna == 4){
                    return true;
                }
                return false;
            }

            public TableCellEditor getCellEditor(int row, int col) {
                if (col == 2){
                    field.setDocument(new util.ValidaNumeros());
                }else{
                    field.setDocument(new util.ValidaNumeros(util.ValidaNumeros.ACEPTA_DECIMAL));
                }
                edit.setClickCountToStart(2);
                field.addFocusListener(new FocusAdapter() {
                    public void focusLost(FocusEvent e) {
                        field.select(0,0);
                    }
                });
                return edit;
            }
            /*parte 2*/};
        jToolBar2 = new javax.swing.JToolBar();
        btnAgregarArticulo = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnQuitarArticulo = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txtSubTotal = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtIGV_RES = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtNeto = new javax.swing.JTextField();
        jToolBar3 = new javax.swing.JToolBar();
        btnGrabarVenta = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btnSalir = new javax.swing.JButton();

        jPanel8.setBackground(new java.awt.Color(102, 102, 102));

        jPanel10.setBackground(new java.awt.Color(102, 102, 102));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATOS DE LA VENTA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 1, 12), new java.awt.Color(204, 204, 255))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nº Venta:");

        txtNcompra.setEditable(false);
        txtNcompra.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        txtNcompra.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nº Serie:");

        txtNumSerie.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nº Documento:");

        txtNumDocumento.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNumSerie)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(txtNumDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(txtNcompra, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(103, Short.MAX_VALUE))))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNcompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNumSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNumDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        jPanel5.setBackground(new java.awt.Color(102, 102, 102));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "MODALIDAD", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 1, 12), new java.awt.Color(204, 204, 255))); // NOI18N

        rdbContado.setBackground(new java.awt.Color(102, 102, 102));
        buttonGroup1.add(rdbContado);
        rdbContado.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        rdbContado.setForeground(new java.awt.Color(255, 255, 255));
        rdbContado.setText("Contado");
        rdbContado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rdbContadoMousePressed(evt);
            }
        });
        rdbContado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbContadoActionPerformed(evt);
            }
        });

        rdbCredito.setBackground(new java.awt.Color(102, 102, 102));
        buttonGroup1.add(rdbCredito);
        rdbCredito.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        rdbCredito.setForeground(new java.awt.Color(255, 255, 255));
        rdbCredito.setText("Crédito");
        rdbCredito.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rdbCreditoMousePressed(evt);
            }
        });
        rdbCredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbCreditoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rdbContado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rdbCredito)
                .addContainerGap(381, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbContado)
                    .addComponent(rdbCredito))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(102, 102, 102));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TIPO DE TARJETA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 1, 12), new java.awt.Color(204, 204, 255))); // NOI18N

        rdbTarjeta_debito.setBackground(new java.awt.Color(102, 102, 102));
        buttonGroup2.add(rdbTarjeta_debito);
        rdbTarjeta_debito.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        rdbTarjeta_debito.setForeground(new java.awt.Color(255, 255, 255));
        rdbTarjeta_debito.setText("Tarjeta de débito");

        rdbTarjetaCredito.setBackground(new java.awt.Color(102, 102, 102));
        buttonGroup2.add(rdbTarjetaCredito);
        rdbTarjetaCredito.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        rdbTarjetaCredito.setForeground(new java.awt.Color(255, 255, 255));
        rdbTarjetaCredito.setText("Tarjeta de crédito");
        rdbTarjetaCredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbTarjetaCreditoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rdbTarjeta_debito)
                    .addComponent(rdbTarjetaCredito))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(rdbTarjeta_debito)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rdbTarjetaCredito))
        );

        jPanel6.setBackground(new java.awt.Color(102, 102, 102));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DÍAS DE CRÉDITO A VENCER", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 1, 12), new java.awt.Color(204, 204, 255))); // NOI18N

        rdb60dias.setBackground(new java.awt.Color(102, 102, 102));
        buttonGroup3.add(rdb60dias);
        rdb60dias.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        rdb60dias.setForeground(new java.awt.Color(255, 255, 255));
        rdb60dias.setText("60 dias");
        rdb60dias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdb60diasActionPerformed(evt);
            }
        });

        rdb30dias.setBackground(new java.awt.Color(102, 102, 102));
        buttonGroup3.add(rdb30dias);
        rdb30dias.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        rdb30dias.setForeground(new java.awt.Color(255, 255, 255));
        rdb30dias.setText("30 dias");
        rdb30dias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdb30diasActionPerformed(evt);
            }
        });

        rdb45dias.setBackground(new java.awt.Color(102, 102, 102));
        buttonGroup3.add(rdb45dias);
        rdb45dias.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        rdb45dias.setForeground(new java.awt.Color(255, 255, 255));
        rdb45dias.setText("45 dias");
        rdb45dias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdb45diasActionPerformed(evt);
            }
        });

        rdb15dias.setBackground(new java.awt.Color(102, 102, 102));
        buttonGroup3.add(rdb15dias);
        rdb15dias.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        rdb15dias.setForeground(new java.awt.Color(255, 255, 255));
        rdb15dias.setText("15 dias");
        rdb15dias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdb15diasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(rdb15dias)
                        .addGap(18, 18, 18)
                        .addComponent(rdb45dias))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(rdb30dias)
                        .addGap(18, 18, 18)
                        .addComponent(rdb60dias)))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rdb45dias)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdb30dias)
                    .addComponent(rdb60dias)))
            .addComponent(rdb15dias)
        );

        jLabel14.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Número de tarjeta:");

        txtNroTarjeta.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N

        jPanel11.setBackground(new java.awt.Color(102, 102, 102));
        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATOS DE LA VENTA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 1, 12), new java.awt.Color(204, 204, 255))); // NOI18N

        jLabel17.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Tipo Comprobante:");

        cboTipoComprobante.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        cboTipoComprobante.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel20.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Fecha venta:");

        dtFecha.setDateFormatString("dd-MM-yyyy");

        jLabel21.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("IGV (%):");

        txtIGV_porcentaje.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIGV_porcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dtFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                    .addComponent(cboTipoComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(cboTipoComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(dtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addComponent(txtIGV_porcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13))
        );

        jLabel15.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Fecha de Vencimiento:");

        dtFechaVencimiento.setDateFormatString("dd-MM-yyyy");
        dtFechaVencimiento.setEnabled(false);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATOS DEL CLIENTE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 1, 12), new java.awt.Color(204, 204, 255))); // NOI18N

        jLabel7.setBackground(new java.awt.Color(204, 204, 204));
        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Codigo:");

        txtCodigo_cliente.setEditable(false);
        txtCodigo_cliente.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        txtCodigo_cliente.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setBackground(new java.awt.Color(204, 204, 204));
        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Nombre:");

        jLabel9.setBackground(new java.awt.Color(204, 204, 204));
        jLabel9.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Direccion:");

        txtDireccion.setEditable(false);
        txtDireccion.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        txtDireccion.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel10.setBackground(new java.awt.Color(204, 204, 204));
        jLabel10.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Telefono:");

        txtTelefono.setEditable(false);
        txtTelefono.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        txtTelefono.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jToolBar1.setBackground(new java.awt.Color(102, 102, 102));
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        btnBuscar.setBackground(new java.awt.Color(102, 102, 102));
        btnBuscar.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/[Boton] Buscar.png"))); // NOI18N
        btnBuscar.setToolTipText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        txtNombres.setEditable(false);
        txtNombres.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        txtNombres.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCodigo_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                        .addComponent(txtNombres)
                        .addComponent(txtTelefono)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 133, Short.MAX_VALUE)
                .addComponent(btnBuscar)
                .addGap(18, 18, 18)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtCodigo_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel8)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DETALLE DEL PEDIDO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 1, 12), new java.awt.Color(204, 204, 255))); // NOI18N

        tblVentaDetalle.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tblVentaDetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblVentaDetalle.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tblVentaDetallePropertyChange(evt);
            }
        });
        tblVentaDetalle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblVentaDetalleKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblVentaDetalle);
        /*parte 3*/
        tblVentaDetalle.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                field.setText("");
                field.requestFocus();
            }
        });

        field.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode()==10){
                    if (field.getText().isEmpty()){
                        evt.consume();
                    }
                }
            }
        });
        /*parte 3*/

        jToolBar2.setBackground(new java.awt.Color(102, 102, 102));
        jToolBar2.setFloatable(false);
        jToolBar2.setRollover(true);

        btnAgregarArticulo.setBackground(new java.awt.Color(102, 102, 102));
        btnAgregarArticulo.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        btnAgregarArticulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/[Boton] Añadir 2.png"))); // NOI18N
        btnAgregarArticulo.setToolTipText("Agregar pedido");
        btnAgregarArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarArticuloActionPerformed(evt);
            }
        });
        jToolBar2.add(btnAgregarArticulo);
        jToolBar2.add(jSeparator1);

        btnQuitarArticulo.setBackground(new java.awt.Color(102, 102, 102));
        btnQuitarArticulo.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        btnQuitarArticulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/[Boton] Quitar.png"))); // NOI18N
        btnQuitarArticulo.setToolTipText("Quitar pedido");
        btnQuitarArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarArticuloActionPerformed(evt);
            }
        });
        jToolBar2.add(btnQuitarArticulo);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel11.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("SUBTOTAL:");

        txtSubTotal.setEditable(false);
        txtSubTotal.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        txtSubTotal.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel12.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("IGV:");

        txtIGV_RES.setEditable(false);
        txtIGV_RES.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        txtIGV_RES.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel13.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("NETO:");

        txtNeto.setEditable(false);
        txtNeto.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        txtNeto.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtIGV_RES, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNeto, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSubTotal)
                        .addComponent(jLabel11))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(txtNeto)
                        .addComponent(txtIGV_RES, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel12))
                .addContainerGap())
        );

        jToolBar3.setBackground(new java.awt.Color(102, 102, 102));
        jToolBar3.setFloatable(false);
        jToolBar3.setRollover(true);

        btnGrabarVenta.setBackground(new java.awt.Color(102, 102, 102));
        btnGrabarVenta.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        btnGrabarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/[Boton] Guardar.png"))); // NOI18N
        btnGrabarVenta.setToolTipText("Grabar");
        btnGrabarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarVentaActionPerformed(evt);
            }
        });
        jToolBar3.add(btnGrabarVenta);
        jToolBar3.add(jSeparator2);

        btnSalir.setBackground(new java.awt.Color(102, 102, 102));
        btnSalir.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/[Boton] Salir.png"))); // NOI18N
        btnSalir.setToolTipText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jToolBar3.add(btnSalir);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(dtFechaVencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(txtNroTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jToolBar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNroTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dtFechaVencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jToolBar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        BuscarCliente obj = new BuscarCliente(null, true);
        obj.setVisible(true);
        if (obj.accion == 1) {
            int filaselec = obj.tblListado.getSelectedRow();
            String codigo = obj.tblListado.getValueAt(filaselec, 0).toString();
            String nombrs = obj.tblListado.getValueAt(filaselec, 1).toString();
            String dir = obj.tblListado.getValueAt(filaselec, 2).toString();
            String telf = obj.tblListado.getValueAt(filaselec, 3).toString();
            //System.out.println(codigo);
            this.txtCodigo_cliente.setText(codigo);
            this.txtDireccion.setText(dir);
            this.txtNombres.setText(nombrs);
            this.txtTelefono.setText(telf);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void rdb30diasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb30diasActionPerformed
        System.out.println(dtFecha.getDateFormatString());
        if (dtFecha.getDate()==null) {
            Funciones.mensajeError("INGRESE LA FECHA DE LA VENTA", Funciones.NOMBRE_SOFTWARE);
            rdb30dias.setSelected(false);
        } else {
            cargarFechaVencimiento();
        }
    }//GEN-LAST:event_rdb30diasActionPerformed

    private void rdb45diasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb45diasActionPerformed
        if (dtFecha.getDate()==null) {
            Funciones.mensajeError("INGRESE LA FECHA DE LA VENTA", Funciones.NOMBRE_SOFTWARE);
            rdb45dias.setSelected(false);
        } else {
            cargarFechaVencimiento();
        }
    }//GEN-LAST:event_rdb45diasActionPerformed

    private void btnGrabarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarVentaActionPerformed
        int codigoTC = TipoComprobante.listaTC.get(cboTipoComprobante.getSelectedIndex()).getCodigoTipoComprobante();
        int numeroSerie = Integer.parseInt(txtNumSerie.getText());
        int numeroDocumen = Integer.parseInt(txtNumDocumento.getText());
        int codigoCliente = Integer.parseInt(this.txtCodigo_cliente.getText());
        java.sql.Date fechaVenta = new java.sql.Date(this.dtFecha.getDate().getTime());
        double porcentajeIGV = Double.parseDouble(txtIGV_porcentaje.getText());
        double subTotal = Double.parseDouble(txtSubTotal.getText().replace(",", ""));
        double igv = Double.parseDouble(txtIGV_RES.getText().replace(",", ""));
        double neto = Double.parseDouble(txtNeto.getText().replace(",", ""));
        int codigoUser = Funciones.USUARIO_LOGUEADO_codigo;
        String estado = "E";
        int codigoSucur = Funciones.sucursal_SELECCIONADA_codigo;
        String modalidad = "";
        if (rdbCredito.isSelected()) {
            modalidad = "1";
        } else {
            modalidad = "2";
        }
        java.sql.Date fechaVencimiento = new java.sql.Date(this.dtFechaVencimiento.getDate().getTime());
        int diasVen = Integer.valueOf(this.rdb15dias.getText().toString());
        try {
            //grabar en latabla compra
            Venta objVenta = new Venta();
            objVenta.setCodigo_tipo_comprobante(codigoTC);
            objVenta.setNumero_serie(numeroSerie);
            objVenta.setNumero_documento(numeroDocumen);
            objVenta.setCodigo_cliente(codigoCliente);
            objVenta.setFecha_venta(fechaVenta);
            objVenta.setPorcentaje_igv(porcentajeIGV);
            objVenta.setIgv(igv);
            objVenta.setSub_total(subTotal);
            objVenta.setTotal(neto);
            objVenta.setCodigo_usuario(codigoUser);
            objVenta.setEstado(estado);
            objVenta.setCodigo_sucursal(codigoSucur);
            objVenta.setModalidad(modalidad);
            objVenta.setFecha_vencimiento(fechaVencimiento);
            objVenta.setDias_vencimiento(diasVen);
            //para grabar en compra detalle
            ArrayList<Venta_detalle> listaVentaDetalle = new ArrayList<Venta_detalle>();
            for (int i = 0; i < tblVentaDetalle.getRowCount(); i++) {
                int codigoArticulo = Integer.parseInt(tblVentaDetalle.getValueAt(i, 0).toString().replace(",", ""));
                int cantidad = Integer.parseInt(tblVentaDetalle.getValueAt(i, 3).toString());
                double precio = Double.parseDouble(tblVentaDetalle.getValueAt(i, 2).toString().replace(",", ""));
                double descuento = Double.parseDouble(tblVentaDetalle.getValueAt(i, 4).toString().replace(",", ""));
                double importe = Double.parseDouble(tblVentaDetalle.getValueAt(i, 5).toString().replace(",", ""));

                Venta_detalle objbitemDetais = new Venta_detalle();
                objbitemDetais.setCodigo_articulo(codigoArticulo);
                objbitemDetais.setCantidad(cantidad);
                objbitemDetais.setPrecio(precio);
                objbitemDetais.setDescuento(descuento);
                objbitemDetais.setImporte(importe);
                listaVentaDetalle.add(objbitemDetais);
                objVenta.setDetalleVentaArticulo(listaVentaDetalle);
            }

            if (objVenta.agregar()) {
                Funciones.mensajeInformacion("se ha agregado", "EXITO");
                accion = 1;
            }
        } catch (Exception e) {
            Funciones.mensajeError(e.getMessage(), Funciones.NOMBRE_SOFTWARE);
        }

    }//GEN-LAST:event_btnGrabarVentaActionPerformed

    private void rdb60diasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb60diasActionPerformed
        if (dtFecha.getDate()==null) {
            Funciones.mensajeError("INGRESE LA FECHA DE LA VENTA", Funciones.NOMBRE_SOFTWARE);
            rdb60dias.setSelected(false);
        } else {
            cargarFechaVencimiento();
        }
    }//GEN-LAST:event_rdb60diasActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void rdbTarjetaCreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbTarjetaCreditoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdbTarjetaCreditoActionPerformed

    private void rdbContadoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdbContadoMousePressed
        //txtDiasVencimiento.setEnabled(false);
        //txtFechaVencimiento.setEnabled(false);
    }//GEN-LAST:event_rdbContadoMousePressed

    private void rdbContadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbContadoActionPerformed
        habilitarDesabilitar(false, 1);
    }//GEN-LAST:event_rdbContadoActionPerformed

    private void rdbCreditoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdbCreditoMousePressed
        //txtDiasVencimiento.setEnabled(true);

    }//GEN-LAST:event_rdbCreditoMousePressed

    private void rdbCreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbCreditoActionPerformed
        habilitarDesabilitar(true, 2);
    }//GEN-LAST:event_rdbCreditoActionPerformed

    private void tblVentaDetallePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tblVentaDetallePropertyChange
        if (evt.getPropertyName().equalsIgnoreCase("tableCellEditor")) {
            int fila = this.tblVentaDetalle.getEditingRow();
            int columna = this.tblVentaDetalle.getEditingColumn();
            if (columna == 3 || columna == 4) {
                int cantidad = Integer.valueOf((this.tblVentaDetalle.getValueAt(fila, 3).toString()));
                double precio = Double.valueOf((this.tblVentaDetalle.getValueAt(fila, 2).toString()));
                double descuento = Double.valueOf((this.tblVentaDetalle.getValueAt(fila, 4).toString()));
                double importe = new Venta_detalle().calcularImporte(cantidad, precio, descuento);
                this.tblVentaDetalle.setValueAt(Funciones.formatearNumero(importe), fila, 5);
                calcularTotales();
            }

        }
    }//GEN-LAST:event_tblVentaDetallePropertyChange

    private void tblVentaDetalleKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblVentaDetalleKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            btnQuitarArticulo.doClick();
        }
    }//GEN-LAST:event_tblVentaDetalleKeyPressed

    private void btnAgregarArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarArticuloActionPerformed
        FrmPedidoBuscar2 objFrm = new FrmPedidoBuscar2(null, true);
        objFrm.setVisible(true);
        if (objFrm.accion == 0) {
            return;
        }
        int fila = objFrm.tblResultado.getSelectedRow();
        if (fila < 0) {
            return;
        }

        int codigoArticulo = Integer.valueOf(objFrm.tblResultado.getValueAt(fila, 0).toString());
        String nombreArticulo = objFrm.tblResultado.getValueAt(fila, 1).toString();
        String precio = objFrm.tblResultado.getValueAt(fila, 2).toString();
        Object filaDatos[] = new Object[6];
        filaDatos[0] = codigoArticulo;
        filaDatos[1] = nombreArticulo;
        filaDatos[2] = precio;
        filaDatos[3] = 0;
        filaDatos[4] = 0;
        filaDatos[5] = 0;
        DefaultTableModel tablaDetalle = (DefaultTableModel) this.tblVentaDetalle.getModel();
        tablaDetalle.addRow(filaDatos);

    }//GEN-LAST:event_btnAgregarArticuloActionPerformed

    private void rdb15diasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb15diasActionPerformed
        if (dtFecha.getDate()==null) {
            Funciones.mensajeError("INGRESE LA FECHA DE LA VENTA", Funciones.NOMBRE_SOFTWARE);
            rdb15dias.setSelected(false);
        } else {
            cargarFechaVencimiento();
        }
    }//GEN-LAST:event_rdb15diasActionPerformed

//    private boolean verificar_fecha(){
//        if (dtFecha.getDate().getDay()) {
//            
//        }
//    }
    private void btnQuitarArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarArticuloActionPerformed
        DefaultTableModel tabladetalle = (DefaultTableModel) this.tblVentaDetalle.getModel();
        int fila = tblVentaDetalle.getSelectedRow();
        String art = tblVentaDetalle.getValueAt(fila, 1).toString();

        if (fila < 0) {
            Funciones.mensajeError("Debe Seleccionar una fila", "Verifique");
            return;
        }
        int respuesta = Funciones.mensajeConfirmacion("esta seguro de quitar este articulo: " + art, "CONFIRME");
        if (respuesta != 0) {
            return;
        }
        tabladetalle.removeRow(fila);
        this.tblVentaDetalle.setModel(tabladetalle);
        calcularTotales();
    }//GEN-LAST:event_btnQuitarArticuloActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarArticulo;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnGrabarVenta;
    private javax.swing.JButton btnQuitarArticulo;
    private javax.swing.JButton btnSalir;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JComboBox cboTipoComprobante;
    private com.toedter.calendar.JDateChooser dtFecha;
    private com.toedter.calendar.JDateChooser dtFechaVencimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JToolBar jToolBar3;
    private javax.swing.JRadioButton rdb15dias;
    private javax.swing.JRadioButton rdb30dias;
    private javax.swing.JRadioButton rdb45dias;
    private javax.swing.JRadioButton rdb60dias;
    private javax.swing.JRadioButton rdbContado;
    private javax.swing.JRadioButton rdbCredito;
    private javax.swing.JRadioButton rdbTarjetaCredito;
    private javax.swing.JRadioButton rdbTarjeta_debito;
    private javax.swing.JTable tblVentaDetalle;
    private javax.swing.JTextField txtCodigo_cliente;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtIGV_RES;
    private javax.swing.JTextField txtIGV_porcentaje;
    private javax.swing.JTextField txtNcompra;
    private javax.swing.JTextField txtNeto;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtNroTarjeta;
    private javax.swing.JTextField txtNumDocumento;
    private javax.swing.JTextField txtNumSerie;
    private javax.swing.JTextField txtSubTotal;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
  private void calcularTotales() {
        double porcentajeIGV = 0;
        if (!this.txtIGV_porcentaje.getText().isEmpty()) {
            porcentajeIGV = Double.parseDouble(this.txtIGV_porcentaje.getText());
        }

        double subtotal = 0;
        double montoIGV = 0;
        double neto = 0;
        for (int i = 0; i < this.tblVentaDetalle.getRowCount(); i++) {
            double importe = 0;
            importe = Double.parseDouble(this.tblVentaDetalle.getValueAt(i, 5).toString().replace(",", ""));
            neto = neto + importe;
        }
        subtotal = neto / (1 + (porcentajeIGV / 100));
        montoIGV = neto - subtotal;
        this.txtSubTotal.setText(Funciones.formatearNumero(subtotal));
        this.txtNeto.setText(Funciones.formatearNumero(neto));
        this.txtIGV_RES.setText(Funciones.formatearNumero(montoIGV));
    }

    public void obtenerTasaIGV() {
        try {
            String valor = new Configuración().obtenerValorConfiguracion(1);
            this.txtIGV_porcentaje.setText(valor);
        } catch (Exception e) {
            Funciones.mensajeError(e.getMessage(), Funciones.NOMBRE_SOFTWARE);
        }
    }

    private void configurarCabeceraDetalle() {
        try {
            ResultSet resul = new Venta_detalle().configurarCabecera();
            int[] ancho = {100, 400, 100, 73, 74, 74};
            String[] alineamiento = {"C", "I", "C", "I", "I", "I"};
            Funciones.llenarTabla(tblVentaDetalle, resul, ancho, alineamiento);

        } catch (Exception e) {
            Funciones.mensajeError(e.getMessage(), Funciones.NOMBRE_SOFTWARE);
        }
    }

    public void llenarCombo() {
        try {
            new TipoComprobante().llenarCombo(cboTipoComprobante);
        } catch (Exception e) {
            Funciones.mensajeError(e.getMessage(), Funciones.NOMBRE_SOFTWARE);
        }
    }

    public void habilitarDesabilitar(boolean dato, int caso) {

        switch (caso) {
            case 1:
                //contado
                this.txtNroTarjeta.setEnabled(dato);
                this.txtNroTarjeta.setText("");
                this.rdb15dias.setEnabled(dato);
                this.rdb15dias.setSelected(dato);
                this.rdb30dias.setEnabled(dato);
                this.rdb30dias.setSelected(dato);
                this.rdb45dias.setEnabled(dato);
                this.rdb45dias.setSelected(dato);
                this.rdb60dias.setEnabled(dato);
                this.rdb60dias.setSelected(dato);
                this.rdbTarjetaCredito.setEnabled(dato);
                this.rdbTarjetaCredito.setSelected(dato);
                this.rdbTarjeta_debito.setEnabled(dato);
                this.rdbTarjeta_debito.setSelected(dato);
            case 2:
                //Credito
                this.txtNroTarjeta.setEnabled(dato);
                this.txtNroTarjeta.setText("");
                this.rdb15dias.setEnabled(dato);
                this.rdb30dias.setEnabled(dato);
                this.rdb45dias.setEnabled(dato);
                this.rdb60dias.setEnabled(dato);
                this.rdbTarjeta_debito.setEnabled(dato);
                this.rdbTarjetaCredito.setEnabled(dato);

        }
    }

    public void cargarFechaVencimiento() {
        if (rdb15dias.isSelected()) {
            int dias = 15;
            Calendar cal = dtFecha.getCalendar();
            cal.add(Calendar.DAY_OF_MONTH, dias);
            dtFechaVencimiento.setCalendar(cal);
        } else {
            if (rdb30dias.isSelected()) {
                int dias = 30;
                Calendar cal = dtFecha.getCalendar();
                cal.add(Calendar.DAY_OF_MONTH, dias);
                dtFechaVencimiento.setCalendar(cal);
            } else {
                if (rdb45dias.isSelected()) {
                    int dias = 45;
                    Calendar cal = dtFecha.getCalendar();
                    cal.add(Calendar.DAY_OF_MONTH, dias);
                    dtFechaVencimiento.setCalendar(cal);
                } else {
                    if (rdb60dias.isSelected()) {
                        int dias = 60;
                        Calendar cal = dtFecha.getCalendar();
                        cal.add(Calendar.DAY_OF_MONTH, dias);
                        dtFechaVencimiento.setCalendar(cal);
                    } else {
                        return;
                    }
                }
            }
        }
    }
}
