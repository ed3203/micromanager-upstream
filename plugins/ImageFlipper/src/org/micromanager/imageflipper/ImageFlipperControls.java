
/*
 * ImageFlipperControls.java
 *
 * Created on Feb 18, 2011, 9:57:34 PM
 */

package org.micromanager.imageflipper;

import ij.process.ByteProcessor;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import mmcorej.StrVector;
import mmcorej.TaggedImage;
import org.micromanager.MMStudioMainFrame;
import org.micromanager.api.DataProcessor;

/**
 *
 * @author arthur
 */
public class ImageFlipperControls extends javax.swing.JFrame {
   private final ImageFlippingProcessor processor_;
   private String selectedCamera_;

    /** Creates new form ImageFlipperControls */
    public ImageFlipperControls() {

      initComponents();
      updateCameras();
      setBackground(MMStudioMainFrame.getInstance().getBackgroundColor());
      MMStudioMainFrame.getInstance().addMMBackgroundListener(this);
      processor_ = new ImageFlippingProcessor(this);
   }

    public DataProcessor<TaggedImage> getProcessor() {
       return processor_;
    }
    
    final public void updateCameras() {
      selectedCamera_ = MMStudioMainFrame.getInstance().getCore().getCameraDevice();
      cameraComboBox_.removeAllItems();
      try {
         StrVector cameras = MMStudioMainFrame.getInstance().getCore().getAllowedPropertyValues("Core", "Camera");
         Iterator it = cameras.iterator();
         while (it.hasNext()) {
            cameraComboBox_.addItem((String) it.next());
         }
      } catch (Exception ex) {
         Logger.getLogger(ImageFlipperControls.class.getName()).log(Level.SEVERE, null, ex);
      }
      cameraComboBox_.setSelectedItem(selectedCamera_);
   }

   /** This method is called from within the constructor to
    * initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mirrorCheckBox_ = new javax.swing.JCheckBox();
        exampleImageSource_ = new javax.swing.JLabel();
        exampleImageTarget_ = new javax.swing.JLabel();
        cameraComboBox_ = new javax.swing.JComboBox();
        rotateComboBox_ = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Image Flipper");
        setBounds(new java.awt.Rectangle(300, 300, 150, 150));
        setMinimumSize(new java.awt.Dimension(200, 200));
        setResizable(false);

        mirrorCheckBox_.setText("Mirror");
        mirrorCheckBox_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mirrorCheckBox_ActionPerformed(evt);
            }
        });

        exampleImageSource_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/micromanager/icons/C.png"))); // NOI18N
        exampleImageSource_.setMaximumSize(new java.awt.Dimension(52, 52));
        exampleImageSource_.setMinimumSize(new java.awt.Dimension(52, 52));
        exampleImageSource_.setPreferredSize(new java.awt.Dimension(52, 52));

        exampleImageTarget_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/micromanager/icons/C.png"))); // NOI18N
        exampleImageTarget_.setMaximumSize(new java.awt.Dimension(52, 52));
        exampleImageTarget_.setMinimumSize(new java.awt.Dimension(52, 52));
        exampleImageTarget_.setPreferredSize(new java.awt.Dimension(52, 52));

        rotateComboBox_.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0˚", "90˚", "180˚", "270˚" }));
        rotateComboBox_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rotateComboBox_ActionPerformed(evt);
            }
        });

        jLabel1.setText("Rotate");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, cameraComboBox_, 0, 147, Short.MAX_VALUE)
                            .add(layout.createSequentialGroup()
                                .add(exampleImageSource_, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                                .add(18, 18, 18)
                                .add(exampleImageTarget_, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 65, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(layout.createSequentialGroup()
                                .add(jLabel1)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(rotateComboBox_, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                        .add(38, 38, 38))
                    .add(layout.createSequentialGroup()
                        .add(mirrorCheckBox_)
                        .addContainerGap(115, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(11, 11, 11)
                .add(cameraComboBox_, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(exampleImageTarget_, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                    .add(exampleImageSource_, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(mirrorCheckBox_)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(rotateComboBox_, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel1))
                .add(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mirrorCheckBox_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mirrorCheckBox_ActionPerformed
       processExample();
    }//GEN-LAST:event_mirrorCheckBox_ActionPerformed

   private void rotateComboBox_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rotateComboBox_ActionPerformed
      processExample();
   }//GEN-LAST:event_rotateComboBox_ActionPerformed


    
    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ImageFlipperControls().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cameraComboBox_;
    private javax.swing.JLabel exampleImageSource_;
    private javax.swing.JLabel exampleImageTarget_;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JCheckBox mirrorCheckBox_;
    private javax.swing.JComboBox rotateComboBox_;
    // End of variables declaration//GEN-END:variables

   public boolean getMirror() {
      return mirrorCheckBox_.isSelected();
   }

   /**
    * Indicates users choice for rotation:
    * 0 - 0 degrees
    * 1 - 90 degrees
    * 2 - 180 degrees
    * 3 - 270 degrees
    * degrees are anti-clockwise
    * 
    * @return coded rotation
    */
   public int getRotate() {
      if ("90˚".equals((String) rotateComboBox_.getSelectedItem()))
         return 1;
      if ("180˚".equals((String) rotateComboBox_.getSelectedItem()))
         return 2;
      if ("270˚".equals((String) rotateComboBox_.getSelectedItem()))
         return 3;
      return 0;
   }
   
   public String getCamera() {
      return (String) cameraComboBox_.getSelectedItem();
   }
   
   private void processExample() {
      ImageIcon exampleIcon = (ImageIcon) exampleImageSource_.getIcon();

      ByteProcessor proc = new ByteProcessor(exampleIcon.getImage());
      
      if (getMirror()) {
         proc.flipHorizontal();
      }
      if (getRotate() == 1) {
         proc = (ByteProcessor) proc.rotateRight();
      }
      if (getRotate() == 2) {
         proc.rotate(180);
      }
      if (getRotate() == 3) {
         proc = (ByteProcessor) proc.rotateLeft();
      }
      
      exampleImageTarget_.setIcon(new ImageIcon(proc.createImage()));
   }
}
