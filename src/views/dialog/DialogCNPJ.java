package views.dialog;

import entities.entity.person.Cnpj;
import entities.entity.uf.States;
import enu.FieldChar;
import impl.ImplState;
import impl.ImplCNPJ;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import util.ControlPanel;
import util.FormatNumber;

public class DialogCNPJ extends javax.swing.JDialog {

    ImplCNPJ crudPessoa;
    private Cnpj cnpj;
    private Cnpj cancel;

    public DialogCNPJ(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.cnpj = new Cnpj();
        initComponents();
        this.chooserNasc.setDate(new Date());
        updateComboBox();
        this.events();

    }

    public DialogCNPJ(java.awt.Frame parent, boolean modal, Cnpj cnpj) {
        super(parent, modal);
        initComponents();
        updateComboBox();
        fields(cnpj);
        this.cancel = cnpj;
        this.events();
        this.eventClick();

    }

    private void updateComboBox() {

        fieldNome.requestFocus();
        ImplState uf = new ImplState();
        cbxUf.removeAllItems();
        uf.findAll().forEach(item -> cbxUf.addItem(item));
        ControlPanel.borderLabel(jpnFields);
    }

    private void events() {
        FormatNumber.formatFieldPoint(fieldCredito, FieldChar.vk_comma);
        this.keyEventChooser();
    }

