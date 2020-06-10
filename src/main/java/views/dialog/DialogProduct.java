package views.dialog;

import entity.person.Person;
import entity.product.Category;
import entity.product.Brand;
import entity.product.Measure;
import entity.product.Stock;
import entity.product.ProductSection;
import enu.FieldChar;
import impl.ImplCategory;
import impl.ImplBrand;
import impl.ImplCompany;
import impl.ImplMeasure;
import impl.ImplProduct;
import impl.ImplSection;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import util.ControlPanel;
import util.ControlImage;
import util.PanelModel;
import util.FormatNumber;
import util.PercentValue;

public class DialogProduct extends javax.swing.JDialog {

    private Stock stock, rollback;
    private ImplProduct crud;
    private String imagePath;

    public DialogProduct(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.updateComboBox();
        this.eventClick();
    }

    public DialogProduct(java.awt.Frame parent, boolean modal, Stock stock) {
        super(parent, modal);
        initComponents();
        this.updateComboBox();
        this.rollback = stock;
        this.fields(stock);
    }

    private void eventClick() {
        boolean isClick = cmdNew.isEnabled();
        if (isClick) {
            cmdNew.setEnabled(false);
            cmdCancel.setEnabled(true);
            imagePath = "";
            stock = new Stock();
            this.fields(stock);
        } else {
            cmdCancel.setEnabled(false);
            cmdNew.setEnabled(true);
        }

    }

    private void updateComboBox() {

        FormatNumber.formatFieldPoint(fieldCompra, FieldChar.vk_comma);
        FormatNumber.formatFieldPoint(fieldVenda, FieldChar.vk_comma);
        FormatNumber.formatFieldPoint(fieldMargem, FieldChar.vk_comma);
        FormatNumber.formatFieldPoint(fieldStock, FieldChar.vk_null);

        ImplBrand marca = new ImplBrand();
        cbxBrand.removeAllItems();
        marca.findAll().forEach(item -> cbxBrand.addItem(item));

        ImplCategory categoria = new ImplCategory();
        cbxCategory.removeAllItems();
        categoria.findAll().forEach(item -> cbxCategory.addItem(item));

        ImplMeasure unidade = new ImplMeasure();
        cbxUnit.removeAllItems();
        unidade.findAll().forEach(item -> cbxUnit.addItem(item));

        ImplSection secao = new ImplSection();
        cbxProductSection.removeAllItems();
        secao.findAll().forEach(item -> cbxProductSection.addItem(item));

        ImplCompany supplier = new ImplCompany();
        cbxSupplier.removeAllItems();
        supplier.findAll().forEach(spe -> cbxSupplier.addItem(spe));

        crud = new ImplProduct();

        ControlPanel.borderLabel(jpnFields);

    }

    private void fields(Stock stock) {
        try {
            this.stock = stock;
            fieldProductId.setText(String.valueOf(this.stock.getId()));
            fieldDescription.setText(this.stock.getProductName());
            fieldCodeBar.setText(this.stock.getCodeBar());
            txtObservation.setText(this.stock.getObservation());

            fieldCompra.setText(String.valueOf(this.stock.getParchasePrice()).replace(".", ","));
            fieldVenda.setText(String.valueOf(this.stock.getSalePrice()).replace(".", ","));
            fieldMargem.setText(String.valueOf((this.stock.getPercentage().doubleValue() * 100)).replace(".", ","));

            cbxCategory.getModel().setSelectedItem(this.stock.getCategory());
            cbxBrand.getModel().setSelectedItem(this.stock.getBrand());
            cbxUnit.getModel().setSelectedItem(this.stock.getMeasure());
            cbxProductSection.getModel().setSelectedItem(this.stock.getIdSecao());
            cbxSupplier.getModel().setSelectedItem(this.stock.getSupplier());

            checkImported.setSelected(Boolean.valueOf(this.stock.getNational()));

            fieldWarranty.setText(String.valueOf(this.stock.getWarranty()).replace(".", ","));
            fieldProfit.setText(String.valueOf(this.stock.getProfit()).replace(".", ","));
            fieldCommission.setText(String.valueOf(this.stock.getSalesCommission()).replace(".", ","));

            imagePath = this.stock.getProductImage();

            fieldStock.setText(String.valueOf(this.stock.getStockQtt()));
            checkProduto(this.stock.getProductStatus());
        } catch (Exception e) {
            System.out.println("Error 001-f: " + e.getMessage());
        } finally {
            lblImage.setIcon(this.getImage(imagePath));
        }

    }

