package hospital;

import javax.swing.JOptionPane;

/**
 *
 * @author Henry Arend
 */
public class Launcher extends javax.swing.JFrame {
    private Queue priorityOneWaitingRoom = new Queue();
    private Queue priorityTwoWaitingRoom = new Queue();
    private Queue priorityThreeWaitingRoom = new Queue();
    private Queue priorityFourWaitingRoom = new Queue();
    private TreatmentRoom roomOne = new TreatmentRoom(getX() + getWidth(), getY() + getHeight());
    private TreatmentRoom roomTwo = new TreatmentRoom(getX() + getWidth(), getY() + getHeight());
    private int priorityNumber;
    /**
     * Creates new form Launcher
     */
    public Launcher() {
//        String priorityString = JOptionPane.showInputDialog(null, "Please type a number of priorities", "Priority Number", JOptionPane.QUESTION_MESSAGE);
//        priorityNumber = Integer.parseInt(priorityString);
        initComponents();
        initMisc();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        admitNew = new javax.swing.JButton();
        discharge = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 20)); // NOI18N
        jLabel1.setText("Sacred Heart Hospital");

        admitNew.setText("Admit Patient");
        admitNew.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                admitNewMouseClicked(evt);
            }
        });

        discharge.setText("Discharge Patient");
        discharge.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dischargeMouseClicked(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(87, 87, 87)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(jLabel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(admitNew, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(discharge, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(87, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel1)
                .add(18, 18, 18)
                .add(admitNew)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(discharge)
                .addContainerGap(97, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void admitNewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admitNewMouseClicked
        Admittance main = new Admittance(this);   
    }//GEN-LAST:event_admitNewMouseClicked

    private void dischargeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dischargeMouseClicked
        takePatient();
        addPatient(checkPriority());
    }//GEN-LAST:event_dischargeMouseClicked

    private Patient checkPriority(){
        if(!priorityOneWaitingRoom.isEmpty()){
            return priorityOneWaitingRoom.dequeue();
        }
        else if(!priorityTwoWaitingRoom.isEmpty()){
            return priorityTwoWaitingRoom.dequeue();
        }
        else if(!priorityThreeWaitingRoom.isEmpty()){
            return priorityThreeWaitingRoom.dequeue();
        }
        else{
            return priorityFourWaitingRoom.dequeue();
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
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
            java.util.logging.Logger.getLogger(Launcher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Launcher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Launcher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Launcher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Launcher().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton admitNew;
    private javax.swing.JButton discharge;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

    private void initMisc() {
        roomOne.setVisible(true);
        roomTwo.setVisible(true);
    }

    public void addPatient(Patient newbie) {
        if(roomOne.checkForEmptyRoom()){
            roomOne.setPatient(newbie);
        }
        else if(roomTwo.checkForEmptyRoom()){
            roomTwo.setPatient(newbie);
        }
        else{
        priorityOneWaitingRoom.enqueue(newbie);
        }
    }
    
    public void takePatient(){
        try{
        Patient temp = roomOne.removePatient();
        JOptionPane.showMessageDialog(null, "Patient Name: " + temp.getName() + "Patient ID: " + temp.getID(),"", JOptionPane.OK_OPTION);
        }
        catch(NullPointerException e){
           JOptionPane.showMessageDialog(null, "No patients in waiting room."); 
        }
    }
    
    public int getPriorityCount(){
        return priorityNumber;
    }
}
