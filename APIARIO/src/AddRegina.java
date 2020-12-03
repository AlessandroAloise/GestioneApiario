
import java.awt.Frame;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 *
 * @author alessandro.aloise
 */
public class AddRegina extends javax.swing.JDialog {


    /**
     * Creates new form AddRegina
     */
    public AddRegina(java.awt.Frame parent) {
        super(parent);
        initComponents();
    }

    private void raiseChange() {
        PropertyChangeEvent event = new PropertyChangeEvent(this, "regina", false, datePicker.getDate());
        PropertyChangeListener[] listeners = this.getPropertyChangeListeners();
        synchronized (listeners) {
            for (PropertyChangeListener e : listeners) {
                e.propertyChange(event);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        invio = new javax.swing.JButton();
        dataPanel = new javax.swing.JPanel();
        data = new javax.swing.JLabel();
        datePicker = new com.github.lgooddatepicker.components.DatePicker();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Data Regina");
        setMinimumSize(new java.awt.Dimension(300, 60));

        invio.setText("Invio");
        invio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invioActionPerformed(evt);
            }
        });
        getContentPane().add(invio, java.awt.BorderLayout.PAGE_END);

        dataPanel.setLayout(new java.awt.BorderLayout());

        data.setText("Data:");
        dataPanel.add(data, java.awt.BorderLayout.LINE_START);
        dataPanel.add(datePicker, java.awt.BorderLayout.CENTER);

        getContentPane().add(dataPanel, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void invioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invioActionPerformed
        raiseChange();
        this.setVisible(false);
    }//GEN-LAST:event_invioActionPerformed

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
            java.util.logging.Logger.getLogger(AddRegina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddRegina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddRegina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddRegina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AddRegina dialog = new AddRegina(new javax.swing.JFrame());
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel data;
    private javax.swing.JPanel dataPanel;
    private com.github.lgooddatepicker.components.DatePicker datePicker;
    private javax.swing.JButton invio;
    // End of variables declaration//GEN-END:variables
}
