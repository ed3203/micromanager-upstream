/*
 * MathForm.java
 *
 * Created on Mar 20, 2012, 2:14:26 PM
 */
package edu.valelab.GaussianFit;

import edu.valelab.GaussianFit.utils.RowData;
import java.util.prefs.Preferences;

/**
 *
 * @author nico
 */
public class MathForm extends javax.swing.JFrame {
   private Preferences prefs_;
   private static final String FRAMEXPOS = "MathXPos";
   private static final String FRAMEYPOS = "MathYPos";
   private final String SELECTED = "Selected";

   /** Creates new form MathForm */
   public MathForm(int[] dataSets1, int[] dataSets2) {
      initComponents();
      
      if (prefs_ == null)
        prefs_ = Preferences.userNodeForPackage(this.getClass());
      setLocation(prefs_.getInt(FRAMEXPOS, 50), prefs_.getInt(FRAMEYPOS, 100));
       
      
      dataSet1ComboBox_.removeAllItems(); 
      
      dataSet1ComboBox_.addItem(SELECTED);
      for (int i : dataSets1)
         dataSet1ComboBox_.addItem(i);
      dataSet2ComboBox_.removeAllItems();
      for (int i : dataSets2)
         dataSet2ComboBox_.addItem(i);
      
      dataSet1ComboBox_.updateUI();
      

   }

   /** This method is called from within the constructor to
    * initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is
    * always regenerated by the Form Editor.
    */
   @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dataSet1ComboBox_ = new javax.swing.JComboBox();
        actionComboBox_ = new javax.swing.JComboBox();
        dataSet2ComboBox_ = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        okButton_ = new javax.swing.JButton();
        cancelButton_ = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Track Math");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        dataSet1ComboBox_.setFont(new java.awt.Font("Lucida Grande", 0, 11));
        dataSet1ComboBox_.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        dataSet1ComboBox_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataSet1ComboBox_ActionPerformed(evt);
            }
        });

        actionComboBox_.setFont(new java.awt.Font("Lucida Grande", 0, 11));
        actionComboBox_.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Subtract" }));

        dataSet2ComboBox_.setFont(new java.awt.Font("Lucida Grande", 0, 11));
        dataSet2ComboBox_.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 11));
        jLabel1.setText("DataSet 1");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 11));
        jLabel2.setText("Action");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 11));
        jLabel3.setText("DataSet 2");

        okButton_.setFont(new java.awt.Font("Lucida Grande", 0, 11));
        okButton_.setText("Do it");
        okButton_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButton_ActionPerformed(evt);
            }
        });

        cancelButton_.setFont(new java.awt.Font("Lucida Grande", 0, 11));
        cancelButton_.setText("Close");
        cancelButton_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButton_ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 89, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 23, Short.MAX_VALUE)
                        .add(dataSet1ComboBox_, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 141, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(jLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 89, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 23, Short.MAX_VALUE)
                        .add(actionComboBox_, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 141, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .add(jLabel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 89, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 23, Short.MAX_VALUE)
                        .add(dataSet2ComboBox_, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 141, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .add(12, 12, 12)
                        .add(okButton_, 0, 0, Short.MAX_VALUE)
                        .add(43, 43, 43)
                        .add(cancelButton_, 0, 0, Short.MAX_VALUE)
                        .add(17, 17, 17)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(dataSet1ComboBox_, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel1))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(actionComboBox_, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel2))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(dataSet2ComboBox_, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel3))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(okButton_, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 19, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(cancelButton_, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 19, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   private void cancelButton_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButton_ActionPerformed
      formWindowClosing(null);
      dispose();
   }//GEN-LAST:event_cancelButton_ActionPerformed

   private void okButton_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButton_ActionPerformed

      boolean usr = false;
      int i1 = 0;
      int i2 = 0;
      try {
         if (SELECTED.equals((String) dataSet1ComboBox_.getSelectedItem())) {
            usr = true;
         }
      } catch (java.lang.ClassCastException cce) {

         i1 = (Integer) dataSet1ComboBox_.getSelectedItem();
         
      }
      i2 = (Integer) dataSet2ComboBox_.getSelectedItem();
      final int id1 = i1;
      final int id2 = i2;
      final boolean useSelectedRows = usr;

      Runnable doWorkRunnable = new Runnable() {

         @Override
         public void run() {
            DataCollectionForm df = DataCollectionForm.getInstance();
            RowData rd1 = null;
            RowData rd2 = null;
            
            if (!useSelectedRows) {
               for (int i = 0; i < df.rowData_.size(); i++) {
                  if (id1 == df.rowData_.get(i).ID_) {
                     rd1 = df.rowData_.get(i);
                  }
                  if (id2 == df.rowData_.get(i).ID_) {
                     rd2 = df.rowData_.get(i);
                  }
               }
               df.doMathOnRows(rd1, rd2, 0);
            } else {
               for (int i = 0; i < df.rowData_.size(); i++) {
                  if (id2 == df.rowData_.get(i).ID_) {
                     rd2 = df.rowData_.get(i);
                  }
               }
            }
               int rows[] = df.getResultsTable().getSelectedRows();
               if (rows.length > 0) {
                  for (int i = 0; i < rows.length; i++) {
                     df.doMathOnRows(df.rowData_.get(rows[i]), rd2, 0);
                  }
               }
      
               
         }
      };
      
      (new Thread(doWorkRunnable)).start();
                  
   }//GEN-LAST:event_okButton_ActionPerformed

   private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
      prefs_.putInt(FRAMEXPOS, getX());
      prefs_.putInt(FRAMEYPOS, getY());
   }//GEN-LAST:event_formWindowClosing

   private void dataSet1ComboBox_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataSet1ComboBox_ActionPerformed
      // TODO add your handling code here:
   }//GEN-LAST:event_dataSet1ComboBox_ActionPerformed

   
   
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox actionComboBox_;
    private javax.swing.JButton cancelButton_;
    private javax.swing.JComboBox dataSet1ComboBox_;
    private javax.swing.JComboBox dataSet2ComboBox_;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton okButton_;
    // End of variables declaration//GEN-END:variables
}
