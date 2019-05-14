/*
 *      CENTRO FEDERAL DE EDUCAÇÃO TECNOLÓGICA DE MINAS GERAIS
 * ENGENHARIA DE COMPUTAÇÃO - LABORATORIO DE LINGUAGEM DE PROGRAMAÇÃO
 * 
 *                    ANTONIO SOUSA E GABRIEL NEGREIROS
 */

package GUI;

import Usuario.Administrador;
import Usuario.Usuario;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Negreiros
 */
public class GUI_MenuPrincipal_Admin extends javax.swing.JFrame {

    private Usuario admin;
    /**
     * Creates new form GUI_MenuPrincipal_Admin
     */
    public GUI_MenuPrincipal_Admin(Usuario admin) {
        initComponents();
        
        // Centraliza o JFrame na tela
        this.setLocationRelativeTo(null);
        this.admin = admin;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton_CadastraServico = new javax.swing.JButton();
        jButton_AtivaServico = new javax.swing.JButton();
        jButton_ServicosAtivados = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("MENU PRINCIPAL DO ADMIN");

        jButton_CadastraServico.setText("Cadastrar Serviço");
        jButton_CadastraServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CadastraServicoActionPerformed(evt);
            }
        });

        jButton_AtivaServico.setText("Ativar Serviço");
        jButton_AtivaServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AtivaServicoActionPerformed(evt);
            }
        });

        jButton_ServicosAtivados.setText("Serviços Ativados");
        jButton_ServicosAtivados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ServicosAtivadosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(257, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(225, 225, 225))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton_ServicosAtivados, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_AtivaServico, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_CadastraServico, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jButton_CadastraServico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_AtivaServico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_ServicosAtivados)
                .addContainerGap(221, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_CadastraServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CadastraServicoActionPerformed
        new GUI_CadastraServico().setVisible(true);
    }//GEN-LAST:event_jButton_CadastraServicoActionPerformed

    private void jButton_AtivaServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AtivaServicoActionPerformed
        try {
            new GUI_AtivaServico().setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(GUI_MenuPrincipal_Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton_AtivaServicoActionPerformed

    private void jButton_ServicosAtivadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ServicosAtivadosActionPerformed
        try {
            // TODO add your handling code here:
            new GUI_ListaServicosAtivados().setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(GUI_MenuPrincipal_Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton_ServicosAtivadosActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_AtivaServico;
    private javax.swing.JButton jButton_CadastraServico;
    private javax.swing.JButton jButton_ServicosAtivados;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}