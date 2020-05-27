package views.dialog;

import entities.entity.product.Category;
import entities.entity.product.Brand;
import entities.entity.product.Measure;
import entities.entity.product.Stock;
import entities.entity.product.ProductSection;
import enu.FieldChar;
import impl.ImplCategory;
import impl.ImplBrand;
import impl.ImplMeasure;
import impl.ImplProduct;
import impl.ImplSection;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import util.ControlPanel;
import util.FormatNumber;
import util.PercentValue;

public class DialogProduct extends javax.swing.JDialog {

    private Stock pro, cancel;
    private ImplProduct crud;

    public DialogProduct(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        pro = new Stock();
        this.updateComboBox();

    }

    public DialogProduct(java.awt.Frame parent, boolean modal, Stock produto) {
        super(parent, modal);
        initComponents();
        this.updateComboBox();
        this.cancel = produto;
        this.fields(produto);
        this.eventClick();
    }

    private void eventClick() {
        boolean isClick = cmdNovo.isEnabled();
        if (isClick) {
            cmdNovo.setEnabled(false);
            cmdCancelar.setEnabled(true);
        } else {
            cmdCancelar.setEnabled(false);
            cmdNovo.setEnabled(true);
        }
    }

    private void updateComboBox() {

        FormatNumber.formatFieldPoint(fieldCompra, FieldChar.vk_comma);
        FormatNumber.formatFieldPoint(fieldVenda, FieldChar.vk_comma);
        FormatNumber.formatFieldPoint(fieldLucro, FieldChar.vk_comma);
        FormatNumber.formatFieldPoint(fieldQtd, FieldChar.vk_null);

        ImplBrand marca = new ImplBrand();
        cbxMarca.removeAllItems();
        marca.findAll().forEach(item -> cbxMarca.addItem(item));

        ImplCategory categoria = new ImplCategory();
        cbxCategoria.removeAllItems();
        categoria.findAll().forEach(item -> cbxCategoria.addItem(item));

        ImplMeasure unidade = new ImplMeasure();
        cbxUnidade.removeAllItems();
        unidade.findAll().forEach(item -> cbxUnidade.addItem(item));

        ImplSection secao = new ImplSection();
        cbxSecao.removeAllItems();
        secao.findAll().forEach(item -> cbxSecao.addItem(item));

        crud = new ImplProduct();

        ControlPanel.borderLabel(jpnFields);

    }

    private void fields(Stock produto) {
        try {
            this.pro = produto;
            fieldProdutoId.setText(0 + String.valueOf(pro.getId()));
            fieldDescricao.setText(pro.getProdutoDescricao());
            fieldCodeBar.setText(pro.getCodeBar());
            fieldNotaFiscal.setText(pro.getProdutoNFe());

            fieldCompra.setText(String.valueOf(pro.getPrecoCompra()).replace(".", ","));
            fieldVenda.setText(String.valueOf(pro.getPrecoVenda()).replace(".", ","));
            fieldLucro.setText(String.valueOf((pro.getPercente().doubleValue() * 100)).replace(".", ","));

            cbxCategoria.getModel().setSelectedItem(pro.getIdCategoria());
            cbxMarca.getModel().setSelectedItem(pro.getIdMarca());
            cbxUnidade.getModel().setSelectedItem(pro.getIdMedida());
            cbxSecao.getModel().setSelectedItem(pro.getIdSecao());

            ckbOrigem.setSelected(Boolean.valueOf(pro.getNacional()));

            fieldQtd.setText(String.valueOf(pro.getEstoqueQtd()));
            checkProduto(pro.getCondicao());
        } catch (Exception e) {
            System.out.println("Error 001-f: " + e.getMessage());
        }

    }

    private void save() throws Exception {
        pro.setProdutoDescricao(fieldDescricao.getText().toUpperCase().trim());
        pro.setCodeBar(fieldCodeBar.getText());
        pro.setProdutoNFe(fieldNotaFiscal.getText());
        pro.setPrecoCompra(BigDecimal.valueOf(Double.parseDouble(fieldCompra.getText().replace(",", "."))));

        pro.setPrecoVenda((BigDecimal.valueOf(Double.parseDouble(fieldVenda.getText().replace(",", ".")))));
        BigDecimal b = BigDecimal.valueOf(Double.parseDouble(fieldLucro.getText().replace(",", ".")) / 100);
        pro.setPercente(b);

        if (fieldDescricao.getText().isEmpty()) {
            throw new Exception("O campo descrição não pode ser vazio.\nVerifique e tente novamente");
        }
        pro.setEstoqueQtd(Integer.parseInt(0 + fieldQtd.getText()));

        pro.setCategoria((Category) cbxCategoria.getSelectedItem());

        pro.setIdMarca((Brand) cbxMarca.getModel().getSelectedItem());

        pro.setIdMedida((Measure) cbxUnidade.getModel().getSelectedItem());

        pro.setIdSecao((ProductSection) cbxSecao.getModel().getSelectedItem());

        pro.setNacional(String.valueOf(ckbOrigem.isSelected()));
        String condicao = "Novo";
        if (rbSemi.isSelected()) {
            condicao = "Seminovo";

        } else if (rbUsado.isSelected()) {
            condicao = "Usado";
        }

        pro.setCondicao(condicao.toUpperCase());
        crud.save(pro);
        JOptionPane.showMessageDialog(rootPane, "Salvo com sucesso!");
    }

