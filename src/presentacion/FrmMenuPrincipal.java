package presentacion;
import util.Funciones;
import util.ImagenFondo;

public class FrmMenuPrincipal extends javax.swing.JFrame {

    public FrmMenuPrincipal() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        this.setTitle( Funciones.NOMBRE_SOFTWARE + " - [ Menú Principal ]" );
//        this.lblUsuario.setText( Funciones.USUARIO_LOGUEADO );
//        this.lblSucursal.setText(Funciones.SUCURSAL_SELECCIONADA);
        this.dpContenedor.setBorder( new ImagenFondo("centrado") );
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dpContenedor = new javax.swing.JDesktopPane();
        jToolBar2 = new javax.swing.JToolBar();
        btnProductos = new javax.swing.JButton();
        jSeparator11 = new javax.swing.JToolBar.Separator();
        btnProveedores = new javax.swing.JButton();
        btnClientes = new javax.swing.JButton();
        jSeparator10 = new javax.swing.JToolBar.Separator();
        btnCompras = new javax.swing.JButton();
        btnVentas = new javax.swing.JButton();
        jSeparator9 = new javax.swing.JToolBar.Separator();
        btnSalir = new javax.swing.JButton();
        jToolBar1 = new javax.swing.JToolBar();
        jLabel1 = new javax.swing.JLabel();
        jSeparator13 = new javax.swing.JToolBar.Separator();
        lblUsuario = new javax.swing.JLabel();
        jSeparator14 = new javax.swing.JToolBar.Separator();
        lblSucursal = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jSeparator12 = new javax.swing.JPopupMenu.Separator();
        MnuProductos = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        MnuProveedores = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        MnuClientes = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        MnuEmpleados = new javax.swing.JMenuItem();
        MnuCargos = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        MnuSucursales = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        MnuMesas = new javax.swing.JMenuItem();
        MnuTiposComprobante = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        MnuSalir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        MnuRegistroCompras = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        MnuRegistrPlatillos = new javax.swing.JMenuItem();
        MnuRegistroPedidos = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        MnuRegistroVentas = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        dpContenedor.setBackground(new java.awt.Color(204, 204, 204));

        jToolBar2.setRollover(true);

        btnProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/[Icono menu] Articulo.png"))); // NOI18N
        btnProductos.setToolTipText("Mantenimiento de Productos");
        btnProductos.setFocusable(false);
        btnProductos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnProductos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductosActionPerformed(evt);
            }
        });
        jToolBar2.add(btnProductos);
        jToolBar2.add(jSeparator11);

        btnProveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/[Icono menu] Proveedor.png"))); // NOI18N
        btnProveedores.setToolTipText("Mantenimiento de Proveedores");
        btnProveedores.setFocusable(false);
        btnProveedores.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnProveedores.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProveedoresActionPerformed(evt);
            }
        });
        jToolBar2.add(btnProveedores);

        btnClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/[Icono menu] Cliente.png"))); // NOI18N
        btnClientes.setToolTipText("Mantenimiento de Clientes");
        btnClientes.setFocusable(false);
        btnClientes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnClientes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesActionPerformed(evt);
            }
        });
        jToolBar2.add(btnClientes);
        jToolBar2.add(jSeparator10);

        btnCompras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/[Icono menu] Compra.png"))); // NOI18N
        btnCompras.setToolTipText("Registro de compras");
        btnCompras.setFocusable(false);
        btnCompras.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCompras.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprasActionPerformed(evt);
            }
        });
        jToolBar2.add(btnCompras);

        btnVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/[Icono Menu] Venta 3.png"))); // NOI18N
        btnVentas.setToolTipText("Registro de ventas");
        btnVentas.setFocusable(false);
        btnVentas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnVentas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentasActionPerformed(evt);
            }
        });
        jToolBar2.add(btnVentas);
        jToolBar2.add(jSeparator9);

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
        jToolBar2.add(btnSalir);

        javax.swing.GroupLayout dpContenedorLayout = new javax.swing.GroupLayout(dpContenedor);
        dpContenedor.setLayout(dpContenedorLayout);
        dpContenedorLayout.setHorizontalGroup(
            dpContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE)
        );
        dpContenedorLayout.setVerticalGroup(
            dpContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dpContenedorLayout.createSequentialGroup()
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 331, Short.MAX_VALUE))
        );
        dpContenedor.setLayer(jToolBar2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/[Menu bar] Bienvenido.png"))); // NOI18N
        jLabel1.setText("Bienvenido");
        jToolBar1.add(jLabel1);
        jToolBar1.add(jSeparator13);

        lblUsuario.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        lblUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/[Menu bar] Usuario.png"))); // NOI18N
        lblUsuario.setText("Usuario:");
        jToolBar1.add(lblUsuario);
        jToolBar1.add(jSeparator14);

        lblSucursal.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        lblSucursal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/[Menu bar] Sucursales.png"))); // NOI18N
        lblSucursal.setText("Sucursal:");
        jToolBar1.add(lblSucursal);

        jMenu1.setText("Archivo");
        jMenu1.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N

        jMenuItem5.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/[Icono menu] Almacen.png"))); // NOI18N
        jMenuItem5.setText("Almacén");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);
        jMenu1.add(jSeparator12);

        MnuProductos.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        MnuProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/[Icono menu] Articulo.png"))); // NOI18N
        MnuProductos.setText("Productos");
        MnuProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnuProductosActionPerformed(evt);
            }
        });
        jMenu1.add(MnuProductos);
        jMenu1.add(jSeparator4);

        MnuProveedores.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        MnuProveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/[Icono menu] Proveedor 2.png"))); // NOI18N
        MnuProveedores.setText("Proveedores");
        MnuProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnuProveedoresActionPerformed(evt);
            }
        });
        jMenu1.add(MnuProveedores);
        jMenu1.add(jSeparator5);

        MnuClientes.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        MnuClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/[Icono menu] Cliente.png"))); // NOI18N
        MnuClientes.setText("Clientes");
        MnuClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnuClientesActionPerformed(evt);
            }
        });
        jMenu1.add(MnuClientes);
        jMenu1.add(jSeparator6);

        MnuEmpleados.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        MnuEmpleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/[Icono menu] Empleado.png"))); // NOI18N
        MnuEmpleados.setText("Empleados");
        MnuEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnuEmpleadosActionPerformed(evt);
            }
        });
        jMenu1.add(MnuEmpleados);

        MnuCargos.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        MnuCargos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/[Icono menu] Proveedor.png"))); // NOI18N
        MnuCargos.setText("Cargos");
        MnuCargos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnuCargosActionPerformed(evt);
            }
        });
        jMenu1.add(MnuCargos);
        jMenu1.add(jSeparator7);

        MnuSucursales.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        MnuSucursales.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/[Icono menu] Sucursal.png"))); // NOI18N
        MnuSucursales.setText("Sucursales");
        MnuSucursales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnuSucursalesActionPerformed(evt);
            }
        });
        jMenu1.add(MnuSucursales);
        jMenu1.add(jSeparator8);

        MnuMesas.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        MnuMesas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/[Icono menu] Mesa.png"))); // NOI18N
        MnuMesas.setText("Mesas");
        MnuMesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnuMesasActionPerformed(evt);
            }
        });
        jMenu1.add(MnuMesas);

        MnuTiposComprobante.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        MnuTiposComprobante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/[Icono menu] Tipo comprobantes.png"))); // NOI18N
        MnuTiposComprobante.setText("Tipos de comprobante");
        MnuTiposComprobante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnuTiposComprobanteActionPerformed(evt);
            }
        });
        jMenu1.add(MnuTiposComprobante);
        jMenu1.add(jSeparator3);

        MnuSalir.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        MnuSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/[Boton] Salir.png"))); // NOI18N
        MnuSalir.setText("Salir");
        MnuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnuSalirActionPerformed(evt);
            }
        });
        jMenu1.add(MnuSalir);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Movimientos");
        jMenu2.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N

        MnuRegistroCompras.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        MnuRegistroCompras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/[Icono menu] Compra.png"))); // NOI18N
        MnuRegistroCompras.setText("Registro de compras");
        MnuRegistroCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnuRegistroComprasActionPerformed(evt);
            }
        });
        jMenu2.add(MnuRegistroCompras);
        jMenu2.add(jSeparator1);

        MnuRegistrPlatillos.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        MnuRegistrPlatillos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/[Icono menu] Platillo.png"))); // NOI18N
        MnuRegistrPlatillos.setText("Registro de platillos");
        MnuRegistrPlatillos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnuRegistrPlatillosActionPerformed(evt);
            }
        });
        jMenu2.add(MnuRegistrPlatillos);

        MnuRegistroPedidos.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        MnuRegistroPedidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/[Icono menu] Pedido.png"))); // NOI18N
        MnuRegistroPedidos.setText("Registro de pedidos");
        MnuRegistroPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnuRegistroPedidosActionPerformed(evt);
            }
        });
        jMenu2.add(MnuRegistroPedidos);
        jMenu2.add(jSeparator2);

        MnuRegistroVentas.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        MnuRegistroVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/[Icono Menu] Venta 3.png"))); // NOI18N
        MnuRegistroVentas.setText("Registro de ventas");
        MnuRegistroVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnuRegistroVentasActionPerformed(evt);
            }
        });
        jMenu2.add(MnuRegistroVentas);

        jMenuBar1.add(jMenu2);

        jMenu4.setText("Reportes");
        jMenu4.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jMenuBar1.add(jMenu4);

        jMenu5.setText("Administración del Sistema");
        jMenu5.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N

        jMenuItem1.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/[Icono menu] Usuario.png"))); // NOI18N
        jMenuItem1.setText("Usuarios");
        jMenu5.add(jMenuItem1);

        jMenuItem2.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/[Icono menu] Sucursal.png"))); // NOI18N
        jMenuItem2.setText("Acceso a sucursales");
        jMenu5.add(jMenuItem2);

        jMenuItem3.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/[Icono menu] Cambiar contraseña 2.jpg"))); // NOI18N
        jMenuItem3.setText("Cambiar contraseña");
        jMenu5.add(jMenuItem3);

        jMenuBar1.add(jMenu5);

        jMenu6.setText("Ayuda");
        jMenu6.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N

        jMenuItem4.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/[Icono menu] Ayuda.png"))); // NOI18N
        jMenuItem4.setText("Acerca de");
        jMenu6.add(jMenuItem4);

        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dpContenedor)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(dpContenedor)
                .addGap(0, 0, 0)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MnuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnuSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_MnuSalirActionPerformed

    private void MnuProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnuProductosActionPerformed
        FrmProductoListado obj = new FrmProductoListado();
        dpContenedor.add(obj);
        obj.setVisible(true);
    }//GEN-LAST:event_MnuProductosActionPerformed

    private void btnProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductosActionPerformed
        FrmProductoListado obj = new FrmProductoListado();
        dpContenedor.add(obj);
        obj.setVisible(true);
    }//GEN-LAST:event_btnProductosActionPerformed

    private void MnuProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnuProveedoresActionPerformed
        FrmProveedorListado obj = new FrmProveedorListado();
        dpContenedor.add(obj);
        obj.setVisible(true);
    }//GEN-LAST:event_MnuProveedoresActionPerformed

    private void MnuClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnuClientesActionPerformed
        FrmClienteListado obj = new FrmClienteListado();
        dpContenedor.add(obj);
        obj.setVisible(true);
    }//GEN-LAST:event_MnuClientesActionPerformed

    private void MnuEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnuEmpleadosActionPerformed
        FrmEmpleadoListado obj = new FrmEmpleadoListado();
        dpContenedor.add(obj);
        obj.setVisible(true);
    }//GEN-LAST:event_MnuEmpleadosActionPerformed

    private void MnuCargosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnuCargosActionPerformed
        FrmCargoListado obj = new FrmCargoListado();
        dpContenedor.add(obj);
        obj.setVisible(true);
    }//GEN-LAST:event_MnuCargosActionPerformed

    private void MnuSucursalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnuSucursalesActionPerformed
        FrmSucursalListado obj = new FrmSucursalListado();
        dpContenedor.add(obj);
        obj.setVisible(true);
    }//GEN-LAST:event_MnuSucursalesActionPerformed

    private void MnuMesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnuMesasActionPerformed
        FrmMesaListado obj = new FrmMesaListado();
        dpContenedor.add(obj);
        obj.setVisible(true);
    }//GEN-LAST:event_MnuMesasActionPerformed

    private void MnuTiposComprobanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnuTiposComprobanteActionPerformed
        FrmTipoComprobanteListado obj = new FrmTipoComprobanteListado();
        dpContenedor.add(obj);
        obj.setVisible(true);
    }//GEN-LAST:event_MnuTiposComprobanteActionPerformed

    private void MnuRegistroComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnuRegistroComprasActionPerformed
        
    }//GEN-LAST:event_MnuRegistroComprasActionPerformed

    private void MnuRegistrPlatillosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnuRegistrPlatillosActionPerformed
        FrmPlatilloRegistro obj = new FrmPlatilloRegistro();
        dpContenedor.add(obj);
        obj.setVisible(true);
    }//GEN-LAST:event_MnuRegistrPlatillosActionPerformed

    private void MnuRegistroPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnuRegistroPedidosActionPerformed
        FrmPedidoListar obj = new FrmPedidoListar();
        dpContenedor.add(obj);
        obj.setVisible(true);
    }//GEN-LAST:event_MnuRegistroPedidosActionPerformed

    private void MnuRegistroVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnuRegistroVentasActionPerformed
        
    }//GEN-LAST:event_MnuRegistroVentasActionPerformed

    private void btnProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProveedoresActionPerformed
        FrmProveedorListado obj = new FrmProveedorListado();
        dpContenedor.add(obj);
        obj.setVisible(true);
    }//GEN-LAST:event_btnProveedoresActionPerformed

    private void btnComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprasActionPerformed
        
    }//GEN-LAST:event_btnComprasActionPerformed

    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed
        FrmClienteListado obj = new FrmClienteListado();
        dpContenedor.add(obj);
        obj.setVisible(true);
    }//GEN-LAST:event_btnClientesActionPerformed

    private void btnVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentasActionPerformed
        
    }//GEN-LAST:event_btnVentasActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        FrmAlmacenListado obj = new FrmAlmacenListado();
        dpContenedor.add(obj);
        obj.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem MnuCargos;
    private javax.swing.JMenuItem MnuClientes;
    private javax.swing.JMenuItem MnuEmpleados;
    private javax.swing.JMenuItem MnuMesas;
    private javax.swing.JMenuItem MnuProductos;
    private javax.swing.JMenuItem MnuProveedores;
    private javax.swing.JMenuItem MnuRegistrPlatillos;
    private javax.swing.JMenuItem MnuRegistroCompras;
    private javax.swing.JMenuItem MnuRegistroPedidos;
    private javax.swing.JMenuItem MnuRegistroVentas;
    private javax.swing.JMenuItem MnuSalir;
    private javax.swing.JMenuItem MnuSucursales;
    private javax.swing.JMenuItem MnuTiposComprobante;
    private javax.swing.JButton btnClientes;
    private javax.swing.JButton btnCompras;
    private javax.swing.JButton btnProductos;
    private javax.swing.JButton btnProveedores;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnVentas;
    private javax.swing.JDesktopPane dpContenedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator10;
    private javax.swing.JToolBar.Separator jSeparator11;
    private javax.swing.JPopupMenu.Separator jSeparator12;
    private javax.swing.JToolBar.Separator jSeparator13;
    private javax.swing.JToolBar.Separator jSeparator14;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JToolBar.Separator jSeparator9;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JLabel lblSucursal;
    private javax.swing.JLabel lblUsuario;
    // End of variables declaration//GEN-END:variables
}
