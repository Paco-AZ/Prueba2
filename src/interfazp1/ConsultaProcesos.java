/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfazp1;

import cjb.ci.CtrlInterfaz;
import cjb.ci.Mensajes;
import java.awt.event.KeyEvent;

/**
 *
 * @author Francisco
 */
public class ConsultaProcesos extends javax.swing.JFrame
{

    /**
     * Creates new form ConsultaProcesos
     */
    public ConsultaProcesos()
    {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Procesos = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        numeroP = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        salirB = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Procesos.setColumns(20);
        Procesos.setRows(5);
        jScrollPane1.setViewportView(Procesos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 590, 270));

        jLabel1.setText("Nivel de Prioridad");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 106, -1, 20));

        numeroP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        numeroP.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                numeroPItemStateChanged(evt);
            }
        });
        numeroP.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                numeroPKeyPressed(evt);
            }
        });
        jPanel1.add(numeroP, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 100, 90, 30));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("CONSULTAS");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, 370, 50));

        salirB.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        salirB.setText("Salir");
        salirB.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                salirBActionPerformed(evt);
            }
        });
        salirB.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                salirBKeyPressed(evt);
            }
        });
        jPanel1.add(salirB, new org.netbeans.lib.awtextra.AbsoluteConstraints(762, 453, 110, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 877, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void numeroPKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_numeroPKeyPressed
    {//GEN-HEADEREND:event_numeroPKeyPressed
        // TODO add your handling code here:
        if ('\n' == evt.getKeyChar())
        {
            CtrlInterfaz.cambia(salirB);
        }
        if (KeyEvent.VK_RIGHT == evt.getKeyCode())
        {
            CtrlInterfaz.cambia(salirB);
        }
        if (KeyEvent.VK_LEFT == evt.getKeyCode())
        {
            CtrlInterfaz.cambia(salirB);
        }
    }//GEN-LAST:event_numeroPKeyPressed

    private void numeroPItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_numeroPItemStateChanged
    {//GEN-HEADEREND:event_numeroPItemStateChanged
        // TODO add your handling code here:
        Procesos.setText(Principal.x.dispPP(numeroP.getSelectedIndex()));
    }//GEN-LAST:event_numeroPItemStateChanged

    private void salirBActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_salirBActionPerformed
    {//GEN-HEADEREND:event_salirBActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_salirBActionPerformed

    private void salirBKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_salirBKeyPressed
    {//GEN-HEADEREND:event_salirBKeyPressed
        // TODO add your handling code here:
        if ('\n' == evt.getKeyChar())
        {
            salirBActionPerformed(null);
        }
        if (KeyEvent.VK_RIGHT == evt.getKeyCode())
        {
            CtrlInterfaz.cambia(numeroP);
        }
        if (KeyEvent.VK_LEFT == evt.getKeyCode())
        {
            CtrlInterfaz.cambia(numeroP);
        }
    }//GEN-LAST:event_salirBKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(ConsultaProcesos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(ConsultaProcesos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(ConsultaProcesos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(ConsultaProcesos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new ConsultaProcesos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Procesos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> numeroP;
    private javax.swing.JButton salirB;
    // End of variables declaration//GEN-END:variables
}
