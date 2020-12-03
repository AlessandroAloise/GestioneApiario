
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 *
 * @author alessandro.aloise
 */
public class AddTrattamento extends javax.swing.JDialog {
    
    String[] valori = new String[3];
    

    /**
     * Creates new form AddTrattamento
     */
    public AddTrattamento(java.awt.Frame parent) {
        super(parent);
        initComponents();
    }

        private void raiseChange() {
        PropertyChangeEvent event = new PropertyChangeEvent(this, "trattamento", false, valori);
        PropertyChangeListener[] listeners = this.getPropertyChangeListeners();
        synchronized (listeners) {
            for (PropertyChangeListener e : listeners) {
                e.propertyChange(event);
            }
        }
    }
        
        
     public void setValori(){
         valori[0] =datePickerInizio.getDate().toString();
         valori[1]= nomeTrattamentoJ.getText();
         valori[2] = datePickerFine.getDate().toString();
     }
     
     
    public String getValori(int indice) {
        return valori[indice];
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inizio = new javax.swing.JPanel();
        dataInizio = new javax.swing.JLabel();
        datePickerInizio = new com.github.lgooddatepicker.components.DatePicker();
        fine = new javax.swing.JPanel();
        datePickerFine = new com.github.lgooddatepicker.components.DatePicker();
        invio = new javax.swing.JButton();
        dataFine = new javax.swing.JLabel();
        dati = new javax.swing.JPanel();
        nome = new javax.swing.JLabel();
        nomeTrattamentoJ = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(300, 150));

        inizio.setLayout(new java.awt.BorderLayout());

        dataInizio.setText("Data inizio:");
        inizio.add(dataInizio, java.awt.BorderLayout.LINE_START);
        inizio.add(datePickerInizio, java.awt.BorderLayout.CENTER);

        getContentPane().add(inizio, java.awt.BorderLayout.NORTH);

        fine.setLayout(new java.awt.BorderLayout());
        fine.add(datePickerFine, java.awt.BorderLayout.CENTER);

        invio.setText("Invio");
        invio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invioActionPerformed(evt);
            }
        });
        fine.add(invio, java.awt.BorderLayout.SOUTH);

        dataFine.setText("Data fine:");
        fine.add(dataFine, java.awt.BorderLayout.LINE_START);

        getContentPane().add(fine, java.awt.BorderLayout.SOUTH);

        dati.setLayout(new java.awt.BorderLayout());

        nome.setText("Nome trattamento:");
        dati.add(nome, java.awt.BorderLayout.WEST);
        dati.add(nomeTrattamentoJ, java.awt.BorderLayout.CENTER);

        getContentPane().add(dati, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void invioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invioActionPerformed
        setValori();
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
            java.util.logging.Logger.getLogger(AddTrattamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddTrattamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddTrattamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddTrattamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AddTrattamento dialog = new AddTrattamento(new javax.swing.JFrame());
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
    private javax.swing.JLabel dataFine;
    private javax.swing.JLabel dataInizio;
    private com.github.lgooddatepicker.components.DatePicker datePickerFine;
    private com.github.lgooddatepicker.components.DatePicker datePickerInizio;
    private javax.swing.JPanel dati;
    private javax.swing.JPanel fine;
    private javax.swing.JPanel inizio;
    private javax.swing.JButton invio;
    private javax.swing.JLabel nome;
    private javax.swing.JTextField nomeTrattamentoJ;
    // End of variables declaration//GEN-END:variables
}
