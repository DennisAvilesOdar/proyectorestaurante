package presentacion;

import java.sql.ResultSet;
import logica.Articulo;
import logica.Producto;
import logica.Platillo;
import util.Funciones;

public class FrmPlatilloRegistro extends javax.swing.JInternalFrame {
    
    public FrmPlatilloRegistro() {
        initComponents();
        this.setLocation(250, 60);
        llenarComboArticulos();
        llenarComboInsumo();
        rdoTodosArticulos.setSelected(true);
        rdoTodosInsumos.setSelected(true);
        cboInsumos.setEnabled(false);
        listar();
    }
    
    private void llenarComboInsumo(){
        try {
            new Producto().llenarCombo(cboInsumos);
        } catch (Exception e) {
            Funciones.mensajeError(e.getMessage(), Funciones.NOMBRE_SOFTWARE);
        }
    }
    
    private void llenarComboArticulos(){
        try {
            new Articulo().llenarCombo(cboArticulos);
        } catch (Exception e) {
            Funciones.mensajeError(e.getMessage(), Funciones.NOMBRE_SOFTWARE);
        }
    }
    
    private void listar(){
        try {
            int insumo=0;
            if(rdoTodosInsumos.isSelected()){
                insumo=0;
            } else{
                if(rdoInsumo.isSelected())
                insumo= cboInsumos.getSelectedIndex();
            }
            
            int articulo = 0;
            if(rdoTodosArticulos.isSelected()){
                articulo=0;
            } else {
                if(rdoArticulo.isSelected()){
                    articulo = cboArticulos.getSelectedIndex();
                }
            }
            
            ResultSet resultado = new Platillo().listar(insumo, articulo);
            Funciones.llenarTabla(tblListado, resultado);
            
        } catch (Exception e) {
            Funciones.mensajeError(e.getMessage(), "Error");
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grdoInsumos = new javax.swing.ButtonGroup();
        grdoArticulos = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        rdoArticulo = new javax.swing.JRadioButton();
        rdoTodosArticulos = new javax.swing.JRadioButton();
        cboArticulos = new javax.swing.JComboBox();
        tbl = new javax.swing.JScrollPane();
        tblListado = new javax.swing.JTable()
        {
            public boolean isCellEditable(int fila, int columna){
                return false;
            }
        }
        ;
        jToolBar1 = new javax.swing.JToolBar();
        btnAgregar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnEliminar = new javax.swing.JButton();
        jToolBar2 = new javax.swing.JToolBar();
        btnSalir = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        rdoInsumo = new javax.swing.JRadioButton();
        rdoTodosInsumos = new javax.swing.JRadioButton();
        cboInsumos = new javax.swing.JComboBox();
        jToolBar3 = new javax.swing.JToolBar();
        btnFiltrar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Registro de platillos");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/[Cabecera] Platillos.jpg"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "FILTRAR POR ARTÍCULO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 1, 12), new java.awt.Color(51, 102, 255))); // NOI18N

        rdoArticulo.setBackground(new java.awt.Color(255, 255, 204));
        grdoArticulos.add(rdoArticulo);
        rdoArticulo.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        rdoArticulo.setText("Artículo");

        rdoTodosArticulos.setBackground(new java.awt.Color(255, 255, 204));
        grdoArticulos.add(rdoTodosArticulos);
        rdoTodosArticulos.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        rdoTodosArticulos.setText("Todos los artículos");

        cboArticulos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(rdoArticulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboArticulos, 0, 199, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(rdoTodosArticulos)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoArticulo)
                    .addComponent(cboArticulos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rdoTodosArticulos)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        tblListado.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        tblListado.setModel(new javax.swing.table.DefaultTableModel(
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
        tblListado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListadoMouseClicked(evt);
            }
        });
        tbl.setViewportView(tblListado);

        jToolBar1.setBackground(new java.awt.Color(255, 255, 204));
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        btnAgregar.setBackground(new java.awt.Color(255, 255, 204));
        btnAgregar.setFont(new java.awt.Font("Trebuchet MS", 1, 11)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/[Boton] Añadir 2.png"))); // NOI18N
        btnAgregar.setToolTipText("Agregar");
        btnAgregar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnAgregar);
        jToolBar1.add(jSeparator1);

        btnEliminar.setBackground(new java.awt.Color(255, 255, 204));
        btnEliminar.setFont(new java.awt.Font("Trebuchet MS", 1, 11)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/[Boton] Eliminar todo.png"))); // NOI18N
        btnEliminar.setToolTipText("Anular");
        btnEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnEliminar);

        jToolBar2.setBackground(new java.awt.Color(255, 255, 204));
        jToolBar2.setFloatable(false);
        jToolBar2.setRollover(true);

        btnSalir.setBackground(new java.awt.Color(255, 255, 204));
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/[Boton] Salir.png"))); // NOI18N
        btnSalir.setToolTipText("Salir");
        btnSalir.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jToolBar2.add(btnSalir);

        jPanel3.setBackground(new java.awt.Color(255, 255, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "FILTRAR POR INSUMO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 1, 12), new java.awt.Color(51, 102, 255))); // NOI18N

        rdoInsumo.setBackground(new java.awt.Color(255, 255, 204));
        grdoInsumos.add(rdoInsumo);
        rdoInsumo.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        rdoInsumo.setText("Insumo");
        rdoInsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoInsumoActionPerformed(evt);
            }
        });