    private void save() throws Exception {
        stock.setProductName(fieldDescription.getText().toUpperCase().trim());
        stock.setCodeBar(fieldCodeBar.getText());
        stock.setObservation(txtObservation.getText());
        stock.setParchasePrice(BigDecimal.valueOf(Double.parseDouble(fieldCompra.getText().replace(",", "."))));
        Person person = (Person) cbxSupplier.getSelectedItem();
        stock.setSupplier(person);

        stock.setWarranty(Integer.parseInt("0".concat(fieldWarranty.getText())));
        stock.setSalesCommission(BigDecimal.valueOf(Double.parseDouble("0".concat(fieldCommission.getText().replace(",", ".")))));
        stock.setProfit(BigDecimal.valueOf(Double.parseDouble("0".concat(fieldProfit.getText().replace(",", ".")))));
        stock.setProductImage(imagePath);

        stock.setSalePrice((BigDecimal.valueOf(Double.parseDouble("0".concat(fieldVenda.getText().replace(",", "."))))));
        BigDecimal b = BigDecimal.valueOf(Double.parseDouble("0".concat(fieldMargem.getText().replace(",", "."))) / 100);
        stock.setPercentage(b);

        if (fieldDescription.getText().isEmpty()) {
            throw new IllegalArgumentException("O campo descrição não pode ser vazio.\nVerifique e tente novamente");
        }
        stock.setStockQtt(Integer.parseInt("0".concat(fieldStock.getText())));

        stock.setCategory((Category) cbxCategory.getSelectedItem());

        stock.setBrand((Brand) cbxBrand.getModel().getSelectedItem());

        stock.setMeasure((Measure) cbxUnit.getModel().getSelectedItem());

        stock.setIdSecao((ProductSection) cbxProductSection.getModel().getSelectedItem());

        stock.setNational(String.valueOf(checkImported.isSelected()));
        String condicao = "Novo";
        if (rbUsedProduct.isSelected()) {
            condicao = "Seminovo";

        } else if (rbOfUsed.isSelected()) {
            condicao = "Usado";
        }

        stock.setProductStatus(condicao.toUpperCase());
        crud.save(stock);
        JOptionPane.showMessageDialog(rootPane, "Salvo com sucesso!");
    }

