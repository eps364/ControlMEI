package views.dialog;

import entity.person.Customer;
import entity.stage.State;

import enu.FieldChar;
import enu.TypePerson;

import impl.ImplState;

import impl.ImplCustomer;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;
import javax.swing.ImageIcon;

import javax.swing.JOptionPane;

import util.ControlPanel;

import util.FormatNumber;

public class DialogCustomer extends javax.swing.JDialog {

    ImplCustomer crudPessoa;

    private Customer cpf;

    private Customer cancel;

    public DialogCustomer(java.awt.Frame parent, boolean modal) {

        super(parent, modal);

        this.cpf = new Customer();

        initComponents();

        updateComboBox();

        this.formatNumber();
        this.chooserNasc.setDate(new Date());
        this.eventClick();

    }

    public DialogCustomer(java.awt.Frame parent, boolean modal, Customer cpf) {

        super(parent, modal);

        initComponents();

        updateComboBox();

        fields(cpf);

        this.cancel = cpf;

        this.formatNumber();

    }

    private void updateComboBox() {

        ControlPanel.borderLabel(jpnFields);

        fieldRazaoSocial.requestFocus();

        ImplState uf = new ImplState();

        cbxUf.removeAllItems();

        uf.findAll().forEach(item -> cbxUf.addItem(item));

    }

    private void formatNumber() {
        this.keyEventChooser();
        FormatNumber.formatFieldPoint(fieldCredito, FieldChar.vk_comma);
        FormatNumber.formatFieldPoint(fieldSalario, FieldChar.vk_comma);
        FormatNumber.formatFieldPoint(fieldRg, FieldChar.vk_null);

    }

    private void fields(Customer cpf) {
        try {

            this.cpf = cpf;

            ckbSituacao.setSelected(cpf.getPersonStatus());

            fieldCode.setText(String.valueOf(cpf.getId()));

            fieldRazaoSocial.setText(cpf.getPersonName());

            fieldCPF.setText(cpf.getSocialNumber());
            cbxSexName.setSelectedItem(cpf.getSexOfPerson());

            fieldRg.setText(cpf.getRg());

            fieldNomeApelido.setText(cpf.getNickname());

            chooserNasc.setDate(cpf.getNascimento());

            fieldCredito.setText(String.valueOf(cpf.getValueCredit()).replace(".", ","));

            fieldFone.setText(cpf.getPhone());

            fieldCelular.setText(cpf.getCellPhone());

            fieldWhatsapp.setText(cpf.getWhatsapp());

            fieldEmail.setText(cpf.getEmail());

            fieldRua.setText(cpf.getStreet());

            fieldReferencia.setText(cpf.getReference());

            fieldCep.setText(cpf.getZipCode());

            fieldBairro.setText(cpf.getDistrictName());

            fieldCidade.setText(cpf.getCityName());

            fieldProfissao.setText(cpf.getProfessionName());
            fieldLocalTrabalho.setText(cpf.getWorkplace());
            fieldSalario.setText(String.valueOf(cpf.getSalary()).replace(".", ","));

            cbxUf.setSelectedItem(cpf.getState());
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }

    }

    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        dadosPerson = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        cmdDispose = new javax.swing.JButton();
        cmdSave = new javax.swing.JButton();
        cmdNew = new javax.swing.JButton();
        jpnFields = new javax.swing.JPanel();
        fieldRazaoSocial = new javax.swing.JTextField();
        fieldCredito = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        fieldRg = new javax.swing.JTextField();
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
        fieldCPF = new javax.swing.JFormattedTextField();
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
        cbxUf = new javax.swing.JComboBox<entity.stage.State>();
        fieldNomeApelido = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        fieldProfissao = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        fieldLocalTrabalho = new javax.swing.JTextField();
        fieldSalario = new javax.swing.JFormattedTextField();
        jLabel22 = new javax.swing.JLabel();
        cbxSexName = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        cmdCancel = new javax.swing.JButton();
        jnpFields1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jpnFields1 = new javax.swing.JPanel();
        fieldRazaoSocial1 = new javax.swing.JTextField();
        fieldCredito1 = new javax.swing.JFormattedTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        fieldRg1 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        chooserNasc1 = new com.toedter.calendar.JDateChooser();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        fieldEmail1 = new javax.swing.JTextField();
        fieldCode1 = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        fieldFone1 = new javax.swing.JFormattedTextField();
        fieldCPF1 = new javax.swing.JFormattedTextField();
        fieldCelular1 = new javax.swing.JFormattedTextField();
        fieldWhatsapp1 = new javax.swing.JFormattedTextField();
        jLabel35 = new javax.swing.JLabel();
        fieldRua1 = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        fieldReferencia1 = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        fieldBairro1 = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        fieldCidade1 = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        fieldCep1 = new javax.swing.JFormattedTextField();
        jLabel40 = new javax.swing.JLabel();
        cbxUf1 = new javax.swing.JComboBox<entity.stage.State>();
        fieldNomeApelido1 = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        fieldProfissao1 = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        fieldLocalTrabalho1 = new javax.swing.JTextField();
        fieldSalario1 = new javax.swing.JFormattedTextField();
        jLabel43 = new javax.swing.JLabel();
        cbxSexName1 = new javax.swing.JComboBox<>();
        jLabel44 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        jLabel16.setText("jLabel16");

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CADASTRAR PESSOA FÍSICA");
        setIconImage(new ImageIcon(getClass().getResource("/img/cpf.png")).getImage());
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

