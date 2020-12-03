import dbUtil.dbConnection;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alessandro Aloise
 * @version 24.09.2020
 */
public class Login extends javax.swing.JPanel {
    public int idUtenteDb;
    CheckData checkData = new CheckData();
    Connection connection;
    private PreparedStatement pr = null;
    private ResultSet rs = null;

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        try {
            this.connection = dbConnection.getConnection();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        if (connection == null) {
            System.exit(1);
        }

    }

    /**
     * Metodo che si occupa di controllare se l'utente che si sta loggando eiste.
     * 
     * @param user nome utente.
     * @param password password del nome utente
     * @return ritorna un flag true se si può loggare e false se non può.
     */
    public boolean isLogin(String user, String password) {
        String sql = "SELECT * FROM utenti where username =? and password = ? ";

        try {
            pr = connection.prepareStatement(sql);
            pr.setString(1, user);
            pr.setString(2, password);
            utente(user);

            rs = pr.executeQuery();

            if (rs.next()) {
                return true;
            }
            return false;

        } catch (SQLException ex) {
            return false;
        }
    }
    
    /**
     * Metodo che permette di selezionare l'id del utente che si vuole.
     * @param user nome utente di chi si logga.
     */
    public void utente(String user) {
        String sql = "SELECT id FROM utenti where username =? ";

        try {
            pr = connection.prepareStatement(sql);
            pr.setString(1, user);
            rs = pr.executeQuery();
            idUtenteDb=(rs.getInt("id")); 
        } catch (SQLException ex) {
            System.out.println("error"+ ex);
        }
    }

    public void raiseChange() {
        PropertyChangeEvent event = new PropertyChangeEvent(this, "login", getUtente(), true);
        PropertyChangeListener[] listeners = this.getPropertyChangeListeners();
        synchronized (listeners) {
            for (PropertyChangeListener e : listeners) {
                e.propertyChange(event);

            }
        }
    }
    
    
    
    
    /**
     * Metodo che ci permette di ricavare l'id.
     * 
     * @return id del nome utente.
     */
    public int getUtente(){
        return idUtenteDb;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Titolo = new javax.swing.JLabel();
        User = new javax.swing.JTextField();
        Password = new javax.swing.JPasswordField();
        Accedi = new javax.swing.JButton();
        wifi = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        Titolo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Titolo.setText("Login");
        Titolo.setBackground(new java.awt.Color(255, 255, 255));
        Titolo.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        Titolo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        User.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        User.setText("ale");
        User.setToolTipText("");

        Password.setText("Ciao12345");
        Password.setToolTipText("");

        Accedi.setText("Accedi");
        Accedi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AccediActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Titolo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(wifi))
            .addGroup(layout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Password)
                    .addComponent(User)
                    .addComponent(Accedi, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
                .addGap(160, 160, 160))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(wifi)
                .addGap(75, 75, 75)
                .addComponent(Titolo)
                .addGap(39, 39, 39)
                .addComponent(User, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(Accedi)
                .addContainerGap(74, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void AccediActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AccediActionPerformed
        String pass = new String(Password.getPassword());
        if (checkData.chekRules(User.getText(), pass)) {
            if (isLogin(User.getText(), pass)) {
                System.out.println("conesso al db");
                raiseChange();
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                checkData.alert("Nome utente o password sbagliati");
            }
        }
    }//GEN-LAST:event_AccediActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Accedi;
    private javax.swing.JPasswordField Password;
    private javax.swing.JLabel Titolo;
    private javax.swing.JTextField User;
    private javax.swing.JLabel wifi;
    // End of variables declaration//GEN-END:variables
}
