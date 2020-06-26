package views;

import entity.person.Person;
import entity.SaleItem;
import entity.product.Stock;
import enu.TypePerson;
import impl.ImplProduct;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.swing.table.DefaultTableModel;
import util.ControlPanel;
import util.FormatNumber;
import views.dialog.PersonList;
import views.dialog.ProductList;

public class InternalSale extends javax.swing.JInternalFrame {

    private SaleItem items;
    private Stock estoque;
    private ImplProduct pdo;
    private List<Stock> estoqueList;
    private final DefaultTableModel model;

    public InternalSale() {
        initComponents();
   
        FormatNumber.spinnerNumber(spnParcela);
        
        
        
        pdo = new ImplProduct();
        estoqueList = new ArrayList();
        model = (DefaultTableModel) masterTable.getModel();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField5 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jpnFields = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        fieldCodeBar = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        fieldProduto = new javax.swing.JTextField();
        cmdBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        masterTable = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jTextField4 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        fieldQtd = new javax.swing.JTextField();
        cmdAdicionar = new javax.swing.JButton();
        cmdRemover = new javax.swing.JButton();
        fieldPreco = new javax.swing.JFormattedTextField();
        fieldCodicao = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        fieldMarca = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cmdConcluir = new javax.swing.JButton();
        cmdSair = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        cbxPagamento = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        spnParcela = new javax.swing.JSpinner();
        jLabel10 = new javax.swing.JLabel();
        fieldDate = new com.toedter.calendar.JDateChooser();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        fieldClient = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        cmdBuscar1 = new javax.swing.JButton();

        jTextField5.setText("jTextField5");

        jTextField7.setText("jTextField7");

        setClosable(true);
        setIconifiable(true);
        setTitle("TELA DE VENDA");
        setPreferredSize(new java.awt.Dimension(800, 580));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jpnFields.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Código de Barra:");

        fieldCodeBar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldCodeBarKeyReleased(evt);
            }
        });

        jLabel3.setText("Produto:");

        fieldProduto.setEditable(false);
        fieldProduto.setBackground(new java.awt.Color(254, 254, 240));

        cmdBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/query.png"))); // NOI18N
        cmdBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdBuscarActionPerformed(evt);
            }
        });

        masterTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "DESCRIÇAO/PRODUTO", "QTD", "PREÇO", "TOTAL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(masterTable);
        if (masterTable.getColumnModel().getColumnCount() > 0) {
            masterTable.getColumnModel().getColumn(0).setMinWidth(0);
            masterTable.getColumnModel().getColumn(0).setPreferredWidth(0);
            masterTable.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lupa.png"))); // NOI18N
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel5.setText("Quant.:");

        fieldQtd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldQtdActionPerformed(evt);
            }
        });

        cmdAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add16.png"))); // NOI18N
        cmdAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAdicionarActionPerformed(evt);
            }
        });

        cmdRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/remove16.png"))); // NOI18N
        cmdRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdRemoverActionPerformed(evt);
            }
        });

        fieldPreco.setEditable(false);
        fieldPreco.setBackground(new java.awt.Color(254, 254, 240));
        fieldPreco.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        fieldCodicao.setEditable(false);
        fieldCodicao.setBackground(new java.awt.Color(254, 254, 240));

        jLabel2.setText("Condição:");

        fieldMarca.setEditable(false);
        fieldMarca.setBackground(new java.awt.Color(254, 254, 240));

        jLabel6.setText("Marca:");

        jLabel7.setText("Preço:");

        cmdConcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/confirm16.png"))); // NOI18N
        cmdConcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdConcluirActionPerformed(evt);
            }
        });

        cmdSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/power16.png"))); // NOI18N
        cmdSair.setText("Sair");
        cmdSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSairActionPerformed(evt);
            }
        });

        jLabel8.setText("Pagamento:");

        cbxPagamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AVISTA", "CT CRÉDITO", "CT DE DÉBITO", "DUPLICATA" }));

        jLabel9.setText("Parcelamento:");

        spnParcela.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));

        jLabel10.setText("Vencimento:");

        fieldDate.setDateFormatString("dd/MM/yyyy");

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel12.setText("Cliente:");

        cmdBuscar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/query.png"))); // NOI18N
        cmdBuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdBuscar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnFieldsLayout = new javax.swing.GroupLayout(jpnFields);
        jpnFields.setLayout(jpnFieldsLayout);
        jpnFieldsLayout.setHorizontalGroup(
            jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnFieldsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnFieldsLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cmdAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addComponent(jSeparator1)
                    .addGroup(jpnFieldsLayout.createSequentialGroup()
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmdConcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdSair))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnFieldsLayout.createSequentialGroup()
                        .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpnFieldsLayout.createSequentialGroup()
                                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fieldQtd, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(fieldPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(fieldMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jpnFieldsLayout.createSequentialGroup()
                                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(fieldProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2)
                                    .addComponent(fieldCodicao, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)))
                            .addGroup(jpnFieldsLayout.createSequentialGroup()
                                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpnFieldsLayout.createSequentialGroup()
                                        .addComponent(fieldCodeBar, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmdBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addGroup(jpnFieldsLayout.createSequentialGroup()
                                        .addComponent(fieldClient, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmdBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fieldDate, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(spnParcela, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(cbxPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(11, 11, 11)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)))
                .addContainerGap())
        );
        jpnFieldsLayout.setVerticalGroup(
            jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnFieldsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnFieldsLayout.createSequentialGroup()
                        .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel8)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(fieldCodeBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmdBuscar)
                            .addComponent(cbxPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmdBuscar1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fieldProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldCodicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spnParcela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(fieldQtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(fieldPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(fieldMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(fieldDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jSeparator3)
                    .addComponent(jSeparator2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(cmdAdicionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmdRemover, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(cmdConcluir)
                    .addComponent(cmdSair))
                .addContainerGap())
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
    }// </editor-fold>//GEN-END:initComponents

    private void fieldQtdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldQtdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldQtdActionPerformed

    private void cmdSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_cmdSairActionPerformed

    private void addItems(List<SaleItem> items) {

    }

    private List<SaleItem> getItems() {
        return null;
    }

    private List<Stock> getListEstoque() {
        return this.estoqueList;
    }

    private void setEstoqueList(List<Stock> estoqueList) {
        this.estoqueList = estoqueList;
    }

    private void cmdBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdBuscarActionPerformed
        ProductList produto = new ProductList(new javax.swing.JFrame(), true);
        produto.setVisible(true);
        selectItem(produto.getProduto());
    }//GEN-LAST:event_cmdBuscarActionPerformed

    private void fieldCodeBarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldCodeBarKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            selectItem(pdo.getLike(fieldCodeBar.getText()));
        }

    }//GEN-LAST:event_fieldCodeBarKeyReleased

    private void cmdAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAdicionarActionPerformed
        List<Stock> list = new ArrayList();

        Stock s = estoque;
        s.setStockQtt(Integer.parseInt(0 + fieldQtd.getText().replace(",", ".")));
        list.add(s);
        this.setEstoqueList(list);
        this.updateTable();


    }//GEN-LAST:event_cmdAdicionarActionPerformed

    private void cmdConcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdConcluirActionPerformed

        Set<SaleItem> set = new HashSet<>();
        SaleItem item = new SaleItem();


    }//GEN-LAST:event_cmdConcluirActionPerformed

    private void cmdRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdRemoverActionPerformed

        int selectRow = masterTable.getSelectedRow();

        this.getListEstoque().removeIf(p -> Objects.equals(p.getId(), p.getId()));
        model.removeRow(selectRow);

        this.updateTable();


    }//GEN-LAST:event_cmdRemoverActionPerformed

    private void cmdBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdBuscar1ActionPerformed
        ControlPanel.DTYPE = TypePerson.CUSTOMER;
        PersonList personList = new PersonList(new javax.swing.JFrame(), true);
       
        personList.setVisible(true);
        clientSelected(personList.getCliente());

    }//GEN-LAST:event_cmdBuscar1ActionPerformed

    private void clientSelected(Person person){
        
        try {
             fieldClient.setText(person.getPersonName());
        } catch (Exception e) {
            System.out.println("Not found costumer!");
        }
    }
    
    private void selectItem(Stock item) {
        try {

            fieldCodeBar.setText(item.getCodeBar());
            fieldProduto.setText(item.getProductName());
            fieldPreco.setText(String.valueOf(item.getSalePrice()).replace(".", ","));
            fieldCodicao.setText(item.getProductStatus());
            fieldMarca.setText(item.getBrand().getBrand());
            fieldQtd.setText(String.valueOf(item.getStockQtt()));
            this.estoque = item;
        } catch (NullPointerException e) {
//            ControlPanel.clean(jpnFields);
            e.getMessage();
        }

    }

    private void updateTable() {
//        model.setRowCount(0);
        this.getListEstoque().forEach(l -> {
            model.addRow(new Object[]{
                l.getId(),
                l.getProductName(),
                l.getStockQtt(),
                l.getSalePrice(),
                l.getSalePrice().doubleValue() * l.getStockQtt()
            });

        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbxPagamento;
    private javax.swing.JButton cmdAdicionar;
    private javax.swing.JButton cmdBuscar;
    private javax.swing.JButton cmdBuscar1;
    private javax.swing.JButton cmdConcluir;
    private javax.swing.JButton cmdRemover;
    private javax.swing.JButton cmdSair;
    private javax.swing.JTextField fieldClient;
    private javax.swing.JTextField fieldCodeBar;
    private javax.swing.JTextField fieldCodicao;
    private com.toedter.calendar.JDateChooser fieldDate;
    private javax.swing.JTextField fieldMarca;
    private javax.swing.JFormattedTextField fieldPreco;
    private javax.swing.JTextField fieldProduto;
    private javax.swing.JTextField fieldQtd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JPanel jpnFields;
    private javax.swing.JTable masterTable;
    private javax.swing.JSpinner spnParcela;
    // End of variables declaration//GEN-END:variables
}
