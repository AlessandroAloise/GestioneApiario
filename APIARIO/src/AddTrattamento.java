
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Schermata di dialogo per aggiungere un trattamento.
 *
 * @author alessandro.aloise
 * @version 17.12.2020
 */
public class AddTrattamento extends javax.swing.JDialog {

    String[] valori = new String[3];

    /**
     * Metodo costruttore
     *
     * @param parent
     */
    public AddTrattamento(java.awt.Frame parent) {
        super(parent);
        initComponents();
    }

    /**
     * Metodo che si occupa di controllare se ci sono state modifiche.
     */
    private void raiseChange() {
        PropertyChangeEvent event = new PropertyChangeEvent(this, "trattamento", false, valori);
        PropertyChangeListener[] listeners = this.getPropertyChangeListeners();
        synchronized (listeners) {
            for (PropertyChangeListener e : listeners) {
                e.propertyChange(event);
            }
        }
    }

    /**
     * Metodo che imposta i valri all'interno dell'array.
     */
    public void setValori() {
        valori[0] = datePickerInizio.getDate().toString();
        valori[1] = nomeTrattamentoJ.getText();
        valori[2] = datePickerFine.getDate().toString();
    }

    /**
     * Getter per l'array.
     *
     * @param indice indice che ci serve conoscere dell'array.
     * @return valore all'indice indicato.
     */
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
     * Main della applicazione.
     *
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
