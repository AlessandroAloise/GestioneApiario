
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Form che contine i panel.
 *
 * @author Alessandro Aloise
 * @version 24.09.2020
 */
public class JFrame_Apiaroi extends javax.swing.JFrame {

    /**
     * Variabile per id utente.
     */
    public int id;
    
    /**
     * Dichiarazione di un istantza di una classe utile.
     */
    CheckData checkData = new CheckData();

    /**
     * Creates new form JFrame_Apiaroi
     */
    public JFrame_Apiaroi() {
        initComponents();
        connessione();

    }

    /**
     * Metodo che si occupa di controolare se il dispositivo su qui sta girando l'applicazione a internet.
     */
    public void connessione() {
        try {
            URL url = new URL("http://www.google.com");
            URLConnection connection = url.openConnection();
            connection.connect();
            scaricaDB();
        } catch (MalformedURLException e) {
            checkData.alert("ATTENZIONE NON CONESSO A INTERNET" + '\n'
                    + "Il programma funzionerà solo se lo avevi già avviato con internet"
                    + '\n'
                    + "Il programma salverà solo le informazioni in locale"
            );
        } catch (IOException e) {
            checkData.alert("ATTENZIONE NON CONESSO A INTERNET" + '\n'
                    + "Il programma funzionerà solo se lo avevi già avviato con internet"
                    + '\n'
                    + "Il programma salverà solo le informazioni in locale"
            );
        }
    }

    /**
     * Metodo che serve a scaricare il db dal sito ogni volta che si avvia l'applicazione
     */
    public void scaricaDB() {
        try ( BufferedInputStream in = new BufferedInputStream(new URL("http://samtinfo.ch/i17aloale/up/Apiario.sqlite").openStream());  FileOutputStream fileOutputStream = new FileOutputStream("Apiario.sqlite")) {
            byte dataBuffer[] = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        login = new Login();
        register = new Register();
        home = new Home();
        start = new Start();

        login.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                loginPropertyChange(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("APIARIO");
        setBackground(new java.awt.Color(255, 255, 255));

        start.setMinimumSize(new java.awt.Dimension(200, 200));
        start.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                startPropertyChange(evt);
            }
        });
        getContentPane().add(start, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_startPropertyChange
        /*
         * Controlla quale tasto é stato premuto e in base a quello esegue del codice diverso.
         */
        start.addButton1ActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand() == "Login") {
                    start.setVisible(false);
                    getContentPane().add(login);
                    login.setVisible(true);
                    validate();
                } else if (e.getActionCommand() == "Registarti") {
                    start.setVisible(false);
                    getContentPane().add(register);
                    register.setVisible(true);
                    validate();
                }
            }
        });


    }//GEN-LAST:event_startPropertyChange

    private void loginPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_loginPropertyChange
        /*
         * Controlla se il tasto login é cliccato allora viene chiamato in causa.
         */
        if ("login".equals(evt.getPropertyName())) {
            if ((boolean) evt.getNewValue()) {
                id = login.getUtente();
                home.setUserId(id);
                login.setVisible(false);
                getContentPane().add(home, java.awt.BorderLayout.CENTER);
                home.setVisible(true);
                validate();
            }

        }

    }//GEN-LAST:event_loginPropertyChange

    /**
     * Main della applicazione.
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrame_Apiaroi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrame_Apiaroi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrame_Apiaroi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrame_Apiaroi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrame_Apiaroi().setVisible(true);

            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Home home;
    private Login login;
    private Register register;
    private Start start;
    // End of variables declaration//GEN-END:variables
}
