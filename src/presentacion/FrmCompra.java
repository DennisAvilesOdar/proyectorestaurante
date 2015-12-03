package presentacion;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import logica.Compra;
import logica.CompraDetalleProducto;
import logica.Configuración;
import logica.TipoComprobante;
import util.Funciones;

public class FrmCompra extends javax.swing.JDialog {
    public int accion=0;
  
    public FrmCompra(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        llenarComboTC();
        configurarCabeceraDetalle();
        tblCompraDetalle.setCellSelectionEnabled(true);
        tblCompraDetalle.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblCompraDetalle.setRowHeight(25);
        ObtenerTasaIGV();
    }
    
    private void calcularTotales(){
        double porcentajeIGV = 0;
        if (! this.txtPorIGV.getText().isEmpty()) {
               porcentajeIGV = Double.parseDouble(this.txtPorIGV.getText());
        }
        double subTotal=0;
        double montoIGV=0;
        double neto=0;
        
        for (int i = 0; i < this.tblCompraDetalle.getRowCount(); i++) {
            double importe = 0;
            
            importe = Double.parseDouble(this.tblCompraDetalle.getValueAt(i, 5).toString().replace(",", ""));
            neto = neto + importe;
        }
        
        subTotal = neto/ (1+(porcentajeIGV/100));
        montoIGV = neto - subTotal;
        
        this.lblSubTotal.setText(Funciones.formatearNumero(subTotal));
        this.lblIGV.setText(Funciones.formatearNumero(montoIGV));
        this.lblNeto.setText(Funciones.formatearNumero(neto));
    }
    
    private void ObtenerTasaIGV(){
        try {
            String valor = new Configuración().obtenerValorConfiguracion(1);
            this.txtPorIGV.setText(valor);
        } catch (Exception e) {
            Funciones.mensajeError(e.getMessage(), Funciones.NOMBRE_SOFTWARE);
        }
    }
    
    private void configurarCabeceraDetalle(){
        try {
            
            ResultSet resultado = new CompraDetalleProducto().configurarCabeceraDetalle();
            String alineacion[] = {"C", "I", "I", "I", "D", "I"};
            int anchoColumnas[] = {90, 300, 90, 90, 100, 90};
            
            Funciones.llenarTabla(tblCompraDetalle, resultado, anchoColumnas, alineacion);
            
        } catch (Exception e) {
            Funciones.mensajeError(e.getMessage(), Funciones.NOMBRE_SOFTWARE);
        }
    }
    
