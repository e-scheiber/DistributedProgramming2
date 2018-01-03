package cmmdcclient;
import cmmdc.ICmmdc;
import java.io.*;

public class VisualCmmdcClient extends javax.swing.JFrame {
  private ICmmdc cmmdc;  
  
    public VisualCmmdcClient(ICmmdc cmmdc) {
      this.cmmdc=cmmdc;
        initComponents();
    }
    
    private void initComponents() {
        jLabelm = new javax.swing.JLabel();
        jTextFieldm = new javax.swing.JTextField();
        jLabeln = new javax.swing.JLabel();
        jTextFieldn = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jTextFieldrez = new javax.swing.JTextField();

        getContentPane().setLayout(new java.awt.GridLayout(3, 2));

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        jLabelm.setText("Primul numar:");
        getContentPane().add(jLabelm);

        jTextFieldm.setText("1");
        getContentPane().add(jTextFieldm);

        jLabeln.setText("Al doilea numar:");
        getContentPane().add(jLabeln);

        jTextFieldn.setText("1");
        getContentPane().add(jTextFieldn);

        jButton1.setText("Calculeaza:");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        getContentPane().add(jButton1);

        jTextFieldrez.setText("1");
        getContentPane().add(jTextFieldrez);

        pack();
    }

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {
        // Add your handling code here:
        long m=Long.parseLong(jTextFieldm.getText());
        long n=Long.parseLong(jTextFieldn.getText());
        long r=cmmdc.cmmdc(m,n);
        jTextFieldrez.setText(new Long(r).toString());
    }
    
    private void exitForm(java.awt.event.WindowEvent evt) {
        //System.exit(0);
        setVisible(false);
    }
    
    /*
    public static void main(String args[]) {
        new VisualCmmdcClient().setVisible(true);
    }
    */
    
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabelm;
    private javax.swing.JLabel jLabeln;
    private javax.swing.JTextField jTextFieldm;
    private javax.swing.JTextField jTextFieldn;
    private javax.swing.JTextField jTextFieldrez;
}
