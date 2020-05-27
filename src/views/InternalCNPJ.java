package views;

import entities.entity.person.Cnpj;
import impl.ImplCNPJ;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import util.ControlPanel;
import util.Fields;
import views.dialog.DialogCNPJ;

public class InternalCNPJ extends javax.swing.JInternalFrame {

    private int value;
    private final ImplCNPJ crud;
    private Cnpj cnpj;
    private final DefaultTableModel model;

    public InternalCNPJ() {
        initComponents();
        crud = new ImplCNPJ();
        model = (DefaultTableModel) masterTable.getModel();
        updateTable();
        ControlPanel.borderLabel(jpnFields);
    }

    private void updateTable() {

        model.getDataVector().clear();
        crud.findAll().forEach(c -> {
            model.addRow(new Object[]{
                c.getId(),
                c.getNomeFantasia(),
                c.getCnpjNumber(),
                c.getFone(),
                c.getCelular(),
                c.getWhatsapp(),
                c.getEmail()

            });

        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuEditDelete = new javax.swing.JPopupMenu();
        itemEditar = new javax.swing.JMenuItem();
        itemDelete = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jpnFields = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        masterTable = new javax.swing.JTable();
        query = new javax.swing.JTextField();
        cmdDispose = new javax.swing.JButton();
        cmdEditar = new javax.swing.JButton();
        cmdNovo = new javax.swing.JButton();
        cmdDelete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        itemEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/img/client_edit.png"))); // NOI18N
        itemEditar.setText("Editar linha");
        itemEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemEditarActionPerformed(evt);
            }
        });
        menuEditDelete.add(itemEditar);

        itemDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/img/client_del.png"))); // NOI18N
        itemDelete.setText("Deletar linha");
        itemDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemDeleteActionPerformed(evt);
            }
        });
        menuEditDelete.add(itemDelete);

        setClosable(true);
        setIconifiable(true);
        setTitle("CADASTRO DE PESSOA JURÍDICA");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/views/img/cnpj.png"))); // NOI18N
        setPreferredSize(new java.awt.Dimension(800, 580));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jpnFields.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jpnFields.setPreferredSize(new java.awt.Dimension(760, 460));

        masterTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOME FANTASIA", "CNPJ", "FONE", "CELULAR", "WHATSAPP", "EMAIL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        masterTable.setComponentPopupMenu(menuEditDelete);
        masterTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                masterTableMouseClicked(evt);
            }
        });
        masterTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                masterTableKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(masterTable);
        if (masterTable.getColumnModel().getColumnCount() > 0) {
            masterTable.getColumnModel().getColumn(0).setMinWidth(40);
            masterTable.getColumnModel().getColumn(0).setPreferredWidth(40);
            masterTable.getColumnModel().getColumn(0).setMaxWidth(40);
            masterTable.getColumnModel().getColumn(1).setMinWidth(200);
            masterTable.getColumnModel().getColumn(1).setPreferredWidth(200);
            masterTable.getColumnModel().getColumn(1).setMaxWidth(200);
        }

        query.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                queryKeyReleased(evt);
            }
        });

        cmdDispose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/img/power.png"))); // NOI18N
        cmdDispose.setText("Sair");
        cmdDispose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdDisposeActionPerformed(evt);
            }
        });

        cmdEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/img/client_edit.png"))); // NOI18N
        cmdEditar.setText("Editar");
        cmdEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdEditarActionPerformed(evt);
            }
        });

        cmdNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/img/client_add.png"))); // NOI18N
        cmdNovo.setText("Novo");
        cmdNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdNovoActionPerformed(evt);
            }
        });

        cmdDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/img/client_del.png"))); // NOI18N
        cmdDelete.setText("Deletar");
        cmdDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdDeleteActionPerformed(evt);
            }
        });

        jLabel1.setText("Consultar:");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/img/lupa.png"))); // NOI18N

        javax.swing.GroupLayout jpnFieldsLayout = new javax.swing.GroupLayout(jpnFields);
        jpnFields.setLayout(jpnFieldsLayout);
        jpnFieldsLayout.setHorizontalGroup(
            jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnFieldsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 736, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnFieldsLayout.createSequentialGroup()
                        .addComponent(cmdNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmdDispose))
                    .addGroup(jpnFieldsLayout.createSequentialGroup()
                        .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jpnFieldsLayout.createSequentialGroup()
                                .addComponent(query, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jpnFieldsLayout.setVerticalGroup(
            jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnFieldsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(query, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdDispose)
                    .addComponent(cmdEditar)
                    .addComponent(cmdNovo)
                    .addComponent(cmdDelete))
                .addGap(78, 78, 78))
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(77, Short.MAX_VALUE)
                .addComponent(jpnFields, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdNovoActionPerformed
        int row = masterTable.getSelectedRow();
        int size = crud.findAll().size();
        DialogCNPJ dialog = new DialogCNPJ(new JFrame(), true);
//        dialog.setTitle(this.getTitle());
        dialog.setVisible(true);

        int outSize = crud.findAll().size();
        updateTable();
        if (outSize > size) {
            masterTable.setRowSelectionInterval(size, size);
        } else {
            modifRowTable(row);
        }


    }//GEN-LAST:event_cmdNovoActionPerformed

    private void masterTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_masterTableMouseClicked

        if (evt.getClickCount() == 2) {
            editButton();
        }
    }//GEN-LAST:event_masterTableMouseClicked

    private void cmdEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdEditarActionPerformed

        editButton();

    }//GEN-LAST:event_cmdEditarActionPerformed

    private void cmdDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdDeleteActionPerformed
        if (masterTable.getSelectedRow() != -1) {
            int row = masterTable.getSelectedRow();
            int size = crud.findAll().size();
            value = (int) masterTable.getValueAt(masterTable.getSelectedRow(), 0);
            crud.delete(Cnpj.class, value);
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

        }
    }//GEN-LAST:event_cmdDeleteActionPerformed

    private void itemDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemDeleteActionPerformed
        cmdDeleteActionPerformed(evt);
    }//GEN-LAST:event_itemDeleteActionPerformed

    private void itemEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEditarActionPerformed
        cmdEditarActionPerformed(evt);
    }//GEN-LAST:event_itemEditarActionPerformed

    private void cmdDisposeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdDisposeActionPerformed
        this.dispose();
    }//GEN-LAST:event_cmdDisposeActionPerformed

    private void queryKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_queryKeyReleased

        String querys = query.getText().toUpperCase();
        TableRowSorter<DefaultTableModel> filter = new TableRowSorter<>(model);
        masterTable.setRowSorter(filter);
        filter.setRowFilter(RowFilter.regexFilter(querys));


    }//GEN-LAST:event_queryKeyReleased

    private void masterTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_masterTableKeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
           this.cmdEditarActionPerformed(null);
        }
    }//GEN-LAST:event_masterTableKeyPressed

    private void modifRowTable(int row) {
        if (masterTable.getSelectedRow() != -1) {
            masterTable.setRowSelectionInterval(row, row);

        }
    }

    private void editButton() {
        int row = masterTable.getSelectedRow();
        if (row != -1) {
            int old = crud.findAll().size();
            value = (int) masterTable.getValueAt(row, 0);
            cnpj = crud.find(Cnpj.class, value);
            DialogCNPJ dialog = new DialogCNPJ(new JFrame(), true, cnpj);
            dialog.setTitle(this.getTitle());
            dialog.setVisible(true);
            updateTable();
            int size = crud.findAll().size();
            if (size > old) {
                row = size - 1;
                masterTable.setRowSelectionInterval(row, row);
            } 
            if (masterTable.getSelectedRow() != -1) {
                this.modifRowTable(row);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdDelete;
    private javax.swing.JButton cmdDispose;
    private javax.swing.JButton cmdEditar;
    private javax.swing.JButton cmdNovo;
    private javax.swing.JMenuItem itemDelete;
    private javax.swing.JMenuItem itemEditar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpnFields;
    private javax.swing.JTable masterTable;
    private javax.swing.JPopupMenu menuEditDelete;
    private javax.swing.JTextField query;
    // End of variables declaration//GEN-END:variables
}
