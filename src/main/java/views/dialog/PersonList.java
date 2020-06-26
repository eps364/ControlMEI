package views.dialog;

import entity.person.Person;
import entity.person.Company;
import entity.person.Customer;

import enu.TypePerson;
import impl.ImplCompany;
import impl.ImplCustomer;

import impl.ImplPerson;
import java.awt.event.KeyEvent;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import util.ControlPanel;
import util.ConvertDate;

public class PersonList extends javax.swing.JDialog {

    private final DefaultTableModel model;
    private ImplPerson crud;
    private Person cliente;

    public PersonList(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        ControlPanel.borderLabel(jpnFields);
        model = (DefaultTableModel) masterTable.getModel();

        this.updateTable();

    }

    private void updateTable() {

        model.setRowCount(0);
        crud = new ImplPerson();

        crud.findAll().forEach(c -> {
            model.addRow(new Object[]{
                c.getId(),
                c.getPersonName(),
                new ConvertDate(c.getNascimento()),
                tipoPessoa(c.getId()),
                c.getPhone(),
                c.getEmail()

            });
        });

    }

    private String tipoPessoa(Integer id) {
        String register;
        ImplPerson imp = new ImplPerson();
        Person person = imp.find(Person.class, id);
        register = person.getdType();
        TypePerson type = TypePerson.valueOf(person.getdType().toUpperCase());
        switch (type) {
            case COMPANY:
                ImplCompany implCp = new ImplCompany();
                Company company = implCp.find(Company.class, id);
                register = company.getCnpjNumber();
                break;

            case EMPLOYEE:
         
                break;

            case CUSTOMER:
                ImplCustomer implCm = new ImplCustomer();
                Customer customer = implCm.find(Customer.class, id);
                register = customer.getSocialNumber();
                break;
            default:
                System.out.println("Not found person");
                break;

        }

        return register;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jpnFields = new javax.swing.JPanel();
        queryField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        masterTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        cmdDispose = new javax.swing.JButton();
        cmdAdd = new javax.swing.JButton();

        jButton2.setText("jButton2");

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("LISTA DE CLIENTES");

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jpnFields.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        queryField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                queryFieldKeyReleased(evt);
            }
        });

        masterTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "RAZÃO SOCIAL", "NASC", "CPF/CNPJ", "CELULAR", "E-MAIL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
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
            public void keyPressed(java.awt.event.KeyEvent evt) {
                masterTableKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(masterTable);
        if (masterTable.getColumnModel().getColumnCount() > 0) {
            masterTable.getColumnModel().getColumn(0).setMinWidth(0);
            masterTable.getColumnModel().getColumn(0).setPreferredWidth(0);
            masterTable.getColumnModel().getColumn(0).setMaxWidth(0);
            masterTable.getColumnModel().getColumn(1).setMinWidth(180);
            masterTable.getColumnModel().getColumn(1).setPreferredWidth(250);
            masterTable.getColumnModel().getColumn(2).setMinWidth(50);
            masterTable.getColumnModel().getColumn(2).setPreferredWidth(80);
            masterTable.getColumnModel().getColumn(3).setMinWidth(80);
            masterTable.getColumnModel().getColumn(3).setPreferredWidth(135);
            masterTable.getColumnModel().getColumn(4).setPreferredWidth(120);
            masterTable.getColumnModel().getColumn(5).setMinWidth(100);
            masterTable.getColumnModel().getColumn(5).setPreferredWidth(200);
        }

        jLabel2.setText("Pesquisar:");

        cmdDispose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/power16.png"))); // NOI18N
        cmdDispose.setText("Sair");
        cmdDispose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdDisposeActionPerformed(evt);
            }
        });

        cmdAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add16.png"))); // NOI18N
        cmdAdd.setText("Adicionar");
        cmdAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnFieldsLayout = new javax.swing.GroupLayout(jpnFields);
        jpnFields.setLayout(jpnFieldsLayout);
        jpnFieldsLayout.setHorizontalGroup(
            jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnFieldsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 752, Short.MAX_VALUE)
                    .addGroup(jpnFieldsLayout.createSequentialGroup()
                        .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(queryField, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jpnFieldsLayout.createSequentialGroup()
                        .addComponent(cmdDispose)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmdAdd)))
                .addContainerGap())
        );
        jpnFieldsLayout.setVerticalGroup(
            jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnFieldsLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(queryField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmdAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmdDispose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnFields, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnFields, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void queryFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_queryFieldKeyReleased
        String querys = queryField.getText().toUpperCase();
        TableRowSorter<DefaultTableModel> filter = new TableRowSorter<>(model);
        masterTable.setRowSorter(filter);
        filter.setRowFilter(RowFilter.regexFilter(querys));
    }//GEN-LAST:event_queryFieldKeyReleased

    private void cmdAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAddActionPerformed
        this.addPessoa();


    }//GEN-LAST:event_cmdAddActionPerformed

    private void masterTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_masterTableMouseClicked

        if (evt.getClickCount() == 2) {

            cmdAddActionPerformed(null);
        }

    }//GEN-LAST:event_masterTableMouseClicked

    private void masterTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_masterTableKeyPressed

        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            this.cmdAddActionPerformed(null);
        }
    }//GEN-LAST:event_masterTableKeyPressed

    private void cmdDisposeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdDisposeActionPerformed
        this.dispose();
    }//GEN-LAST:event_cmdDisposeActionPerformed

    private void addPessoa() {

        if (masterTable.getSelectedRow() != -1) {
            int value = Integer.parseInt(masterTable.getValueAt(masterTable.getSelectedRow(), 0).toString());
            cliente = crud.find(Person.class, value);
            this.dispose();
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
            java.util.logging.Logger.getLogger(PersonList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            PersonList dialog = new PersonList(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton cmdAdd;
    private javax.swing.JButton cmdDispose;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpnFields;
    private javax.swing.JTable masterTable;
    private javax.swing.JTextField queryField;
    // End of variables declaration//GEN-END:variables

    public Person getCliente() {
        return cliente;
    }
}
