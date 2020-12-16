
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import dbUtil.dbConnection;
import java.awt.Frame;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

/**
 * CLasse principale che si occupa della logia dell'applicazione.
 *
 * @author Alessandro.Aloise
 * @version 16.12.2020
 */
public class Home extends javax.swing.JPanel {

    /**
     * Dichiarazione di un istantza di una classe utile.
     */
    CheckData checkData = new CheckData();

    /**
     * Istanziamento del frame.
     */
    public Frame JFrame_Apiaroi = null;

    /**
     * Assengazione del frame.
     */
    public AddArnia arina = new AddArnia(JFrame_Apiaroi);

    /**
     * Assengazione del frame.
     */
    public AddRegina reginaP = new AddRegina(JFrame_Apiaroi);
    /**
     * Assengazione del frame.
     */
    public AddTrattamento trattamento = new AddTrattamento(JFrame_Apiaroi);

    /**
     * Array contentente i valori delle arine
     * (abitata,nome, località)
     */
    public String[] valoriN = new String[3];
    
    /**
     * Valori trattamenti.
     * (inizio, fine,nome_trattamento, nome_arnia)
     */
    public String[] valoriTrattamenti = new String[3];
    

    private DefaultListModel model = new DefaultListModel<>();
    
    /**
     * ArrayList delle arine.
     */
    public ArrayList list = new ArrayList<>();

    /**
     * Connessione al db.
     */
    Connection connection;

    /**
     * Id del utente loggato.
     */
    public int idUtente;

    private PreparedStatement pr = null;
    private ResultSet rs = null;
    private boolean newNota;

