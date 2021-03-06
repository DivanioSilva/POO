/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import avaliacoes.Regime;
import disciplinas.Disciplina;
import escola.Secretaria;
import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import util.Utilitarios;
import util.cvs.CsvManagement;
import utilizadores.Aluno;
import utilizadores.Professor;
import utilizadores.TipoUtilizador;
import utilizadores.Tutor;
import utilizadores.Utilizador;

/**
 *
 * @author dcsilva
 */
public class MainFrame extends javax.swing.JFrame {

    private Utilizador utilizador;
    private Utilizador util;
    private Secretaria secretaria;
    DefaultTableModel model, disciplinasModel;

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        initdata();
    }

    private void initdata() {
        secretaria = new Secretaria();
        popularListagem();
        refreshUtilizadoresTable();
        refrescarComboBoxDocentesTutores();
//        Utilizador utilizador;
    }

    /**
     * Método para popular a lista de utilizadores
     */
    private void popularListagem() {
        Utilizador u;
        u = new Aluno();
        u.setNome("Hugo");
        u.setIdade(33);
        u.setMorada("Lisboa");
        u.setTelemovel("");
        u.setUsername("");
        u.setPassword("");
        u.setEmail("hugo@ual.pt");
//        u.setTipo(TipoUtilizador.Aluno);
        secretaria.utilCriar(u);
        u = new Professor();
        u.setNome("Paulo Cabrita");
        u.setIdade(43);
        u.setEmail("pjc@ual.pt");
        u.setMorada("Loures");
        u.setTelemovel("");
        u.setUsername("");
        u.setPassword("");
//        u.setTipo(TipoUtilizador.Professor);
        secretaria.utilCriar(u);
        u = new Aluno();
        u.setNome("Pedro");
        u.setIdade(27);
        u.setMorada("Lisboa");
        u.setTelemovel("");
        u.setUsername("");
        u.setPassword("");
        u.setEmail("pedro@ual.pt");
//        u.setTipo(TipoUtilizador.Aluno);
        secretaria.utilCriar(u);

        jTextFieldNomeDisciplina.setText("POO");
        jTextFieldCusto.setText("99.99");

    }

    /**
     * Aqui é que é feita a inserção dos dados na tabela dos utilizadoresSS
     */
    private void refreshUtilizadoresTable() {
        refreshUtilizadoresListRemover();
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        Object rowData[] = new Object[7];
        secretaria.getUtilizadores().forEach(u -> {
            rowData[0] = u.getNome();
            rowData[1] = u.getIdade();
            rowData[2] = u.getTelemovel();
            rowData[3] = u.getMorada();
            rowData[4] = u.getEmail();
            rowData[5] = u.getUsername();
            rowData[6] = u.getTipo();
            model.addRow(rowData);
        }
        );

    }

    private void refreshAlunos() {
        //myJlist.setListData(new String[0]);
        //a.stream().filter(x -> x > 3).collect(Collectors.toList());
        List<String> alunosTmp = new ArrayList<>();
        for (Utilizador u : secretaria.getUtilizadores()) {
            if (u.getTipo().equals(TipoUtilizador.Aluno)) {
                alunosTmp.add(u.getNome());
            }
        }

        String alunos[] = new String[alunosTmp.size()];

        for (int i = 0; i < alunosTmp.size(); i++) {
            alunos[i] = alunosTmp.get(i);
        }

        jListAlunos.setListData(alunos);
    }

    private void usersGestaoCard() {
        CardLayout card = (CardLayout) mainPanel.getLayout();
        card.show(mainPanel, "utilGestaoCard");
    }

    private void usersNovoCard() {
        CardLayout card = (CardLayout) mainPanel.getLayout();
        card.show(mainPanel, "usersCard");
    }

    private void disciplinasGruposCard() {
        CardLayout card = (CardLayout) mainPanel.getLayout();
        card.show(mainPanel, "discGrupoCard");
    }

    private void popularComboBoxResponsavelCadeira() {
        for (Utilizador u : secretaria.getUtilizadores()) {
            if (u.getTipo().equals(TipoUtilizador.Professor)) {
                jComboBoxResponsável.addItem(u.getNome());
            }
        }
    }

    private void popularComboBoxProfTutores() {
        for (Utilizador u : secretaria.getUtilizadores()) {
            if (u.getTipo().equals(TipoUtilizador.Professor) || u.getTipo().equals(TipoUtilizador.Tutor)) {
                jComboBoxTutor.addItem(u.getNome());
            }
        }
    }

    private void popularComboBoxDisciplinas() {
        for (Disciplina d : secretaria.getDisciplinas()) {
            jComboBoxEscolherDisciplina.addItem(d.getNome());
        }
    }

    private void refreshListaDisciplinas() {
        jComboBoxEscolherDisciplina.removeAllItems();
        popularComboBoxDisciplinas();
    }

    private void refrescarComboBoxDocentesTutores() {
        jComboBoxResponsável.removeAllItems();
        jComboBoxTutor.removeAllItems();
        popularComboBoxResponsavelCadeira();
        popularComboBoxProfTutores();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        utilizadoresCard = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jTextFieldNome = new javax.swing.JTextField();
        jTextFieldIdade = new javax.swing.JTextField();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldUsername = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldTlm = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldMorada = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jComboBoxUserTipo = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPasswordFieldPass = new javax.swing.JPasswordField();
        jButtonSalvar = new javax.swing.JButton();
        disciplinaAddAlunosCard = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jListAlunos = new javax.swing.JList<>();
        jComboBoxEscolherDisciplina = new javax.swing.JComboBox<>();
        jButtonAddAlunoDisciplina1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableDisciplinaAlunosInscritos = new javax.swing.JTable();
        jButtonAddAlunoDisciplina = new javax.swing.JButton();
        jLabelDisciplinaNomeProf = new javax.swing.JLabel();
        utilizadoresGestao = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButtonDeleteSelectedUser = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        disciplinasEGrupos = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jTextFieldNomeDisciplina = new javax.swing.JTextField();
        jButtonDisciplinaSalvar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jComboBoxResponsável = new javax.swing.JComboBox<>();
        jComboBoxTutor = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jSpinnerInicioDia = new javax.swing.JSpinner();
        jSpinnerInicioMes = new javax.swing.JSpinner();
        jSpinnerInicioAno = new javax.swing.JSpinner();
        jSpinnerFimDia = new javax.swing.JSpinner();
        jSpinnerFimMes = new javax.swing.JSpinner();
        jSpinnerFimAno = new javax.swing.JSpinner();
        jTextFieldCusto = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jComboBoxRegime = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jTextFieldNomeGrupo = new javax.swing.JTextField();
        jButtonGrupoSalvar = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDisciplinas = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuUtilGestao = new javax.swing.JMenu();
        jMenuItemUtilGestao = new javax.swing.JMenuItem();
        jMenuItemNewUser = new javax.swing.JMenuItem();
        jMenuItemDiscGrupos = new javax.swing.JMenuItem();
        jMenuItemDiscAddAlunos = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("mainPanel"); // NOI18N

        mainPanel.setLayout(new java.awt.CardLayout());

        jLabel1.setFont(new java.awt.Font("Noto Sans", 0, 24)); // NOI18N
        jLabel1.setText("Ecrã para criar utilizadores");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Utilizador")));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextFieldNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNomeActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 287, -1));
        jPanel1.add(jTextFieldIdade, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 80, 41, -1));

        jTextFieldEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldEmailActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 371, -1));

        jLabel7.setText("Morada:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, -1, -1));
        jPanel1.add(jTextFieldUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 128, -1));

        jLabel9.setText("Password:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 220, -1, -1));

        jLabel4.setText("Idade:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 80, -1, -1));

        jTextFieldTlm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTlmActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldTlm, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 141, -1));

        jLabel3.setText("Nome:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, -1, -1));
        jPanel1.add(jTextFieldMorada, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 371, -1));

        jLabel5.setText("Telemóvel:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, -1, -1));

        jLabel10.setText("Tipo:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, -1, -1));

        jComboBoxUserTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aluno", "Professor", "Tutor" }));
        jComboBoxUserTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxUserTipoActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBoxUserTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 150, -1));

        jLabel8.setText("Username:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, -1, -1));

        jLabel6.setText("E-mail:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, -1, -1));
        jPanel1.add(jPasswordFieldPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 220, 160, -1));

        jButtonSalvar.setText("Guardar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 250, 160, -1));

        javax.swing.GroupLayout utilizadoresCardLayout = new javax.swing.GroupLayout(utilizadoresCard);
        utilizadoresCard.setLayout(utilizadoresCardLayout);
        utilizadoresCardLayout.setHorizontalGroup(
            utilizadoresCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(utilizadoresCardLayout.createSequentialGroup()
                .addGap(167, 167, 167)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(utilizadoresCardLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 728, Short.MAX_VALUE)
                .addContainerGap())
        );
        utilizadoresCardLayout.setVerticalGroup(
            utilizadoresCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(utilizadoresCardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
                .addContainerGap())
        );

        mainPanel.add(utilizadoresCard, "usersCard");

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel20.setText("Disciplinas");

        jLabel19.setText("Alunos");

        jScrollPane4.setViewportView(jListAlunos);

        jComboBoxEscolherDisciplina.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxEscolherDisciplinaItemStateChanged(evt);
            }
        });
        jComboBoxEscolherDisciplina.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jComboBoxEscolherDisciplinaMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBoxEscolherDisciplinaMouseClicked(evt);
            }
        });

        jButtonAddAlunoDisciplina1.setText("Adicionar");
        jButtonAddAlunoDisciplina1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddAlunoDisciplina1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBoxEscolherDisciplina, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jButtonAddAlunoDisciplina1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxEscolherDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonAddAlunoDisciplina1, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Alunos inscritos na disciplina"));

        jTableDisciplinaAlunosInscritos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Aluno"
            }
        ));
        jScrollPane5.setViewportView(jTableDisciplinaAlunosInscritos);

        jButtonAddAlunoDisciplina.setText("Remover");

        jLabelDisciplinaNomeProf.setText("nomeDaDisciplina e professorResponsável");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(jButtonAddAlunoDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelDisciplinaNomeProf, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabelDisciplinaNomeProf)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonAddAlunoDisciplina, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout disciplinaAddAlunosCardLayout = new javax.swing.GroupLayout(disciplinaAddAlunosCard);
        disciplinaAddAlunosCard.setLayout(disciplinaAddAlunosCardLayout);
        disciplinaAddAlunosCardLayout.setHorizontalGroup(
            disciplinaAddAlunosCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(disciplinaAddAlunosCardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        disciplinaAddAlunosCardLayout.setVerticalGroup(
            disciplinaAddAlunosCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(disciplinaAddAlunosCardLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(disciplinaAddAlunosCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        mainPanel.add(disciplinaAddAlunosCard, "discAddAlunosCard");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Idade", "Telemóvel", "Email", "Morada", "Username", "Tipo"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable2MouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jButtonDeleteSelectedUser.setText("Apagar");
        jButtonDeleteSelectedUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteSelectedUserActionPerformed(evt);
            }
        });

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("CSV");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout utilizadoresGestaoLayout = new javax.swing.GroupLayout(utilizadoresGestao);
        utilizadoresGestao.setLayout(utilizadoresGestaoLayout);
        utilizadoresGestaoLayout.setHorizontalGroup(
            utilizadoresGestaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(utilizadoresGestaoLayout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addComponent(jButtonDeleteSelectedUser, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(158, 158, 158)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 772, Short.MAX_VALUE)
        );
        utilizadoresGestaoLayout.setVerticalGroup(
            utilizadoresGestaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(utilizadoresGestaoLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(utilizadoresGestaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonDeleteSelectedUser, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(utilizadoresGestaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainPanel.add(utilizadoresGestao, "utilGestaoCard");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Adicionar disciplina"));

        jButtonDisciplinaSalvar.setText("Guardar");
        jButtonDisciplinaSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDisciplinaSalvarActionPerformed(evt);
            }
        });

        jLabel11.setText("Nome:");

        jLabel13.setText("Responsável:");

        jLabel14.setText("Prof ou tutor:");

        jLabel15.setText("Custo:");

        jLabel16.setText("Início:");

        jLabel17.setText("Fim:");

        jSpinnerInicioDia.setModel(new javax.swing.SpinnerListModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));

        jSpinnerInicioMes.setModel(new javax.swing.SpinnerListModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));

        jSpinnerInicioAno.setModel(new javax.swing.SpinnerListModel(new String[] {"2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050"}));

        jSpinnerFimDia.setModel(new javax.swing.SpinnerListModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));

        jSpinnerFimMes.setModel(new javax.swing.SpinnerListModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));

        jSpinnerFimAno.setModel(new javax.swing.SpinnerListModel(new String[] {"2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050"}));

        jLabel18.setText("Regime:");

        jComboBoxRegime.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PRESENCIAL", "ELEARNING", "MISTA" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNomeDisciplina))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel15)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBoxTutor, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxResponsável, 0, 208, Short.MAX_VALUE)
                            .addComponent(jTextFieldCusto)
                            .addComponent(jComboBoxRegime, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(220, 220, 220))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jButtonDisciplinaSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSpinnerFimDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinnerInicioDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSpinnerFimMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinnerInicioMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSpinnerFimAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinnerInicioAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel16)
                    .addComponent(jLabel18))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNomeDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxResponsável, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxTutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jTextFieldCusto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jComboBoxRegime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jSpinnerInicioDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jSpinnerFimDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jSpinnerInicioMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSpinnerFimMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jSpinnerInicioAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSpinnerFimAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonDisciplinaSalvar)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Adicionar grupo"));

        jButtonGrupoSalvar.setText("Guardar");
        jButtonGrupoSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGrupoSalvarActionPerformed(evt);
            }
        });

        jLabel12.setText("Nome:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldNomeGrupo)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jButtonGrupoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 32, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jTextFieldNomeGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonGrupoSalvar)
                .addContainerGap())
        );

        jTableDisciplinas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Disciplina", "Professor", "Custo", "Início", "Fim"
            }
        ));
        jScrollPane1.setViewportView(jTableDisciplinas);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Grupo"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        javax.swing.GroupLayout disciplinasEGruposLayout = new javax.swing.GroupLayout(disciplinasEGrupos);
        disciplinasEGrupos.setLayout(disciplinasEGruposLayout);
        disciplinasEGruposLayout.setHorizontalGroup(
            disciplinasEGruposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(disciplinasEGruposLayout.createSequentialGroup()
                .addGroup(disciplinasEGruposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(disciplinasEGruposLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(disciplinasEGruposLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(disciplinasEGruposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );
        disciplinasEGruposLayout.setVerticalGroup(
            disciplinasEGruposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(disciplinasEGruposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(disciplinasEGruposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(disciplinasEGruposLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(disciplinasEGruposLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        mainPanel.add(disciplinasEGrupos, "discGrupoCard");

        jMenuUtilGestao.setText("Ações");
        jMenuUtilGestao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuUtilGestaoActionPerformed(evt);
            }
        });

        jMenuItemUtilGestao.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemUtilGestao.setText("Gestão Utilizadores");
        jMenuItemUtilGestao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemUtilGestaoActionPerformed(evt);
            }
        });
        jMenuUtilGestao.add(jMenuItemUtilGestao);

        jMenuItemNewUser.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemNewUser.setText("Criar utilizadores");
        jMenuItemNewUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemNewUserActionPerformed(evt);
            }
        });
        jMenuUtilGestao.add(jMenuItemNewUser);

        jMenuItemDiscGrupos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemDiscGrupos.setText("Disciplinas");
        jMenuItemDiscGrupos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemDiscGruposActionPerformed(evt);
            }
        });
        jMenuUtilGestao.add(jMenuItemDiscGrupos);

        jMenuItemDiscAddAlunos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemDiscAddAlunos.setText("Disciplina - Adicionar alunos");
        jMenuItemDiscAddAlunos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemDiscAddAlunosActionPerformed(evt);
            }
        });
        jMenuUtilGestao.add(jMenuItemDiscAddAlunos);

        jMenuBar1.add(jMenuUtilGestao);
        jMenuUtilGestao.getAccessibleContext().setAccessibleName("UtilGestao");

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNomeActionPerformed

    private void jTextFieldTlmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTlmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTlmActionPerformed

    private void jTextFieldEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEmailActionPerformed

    private void jComboBoxUserTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxUserTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxUserTipoActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        if (jComboBoxUserTipo.getSelectedItem().toString() == TipoUtilizador.Aluno.toString()) {
            utilizador = new Aluno();
        } else if (jComboBoxUserTipo.getSelectedItem().toString() == TipoUtilizador.Professor.toString()) {
            utilizador = new Professor();
        } else if (jComboBoxUserTipo.getSelectedItem().toString() == TipoUtilizador.Tutor.toString()) {
            utilizador = new Tutor();
        }

        try {
            utilizador.setNome(jTextFieldNome.getText());
            utilizador.setIdade(Integer.parseInt(jTextFieldIdade.getText()));
            utilizador.setMorada(jTextFieldMorada.getText());
            utilizador.setPassword(Arrays.toString(jPasswordFieldPass.getPassword()));
            utilizador.setTelemovel(jTextFieldTlm.getText());
            utilizador.setUsername(jTextFieldUsername.getText());
            utilizador.setEmail(jTextFieldEmail.getText());

//            System.out.println(utilizador);
//            secretaria.getUtilizadores().add(utilizador);
            secretaria.utilCriar(utilizador);
            clearFormFields();
            refreshUtilizadoresTable();

            JOptionPane.showMessageDialog(this, "Utilizador salvo com sucesso!", "SUCESSO", JOptionPane.INFORMATION_MESSAGE);

//            popularComboBox();
            refreshAlunos();
            refrescarComboBoxDocentesTutores();
        } catch (NumberFormatException n) {
            JOptionPane.showMessageDialog(this, "Coloque um número inteiro na idade do utilizador!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ocorreu um erro! " + e);
        }
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonDeleteSelectedUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteSelectedUserActionPerformed
        model = (DefaultTableModel) this.jTable2.getModel();
        int[] rows = jTable2.getSelectedRows();

        if (rows.length == 0) {
            JOptionPane.showMessageDialog(this, "É necessário escolher um utilizador da lista!!", "", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                int n = JOptionPane.showConfirmDialog(
                        this,
                        "Tem certeza que quer excluir este user?",
                        "EXCLUIR UTILIZADOR",
                        JOptionPane.YES_NO_OPTION);

                System.out.println("");

                if (n == 0) {
                    //            JOptionPane.showMessageDialog(null, "HELLO");
                    //                model = (DefaultTableModel) this.jTable2.getModel();
                    //                int[] rows = jTable2.getSelectedRows();
                    for (int i = 0; i < rows.length; i++) {
                        model.removeRow(rows[i] - i);
                    }
                    JOptionPane.showMessageDialog(this, "Utilizador excluido com sucesso!", "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Nenhuma alteração foi feita!", "SEM ALTERAÇÃO", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Erro ao excluir!!!!!", "", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButtonDeleteSelectedUserActionPerformed

    private void jMenuUtilGestaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuUtilGestaoActionPerformed
//        usersGestaoCard();
    }//GEN-LAST:event_jMenuUtilGestaoActionPerformed

    private void jMenuItemUtilGestaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemUtilGestaoActionPerformed
        usersGestaoCard();
    }//GEN-LAST:event_jMenuItemUtilGestaoActionPerformed

    private void jMenuItemNewUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemNewUserActionPerformed
        usersNovoCard();
    }//GEN-LAST:event_jMenuItemNewUserActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        System.out.println("");
        try {
            for (int i = 0; i < secretaria.getUtilizadores().size(); i++) {
                secretaria.getUtilizadores().get(i).setNome(model.getValueAt(i, 0).toString());
                secretaria.getUtilizadores().get(i).setIdade(Integer.parseInt(model.getValueAt(i, 1).toString()));
                secretaria.getUtilizadores().get(i).setTelemovel(model.getValueAt(i, 2).toString());
            }
        } catch (Exception e) {
            System.err.println(e);
        }

        secretaria.getUtilizadores().forEach(u -> System.out.println(u));
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseReleased
        System.out.println("");
        try {
            for (int i = 0; i < secretaria.getUtilizadores().size(); i++) {
                secretaria.getUtilizadores().get(i).setNome(model.getValueAt(i, 0).toString());
                secretaria.getUtilizadores().get(i).setIdade(Integer.parseInt(model.getValueAt(i, 1).toString()));
                secretaria.getUtilizadores().get(i).setTelemovel(model.getValueAt(i, 2).toString());
                secretaria.getUtilizadores().get(i).setEmail(model.getValueAt(i, 3).toString());
                secretaria.getUtilizadores().get(i).setMorada(model.getValueAt(i, 4).toString());
                secretaria.getUtilizadores().get(i).setUsername(model.getValueAt(i, 5).toString());
            }
        } catch (Exception e) {
            System.err.println(e);
        }

        secretaria.getUtilizadores().forEach(u -> System.out.println(u));
    }//GEN-LAST:event_jTable2MouseReleased

    private void jMenuItemDiscAddAlunosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemDiscAddAlunosActionPerformed
        CardLayout card = (CardLayout) mainPanel.getLayout();
        card.show(mainPanel, "discAddAlunosCard");
    }//GEN-LAST:event_jMenuItemDiscAddAlunosActionPerformed

    private void jMenuItemDiscGruposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemDiscGruposActionPerformed
        disciplinasGruposCard();
    }//GEN-LAST:event_jMenuItemDiscGruposActionPerformed

    private void jButtonDisciplinaSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDisciplinaSalvarActionPerformed
        Disciplina disciplina = new Disciplina();
        disciplina.setNome(jTextFieldNomeDisciplina.getText());
        disciplina.setProfResponsavel((Professor) selecionarProfResponsavel());

        disciplina.getProfsTutores().add((Professor) selecionarProfTutor());

        disciplina.setInicio(Utilitarios.conversorData(Integer.parseInt(jSpinnerInicioDia.getValue().toString()), Integer.parseInt(jSpinnerInicioMes.getValue().toString()), Integer.parseInt(jSpinnerInicioAno.getValue().toString())));
        disciplina.setFim(Utilitarios.conversorData(Integer.parseInt(jSpinnerFimDia.getValue().toString()), Integer.parseInt(jSpinnerFimMes.getValue().toString()), Integer.parseInt(jSpinnerFimAno.getValue().toString())));

        try {
//            disciplina.setCusto(Float.parseFloat(jFormattedTextFieldCusto.toString()));
            disciplina.setCusto(Float.parseFloat(jTextFieldCusto.getText()));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Tem que colocar um valor (Float) no custo do curso!");
        }

        if (jComboBoxRegime.getSelectedItem().toString() == null ? Regime.ELEARNING.toString() == null : jComboBoxRegime.getSelectedItem().toString().equals(Regime.ELEARNING.toString())) {
            disciplina.setRegime(Regime.ELEARNING);
        } else if (jComboBoxRegime.getSelectedItem().toString() == null ? Regime.MISTA.toString() == null : jComboBoxRegime.getSelectedItem().toString().equals(Regime.MISTA.toString())) {
            disciplina.setRegime(Regime.MISTA);
        } else if (jComboBoxRegime.getSelectedItem().toString() == null ? Regime.PRESENCIAL.toString() == null : jComboBoxRegime.getSelectedItem().toString().equals(Regime.PRESENCIAL.toString())) {
            disciplina.setRegime(Regime.PRESENCIAL);
        }

