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

/**
 *
 * @author Antonio
 */
public class GUI_ListaServicosAtivados extends javax.swing.JFrame {
    
    private ArrayList<Servico> Servicos;
    /**
     * Creates new form GUI_ListaServicosAtivados
     */
    public GUI_ListaServicosAtivados() throws FileNotFoundException, IOException {
        initComponents();
        
        // Centraliza o JFrame na tela
        this.setLocationRelativeTo(null);
        
        jComboBox_Servicos.removeAllItems();
                
        arquivo x = new arquivo();
        Servicos = x.getServicosAtivados();
        
        for (Iterator iterator = Servicos.iterator(); iterator.hasNext(); ) {  
            Servico lido = (Servico) iterator.next();
            
            jComboBox_Servicos.addItem(lido.getTipoServico());
        }
        
        this.jTextField_Observacoes.setEditable(false);
        this.jTextField_Observacoes.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jComboBox_Servicos = new javax.swing.JComboBox<>();
        jTextField_Observacoes = new javax.swing.JTextField();
        jButton_Sair = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Confira abaixo os serviços disponíveis:");

        jComboBox_Servicos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox_Servicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_ServicosActionPerformed(evt);
            }
        });

        jTextField_Observacoes.setText("Observações");
        jTextField_Observacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_ObservacoesActionPerformed(evt);
            }
        });

        jButton_Sair.setText("Voltar");
        jButton_Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SairActionPerformed(evt);
            }
        });

        jLabel1.setText("Serviço:");

        jLabel3.setText("Observação:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton_Sair))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jComboBox_Servicos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField_Observacoes, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE))
                            .addComponent(jLabel3))))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox_Servicos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(2, 2, 2)
                .addComponent(jTextField_Observacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
                .addComponent(jButton_Sair)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox_ServicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_ServicosActionPerformed
        // TODO add your handling code here:
        int index_selecionado = jComboBox_Servicos.getSelectedIndex();
        
        if(index_selecionado>=0){
            Servico selecionado = Servicos.get(index_selecionado);
            jTextField_Observacoes.setText(selecionado.getObservacaoServico());
            //System.out.println(selecionado.getTipoServico());

        }
    }//GEN-LAST:event_jComboBox_ServicosActionPerformed

    private void jButton_SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SairActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton_SairActionPerformed

    private void jTextField_ObservacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_ObservacoesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_ObservacoesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Sair;
    private javax.swing.JComboBox<String> jComboBox_Servicos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField_Observacoes;
    // End of variables declaration//GEN-END:variables
}