    private void checkProduto(String value) {
        try {
            char c = value.charAt(0);
            switch (c) {
                case 'U':
                    rbOfUsed.setSelected(true);
                    break;
                case 'S':
                    rbUsedProduct.setSelected(true);
                    break;
                default:
                    rbNew.setSelected(true);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btgTipo = new javax.swing.ButtonGroup();
        popUpImagem = new javax.swing.JPopupMenu();
        jmnItemAdd = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jmnItemClear = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jmnWebcam = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jpnFields = new javax.swing.JPanel();
        lblCodeBar = new javax.swing.JLabel();
        lblProdutcId = new javax.swing.JLabel();
        lblDescription = new javax.swing.JLabel();
        fieldProductId = new javax.swing.JTextField();
        fieldDescription = new javax.swing.JTextField();
        fieldCodeBar = new javax.swing.JTextField();
        checkImported = new javax.swing.JCheckBox();
        rbNew = new javax.swing.JRadioButton();
        rbUsedProduct = new javax.swing.JRadioButton();
        rbOfUsed = new javax.swing.JRadioButton();
        lblBrand = new javax.swing.JLabel();
        cbxBrand = new javax.swing.JComboBox<>();
        cbxCategory = new javax.swing.JComboBox<>();
        cbxUnit = new javax.swing.JComboBox<>();
        lblUnit = new javax.swing.JLabel();
        lblCategory = new javax.swing.JLabel();
        lblSection = new javax.swing.JLabel();
        cbxProductSection = new javax.swing.JComboBox<>();
        cbxSupplier = new javax.swing.JComboBox<>();
        lblSupplier = new javax.swing.JLabel();
        cmdSupplier = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        fieldCompra = new javax.swing.JFormattedTextField();
        fieldMargem = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        fieldProfit = new javax.swing.JFormattedTextField();
        fieldVenda = new javax.swing.JFormattedTextField();
        jLabel13 = new javax.swing.JLabel();
        lblSale = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtObservation = new javax.swing.JTextArea();
        lblStock = new javax.swing.JLabel();
        fieldStock = new javax.swing.JFormattedTextField();
        cmdNew = new javax.swing.JButton();
        cmdSave = new javax.swing.JButton();
        cmdCancel = new javax.swing.JButton();
        cmdExit = new javax.swing.JButton();
        lblWarranty = new javax.swing.JLabel();
        lblCommission = new javax.swing.JLabel();
        fieldCommission = new javax.swing.JFormattedTextField();
        fieldWarranty = new javax.swing.JFormattedTextField();
        compImage = new PanelModel();
        lblImage = new javax.swing.JLabel();

        jmnItemAdd.setText("Add Image");
        jmnItemAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnItemAddActionPerformed(evt);
            }
        });
        popUpImagem.add(jmnItemAdd);
        popUpImagem.add(jSeparator1);