//        refreshDisciplinas();
        secretaria.disciplinaCriar(disciplina);

//        System.out.println("Prof responsável: -----------> " + disciplina.getProfResponsavel());
        refreshDisciplinas();
        refreshListaDisciplinas();
    }//GEN-LAST:event_jButtonDisciplinaSalvarActionPerformed

    private void jButtonGrupoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGrupoSalvarActionPerformed

//        DefaultTableModel model2 = (DefaultTableModel) jTableDisciplinas.getModel();
//        Object rowData[] = new Object[1];
//
//        rowData[0] = "AA";
//        model2.addRow(rowData);

    }//GEN-LAST:event_jButtonGrupoSalvarActionPerformed

    private void jButtonAddAlunoDisciplina1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddAlunoDisciplina1ActionPerformed
        //Adicionar selecionar a disciplina
//        jLabelDisciplinaNomeProf.setText("");
        for (Disciplina d : secretaria.getDisciplinas()) {
            if (d.getNome() == jComboBoxEscolherDisciplina.getSelectedItem()) {
//                jLabelDisciplinaNomeProf.setText("Disciplina: "+jComboBoxEscolherDisciplina.getSelectedItem()+". Docente: "+d.getProfResponsavel().getNome());
                //adicionar aluno
                for (Utilizador a : secretaria.getUtilizadores()) {
                    if (a.getNome().equals(jListAlunos.getSelectedValue())) {
                        d.getAlunos().add((Aluno) a);
                    }
                }
            }

//            d.getAlunos().forEach(a -> System.out.println(a));
        }

        addAlunosDaDisciplinaTable();
        
    }//GEN-LAST:event_jButtonAddAlunoDisciplina1ActionPerformed

    private void jComboBoxEscolherDisciplinaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxEscolherDisciplinaMouseReleased
