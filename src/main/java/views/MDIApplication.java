package views;

import java.awt.Dimension;
import java.beans.PropertyVetoException;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import views.dialog.DialogCategory;
import views.dialog.DialogBrand;
import views.dialog.DialogMeasure;
import views.dialog.DialogSection;
import views.dialog.config.Config;

public class MDIApplication extends javax.swing.JFrame {

    public MDIApplication() {
//        factory.Generic.Factory();

        initComponents();
//        Configuration.Config();
    }

    private void updateScreen(JInternalFrame frame) {
        Dimension d = desktopPane.getSize();
        for (JInternalFrame f : desktopPane.getAllFrames()) {

            if (f.getClass().equals(frame.getClass())) {
                f.toFront();

                try {
                    f.setSelected(true);
                    if (!frame.isIcon()) {
                        f.setIcon(false);
                    }
                } catch (PropertyVetoException e) {
                    System.out.println(e.getMessage());
                }
                return;
            }
        }

        desktopPane.add(frame);
        int heifht = (d.height - frame.getHeight()) / 2;
        int widht = (d.width - frame.getWidth()) / 2;
        frame.setLocation(widht, heifht);
        frame.setVisible(true);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator7 = new javax.swing.JSeparator();
        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenu2 = new javax.swing.JMenu();
        itemCategoria = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        itemMarca = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        itemMedida = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        itemProduto = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        itemSecao = new javax.swing.JMenuItem();
        jSeparator10 = new javax.swing.JPopupMenu.Separator();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenu1 = new javax.swing.JMenu();
        jSeparator12 = new javax.swing.JPopupMenu.Separator();
        itemCPF = new javax.swing.JMenuItem();
        jSeparator11 = new javax.swing.JPopupMenu.Separator();
        itemCNPJ = new javax.swing.JMenuItem();
        jSeparator13 = new javax.swing.JPopupMenu.Separator();
        itemFuncionario = new javax.swing.JMenuItem();
        jSeparator14 = new javax.swing.JPopupMenu.Separator();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        itemExit = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        editMenu = new javax.swing.JMenu();
        itemEntradaMercadoria = new javax.swing.JMenuItem();
        itemSaidaMercadoria = new javax.swing.JMenuItem();
        itemDespesa = new javax.swing.JMenuItem();
        itemServico = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        itemSistema = new javax.swing.JMenuItem();
        itemAjuda = new javax.swing.JMenuItem();
        moveMenu = new javax.swing.JMenu();
        itemCompra = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Linecode:: ControlMEI");
        setIconImage(new ImageIcon(getClass().getResource("/img/icon.png")).getImage());

        fileMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cadastrar.png"))); // NOI18N
        fileMenu.setMnemonic('f');
        fileMenu.setText("Cadastro de...");
        fileMenu.setToolTipText("");
        fileMenu.add(jSeparator2);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/produto.png"))); // NOI18N
        jMenu2.setText("Produto");

        itemCategoria.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        itemCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/categoria.png"))); // NOI18N
        itemCategoria.setText("Categoria");
        itemCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCategoriaActionPerformed(evt);
            }
        });
        jMenu2.add(itemCategoria);
        jMenu2.add(jSeparator5);

        itemMarca.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        itemMarca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon-marca.png"))); // NOI18N
        itemMarca.setText("Marca");
        itemMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMarcaActionPerformed(evt);
            }
        });
        jMenu2.add(itemMarca);
        jMenu2.add(jSeparator6);

        itemMedida.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        itemMedida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/medida.png"))); // NOI18N
        itemMedida.setText("Medida");
        itemMedida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMedidaActionPerformed(evt);
            }
        });
        jMenu2.add(itemMedida);
        jMenu2.add(jSeparator8);

        itemProduto.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        itemProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/produto.png"))); // NOI18N
        itemProduto.setMnemonic('s');
        itemProduto.setText("Produto");
        itemProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemProdutoActionPerformed(evt);
            }
        });
        jMenu2.add(itemProduto);
        jMenu2.add(jSeparator9);

        itemSecao.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        itemSecao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/secao.png"))); // NOI18N
        itemSecao.setText("Seção");
        itemSecao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSecaoActionPerformed(evt);
            }
        });
        jMenu2.add(itemSecao);
        jMenu2.add(jSeparator10);

        fileMenu.add(jMenu2);
        fileMenu.add(jSeparator1);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/person.png"))); // NOI18N
        jMenu1.setText("Pessoa");
        jMenu1.add(jSeparator12);

        itemCPF.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        itemCPF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cpf.png"))); // NOI18N
        itemCPF.setText("Física");
        itemCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCPFActionPerformed(evt);
            }
        });
        jMenu1.add(itemCPF);
        jMenu1.add(jSeparator11);

        itemCNPJ.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_J, java.awt.event.InputEvent.CTRL_MASK));
        itemCNPJ.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cnpj.png"))); // NOI18N
        itemCNPJ.setMnemonic('o');
        itemCNPJ.setText("Jurídica");
        itemCNPJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCNPJActionPerformed(evt);
            }
        });
        jMenu1.add(itemCNPJ);
        jMenu1.add(jSeparator13);

        itemFuncionario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        itemFuncionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/employer.png"))); // NOI18N
        itemFuncionario.setMnemonic('a');
        itemFuncionario.setText("Funcionário");
        jMenu1.add(itemFuncionario);
        jMenu1.add(jSeparator14);

        fileMenu.add(jMenu1);
        fileMenu.add(jSeparator3);

        itemExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        itemExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/power.png"))); // NOI18N
        itemExit.setMnemonic('x');
        itemExit.setText("Sair");
        itemExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemExitActionPerformed(evt);
            }
        });
        fileMenu.add(itemExit);
        fileMenu.add(jSeparator4);

        menuBar.add(fileMenu);

        editMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/report.png"))); // NOI18N
        editMenu.setMnemonic('e');
        editMenu.setText("Relatórios");

        itemEntradaMercadoria.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.SHIFT_MASK));
        itemEntradaMercadoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/rigth.png"))); // NOI18N
        itemEntradaMercadoria.setMnemonic('t');
        itemEntradaMercadoria.setText("Entrada de Mercadoria");
        editMenu.add(itemEntradaMercadoria);

        itemSaidaMercadoria.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK));
        itemSaidaMercadoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/left.png"))); // NOI18N
        itemSaidaMercadoria.setMnemonic('y');
        itemSaidaMercadoria.setText("Saída de Mercadoria");
        itemSaidaMercadoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSaidaMercadoriaActionPerformed(evt);
            }
        });
        editMenu.add(itemSaidaMercadoria);

        itemDespesa.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.SHIFT_MASK));
        itemDespesa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/despesa.png"))); // NOI18N
        itemDespesa.setMnemonic('p');
        itemDespesa.setText("Despesas");
        editMenu.add(itemDespesa);

        itemServico.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        itemServico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/services.png"))); // NOI18N
        itemServico.setMnemonic('d');
        itemServico.setText("Serviços");
        editMenu.add(itemServico);

        menuBar.add(editMenu);

        helpMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/help.png"))); // NOI18N
        helpMenu.setMnemonic('h');
        helpMenu.setText("Sobre...");

        itemSistema.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        itemSistema.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/config.png"))); // NOI18N
        itemSistema.setMnemonic('c');
        itemSistema.setText("Sistema");
        itemSistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSistemaActionPerformed(evt);
            }
        });
        helpMenu.add(itemSistema);

        itemAjuda.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        itemAjuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/help-item.png"))); // NOI18N
        itemAjuda.setMnemonic('a');
        itemAjuda.setText("Ajuda");
        helpMenu.add(itemAjuda);

        menuBar.add(helpMenu);

        moveMenu.setText("Movimentação");

        itemCompra.setText("Vender");
        itemCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCompraActionPerformed(evt);
            }
        });
        moveMenu.add(itemCompra);

        menuBar.add(moveMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void itemExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_itemExitActionPerformed

    private void itemProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemProdutoActionPerformed
        updateScreen(new InternalProduct());
    }//GEN-LAST:event_itemProdutoActionPerformed

    private void itemSaidaMercadoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSaidaMercadoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemSaidaMercadoriaActionPerformed

    private void itemCNPJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCNPJActionPerformed
        updateScreen(new InternalCompany());
    }//GEN-LAST:event_itemCNPJActionPerformed

    private void itemCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCPFActionPerformed
        updateScreen(new InternalCostumer());
    }//GEN-LAST:event_itemCPFActionPerformed

    private void itemCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCategoriaActionPerformed
        DialogCategory.main(null);
    }//GEN-LAST:event_itemCategoriaActionPerformed

    private void itemMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMarcaActionPerformed
        DialogBrand.main(null);
    }//GEN-LAST:event_itemMarcaActionPerformed

    private void itemMedidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMedidaActionPerformed
        DialogMeasure.main(null);
    }//GEN-LAST:event_itemMedidaActionPerformed

    private void itemSecaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSecaoActionPerformed
        DialogSection.main(null);
    }//GEN-LAST:event_itemSecaoActionPerformed

    private void itemSistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSistemaActionPerformed
        Config.main(null);
    }//GEN-LAST:event_itemSistemaActionPerformed

    private void itemCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCompraActionPerformed
        this.updateScreen(new InternalSale());
    }//GEN-LAST:event_itemCompraActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {

                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MDIApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new MDIApplication().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenuItem itemAjuda;
    private javax.swing.JMenuItem itemCNPJ;
    private javax.swing.JMenuItem itemCPF;
    private javax.swing.JMenuItem itemCategoria;
    private javax.swing.JMenuItem itemCompra;
    private javax.swing.JMenuItem itemDespesa;
    private javax.swing.JMenuItem itemEntradaMercadoria;
    private javax.swing.JMenuItem itemExit;
    private javax.swing.JMenuItem itemFuncionario;
    private javax.swing.JMenuItem itemMarca;
    private javax.swing.JMenuItem itemMedida;
    private javax.swing.JMenuItem itemProduto;
    private javax.swing.JMenuItem itemSaidaMercadoria;
    private javax.swing.JMenuItem itemSecao;
    private javax.swing.JMenuItem itemServico;
    private javax.swing.JMenuItem itemSistema;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator10;
    private javax.swing.JPopupMenu.Separator jSeparator11;
    private javax.swing.JPopupMenu.Separator jSeparator12;
    private javax.swing.JPopupMenu.Separator jSeparator13;
    private javax.swing.JPopupMenu.Separator jSeparator14;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JPopupMenu.Separator jSeparator9;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu moveMenu;
    // End of variables declaration//GEN-END:variables

}
