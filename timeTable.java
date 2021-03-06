
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aqleema
 */
public class timeTable extends javax.swing.JFrame {

    Connection con;
    Statement sp;
    ResultSet rs;
    public String dData;
    public String aData;
    public Date d;
    /**
     * Creates new form timeTable
     */
    public timeTable() {
        initComponents();
        try{
        establishConnection();
        }catch(Exception e){
            System.out.println(e);
        }
        setDdata();
        setAdata();
      //  getdData();
    }
    public void establishConnection()
             throws ClassNotFoundException, SQLException
    {
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/flight_management?zeroDateTimeBehavior=convertToNull", "root","");
        sp=(Statement) con.createStatement();
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        dCombo = new javax.swing.JComboBox();
        aCombo = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        dateChooser = new com.toedter.calendar.JDateChooser();
        proceed_btn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Lucida Bright", 0, 18)); // NOI18N
        jLabel1.setText("Arrival airport- city");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 380, 174, 22);

        getContentPane().add(dCombo);
        dCombo.setBounds(250, 290, 186, 30);

        getContentPane().add(aCombo);
        aCombo.setBounds(250, 370, 186, 29);

        jLabel2.setFont(new java.awt.Font("Lucida Bright", 0, 18)); // NOI18N
        jLabel2.setText("Departure date");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 430, 180, 29);
        getContentPane().add(dateChooser);
        dateChooser.setBounds(250, 430, 180, 30);

        proceed_btn.setBackground(new java.awt.Color(204, 255, 0));
        proceed_btn.setFont(new java.awt.Font("Lucida Bright", 0, 18)); // NOI18N
        proceed_btn.setText("Proceed");
        proceed_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proceed_btnActionPerformed(evt);
            }
        });
        getContentPane().add(proceed_btn);
        proceed_btn.setBounds(290, 480, 101, 31);

        jLabel4.setFont(new java.awt.Font("Lucida Bright", 0, 18)); // NOI18N
        jLabel4.setText("Departure airport- city");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(20, 290, 210, 30);
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 690, 530);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void proceed_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proceed_btnActionPerformed
        // TODO add your handling code here:
        dData=(String) dCombo.getSelectedItem();
        aData=(String) aCombo.getSelectedItem();
        d= dateChooser.getDate();
        flightSchedule f=new flightSchedule(this);
       
        f.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_proceed_btnActionPerformed
    public void setDate(){
        Date d=new Date();
        SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd");
       // dDate.setText(s.format(d));
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(timeTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(timeTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(timeTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(timeTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new timeTable().setVisible(true);
            }
        });
    }
    public void setDdata()
    {
         try{
            String query="select * from flights";
            rs=sp.executeQuery(query);
            while(rs.next())
            {
                String departure=rs.getString("departure");
                
                System.out.println(departure);
                dCombo.addItem(departure);
            }
        }catch(Exception exp){
            System.out.println(exp);
        }
       
    }
    public void setAdata(){
        try{
            String query="select * from flights";
            rs=sp.executeQuery(query);
            while(rs.next())
            {
                String arrival=rs.getString("arrival");
                
                System.out.println(arrival);
                aCombo.addItem(arrival);
            }
        }catch(Exception exp){
            System.out.println(exp);
        }
      
    }
    public String getdData(){
        String r= (String) dCombo.getSelectedItem();
        System.out.println(r);
        return r;
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox aCombo;
    private javax.swing.JComboBox dCombo;
    private com.toedter.calendar.JDateChooser dateChooser;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton proceed_btn;
    // End of variables declaration//GEN-END:variables
}
