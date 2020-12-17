
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 *
 * @author alessandro.aloise
 * @version 17.12.2020
 */
public class AddRegina extends javax.swing.JDialog {


    /**
     * Metodo costruttore
     * @param parent 
     */
    public AddRegina(java.awt.Frame parent) {
        super(parent);
        initComponents();
    }

        /**
     * Metodo che si occupa di controllare se ci sono state modifiche.
     */
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
     * Main della applicazione.
     * 
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
