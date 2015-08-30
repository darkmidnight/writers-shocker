package writersblock;

import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WritersBlockMotivationTool extends javax.swing.JFrame {
    private final ShockTimer tThread;
    private boolean started;
    private final WiimoteThread mjt;

    public WritersBlockMotivationTool() {
        initComponents();
        tThread = new ShockTimer();
        started = false;
        mjt = new WiimoteThread();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Writers Block Motivation Aid");
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
                formWindowLostFocus(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextArea1KeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextArea1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTextArea1);

        jLabel1.setText("Charge");

        jLabel2.setText("The timer starts when you first start typing");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 745, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextArea1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea1KeyTyped
        if (!started) {
            started = true;
            tThread.start();
            consoleOut("Starting timer");
        }
        getKeyEventName(evt);
    }//GEN-LAST:event_jTextArea1KeyTyped

    private void jTextArea1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea1KeyPressed
        if (started) {
            getKeyEventName(evt);
        }
    }//GEN-LAST:event_jTextArea1KeyPressed

    private void formWindowLostFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowLostFocus
        tThread.increaseTimer();
    }//GEN-LAST:event_formWindowLostFocus

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WritersBlockMotivationTool.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new WritersBlockMotivationTool().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
    public void getKeyEventName(KeyEvent evt) {
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_BACK_SPACE: tThread.increaseTimer();return;
            case KeyEvent.VK_DELETE: tThread.increaseTimer();return;
        }
        if (!ignoreKey(evt)) {
            tThread.setLKP();
        }
    }
    /**
     * These keys will not count as typing (control keys, etc)
     * @param evt
     * @return
     */
    public boolean ignoreKey(KeyEvent evt) {
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_F1: return true;
            case KeyEvent.VK_F10: return true;
            case KeyEvent.VK_F11: return true;
            case KeyEvent.VK_F12: return true;
            case KeyEvent.VK_F13: return true;
            case KeyEvent.VK_F14: return true;
            case KeyEvent.VK_F15: return true;
            case KeyEvent.VK_F16: return true;
            case KeyEvent.VK_F17: return true;
            case KeyEvent.VK_F18: return true;
            case KeyEvent.VK_F19: return true;
            case KeyEvent.VK_F2: return true;
            case KeyEvent.VK_F20: return true;
            case KeyEvent.VK_F21: return true;
            case KeyEvent.VK_F22: return true;
            case KeyEvent.VK_F23: return true;
            case KeyEvent.VK_F24: return true;
            case KeyEvent.VK_F3: return true;
            case KeyEvent.VK_F4: return true;
            case KeyEvent.VK_F5: return true;
            case KeyEvent.VK_F6: return true;
            case KeyEvent.VK_F7: return true;
            case KeyEvent.VK_F8: return true;
            case KeyEvent.VK_F9: return true;
        }
        return false;
    }

    /**
     * Update the progress bar
     */
    public void updateUI() {
        jProgressBar1.setValue(tThread.getTimerChunks());
    }
    
    private void consoleOut(String text) {
        jLabel2.setText(text);
    }
    
    class ShockTimer extends Thread {
        private long lastKeyPressed;
        private int timerChunks = 0;
        private final int chunksTilShock = 100;
        private final int requiredWait = 500;

        public ShockTimer() { }

        @Override
        public void run() {
            setLKP();
            while (true) {
                if ((System.currentTimeMillis() - lastKeyPressed) > requiredWait) {
                    increaseTimer();
                } else {
                    decreaseTimer();
                }
                try {
                    Thread.sleep(1000); // Change this value to speed up the timer
                } catch (InterruptedException ex) {
                    Logger.getLogger(WritersBlockMotivationTool.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        private synchronized void decreaseTimer() {
            timerChunks -= 2;
            if (timerChunks < 0 ) { timerChunks = 0; }
            updateUI();
        }

        private synchronized void increaseTimer() {
            timerChunks += 10;
            if (timerChunks >= chunksTilShock) {
                administerShock();
                timerChunks = 0;
            }
            updateUI();
        }

        private synchronized void setLKP() {
            lastKeyPressed = System.currentTimeMillis();
        }

        private void administerShock() {
            mjt.buzz();
        }

        private synchronized int getTimerChunks() {
            return timerChunks;
        }
    }
}
