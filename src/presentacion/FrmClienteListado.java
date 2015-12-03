package presentacion;

import java.awt.Dimension;
import java.sql.ResultSet;
import logica.Cliente;
import util.Funciones;

public class FrmClienteListado extends javax.swing.JInternalFrame {

    private ResultSet resultado;
    
    public FrmClienteListado() {
        initComponents();
        this.setLocation(250, 60);
        cargarCamposBusqueda();
        cargarTabla();
        listar();
    }
    private void cargarCamposBusqueda(){
        String campos[] = new Cliente().obtenerCamposFiltro();
        
        cboBusqueda.removeAllItems();
        for (int i = 0; i < campos.length; i++) {
            cboBusqueda.addItem( campos[i] );
        }
    }
    
    private void cargarTabla(){
        try {
            this.resultado = new Cliente().listar();
        } catch (Exception e) {
            Funciones.mensajeError(e.getMessage(), Funciones.NOMBRE_SOFTWARE);
        }
    }
    
    private void listar(){
        try {
            String alineacion[] = {"C","C","C","C","C","C","C","C","C"};
            int anchoColumnas[] = {100,100,100,100,100,100,100,100,100};
            
            Funciones.llenarTablaBusqueda(
                    tblListado, 
                    resultado, //Resultset
                    anchoColumnas, 
                    alineacion, 
                    this.cboBusqueda.getSelectedItem().toString(), 
                    this.txtValorBusqueda.getText());
            
        } catch (Exception e) {
            Funciones.mensajeError(e.getMessage(), Funciones.NOMBRE_SOFTWARE);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        tbOpciones = new javax.swing.JToolBar();
        jLabel2 = new javax.swing.JLabel();
        cboBusqueda = new javax.swing.JComboBox();
        txtValorBusqueda = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnAgregar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btnEditar = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        btnEliminar = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        btnRefrescar = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        btnSalir = new javax.swing.JButton();
        tbl = new javax.swing.JScrollPane();
        tblListado = new javax.swing.JTable()
        {
            public boolean isCellEditable(int fila, int columna){
                return false;
            }
        }
        ;

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Listado de clientes");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/[Cabecera] Clientes.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));

        jPanel3.setBackground(new java.awt.Color(255, 255, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "BÚSQUEDA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 1, 12), new java.awt.Color(51, 51, 51))); // NOI18N

        tbOpciones.setBackground(new java.awt.Color(255, 255, 204));
        tbOpciones.setFloatable(false);
        tbOpciones.setRollover(true);

        jLabel2.setBackground(new java.awt.Color(255, 255, 204));
        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        jLabel2.setText("Buscar:");
        tbOpciones.add(jLabel2);

        cboBusqueda.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        cboBusqueda.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Item 1", "Item 2", "Item 3", "Item 4" }));
        tbOpciones.add(cboBusqueda);

        txtValorBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorBusquedaActionPerformed(evt);
            }
        });
        txtValorBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtValorBusquedaKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtValorBusquedaKeyReleased(evt);
            }
        });
        tbOpciones.add(txtValorBusqueda);
        tbOpciones.add(jSeparator1);

        btnAgregar.setBackground(new java.awt.Color(255, 255, 204));
        btnAgregar.setFont(new java.awt.Font("Trebuchet MS", 1, 11)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/[Boton] Añadir.png"))); // NOI18N
        btnAgregar.setToolTipText("Agregar");
        btnAgregar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        tbOpciones.add(btnAgregar);
        tbOpciones.add(jSeparator2);

        btnEditar.setBackground(new java.awt.Color(255, 255, 204));
        btnEditar.setFont(new java.awt.Font("Trebuchet MS", 1, 11)); // NOI18N
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/[Boton] Editarr.png"))); // NOI18N
        btnEditar.setToolTipText("Editar");
        btnEditar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        tbOpciones.add(btnEditar);
        tbOpciones.add(jSeparator3);

        btnEliminar.setBackground(new java.awt.Color(255, 255, 204));
        btnEliminar.setFont(new java.awt.Font("Trebuchet MS", 1, 11)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/[Boton] Eliminar todo.png"))); // NOI18N
        btnEliminar.setToolTipText("Eliminar");
        btnEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        tbOpciones.add(btnEliminar);
        tbOpciones.add(jSeparator4);

        btnRefrescar.setBackground(new java.awt.Color(255, 255, 204));
        btnRefrescar.setFont(new java.awt.Font("Trebuchet MS", 1, 11)); // NOI18N
        btnRefrescar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/[Boton] Actualizar.png"))); // NOI18N
        btnRefrescar.setToolTipText("Actualizar");
        btnRefrescar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnRefrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefrescarActionPerformed(evt);
            }
        });
        tbOpciones.add(btnRefrescar);
        tbOpciones.add(jSeparator5);

        btnSalir.setBackground(new java.awt.Color(255, 255, 204));
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/[Boton] Salir.png"))); // NOI18N
        btnSalir.setToolTipText("Salir");
        btnSalir.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        tbOpciones.add(btnSalir);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tbOpciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(tbOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tbl, javax.swing.GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tbl, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtValorBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorBusquedaActionPerformed

    private void txtValorBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorBusquedaKeyReleased
        listar();
    }//GEN-LAST:event_txtValorBusquedaKeyReleased

    private void txtValorBusquedaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorBusquedaKeyTyped

    }//GEN-LAST:event_txtValorBusquedaKeyTyped

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        FrmClienteAgregarEditar obj = new FrmClienteAgregarEditar(null, true);
        obj.setTitle("Agregar un cliente");
        obj.setVisible(true);
        
        if (obj.accion == 1){ //hizo clic en grabar
            try {
                String tipo = null;
                String convenio = null;
                Cliente objC = new Cliente();
                objC.setDni(obj.txtDNI.getText() );
                objC.setNombre_completo(obj.txtNombreCompleto.getText());
                objC.setRuc(obj.txtRUC.getText());
                objC.setRazon_social(obj.txtEmpresa.getText());
                objC.setTelefono(obj.txtTelefono.getText());
                objC.setEmail(obj.txtEmail.getText());
                if(obj.rdoEmpresa.isSelected()){
                    tipo = "E";
                }else{
                    tipo = "N";
                }
                if(obj.chkConvenio.isSelected()){
                    convenio = "S";
                }else{
                    convenio = "N";
                }
                objC.setTipo_cliente(tipo);
                objC.setConvenio(convenio);
                
                if (objC.agregar()){
                    this.cargarTabla();
                    this.listar();
                }
            } catch (Exception e) {
                Funciones.mensajeError(
                        e.getMessage(), 
                        Funciones.NOMBRE_SOFTWARE
                );
            }
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int fila = this.tblListado.getSelectedRow();
        if (fila < 0 ){
            Funciones.mensajeError(
                    "Debe seleccionar una fila", 
                    Funciones.NOMBRE_SOFTWARE
                );
            return;
        }
        
        int codigo =Integer.parseInt(this.tblListado.getValueAt(fila, 0).toString());
        
        Cliente objC = new Cliente();
        
        try {
            ResultSet resultado = objC.leerDatos(codigo);
            if (resultado.next()){
                FrmClienteAgregarEditar objFrm = new FrmClienteAgregarEditar(null, true);
                objFrm.setTitle("Editar");
                objFrm.txtCodigo.setText(String.valueOf( resultado.getInt("codigo_cliente")));
                objFrm.txtDNI.setText(resultado.getString("dni"));                
                objFrm.txtNombreCompleto.setText(resultado.getString("nombre_completo"));
                objFrm.txtRUC.setText(resultado.getString("ruc"));
                objFrm.txtEmpresa.setText(resultado.getString("razon_social"));
                objFrm.txtTelefono.setText(resultado.getString("telefono"));
                objFrm.txtEmail.setText(resultado.getString("email"));
                if(resultado.getString("tipo_cliente").equalsIgnoreCase("E")){
                    objFrm.rdoEmpresa.setSelected(true);
                    objFrm.rdoPersonaNatural.setSelected(false);
                    objFrm.txtRUC.setEnabled(false);
                    objFrm.txtEmpresa.setEnabled(false);
                }else{
                    objFrm.rdoPersonaNatural.setSelected(true);
                    objFrm.rdoEmpresa.setSelected(false);
                    objFrm.txtDNI.setEnabled(false);
                    objFrm.txtNombreCompleto.setEnabled(false);
                }
                if(resultado.getString("convenio").equalsIgnoreCase("S")){
                    objFrm.chkConvenio.setSelected(true);
                }else{
                    objFrm.chkConvenio.setSelected(false);
                }
                objFrm.setVisible(true);
                
                if (objFrm.accion == 1){
                    Cliente obj = new Cliente();
                    obj.setCodigo_cliente(Integer.parseInt( objFrm.txtCodigo.getText()));
                    obj.setDni(objFrm.txtDNI.getText());
                    obj.setNombre_completo(objFrm.txtNombreCompleto.getText());
                    obj.setRuc(objFrm.txtRUC.getText());
                    obj.setRazon_social(objFrm.txtEmpresa.getText());
                    obj.setTelefono(objFrm.txtTelefono.getText());
                    obj.setEmail(objFrm.txtEmail.getText());
                    if(objFrm.rdoEmpresa.isSelected()){
                        obj.setTipo_cliente("E");
                    }else{
                        obj.setTipo_cliente("N");
                    }
                    if(objFrm.chkConvenio.isSelected()){
                        obj.setConvenio("S");
                    }else{
                        obj.setConvenio("N");
                    }

                    if (objC.editar()){
                        this.cargarTabla();
                        this.listar();
                    }
                }
                
            }   
            
        } catch (Exception e) {
            Funciones.mensajeError(
                    e.getMessage(), 
                    Funciones.NOMBRE_SOFTWARE
            );
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int fila = this.tblListado.getSelectedRow();
        if (fila < 0 ){
            Funciones.mensajeError(
                    "Debe seleccionar una fila", 
                    Funciones.NOMBRE_SOFTWARE
                );
            return;
        }
        
        int codigo =Integer.parseInt(this.tblListado.getValueAt(fila, 0).toString());
        
        Cliente objC = new Cliente();
        
        int r = Funciones.mensajeConfirmacion(
                "Esta seguro de eliminar el registro seleccionado", 
                "Confirme"
            );
        if (r==0){ //si
            try {
                
                objC.setCodigo_cliente(codigo);
                
                if (objC.eliminar()){
                    this.cargarTabla();
                    this.listar();
                }
            } catch (Exception e) {
                Funciones.mensajeError(
                        e.getMessage(), 
                        Funciones.NOMBRE_SOFTWARE
                );
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnRefrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefrescarActionPerformed
        this.cargarTabla();
        this.listar();
    }//GEN-LAST:event_btnRefrescarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void tblListadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListadoMouseClicked
        if (evt.getClickCount()==2){
            this.btnEditar.doClick();
        }
    }//GEN-LAST:event_tblListadoMouseClicked

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        this.cboBusqueda.setPreferredSize( new Dimension(130, 25) );
        this.txtValorBusqueda.setPreferredSize( new Dimension(150, 25) );
        
        this.tbOpciones.add(cboBusqueda, 1);
        this.tbOpciones.add(txtValorBusqueda, 2);
    }//GEN-LAST:event_formInternalFrameActivated

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnRefrescar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox cboBusqueda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar tbOpciones;
    private javax.swing.JScrollPane tbl;
    private javax.swing.JTable tblListado;
    private javax.swing.JTextField txtValorBusqueda;
    // End of variables declaration//GEN-END:variables
}