        jmnItemClear.setText("Clear Image");
        jmnItemClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnItemClearActionPerformed(evt);
            }
        });
        popUpImagem.add(jmnItemClear);
        popUpImagem.add(jSeparator2);

        jmnWebcam.setText("WebCam");
        jmnWebcam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnWebcamActionPerformed(evt);
            }
        });
        popUpImagem.add(jmnWebcam);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CADASTRAR PRODUTO");
        setIconImage(new ImageIcon(getClass().getResource("/img/produto.png")).getImage());
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.TOOLKIT_EXCLUDE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jpnFields.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblCodeBar.setText("Código de barra:");

        lblProdutcId.setText("Código:");

        lblDescription.setText("Descrição:");

        fieldProductId.setEditable(false);
        fieldProductId.setFocusable(false);

        fieldDescription.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldDescriptionKeyPressed(evt);
            }
        });

        fieldCodeBar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldCodeBarKeyPressed(evt);
            }
        });

        checkImported.setText("Imported");
        checkImported.setToolTipText("Imported");
        checkImported.setPreferredSize(new java.awt.Dimension(81, 20));

        btgTipo.add(rbNew);
        rbNew.setSelected(true);
        rbNew.setText("Novo");

        btgTipo.add(rbUsedProduct);
        rbUsedProduct.setText("Seminovo");

        btgTipo.add(rbOfUsed);
        rbOfUsed.setText("Usado");

        lblBrand.setText("Marca:");
        lblBrand.setBorder(new EmptyBorder(0,3,0,0));

        cbxBrand.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbxBrandKeyPressed(evt);
            }
        });

        cbxCategory.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbxCategoryKeyPressed(evt);
            }
        });

        cbxUnit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbxUnitKeyPressed(evt);
            }
        });

        lblUnit.setText("Unidade:");

        lblCategory.setText("Categoria:");

        lblSection.setText("Seção:");

        cbxProductSection.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbxProductSectionKeyPressed(evt);
            }
        });

        lblSupplier.setText("Fornecedor:");

        cmdSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/query.png"))); // NOI18N
        cmdSupplier.setMaximumSize(new java.awt.Dimension(49, 22));
        cmdSupplier.setMinimumSize(new java.awt.Dimension(49, 22));
        cmdSupplier.setPreferredSize(new java.awt.Dimension(49, 22));

        jLabel8.setText("Compra (R$):");

        fieldCompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldCompraKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldCompraKeyReleased(evt);
            }
        });

        fieldMargem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldMargemKeyReleased(evt);
            }
        });

        jLabel9.setText("Margem (%):");

        fieldProfit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldProfitKeyReleased(evt);
            }
        });

        fieldVenda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldVendaKeyReleased(evt);
            }
        });

        jLabel13.setText("Lucro (R$):");

        lblSale.setText("Venda (R$):");

        txtObservation.setColumns(20);
        txtObservation.setLineWrap(true);
        txtObservation.setRows(5);
        txtObservation.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Observação", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jScrollPane1.setViewportView(txtObservation);

        lblStock.setText("Estoque:");

        fieldStock.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        fieldStock.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        cmdNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/new-pro.png"))); // NOI18N
        cmdNew.setText("Novo");
        cmdNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdNewActionPerformed(evt);
            }
        });

        cmdSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save-pro.png"))); // NOI18N
        cmdSave.setText("Salvar");
        cmdSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSaveActionPerformed(evt);
            }
        });

        cmdCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reflesh.png"))); // NOI18N
        cmdCancel.setText("Cancelar");
        cmdCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCancelActionPerformed(evt);
            }
        });

        cmdExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/power.png"))); // NOI18N
        cmdExit.setText("Sair");
        cmdExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdExitActionPerformed(evt);
            }
        });

        lblWarranty.setText("Garantia:");

        lblCommission.setText("Comissão:");

        compImage.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImage.setToolTipText("Add product image");
        lblImage.setComponentPopupMenu(popUpImagem);
        lblImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblImageMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout compImageLayout = new javax.swing.GroupLayout(compImage);
        compImage.setLayout(compImageLayout);
        compImageLayout.setHorizontalGroup(
            compImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        compImageLayout.setVerticalGroup(
            compImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout jpnFieldsLayout = new javax.swing.GroupLayout(jpnFields);
        jpnFields.setLayout(jpnFieldsLayout);
        jpnFieldsLayout.setHorizontalGroup(
            jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnFieldsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnFieldsLayout.createSequentialGroup()
                        .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fieldDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDescription))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpnFieldsLayout.createSequentialGroup()
                                .addComponent(lblCodeBar)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jpnFieldsLayout.createSequentialGroup()
                                .addComponent(fieldCodeBar)
                                .addContainerGap())))
                    .addGroup(jpnFieldsLayout.createSequentialGroup()
                        .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpnFieldsLayout.createSequentialGroup()
                                .addComponent(fieldProductId, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(checkImported, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rbNew)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbUsedProduct)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rbOfUsed))
                            .addGroup(jpnFieldsLayout.createSequentialGroup()
                                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbxBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblBrand))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbxUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblUnit))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbxCategory, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jpnFieldsLayout.createSequentialGroup()
                                        .addComponent(lblCategory)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnFieldsLayout.createSequentialGroup()
                                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpnFieldsLayout.createSequentialGroup()
                                        .addComponent(lblSection)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(cbxProductSection, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblSupplier)
                                    .addGroup(jpnFieldsLayout.createSequentialGroup()
                                        .addComponent(cbxSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmdSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jpnFieldsLayout.createSequentialGroup()
                                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpnFieldsLayout.createSequentialGroup()
                                        .addComponent(fieldCompra)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(jpnFieldsLayout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(77, 77, 77)))
                                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fieldMargem, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fieldProfit, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpnFieldsLayout.createSequentialGroup()
                                        .addComponent(lblSale, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(79, 79, 79))
                                    .addComponent(fieldVenda, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)))
                            .addGroup(jpnFieldsLayout.createSequentialGroup()
                                .addComponent(compImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1))
                            .addGroup(jpnFieldsLayout.createSequentialGroup()
                                .addComponent(lblProdutcId)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jpnFieldsLayout.createSequentialGroup()
                                .addComponent(cmdNew)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmdSave)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmdCancel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmdExit))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnFieldsLayout.createSequentialGroup()
                                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpnFieldsLayout.createSequentialGroup()
                                        .addComponent(lblWarranty)
                                        .addGap(0, 211, Short.MAX_VALUE))
                                    .addComponent(fieldWarranty))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnFieldsLayout.createSequentialGroup()
                                        .addComponent(fieldCommission, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnFieldsLayout.createSequentialGroup()
                                        .addComponent(lblCommission)
                                        .addGap(199, 199, 199)))
                                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblStock)
                                    .addComponent(fieldStock, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())))
        );
        jpnFieldsLayout.setVerticalGroup(
            jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnFieldsLayout.createSequentialGroup()
                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnFieldsLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(lblProdutcId, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(checkImported, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                            .addComponent(fieldProductId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpnFieldsLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(rbOfUsed, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rbUsedProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rbNew, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(7, 7, 7)
                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDescription, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCodeBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldDescription)
                    .addComponent(fieldCodeBar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBrand, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblUnit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCategory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxBrand, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                    .addComponent(cbxCategory)
                    .addComponent(cbxUnit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSection, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(cbxSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(cmdSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbxProductSection, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSale, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldCompra)
                    .addComponent(fieldMargem)
                    .addComponent(fieldProfit)
                    .addComponent(fieldVenda))
                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jpnFieldsLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(compImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jpnFieldsLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStock)
                    .addComponent(lblCommission, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblWarranty))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldStock)
                    .addComponent(fieldCommission, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldWarranty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdNew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmdSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmdCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmdExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cmdExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdExitActionPerformed
        this.dispose();
    }//GEN-LAST:event_cmdExitActionPerformed

    private void cmdCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCancelActionPerformed
        stock = this.rollback;
        this.fields(stock);
        this.eventClick();
    }//GEN-LAST:event_cmdCancelActionPerformed

    private void cmdSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSaveActionPerformed
        try {
            save();
        } catch (Exception e) {
            System.out.println("Error save: ".concat(e.getMessage()));
        }
    }//GEN-LAST:event_cmdSaveActionPerformed

    private void fieldCompraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldCompraKeyReleased

        fieldMargemKeyReleased(evt);


    }//GEN-LAST:event_fieldCompraKeyReleased

    private void fieldMargemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldMargemKeyReleased
        String venda = PercentValue.venda(fieldCompra.getText(), fieldMargem.getText());
        fieldVenda.setText(venda);
    }//GEN-LAST:event_fieldMargemKeyReleased

    private void fieldVendaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldVendaKeyReleased
        String percente = PercentValue.percente(fieldCompra.getText(), fieldVenda.getText());
        fieldMargem.setText(percente);
    }//GEN-LAST:event_fieldVendaKeyReleased

    private void fieldDescriptionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldDescriptionKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            fieldCodeBar.requestFocus();

        }
    }//GEN-LAST:event_fieldDescriptionKeyPressed

    private void fieldCodeBarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldCodeBarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            cbxBrand.requestFocus();

        }
    }//GEN-LAST:event_fieldCodeBarKeyPressed

    private void cbxBrandKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbxBrandKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            cbxUnit.requestFocus();

        }
    }//GEN-LAST:event_cbxBrandKeyPressed

    private void cbxUnitKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbxUnitKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            cbxCategory.requestFocus();

        }
    }//GEN-LAST:event_cbxUnitKeyPressed

    private void cbxCategoryKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbxCategoryKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            cbxProductSection.requestFocus();

        }
    }//GEN-LAST:event_cbxCategoryKeyPressed

    private void cbxProductSectionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbxProductSectionKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            fieldCompra.requestFocus();

        }
    }//GEN-LAST:event_cbxProductSectionKeyPressed

    private void fieldCompraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldCompraKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            fieldVenda.requestFocus();

        }
    }//GEN-LAST:event_fieldCompraKeyPressed

    private void cmdNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdNewActionPerformed
        this.eventClick();
    }//GEN-LAST:event_cmdNewActionPerformed

    private void fieldProfitKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldProfitKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldProfitKeyReleased

    private void jmnItemAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnItemAddActionPerformed

        try {
            this.openFileImage();
        } catch (Exception e) {
            System.out.println("Null value");
        }
    }//GEN-LAST:event_jmnItemAddActionPerformed

    private void jmnItemClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnItemClearActionPerformed
        imagePath = null;
        lblImage.setIcon(null);
    }//GEN-LAST:event_jmnItemClearActionPerformed

    private void jmnWebcamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnWebcamActionPerformed
        JOptionPane.showMessageDialog(rootPane, "Not implement");
    }//GEN-LAST:event_jmnWebcamActionPerformed

    private void lblImageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImageMouseClicked
        if (evt.getClickCount() == 2) {
            jmnItemAddActionPerformed(null);
        }
    }//GEN-LAST:event_lblImageMouseClicked

    //
    private void openFileImage() throws Exception {

        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Selecting image file...");
        chooser.setFileFilter(ControlImage.getFilter());
        chooser.showOpenDialog(this);
        imagePath = chooser.getSelectedFile().getAbsolutePath();
        lblImage.setIcon(this.getImage(imagePath));

    }

    private ImageIcon getImage(String path) {
        ImageIcon icon = null;
        try {
            if (!path.equals("")) {
                icon = new ControlImage(path).imageIcon();
            }
        } catch (Exception e) {
            System.out.println("Not found image default.");
        }
        return icon;
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
    private javax.swing.JComboBox<entity.product.Brand> cbxBrand;
    private javax.swing.JComboBox<entity.product.Category> cbxCategory;
    private javax.swing.JComboBox<entity.product.ProductSection> cbxProductSection;
    private javax.swing.JComboBox<entity.person.Company> cbxSupplier;
    private javax.swing.JComboBox<entity.product.Measure> cbxUnit;
    private javax.swing.JCheckBox checkImported;
    private javax.swing.JButton cmdCancel;
    private javax.swing.JButton cmdExit;
    private javax.swing.JButton cmdNew;
    private javax.swing.JButton cmdSave;
    private javax.swing.JButton cmdSupplier;
    private javax.swing.JPanel compImage;
    private javax.swing.JTextField fieldCodeBar;
    private javax.swing.JFormattedTextField fieldCommission;
    private javax.swing.JFormattedTextField fieldCompra;
    private javax.swing.JTextField fieldDescription;
    private javax.swing.JFormattedTextField fieldMargem;
    private javax.swing.JTextField fieldProductId;
    private javax.swing.JFormattedTextField fieldProfit;
    private javax.swing.JFormattedTextField fieldStock;
    private javax.swing.JFormattedTextField fieldVenda;
    private javax.swing.JFormattedTextField fieldWarranty;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JMenuItem jmnItemAdd;
    private javax.swing.JMenuItem jmnItemClear;
    private javax.swing.JMenuItem jmnWebcam;
    private javax.swing.JPanel jpnFields;
    private javax.swing.JLabel lblBrand;
    private javax.swing.JLabel lblCategory;
    private javax.swing.JLabel lblCodeBar;
    private javax.swing.JLabel lblCommission;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblProdutcId;
    private javax.swing.JLabel lblSale;
    private javax.swing.JLabel lblSection;
    private javax.swing.JLabel lblStock;
    private javax.swing.JLabel lblSupplier;
    private javax.swing.JLabel lblUnit;
    private javax.swing.JLabel lblWarranty;
    private javax.swing.JPopupMenu popUpImagem;
    private javax.swing.JRadioButton rbNew;
    private javax.swing.JRadioButton rbOfUsed;
    private javax.swing.JRadioButton rbUsedProduct;
    private javax.swing.JTextArea txtObservation;
    // End of variables declaration//GEN-END:variables
}