//        limparTabelaAlunosDisciplinas();
//        addAlunosDaDisciplinaTable();
//        System.out.println("Limpei a tabela dos alunos");
    }//GEN-LAST:event_jComboBoxEscolherDisciplinaMouseReleased

    private void jComboBoxEscolherDisciplinaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxEscolherDisciplinaMouseClicked
        // TODO add your handling code here:
//        limparTabelaAlunosDisciplinas();
//        addAlunosDaDisciplinaTable();
    }//GEN-LAST:event_jComboBoxEscolherDisciplinaMouseClicked

    private void jComboBoxEscolherDisciplinaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxEscolherDisciplinaItemStateChanged
        // TODO add your handling code here:
//        limparTabelaAlunosDisciplinas();
        jLabelDisciplinaNomeProf.setText("");
        jLabelDisciplinaNomeProf.setText("Disciplina: "+jComboBoxEscolherDisciplina.getSelectedItem());
        addAlunosDaDisciplinaTable();
    }//GEN-LAST:event_jComboBoxEscolherDisciplinaItemStateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        CsvManagement csv = new CsvManagement(secretaria);
        csv.salvarUtilizadores();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void addAlunosDaDisciplinaTable() {
        limparTabelaAlunosDisciplinas();
        DefaultTableModel modelAlunosDisciplina = (DefaultTableModel) jTableDisciplinaAlunosInscritos.getModel();
        Object rowData[] = new Object[1];

        for (Disciplina d : secretaria.getDisciplinas()) {
//            jLabelDisciplinaNomeProf.setText("Disciplina: "+d.getNome()+". Docente: "+d.getProfResponsavel().getNome());
            if (d.getNome() == jComboBoxEscolherDisciplina.getSelectedItem()) {
                for (Aluno a : d.getAlunos()) {
                    rowData[0] = a.getNome();
                    modelAlunosDisciplina.addRow(rowData);
                }
            }
        }
    }

    private void limparTabelaAlunosDisciplinas() {
        DefaultTableModel modelAlunosDisciplina = (DefaultTableModel) jTableDisciplinaAlunosInscritos.getModel();

        while (modelAlunosDisciplina.getRowCount() > 0) {
            for (int i = 0; i < modelAlunosDisciplina.getRowCount(); i++) {
                modelAlunosDisciplina.removeRow(i);
            }
        }
    }

    private void refreshDisciplinas() {
//        refreshDisciplinasTable();
        refreshDisciplinasTableRemover();
        DefaultTableModel model2 = (DefaultTableModel) jTableDisciplinas.getModel();
        Object rowData[] = new Object[5];
        for (Disciplina d : secretaria.getDisciplinas()) {
            rowData[0] = d.getNome();
            rowData[1] = d.getProfResponsavel();
            rowData[2] = d.getCusto();
            rowData[3] = Utilitarios.conversarDateToString(d.getInicio());
            rowData[4] = Utilitarios.conversarDateToString(d.getFim());
            model2.addRow(rowData);
        }
    }

    private Utilizador selecionarProfResponsavel() {
        util = new Professor();
        for (Utilizador p : secretaria.getUtilizadores()) {
            if (p.getNome().equals(jComboBoxResponsável.getSelectedItem().toString())) {
                util = p;
            }
        }
        return util;
    }

    private Utilizador selecionarProfTutor() {
        util = new Professor();
        for (Utilizador p : secretaria.getUtilizadores()) {
            if (p.getNome().equals(jComboBoxTutor.getSelectedItem().toString())) {
                util = p;
            }
        }
        return util;
    }

    private void refreshUtilizadoresListRemover() {
        model = (DefaultTableModel) jTable2.getModel();

        while (model.getRowCount() > 0) {
            for (int i = 0; i < model.getRowCount(); i++) {
                model.removeRow(i);
            }
        }
    }

    private void refreshDisciplinasTableRemover() {
        disciplinasModel = (DefaultTableModel) jTableDisciplinas.getModel();

        while (disciplinasModel.getRowCount() > 0) {
            for (int i = 0; i < disciplinasModel.getRowCount(); i++) {
                disciplinasModel.removeRow(i);
            }
        }
    }

    private void clearFormFields() {
        jTextFieldEmail.setText("");
        jTextFieldIdade.setText("");
        jTextFieldMorada.setText("");
        jTextFieldNome.setText("");
        jTextFieldTlm.setText("");
        jTextFieldUsername.setText("");
        jPasswordFieldPass.setText("");
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new MainFrame().setVisible(true);
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel disciplinaAddAlunosCard;
    private javax.swing.JPanel disciplinasEGrupos;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonAddAlunoDisciplina;
    private javax.swing.JButton jButtonAddAlunoDisciplina1;
    private javax.swing.JButton jButtonDeleteSelectedUser;
    private javax.swing.JButton jButtonDisciplinaSalvar;
    private javax.swing.JButton jButtonGrupoSalvar;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JComboBox<String> jComboBoxEscolherDisciplina;
    private javax.swing.JComboBox<String> jComboBoxRegime;
    private javax.swing.JComboBox<String> jComboBoxResponsável;
    private javax.swing.JComboBox<String> jComboBoxTutor;
    private javax.swing.JComboBox<String> jComboBoxUserTipo;
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
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelDisciplinaNomeProf;
    private javax.swing.JList<String> jListAlunos;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemDiscAddAlunos;
    private javax.swing.JMenuItem jMenuItemDiscGrupos;
    private javax.swing.JMenuItem jMenuItemNewUser;
    private javax.swing.JMenuItem jMenuItemUtilGestao;
    private javax.swing.JMenu jMenuUtilGestao;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPasswordField jPasswordFieldPass;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSpinner jSpinnerFimAno;
    private javax.swing.JSpinner jSpinnerFimDia;
    private javax.swing.JSpinner jSpinnerFimMes;
    private javax.swing.JSpinner jSpinnerInicioAno;
    private javax.swing.JSpinner jSpinnerInicioDia;
    private javax.swing.JSpinner jSpinnerInicioMes;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTableDisciplinaAlunosInscritos;
    private javax.swing.JTable jTableDisciplinas;
    private javax.swing.JTextField jTextFieldCusto;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldIdade;
    private javax.swing.JTextField jTextFieldMorada;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldNomeDisciplina;
    private javax.swing.JTextField jTextFieldNomeGrupo;
    private javax.swing.JTextField jTextFieldTlm;
    private javax.swing.JTextField jTextFieldUsername;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel utilizadoresCard;
    private javax.swing.JPanel utilizadoresGestao;
    // End of variables declaration//GEN-END:variables
}
