import dbUtil.dbConnection;
import java.awt.Frame;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

/**
 *
 *
 * @author alessandro.aloise
 * @version 26.11.2020
 */
public class Home extends javax.swing.JPanel {
    CheckData checkData = new CheckData();
    public Frame JFrame_Apiaroi = null;
    public AddArnia arina = new AddArnia(JFrame_Apiaroi);
    public AddRegina reginaP = new AddRegina(JFrame_Apiaroi);
    public String[] valoriN = new String[3];

    private DefaultListModel model = new DefaultListModel<>();
    public ArrayList list = new ArrayList<>();
    Connection connection;
    private int idRegina;
    public int idUtente;

    private PreparedStatement pr = null;
    private ResultSet rs = null;

    /**
     * Creates new form Home
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
        System.out.println(idUtente);
        riempiList();
        arinaList.setModel(model);

    }

    /**
     * Metodo che si occupa di selezionare tutte le arine di un utente.
     *
     * @param user utente che sta richiedendo le sue arine.
     */
    public void selctArnia(int user) {
        String sql = "select nome from arnia where id_utente = ?";

        try {
            pr = connection.prepareStatement(sql);
            pr.setInt(1, user);
            rs = pr.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("nome"));
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
        String sql = "INSERT INTO arnia(abitata,id_utente, nome) values (?,?,?)";
        System.out.println(idUtente);
        try {
            pr = connection.prepareStatement(sql);
            pr.setString(1, "true");
            pr.setInt(2, idUtente);
            pr.setString(3, valoriN[0]);

            pr.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("error: " + ex);
        }
    }

    /**
     * Metodo che si occupa di cerca una regina tramite la sua data di nascita.
     *
     * @param data Data di nascita della regina.
     */
    public void selctReginaId(String data) {
        String sql = "select id from regina where data = ?";

        try {
            pr = connection.prepareStatement(sql);
            pr.setString(1, data);
            rs = pr.executeQuery();
            idRegina = rs.getInt("id");
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("error" + ex);
        }
    }

    /**
     * Metodo che permette di aggiungere una regina alla propria arina.
     *
     * @param dataR data di nascita della regina
     */
    public void addRegina(String dataR) {
        String sql = "INSERT INTO regina(data) values (?)";

        try {
            pr = connection.prepareStatement(sql);
            pr.setString(1, dataR);
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

    public void aggiornametoArina(String nome, int id) {
        String sql = "UPDATE arnia SET id_regina = ? where nome = ? & id=?";

        try {
            pr = connection.prepareStatement(sql);
            pr.setInt(1, idRegina);
            pr.setString(2, nome);
            pr.setInt(3, id);
            pr.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println("error: " + ex);
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

    /**
     * Metodo che si occupa di riempire la lista delle arine.
     */
    private void riempiList() {
        list.add("Arine:");
        selctArnia(idUtente);
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuPrincipale = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        arinaList = new javax.swing.JList<>();
        menu = new javax.swing.JPanel();
        arniaB = new javax.swing.JButton();
        regina = new javax.swing.JButton();
        trattamenti = new javax.swing.JButton();
        note = new javax.swing.JTextArea();
        calendarPanel1 = new com.github.lgooddatepicker.components.CalendarPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(500, 203));
        setPreferredSize(new java.awt.Dimension(600, 270));
        setLayout(new java.awt.BorderLayout());

        menuPrincipale.setLayout(new javax.swing.BoxLayout(menuPrincipale, javax.swing.BoxLayout.Y_AXIS));

        arinaList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Le tue arnie:", " " };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(arinaList);

        menuPrincipale.add(jScrollPane1);

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
        menu.add(trattamenti, java.awt.BorderLayout.LINE_END);

        menuPrincipale.add(menu);

        note.setColumns(20);
        note.setRows(5);
        note.setText("note");
        menuPrincipale.add(note);

        add(menuPrincipale, java.awt.BorderLayout.LINE_START);
        add(calendarPanel1, java.awt.BorderLayout.CENTER);
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

    private void arinaDialogPropertyChange(java.beans.PropertyChangeEvent evt) {
        if ("arina".equals(evt.getPropertyName())) {
            for (int i = 0; i < 3; i++) {
                valoriN[i] = arina.getValori(i);
            }
            addList(valoriN[0]);
            arine();
        }
    }

    private void reginaDialogPropertyChange(java.beans.PropertyChangeEvent evt) {
        if ("regina".equals(evt.getPropertyName())) {
            String arinaUtente = reginaP.getNomeArina();
            if (controlloArina(arinaUtente)) {
                addRegina(evt.getNewValue().toString());
                selctReginaId(evt.getNewValue().toString());
                aggiornametoArina(arinaUtente, idUtente);
            } else {
                checkData.alert("Nome arina sbagliato");
            }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> arinaList;
    private javax.swing.JButton arniaB;
    private com.github.lgooddatepicker.components.CalendarPanel calendarPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel menu;
    private javax.swing.JPanel menuPrincipale;
    private javax.swing.JTextArea note;
    private javax.swing.JButton regina;
    private javax.swing.JButton trattamenti;
    // End of variables declaration//GEN-END:variables
}
