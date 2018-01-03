package cmmdc.client;
import cmmdc.ICmmdc; 

public class VisualCmmdcClient extends javax.swing.JFrame {
    ICmmdc obj=null; 
    
    public VisualCmmdcClient(ICmmdc obj) {
        this.obj=obj;
        initComponents();
        setVisible(true);
    }

    private void initComponents() {

        jLabelm = new javax.swing.JLabel();
        jTextFieldm = new javax.swing.JTextField();
        jLabeln = new javax.swing.JLabel();
        jTextFieldn = new javax.swing.JTextField();
        jButton = new javax.swing.JButton();
        jTextFieldrez = new javax.swing.JTextField();

        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Calcul CMMDC");

        jLabelm.setText("Primul numar");

        jTextFieldm.setText("1");

        jLabeln.setText("Al doilea numar");

        jTextFieldn.setText("1");

        jButton.setText("Calculeaza");
        jButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonMouseClicked(evt);
            }
        });

        jTextFieldrez.setEditable(false);
        jTextFieldrez.setText("1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelm)
                    .addComponent(jLabeln)
                    .addComponent(jButton))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldrez, 0, 0, Short.MAX_VALUE)
                    .addComponent(jTextFieldn)
                    .addComponent(jTextFieldm, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))
                .addContainerGap(205, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelm))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabeln)
                    .addComponent(jTextFieldn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton)
                    .addComponent(jTextFieldrez, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(170, Short.MAX_VALUE))
        );

        pack();
    }

    private void jButtonMouseClicked(java.awt.event.MouseEvent evt) {
        long m=Long.parseLong(jTextFieldm.getText());
        long n=Long.parseLong(jTextFieldn.getText());
        long r=obj.cmmdc(m,n);
        jTextFieldrez.setText(new Long(r).toString());
    }
    
    private javax.swing.JButton jButton;
    private javax.swing.JLabel jLabelm;
    private javax.swing.JLabel jLabeln;
    private javax.swing.JTextField jTextFieldm;
    private javax.swing.JTextField jTextFieldn;
    private javax.swing.JTextField jTextFieldrez; 
}
