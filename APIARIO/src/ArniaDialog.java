
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Schermata di dialogo per aggiungere un arina.
 *
 * @author alessandro.aloise
 * @version 17.12.2020
 */
public class ArniaDialog extends javax.swing.JDialog {

    /**
     * Metodo costruttore
     *
     * @param parent
     */
    public ArniaDialog(java.awt.Frame parent) {
        super(parent);
        initComponents();
    }

    /**
     * Metodo che si occupa di controllare se ci sono state modifiche.
     */
    private void raiseChange() {
        PropertyChangeEvent event = new PropertyChangeEvent(this, "arina", false, testo.getText());
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

        titolo = new javax.swing.JLabel();
        testo = new javax.swing.JTextField();
        invio = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nome Arina");
        setPreferredSize(new java.awt.Dimension(200, 100));

        titolo.setText("Nome Arina:");
        getContentPane().add(titolo, java.awt.BorderLayout.LINE_START);
        getContentPane().add(testo, java.awt.BorderLayout.CENTER);

        invio.setText("Invio");
        invio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invioActionPerformed(evt);
            }
        });
        getContentPane().add(invio, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void invioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invioActionPerformed
        raiseChange();
        this.setVisible(false);
    }//GEN-LAST:event_invioActionPerformed

    /**
     * Main della applicazione.
     * 
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ArniaDialog dialog = new ArniaDialog(new javax.swing.JFrame());
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
    private javax.swing.JButton invio;
    private javax.swing.JTextField testo;
    private javax.swing.JLabel titolo;
    // End of variables declaration//GEN-END:variables
}