    private void checkProduto(String value) {
        try {
            char c = value.charAt(0);
            switch (c) {
                case 'U':
                    rbUsado.setSelected(true);
                    break;
                case 'S':
                    rbSemi.setSelected(true);
                    break;
                default:
                    rbNovo.setSelected(true);
                    break;
            }
        } catch (Exception e) {
//            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btgTipo = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jpnFields = new javax.swing.JPanel();
        cbxSecao = new javax.swing.JComboBox<>();
        fieldCompra = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        cbxCategoria = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cmdCancelar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmdExit = new javax.swing.JButton();
        rbNovo = new javax.swing.JRadioButton();
        fieldNotaFiscal = new javax.swing.JTextField();
        fieldProdutoId = new javax.swing.JTextField();
        rbSemi = new javax.swing.JRadioButton();
        fieldLucro = new javax.swing.JFormattedTextField();
        rbUsado = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        fieldVenda = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        fieldDescricao = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cmdSalvar = new javax.swing.JButton();
        cbxMarca = new javax.swing.JComboBox<>();
        fieldCodeBar = new javax.swing.JTextField();
        cbxUnidade = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cmdNovo = new javax.swing.JButton();
        ckbOrigem = new javax.swing.JCheckBox();
        jLabel11 = new javax.swing.JLabel();
        fieldQtd = new javax.swing.JFormattedTextField();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CADASTRAR PRODUTO");
        setIconImage(new ImageIcon(getClass().getResource("/views/img/produto.png")).getImage());
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.TOOLKIT_EXCLUDE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jpnFields.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cbxSecao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbxSecaoKeyPressed(evt);
            }
        });

        fieldCompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldCompraKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldCompraKeyReleased(evt);
            }
        });

        jLabel9.setText("Lucro (%):");

        cbxCategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbxCategoriaKeyPressed(evt);
            }
        });

        jLabel4.setText("Uni.:");

        cmdCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/img/reflesh.png"))); // NOI18N
        cmdCancelar.setText("Cancelar");
        cmdCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCancelarActionPerformed(evt);
            }
        });

        jLabel3.setText("Código de barra:");

        jLabel12.setText("NCM/ NFe:");

        jLabel1.setText("Código:");

        jLabel2.setText("Descrição:");

        cmdExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/img/power.png"))); // NOI18N
        cmdExit.setText("Sair");
        cmdExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdExitActionPerformed(evt);
            }
        });

        btgTipo.add(rbNovo);
        rbNovo.setSelected(true);
        rbNovo.setText("Novo");

        fieldProdutoId.setEditable(false);
        fieldProdutoId.setFocusable(false);

        btgTipo.add(rbSemi);
        rbSemi.setText("Seminovo");

        fieldLucro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldLucroKeyReleased(evt);
            }
        });

        btgTipo.add(rbUsado);
        rbUsado.setText("Usado");

        jLabel6.setText("Categoria:");

        fieldVenda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldVendaKeyReleased(evt);
            }
        });

        jLabel8.setText("Compra (R$):");

        fieldDescricao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldDescricaoKeyPressed(evt);
            }
        });

        jLabel7.setText("Seção:");

        cmdSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/img/save-pro.png"))); // NOI18N
        cmdSalvar.setText("Salvar");
        cmdSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSalvarActionPerformed(evt);
            }
        });

        cbxMarca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbxMarcaKeyPressed(evt);
            }
        });

        fieldCodeBar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldCodeBarKeyPressed(evt);
            }
        });

        cbxUnidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbxUnidadeKeyPressed(evt);
            }
        });

        jLabel5.setText("Marca:");
        jLabel5.setBorder(new EmptyBorder(0,3,0,0));

        jLabel10.setText("Venda (R$):");

        cmdNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/img/new-pro.png"))); // NOI18N
        cmdNovo.setText("Novo");
        cmdNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdNovoActionPerformed(evt);
            }
        });

        ckbOrigem.setText("Importado");
        ckbOrigem.setPreferredSize(new java.awt.Dimension(81, 20));

        jLabel11.setText("Estoque:");

        fieldQtd.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        fieldQtd.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        javax.swing.GroupLayout jpnFieldsLayout = new javax.swing.GroupLayout(jpnFields);
        jpnFields.setLayout(jpnFieldsLayout);
        jpnFieldsLayout.setHorizontalGroup(
            jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnFieldsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpnFieldsLayout.createSequentialGroup()
                        .addComponent(cmdNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmdExit))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpnFieldsLayout.createSequentialGroup()
                        .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpnFieldsLayout.createSequentialGroup()
                                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnFieldsLayout.createSequentialGroup()
                                        .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cbxMarca, 0, 141, Short.MAX_VALUE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cbxUnidade, 0, 134, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbxCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnFieldsLayout.createSequentialGroup()
                                        .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(fieldCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(fieldLucro, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(fieldVenda, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel12)
                                    .addComponent(fieldNotaFiscal)
                                    .addComponent(cbxSecao, 0, 149, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel11)))
                            .addComponent(jLabel1)
                            .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpnFieldsLayout.createSequentialGroup()
                                    .addComponent(fieldProdutoId, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(rbNovo)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(rbSemi)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(rbUsado))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpnFieldsLayout.createSequentialGroup()
                                    .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jpnFieldsLayout.createSequentialGroup()
                                            .addComponent(fieldDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(ckbOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel2))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(fieldCodeBar, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jpnFieldsLayout.createSequentialGroup()
                        .addGap(422, 422, 422)
                        .addComponent(fieldQtd)))
                .addContainerGap())
        );
        jpnFieldsLayout.setVerticalGroup(
            jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnFieldsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(fieldProdutoId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbNovo)
                    .addComponent(rbSemi)
                    .addComponent(rbUsado))
                .addGap(23, 23, 23)
                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldCodeBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ckbOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxSecao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fieldCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldLucro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnFieldsLayout.createSequentialGroup()
                            .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel9)
                                .addComponent(jLabel10)
                                .addComponent(jLabel8))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(fieldVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpnFieldsLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldNotaFiscal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldQtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99)
                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdNovo)
                    .addComponent(cmdSalvar)
                    .addComponent(cmdCancelar)
                    .addComponent(cmdExit))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnFields, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cmdExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdExitActionPerformed
        this.dispose();
    }//GEN-LAST:event_cmdExitActionPerformed

    private void cmdCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCancelarActionPerformed
        pro = this.cancel;
        this.fields(pro);
        this.eventClick();
    }//GEN-LAST:event_cmdCancelarActionPerformed

    private void cmdSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSalvarActionPerformed
        try {
            save();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_cmdSalvarActionPerformed

    private void fieldCompraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldCompraKeyReleased

        fieldLucroKeyReleased(evt);


    }//GEN-LAST:event_fieldCompraKeyReleased

    private void fieldLucroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldLucroKeyReleased
        String venda = PercentValue.venda(fieldCompra.getText(), fieldLucro.getText());
        fieldVenda.setText(venda);
    }//GEN-LAST:event_fieldLucroKeyReleased

    private void fieldVendaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldVendaKeyReleased
        String percente = PercentValue.percente(fieldCompra.getText(), fieldVenda.getText());
        fieldLucro.setText(percente);
    }//GEN-LAST:event_fieldVendaKeyReleased

    private void fieldDescricaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldDescricaoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            fieldCodeBar.requestFocus();

        }
    }//GEN-LAST:event_fieldDescricaoKeyPressed

    private void fieldCodeBarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldCodeBarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            cbxMarca.requestFocus();

        }
    }//GEN-LAST:event_fieldCodeBarKeyPressed

    private void cbxMarcaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbxMarcaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            cbxUnidade.requestFocus();

        }
    }//GEN-LAST:event_cbxMarcaKeyPressed

    private void cbxUnidadeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbxUnidadeKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            cbxCategoria.requestFocus();

        }
    }//GEN-LAST:event_cbxUnidadeKeyPressed

    private void cbxCategoriaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbxCategoriaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            cbxSecao.requestFocus();

        }
    }//GEN-LAST:event_cbxCategoriaKeyPressed

    private void cbxSecaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbxSecaoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            fieldCompra.requestFocus();

        }
    }//GEN-LAST:event_cbxSecaoKeyPressed

    private void fieldCompraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldCompraKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            fieldVenda.requestFocus();

        }
    }//GEN-LAST:event_fieldCompraKeyPressed

    private void cmdNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdNovoActionPerformed
        this.eventClick();
    }//GEN-LAST:event_cmdNovoActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            DialogProduct dialog = new DialogProduct(new javax.swing.JFrame(), true);
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
    private javax.swing.ButtonGroup btgTipo;
    private javax.swing.JComboBox<entities.entity.product.Category> cbxCategoria;
    private javax.swing.JComboBox<entities.entity.product.Brand> cbxMarca;
    private javax.swing.JComboBox<entities.entity.product.ProductSection> cbxSecao;
    private javax.swing.JComboBox<entities.entity.product.Measure> cbxUnidade;
    private javax.swing.JCheckBox ckbOrigem;
    private javax.swing.JButton cmdCancelar;
    private javax.swing.JButton cmdExit;
    private javax.swing.JButton cmdNovo;
    private javax.swing.JButton cmdSalvar;
    private javax.swing.JTextField fieldCodeBar;
    private javax.swing.JFormattedTextField fieldCompra;
    private javax.swing.JTextField fieldDescricao;
    private javax.swing.JFormattedTextField fieldLucro;
    private javax.swing.JTextField fieldNotaFiscal;
    private javax.swing.JTextField fieldProdutoId;
    private javax.swing.JFormattedTextField fieldQtd;
    private javax.swing.JFormattedTextField fieldVenda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel jpnFields;
    private javax.swing.JRadioButton rbNovo;
    private javax.swing.JRadioButton rbSemi;
    private javax.swing.JRadioButton rbUsado;
    // End of variables declaration//GEN-END:variables
}
