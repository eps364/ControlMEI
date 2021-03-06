package views.dialog;

import entity.person.Company;
import entity.stage.State;
import enu.FieldChar;
import impl.ImplState;
import impl.ImplCompany;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import util.ControlPanel;
import util.FormatNumber;

public class DialogCompany extends javax.swing.JDialog {

    ImplCompany crudPessoa;
    private Company company;
    private Company companyCancel;

    public DialogCompany(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.company = new Company();
        initComponents();
        this.chooserNasc.setDate(new Date());
        updateComboBox();
        this.formatNumber();
        this.eventClick();

    }

    public DialogCompany(java.awt.Frame parent, boolean modal, Company company) {
        super(parent, modal);
        initComponents();
        updateComboBox();
        fields(company);
        this.companyCancel = company;
        this.formatNumber();
    }

    private void updateComboBox() {

        fieldNome.requestFocus();
        ImplState uf = new ImplState();
        cbxUf.removeAllItems();
        uf.findAll().forEach(item -> cbxUf.addItem(item));
        ControlPanel.borderLabel(jpnFields);
    }

    private void formatNumber() {
        FormatNumber.formatFieldPoint(fieldCredito, FieldChar.vk_comma);
        FormatNumber.formatFieldPoint(fieldCredito, FieldChar.vk_comma);
        FormatNumber.formatFieldPoint(fieldCredito, FieldChar.vk_comma);

        this.keyEventChooser();
    }

