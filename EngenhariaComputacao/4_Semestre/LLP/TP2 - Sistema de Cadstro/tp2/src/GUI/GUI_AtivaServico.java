/*
 *      CENTRO FEDERAL DE EDUCAÇÃO TECNOLÓGICA DE MINAS GERAIS
 * ENGENHARIA DE COMPUTAÇÃO - LABORATORIO DE LINGUAGEM DE PROGRAMAÇÃO
 * 
 *                    ANTONIO SOUSA E GABRIEL NEGREIROS
 */

package GUI;

import Console.arquivo;
import Serviços.Servico;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GUI_AtivaServico extends javax.swing.JFrame {

    private ArrayList<Servico> Servicos;
    private ArrayList<Servico> ServicosAtivados;
    
    int index_selecionado = -1;
    
    public GUI_AtivaServico() throws IOException {
        initComponents();
        
         // Centraliza o JFrame na tela
        this.setLocationRelativeTo(null);
        
        jComboBox_Servicos.removeAllItems();
                
        arquivo x = new arquivo();
        Servicos = x.getServicos();
        
        for (Iterator iterator = Servicos.iterator(); iterator.hasNext(); ) {  
            Servico lido = (Servico) iterator.next();
            
            jComboBox_Servicos.addItem(lido.getTipoServico());
        }
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox_Servicos = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jTextField_Observacao = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField_Nome = new javax.swing.JTextField();
        jButton_AtivaServico = new javax.swing.JButton();
        jButton_ExcluiServico = new javax.swing.JButton();
        jButton_EditaServico = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel_semServico = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jComboBox_Servicos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox_Servicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_ServicosActionPerformed(evt);
            }
        });

        jLabel1.setText("Selecione");

        jTextField_Observacao.setText("Observação");
        jTextField_Observacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_ObservacaoActionPerformed(evt);
            }
        });

        jLabel2.setText("Nome do Serviço:");

        jLabel3.setText("Observação:");

        jLabel4.setText("Nome para cadastrar:");

        jTextField_Nome.setText("Nome");
        jTextField_Nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_NomeActionPerformed(evt);
            }
        });

        jButton_AtivaServico.setText("Ativar Serviço");
        jButton_AtivaServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AtivaServicoActionPerformed(evt);
            }
        });

        jButton_ExcluiServico.setText("Excluir Serviço");
        jButton_ExcluiServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ExcluiServicoActionPerformed(evt);
            }
        });

        jButton_EditaServico.setText("Editar e Ativar Serviço");
        jButton_EditaServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_EditaServicoActionPerformed(evt);
            }
        });

        jButton4.setText("Voltar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel_semServico.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel_semServico.setText("Nenhum Serviço para ativar!");

        jLabel5.setText("Altere os campos abaixo se quiser editar algum serviço:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBox_Servicos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextField_Observacao, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                                    .addComponent(jTextField_Nome)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton_AtivaServico)
                                .addGap(18, 18, 18)
                                .addComponent(jButton_EditaServico, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(jButton_ExcluiServico))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jLabel_semServico, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox_Servicos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(21, 21, 21)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_Observacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_AtivaServico)
                    .addComponent(jButton_ExcluiServico)
                    .addComponent(jButton_EditaServico))
                .addGap(18, 18, 18)
                .addComponent(jLabel_semServico, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox_ServicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_ServicosActionPerformed
        // TODO add your handling code here:
        index_selecionado = jComboBox_Servicos.getSelectedIndex();
        
        jButton_AtivaServico.setVisible(false);
        jButton_EditaServico.setVisible(false);
        jButton_ExcluiServico.setVisible(false);
        jLabel_semServico.setVisible(true);
        
        if(index_selecionado>=0){
            jButton_AtivaServico.setVisible(true);
            jButton_EditaServico.setVisible(true);
            jButton_ExcluiServico.setVisible(true);
            jLabel_semServico.setVisible(false);
        
            Servico selecionado = Servicos.get(index_selecionado);
            jTextField_Nome.setText(selecionado.getTipoServico());
            jTextField_Observacao.setText(selecionado.getObservacaoServico());
            //System.out.println(selecionado.getTipoServico());

        }
        
    }//GEN-LAST:event_jComboBox_ServicosActionPerformed

    private void jTextField_NomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_NomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_NomeActionPerformed

    private void jTextField_ObservacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_ObservacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_ObservacaoActionPerformed

    private void jButton_ExcluiServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ExcluiServicoActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            
            arquivo x = new arquivo();
            
            Servicos = x.getServicos();
            Servicos.remove(index_selecionado);
            x.setServicos(Servicos);
            
            this.dispose();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GUI_AtivaServico.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GUI_AtivaServico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton_ExcluiServicoActionPerformed

    private void jButton_EditaServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_EditaServicoActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            
            arquivo x = new arquivo();
            
            Servicos = x.getServicos();
            Servicos.remove(index_selecionado);
            x.setServicos(Servicos);
            
            Servico editado = new Servico(jTextField_Nome.getText(), jTextField_Observacao.getText());
            
            arquivo y = new arquivo();
            
            ServicosAtivados = y.getServicosAtivados(); //busca os serviços ativados
            ServicosAtivados.add(editado);
            y.setServicosAtivados(ServicosAtivados);    //atualiza os serviços ativados
            
            this.dispose();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GUI_AtivaServico.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GUI_AtivaServico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton_EditaServicoActionPerformed

    private void jButton_AtivaServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AtivaServicoActionPerformed
        
        try {
            // TODO add your handling code here:
            arquivo x = new arquivo();
            
            Servicos = x.getServicos();
            Servico selecionado = Servicos.get(index_selecionado); //Armazenar para passar para o outro arquivo
            Servicos.remove(index_selecionado);
            x.setServicos(Servicos);
            
            arquivo y = new arquivo();
            
            ServicosAtivados = y.getServicosAtivados(); //busca os serviços ativados
            ServicosAtivados.add(selecionado);
            y.setServicosAtivados(ServicosAtivados);    //atualiza os serviços ativados
            
            this.dispose();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GUI_AtivaServico.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GUI_AtivaServico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton_AtivaServicoActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton_AtivaServico;
    private javax.swing.JButton jButton_EditaServico;
    private javax.swing.JButton jButton_ExcluiServico;
    private javax.swing.JComboBox<String> jComboBox_Servicos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel_semServico;
    private javax.swing.JTextField jTextField_Nome;
    private javax.swing.JTextField jTextField_Observacao;
    // End of variables declaration//GEN-END:variables
}
