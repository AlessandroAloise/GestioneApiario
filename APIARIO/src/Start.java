
import java.awt.event.ActionListener;

/**
 * Panel che si occupa della home.
 *
 * @author Alessandro Aloise
 * @version 24.09.2020
 */
public class Start extends javax.swing.JPanel {
    
    CheckData checkData= new CheckData();
    
    public void addButton1ActionListener(ActionListener listener) {
        LoginB.addActionListener(listener);
        Register.addActionListener(listener);
    }
    
    /**
     * Creates new form Home
     */
    public Start() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Titolo = new javax.swing.JLabel();
        LoginB = new javax.swing.JButton();
        Register = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(100, 100));

        Titolo.setBackground(new java.awt.Color(255, 255, 255));
        Titolo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Titolo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Titolo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/ape16.png"))); // NOI18N
        Titolo.setLabelFor(Titolo);
        Titolo.setText("APIARIO");

        LoginB.setBackground(new java.awt.Color(0, 0, 0));
        LoginB.setForeground(new java.awt.Color(255, 255, 255));
        LoginB.setText("Login");
        LoginB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LoginBMouseClicked(evt);
            }
        });
        LoginB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginBActionPerformed(evt);
            }
        });

        Register.setBackground(new java.awt.Color(0, 0, 0));
        Register.setForeground(new java.awt.Color(255, 255, 255));
        Register.setText("Registarti");
        Register.setMinimumSize(new java.awt.Dimension(100, 100));
        Register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Titolo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Register, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                    .addComponent(LoginB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(101, 101, 101))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(Titolo)
                .addGap(18, 18, 18)
                .addComponent(LoginB)
                .addGap(33, 33, 33)
                .addComponent(Register, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(106, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void LoginBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginBMouseClicked
    }//GEN-LAST:event_LoginBMouseClicked

    private void LoginBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginBActionPerformed

                 
        
         /*
        try {
            URL url = new URL("https://www.google.ch/?hl=it");

            URLConnection connection = url.openConnection();
            connection.connect();

            System.out.println("Internet Conesso");

        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Erorr");
        }*/
    }//GEN-LAST:event_LoginBActionPerformed

    private void RegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterActionPerformed
    }//GEN-LAST:event_RegisterActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LoginB;
    private javax.swing.JButton Register;
    private javax.swing.JLabel Titolo;
    // End of variables declaration//GEN-END:variables
}
