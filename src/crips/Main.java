/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crips;

import com.placeholder.PlaceHolder;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;

/**
 *
 * @author EJ
 */
public class Main extends javax.swing.JFrame {
    
    PlaceHolder holder;
    String typeOfCryptography = "symmetric";
    Criteria criteria=new Criteria();
    KeyPair keyPair;
    PublicKey pubKey;
    PrivateKey privateKey;
    ArrayList<Data> data = new ArrayList();
    Scanner sc;
    
    /**
     * Creates new form Main
     */
    public Main() throws NoSuchAlgorithmException {
        initComponents();
        setPlaceHolder();
        animationHacking();
        setActionCommand();
        this.keyPair = buildKeyPair();
        this.pubKey = keyPair.getPublic();
        this.privateKey = keyPair.getPrivate();
    }
    
    private void setPlaceHolder() {
        holder = new PlaceHolder(txt_alice, "Type a message...");
        holder = new PlaceHolder(txt_bob, "Type a message...");
    }
    
    private void setActionCommand() {
        radio_AES.setActionCommand("AES");
        radio_DES.setActionCommand("DES");
        radio_BLOWFISH.setActionCommand("BLOWFISH");
        radio_RSA.setActionCommand("RSA");
    }
    
    private void animationHacking(){
        Random random = new Random();
        Timer tm;
        tm = new Timer(10, new ActionListener(){
            int r = random.nextInt(255);
            int b = 0;
            int g = 0;
            int itr = 1;
            @Override 
            public void actionPerformed(ActionEvent e){
                try{
                    lbl_hacking.setBackground(new Color(0, 0, 0));
                    lbl_hacking.setForeground(new Color(r,g,b));
                    if (itr == 1) {
                        lbl_hacking.setText("HACKING.");
                        itr++;
                    }
                    else if (itr == 2) {
                        lbl_hacking.setText("HACKING..");
                        itr++;
                    }
                    else  {
                        lbl_hacking.setText("HACKING...");
                        itr = 1;
                    }
                    r = r + 1;
                    b = b + 1;
                    g = g + 1;
                }catch(Exception ex){
                    r = random.nextInt(255);
                    b = 0;
                    g = 0;
                }
            }
        });
        tm.start();
    }
    