    private void fields(Company company) {
        try {
            this.company = company;

            ckbSituacao.setSelected(company.getPersonStatus());

            fieldCode.setText(String.valueOf(company.getId()));
            fieldNome.setText(company.getPersonName());
            fieldNomeFantasia.setText(company.getFantasyName());

            fieldCNPJ.setText(company.getCnpjNumber());
            fieldInscricao.setText(company.getStateRegister());
            chooserNasc.setDate(company.getNascimento());
            fieldCredito.setText(String.valueOf(company.getValueCredit()).replace(".", ","));

            fieldFone.setText(company.getPhone());
            fieldCelular.setText(company.getCellPhone());
            fieldWhatsapp.setText(company.getWhatsapp());
            fieldEmail.setText(company.getEmail());
            fieldRua.setText(company.getStreet());
            fieldReferencia.setText(company.getReference());
            fieldCep.setText(company.getZipCode());
            fieldBairro.setText(company.getDistrictName());
            fieldCidade.setText(company.getCityName());

            cbxUf.setSelectedItem(company.getState());
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
        cmdSave = new javax.swing.JButton();
        cmdNew = new javax.swing.JButton();
        jpnFields = new javax.swing.JPanel();
        fieldNome = new javax.swing.JTextField();
        fieldCredito = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
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
        fieldInscricao = new javax.swing.JFormattedTextField();
        fieldNomeFantasia = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        cmdCancel = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        jLabel16.setText("jLabel16");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CADASTRAR PESSOA JURÍDICA");
        setIconImage(new ImageIcon(getClass().getResource("/img/cnpj.png")).getImage());
        setModal(true);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cmdDispose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/power.png"))); // NOI18N
        cmdDispose.setText("Sair");
        cmdDispose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdDisposeActionPerformed(evt);
            }
        });

        cmdSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/client_confirm.png"))); // NOI18N
        cmdSave.setText("Salvar");
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

        cmdNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/client_add.png"))); // NOI18N
        cmdNew.setText("Novo");
        cmdNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdNewActionPerformed(evt);
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

        jLabel7.setText("Inscrição:");

        jLabel5.setText("Crédito:");

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

        fieldInscricao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        fieldInscricao.setText("");
        fieldInscricao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldInscricaoKeyPressed(evt);
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
                                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(fieldFone, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpnFieldsLayout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpnFieldsLayout.createSequentialGroup()
                                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpnFieldsLayout.createSequentialGroup()
                                        .addComponent(fieldCode, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(ckbSituacao))
                                    .addComponent(fieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpnFieldsLayout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jpnFieldsLayout.createSequentialGroup()
                                        .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(fieldNomeFantasia)
                                            .addGroup(jpnFieldsLayout.createSequentialGroup()
                                                .addComponent(jLabel20)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(fieldCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jpnFieldsLayout.createSequentialGroup()
                                .addComponent(chooserNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fieldInscricao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(fieldCredito, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                    .addComponent(jLabel7)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chooserNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fieldCredito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fieldInscricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addContainerGap(80, Short.MAX_VALUE))
        );

        jpnFieldsLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {ckbSituacao, fieldCode});

        jpnFieldsLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel3, jLabel4});

        jpnFieldsLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel5, jLabel7, jLabel8});

        jpnFieldsLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {chooserNasc, fieldCredito});

        jpnFieldsLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel10, jLabel11, jLabel12, jLabel9});

        cmdCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reflesh.png"))); // NOI18N
        cmdCancel.setText("Cancelar");
        cmdCancel.setEnabled(false);
        cmdCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCancelActionPerformed(evt);
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
                        .addComponent(cmdNew)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmdDispose)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnFields, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdNew)
                    .addComponent(cmdSave)
                    .addComponent(cmdDispose)
                    .addComponent(cmdCancel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cmdDisposeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdDisposeActionPerformed
        this.dispose();
    }//GEN-LAST:event_cmdDisposeActionPerformed

    private void cmdSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSaveActionPerformed
        try {
            if (ControlPanel.emailValidate(fieldEmail.getText())) {
                this.save();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Invalid email.\nCheck and try again.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_cmdSaveActionPerformed


    private void cmdNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdNewActionPerformed
        this.company = new Company();
        ControlPanel.clean(jpnFields);
        this.eventClick();
    }//GEN-LAST:event_cmdNewActionPerformed

    private void eventClick() {
        boolean isClick = cmdNew.isEnabled();
        if (isClick) {
            cmdNew.setEnabled(false);
            cmdCancel.setEnabled(true);
        } else {
            cmdCancel.setEnabled(false);
            cmdNew.setEnabled(true);
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
                    fieldInscricao.requestFocus();

                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

    }


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
            cmdSave.requestFocus();
        }
    }//GEN-LAST:event_cbxUfKeyPressed

    private void cmdSaveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmdSaveKeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            cmdSaveActionPerformed(null);
        }
    }//GEN-LAST:event_cmdSaveKeyPressed

    private void fieldInscricaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldInscricaoKeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            fieldCredito.requestFocus();
        }
    }//GEN-LAST:event_fieldInscricaoKeyPressed

    private void cmdCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCancelActionPerformed
        fields(companyCancel);
        this.eventClick();
    }//GEN-LAST:event_cmdCancelActionPerformed

    private void fieldNomeFantasiaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldNomeFantasiaKeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            fieldCNPJ.requestFocus();
        }
    }//GEN-LAST:event_fieldNomeFantasiaKeyPressed

    private void save() throws Exception {

        company.setPersonName(fieldNome.getText().toUpperCase().trim());
        if (company.getPersonName().equals("")) {
            throw new IllegalArgumentException("O campo razão social não pode ser vazio.\nVerifique e tente novamente");
        }

        company.setDateBirth(chooserNasc.getDate());
        if (company.getNascimento() == null) {
            throw new IllegalArgumentException("O campo Nascimento não pode ser vazio.\nVerifique e tente novamente");
        }
        company.setFantasyName(fieldNomeFantasia.getText().trim().toUpperCase());
        company.setValueCredit(Double.parseDouble(0 + fieldCredito.getText().replace(",", ".")));
        company.setPersonStatus(ckbSituacao.isSelected());
        company.setCnpjNumber(fieldCNPJ.getText());
        company.setStateRegister(fieldInscricao.getText());
        company.setPhone(fieldFone.getText());
        company.setCellPhone(fieldCelular.getText());
        company.setWhatsapp(fieldWhatsapp.getText());
        company.setEmail(fieldEmail.getText().toLowerCase().trim());
        company.setStreet(fieldRua.getText().toUpperCase().trim());
        company.setReference(fieldReferencia.getText().toUpperCase().trim());
        company.setZipCode(fieldCep.getText());
        company.setDistrictName(fieldBairro.getText().toUpperCase().trim());
        company.setCityName(fieldCidade.getText().toUpperCase().trim());

        company.setState((State) cbxUf.getSelectedItem());
        crudPessoa = new ImplCompany();
        crudPessoa.save(company);
        if (ControlPanel.optionPaneSave("Saved uccessfully!")) {
            cmdDisposeActionPerformed(null);
        }

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
            java.util.logging.Logger.getLogger(DialogCompany.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
            DialogCompany dialog = new DialogCompany(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<entity.stage.State> cbxUf;
    private com.toedter.calendar.JDateChooser chooserNasc;
    private javax.swing.JCheckBox ckbSituacao;
    private javax.swing.JButton cmdCancel;
    private javax.swing.JButton cmdDispose;
    private javax.swing.JButton cmdNew;
    private javax.swing.JButton cmdSave;
    private javax.swing.JTextField fieldBairro;
    private javax.swing.JFormattedTextField fieldCNPJ;
    private javax.swing.JFormattedTextField fieldCelular;
    private javax.swing.JFormattedTextField fieldCep;
    private javax.swing.JTextField fieldCidade;
    private javax.swing.JTextField fieldCode;
    private javax.swing.JFormattedTextField fieldCredito;
    private javax.swing.JTextField fieldEmail;
    private javax.swing.JFormattedTextField fieldFone;
    private javax.swing.JFormattedTextField fieldInscricao;
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
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jpnFields;
    // End of variables declaration//GEN-END:variables
}
