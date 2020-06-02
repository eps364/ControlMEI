package views.dialog;

import entity.product.Category;
import impl.ImplCategory;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import util.ControlPanel;

public class DialogCategory extends javax.swing.JDialog {

    private final DefaultTableModel model;
    private Category categoria;
    private ImplCategory crud;

    private int value;

    public DialogCategory(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        model = (DefaultTableModel) masterTable.getModel();
        updateTable();
        ControlPanel.borderLabel(jpnFields);
    }

    private void updateTable() {
        model.getDataVector().clear();
        crud = new ImplCategory();
        crud.findAll().forEach(c -> {
            model.addRow(new Object[]{
                c.getId(),
                c.getCategoria()

            });

        });

    }

    private void save() {
        try {
            int row = masterTable.getSelectedRow();
            int old = crud.findAll().size();

            categoria.setCategoria(fieldCategoria.getText().toUpperCase());
            if (fieldCategoria.getText().equals("")) {
                throw new IllegalArgumentException("categoria inválida.\nVerifique e tente novamente");
            }
            crud.save(categoria);

            updateTable();
            int size = crud.findAll().size();
            if (size > old) {
                row = size - 1;
                masterTable.setRowSelectionInterval(row, row);
            }
            if (masterTable.getSelectedRow() != -1) {
                this.modifRowTable(row);
                this.fields();
            }
            JOptionPane.showMessageDialog(rootPane, "Salvo com sucesso!");
        } catch (HeadlessException | IllegalArgumentException e) {

            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jpnFields = new javax.swing.JPanel();
        cmdNovo = new javax.swing.JButton();
        fieldCode = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        masterTable = new javax.swing.JTable();
        query = new javax.swing.JTextField();
        fieldCategoria = new javax.swing.JTextField();
        fieldClose = new javax.swing.JButton();
        cmdSalvar = new javax.swing.JButton();
        cmdDeletar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CADASTRAR CATEGORIA");
        setIconImage(new ImageIcon(getClass().getResource("/views/img/categoria.png")).getImage());
        setModal(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jpnFields.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cmdNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/img/new-cate.png"))); // NOI18N
        cmdNovo.setText("Novo");
        cmdNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdNovoActionPerformed(evt);
            }
        });

        fieldCode.setBackground(new java.awt.Color(240, 240, 240));
        fieldCode.setEnabled(false);
        fieldCode.setFocusable(false);

        masterTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "DESCRICAO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        masterTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                masterTableMouseClicked(evt);
            }
        });
        masterTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                masterTableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(masterTable);
        if (masterTable.getColumnModel().getColumnCount() > 0) {
            masterTable.getColumnModel().getColumn(0).setMinWidth(30);
            masterTable.getColumnModel().getColumn(0).setPreferredWidth(50);
            masterTable.getColumnModel().getColumn(0).setMaxWidth(70);
            masterTable.getColumnModel().getColumn(1).setMinWidth(90);
            masterTable.getColumnModel().getColumn(1).setPreferredWidth(300);
            masterTable.getColumnModel().getColumn(1).setMaxWidth(410);
        }

        query.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                queryKeyReleased(evt);
            }
        });

        fieldCategoria.setEnabled(false);
        fieldCategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldCategoriaKeyPressed(evt);
            }
        });

        fieldClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/img/power.png"))); // NOI18N
        fieldClose.setText("Sair");
        fieldClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldCloseActionPerformed(evt);
            }
        });

        cmdSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/img/save-cate.png"))); // NOI18N
        cmdSalvar.setText("Salvar");
        cmdSalvar.setEnabled(false);
        cmdSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSalvarActionPerformed(evt);
            }
        });
        cmdSalvar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmdSalvarKeyPressed(evt);
            }
        });

        cmdDeletar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/img/delete-cate.png"))); // NOI18N
        cmdDeletar.setText("Deletar");
        cmdDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdDeletarActionPerformed(evt);
            }
        });

        jLabel4.setText("Código:");

        jLabel1.setText("Categoria:");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/img/reflesh.png"))); // NOI18N
        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/img/lupa.png"))); // NOI18N

        javax.swing.GroupLayout jpnFieldsLayout = new javax.swing.GroupLayout(jpnFields);
        jpnFields.setLayout(jpnFieldsLayout);
        jpnFieldsLayout.setHorizontalGroup(
            jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnFieldsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fieldCategoria)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnFieldsLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(fieldClose))
                    .addGroup(jpnFieldsLayout.createSequentialGroup()
                        .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(fieldCode, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jpnFieldsLayout.createSequentialGroup()
                                .addComponent(cmdNovo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmdSalvar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmdDeletar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1))
                            .addGroup(jpnFieldsLayout.createSequentialGroup()
                                .addComponent(query, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jpnFieldsLayout.setVerticalGroup(
            jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnFieldsLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(query, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdNovo)
                    .addComponent(cmdSalvar)
                    .addComponent(cmdDeletar)
                    .addComponent(fieldClose)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnFields, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnFields, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void masterTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_masterTableMouseClicked
        this.fields();
        this.enableFields(true);


    }//GEN-LAST:event_masterTableMouseClicked


    private void queryKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_queryKeyReleased
        try {
            String querys = query.getText().toUpperCase();
            TableRowSorter<DefaultTableModel> filter = new TableRowSorter<>(model);
            masterTable.setRowSorter(filter);
            filter.setRowFilter(RowFilter.regexFilter(querys));
        } catch (Exception e) {
            System.out.print("error:\n" + e.getMessage());
        }
    }//GEN-LAST:event_queryKeyReleased

    private void fieldCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_fieldCloseActionPerformed

    private void cmdNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdNovoActionPerformed
        fieldCategoria.requestFocus();
        this.enableFields(true);
        categoria = new Category();
        ControlPanel.clean(jpnFields);
    }//GEN-LAST:event_cmdNovoActionPerformed

    private void cmdDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdDeletarActionPerformed

        if (masterTable.getSelectedRow() != -1) {
            int row = masterTable.getSelectedRow();
            int size = crud.findAll().size();
            value = (int) masterTable.getValueAt(masterTable.getSelectedRow(), 0);
            crud.delete(Category.class, value);
            int sizeIndex = crud.findAll().size();
            if (size > sizeIndex) {
                model.removeRow(row);
            }

            int count = masterTable.getRowCount();
            if (count > row) {
                masterTable.setRowSelectionInterval(row, row);
            } else if (masterTable.getRowCount() > 0) {
                row -= 1;
                masterTable.setRowSelectionInterval(row, row);

            }
            fields();

        }
    }//GEN-LAST:event_cmdDeletarActionPerformed

    private void cmdSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSalvarActionPerformed

        this.save();


    }//GEN-LAST:event_cmdSalvarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        ControlPanel.clean(jpnFields);
        this.enableFields(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cmdSalvarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmdSalvarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.save();
        }
    }//GEN-LAST:event_cmdSalvarKeyPressed

    private void masterTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_masterTableKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_UP || evt.getKeyCode() == KeyEvent.VK_DOWN) {
            int row = masterTable.getSelectedRow();
            this.modifRowTable(row);
            fields();
        }
    }//GEN-LAST:event_masterTableKeyReleased

    private void fieldCategoriaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldCategoriaKeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            cmdSalvar.requestFocus();
        }
    }//GEN-LAST:event_fieldCategoriaKeyPressed

    private void enableFields(boolean is) {

        fieldCode.setEnabled(is);
        fieldCategoria.setEnabled(is);
        cmdSalvar.setEnabled(is);

    }

    private void modifRowTable(int row) {
        if (masterTable.getSelectedRow() != -1) {
            masterTable.setRowSelectionInterval(row, row);

        }
    }

    private void fields() {
        if (masterTable.getSelectedRow() != -1) {
            value = (int) masterTable.getValueAt(masterTable.getSelectedRow(), 0);
            int row = masterTable.getSelectedRow();
            this.modifRowTable(row);
            categoria = crud.find(Category.class, value);
            fieldCode.setText(String.valueOf(categoria.getId()));
            fieldCategoria.setText(categoria.getCategoria());
        }
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogCategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            DialogCategory dialog = new DialogCategory(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
//                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdDeletar;
    private javax.swing.JButton cmdNovo;
    private javax.swing.JButton cmdSalvar;
    private javax.swing.JTextField fieldCategoria;
    private javax.swing.JButton fieldClose;
    private javax.swing.JTextField fieldCode;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpnFields;
    private javax.swing.JTable masterTable;
    private javax.swing.JTextField query;
    // End of variables declaration//GEN-END:variables
}