    /**
     * Costruttore della classe
     */
    public Home() {
        initComponents();
        try {
            this.connection = dbConnection.getConnection();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        if (connection == null) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, "Errore di connessione");
        }

    }

    /**
     * Metodo che si occupa di settare la variabile del id utente e aggiornare
     * la lista.
     *
     * @param user id del utente.
     */
    public void setUserId(int user) {
        idUtente = user;
        riempiList();
        arinaList.setModel(model);
        repaint();
    }

    public void prova() throws IOException {
    }

    /**
     * Metodo che si occupa di selezionare tutte le arine di un utente.
     *
     * @param user utente che sta richiedendo le sue arine.
     */
    public void selctArnia() {
        String sql = "select nome from arnia where id_utente = ?";

        try {
            pr = connection.prepareStatement(sql);
            pr.setInt(1, idUtente);
            rs = pr.executeQuery();
            while (rs.next()) {
                addList(rs.getString("nome"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("error" + ex);
        }
    }

    /**
     * Metodo che inserisce le arine nel db con l'id del utente.
     */
    public void arine() {
        String sql = "INSERT INTO arnia(abitata,id_utente, nome, località) values (?,?,?,?)";
        try {
            pr = connection.prepareStatement(sql);
            pr.setString(1, valoriN[2]);
            pr.setInt(2, idUtente);
            pr.setString(3, valoriN[0]);
            pr.setString(4, valoriN[1]);

            pr.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("error: " + ex);
        }
    }

    /**
     * Metodo che permette di aggiungere una regina alla propria arina.
     *
     * @param dataR data di nascita della regina
     */
    public void addRegina(String dataR) {
        String sql = "INSERT INTO sotricoRegine(data, nome_arina) values (?,?)";

        try {
            pr = connection.prepareStatement(sql);
            pr.setString(1, dataR);
            pr.setString(2, arinaList.getSelectedValue());
            pr.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("error: " + ex);
        }

    }

    /**
     * Metodo che controlla se l'arina indicata esiste.
     *
     * @param arina nome arina
     * @return ritorna un flag true se l'arina indicata esiste e false se non
     * esiste.
     */
    public boolean controlloArina(String arina) {
        String sql = "SELECT * FROM arnia where nome =? ";

        try {
            pr = connection.prepareStatement(sql);
            pr.setString(1, arina);

            rs = pr.executeQuery();

            if (rs.next()) {
                return true;
            }
            return false;

        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    /**
     * Metodo che si occupa di selezionare una nota del determinato giorno.
     *
     * @return
     */
    public boolean nota() {
        String dataN = calendarPanel.getSelectedDate().toString();
        String sql = "SELECT testo FROM note where nome_arnia = ?and data_nota = ?";

        try {
            pr = connection.prepareStatement(sql);
            pr.setString(1, arinaList.getSelectedValue());
            pr.setString(2, dataN);

            rs = pr.executeQuery();
            while (rs.next()) {
                if (!(rs.getString("testo") == "")) {
                    note.setText(rs.getString("testo"));
                    return true;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    /**
     * Metodo che genera una nuova nota.
     */
    public void new_note() {
        String dataN = calendarPanel.getSelectedDate().toString();
        String sql = "INSERT INTO note(testo, nome_arnia,data_nota, id_utente) values (?,?,?,?)";

        try {
            pr = connection.prepareStatement(sql);
            pr.setString(1, note.getText());
            pr.setString(2, arinaList.getSelectedValue());
            pr.setString(3, dataN);
            pr.setInt(4, idUtente);
            pr.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("error: " + ex);
        }

    }

    /**
     * Metodo che si occupa di aggiornare una nota esistente.
     */
    public void updata_note() {
        String dataN = calendarPanel.getSelectedDate().toString();
        String sql = "UPDATE note SET testo = ? where nome_arnia = ? and data_nota = ? and id_utente = ?";

        try {
            pr = connection.prepareStatement(sql);
            pr.setString(1, note.getText());
            System.out.println(note.getText());
            pr.setString(2, arinaList.getSelectedValue());
            pr.setString(3, dataN);
            pr.setInt(4, idUtente);
            pr.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Metdo che cancella l'arina dalla tabella arina.
     */
    public void remArnia() {
        String sql = "DELETE FROM arnia where id_utente = ? and nome =? ";

        try {
            remNote();
            remCure();
            pr = connection.prepareStatement(sql);
            pr.setInt(1, idUtente);
            pr.setString(2, arinaList.getSelectedValue());

            pr.executeUpdate();
            note.setText("");

        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Metodo che rimuove una nota.
     */
    public void remNote() {
        String sql = "DELETE FROM note where id_utente = ? and nome_arnia =? ";

        try {
            pr = connection.prepareStatement(sql);
            pr.setInt(1, idUtente);
            pr.setString(2, arinaList.getSelectedValue());

            pr.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Metodo che rimuove una cura.
     */
    public void remCure() {
        String sql = "DELETE FROM cure where id_utente = ? and nome_arnia =? ";

        try {
            pr = connection.prepareStatement(sql);
            pr.setInt(1, idUtente);
            pr.setString(2, arinaList.getSelectedValue());

            pr.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Metodo che permette di aggiungere un arina alla lista che si vede.
     *
     * @param arina arina da aggiungere.
     */
    public void addList(String arina) {
        list.add(arina);
        valida();
    }

    public void remList() {
        list.remove(arinaList.getSelectedValue());
        valida();
    }

    /**
     * Metodo che si occupa di riempire la lista delle arine.
     */
    private void riempiList() {
        selctArnia();
        valida();
    }

    /**
     * Metodo che si occupa di validare la lista.
     */
    public void valida() {
        model.clear();
        list.stream().forEach((s) -> {
            model.addElement(s);
        });
    }

    /**
     * Metodo che si occupa di gestire il calendario.
     */
    public void calendario() {
        note.setText("");
        checkTrattamenti();
        if (!(calendarPanel.getSelectedDate() == null) && (!(arinaList.getSelectedValue() == null))) {
            newNota = nota();
        }
    }

    /**
     * Metodo per aggiungere un trattamento.
     */
    public void addTrattamenti() {
        String sql = "INSERT INTO cure(inizio, fine,nome_trattamento, nome_arnia,id_utente) values (?,?,?,?,?)";

        try {
            pr = connection.prepareStatement(sql);
            pr.setString(1, valoriTrattamenti[0]);
            pr.setString(2, valoriTrattamenti[2]);
            pr.setString(3, valoriTrattamenti[1]);
            pr.setString(4, arinaList.getSelectedValue());
            pr.setInt(5, idUtente);
            pr.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("error: " + ex);
        }
    }

    /**
     * Metodo che controlla il termine di un trattamento e lo mostra a schermo.
     */
    public void checkTrattamenti() {
        if (!(calendarPanel.getSelectedDate() == null)) {
            String dataN = calendarPanel.getSelectedDate().toString();
            String sql = "SELECT nome_trattamento FROM cure where fine = ? and id_utente =?";

            try {
                pr = connection.prepareStatement(sql);
                pr.setString(1, dataN);
                pr.setInt(2, idUtente);

                rs = pr.executeQuery();
                String nota = "Fine trattamento: ";
                while (rs.next()) {
                    note.append(nota + rs.getString("nome_trattamento"));
                }

            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    /**
     * Metodo che ritorna la località del meteo da guardare.
     *
     * @return località meteo.
     */
    public String meteo() {
        String sql = "SELECT località FROM arnia where nome = ?and id_utente = ?";

        try {
            pr = connection.prepareStatement(sql);
            pr.setString(1, arinaList.getSelectedValue());
            pr.setInt(2, idUtente);

            rs = pr.executeQuery();
            return rs.getString("località");
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    /**
     * Metodo per mappare.
     *
     * @param str
     * @return
     */
    public static Map<String, Object> jsonToMap(String str) {
        Map<String, Object> map = new Gson().fromJson(
                str, new TypeToken<HashMap<String, Object>>() {
                }.getType()
        );
        return map;
    }

    /**
     * Metodo che stampa a schermo il meteo del psoto.
     */
    public void NewMeteo() {
        String API_KEY = "2aef2d1da7628b1200873fc839d8cc5a";
        String posizione = meteo();
        String urlString = "http://api.openweathermap.org/data/2.5/weather?q=" + posizione + "&appid=" + API_KEY + "&units=metric";
        try {
            StringBuilder result = new StringBuilder();
            URL url = new URL(urlString);
            URLConnection conn = url.openConnection();
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            rd.close();
            //System.out.println(result);

            Map<String, Object> resMap = jsonToMap(result.toString());
            Map<String, Object> mainMap = jsonToMap(resMap.get("main").toString());
            Map<String, Object> windMap = jsonToMap(resMap.get("wind").toString());

            checkData.alert("Luogo: " + posizione + '\n'
                    + "Temperatura Attuale: " + mainMap.get("temp") + " C°" + '\n'
                    + "Temperatura Massima: " + mainMap.get("temp_max") + " C°" + '\n'
                    + "Temperatura Minima: " + mainMap.get("temp_min") + " C°" + '\n'
                    + "Umidità Attuale: " + mainMap.get("humidity") + "%" + '\n'
            );

        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuPrincipale = new javax.swing.JPanel();
        arineJ = new javax.swing.JPanel();
        leTueArine = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        arinaList = new javax.swing.JList<>();
        menu = new javax.swing.JPanel();
        arniaB = new javax.swing.JButton();
        regina = new javax.swing.JButton();
        trattamenti = new javax.swing.JButton();
        remArniaB = new javax.swing.JButton();
        meteo = new javax.swing.JButton();
        calendarioJ = new javax.swing.JPanel();
        noteJpanel = new javax.swing.JPanel();
        note = new javax.swing.JTextArea();
        noteJ = new javax.swing.JLabel();
        salvaNota = new javax.swing.JButton();
        calendarPanel = new com.github.lgooddatepicker.components.CalendarPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(500, 203));
        setPreferredSize(new java.awt.Dimension(600, 400));
        setLayout(new java.awt.BorderLayout());

        menuPrincipale.setLayout(new javax.swing.BoxLayout(menuPrincipale, javax.swing.BoxLayout.Y_AXIS));

        arineJ.setLayout(new java.awt.BorderLayout());

        leTueArine.setBackground(new java.awt.Color(255, 255, 255));
        leTueArine.setText("Le tue arine:                           ");
        arineJ.add(leTueArine, java.awt.BorderLayout.NORTH);

        arinaList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Le tue arnie:", " " };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(arinaList);

        arineJ.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        menuPrincipale.add(arineJ);

        menu.setLayout(new java.awt.BorderLayout());

        arniaB.setText("agguingi arnia");
        arniaB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arniaBActionPerformed(evt);
            }
        });
        menu.add(arniaB, java.awt.BorderLayout.CENTER);

        regina.setText("Ape regina");
        regina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reginaActionPerformed(evt);
            }
        });
        menu.add(regina, java.awt.BorderLayout.PAGE_START);

        trattamenti.setText("Trattamenti");
        trattamenti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trattamentiActionPerformed(evt);
            }
        });
        menu.add(trattamenti, java.awt.BorderLayout.LINE_END);

        remArniaB.setText("Rimuovi arina");
        remArniaB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remArniaBActionPerformed(evt);
            }
        });
        menu.add(remArniaB, java.awt.BorderLayout.PAGE_END);

        meteo.setText("Meteo");
        meteo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meteoActionPerformed(evt);
            }
        });
        menu.add(meteo, java.awt.BorderLayout.LINE_START);

        menuPrincipale.add(menu);

        add(menuPrincipale, java.awt.BorderLayout.LINE_START);

        calendarioJ.setLayout(new java.awt.BorderLayout());

        noteJpanel.setLayout(new java.awt.BorderLayout());

        note.setColumns(20);
        note.setRows(5);
        noteJpanel.add(note, java.awt.BorderLayout.CENTER);

        noteJ.setText("Note:    ");
        noteJpanel.add(noteJ, java.awt.BorderLayout.NORTH);

        salvaNota.setText("Salva nota");
        salvaNota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvaNotaActionPerformed(evt);
            }
        });
        noteJpanel.add(salvaNota, java.awt.BorderLayout.SOUTH);

        calendarioJ.add(noteJpanel, java.awt.BorderLayout.SOUTH);

        calendarPanel.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                calendarPanelPropertyChange(evt);
            }
        });
        calendarioJ.add(calendarPanel, java.awt.BorderLayout.NORTH);

        add(calendarioJ, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void arniaBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arniaBActionPerformed
        arina.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                arinaDialogPropertyChange(evt);
            }
        });
        arina.setVisible(true);
    }//GEN-LAST:event_arniaBActionPerformed

    private void reginaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reginaActionPerformed
        reginaP.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                reginaDialogPropertyChange(evt);
            }
        });
        reginaP.setVisible(true);
    }//GEN-LAST:event_reginaActionPerformed

    private void salvaNotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvaNotaActionPerformed
        if (!newNota) {
            new_note();
        } else {
            updata_note();
        }
    }//GEN-LAST:event_salvaNotaActionPerformed

    private void calendarPanelPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_calendarPanelPropertyChange
        calendario();
    }//GEN-LAST:event_calendarPanelPropertyChange

    private void trattamentiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trattamentiActionPerformed
        trattamento.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                trattamentoDialogPropertyChange(evt);
            }
        });
        trattamento.setVisible(true);
    }//GEN-LAST:event_trattamentiActionPerformed

    private void remArniaBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remArniaBActionPerformed
        remArnia();
        remList();
    }//GEN-LAST:event_remArniaBActionPerformed

    private void meteoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meteoActionPerformed
        try {
            if (!(arinaList.getSelectedValue() == null)) {
                NewMeteo();
            } else {
                checkData.alert("Nessuna arina selezionata");
            }
            prova();
        } catch (IOException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_meteoActionPerformed

    /**
     * Viene richiamato quando viene richiamato arina.
     *
     * @param evt
     */
    private void arinaDialogPropertyChange(java.beans.PropertyChangeEvent evt) {
        if ("arina".equals(evt.getPropertyName())) {
            for (int i = 0; i < 3; i++) {
                valoriN[i] = arina.getValori(i);
            }
            addList(valoriN[0]);
            arine();
        }
    }

    /**
     * Viene richiamato quando viene richiamato regina.
     *
     * @param evt
     */
    private void reginaDialogPropertyChange(java.beans.PropertyChangeEvent evt) {
        if ("regina".equals(evt.getPropertyName())) {
            if (arinaList.getSelectedValue() == null) {
                checkData.alert("Nessuna arina selezionata");
            } else {
                addRegina(evt.getNewValue().toString());
            }
        }
    }

    /**
     * Viene richiamato quando viene richiamato trattamento.
     *
     * @param evt
     */
    private void trattamentoDialogPropertyChange(java.beans.PropertyChangeEvent evt) {
        if ("trattamento".equals(evt.getPropertyName())) {
            if (!(arinaList.getSelectedValue() == null)) {
                for (int i = 0; i < 3; i++) {
                    valoriTrattamenti[i] = trattamento.getValori(i);
                }
                addTrattamenti();
            } else {
                checkData.alert("Nessuna arina selezionata per i tratattamenti");
            }
        }

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> arinaList;
    private javax.swing.JPanel arineJ;
    private javax.swing.JButton arniaB;
    private com.github.lgooddatepicker.components.CalendarPanel calendarPanel;
    private javax.swing.JPanel calendarioJ;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel leTueArine;
    private javax.swing.JPanel menu;
    private javax.swing.JPanel menuPrincipale;
    private javax.swing.JButton meteo;
    private javax.swing.JTextArea note;
    private javax.swing.JLabel noteJ;
    private javax.swing.JPanel noteJpanel;
    private javax.swing.JButton regina;
    private javax.swing.JButton remArniaB;
    private javax.swing.JButton salvaNota;
    private javax.swing.JButton trattamenti;
    // End of variables declaration//GEN-END:variables

}
