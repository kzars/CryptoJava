// Author: Karlis Zars
// Main class for Cryprogaphy using AES Algorithm
// Using javax.crypto library

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import java.util.Scanner;
import java.io.*;
import java.util.Arrays;

// For GUI using JFrame
public class Main extends javax.swing.JFrame {

    CryptoAESAlgo aesAlgo;

    public Main() {
        guiStart();
    }

// GUI main component placement Method
    private void guiStart() {

        Button = new javax.swing.JButton();
        Button_i = new javax.swing.JButton();
        Panel = new javax.swing.JScrollPane();
        Label1 = new javax.swing.JLabel();
        Label2 = new javax.swing.JLabel();
        TextArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        Label1.setFont(new java.awt.Font("Calibri", 1, 14));
        Label1.setForeground(new java.awt.Color(102, 100, 102));
        Label1.setText("Ludzu izvalaties vai valatie sifret vai atsifret failu saturu");

        Button.setText("Sifret");
        Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonActionPerformed(evt);
            }
        });

        Button_i.setText("Atsifret");
        Button_i.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_iActionPerformed(evt);
            }
        });

        TextArea.setColumns(35);
        TextArea.setRows(5);
        Panel.setViewportView(TextArea);
        Label2.setFont(new java.awt.Font("Calibri", 1, 14));
        Label2.setText("AES Sifresanas programma");
        //Main layout
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(Label1)
                                    .addGap(0, 126, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addComponent(Button)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Button_i))
                        .addComponent(Panel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Label2))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(Label2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Label1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Button_i)
                    .addComponent(Button))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    private void ButtonActionPerformed(java.awt.event.ActionEvent evt) {
        try{
          FileInputStream fiskey=new FileInputStream("Key.txt");
          Scanner sck=new Scanner(fiskey);
          String keytext = sck.nextLine();
          byte[] keyValue = keytext.getBytes();
          aesAlgo = new CryptoAESAlgo(keyValue);

          FileInputStream fis=new FileInputStream("Input.txt");
          Scanner sc=new Scanner(fis);
          String plainText = sc.nextLine();
          String encryptedText = aesAlgo.encrypt(plainText);

            TextArea.setText(encryptedText);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void Button_iActionPerformed(java.awt.event.ActionEvent evt) {
        try{
            FileInputStream fis2=new FileInputStream("Input2.txt");
            Scanner sc2=new Scanner(fis2);
            String encryptedText = sc2.nextLine();
            String plainText = aesAlgo.decrypt(encryptedText);

            TextArea.setText(plainText);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {

        // Create and display the form
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // GUI Variables declaration
    private javax.swing.JButton Button;
    private javax.swing.JButton Button_i;
    private javax.swing.JLabel Label1;
    private javax.swing.JLabel Label2;
    private javax.swing.JScrollPane Panel;
    private javax.swing.JTextArea TextArea;

}
