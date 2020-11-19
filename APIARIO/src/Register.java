
import dbUtil.dbConnection;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alessandro.aloise
 */
public class Register extends javax.swing.JPanel {

    Connection connection;
    CheckData checkData = new CheckData();

    /**
     * Creates new form Prova
     */
    public Register() {
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

    public boolean isRegister(String user, String password, String email) {
        PreparedStatement pr = null;
        ResultSet rs = null;

        String sql = "INSERT INTO utenti(username,admin,password,email) values (?,?,?,?)";

        try {
            pr = connection.prepareStatement(sql);
            pr.setString(1, user);
            pr.setString(2, "false");
            pr.setString(3, password);
            pr.setString(4, email);

            pr.executeUpdate();
            return true;

        } catch (SQLException ex) {
            return false;
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Titolo = new javax.swing.JLabel();
        acesso = new javax.swing.JButton();
        Nome = new javax.swing.JTextField();
        Cognome = new javax.swing.JTextField();
        Email = new javax.swing.JTextField();
        Password = new javax.swing.JPasswordField();
        NomeUtente = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));

        Titolo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Titolo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Titolo.setText("REGISTRATI");

        acesso.setText("Accedi");
        acesso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acessoActionPerformed(evt);
            }
        });

        Nome.setText("Nome");

        Cognome.setText("Cognome");

        Email.setText("Email");

        Password.setText("jPasswordField1");

        NomeUtente.setText("nome.cognome");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Titolo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Cognome, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(acesso, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                    .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(Email, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Nome, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NomeUtente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))
                .addGap(153, 153, 153))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(Titolo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Cognome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NomeUtente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(acesso)
                .addGap(28, 28, 28))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void acessoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acessoActionPerformed
        String nome = Nome.getText();
        String cognome = Cognome.getText();
        String nomeUtente = NomeUtente.getText();
        String email = Email.getText();
        String password = new String(Password.getPassword());
        if (checkData.register(nome, cognome, nomeUtente, email, password)) {
            if (isRegister(nomeUtente, password, email)) {
                checkData.alert("Ti sei registrato corettamente");
                try {
                    connection.commit();
                } catch (SQLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            checkData.alert("Dati non validi ricontrollare");
        }
    }//GEN-LAST:event_acessoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Cognome;
    private javax.swing.JTextField Email;
    private javax.swing.JTextField Nome;
    private javax.swing.JTextField NomeUtente;
    private javax.swing.JPasswordField Password;
    private javax.swing.JLabel Titolo;
    private javax.swing.JButton acesso;
    // End of variables declaration//GEN-END:variables
}
