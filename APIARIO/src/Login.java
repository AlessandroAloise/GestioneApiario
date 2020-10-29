import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alessandro Aloise
 * @version 24.09.2020
 */
public class Login extends javax.swing.JPanel {
    CheckData checkData = new CheckData();
    


    private void raiseChange() {
        PropertyChangeEvent event = new PropertyChangeEvent(this,"login",false, true);
        PropertyChangeListener[] listeners = this.getPropertyChangeListeners();
        synchronized (listeners) {
            for (PropertyChangeListener e : listeners) {
                e.propertyChange(event);
                
            }
        }
    }

/**
 * Creates new form Login
 */
public Login() {
        initComponents();
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

        Titolo.setBackground(new java.awt.Color(255, 255, 255));
        Titolo.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        Titolo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Titolo.setText("Login");
        Titolo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        User.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        User.setText("User");
        User.setToolTipText("");

        Password.setText("Password");
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
                .addGap(18, 18, 18)
                .addComponent(User, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Accedi)
                .addGap(59, 59, 59))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void AccediActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AccediActionPerformed
        String pass =new String(Password.getPassword());
        if(checkData.chekRules(User.getText(),pass )){
            raiseChange();  
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
