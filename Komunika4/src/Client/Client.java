/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import Packets.*;
import java.awt.CardLayout;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;
import javax.swing.JOptionPane;

/**
 *
 * @author khali
 */
public class Client extends javax.swing.JFrame implements Runnable {

    /**
     * Creates new form Client
     */
    private String username;
    private String host;
    private int port;
    private Socket socket;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    private boolean running = false;
    private boolean audio = false;
    private boolean video = false;
    private EventListener listener;
    CardLayout mainLayout, secondaryLayout;
    TargetDataLine line;
    ArrayList<String> users;
    
    public Client() {
        initComponents();
        mainLayout = (CardLayout) parent.getLayout();
        secondaryLayout = (CardLayout) parent2.getLayout();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        parent = new javax.swing.JPanel();
        menu = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        Join = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        usernameTField = new javax.swing.JTextField();
        room = new javax.swing.JPanel();
        parent2 = new javax.swing.JPanel();
        chat = new javax.swing.JPanel();
        chatTField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        participants = new javax.swing.JPanel();
        options = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        People = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        Chat = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        Leave = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        chatTArea = new javax.swing.JTextArea();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Komunika");

        parent.setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(56, 182, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/SNJclips Logotipos (100 x 70 px) (100 x 60 px) (80 x 60 px) (260 x 180 px).png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, 270, 162));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 270, 300, 10));

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Join.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Join.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Join.setText("Join");
        Join.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JoinMouseClicked(evt);
            }
        });
        jPanel2.add(Join, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 290, 300, 40));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Enter your username please");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 190, 240, 38));

        usernameTField.setBackground(new java.awt.Color(255, 230, 255));
        usernameTField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        usernameTField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameTFieldActionPerformed(evt);
            }
        });
        jPanel1.add(usernameTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 230, 300, 40));

        javax.swing.GroupLayout menuLayout = new javax.swing.GroupLayout(menu);
        menu.setLayout(menuLayout);
        menuLayout.setHorizontalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 722, Short.MAX_VALUE)
        );
        menuLayout.setVerticalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
        );

        parent.add(menu, "card2");

        room.setBackground(new java.awt.Color(102, 153, 255));

        parent2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        parent2.setLayout(new java.awt.CardLayout());

        chat.setBackground(new java.awt.Color(51, 182, 255));

        chatTField.setBackground(new java.awt.Color(204, 204, 204));
        chatTField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                chatTFieldKeyPressed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/SNJclips Logotipos (100 x 70 px) (100 x 60 px) (80 x 60 px) (260 x 180 px).png"))); // NOI18N

        javax.swing.GroupLayout chatLayout = new javax.swing.GroupLayout(chat);
        chat.setLayout(chatLayout);
        chatLayout.setHorizontalGroup(
            chatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(chatTField)
            .addGroup(chatLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        chatLayout.setVerticalGroup(
            chatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, chatLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(chatTField, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92))
        );

        parent2.add(chat, "card2");

        javax.swing.GroupLayout participantsLayout = new javax.swing.GroupLayout(participants);
        participants.setLayout(participantsLayout);
        participantsLayout.setHorizontalGroup(
            participantsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 247, Short.MAX_VALUE)
        );
        participantsLayout.setVerticalGroup(
            participantsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 415, Short.MAX_VALUE)
        );

        parent2.add(participants, "card3");

        options.setBackground(new java.awt.Color(37, 127, 186));
        options.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        options.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/logo (40 x 40 px).png"))); // NOI18N
        options.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        People.setBackground(new java.awt.Color(47, 161, 237));
        People.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PeopleMouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel9.setText("People");

        javax.swing.GroupLayout PeopleLayout = new javax.swing.GroupLayout(People);
        People.setLayout(PeopleLayout);
        PeopleLayout.setHorizontalGroup(
            PeopleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PeopleLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel9)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        PeopleLayout.setVerticalGroup(
            PeopleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PeopleLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        options.add(People, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 80, 40));

        Chat.setBackground(new java.awt.Color(47, 161, 237));
        Chat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ChatMouseClicked(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel10.setText("Chat");

        javax.swing.GroupLayout ChatLayout = new javax.swing.GroupLayout(Chat);
        Chat.setLayout(ChatLayout);
        ChatLayout.setHorizontalGroup(
            ChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ChatLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel10)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        ChatLayout.setVerticalGroup(
            ChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ChatLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        options.add(Chat, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 80, 40));

        Leave.setBackground(new java.awt.Color(47, 161, 237));
        Leave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LeaveMouseClicked(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel11.setText("Leave");

        javax.swing.GroupLayout LeaveLayout = new javax.swing.GroupLayout(Leave);
        Leave.setLayout(LeaveLayout);
        LeaveLayout.setHorizontalGroup(
            LeaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeaveLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel11)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        LeaveLayout.setVerticalGroup(
            LeaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeaveLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        options.add(Leave, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 80, 40));

        chatTArea.setBackground(new java.awt.Color(204, 204, 204));
        chatTArea.setColumns(20);
        chatTArea.setRows(5);
        jScrollPane1.setViewportView(chatTArea);

        javax.swing.GroupLayout roomLayout = new javax.swing.GroupLayout(room);
        room.setLayout(roomLayout);
        roomLayout.setHorizontalGroup(
            roomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roomLayout.createSequentialGroup()
                .addGroup(roomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(options, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(parent2, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        roomLayout.setVerticalGroup(
            roomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(parent2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(roomLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(options, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        parent.add(room, "card3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(parent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(parent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void joinBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_joinBtnActionPerformed
        username = usernameTField.getText();
        if (username.isEmpty()) {
            //JOptionPane.showMessageDialog(this, "Your username can not be empty");
            System.out.println("Your username can not be empty");
        } else {
            connect();
            mainLayout.show(parent, "card3");
            usernameTField.setText("");
        }
    }//GEN-LAST:event_joinBtnActionPerformed

    private void chatTFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_chatTFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String s = chatTField.getText();
            sendObject(new ChatPacket(this.username, s));
            chatTField.setText("");
        }
    }//GEN-LAST:event_chatTFieldKeyPressed

    private void JoinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JoinMouseClicked
        username = usernameTField.getText();
        if (username.isEmpty()) {
            //JOptionPane.showMessageDialog(this, "Your username can not be empty");
            System.out.println("Your username can not be empty");
        } else {
            connect();
            mainLayout.show(parent, "card3");
        }
    }//GEN-LAST:event_JoinMouseClicked

    private void ChatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ChatMouseClicked
        secondaryLayout.show(parent2, "card2");
    }//GEN-LAST:event_ChatMouseClicked

    private void LeaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LeaveMouseClicked
        close();
    }//GEN-LAST:event_LeaveMouseClicked

    private void PeopleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PeopleMouseClicked
        secondaryLayout.show(parent2, "card3");
    }//GEN-LAST:event_PeopleMouseClicked

    private void usernameTFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameTFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameTFieldActionPerformed

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
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Client().setVisible(true);
            }
        });
    }

    public AudioFormat getAudioFormat() {
        float sampleRate = 16000;
        int sampleSizeInBits = 8;
        int channels = 2;
        boolean signed = true;
        boolean bigEndian = true;
        AudioFormat format = new AudioFormat(sampleRate, sampleSizeInBits,
                channels, signed, bigEndian);
        return format;
    }

    public void connect() {
        try {
            host = "127.0.0.1";
            port = 3000;
            socket = new Socket(host, port);
            out = new ObjectOutputStream(socket.getOutputStream());
            out.flush();
            in = new ObjectInputStream(socket.getInputStream());

            listener = new EventListener();
            running = true;

            new Thread(this).start();
            sendObject(new AddUserPacket(username));

            Thread audioThread = new Thread(new Runnable() {
                @Override
                public void run() {

                    AudioFormat format = getAudioFormat();
                    DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);

                    // checks if system supports the data line
                    if (!AudioSystem.isLineSupported(info)) {
                        System.out.println("Line not supported");
                        System.exit(0);
                    }
                    try {
                        line = (TargetDataLine) AudioSystem.getLine(info);
                        line.open(format);
                        line.start();   // start capturing
                    } catch (LineUnavailableException ex) {
                        Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    System.out.println("Start capturing...");
                    while (true) {
                        System.out.println("");
                        if (audio) {
                            try {

                                //AudioInputStream ais = new AudioInputStream(line);
                                byte buf[] = new byte[1024];

                                int bytesIn = line.read(buf, 0, 1024);

                                AudioPacket ap = new AudioPacket(buf, 0, bytesIn);

                                //AudioPacket ap = new AudioPacket(ais);
                                out.writeObject(ap);

                            } catch (IOException ex) {
                                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }

                    }
                }
            });
            audioThread.start();
            Thread videoThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (video) {

                    }
                }
            });
            videoThread.start();

        } catch (IOException ex) {
            System.out.println("Unnable to connect to the server");
        }
    }

    public void close() {

        try {
            running = false;
            audio = false;
            video = false;
            RemoveUserPacket packet = new RemoveUserPacket(username);
            sendObject(packet);
            in.close();
            out.close();
            socket.close();
        } catch (IOException ex) {
            System.out.println("Error in closing the connection");
        }

    }

    public void sendObject(Object packet) {
        try {
            out.writeObject(packet);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void run() {
        while (running) {
            try {
                Object data = in.readObject();
                listener.recieved(data);
            } catch (IOException ex) {
                close();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Chat;
    private javax.swing.JLabel Join;
    private javax.swing.JPanel Leave;
    private javax.swing.JPanel People;
    private javax.swing.JPanel chat;
    public static javax.swing.JTextArea chatTArea;
    private javax.swing.JTextField chatTField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel menu;
    private javax.swing.JPanel options;
    private javax.swing.JPanel parent;
    private javax.swing.JPanel parent2;
    private javax.swing.JPanel participants;
    private javax.swing.JPanel room;
    private javax.swing.JTextField usernameTField;
    // End of variables declaration//GEN-END:variables
}