    private void displayLoading(JPanel parent, JPanel p,JTextArea txtarea, String txt, String user) {
        Timer tm;
        tm = new Timer(1000, new ActionListener(){
            int count = 1;
            public void actionPerformed(ActionEvent e){
                try{
                    count++;;
                    if (count == 5) {
                       showPanel(parent, p);
                       displayDecipher(txtarea, txt, user);
                       return;
                    }
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        });
        tm.start();         
    }
    
    private void displayDecipher(JTextArea txtarea, String txt, String user) {
        txtarea.append(user + ": " + txt +"\n");
    }
    
    public KeyPair buildKeyPair() throws NoSuchAlgorithmException {
        final int keySize = 2048;
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(keySize);      
        return keyPairGenerator.genKeyPair();
    }
    
    private String encryptData(String plainText, String key) throws Exception {
        String encryptedData = null;
        if (radio_DES.isSelected()) {
            DES des = new DES(key);
            encryptedData = des.encrypt(plainText);
        }
        else if (radio_AES.isSelected()){
            AES aes = new AES(key);
            encryptedData = aes.encrypt(plainText);
        }
        else if (radio_BLOWFISH.isSelected()){
            Blowfish blowfish = new Blowfish(key);
            encryptedData = blowfish.encrypt(plainText);
        }
        else if (radio_RSA.isSelected()){
            RSA rsa = new RSA();
            encryptedData = rsa.encrypt(this.privateKey, plainText);
        }
        return encryptedData;
    }
    
    
    private String decryptData(String data, String key) throws Exception {
        String decryptedData = null;
        if (radio_DES.isSelected()) {
            DES des = new DES(key);
            decryptedData = des.decrypt(data);
        }
        if (radio_AES.isSelected()) {
            AES aes = new AES(key);
            decryptedData = aes.decrypt(data);
        }
        else if (radio_BLOWFISH.isSelected()){
            Blowfish blowfish = new Blowfish(key);
            decryptedData = blowfish.decrypt(data);
        }
        else if (radio_RSA.isSelected()){
            RSA rsa = new RSA();
            decryptedData = rsa.decrypt(this.pubKey, data);
        }
        return decryptedData;
    }
    
    private void showPanel(JPanel parent, JPanel p) {
        parent.removeAll();
        parent.add(p);
        parent.repaint();
        parent.revalidate();
    }
    
    private void editorText() {
        JEditorPane txtarea_hacker = new JEditorPane();
        txtarea_hacker.setContentType("text/html");
//        editorPane.setText("<b>This text is bold</b>"); 
    }
    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        panel_main = new javax.swing.JPanel();
        panel_alice = new javax.swing.JPanel();
        panel_aliceHeader = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        panel_aliceBody = new javax.swing.JPanel();
        panel_aliceKey = new javax.swing.JPanel();
        panel_aliceSymmetric = new javax.swing.JPanel();
        jTextField4 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        panel_aliceLoading = new javax.swing.JPanel();
        lbl_aliceLoading = new javax.swing.JLabel();
        panel_aliceAsymmetric = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtarea_alice = new javax.swing.JTextArea();
        txt_alice = new javax.swing.JTextField();
        panel_bob = new javax.swing.JPanel();
        panel_bobHeader = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        panel_bobBody = new javax.swing.JPanel();
        panel_bobKey = new javax.swing.JPanel();
        panel_bobSymmetric = new javax.swing.JPanel();
        jTextField6 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        panel_bobLoading = new javax.swing.JPanel();
        lbl_bobLoading = new javax.swing.JLabel();
        panel_bobAsymmetric = new javax.swing.JPanel();
        jTextField3 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtarea_bob = new javax.swing.JTextArea();
        txt_bob = new javax.swing.JTextField();
        panel_actions = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        radio_symmetric = new javax.swing.JRadioButton();
        radio_asymmetric = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        radio_DES = new javax.swing.JRadioButton();
        radio_AES = new javax.swing.JRadioButton();
        radio_MD5 = new javax.swing.JRadioButton();
        radio_BLOWFISH = new javax.swing.JRadioButton();
        radio_RSA = new javax.swing.JRadioButton();
        btn_algoStatistics = new javax.swing.JButton();
        panel_hacker = new javax.swing.JPanel();
        panel_hackerHeader = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtarea_hacker = new javax.swing.JTextArea();
        lbl_hacking = new javax.swing.JLabel();
        lbl_BG = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel_main.setBackground(new java.awt.Color(0, 204, 51));
        panel_main.setMaximumSize(new java.awt.Dimension(1280, 900));
        panel_main.setLayout(null);

        panel_alice.setBackground(new java.awt.Color(255, 255, 255));
        panel_alice.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 5));

        panel_aliceHeader.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel4.setText("Alice Caroll");

        jLabel3.setIcon(new javax.swing.ImageIcon("E:\\EJ\\Java\\Netbeans Project\\Cryptograhy\\src\\images\\Avengers-Black-Widow-icon.png")); // NOI18N
        jLabel3.setText("jLabel3");