    private void llenarComboTC(){
        try {
            new TipoComprobante().llenarCombo(cboTC);
        } catch (Exception e) {
            Funciones.mensajeError(e.getMessage(), Funciones.NOMBRE_SOFTWARE);
        }
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        lblSubTotal = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lblIGV = new javax.swing.JLabel();
        lblNeto = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        /*parte 1*/
        final JTextField field = new JTextField("Juancarlos");
        final DefaultCellEditor edit = new DefaultCellEditor(field);
        field.setBorder(BorderFactory.createMatteBorder(3,3,3,3,Color.red));
        field.setForeground(Color.blue);
        /*parte 1*/
        tblCompraDetalle = new javax.swing.JTable(){
            /*parte 2*/
            public boolean isCellEditable(int fila, int columna){
                if (columna == 2 || columna == 3 || columna == 4){
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
            /*parte 2*/

        };
        jLabel13 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtRuc = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        lblRazonSocial = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtCantDiasVenc = new javax.swing.JTextField();
        cboTC = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        txtNroDoc = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNroSerie = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtFecha = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        txtFechaVencimiento = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        txtPorIGV = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        btnAgregarInsumo = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnQuitarInsumo = new javax.swing.JButton();
        jToolBar2 = new javax.swing.JToolBar();
        btnGrabar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 153, 102));

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel10.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 255, 204));
        jLabel10.setText("Sub. Total:");

        lblSubTotal.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        lblSubTotal.setForeground(new java.awt.Color(255, 204, 0));
        lblSubTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSubTotal.setText("0.00");
        lblSubTotal.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblSubTotal.setPreferredSize(new java.awt.Dimension(72, 20));

        jLabel14.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(204, 255, 204));
        jLabel14.setText("IGV:");

        lblIGV.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        lblIGV.setForeground(new java.awt.Color(255, 204, 0));
        lblIGV.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblIGV.setText("0.00");
        lblIGV.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblIGV.setPreferredSize(new java.awt.Dimension(72, 20));

        lblNeto.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        lblNeto.setForeground(new java.awt.Color(255, 204, 0));
        lblNeto.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNeto.setText("0.00");
        lblNeto.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblNeto.setPreferredSize(new java.awt.Dimension(72, 20));

        jLabel17.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(204, 255, 204));
        jLabel17.setText("Neto:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblIGV, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNeto, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(lblIGV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel14)
                        .addComponent(lblNeto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel17)))
                .addContainerGap())
        );

        tblCompraDetalle.setModel(new javax.swing.table.DefaultTableModel(
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
        tblCompraDetalle.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                tblCompraDetalleMouseWheelMoved(evt);
            }
        });
        tblCompraDetalle.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tblCompraDetallePropertyChange(evt);
            }
        });
        tblCompraDetalle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblCompraDetalleKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblCompraDetalle);
        /*parte 3*/
        tblCompraDetalle.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
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

        jLabel13.setBackground(new java.awt.Color(255, 204, 153));
        jLabel13.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 204, 153));
        jLabel13.setText("Artículos registrados en la compra");

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del proveedor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(255, 204, 153))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("RUC:");

        txtRuc.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        txtRuc.setEnabled(false);
        txtRuc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRucKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRucKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Razón Social:");

        lblRazonSocial.setBackground(new java.awt.Color(0, 102, 102));
        lblRazonSocial.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        lblRazonSocial.setText(" ");
        lblRazonSocial.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblRazonSocial.setPreferredSize(new java.awt.Dimension(7, 22));

        btnBuscar.setBackground(new java.awt.Color(51, 153, 0));
        btnBuscar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Search.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Dirección:");

        lblDireccion.setBackground(new java.awt.Color(0, 102, 102));
        lblDireccion.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        lblDireccion.setText(" ");
        lblDireccion.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblDireccion.setPreferredSize(new java.awt.Dimension(7, 22));

        jLabel11.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Teléfono:");

        lblTelefono.setBackground(new java.awt.Color(0, 102, 102));
        lblTelefono.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        lblTelefono.setText(" ");
        lblTelefono.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblTelefono.setPreferredSize(new java.awt.Dimension(7, 22));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel7)
                        .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtRuc, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscar))
                    .addComponent(lblRazonSocial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRuc)
                    .addComponent(btnBuscar)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lblRazonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lblDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(lblTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel12.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Cant. Dias");

        txtCantDiasVenc.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N

        cboTC.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        cboTC.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Tipo Comprobante");

        txtNroDoc.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nº Documento");

        txtNroSerie.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nº Serie");

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Fecha Compra");

        jLabel15.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("N° Compra");

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Fecha de Vencimiento");

        txtPorIGV.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        txtPorIGV.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPorIGVFocusLost(evt);
            }
        });
        txtPorIGV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPorIGVKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPorIGVKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("IGV (%)");

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/[Cabecera] Insumos.jpg"))); // NOI18N
        jLabel16.setText(" ");

        jToolBar1.setBackground(new java.awt.Color(0, 102, 102));
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        btnAgregarInsumo.setBackground(new java.awt.Color(0, 102, 102));
        btnAgregarInsumo.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        btnAgregarInsumo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/[Boton] Agregar.png"))); // NOI18N
        btnAgregarInsumo.setToolTipText("Agregar producto");
        btnAgregarInsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarInsumoActionPerformed(evt);
            }
        });
        jToolBar1.add(btnAgregarInsumo);
        jToolBar1.add(jSeparator1);

        btnQuitarInsumo.setBackground(new java.awt.Color(0, 102, 102));
        btnQuitarInsumo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnQuitarInsumo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/[Boton] Eliminar agregado.png"))); // NOI18N
        btnQuitarInsumo.setToolTipText("Quitar producto");
        btnQuitarInsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarInsumoActionPerformed(evt);
            }
        });
        jToolBar1.add(btnQuitarInsumo);

        jToolBar2.setBackground(new java.awt.Color(0, 102, 102));
        jToolBar2.setFloatable(false);
        jToolBar2.setRollover(true);

        btnGrabar.setBackground(new java.awt.Color(0, 102, 102));
        btnGrabar.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        btnGrabar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/[Boton] Guardar.png"))); // NOI18N
        btnGrabar.setToolTipText("Grabar");
        btnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarActionPerformed(evt);
            }
        });
        jToolBar2.add(btnGrabar);
        jToolBar2.add(jSeparator2);

        btnSalir.setBackground(new java.awt.Color(0, 102, 102));
        btnSalir.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/[Boton] Salir.png"))); // NOI18N
        btnSalir.setToolTipText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jToolBar2.add(btnSalir);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel13)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel15)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtNroSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(cboTC, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtNroDoc))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtCantDiasVenc)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtFechaVencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel8)
                                .addComponent(txtPorIGV, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(257, 257, 257)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 17, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jLabel15))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cboTC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNroSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtNroDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtPorIGV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtCantDiasVenc)
                            .addComponent(txtFechaVencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPorIGVKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPorIGVKeyTyped

    }//GEN-LAST:event_txtPorIGVKeyTyped

    private void txtPorIGVKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPorIGVKeyPressed

    }//GEN-LAST:event_txtPorIGVKeyPressed

    private void txtPorIGVFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPorIGVFocusLost

    }//GEN-LAST:event_txtPorIGVFocusLost

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        /*
        FrmProveedorBuscar objFrm = new FrmProveedorBuscar(null, true);
        objFrm.setVisible(true);

        if (objFrm.accion==1) {  //hizo clic en aceptar
            int filaSeleccionada = objFrm.tblProveedor.getSelectedRow();

            String ruc = objFrm.tblProveedor.getValueAt(filaSeleccionada, 0).toString();
            String rs  = objFrm.tblProveedor.getValueAt(filaSeleccionada, 1).toString();
            String dir = objFrm.tblProveedor.getValueAt(filaSeleccionada, 2).toString();
            String tel = objFrm.tblProveedor.getValueAt(filaSeleccionada, 3).toString();

            this.txtRuc.setText(ruc);
            this.lblRazonSocial.setText(rs);
            this.lblDireccion.setText(dir);
            this.lblTelefono.setText(tel);
        }
        */
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtRucKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRucKeyTyped

    }//GEN-LAST:event_txtRucKeyTyped

    private void txtRucKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRucKeyPressed

    }//GEN-LAST:event_txtRucKeyPressed

    private void btnAgregarInsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarInsumoActionPerformed
        /*
        FrmArticuloBuscar objFrm = new FrmArticuloBuscar(null, true);
        objFrm.setTitle("Agregar nuevo Insumo");
        objFrm.setVisible(true);

        if (objFrm.accion == 0) {     //Para cuando el usuario no selecciona ninguna fila
            return;
        }

        int fila = objFrm.tblResultado.getSelectedRow();

        if (fila < 0) {     //Para cuando el usuario no selecciona ninguna fila
            return;
        }

        int codigoInsumo = Integer.parseInt(objFrm.tblResultado.getValueAt(fila, 0).toString());
        String nombreInsumo = objFrm.tblResultado.getValueAt(fila, 1).toString();
        Object filaDatos[] = new Object[6];
        filaDatos[0] = codigoInsumo;
        filaDatos[1] = nombreInsumo;
        filaDatos[2] = 0;
        filaDatos[3] = 0;
        filaDatos[4] = 0;
        filaDatos[5] = 0;

        DefaultTableModel tablaDetalle = (DefaultTableModel)this.tblCompraDetalle.getModel();

        tablaDetalle.addRow(filaDatos);

        this.tblCompraDetalle.setModel(tablaDetalle);
        */
    }//GEN-LAST:event_btnAgregarInsumoActionPerformed

    private void btnQuitarInsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarInsumoActionPerformed

        DefaultTableModel tablaDetalle = (DefaultTableModel)this.tblCompraDetalle.getModel();
        int fila = this.tblCompraDetalle.getSelectedRow();

        if (fila < 0) {
            Funciones.mensajeError("Debe seleccionar una fila", "Verifique");
            return;
        }

        String articulo = tblCompraDetalle.getValueAt(fila, 1).toString();
        int respuesta = Funciones.mensajeConfirmacion("Está seguro de quitar el insumo: " + articulo +"?", "Confirme");

        if (respuesta != 0) {
            return;
        }

        tablaDetalle.removeRow(fila);
        this.tblCompraDetalle.setModel(tablaDetalle);

        calcularTotales();
    }//GEN-LAST:event_btnQuitarInsumoActionPerformed

    private void tblCompraDetalleKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblCompraDetalleKeyPressed
        /*
        if (evt.getKeyCode()==KeyEvent.VK_DELETE) {
            btnQuitar.doClick();
        }
        */

        switch(evt.getKeyCode()){
            case KeyEvent.VK_DELETE:
            btnQuitarInsumo.doClick();
            break;

            case  KeyEvent.VK_INSERT:
            btnAgregarInsumo.doClick();
            break;
        }
    }//GEN-LAST:event_tblCompraDetalleKeyPressed

    private void tblCompraDetallePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tblCompraDetallePropertyChange
        if (evt.getPropertyName().equalsIgnoreCase("tableCellEditor")) {
            int fila = this.tblCompraDetalle.getEditingRow();
            int columna = this.tblCompraDetalle.getEditingColumn();
            if (columna == 2 || columna == 3 || columna == 4) {
                int cantidad = Integer.parseInt(this.tblCompraDetalle.getValueAt(fila, 2).toString());
                double precio = Double.parseDouble(this.tblCompraDetalle.getValueAt(fila, 3).toString());
                double descuento = Double.parseDouble(this.tblCompraDetalle.getValueAt(fila, 4).toString());
                calcularTotales();
            }
        }
    }//GEN-LAST:event_tblCompraDetallePropertyChange

    private void tblCompraDetalleMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_tblCompraDetalleMouseWheelMoved

    }//GEN-LAST:event_tblCompraDetalleMouseWheelMoved

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.accion = 0;
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
        int respuesta = Funciones.mensajeConfirmacion("Desea grabar la compra", "Confirme");
        if (respuesta == 1) {
            return;
        }

        int codigoTC = TipoComprobante.listaTC.get(cboTC.getSelectedIndex()).getCodigoTipoComprobante();
        int nroSerie = Integer.parseInt(txtNroSerie.getText());
        int nroDoc = Integer.parseInt(txtNroDoc.getText());
        String rucProveedor = this.txtRuc.getText();
        java.sql.Date fechaCompra = new java.sql.Date(this.txtFecha.getDate().getTime());
        double porcentajeIGV = Double.parseDouble(txtPorIGV.getText());
        double subTotal = Double.parseDouble(lblSubTotal.getText().replace(",", ""));
        double igv = Double.parseDouble(lblIGV.getText().replace(",", ""));
        double total = Double.parseDouble(lblNeto.getText().replace(",", ""));
        int cantDiasVenc = Integer.parseInt(txtCantDiasVenc.getText());
        java.sql.Date fechaVencimiento = new java.sql.Date(this.txtFechaVencimiento.getDate().getTime());
        int codigoUsuario = Funciones.USUARIO_LOGUEADO_codigo;

        try {

            //Recoger los datos para grabar en compraa
            Compra objCompra = new Compra();
            objCompra.setCodigoTipoComprobante(codigoTC);
            objCompra.setNumeroSerie(nroSerie);
            objCompra.setNumeroDocumento(nroDoc);
            objCompra.setRucProveedor(rucProveedor);
            objCompra.setFechaCompra(fechaCompra);
            objCompra.setPorcentajeIGV(porcentajeIGV);
            objCompra.setSubTotal(subTotal);
            objCompra.setIgv(igv);
            objCompra.setTotal(total);
            objCompra.setCantDiasVencimiento(cantDiasVenc);
            objCompra.setFechaVencimiento(fechaVencimiento);
            objCompra.setIdUsuario(codigoUsuario);

            //Recoger los datos para grabar en compra detalle
            ArrayList<CompraDetalleProducto> listaCompraDetalleI = new ArrayList<CompraDetalleProducto>();

            //recorrer todas las filas del jtable para recoger los datos
            for (int i = 0; i < tblCompraDetalle.getRowCount(); i++) {
                int codigoProducto = Integer.parseInt(tblCompraDetalle.getValueAt(i, 0).toString());
                int cantidad = Integer.parseInt(tblCompraDetalle.getValueAt(i, 2).toString());
                double precio = Double.parseDouble(tblCompraDetalle.getValueAt(i, 3).toString().replace(",", " "));
                double descuento = Double.parseDouble(tblCompraDetalle.getValueAt(i, 4).toString().replace(",", " "));

                CompraDetalleProducto objItemDetalleI = new CompraDetalleProducto();
                objItemDetalleI.setCodigoProducto(codigoProducto);
                objItemDetalleI.setCantidad(cantidad);
                objItemDetalleI.setPrecio(precio);
                objItemDetalleI.setDescuento(descuento);

                listaCompraDetalleI.add(objItemDetalleI);

            }

            objCompra.setDetalleCompraInsumo(listaCompraDetalleI);

            if (objCompra.agregar()) {
                Funciones.mensajeInformacion("Se ha registrado la compra", "Exito");
                this.accion = 1;
                this.dispose();
            }

        } catch (Exception e) {
            Funciones.mensajeError(e.getMessage(), "Error");
        }
    }//GEN-LAST:event_btnGrabarActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarInsumo;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnGrabar;
    private javax.swing.JButton btnQuitarInsumo;
    private javax.swing.JButton btnSalir;
    public javax.swing.JComboBox cboTC;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JLabel lblDireccion;
    public javax.swing.JLabel lblIGV;
    public javax.swing.JLabel lblNeto;
    private javax.swing.JLabel lblRazonSocial;
    public javax.swing.JLabel lblSubTotal;
    private javax.swing.JLabel lblTelefono;
    public javax.swing.JTable tblCompraDetalle;
    private javax.swing.JTextField txtCantDiasVenc;
    public com.toedter.calendar.JDateChooser txtFecha;
    private com.toedter.calendar.JDateChooser txtFechaVencimiento;
    public javax.swing.JTextField txtNroDoc;
    public javax.swing.JTextField txtNroSerie;
    public javax.swing.JTextField txtPorIGV;
    public javax.swing.JTextField txtRuc;
    // End of variables declaration//GEN-END:variables
}
