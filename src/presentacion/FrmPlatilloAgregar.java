package presentacion;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import logica.Producto;
import logica.Platillo;
import logica.PlatilloArticulo;
import logica.PlatilloInsumo;
import util.Funciones;

public class FrmPlatilloAgregar extends javax.swing.JDialog {
    public int accion = 0;
    
    public FrmPlatilloAgregar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.txtNombre.requestFocus();
        configurarCabeceraInsumos();
        tblInsumos.setCellSelectionEnabled(true);
        tblInsumos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblInsumos.setRowHeight(25);
    }
    
    private void configurarCabeceraInsumos() {
        try {
            ResultSet resultado = new PlatilloInsumo().configurarCabeceraDetalle();
            String alineacionColumnas[] = {"C", "I", "D"};
            int anchoColumnas[] = {100, 300, 170};
            Funciones.llenarTabla(tblInsumos, resultado, anchoColumnas, alineacionColumnas);
        } catch (Exception e) {
            Funciones.mensajeError(e.getMessage(), Funciones.NOMBRE_SOFTWARE);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblInsumos = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        btnAgregarInsumo = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnQuitarInsumo = new javax.swing.JButton();
        jToolBar3 = new javax.swing.JToolBar();
        btnGuardar = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATOS DEL PLATILLO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 1, 12), new java.awt.Color(153, 255, 255))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel1.setText("Nombre:");

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel2.setText("Descripción:");

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel3.setText("Precio:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDescripcion)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Listado de Productos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(153, 255, 255))); // NOI18N

        tblInsumos.setModel(new javax.swing.table.DefaultTableModel(
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
        tblInsumos.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tblInsumosPropertyChange(evt);
            }
        });
        tblInsumos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblInsumosKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblInsumos);

        jToolBar1.setBackground(new java.awt.Color(102, 102, 102));
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        btnAgregarInsumo.setBackground(new java.awt.Color(102, 102, 102));
        btnAgregarInsumo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/[Boton] Agregar.png"))); // NOI18N
        btnAgregarInsumo.setToolTipText("Agregar producto");
        btnAgregarInsumo.setFocusable(false);
        btnAgregarInsumo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAgregarInsumo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAgregarInsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarInsumoActionPerformed(evt);
            }
        });
        jToolBar1.add(btnAgregarInsumo);
        jToolBar1.add(jSeparator1);

        btnQuitarInsumo.setBackground(new java.awt.Color(102, 102, 102));
        btnQuitarInsumo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/[Boton] Eliminar agregado.png"))); // NOI18N
        btnQuitarInsumo.setToolTipText("Quitar producto");
        btnQuitarInsumo.setFocusable(false);
        btnQuitarInsumo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnQuitarInsumo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnQuitarInsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarInsumoActionPerformed(evt);
            }
        });
        jToolBar1.add(btnQuitarInsumo);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                .addContainerGap())
        );

        jToolBar3.setBackground(new java.awt.Color(102, 102, 102));
        jToolBar3.setFloatable(false);
        jToolBar3.setRollover(true);

        btnGuardar.setBackground(new java.awt.Color(102, 102, 102));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/[Boton] Guardar.png"))); // NOI18N
        btnGuardar.setToolTipText("Grabar");
        btnGuardar.setFocusable(false);
        btnGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGuardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jToolBar3.add(btnGuardar);
        jToolBar3.add(jSeparator3);

        btnSalir.setBackground(new java.awt.Color(102, 102, 102));
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/[Boton] Salir.png"))); // NOI18N
        btnSalir.setToolTipText("Salir");
        btnSalir.setFocusable(false);
        btnSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jToolBar3.add(btnSalir);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jToolBar3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.accion = 0;
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnAgregarInsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarInsumoActionPerformed
        FrmProductoBuscar objFrm = new FrmProductoBuscar(null, true);
        objFrm.setVisible(true);
        Producto c = new Producto();
        if (objFrm.accion == 0) {
            return;
        }
        int fila = objFrm.tblResultado.getSelectedRow();

        if (fila < 0) {
            return;
        }

        int codigoProducto = Integer.parseInt(objFrm.tblResultado.getValueAt(fila, 0).toString());
        String nombreProducto = objFrm.tblResultado.getValueAt(fila, 1).toString();
        c.setCodigo_producto(codigoProducto);

        Object filaDatos[] = new Object[3];
        filaDatos[0] = codigoProducto;
        filaDatos[1] = nombreProducto;
        filaDatos[2] = 0;
        
        DefaultTableModel tablaDetalle = (DefaultTableModel) this.tblInsumos.getModel();
        tablaDetalle.addRow(filaDatos);

        this.tblInsumos.setModel(tablaDetalle);
    }//GEN-LAST:event_btnAgregarInsumoActionPerformed

    private void tblInsumosPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tblInsumosPropertyChange
        if (evt.getPropertyName().equalsIgnoreCase("tableCellEditor")) {
            int fila = this.tblInsumos.getEditingRow();
            int columna = this.tblInsumos.getEditingColumn();
            if (columna == 2) {
                int cantidad = Integer.parseInt(this.tblInsumos.getValueAt(fila, 2).toString());
            }
        }
    }//GEN-LAST:event_tblInsumosPropertyChange

    private void btnQuitarInsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarInsumoActionPerformed
        DefaultTableModel tablaDetalle = (DefaultTableModel) this.tblInsumos.getModel();
        int fila = this.tblInsumos.getSelectedRow();
        
        if (fila < 0) {
            Funciones.mensajeError("Debe seleccionar una fila", "Verifique");
            return;
        }

        String insumo = tblInsumos.getValueAt(fila, 1).toString();
        int respuesta = Funciones.mensajeConfirmacion("¿Esta seguro de quitar el insumo: " + insumo, "Confirme");
        
        if (respuesta != 0) {
            return;
        }
        
        tablaDetalle.removeRow(fila);
        this.tblInsumos.setModel(tablaDetalle);
        
    }//GEN-LAST:event_btnQuitarInsumoActionPerformed

    private void tblInsumosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblInsumosKeyPressed
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_DELETE:
                btnQuitarInsumo.doClick();
                break;

            case KeyEvent.VK_INSERT:
                btnAgregarInsumo.doClick();
                break;
        }
    }//GEN-LAST:event_tblInsumosKeyPressed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        int respuesta = Funciones.mensajeConfirmacion("¿Desea grabar el platillo?", "Confirme");
        if (respuesta == 1) {
            return;
        }
        
        String nombre = txtNombre.getText();
        String descripcion = txtDescripcion.getText();
        double precio = Double.parseDouble(txtPrecio.getText().replace(",", ""));
        
        try {
            Platillo m = new Platillo();
            m.setNombre(nombre);
            m.setDescripcion(descripcion);
            m.setPrecio(precio);
            
            ArrayList<PlatilloInsumo> listaInsumos = new ArrayList<PlatilloInsumo>();

            for (int i = 0; i < tblInsumos.getRowCount(); i++) {
                int codigoInsumo = Integer.parseInt(tblInsumos.getValueAt(i, 0).toString());
                int cantidad = Integer.parseInt(tblInsumos.getValueAt(i, 2).toString());
                
                PlatilloInsumo objItemDetalle = new PlatilloInsumo();
                objItemDetalle.setCodigo_insumo(codigoInsumo);
                objItemDetalle.setCantidad(cantidad);
                
                listaInsumos.add(objItemDetalle);
            }
            m.setDetalleInsumos(listaInsumos);
            
            if (m.agregar()) {
                Funciones.mensajeInformacion("Se ha registrado el platillo", "Éxito");
                this.accion = 1;
                this.dispose();
            }

        } catch (Exception e) {
            Funciones.mensajeError(e.getMessage(), "Error");
        }

    }//GEN-LAST:event_btnGuardarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarInsumo;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnQuitarInsumo;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar3;
    private javax.swing.JTable tblInsumos;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
