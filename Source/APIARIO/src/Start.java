
import java.awt.event.ActionListener;

/**
 * Panel che si occupa della home.
 *
 * @author Alessandro Aloise
 * @version 24.09.2020
 */
public class Start extends javax.swing.JPanel {

    CheckData checkData = new CheckData();

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


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Titolo = new javax.swing.JLabel();
        LoginB = new javax.swing.JButton();
        Register = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(100, 100));
        setPreferredSize(new java.awt.Dimension(550, 350));

        Titolo.setBackground(new java.awt.Color(255, 255, 255));
        Titolo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Titolo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Titolo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/ape16.png"))); // NOI18N
        Titolo.setLabelFor(Titolo);
        Titolo.setText("APIARIO");

        LoginB.setBackground(new java.awt.Color(0, 0, 0));
        LoginB.setForeground(new java.awt.Color(255, 255, 255));
        LoginB.setText("Login");

        Register.setBackground(new java.awt.Color(0, 0, 0));
        Register.setForeground(new java.awt.Color(255, 255, 255));
        Register.setText("Registarti");
        Register.setMinimumSize(new java.awt.Dimension(100, 100));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Titolo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LoginB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Register, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(Titolo)
                .addGap(64, 64, 64)
                .addComponent(LoginB)
                .addGap(33, 33, 33)
                .addComponent(Register, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(105, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LoginB;
    private javax.swing.JButton Register;
    private javax.swing.JLabel Titolo;
    // End of variables declaration//GEN-END:variables
}
