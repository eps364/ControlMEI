package views.dialog;

import entity.person.Cpf;
import entity.uf.State;

import enu.FieldChar;

import impl.ImplState;

import impl.ImplCPF;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;
import javax.swing.ImageIcon;

import javax.swing.JOptionPane;

import util.ControlPanel;

import util.FormatNumber;

public class DialogCPF extends javax.swing.JDialog {

    ImplCPF crudPessoa;

    private Cpf cpf;

    private Cpf cancel;

    public DialogCPF(java.awt.Frame parent, boolean modal) {

        super(parent, modal);

        this.cpf = new Cpf();

        initComponents();

        updateComboBox();

        this.formatNumber();
        this.chooserNasc.setDate(new Date());
        this.eventClick();

    }

    public DialogCPF(java.awt.Frame parent, boolean modal, Cpf cpf) {

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

    private void fields(Cpf cpf) {
        try {

            this.cpf = cpf;

            ckbSituacao.setSelected(cpf.getActive());

            fieldCode.setText(String.valueOf(cpf.getId()));

            fieldRazaoSocial.setText(cpf.getRazaoSocial());

            fieldCPF.setText(cpf.getCpfNumber());

            fieldRg.setText(cpf.getRg());

            fieldNomeApelido.setText(cpf.getNomeFantasia());

            chooserNasc.setDate(cpf.getNascimento());

            fieldCredito.setText(String.valueOf(cpf.getCredito()).replace(".", ","));

            fieldFone.setText(cpf.getFone());

            fieldCelular.setText(cpf.getCelular());

            fieldWhatsapp.setText(cpf.getWhatsapp());

            fieldEmail.setText(cpf.getEmail());

            fieldRua.setText(cpf.getRua());

            fieldReferencia.setText(cpf.getReferencia());

            fieldCep.setText(cpf.getCep());

            fieldBairro.setText(cpf.getBairro());

            fieldCidade.setText(cpf.getCidade());

            fieldProfissao.setText(cpf.getProfissao());
            fieldLocalTrabalho.setText(cpf.getLocalTrabalho());
            fieldSalario.setText(String.valueOf(cpf.getSalario()).replace(".", ","));

            cbxUf.setSelectedItem(cpf.getEstado());
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
        jPanel1 = new javax.swing.JPanel();
        cmdDispose = new javax.swing.JButton();
        cmdGravar = new javax.swing.JButton();
        cmdNovo = new javax.swing.JButton();
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
        cbxUf = new javax.swing.JComboBox<entity.uf.State>();
        fieldNomeApelido = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        fieldProfissao = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        fieldLocalTrabalho = new javax.swing.JTextField();
        fieldSalario = new javax.swing.JFormattedTextField();
        jLabel22 = new javax.swing.JLabel();
        cmdCancelar = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        jLabel16.setText("jLabel16");

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CADASTRAR PESSOA FÍSICA");
        setIconImage(new ImageIcon(getClass().getResource("/views/img/cpf.png")).getImage());
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
                                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(fieldRazaoSocial, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jpnFieldsLayout.createSequentialGroup()
                                        .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jpnFieldsLayout.createSequentialGroup()
                                                .addComponent(fieldCode, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(ckbSituacao))
                                            .addComponent(jLabel3))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fieldCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)))
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
                                            .addComponent(fieldCredito, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))))))
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
                            .addGroup(jpnFieldsLayout.createSequentialGroup()
                                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(fieldCidade, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                                    .addComponent(jLabel21))
                                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpnFieldsLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(fieldCep, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cbxUf, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jpnFieldsLayout.createSequentialGroup()
                                        .addGap(66, 66, 66)
                                        .addComponent(jLabel22))))
                            .addGroup(jpnFieldsLayout.createSequentialGroup()
                                .addComponent(fieldLocalTrabalho, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fieldSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jpnFieldsLayout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldRazaoSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }

    }//GEN-LAST:event_cmdGravarActionPerformed


    private void cmdNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdNovoActionPerformed

        this.cpf = new Cpf();

        ControlPanel.clean(jpnFields);
        this.eventClick();

    }//GEN-LAST:event_cmdNovoActionPerformed


    private void fieldRazaoSocialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldRazaoSocialKeyPressed

        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {

            fieldCPF.requestFocus();

        }

    }//GEN-LAST:event_fieldRazaoSocialKeyPressed


    private void fieldCPFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldCPFKeyPressed

        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {

            chooserNasc.getDateEditor().getUiComponent().requestFocusInWindow();

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


    private void cmdGravarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmdGravarKeyPressed

        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            cmdGravarActionPerformed(null);
        }
    }//GEN-LAST:event_cmdGravarKeyPressed


    private void fieldRgKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldRgKeyPressed

        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            fieldNomeApelido.requestFocus();
        }
    }//GEN-LAST:event_fieldRgKeyPressed


    private void cmdCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCancelarActionPerformed
        this.eventClick();
        fields(cancel);

    }//GEN-LAST:event_cmdCancelarActionPerformed

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
            cmdGravar.requestFocus();
        }

    }//GEN-LAST:event_fieldSalarioKeyPressed

    private void save() throws Exception {

        cpf.setRazaoSocial(fieldRazaoSocial.getText().toUpperCase().trim());
        if (cpf.getRazaoSocial().equals("")) {
            throw new Exception("O campo razão social não pode ser vazio.\nVerifique e tente novamente");
        }
        cpf.setNomeFantasia(fieldNomeApelido.getText().toUpperCase());
        cpf.setNascimento(chooserNasc.getDate());
        if (cpf.getNascimento() == null) {
            throw new Exception("O campo Nascimento não pode ser vazio.\nVerifique e tente novamente");
        }

        cpf.setCredito(Double.parseDouble(0 + fieldCredito.getText().replace(",", ".")));

        cpf.setActive(ckbSituacao.isSelected());

        cpf.setCpfNumber(fieldCPF.getText());

//        cpf.setInscEstadual(fieldInscEstadual.getText());
        cpf.setRg(fieldRg.getText());

        cpf.setFone(fieldFone.getText());

        cpf.setCelular(fieldCelular.getText());

        cpf.setWhatsapp(fieldWhatsapp.getText());

        cpf.setEmail(fieldEmail.getText().toLowerCase().trim());

        cpf.setRua(fieldRua.getText().toUpperCase().trim());

        cpf.setReferencia(fieldReferencia.getText().toUpperCase().trim());

        cpf.setCep(fieldCep.getText());

        cpf.setBairro(fieldBairro.getText().toUpperCase().trim());

        cpf.setCidade(fieldCidade.getText().toUpperCase().trim());

        cpf.setEstado((State) cbxUf.getSelectedItem());
//        Estado s = new Estado();
//        s.setNome(e);
//        System.out.println(s.getId());

        cpf.setProfissao(fieldProfissao.getText().toUpperCase().trim());
        cpf.setLocalTrabalho(fieldLocalTrabalho.getText().toUpperCase().trim());
        cpf.setSalario(Double.parseDouble(0 + fieldSalario.getText().replace(",", ".")));

        crudPessoa = new ImplCPF();
        crudPessoa.save(cpf);
        JOptionPane.showMessageDialog(rootPane, "Salvo com sucesso!");
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

            java.util.logging.Logger.getLogger(DialogCPF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);

        }

        //</editor-fold>
        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {

            DialogCPF dialog = new DialogCPF(new javax.swing.JFrame(), true);

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
    private javax.swing.JComboBox<entity.uf.State> cbxUf;
    private com.toedter.calendar.JDateChooser chooserNasc;
    private javax.swing.JCheckBox ckbSituacao;
    private javax.swing.JButton cmdCancelar;
    private javax.swing.JButton cmdDispose;
    private javax.swing.JButton cmdGravar;
    private javax.swing.JButton cmdNovo;
    private javax.swing.JTextField fieldBairro;
    private javax.swing.JFormattedTextField fieldCPF;
    private javax.swing.JFormattedTextField fieldCelular;
    private javax.swing.JFormattedTextField fieldCep;
    private javax.swing.JTextField fieldCidade;
    private javax.swing.JTextField fieldCode;
    private javax.swing.JFormattedTextField fieldCredito;
    private javax.swing.JTextField fieldEmail;
    private javax.swing.JFormattedTextField fieldFone;
    private javax.swing.JTextField fieldLocalTrabalho;
    private javax.swing.JTextField fieldNomeApelido;
    private javax.swing.JTextField fieldProfissao;
    private javax.swing.JTextField fieldRazaoSocial;
    private javax.swing.JTextField fieldReferencia;
    private javax.swing.JTextField fieldRg;
    private javax.swing.JTextField fieldRua;
    private javax.swing.JFormattedTextField fieldSalario;
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
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel jpnFields;
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