        rdoTodosInsumos.setBackground(new java.awt.Color(255, 255, 204));
        grdoInsumos.add(rdoTodosInsumos);
        rdoTodosInsumos.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        rdoTodosInsumos.setText("Todos los insumos");
        rdoTodosInsumos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoTodosInsumosActionPerformed(evt);
            }
        });

        cboInsumos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(rdoInsumo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboInsumos, 0, 203, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(rdoTodosInsumos)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoInsumo)
                    .addComponent(cboInsumos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rdoTodosInsumos)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jToolBar3.setBackground(new java.awt.Color(255, 255, 204));
        jToolBar3.setFloatable(false);
        jToolBar3.setRollover(true);

        btnFiltrar.setBackground(new java.awt.Color(255, 255, 204));
        btnFiltrar.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        btnFiltrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/[Boton] Buscar 2.png"))); // NOI18N
        btnFiltrar.setToolTipText("Filtrar");
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });
        jToolBar3.add(btnFiltrar);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tbl, javax.swing.GroupLayout.DEFAULT_SIZE, 694, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                        .addGap(542, 542, 542)
                        .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jToolBar3, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jToolBar3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(tbl, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(4, 4, 4))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        FrmPlatilloAgregar objFrm = new FrmPlatilloAgregar(null, true);
        objFrm.setTitle("Registrar nuevo platillo");
        objFrm.setVisible(true);
        
        if (objFrm.accion == 1){ 
            rdoTodosInsumos.setSelected(true);
            rdoTodosArticulos.setSelected(true);
            listar();
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int fila = this.tblListado.getSelectedRow();
        if (fila < 0 ){
            Funciones.mensajeError("Para anular un platillo, primero debe seleccionarlo del listado", Funciones.NOMBRE_SOFTWARE);
            return;
        }
        int r = Funciones.mensajeConfirmacion("¿Está seguro de anular el platillo seleccionado?", "Confirme");
        
        if (r==1){
            return;
        }
        
        int numeroPlatillo = Integer.parseInt(this.tblListado.getValueAt(fila, 0).toString());
        try {
            Platillo objPlatillo = new Platillo();
            boolean resultado = objPlatillo.anular(numeroPlatillo);
            if (resultado){
                Funciones.mensajeInformacion("El platillo ha sido anulado correctamente", Funciones.NOMBRE_SOFTWARE);
                listar();
            }
            
        } catch (Exception e) {
            Funciones.mensajeError(e.getMessage(), "Error");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void tblListadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListadoMouseClicked
        
    }//GEN-LAST:event_tblListadoMouseClicked

    private void rdoInsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoInsumoActionPerformed
        if(rdoInsumo.isSelected()){
            cboInsumos.setEnabled(true);
        }
    }//GEN-LAST:event_rdoInsumoActionPerformed

    private void rdoTodosInsumosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoTodosInsumosActionPerformed
        if(rdoTodosInsumos.isSelected()){
            cboInsumos.setEnabled(false);
        }
    }//GEN-LAST:event_rdoTodosInsumosActionPerformed

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
        try {
            listar();
        } catch (Exception e) {
            Funciones.mensajeError(e.getMessage(), "Error");
        }
    }//GEN-LAST:event_btnFiltrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox cboArticulos;
    private javax.swing.JComboBox cboInsumos;
    private javax.swing.ButtonGroup grdoArticulos;
    private javax.swing.ButtonGroup grdoInsumos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JToolBar jToolBar3;
    private javax.swing.JRadioButton rdoArticulo;
    private javax.swing.JRadioButton rdoInsumo;
    private javax.swing.JRadioButton rdoTodosArticulos;
    private javax.swing.JRadioButton rdoTodosInsumos;
    private javax.swing.JScrollPane tbl;
    private javax.swing.JTable tblListado;
    // End of variables declaration//GEN-END:variables
}