        javax.swing.GroupLayout panel_aliceHeaderLayout = new javax.swing.GroupLayout(panel_aliceHeader);
        panel_aliceHeader.setLayout(panel_aliceHeaderLayout);
        panel_aliceHeaderLayout.setHorizontalGroup(
            panel_aliceHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_aliceHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_aliceHeaderLayout.setVerticalGroup(
            panel_aliceHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_aliceHeaderLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel_aliceHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)))
        );

        panel_aliceBody.setBackground(new java.awt.Color(204, 204, 204));

        panel_aliceKey.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        panel_aliceKey.setMinimumSize(new java.awt.Dimension(310, 132));
        panel_aliceKey.setLayout(new java.awt.CardLayout());

        panel_aliceSymmetric.setBackground(new java.awt.Color(204, 204, 204));
        panel_aliceSymmetric.setMinimumSize(new java.awt.Dimension(310, 132));
        panel_aliceSymmetric.setPreferredSize(new java.awt.Dimension(310, 132));

        jTextField4.setText(" 471c3$pUb71ck3y");
        jTextField4.setDisabledTextColor(new java.awt.Color(204, 0, 0));
        jTextField4.setEnabled(false);

        jLabel11.setFont(new java.awt.Font("SansSerif", 2, 14)); // NOI18N
        jLabel11.setText("Alice's public key");

        jLabel12.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel12.setText("Symmetric Key Cryptography");

        javax.swing.GroupLayout panel_aliceSymmetricLayout = new javax.swing.GroupLayout(panel_aliceSymmetric);
        panel_aliceSymmetric.setLayout(panel_aliceSymmetricLayout);
        panel_aliceSymmetricLayout.setHorizontalGroup(
            panel_aliceSymmetricLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_aliceSymmetricLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(panel_aliceSymmetricLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_aliceSymmetricLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_aliceSymmetricLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(53, 53, 53))))
        );
        panel_aliceSymmetricLayout.setVerticalGroup(
            panel_aliceSymmetricLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_aliceSymmetricLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addGap(31, 31, 31)
                .addGroup(panel_aliceSymmetricLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(0, 0, 0))
        );

        panel_aliceKey.add(panel_aliceSymmetric, "card2");

        panel_aliceLoading.setBackground(new java.awt.Color(204, 204, 204));
        panel_aliceLoading.setMinimumSize(new java.awt.Dimension(310, 132));

        lbl_aliceLoading.setIcon(new javax.swing.ImageIcon("E:\\EJ\\Java\\Netbeans Project\\Cryptograhy\\src\\images\\loading_gif2.gif")); // NOI18N

        javax.swing.GroupLayout panel_aliceLoadingLayout = new javax.swing.GroupLayout(panel_aliceLoading);
        panel_aliceLoading.setLayout(panel_aliceLoadingLayout);
        panel_aliceLoadingLayout.setHorizontalGroup(
            panel_aliceLoadingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_aliceLoading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panel_aliceLoadingLayout.setVerticalGroup(
            panel_aliceLoadingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_aliceLoading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panel_aliceKey.add(panel_aliceLoading, "card2");

        panel_aliceAsymmetric.setBackground(new java.awt.Color(204, 204, 204));
        panel_aliceAsymmetric.setMinimumSize(new java.awt.Dimension(310, 132));
        panel_aliceAsymmetric.setPreferredSize(new java.awt.Dimension(310, 132));

        jTextField1.setBackground(new java.awt.Color(240, 240, 240));
        jTextField1.setText(" B0b'$pUb71ck3y");
        jTextField1.setDisabledTextColor(new java.awt.Color(204, 0, 0));
        jTextField1.setEnabled(false);

        jTextField2.setBackground(new java.awt.Color(240, 240, 240));
        jTextField2.setText("A71c3'$pr1v4+3k3y");
        jTextField2.setDisabledTextColor(new java.awt.Color(204, 0, 0));
        jTextField2.setEnabled(false);

        jLabel9.setFont(new java.awt.Font("SansSerif", 2, 14)); // NOI18N
        jLabel9.setText("Alice's private key");

        jLabel1.setFont(new java.awt.Font("SansSerif", 2, 14)); // NOI18N
        jLabel1.setText("Bob's public key");

        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel10.setText("Asymmetric Key Cryptography");

        javax.swing.GroupLayout panel_aliceAsymmetricLayout = new javax.swing.GroupLayout(panel_aliceAsymmetric);
        panel_aliceAsymmetric.setLayout(panel_aliceAsymmetricLayout);
        panel_aliceAsymmetricLayout.setHorizontalGroup(
            panel_aliceAsymmetricLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_aliceAsymmetricLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(panel_aliceAsymmetricLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_aliceAsymmetricLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1))
                    .addComponent(jLabel9))
                .addGroup(panel_aliceAsymmetricLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_aliceAsymmetricLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_aliceAsymmetricLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(panel_aliceAsymmetricLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_aliceAsymmetricLayout.setVerticalGroup(
            panel_aliceAsymmetricLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_aliceAsymmetricLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addGroup(panel_aliceAsymmetricLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_aliceAsymmetricLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel_aliceKey.add(panel_aliceAsymmetric, "card2");

        txtarea_alice.setEditable(false);
        txtarea_alice.setColumns(20);
        txtarea_alice.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtarea_alice.setLineWrap(true);
        txtarea_alice.setRows(5);
        txtarea_alice.setBorder(null);
        txtarea_alice.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtarea_alice.setFocusable(false);
        jScrollPane2.setViewportView(txtarea_alice);

        txt_alice.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txt_alice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_aliceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_aliceBodyLayout = new javax.swing.GroupLayout(panel_aliceBody);
        panel_aliceBody.setLayout(panel_aliceBodyLayout);
        panel_aliceBodyLayout.setHorizontalGroup(
            panel_aliceBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_aliceKey, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(txt_alice)
        );
        panel_aliceBodyLayout.setVerticalGroup(
            panel_aliceBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_aliceBodyLayout.createSequentialGroup()
                .addComponent(panel_aliceKey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(txt_alice, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout panel_aliceLayout = new javax.swing.GroupLayout(panel_alice);
        panel_alice.setLayout(panel_aliceLayout);
        panel_aliceLayout.setHorizontalGroup(
            panel_aliceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_aliceBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panel_aliceHeader, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panel_aliceLayout.setVerticalGroup(
            panel_aliceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_aliceLayout.createSequentialGroup()
                .addComponent(panel_aliceHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_aliceBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel_main.add(panel_alice);
        panel_alice.setBounds(290, 20, 320, 530);

        panel_bob.setBackground(new java.awt.Color(255, 255, 255));
        panel_bob.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 5));

        panel_bobHeader.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel8.setText("Bob Simmon");

        jLabel13.setIcon(new javax.swing.ImageIcon("E:\\EJ\\Java\\Netbeans Project\\Cryptograhy\\src\\images\\Avengers-Agent-Coulson-icon.png")); // NOI18N
        jLabel13.setText("jLabel3");

        javax.swing.GroupLayout panel_bobHeaderLayout = new javax.swing.GroupLayout(panel_bobHeader);
        panel_bobHeader.setLayout(panel_bobHeaderLayout);
        panel_bobHeaderLayout.setHorizontalGroup(
            panel_bobHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_bobHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_bobHeaderLayout.setVerticalGroup(
            panel_bobHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_bobHeaderLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel_bobHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel8)))
        );

        panel_bobBody.setBackground(new java.awt.Color(204, 204, 204));

        panel_bobKey.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        panel_bobKey.setLayout(new java.awt.CardLayout());

        panel_bobSymmetric.setBackground(new java.awt.Color(204, 204, 204));
        panel_bobSymmetric.setMinimumSize(new java.awt.Dimension(310, 132));
        panel_bobSymmetric.setPreferredSize(new java.awt.Dimension(310, 132));

        jTextField6.setText(" B0b$pUb71ck3y");
        jTextField6.setDisabledTextColor(new java.awt.Color(204, 0, 0));
        jTextField6.setEnabled(false);

        jLabel17.setFont(new java.awt.Font("SansSerif", 2, 14)); // NOI18N
        jLabel17.setText("Bob's public key");

        jLabel18.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel18.setText("Symmetric Key Cryptography");

        javax.swing.GroupLayout panel_bobSymmetricLayout = new javax.swing.GroupLayout(panel_bobSymmetric);
        panel_bobSymmetric.setLayout(panel_bobSymmetricLayout);
        panel_bobSymmetricLayout.setHorizontalGroup(
            panel_bobSymmetricLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_bobSymmetricLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(panel_bobSymmetricLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_bobSymmetricLayout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_bobSymmetricLayout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(53, 53, 53))))
        );
        panel_bobSymmetricLayout.setVerticalGroup(
            panel_bobSymmetricLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_bobSymmetricLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addGap(31, 31, 31)
                .addGroup(panel_bobSymmetricLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addGap(0, 0, 0))
        );

        panel_bobKey.add(panel_bobSymmetric, "card2");

        panel_bobLoading.setBackground(new java.awt.Color(204, 204, 204));
        panel_bobLoading.setMinimumSize(new java.awt.Dimension(310, 132));

        lbl_bobLoading.setIcon(new javax.swing.ImageIcon("E:\\EJ\\Java\\Netbeans Project\\Cryptograhy\\src\\images\\loading_gif2.gif")); // NOI18N

        javax.swing.GroupLayout panel_bobLoadingLayout = new javax.swing.GroupLayout(panel_bobLoading);
        panel_bobLoading.setLayout(panel_bobLoadingLayout);
        panel_bobLoadingLayout.setHorizontalGroup(
            panel_bobLoadingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_bobLoading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panel_bobLoadingLayout.setVerticalGroup(
            panel_bobLoadingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_bobLoading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panel_bobKey.add(panel_bobLoading, "card2");

        panel_bobAsymmetric.setBackground(new java.awt.Color(204, 204, 204));
        panel_bobAsymmetric.setMinimumSize(new java.awt.Dimension(310, 132));
        panel_bobAsymmetric.setPreferredSize(new java.awt.Dimension(310, 132));

        jTextField3.setBackground(new java.awt.Color(240, 240, 240));
        jTextField3.setText(" 471c3$pUb71ck3y");
        jTextField3.setDisabledTextColor(new java.awt.Color(204, 0, 0));
        jTextField3.setEnabled(false);

        jTextField5.setBackground(new java.awt.Color(240, 240, 240));
        jTextField5.setText(" B0b$pr1v4+3k3y");
        jTextField5.setDisabledTextColor(new java.awt.Color(204, 0, 0));
        jTextField5.setEnabled(false);

        jLabel14.setFont(new java.awt.Font("SansSerif", 2, 14)); // NOI18N
        jLabel14.setText("Bob's private key");

        jLabel15.setFont(new java.awt.Font("SansSerif", 2, 14)); // NOI18N
        jLabel15.setText("Alice's public key");

        jLabel16.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel16.setText("Asymmetric Key Cryptography");

        javax.swing.GroupLayout panel_bobAsymmetricLayout = new javax.swing.GroupLayout(panel_bobAsymmetric);
        panel_bobAsymmetric.setLayout(panel_bobAsymmetricLayout);
        panel_bobAsymmetricLayout.setHorizontalGroup(
            panel_bobAsymmetricLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_bobAsymmetricLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel_bobAsymmetricLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addGroup(panel_bobAsymmetricLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(panel_bobAsymmetricLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel16)
                .addContainerGap(62, Short.MAX_VALUE))
        );
        panel_bobAsymmetricLayout.setVerticalGroup(
            panel_bobAsymmetricLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_bobAsymmetricLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addGap(18, 18, 18)
                .addGroup(panel_bobAsymmetricLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_bobAsymmetricLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel_bobKey.add(panel_bobAsymmetric, "card2");

        txtarea_bob.setEditable(false);
        txtarea_bob.setColumns(20);
        txtarea_bob.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtarea_bob.setLineWrap(true);
        txtarea_bob.setRows(5);
        txtarea_bob.setBorder(null);
        txtarea_bob.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtarea_bob.setFocusable(false);
        jScrollPane4.setViewportView(txtarea_bob);

        txt_bob.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txt_bob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bobActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_bobBodyLayout = new javax.swing.GroupLayout(panel_bobBody);
        panel_bobBody.setLayout(panel_bobBodyLayout);
        panel_bobBodyLayout.setHorizontalGroup(
            panel_bobBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_bobKey, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(txt_bob)
        );
        panel_bobBodyLayout.setVerticalGroup(
            panel_bobBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_bobBodyLayout.createSequentialGroup()
                .addComponent(panel_bobKey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(txt_bob, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout panel_bobLayout = new javax.swing.GroupLayout(panel_bob);
        panel_bob.setLayout(panel_bobLayout);
        panel_bobLayout.setHorizontalGroup(
            panel_bobLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_bobBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panel_bobHeader, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panel_bobLayout.setVerticalGroup(
            panel_bobLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_bobLayout.createSequentialGroup()
                .addComponent(panel_bobHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_bobBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel_main.add(panel_bob);
        panel_bob.setBounds(927, 20, 320, 530);

        panel_actions.setBackground(new java.awt.Color(153, 153, 153));
        panel_actions.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 5));

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setFont(new java.awt.Font("BatmanForeverAlternate", 0, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Actions");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Type of Crpytography", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 18))); // NOI18N

        buttonGroup1.add(radio_symmetric);
        radio_symmetric.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        radio_symmetric.setSelected(true);
        radio_symmetric.setText("Symmetric Key Crptography");
        radio_symmetric.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radio_symmetricActionPerformed(evt);
            }
        });

        buttonGroup1.add(radio_asymmetric);
        radio_asymmetric.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        radio_asymmetric.setText("Asymmetric Key Crptography");
        radio_asymmetric.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radio_asymmetricActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radio_symmetric)
                    .addComponent(radio_asymmetric))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(radio_symmetric)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(radio_asymmetric)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Algorithm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 18))); // NOI18N

        buttonGroup2.add(radio_DES);
        radio_DES.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        radio_DES.setText("DES");

        buttonGroup2.add(radio_AES);
        radio_AES.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        radio_AES.setText("AES");

        buttonGroup2.add(radio_MD5);
        radio_MD5.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        radio_MD5.setText("MD5");

        buttonGroup2.add(radio_BLOWFISH);
        radio_BLOWFISH.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        radio_BLOWFISH.setText("BLOWFISH");

        buttonGroup2.add(radio_RSA);
        radio_RSA.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        radio_RSA.setText("RSA");
        radio_RSA.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radio_AES)
                    .addComponent(radio_DES)
                    .addComponent(radio_BLOWFISH)
                    .addComponent(radio_MD5)
                    .addComponent(radio_RSA))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(radio_DES)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radio_AES)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radio_BLOWFISH)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radio_MD5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radio_RSA)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        btn_algoStatistics.setBackground(new java.awt.Color(0, 0, 0));
        btn_algoStatistics.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_algoStatistics.setForeground(new java.awt.Color(255, 255, 255));
        btn_algoStatistics.setText("Go to Algorithms Statistics");
        btn_algoStatistics.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_algoStatisticsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_actionsLayout = new javax.swing.GroupLayout(panel_actions);
        panel_actions.setLayout(panel_actionsLayout);
        panel_actionsLayout.setHorizontalGroup(
            panel_actionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_actionsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_actionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel_actionsLayout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btn_algoStatistics, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE))
                .addContainerGap())
        );
        panel_actionsLayout.setVerticalGroup(
            panel_actionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_actionsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addGap(30, 30, 30)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(btn_algoStatistics, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panel_main.add(panel_actions);
        panel_actions.setBounds(20, 20, 260, 530);

        panel_hacker.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 5));

        panel_hackerHeader.setBackground(new java.awt.Color(255, 255, 255));
        panel_hackerHeader.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jLabel20.setIcon(new javax.swing.ImageIcon("E:\\EJ\\Java\\Netbeans Project\\Cryptograhy\\src\\images\\Avengers-Nick-Fury-icon.png")); // NOI18N
        jLabel20.setText("jLabel3");

        jLabel21.setBackground(new java.awt.Color(255, 255, 255));
        jLabel21.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel21.setText("Hacker");

        javax.swing.GroupLayout panel_hackerHeaderLayout = new javax.swing.GroupLayout(panel_hackerHeader);
        panel_hackerHeader.setLayout(panel_hackerHeaderLayout);
        panel_hackerHeaderLayout.setHorizontalGroup(
            panel_hackerHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_hackerHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        panel_hackerHeaderLayout.setVerticalGroup(
            panel_hackerHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_hackerHeaderLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel_hackerHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21))
                .addContainerGap())
        );

        txtarea_hacker.setEditable(false);
        txtarea_hacker.setColumns(20);
        txtarea_hacker.setLineWrap(true);
        txtarea_hacker.setRows(5);
        txtarea_hacker.setFocusable(false);
        jScrollPane1.setViewportView(txtarea_hacker);

        lbl_hacking.setBackground(new java.awt.Color(255, 255, 255));
        lbl_hacking.setFont(new java.awt.Font("DS-Digital", 0, 36)); // NOI18N
        lbl_hacking.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_hacking.setText("HACKING...");
        lbl_hacking.setOpaque(true);
        lbl_hacking.setPreferredSize(new java.awt.Dimension(34, 20));

        javax.swing.GroupLayout panel_hackerLayout = new javax.swing.GroupLayout(panel_hacker);
        panel_hacker.setLayout(panel_hackerLayout);
        panel_hackerLayout.setHorizontalGroup(
            panel_hackerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_hackerHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addComponent(lbl_hacking, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panel_hackerLayout.setVerticalGroup(
            panel_hackerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_hackerLayout.createSequentialGroup()
                .addComponent(panel_hackerHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(lbl_hacking, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panel_main.add(panel_hacker);
        panel_hacker.setBounds(624, 20, 290, 530);

        lbl_BG.setIcon(new javax.swing.ImageIcon("E:\\EJ\\Java\\Netbeans Project\\Cryptograhy\\src\\images\\w1.jpg")); // NOI18N
        panel_main.add(lbl_BG);
        lbl_BG.setBounds(0, 0, 1270, 570);

        getContentPane().add(panel_main, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(1283, 608));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_aliceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_aliceActionPerformed
        // TODO add your handling code here:
        Runtime rt = Runtime.getRuntime();
        long usedBefore = rt.totalMemory() - rt.freeMemory();
        long startTime=System.nanoTime();
        String plainText = txt_alice.getText();
        String encryptedData="";

        showPanel(panel_bobKey, panel_bobLoading);
        if (this.typeOfCryptography.equals("asymmetric")) {
            try {
                encryptedData = encryptData(plainText, "B0b$pUb71ck3y");
                String decryptedData = decryptData(encryptedData, "B0b$pr1v4+3k3y");

                txtarea_alice.append("Alice: " + plainText +"\n");
                txtarea_hacker.append("Alice: " + encryptedData +"\n");
                displayLoading(panel_bobKey, panel_bobAsymmetric, txtarea_bob, decryptedData, "Alice");
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        else if (this.typeOfCryptography.equals("symmetric")) {
            try {
                encryptedData = encryptData(plainText, "471c3$pUb71ck3y1");
                String decryptedData = decryptData(encryptedData, "471c3$pUb71ck3y1");

                txtarea_alice.append("Alice: " + plainText +"\n");
                txtarea_hacker.append("Alice: " + encryptedData +"\n");
                displayLoading(panel_bobKey, panel_bobSymmetric, txtarea_bob, decryptedData, "Alice");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        this.requestFocus();
        txt_alice.setText("");
        holder = new PlaceHolder(txt_alice, "Type a plainText...");
        
        // criteria
        double speed=criteria.getSpeed(startTime)/1000000000.0;
        System.out.println(buttonGroup2.getSelection().getActionCommand() + " Speed: " + speed); // in seconds
//        criteria.getMemoryCost(buttonGroup2.getSelection().getActionCommand(), usedBefore); // in bytes
        System.out.println(buttonGroup2.getSelection().getActionCommand() + " Memory used before: " + usedBefore + " bytes");
        long usedAfter = criteria.getMemoryCost();
        System.out.println(buttonGroup2.getSelection().getActionCommand() + " Memory used after: " + usedAfter + " bytes");
        System.out.println(buttonGroup2.getSelection().getActionCommand() + " Total loops after decrypted: " + criteria.getSecurity(plainText, encryptedData));
        
        // add data
        sc = new Scanner(System.in);
        String algo = buttonGroup2.getSelection().getActionCommand();
        System.out.print("Enter file size: ");
        String fileSize = sc.nextLine();
//        double speed =  criteria.getSpeed(startTime)/1000000000.0;
        long security = criteria.getSecurity(plainText, encryptedData);
        data.add(new Data(algo, fileSize, speed, usedBefore, usedAfter, security));
    }//GEN-LAST:event_txt_aliceActionPerformed

    private void txt_bobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bobActionPerformed
        // TODO add your handling code here:
        Runtime rt = Runtime.getRuntime();
        long usedBefore = rt.totalMemory() - rt.freeMemory();
        long startTime=System.nanoTime();
        String plainText = txt_bob.getText();
        String encryptedData = "";

        showPanel(panel_aliceKey, panel_aliceLoading);
        if (this.typeOfCryptography.equals("asymmetric")) {
            try {
                encryptedData = encryptData(plainText, "471c3$pUb71ck3y1");
                String decryptedData = decryptData(encryptedData, "A71c3'$pr1v4+3k3y");
                
                txtarea_bob.append("Bob: " + plainText +"\n");
                txtarea_hacker.append("Bob: " + encryptedData +"\n");
                displayLoading(panel_aliceKey, panel_aliceAsymmetric, txtarea_alice, plainText, "Bob");
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        else if (this.typeOfCryptography.equals("symmetric")) {
            try {
               encryptedData = encryptData(plainText, "B0b$pUb71ck3y123");
                String decryptedData = decryptData(encryptedData, "B0b$pUb71ck3y123");
                
                txtarea_bob.append("Bob: " + plainText +"\n");
                txtarea_hacker.append("Bob: " + encryptedData +"\n");
                displayLoading(panel_aliceKey, panel_aliceSymmetric, txtarea_alice, plainText, "Bob");
            } catch (Exception e) {
                  e.printStackTrace();
            }
        }

        this.requestFocus();
        txt_bob.setText("");
        holder = new PlaceHolder(txt_alice, "Type a plainText...");
        
        // criteria
        double speed=criteria.getSpeed(startTime)/1000000000.0;
        System.out.println(buttonGroup2.getSelection().getActionCommand() + " Speed: " + speed); // in seconds
//        criteria.getMemoryCost(buttonGroup2.getSelection().getActionCommand(), usedBefore); // in bytes
        System.out.println(buttonGroup2.getSelection().getActionCommand() + " Memory used before: " + usedBefore + " bytes");
        long usedAfter = criteria.getMemoryCost();
        System.out.println(buttonGroup2.getSelection().getActionCommand() + " Memory used after: " + usedAfter + " bytes");
        System.out.println(buttonGroup2.getSelection().getActionCommand() + " Total loops after decrypted: " + criteria.getSecurity(plainText, encryptedData));
         
        // add data
        sc = new Scanner(System.in);
        String algo = buttonGroup2.getSelection().getActionCommand();
        System.out.println("Enter file size: ");
        String fileSize = sc.nextLine();
//        double speed =  criteria.getSpeed(startTime)/1000000000.0;
        long security = criteria.getSecurity(plainText, encryptedData);
        data.add(new Data(algo, fileSize, speed, usedBefore, usedAfter, security));
        System.out.println();
    }//GEN-LAST:event_txt_bobActionPerformed

    private void radio_asymmetricActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radio_asymmetricActionPerformed
        // TODO add your handling code here:
        showPanel(panel_bobKey, panel_bobAsymmetric);
        showPanel(panel_aliceKey, panel_aliceAsymmetric);
        radio_RSA.setEnabled(true);
        radio_DES.setEnabled(false);
        radio_BLOWFISH.setEnabled(false);
        radio_AES.setEnabled(false);
        radio_MD5.setEnabled(false);
        this.typeOfCryptography = "asymmetric";
    }//GEN-LAST:event_radio_asymmetricActionPerformed

    private void radio_symmetricActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radio_symmetricActionPerformed
        // TODO add your handling code here:
        showPanel(panel_bobKey, panel_bobSymmetric);
        showPanel(panel_aliceKey, panel_aliceSymmetric);
        radio_RSA.setEnabled(false);
        radio_DES.setEnabled(true);
        radio_BLOWFISH.setEnabled(true);
        radio_AES.setEnabled(true);
        radio_MD5.setEnabled(true);
        this.typeOfCryptography = "symmetric";
    }//GEN-LAST:event_radio_symmetricActionPerformed

    private void btn_algoStatisticsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_algoStatisticsActionPerformed
        // TODO add your handling code here:
        new CriteriaTable(data  ).setVisible(true);
    }//GEN-LAST:event_btn_algoStatisticsActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Main().setVisible(true);
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_algoStatistics;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JLabel lbl_BG;
    private javax.swing.JLabel lbl_aliceLoading;
    private javax.swing.JLabel lbl_bobLoading;
    private javax.swing.JLabel lbl_hacking;
    private javax.swing.JPanel panel_actions;
    private javax.swing.JPanel panel_alice;
    private javax.swing.JPanel panel_aliceAsymmetric;
    private javax.swing.JPanel panel_aliceBody;
    private javax.swing.JPanel panel_aliceHeader;
    private javax.swing.JPanel panel_aliceKey;
    private javax.swing.JPanel panel_aliceLoading;
    private javax.swing.JPanel panel_aliceSymmetric;
    private javax.swing.JPanel panel_bob;
    private javax.swing.JPanel panel_bobAsymmetric;
    private javax.swing.JPanel panel_bobBody;
    private javax.swing.JPanel panel_bobHeader;
    private javax.swing.JPanel panel_bobKey;
    private javax.swing.JPanel panel_bobLoading;
    private javax.swing.JPanel panel_bobSymmetric;
    private javax.swing.JPanel panel_hacker;
    private javax.swing.JPanel panel_hackerHeader;
    private javax.swing.JPanel panel_main;
    private javax.swing.JRadioButton radio_AES;
    private javax.swing.JRadioButton radio_BLOWFISH;
    private javax.swing.JRadioButton radio_DES;
    private javax.swing.JRadioButton radio_MD5;
    private javax.swing.JRadioButton radio_RSA;
    private javax.swing.JRadioButton radio_asymmetric;
    private javax.swing.JRadioButton radio_symmetric;
    private javax.swing.JTextField txt_alice;
    private javax.swing.JTextField txt_bob;
    private javax.swing.JTextArea txtarea_alice;
    private javax.swing.JTextArea txtarea_bob;
    private javax.swing.JTextArea txtarea_hacker;
    // End of variables declaration//GEN-END:variables
}
