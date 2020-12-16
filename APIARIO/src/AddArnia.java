
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Schermata di dialogo per aggiungere un arina.
 *
 * @author alessandro.aloise
 * @version 17.12.2020
 */
public class AddArnia extends javax.swing.JDialog {

    /**
     * Array che contrienie i valori.
     */
    public String[] valori = new String[3];

    /**
     * Metodo costruttore
     * @param parent 
     */
    public AddArnia(java.awt.Frame parent) {
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

    /**
     * Metodo che imposta i valri all'interno dell'array.
     */
    public void setValori() {
        valori[0] = testo.getText();
        valori[1] = tLocalita.getText();
        if(abitata.isSelected()){
            valori[2] = "true"; 
        }else{
            valori[2] = "false";
        }
       
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

        nome = new javax.swing.JPanel();
        titolo = new javax.swing.JLabel();
        testo = new javax.swing.JTextField();
        posizione = new javax.swing.JPanel();
        naz = new javax.swing.JPanel();
        nazione = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        loc = new javax.swing.JPanel();
        località = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tLocalita = new javax.swing.JTextPane();
        invio = new javax.swing.JButton();
        abitata = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nome Arina");

        nome.setLayout(new java.awt.BorderLayout());

        titolo.setText("Nome Arina:");
        nome.add(titolo, java.awt.BorderLayout.LINE_START);
        nome.add(testo, java.awt.BorderLayout.CENTER);

        getContentPane().add(nome, java.awt.BorderLayout.NORTH);

        posizione.setLayout(new java.awt.GridLayout(1, 0));

        naz.setLayout(new java.awt.GridBagLayout());

        nazione.setText("Nazione:     ");
        naz.add(nazione, new java.awt.GridBagConstraints());

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Svizzera", "Afghanistan", "Albania", "Algeria", "Andorra", "Angola", "Anguilla", "Antartide", "Antigua e Barbuda", "Arabia Saudita", "Argentina", "Armenia", "Aruba", "Australia", "Austria", "Azerbaigian", "Bahamas", "Bahrein", "Bangladesh", "Barbados", "Belgio", "Belize", "Benin", "Bermuda", "Bhutan", "Bielorussia", "Birmania", "Bolivia", "Bosnia ed Erzegovina", "Botswana", "Brasile", "Brunei", "Bulgaria", "Burkina Faso", "Burundi", "Cambogia", "Camerun", "Canada", "Capo Verde", "Ciad", "Cile", "Cina", "Cipro", "Citt", "Colombia", "Comore", "Corea del Nord", "Corea del Sud", "Costa d'Avorio", "Costa Rica", "Croazia", "Cuba", "Cura", "Danimarca", "Dominica", "Ecuador", "Egitto", "El Salvador", "Emirati Arabi Uniti", "Eritrea", "Estonia", "Etiopia", "Figi", "Filippine", "Finlandia", "Francia", "Gabon", "Gambia", "Georgia", "Georgia del Sud e isole Sandwich meridionali", "Germania", "Ghana", "Giamaica", "Giappone", "Gibilterra", "Gibuti", "Giordania", "Grecia", "Grenada", "Groenlandia", "Guadalupa", "Guam", "Guatemala", "Guernsey", "Guinea", "Guinea-Bissau", "Guinea Equatoriale", "Guyana", "Guyana francese", "Haiti", "Honduras", "Hong Kong", "India", "Indonesia", "Iran", "Iraq", "Irlanda", "Islanda", "Isola Bouvet", "Isola di Man", "Isola di Natale", "Isola Norfolk", "Isole ", "Isole BES", "Isole Cayman", "Isole Cocos (Keeling)", "Isole Cook", "F", "Isole Falkland", "Isole Heard e McDonald", "Isole Marianne Settentrionali", "Isole Marshall", "Isole minori esterne degli Stati Uniti", "Isole Pitcairn", "Isole Salomone", "Isole Vergini britanniche", "Isole Vergini americane", "Israele", "Italia", "Jersey", "Kazakistan", "Kenya", "Kirghizistan", "Kiribati", "Kuwait", "Laos", "Lesotho", "Lettonia", "Libano", "Liberia", "Libia", "Liechtenstein", "Lituania", "Lussemburgo", "Macao", "Macedonia", "Madagascar", "Malawi", "Malesia", "Maldive", "Mali", "Malta", "Marocco", "Martinica", "Mauritania", "Mauritius", "Mayotte", "Messico", "Micronesia", "Moldavia", "Mongolia", "Montenegro", "Montserrat", "Mozambico", "Namibia", "Nauru", "Nepal", "Nicaragua", "Niger", "Nigeria", "Niue", "Norvegia", "Nuova Caledonia", "Nuova Zelanda", "Oman", "Paesi Bassi", "Pakistan", "Palau", "Palestina", "Panam", "Papua Nuova Guinea", "Paraguay", "Per", "Polinesia Francese", "Polonia", "Porto Rico", "Portogallo", "Monaco", "Qatar", "Regno Unito", "RD del Congo", "Rep. Ceca", "Rep. Centrafricana", "Rep. del Congo", "Rep. Dominicana", "Riunione", "Romania", "Ruanda", "Russia", "Sahara Occidentale", "Saint Kitts e Nevis", "Santa Lucia", "Sant'Elena, Ascensione e Tristan da Cunha", "Saint Vincent e Grenadine", "Saint-Barth", "Saint-Martin", "Saint-Pierre e Miquelon", "Samoa", "Samoa Americane", "San Marino", "S", "Senegal", "Serbia", "Seychelles", "Sierra Leone", "Singapore", "Sint Maarten", "Siria", "Slovacchia", "Slovenia", "Somalia", "Spagna", "Sri Lanka", "Stati Uniti", "Sudafrica", "Sudan", "Sudan del Sud", "Suriname", "Svalbard e Jan Mayen", "Svezia", "Svizzera", "Swaziland", "Taiwan", "Tagikistan", "Tanzania", "Terre australi e antartiche francesi", "Territorio britannico dell'oceano Indiano", "Thailandia", "Timor Est", "Togo", "Tokelau", "Tonga", "Trinidad e Tobago", "Tunisia", "Turchia", "Turkmenistan", "Turks e Caicos", "Tuvalu", "Ucraina", "Uganda", "Ungheria", "Uruguay", "Uzbekistan", "Vanuatu", "Venezuela", "Vietnam", "Wallis e Futuna", "Yemen", "Zambia", "Zimbabwe", " " }));
        naz.add(jComboBox1, new java.awt.GridBagConstraints());

        posizione.add(naz);

        loc.setLayout(new java.awt.BorderLayout());

        località.setText("Località");
        loc.add(località, java.awt.BorderLayout.LINE_START);

        jScrollPane1.setViewportView(tLocalita);

        loc.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        posizione.add(loc);

        getContentPane().add(posizione, java.awt.BorderLayout.CENTER);

        invio.setText("Invio");
        invio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invioActionPerformed(evt);
            }
        });
        getContentPane().add(invio, java.awt.BorderLayout.SOUTH);

        abitata.setText("abitata");
        getContentPane().add(abitata, java.awt.BorderLayout.LINE_END);

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
                AddArnia dialog = new AddArnia(new javax.swing.JFrame());
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
    private javax.swing.JCheckBox abitata;
    private javax.swing.JButton invio;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel loc;
    private javax.swing.JLabel località;
    private javax.swing.JPanel naz;
    private javax.swing.JLabel nazione;
    private javax.swing.JPanel nome;
    private javax.swing.JPanel posizione;
    private javax.swing.JTextPane tLocalita;
    private javax.swing.JTextField testo;
    private javax.swing.JLabel titolo;
    // End of variables declaration//GEN-END:variables
}
