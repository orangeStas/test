/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatapp;

import com.sun.corba.se.pept.transport.ListenerThread;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.JTextPane;

/**
 *
 * @author OrangeUser
 */
public class chat extends javax.swing.JFrame {

    String userName;
    Socket socket;
    BufferedReader reader;
    PrintWriter writer;
    ArrayList<String> userList = new ArrayList<>();
    Boolean isConnected = false;

    /**
     * Creates new form chat
     */
    public chat() {
        initComponents();
    }

    private Thread Thread(ServerMain serverMain) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        userNameField = new javax.swing.JTextField();
        connectButton = new javax.swing.JButton();
        disconnectButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        onlineUsersArea = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        chatTextArea = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        chatMessageArea = new javax.swing.JTextPane();
        sendButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        ipField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ChatClient");
        setAlwaysOnTop(true);
        setForeground(java.awt.Color.orange);

        jLabel1.setText("Имя пользователя");

        connectButton.setText("Подключиться");
        connectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectButtonActionPerformed(evt);
            }
        });

        disconnectButton.setText("Отключиться");
        disconnectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disconnectButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Пользователи");

        onlineUsersArea.setEditable(false);
        onlineUsersArea.setColumns(20);
        onlineUsersArea.setRows(5);
        jScrollPane1.setViewportView(onlineUsersArea);

        chatTextArea.setEditable(false);
        chatTextArea.setColumns(20);
        chatTextArea.setLineWrap(true);
        chatTextArea.setRows(5);
        jScrollPane2.setViewportView(chatTextArea);

        chatMessageArea.setToolTipText("");
        jScrollPane3.setViewportView(chatMessageArea);

        sendButton.setText("Отправить");
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("IP-адрес");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(sendButton)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(userNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ipField, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(disconnectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(connectButton))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(connectButton)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ipField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(disconnectButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sendButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    private void connectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectButtonActionPerformed
        if (isConnected == false) {
            userName = userNameField.getText();
            userNameField.setEditable(false);
            ipField.setEditable(false);
            
            //Trying connect to server
            try {
                socket = new Socket(ipField.getText(), 5555);
                InputStreamReader streamReader = new InputStreamReader(socket.getInputStream());
                reader = new BufferedReader(streamReader);
                writer = new PrintWriter(socket.getOutputStream());
                writer.println(userName + "::Connect");
                writer.flush();
                isConnected = true;
            
            //Else set up own server
            } catch (Exception e) {
                try {
                    userNameField.setEditable(true);
                    ipField.setEditable(true);
                    chatTextArea.append("Сервер не найден. Создание нового сервера..\n");
                    Thread thread = new Thread(new ServerMain());
                    thread.start();
                } catch (Exception ex) {
                    userNameField.setEditable(true);
                }
            }
          
            ListenThread();
        } else if (isConnected == true) {
            chatTextArea.append("Вы уже подключены.\n");
        }
    }//GEN-LAST:event_connectButtonActionPerformed

    /*Method, that create a new thread of class CommandReader*/
    public void ListenThread() {
        Thread incomingReader = new Thread(new CommandReader());
        incomingReader.start();
    }
   
    /*This class get commands from server*/
    public class CommandReader implements Runnable {
        public void run() {
            String stream;
            String[] data;
            String done = "Done", connect = "Connect", disconnect = "Disconnect", message = "Message";

            try {
                while ((stream = reader.readLine()) != null) {
                    data = stream.split(":");
                    String name = data[0], messageString = data[1], command = data[2];
                    if (command.equals(message)) {
                        chatTextArea.append(name + ": " + messageString + "\n");
                    } else if (command.equals(connect)) {
                        chatTextArea.removeAll();
                        userAdd(name);
                    } else if (command.equals(disconnect)) {
                        userRemove(name);
                    } else if (command.equals(done)) {
                        onlineUsersArea.setText("");
                        writeUsers();
                        userList.clear();
                    }
                }
            } catch (Exception e) {
            }
        }
    }
    
    private void disconnectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disconnectButtonActionPerformed
        sendDisconnect();
        Disconnect();
    }//GEN-LAST:event_disconnectButtonActionPerformed

    
    public void sendDisconnect() {
        String bye = (userName + "::Disconnect");
        try {
            writer.println(bye); //send server about disconnect
            writer.flush();
        } catch (Exception e) {
            chatTextArea.append("Не удаётся отправить запрос на отключение\n");
        }
    }

    public void Disconnect() {
        try {
            
            /*Close streams and stop thread*/
            chatTextArea.append("Отключение..\n");
            socket.close();
            reader.close();
            writer.close();
            Thread.currentThread().interrupt();
            
        } catch (Exception e) {
            chatTextArea.append("Ошибка при отключении. \n");
        }
        isConnected = false;
        userNameField.setEditable(true);
        ipField.setEditable(true);
        onlineUsersArea.setText("");
    }

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
        String nothing = "";
        if ((chatMessageArea.getText().equals(nothing))) {
            chatMessageArea.setText("");
            chatMessageArea.requestFocus();
        } else {
            try {
                
                /*Send message*/
                writer.println(userName + ":" + chatMessageArea.getText() + ":" + "Message");
                writer.flush();
            } catch (Exception e) {
                chatTextArea.append("Сообщение не отправлено\n");
            }
            chatMessageArea.setText(nothing);
            chatMessageArea.requestFocus();
        }
    }//GEN-LAST:event_sendButtonActionPerformed

    public void userAdd(String userName) {
        userList.add(userName);
    }

    public void userRemove(String userName) {
        chatTextArea.append(userName + " отключился.\n");
    }

    /*Reflesh online users*/
    public void writeUsers() {
        String[] tempList = new String[userList.size()];
        userList.toArray(tempList);
        for (String token : tempList) {
            onlineUsersArea.append(token + "\n");
        }
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
            java.util.logging.Logger.getLogger(chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new chat().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane chatMessageArea;
    private javax.swing.JTextArea chatTextArea;
    private javax.swing.JButton connectButton;
    private javax.swing.JButton disconnectButton;
    private javax.swing.JTextField ipField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea onlineUsersArea;
    private javax.swing.JButton sendButton;
    private javax.swing.JTextField userNameField;
    // End of variables declaration//GEN-END:variables
}