        fieldRazaoSocial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldRazaoSocialKeyPressed(evt);
            }
        });

        fieldCredito.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        fieldCredito.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldCreditoKeyPressed(evt);
            }
        });

        jLabel2.setText("Código:");

        jLabel6.setText("RG:");

        jLabel7.setText("Nome de praça:");

        jLabel5.setText("Crédito:");

        fieldRg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldRgKeyPressed(evt);
            }
        });

        jLabel9.setText("Fone:");

        jLabel12.setText("Email:");

        chooserNasc.setDateFormatString("dd/MM/yyyy");

        jLabel8.setText("Nascimento:");

        ckbSituacao.setSelected(true);
        ckbSituacao.setText("Ativo");

        jLabel4.setText("CPF:");

        jLabel3.setText("Razão Social:");

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
            fieldCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        fieldCPF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldCPFKeyPressed(evt);
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

        fieldNomeApelido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldNomeApelidoKeyPressed(evt);
            }
        });

        jLabel20.setText("Profissão:");

        fieldProfissao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldProfissaoKeyPressed(evt);
            }
        });

        jLabel21.setText("Local de trabalho:");

        fieldLocalTrabalho.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldLocalTrabalhoKeyPressed(evt);
            }
        });

        fieldSalario.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        fieldSalario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldSalarioKeyPressed(evt);
            }
        });

        jLabel22.setText("Salário:");

        cbxSexName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Feminino" }));
        cbxSexName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbxSexNameKeyPressed(evt);
            }
        });

        jLabel23.setText("Sexo:");

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
                                            .addComponent(fieldRg, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                                            .addComponent(fieldNomeApelido))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(fieldCredito, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpnFieldsLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(484, 484, 484)
                                .addComponent(jLabel23)))
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
                        .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(fieldProfissao)
                            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fieldBairro, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(fieldLocalTrabalho)
                                .addComponent(fieldCidade, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                                .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
                            .addComponent(jLabel21))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(fieldSalario, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jpnFieldsLayout.createSequentialGroup()
                                    .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(fieldCep, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                        .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(cbxUf, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jpnFieldsLayout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnFieldsLayout.createSequentialGroup()
                        .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jpnFieldsLayout.createSequentialGroup()
                                .addComponent(fieldCode, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ckbSituacao)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jpnFieldsLayout.createSequentialGroup()
                                .addComponent(fieldRazaoSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpnFieldsLayout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(fieldCPF))))
                        .addGap(6, 6, 6)
                        .addComponent(cbxSexName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldRazaoSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxSexName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addComponent(fieldRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fieldCredito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fieldNomeApelido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldProfissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldLocalTrabalho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jpnFieldsLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {ckbSituacao, fieldCode});

        jpnFieldsLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel3, jLabel4});

        jpnFieldsLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel5, jLabel6, jLabel7, jLabel8});

        jpnFieldsLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {chooserNasc, fieldCredito, fieldRg});

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdNew)
                    .addComponent(cmdSave)
                    .addComponent(cmdDispose)
                    .addComponent(cmdCancel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        dadosPerson.addTab("DADOS PESSOAIS", jPanel1);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jpnFields1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        fieldRazaoSocial1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldRazaoSocial1KeyPressed(evt);
            }
        });

        fieldCredito1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        fieldCredito1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldCredito1KeyPressed(evt);
            }
        });

        jLabel24.setText("Código de usuário:");

        jLabel25.setText("PIS:");

        jLabel26.setText("Contratação:");

        jLabel27.setText("Crédito:");

        fieldRg1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldRg1KeyPressed(evt);
            }
        });

        jLabel28.setText("Carga Horária:");

        jLabel29.setText("Email:");

        chooserNasc1.setDateFormatString("dd/MM/yyyy");

        jLabel30.setText("Data Admissão:");

        jLabel31.setText("CNH:");

        jLabel32.setText("Casteira de Trabalho:");

        jLabel33.setText("Celular:");

        fieldEmail1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldEmail1KeyPressed(evt);
            }
        });

        fieldCode1.setEditable(false);
        fieldCode1.setBackground(new java.awt.Color(255, 255, 255));
        fieldCode1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        fieldCode1.setFocusable(false);

        jLabel34.setText("Whatsapp:");

        fieldFone1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getTimeInstance(java.text.DateFormat.SHORT))));
        fieldFone1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldFone1KeyPressed(evt);
            }
        });

        try {
            fieldCPF1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        fieldCPF1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldCPF1KeyPressed(evt);
            }
        });

        try {
            fieldCelular1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        fieldCelular1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldCelular1KeyPressed(evt);
            }
        });

        try {
            fieldWhatsapp1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        fieldWhatsapp1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldWhatsapp1KeyPressed(evt);
            }
        });

        jLabel35.setText("Nacionalidade:");

        fieldRua1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldRua1KeyPressed(evt);
            }
        });

        jLabel36.setText("Naturalidade:");

        fieldReferencia1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldReferencia1KeyPressed(evt);
            }
        });

        jLabel37.setText("Bairro:");

        fieldBairro1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldBairro1KeyPressed(evt);
            }
        });

        jLabel38.setText("Cidade:");

        fieldCidade1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldCidade1KeyPressed(evt);
            }
        });

        jLabel39.setText("CEP:");

        try {
            fieldCep1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        fieldCep1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldCep1KeyPressed(evt);
            }
        });

        jLabel40.setText("UF:");

        cbxUf1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbxUf1KeyPressed(evt);
            }
        });

        fieldNomeApelido1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldNomeApelido1KeyPressed(evt);
            }
        });

        jLabel41.setText("Profissão:");

        fieldProfissao1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldProfissao1KeyPressed(evt);
            }
        });

        jLabel42.setText("Local de trabalho:");

        fieldLocalTrabalho1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldLocalTrabalho1KeyPressed(evt);
            }
        });

        fieldSalario1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        fieldSalario1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldSalario1KeyPressed(evt);
            }
        });

        jLabel43.setText("Salário:");

        cbxSexName1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Casado", "Solteiro", "Diverciado" }));
        cbxSexName1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbxSexName1KeyPressed(evt);
            }
        });

        jLabel44.setText("Estado Civil:");

        javax.swing.GroupLayout jpnFields1Layout = new javax.swing.GroupLayout(jpnFields1);
        jpnFields1.setLayout(jpnFields1Layout);
        jpnFields1Layout.setHorizontalGroup(
            jpnFields1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnFields1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnFields1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnFields1Layout.createSequentialGroup()
                        .addGroup(jpnFields1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fieldRua1)
                            .addGroup(jpnFields1Layout.createSequentialGroup()
                                .addComponent(jLabel35)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnFields1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jpnFields1Layout.createSequentialGroup()
                                .addComponent(jLabel36)
                                .addGap(255, 255, 255))
                            .addComponent(fieldReferencia1)))
                    .addGroup(jpnFields1Layout.createSequentialGroup()
                        .addGroup(jpnFields1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel32)
                            .addComponent(jLabel41)
                            .addComponent(fieldCode1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnFields1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jpnFields1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnFields1Layout.createSequentialGroup()
                                .addGroup(jpnFields1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(chooserNasc1, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                                    .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(fieldFone1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel28))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpnFields1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jpnFields1Layout.createSequentialGroup()
                                        .addGroup(jpnFields1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(fieldCelular1)
                                            .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jpnFields1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(fieldWhatsapp1)
                                            .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jpnFields1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel29)
                                            .addComponent(fieldEmail1)))
                                    .addGroup(jpnFields1Layout.createSequentialGroup()
                                        .addGroup(jpnFields1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(fieldRg1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel25))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jpnFields1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(fieldNomeApelido1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel26))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jpnFields1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel27)
                                            .addComponent(fieldCredito1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnFields1Layout.createSequentialGroup()
                                .addGroup(jpnFields1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(fieldProfissao1)
                                    .addComponent(jLabel37, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fieldBairro1, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpnFields1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpnFields1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(fieldLocalTrabalho1)
                                        .addComponent(fieldCidade1)
                                        .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
                                    .addComponent(jLabel42))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpnFields1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jpnFields1Layout.createSequentialGroup()
                                        .addGroup(jpnFields1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(fieldCep1, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                            .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jpnFields1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cbxUf1, 0, 80, Short.MAX_VALUE)))
                                    .addComponent(fieldSalario1)))))
                    .addGroup(jpnFields1Layout.createSequentialGroup()
                        .addComponent(fieldRazaoSocial1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnFields1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fieldCPF1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnFields1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpnFields1Layout.createSequentialGroup()
                                .addComponent(jLabel44)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(cbxSexName1, 0, 112, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jpnFields1Layout.setVerticalGroup(
            jpnFields1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnFields1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldCode1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnFields1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(jLabel31)
                    .addComponent(jLabel44))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnFields1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldRazaoSocial1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldCPF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxSexName1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnFields1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(jLabel25)
                    .addComponent(jLabel26)
                    .addComponent(jLabel27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnFields1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chooserNasc1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpnFields1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fieldRg1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fieldCredito1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fieldNomeApelido1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnFields1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28)
                    .addGroup(jpnFields1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel33)
                        .addComponent(jLabel34)
                        .addComponent(jLabel29)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnFields1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldFone1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldCelular1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldWhatsapp1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldEmail1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnFields1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(jLabel36))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnFields1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldRua1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldReferencia1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnFields1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(jLabel38)
                    .addComponent(jLabel39)
                    .addComponent(jLabel40))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnFields1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldBairro1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldCidade1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldCep1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxUf1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnFields1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(jLabel42)
                    .addComponent(jLabel43))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnFields1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldProfissao1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldLocalTrabalho1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldSalario1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnFields1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnFields1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jnpFields1Layout = new javax.swing.GroupLayout(jnpFields1);
        jnpFields1.setLayout(jnpFields1Layout);
        jnpFields1Layout.setHorizontalGroup(
            jnpFields1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jnpFields1Layout.setVerticalGroup(
            jnpFields1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        dadosPerson.addTab("DADOS DE FUNCIONÁRIO", jnpFields1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dadosPerson, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dadosPerson, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                .addContainerGap())
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

            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }

    }//GEN-LAST:event_cmdSaveActionPerformed


    private void cmdNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdNewActionPerformed

        this.cpf = new Customer();

        ControlPanel.clean(jpnFields);
        this.eventClick();

    }//GEN-LAST:event_cmdNewActionPerformed


    private void fieldRazaoSocialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldRazaoSocialKeyPressed

        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {

            fieldCPF.requestFocus();

        }

    }//GEN-LAST:event_fieldRazaoSocialKeyPressed


    private void fieldCPFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldCPFKeyPressed

        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {

            cbxSexName.requestFocus();

        }

    }//GEN-LAST:event_fieldCPFKeyPressed


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

            fieldProfissao.requestFocus();

        }

    }//GEN-LAST:event_cbxUfKeyPressed


    private void cmdSaveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmdSaveKeyPressed

        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            cmdSaveActionPerformed(null);
        }
    }//GEN-LAST:event_cmdSaveKeyPressed


    private void fieldRgKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldRgKeyPressed

        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            fieldNomeApelido.requestFocus();
        }
    }//GEN-LAST:event_fieldRgKeyPressed


    private void cmdCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCancelActionPerformed
        this.eventClick();
        fields(cancel);

    }//GEN-LAST:event_cmdCancelActionPerformed

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
    private void fieldNomeApelidoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldNomeApelidoKeyPressed

        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            fieldCredito.requestFocus();
        }

    }//GEN-LAST:event_fieldNomeApelidoKeyPressed

    private void fieldProfissaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldProfissaoKeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            fieldLocalTrabalho.requestFocus();
        }

    }//GEN-LAST:event_fieldProfissaoKeyPressed

    private void fieldLocalTrabalhoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldLocalTrabalhoKeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            fieldSalario.requestFocus();
        }

    }//GEN-LAST:event_fieldLocalTrabalhoKeyPressed

    private void fieldSalarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldSalarioKeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            cmdSave.requestFocus();
        }

    }//GEN-LAST:event_fieldSalarioKeyPressed

    private void cbxSexNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbxSexNameKeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            chooserNasc.getDateEditor().getUiComponent().requestFocusInWindow();
        }
    }//GEN-LAST:event_cbxSexNameKeyPressed

    private void fieldRazaoSocial1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldRazaoSocial1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldRazaoSocial1KeyPressed

    private void fieldCredito1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldCredito1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldCredito1KeyPressed

    private void fieldRg1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldRg1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldRg1KeyPressed

    private void fieldCPF1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldCPF1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldCPF1KeyPressed

    private void fieldRua1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldRua1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldRua1KeyPressed

    private void fieldReferencia1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldReferencia1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldReferencia1KeyPressed

    private void fieldBairro1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldBairro1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldBairro1KeyPressed

    private void fieldCidade1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldCidade1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldCidade1KeyPressed

    private void fieldCep1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldCep1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldCep1KeyPressed

    private void cbxUf1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbxUf1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxUf1KeyPressed

    private void fieldNomeApelido1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldNomeApelido1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldNomeApelido1KeyPressed

    private void fieldProfissao1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldProfissao1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldProfissao1KeyPressed

    private void fieldLocalTrabalho1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldLocalTrabalho1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldLocalTrabalho1KeyPressed

    private void fieldSalario1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldSalario1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldSalario1KeyPressed

    private void cbxSexName1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbxSexName1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxSexName1KeyPressed

    private void fieldEmail1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldEmail1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldEmail1KeyPressed

    private void fieldWhatsapp1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldWhatsapp1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldWhatsapp1KeyPressed

    private void fieldCelular1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldCelular1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldCelular1KeyPressed

    private void fieldFone1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldFone1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldFone1KeyPressed

    private void save() throws Exception {

        cpf.setPersonName(fieldRazaoSocial.getText().toUpperCase().trim());
        if (cpf.getPersonName().equals("")) {
            throw new IllegalArgumentException("O campo razão social não pode ser vazio.\nVerifique e tente novamente");
        }
        cpf.setNickname(fieldNomeApelido.getText().toUpperCase());
        cpf.setDateBirth(chooserNasc.getDate());
        if (cpf.getNascimento() == null) {
            throw new IllegalArgumentException("O campo Nascimento não pode ser vazio.\nVerifique e tente novamente");
        }

        cpf.setValueCredit(Double.parseDouble(0 + fieldCredito.getText().replace(",", ".")));

        cpf.setPersonStatus(ckbSituacao.isSelected());

        cpf.setSocialNumber(fieldCPF.getText());

        cpf.setRg(fieldRg.getText());

        cpf.setPhone(fieldFone.getText());

        cpf.setCellPhone(fieldCelular.getText());

        cpf.setWhatsapp(fieldWhatsapp.getText());

        cpf.setEmail(fieldEmail.getText().toLowerCase().trim());

        cpf.setStreet(fieldRua.getText().toUpperCase().trim());

        cpf.setReference(fieldReferencia.getText().toUpperCase().trim());

        cpf.setZipCode(fieldCep.getText());

        cpf.setDistrictName(fieldBairro.getText().toUpperCase().trim());

        cpf.setCityName(fieldCidade.getText().toUpperCase().trim());

        cpf.setSexOfPerson(cbxSexName.getSelectedItem().toString());
        cpf.setState((State) cbxUf.getSelectedItem());
        cpf.setProfessionName(fieldProfissao.getText().toUpperCase().trim());
        cpf.setWorkplace(fieldLocalTrabalho.getText().toUpperCase().trim());
        cpf.setSalary(Double.parseDouble(0 + fieldSalario.getText().replace(",", ".")));

        crudPessoa = new ImplCustomer();
        crudPessoa.save(cpf);
        if (ControlPanel.optionPaneSave("Saved successfully!")) {
            cmdDisposeActionPerformed(null);
        }

    }

    /**
     *
     * @param args the command line arguments
     *
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

            java.util.logging.Logger.getLogger(DialogCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);

        }

        //</editor-fold>
        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {

            DialogCustomer dialog = new DialogCustomer(new javax.swing.JFrame(), true);

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
    private javax.swing.JComboBox<String> cbxSexName;
    private javax.swing.JComboBox<String> cbxSexName1;
    private javax.swing.JComboBox<entity.stage.State> cbxUf;
    private javax.swing.JComboBox<entity.stage.State> cbxUf1;
    private com.toedter.calendar.JDateChooser chooserNasc;
    private com.toedter.calendar.JDateChooser chooserNasc1;
    private javax.swing.JCheckBox ckbSituacao;
    private javax.swing.JButton cmdCancel;
    private javax.swing.JButton cmdDispose;
    private javax.swing.JButton cmdNew;
    private javax.swing.JButton cmdSave;
    private javax.swing.JTabbedPane dadosPerson;
    private javax.swing.JTextField fieldBairro;
    private javax.swing.JTextField fieldBairro1;
    private javax.swing.JFormattedTextField fieldCPF;
    private javax.swing.JFormattedTextField fieldCPF1;
    private javax.swing.JFormattedTextField fieldCelular;
    private javax.swing.JFormattedTextField fieldCelular1;
    private javax.swing.JFormattedTextField fieldCep;
    private javax.swing.JFormattedTextField fieldCep1;
    private javax.swing.JTextField fieldCidade;
    private javax.swing.JTextField fieldCidade1;
    private javax.swing.JTextField fieldCode;
    private javax.swing.JTextField fieldCode1;
    private javax.swing.JFormattedTextField fieldCredito;
    private javax.swing.JFormattedTextField fieldCredito1;
    private javax.swing.JTextField fieldEmail;
    private javax.swing.JTextField fieldEmail1;
    private javax.swing.JFormattedTextField fieldFone;
    private javax.swing.JFormattedTextField fieldFone1;
    private javax.swing.JTextField fieldLocalTrabalho;
    private javax.swing.JTextField fieldLocalTrabalho1;
    private javax.swing.JTextField fieldNomeApelido;
    private javax.swing.JTextField fieldNomeApelido1;
    private javax.swing.JTextField fieldProfissao;
    private javax.swing.JTextField fieldProfissao1;
    private javax.swing.JTextField fieldRazaoSocial;
    private javax.swing.JTextField fieldRazaoSocial1;
    private javax.swing.JTextField fieldReferencia;
    private javax.swing.JTextField fieldReferencia1;
    private javax.swing.JTextField fieldRg;
    private javax.swing.JTextField fieldRg1;
    private javax.swing.JTextField fieldRua;
    private javax.swing.JTextField fieldRua1;
    private javax.swing.JFormattedTextField fieldSalario;
    private javax.swing.JFormattedTextField fieldSalario1;
    private javax.swing.JFormattedTextField fieldWhatsapp;
    private javax.swing.JFormattedTextField fieldWhatsapp1;
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
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel jnpFields1;
    private javax.swing.JPanel jpnFields;
    private javax.swing.JPanel jpnFields1;
    // End of variables declaration//GEN-END:variables

    private void keyEventChooser() {

        chooserNasc.getDateEditor().getUiComponent().addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                    fieldRg.requestFocus();

                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

    }

}