    private void fields(Cnpj cnpj) {
        try {
            this.cnpj = cnpj;

            ckbSituacao.setSelected(cnpj.getActive());

            fieldCode.setText(String.valueOf(cnpj.getId()));
            fieldNome.setText(cnpj.getRazaoSocial());
            fieldNomeFantasia.setText(cnpj.getNomeFantasia());

            fieldCNPJ.setText(cnpj.getCnpjNumber());
            fieldInscEstadual.setText(cnpj.getInscEstadual());
            fieldInscMunicipal.setText(cnpj.getInscMunicipal());
            chooserNasc.setDate(cnpj.getNascimento());
            fieldCredito.setText(String.valueOf(cnpj.getCredito()).replace(".", ","));

            fieldFone.setText(cnpj.getFone());
            fieldCelular.setText(cnpj.getCelular());
            fieldWhatsapp.setText(cnpj.getWhatsapp());
            fieldEmail.setText(cnpj.getEmail());
            fieldRua.setText(cnpj.getRua());
            fieldReferencia.setText(cnpj.getReferencia());
            fieldCep.setText(cnpj.getCep());
            fieldBairro.setText(cnpj.getBairro());
            fieldCidade.setText(cnpj.getCidade());

            cbxUf.setSelectedItem(cnpj.getEstado());
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        cmdDispose = new javax.swing.JButton();
        cmdGravar = new javax.swing.JButton();
        cmdNovo = new javax.swing.JButton();
        jpnFields = new javax.swing.JPanel();
        fieldNome = new javax.swing.JTextField();
        fieldCredito = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        fieldInscMunicipal = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        chooserNasc = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        ckbSituacao = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        fieldEmail = new javax.swing.JTextField();
        fieldCode = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        fieldFone = new javax.swing.JFormattedTextField();
        fieldCNPJ = new javax.swing.JFormattedTextField();
        fieldCelular = new javax.swing.JFormattedTextField();
        fieldWhatsapp = new javax.swing.JFormattedTextField();
        jLabel13 = new javax.swing.JLabel();
        fieldRua = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        fieldReferencia = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        fieldBairro = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        fieldCidade = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        fieldCep = new javax.swing.JFormattedTextField();
        jLabel19 = new javax.swing.JLabel();
        cbxUf = new javax.swing.JComboBox<>();
        fieldInscEstadual = new javax.swing.JFormattedTextField();
        fieldNomeFantasia = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        cmdCancelar = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        jLabel16.setText("jLabel16");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CADASTRAR PESSOA JURÍDICA");
        setIconImage(new ImageIcon(getClass().getResource("/views/img/cnpj.png")).getImage());
        setModal(true);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cmdDispose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/img/power.png"))); // NOI18N
        cmdDispose.setText("Sair");
        cmdDispose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdDisposeActionPerformed(evt);
            }
        });

        cmdGravar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/img/client_confirm.png"))); // NOI18N
        cmdGravar.setText("Salvar");
        cmdGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdGravarActionPerformed(evt);
            }
        });
        cmdGravar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmdGravarKeyPressed(evt);
            }
        });

        cmdNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/img/client_add.png"))); // NOI18N
        cmdNovo.setText("Novo");
        cmdNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdNovoActionPerformed(evt);
            }
        });

        jpnFields.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        fieldNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldNomeKeyPressed(evt);
            }
        });

        fieldCredito.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        fieldCredito.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldCreditoKeyPressed(evt);
            }
        });

        jLabel2.setText("Código:");

        jLabel6.setText("Insc. Municipal:");

        jLabel7.setText("Insc. Estadual:");

        jLabel5.setText("Crédito:");

        fieldInscMunicipal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldInscMunicipalKeyPressed(evt);
            }
        });

        jLabel9.setText("Fone:");

        jLabel12.setText("Email:");

        chooserNasc.setDateFormatString("dd/MM/yyyy");

        jLabel8.setText("Fund.:");

        ckbSituacao.setSelected(true);
        ckbSituacao.setText("Ativo");

        jLabel4.setText("CNPJ:");

        jLabel3.setText("Razão social:");

        jLabel10.setText("Celular:");

        fieldEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldEmailKeyPressed(evt);
            }
        });

        fieldCode.setEditable(false);
        fieldCode.setBackground(new java.awt.Color(255, 255, 255));
        fieldCode.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        fieldCode.setFocusable(false);

        jLabel11.setText("Whatsapp:");

        try {
            fieldFone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        fieldFone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldFoneKeyPressed(evt);
            }
        });

        try {
            fieldCNPJ.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        fieldCNPJ.setText("");
        fieldCNPJ.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldCNPJKeyPressed(evt);
            }
        });

        try {
            fieldCelular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        fieldCelular.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldCelularKeyPressed(evt);
            }
        });

        try {
            fieldWhatsapp.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        fieldWhatsapp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldWhatsappKeyPressed(evt);
            }
        });

        jLabel13.setText("Logradouro:");

        fieldRua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldRuaKeyPressed(evt);
            }
        });

        jLabel14.setText("Referência:");

        fieldReferencia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldReferenciaKeyPressed(evt);
            }
        });

        jLabel17.setText("Bairro:");

        fieldBairro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldBairroKeyPressed(evt);
            }
        });

        jLabel18.setText("Cidade:");

        fieldCidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldCidadeKeyPressed(evt);
            }
        });

        jLabel15.setText("CEP:");

        try {
            fieldCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        fieldCep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldCepKeyPressed(evt);
            }
        });

        jLabel19.setText("UF:");

        cbxUf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbxUfKeyPressed(evt);
            }
        });

        try {
            fieldInscEstadual.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-######-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        fieldInscEstadual.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldInscEstadualKeyPressed(evt);
            }
        });

        fieldNomeFantasia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldNomeFantasiaKeyPressed(evt);
            }
        });

        jLabel20.setText("Nome de fantasia:");

        javax.swing.GroupLayout jpnFieldsLayout = new javax.swing.GroupLayout(jpnFields);
        jpnFields.setLayout(jpnFieldsLayout);
        jpnFieldsLayout.setHorizontalGroup(
            jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnFieldsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnFieldsLayout.createSequentialGroup()
                        .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jpnFieldsLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(chooserNasc, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(fieldFone, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpnFieldsLayout.createSequentialGroup()
                                        .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(fieldCelular)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(fieldWhatsapp)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(fieldEmail)
                                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jpnFieldsLayout.createSequentialGroup()
                                        .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(fieldInscMunicipal, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                                            .addComponent(fieldInscEstadual))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(fieldCredito, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jpnFieldsLayout.createSequentialGroup()
                                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jpnFieldsLayout.createSequentialGroup()
                                        .addComponent(fieldCode, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(ckbSituacao))
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel20)
                                    .addComponent(fieldNomeFantasia, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpnFieldsLayout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(fieldCNPJ)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpnFieldsLayout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(1, 1, 1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnFieldsLayout.createSequentialGroup()
                        .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fieldRua)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(fieldReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnFieldsLayout.createSequentialGroup()
                        .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(fieldBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(fieldCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(fieldCep, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbxUf, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jpnFieldsLayout.setVerticalGroup(
            jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnFieldsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ckbSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldNomeFantasia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chooserNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fieldInscMunicipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fieldCredito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fieldInscEstadual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(jLabel11)
                        .addComponent(jLabel12)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldFone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldWhatsapp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(jLabel15)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(75, Short.MAX_VALUE))
        );

        jpnFieldsLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {ckbSituacao, fieldCode});

        jpnFieldsLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel3, jLabel4});

        jpnFieldsLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel5, jLabel6, jLabel7, jLabel8});

        jpnFieldsLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {chooserNasc, fieldCredito, fieldInscMunicipal});

        jpnFieldsLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel10, jLabel11, jLabel12, jLabel9});

        cmdCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/img/reflesh.png"))); // NOI18N
        cmdCancelar.setText("Cancelar");
        cmdCancelar.setEnabled(false);
        cmdCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpnFields, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cmdNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdGravar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmdDispose)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnFields, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdNovo)
                    .addComponent(cmdGravar)
                    .addComponent(cmdDispose)
                    .addComponent(cmdCancelar))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cmdDisposeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdDisposeActionPerformed
        this.dispose();
    }//GEN-LAST:event_cmdDisposeActionPerformed

    private void cmdGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdGravarActionPerformed
        try {
            this.save();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_cmdGravarActionPerformed


    private void cmdNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdNovoActionPerformed
        this.cnpj = new Cnpj();
        ControlPanel.clean(jpnFields);
        this.eventClick();
    }//GEN-LAST:event_cmdNovoActionPerformed

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
    private void fieldNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldNomeKeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            fieldNomeFantasia.requestFocus();
        }
    }//GEN-LAST:event_fieldNomeKeyPressed

    private void fieldCNPJKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldCNPJKeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            chooserNasc.requestFocusInWindow();

        }
    }//GEN-LAST:event_fieldCNPJKeyPressed

    private void keyEventChooser() {

        chooserNasc.getDateEditor().getUiComponent().addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                    fieldInscMunicipal.requestFocus();

                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

    }


    private void fieldInscMunicipalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldInscMunicipalKeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            fieldInscEstadual.requestFocus();
        }
    }//GEN-LAST:event_fieldInscMunicipalKeyPressed

    private void fieldCreditoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldCreditoKeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            fieldFone.requestFocus();
        }


    }//GEN-LAST:event_fieldCreditoKeyPressed

    private void fieldFoneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldFoneKeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            fieldCelular.requestFocus();
        }
    }//GEN-LAST:event_fieldFoneKeyPressed

    private void fieldCelularKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldCelularKeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            fieldWhatsapp.requestFocus();
        }
    }//GEN-LAST:event_fieldCelularKeyPressed

    private void fieldWhatsappKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldWhatsappKeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            fieldEmail.requestFocus();
        }
    }//GEN-LAST:event_fieldWhatsappKeyPressed

    private void fieldEmailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldEmailKeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            fieldRua.requestFocus();
        }
    }//GEN-LAST:event_fieldEmailKeyPressed

    private void fieldRuaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldRuaKeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            fieldReferencia.requestFocus();
        }
    }//GEN-LAST:event_fieldRuaKeyPressed

    private void fieldReferenciaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldReferenciaKeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            fieldBairro.requestFocus();
        }
    }//GEN-LAST:event_fieldReferenciaKeyPressed

    private void fieldBairroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldBairroKeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            fieldCidade.requestFocus();
        }
    }//GEN-LAST:event_fieldBairroKeyPressed

    private void fieldCidadeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldCidadeKeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            fieldCep.requestFocus();
        }
    }//GEN-LAST:event_fieldCidadeKeyPressed

    private void fieldCepKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldCepKeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            cbxUf.requestFocus();
        }
    }//GEN-LAST:event_fieldCepKeyPressed

    private void cbxUfKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbxUfKeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            cmdGravar.requestFocus();
        }
    }//GEN-LAST:event_cbxUfKeyPressed

    private void cmdGravarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmdGravarKeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            cmdGravarActionPerformed(null);
        }
    }//GEN-LAST:event_cmdGravarKeyPressed

    private void fieldInscEstadualKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldInscEstadualKeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            fieldCredito.requestFocus();
        }
    }//GEN-LAST:event_fieldInscEstadualKeyPressed

    private void cmdCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCancelarActionPerformed
        fields(cancel);
        this.eventClick();
    }//GEN-LAST:event_cmdCancelarActionPerformed

    private void fieldNomeFantasiaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldNomeFantasiaKeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            fieldCNPJ.requestFocus();
        }
    }//GEN-LAST:event_fieldNomeFantasiaKeyPressed

    private void save() throws Exception {

        cnpj.setRazaoSocial(fieldNome.getText().toUpperCase().trim());
        if (cnpj.getRazaoSocial().equals("")) {
            throw new Exception("O campo razão social não pode ser vazio.\nVerifique e tente novamente");
        }

        cnpj.setNascimento(chooserNasc.getDate());
        if (cnpj.getNascimento() == null) {
            throw new Exception("O campo Nascimento não pode ser vazio.\nVerifique e tente novamente");
        }
        cnpj.setNomeFantasia(fieldNomeFantasia.getText().trim().toUpperCase());
        cnpj.setCredito(Double.parseDouble(0 + fieldCredito.getText().replace(",", ".")));
        cnpj.setActive(ckbSituacao.isSelected());
        cnpj.setCnpjNumber(fieldCNPJ.getText());
        cnpj.setInscEstadual(fieldInscEstadual.getText());
        cnpj.setInscMunicipal(fieldInscMunicipal.getText());
        cnpj.setFone(fieldFone.getText());
        cnpj.setCelular(fieldCelular.getText());
        cnpj.setWhatsapp(fieldWhatsapp.getText());
        cnpj.setEmail(fieldEmail.getText().toLowerCase().trim());
        cnpj.setRua(fieldRua.getText().toUpperCase().trim());
        cnpj.setReferencia(fieldReferencia.getText().toUpperCase().trim());
        cnpj.setCep(fieldCep.getText());
        cnpj.setBairro(fieldBairro.getText().toUpperCase().trim());
        cnpj.setCidade(fieldCidade.getText().toUpperCase().trim());

        cnpj.setEstado((States) cbxUf.getSelectedItem());
        crudPessoa = new ImplCNPJ();
        crudPessoa.save(cnpj);
        JOptionPane.showMessageDialog(rootPane, "Salvo com sucesso!");

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogCNPJ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            DialogCNPJ dialog = new DialogCNPJ(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<States> cbxUf;
    private com.toedter.calendar.JDateChooser chooserNasc;
    private javax.swing.JCheckBox ckbSituacao;
    private javax.swing.JButton cmdCancelar;
    private javax.swing.JButton cmdDispose;
    private javax.swing.JButton cmdGravar;
    private javax.swing.JButton cmdNovo;
    private javax.swing.JTextField fieldBairro;
    private javax.swing.JFormattedTextField fieldCNPJ;
    private javax.swing.JFormattedTextField fieldCelular;
    private javax.swing.JFormattedTextField fieldCep;
    private javax.swing.JTextField fieldCidade;
    private javax.swing.JTextField fieldCode;
    private javax.swing.JFormattedTextField fieldCredito;
    private javax.swing.JTextField fieldEmail;
    private javax.swing.JFormattedTextField fieldFone;
    private javax.swing.JFormattedTextField fieldInscEstadual;
    private javax.swing.JTextField fieldInscMunicipal;
    private javax.swing.JTextField fieldNome;
    private javax.swing.JTextField fieldNomeFantasia;
    private javax.swing.JTextField fieldReferencia;
    private javax.swing.JTextField fieldRua;
    private javax.swing.JFormattedTextField fieldWhatsapp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jpnFields;
    // End of variables declaration//GEN-END:variables
}
