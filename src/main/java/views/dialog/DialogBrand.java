package views.dialog;

import entity.product.Brand;
import enu.ButtonEnum;
import impl.ImplBrand;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import util.ControlPanel;

public class DialogBrand extends javax.swing.JDialog {

    private final DefaultTableModel model;
    private Brand marca;
    private ImplBrand crud;

    private int value;

    public DialogBrand(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        model = (DefaultTableModel) masterTable.getModel();
        updateTable();
        ControlPanel.borderLabel(jpnFields);
    }

    private void updateTable() {
        model.getDataVector().clear();
        crud = new ImplBrand();
        crud.findAll().forEach(c -> {
            model.addRow(new Object[]{
                c.getId(),
                c.getBrand()

            });

        });

    }

    private void save() {
        try {
            int row = masterTable.getSelectedRow();
            int old = crud.findAll().size();

            marca.setMarca(fieldCategoria.getText().toUpperCase());
            if (fieldCategoria.getText().equals("")) {
                throw new IllegalArgumentException("categoria inválida.\nVerifique e tente novamente");
            }
            crud.save(marca);

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
            if (ControlPanel.optionPaneSave("Saved successfully!")) {
                cmdDisposeActionPerformed(null);
            }
        } catch (HeadlessException | IllegalArgumentException e) {

            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        } finally {
            this.setEnableField(ControlPanel.controlDialogButton(ButtonEnum.SAVE_BUTTON, cmdDelete, cmdNew, cmdSave));

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jpnFields = new javax.swing.JPanel();
        cmdNew = new javax.swing.JButton();
        fieldCode = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        masterTable = new javax.swing.JTable();
        query = new javax.swing.JTextField();
        fieldCategoria = new javax.swing.JTextField();
        cmdDispose = new javax.swing.JButton();
        cmdSave = new javax.swing.JButton();
        cmdDelete = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cmdCancel = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CADASTRAR MARCA");
        setIconImage(new ImageIcon(getClass().getResource("/img/icon-marca.png")).getImage());
        setModal(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jpnFields.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cmdNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/new-cate.png"))); // NOI18N
        cmdNew.setText("Novo");
        cmdNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdNewActionPerformed(evt);
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

        cmdDispose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/power.png"))); // NOI18N
        cmdDispose.setText("Sair");
        cmdDispose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdDisposeActionPerformed(evt);
            }
        });

        cmdSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save-cate.png"))); // NOI18N
        cmdSave.setText("Salvar");
        cmdSave.setEnabled(false);
        cmdSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSaveActionPerformed(evt);
            }
        });
        cmdSave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmdSaveKeyPressed(evt);
            }
        });

        cmdDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete-cate.png"))); // NOI18N
        cmdDelete.setText("Deletar");
        cmdDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdDeleteActionPerformed(evt);
            }
        });

        jLabel4.setText("Código:");

        jLabel1.setText("Marca:");

        cmdCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reflesh.png"))); // NOI18N
        cmdCancel.setText("Cancelar");
        cmdCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCancelActionPerformed(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lupa.png"))); // NOI18N

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
                        .addComponent(cmdDispose))
                    .addGroup(jpnFieldsLayout.createSequentialGroup()
                        .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(fieldCode, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jpnFieldsLayout.createSequentialGroup()
                                .addComponent(cmdNew)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmdSave)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmdDelete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmdCancel))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(query, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdNew)
                    .addComponent(cmdSave)
                    .addComponent(cmdDelete)
                    .addComponent(cmdDispose)
                    .addComponent(cmdCancel))
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
        this.setEnableField(ControlPanel.controlDialogButton(ButtonEnum.MASTER_TABLE, cmdDelete, cmdNew, cmdSave));


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

    private void cmdDisposeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdDisposeActionPerformed
        this.dispose();
    }//GEN-LAST:event_cmdDisposeActionPerformed

    private void cmdNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdNewActionPerformed
        fieldCategoria.requestFocus();
        this.setEnableField(ControlPanel.controlDialogButton(ButtonEnum.NEW_BUTTON, cmdDelete, cmdNew, cmdSave));
        marca = new Brand();
        ControlPanel.clean(jpnFields);
    }//GEN-LAST:event_cmdNewActionPerformed

    private void cmdDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdDeleteActionPerformed

        if (masterTable.getSelectedRow() != -1) {
            int row = masterTable.getSelectedRow();
            int size = crud.findAll().size();
            value = (int) masterTable.getValueAt(masterTable.getSelectedRow(), 0);
            crud.delete(Brand.class, value);
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
            this.setEnableField(ControlPanel.controlDialogButton(ButtonEnum.SAVE_BUTTON, cmdDelete, cmdNew, cmdSave));
            fields();
            if (ControlPanel.optionPaneSave("Successfully deleted!")) {
                cmdDisposeActionPerformed(null);
            }

        }
    }//GEN-LAST:event_cmdDeleteActionPerformed

    private void cmdSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSaveActionPerformed

        this.save();


    }//GEN-LAST:event_cmdSaveActionPerformed

    private void cmdCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCancelActionPerformed

        ControlPanel.clean(jpnFields);
        this.setEnableField(ControlPanel.controlDialogButton(ButtonEnum.CANCEL_BUTTON, cmdDelete, cmdNew, cmdSave));
    }//GEN-LAST:event_cmdCancelActionPerformed

    private void cmdSaveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmdSaveKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.save();
        }
    }//GEN-LAST:event_cmdSaveKeyPressed

    private void masterTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_masterTableKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_UP || evt.getKeyCode() == KeyEvent.VK_DOWN) {
            int row = masterTable.getSelectedRow();
            this.modifRowTable(row);
            fields();
        }
    }//GEN-LAST:event_masterTableKeyReleased

    private void fieldCategoriaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldCategoriaKeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            cmdSave.requestFocus();
        }
    }//GEN-LAST:event_fieldCategoriaKeyPressed

    private void setEnableField(boolean is) {

        fieldCode.setEnabled(is);
        fieldCategoria.setEnabled(is);

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
            marca = crud.find(Brand.class, value);
            fieldCode.setText(String.valueOf(marca.getId()));
            fieldCategoria.setText(marca.getBrand());
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
            java.util.logging.Logger.getLogger(DialogBrand.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            DialogBrand dialog = new DialogBrand(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton cmdCancel;
    private javax.swing.JButton cmdDelete;
    private javax.swing.JButton cmdDispose;
    private javax.swing.JButton cmdNew;
    private javax.swing.JButton cmdSave;
    private javax.swing.JTextField fieldCategoria;
    private javax.swing.JTextField fieldCode;
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
