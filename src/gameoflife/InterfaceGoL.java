/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Mateusz
 */
public class InterfaceGoL extends javax.swing.JFrame {
    public static final Object lock = new Object();
    private boolean isRunning;
    private StructureGoL playground;
    private int amountOfRows, amountInRow; 
    private double timeBeetweenStages;
    private ArrayList<ArrayList<JLabel>> spaceToPlay;

    /**
     * Creates new form InterfaceGoL
     */
    public InterfaceGoL() {
        initComponents();
        createView();
        isRunning = false;
    }
    public void close()
    {
        dispose();
    }
    
    public void createView()
    {

        try{
            amountOfRows = Integer.parseInt(txtFldWidth.getText());
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "There is no number in \"width\" field", "Error", JOptionPane.ERROR_MESSAGE);
        }
        try{
            amountInRow = Integer.parseInt(txtFldHeight.getText());
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "There is no number in \"height\" field", "Error", JOptionPane.ERROR_MESSAGE);
        }
        try{
            timeBeetweenStages = Double.parseDouble(txtFldTime.getText());
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "There is no number in \"Time for Stage\" field", "Error", JOptionPane.ERROR_MESSAGE);
        }
        spaceToPlay = new ArrayList();
        for(int i = 0; i < amountOfRows; i++)
        {
            spaceToPlay.add(new ArrayList());
        }
        playground = new StructureGoL(amountOfRows,amountInRow);
        int widthOfElement = panelPlayground.getWidth()/amountOfRows;
        int heightOfElement = panelPlayground.getHeight()/amountInRow;
        for(int rows = 0; rows < amountOfRows; rows++)
        {
            for(int cells = 0; cells < amountInRow; cells++)
            {
                
                JLabel newlyAdded = new JLabel();
                newlyAdded.setBounds(rows*widthOfElement,cells*heightOfElement,widthOfElement-1,heightOfElement-1);
                newlyAdded.addMouseListener(new MouseClicker(rows, cells, playground));
                newlyAdded.setBackground(Color.BLACK);
                newlyAdded.setOpaque(true);
                spaceToPlay.get(rows).add(newlyAdded);
                panelPlayground.add(newlyAdded);
                
            }
        }
        jScrollPane1.revalidate();
        jScrollPane1.repaint();
        
        this.revalidate();
        this.repaint();
        
    }
    public void clear()
    {
        panelPlayground.removeAll();
    }
    
    
    
    public void nextStage()
    {
        playground.nextLivingStage();
        recolor();
    }
    public void recolor()
    {
        boolean[][] board = playground.getBoard();
        for(int row = 0; row < board.length; row++)
        {
            for(int cell = 0; cell < board[row].length; cell++ )
            {
                if(board[row][cell])
                {
                    spaceToPlay.get(row).get(cell).setBackground(Color.WHITE);
                }else
                    spaceToPlay.get(row).get(cell).setBackground(Color.BLACK);
            }
        }
    }
    
    public boolean isRunning()
    {
        return isRunning;
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        txtFldWidth = new javax.swing.JTextField();
        txtFldHeight = new javax.swing.JTextField();
        buttonExit = new javax.swing.JButton();
        buttonReset = new javax.swing.JButton();
        jLabelWidtht = new javax.swing.JLabel();
        jLabelHeight = new javax.swing.JLabel();
        txtFldTime = new javax.swing.JTextField();
        jLabelTime = new javax.swing.JLabel();
        jLabelSeconds = new javax.swing.JLabel();
        buttonStarPause = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        panelPlayground = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        Save = new javax.swing.JMenuItem();
        SaveAs = new javax.swing.JMenuItem();
        LoadFile = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtFldWidth.setText("20");
        txtFldWidth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFldWidthActionPerformed(evt);
            }
        });

        txtFldHeight.setText("20");

        buttonExit.setText("Exit");
        buttonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExitActionPerformed(evt);
            }
        });

        buttonReset.setText("Reset");
        buttonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonResetActionPerformed(evt);
            }
        });

        jLabelWidtht.setText("Widtht");

        jLabelHeight.setText("Height");

        txtFldTime.setText("2");
        txtFldTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFldTimeActionPerformed(evt);
            }
        });

        jLabelTime.setText("Time for stage");

        jLabelSeconds.setText("sec.");

        buttonStarPause.setText("Start");
        buttonStarPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonStarPauseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelPlaygroundLayout = new javax.swing.GroupLayout(panelPlayground);
        panelPlayground.setLayout(panelPlaygroundLayout);
        panelPlaygroundLayout.setHorizontalGroup(
            panelPlaygroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 336, Short.MAX_VALUE)
        );
        panelPlaygroundLayout.setVerticalGroup(
            panelPlaygroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 282, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(panelPlayground);

        jMenu1.setText("File");

        Save.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        Save.setText("Save");
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });
        jMenu1.add(Save);

        SaveAs.setText("Save as");
        jMenu1.add(SaveAs);

        LoadFile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        LoadFile.setText("Load File");
        LoadFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoadFileActionPerformed(evt);
            }
        });
        jMenu1.add(LoadFile);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(buttonExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonStarPause, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabelTime, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabelHeight, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(txtFldTime, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabelSeconds)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabelWidtht)
                                .addGap(27, 27, 27))
                            .addComponent(txtFldWidth, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtFldHeight, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabelWidtht)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtFldWidth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(jLabelHeight)
                        .addGap(2, 2, 2)
                        .addComponent(txtFldHeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(jLabelTime, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFldTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelSeconds))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                        .addComponent(buttonStarPause)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonReset)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonExit))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFldTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFldTimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFldTimeActionPerformed

    private void txtFldWidthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFldWidthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFldWidthActionPerformed

    private void buttonStarPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonStarPauseActionPerformed
        synchronized(lock){// TODO add your handling code here:
            if (isRunning)
            {
                isRunning = false;
                buttonStarPause.setText("Start");
            }else{
                isRunning = true;
                buttonStarPause.setText("Pause");
            }
            lock.notify();
        }
    }//GEN-LAST:event_buttonStarPauseActionPerformed

    private void buttonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonResetActionPerformed
        synchronized(lock){// TODO add your handling code here:
            clear();
            createView();
            lock.notify();
        }
    }//GEN-LAST:event_buttonResetActionPerformed

    private void buttonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExitActionPerformed
        // TODO add your handling code here:
        close();
    }//GEN-LAST:event_buttonExitActionPerformed

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
        JFileChooser chooseFile = new JFileChooser();
        if(chooseFile.showSaveDialog(this) == JFileChooser.APPROVE_OPTION)
        {
            FileService.writeToMyFile(playground, chooseFile.getSelectedFile());
        }
    }//GEN-LAST:event_SaveActionPerformed

    private void LoadFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoadFileActionPerformed
        JFileChooser chooseFile = new JFileChooser();
        if(chooseFile.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)
        {
            try {
                StructureGoL board = new StructureGoL(FileService.loadFromFile(chooseFile.getSelectedFile()));
                txtFldWidth.setText(Integer.toString(board.getWidth()));
                txtFldHeight.setText(Integer.toString(board.getHeight()));
                clear();
                createView();
                playground = board;
                recolor();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Trouble with reading file, please try again");
            }
        }
    }//GEN-LAST:event_LoadFileActionPerformed
    public double timeBeetweenStages()
    {
        return timeBeetweenStages;
    }
    /**
     * @param args the command line arguments
     */
    public static synchronized void main(String args[]) {
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
            java.util.logging.Logger.getLogger(InterfaceGoL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceGoL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceGoL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceGoL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        final InterfaceGoL mine = new InterfaceGoL();
        mine.setVisible(true);
                
        /* Create and display the form */
 
                        
        Thread thd = new Thread() {
        public void run() {
            while(true)
                {
                    if(mine.isRunning)
                    {
                    
                            try {
                                synchronized(lock){
                                    sleep((long)(mine.timeBeetweenStages()*1000));
                                }

                                mine.nextStage();

                            }catch (InterruptedException ex) {
                                Logger.getLogger(InterfaceGoL.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        
                    }else{
                    
                            try {
                                synchronized(lock){
                                    lock.wait();
                                }

                            } catch (InterruptedException ex) {
                                Logger.getLogger(InterfaceGoL.class.getName()).log(Level.SEVERE, null, ex);
                            }                    
                    }
                }
            }
        };
        thd.run();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem LoadFile;
    private javax.swing.JMenuItem Save;
    private javax.swing.JMenuItem SaveAs;
    private javax.swing.JButton buttonExit;
    private javax.swing.JButton buttonReset;
    private javax.swing.JButton buttonStarPause;
    private javax.swing.JLabel jLabelHeight;
    private javax.swing.JLabel jLabelSeconds;
    private javax.swing.JLabel jLabelTime;
    private javax.swing.JLabel jLabelWidtht;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelPlayground;
    private javax.swing.JTextField txtFldHeight;
    private javax.swing.JTextField txtFldTime;
    private javax.swing.JTextField txtFldWidth;
    // End of variables declaration//GEN-END:variables
}
