import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;

public class Transaction extends JFrame implements ActionListener {
    JButton btnDeposite, btnWithdraw, btnCardinfo, btnFastcash, btnTransfer, btnMiniStatement, btnDonation, btnExit;
    String cardNo, pin;

    Transaction(String strCardNo, String pin) {
        this.cardNo = strCardNo;
        this.pin = pin;
        setLayout(null);
        setLocation(550, 20);
        getContentPane().setBackground(Color.BLACK);

        // Adding Image to the frame
        URL imgIconUrl = getClass().getResource("./images/atm.jpg");
        ImageIcon imgIcon;
        Image img;
        if (imgIconUrl != null) {
            imgIcon = new ImageIcon(imgIconUrl);
            img = imgIcon.getImage().getScaledInstance(750, 760, Image.SCALE_DEFAULT);
        } else {
            System.out.println("Image is not found");
            return;
        }
        imgIcon = new ImageIcon(img);
        JLabel labelImage = new JLabel(imgIcon);
        labelImage.setBounds(0, 0, 750, 830);
        add(labelImage);

        // Adding Headre ATM_MACHINE
        // header
        JLabel atmMAchine = new JLabel("ATM MACHINE");
        atmMAchine.setFont(new Font("Raleway", Font.BOLD, 24));
        atmMAchine.setBounds(300, 6, 200, 20);
        atmMAchine.setForeground(Color.GREEN);
        labelImage.add(atmMAchine);

        // select options
        JLabel selectText = new JLabel("Please select your Transaction...");
        selectText.setFont(new Font("Raleway", Font.ITALIC, 18));
        selectText.setBounds(140, 310, 500, 24);
        selectText.setForeground(Color.WHITE);
        labelImage.add(selectText);

        // Default values for Butons
        int Fx = 140, Fy = 415, Iw = 130, Ih = 27;
        Font font = new Font("Raleway", Font.BOLD, 16);
        // Color white = new Color(0,0,0);
        Color gray = new Color(128, 128, 128);

        // Deposite button
        btnDeposite = new JButton("Deposite");
        btnDeposite.setFont(font);
        btnDeposite.setBounds(Fx, Fy, Iw, Ih);
        btnDeposite.setBackground(gray);
        btnDeposite.setForeground(Color.GREEN);
        btnDeposite.setFocusPainted(false);
        labelImage.add(btnDeposite);

        // Withdraw
        btnWithdraw = new JButton("Withdraw");
        btnWithdraw.setFont(font);
        btnWithdraw.setBounds(Fx + 150, Fy, Iw, Ih);
        btnWithdraw.setFocusPainted(false);
        btnWithdraw.setBackground(gray);
        btnWithdraw.setForeground(Color.GREEN);
        labelImage.add(btnWithdraw);

        // Card info and pin chnage button
        btnCardinfo = new JButton("Card Info");
        btnCardinfo.setFont(font);
        btnCardinfo.setBounds(Fx, Fy + 32, Iw, Ih);
        btnCardinfo.setFocusPainted(false);
        btnCardinfo.setBackground(gray);
        btnCardinfo.setForeground(Color.GREEN);
        labelImage.add(btnCardinfo);

        // Fast cash button
        btnFastcash = new JButton("Fast Cash");
        btnFastcash.setFont(font);
        btnFastcash.setBounds(Fx + 150, Fy + 32, Iw, Ih);
        btnFastcash.setFocusPainted(false);
        btnFastcash.setBackground(gray);
        btnFastcash.setForeground(Color.GREEN);
        labelImage.add(btnFastcash);

        // Donation payment
        btnDonation = new JButton("Donation");
        btnDonation.setFont(font);
        btnDonation.setBounds(Fx, Fy + 64, Iw, Ih);
        btnDonation.setFocusPainted(false);
        btnDonation.setBackground(gray);
        btnDonation.setForeground(Color.GREEN);
        labelImage.add(btnDonation);

        // Transfer money button
        btnTransfer = new JButton("Transfer");
        btnTransfer.setFont(font);
        btnTransfer.setBounds(Fx + 150, Fy + 64, Iw, Ih);
        btnTransfer.setFocusPainted(false);
        btnTransfer.setBackground(gray);
        btnTransfer.setForeground(Color.GREEN);
        labelImage.add(btnTransfer);

        // Mini statement
        btnMiniStatement = new JButton("Mini Statement");
        btnMiniStatement.setFont(font);
        btnMiniStatement.setBounds(Fx, Fy + 95, Iw, Ih);
        btnMiniStatement.setFocusPainted(false);
        btnMiniStatement.setBackground(gray);
        btnMiniStatement.setForeground(Color.GREEN);
        labelImage.add(btnMiniStatement);

        // Exit button
        btnExit = new JButton("Exit");
        btnExit.setFont(font);
        btnExit.setBounds(Fx + 150, Fy + 95, Iw, Ih);
        btnExit.setFocusPainted(false);
        btnExit.setBackground(gray);
        btnExit.setForeground(Color.GREEN);
        labelImage.add(btnExit);

        // Adding the action listenerto the all buttons
        btnDeposite.addActionListener(this);
        btnWithdraw.addActionListener(this);
        btnCardinfo.addActionListener(this);
        btnFastcash.addActionListener(this);
        btnDonation.addActionListener(this);
        btnTransfer.addActionListener(this);
        btnMiniStatement.addActionListener(this);
        btnExit.addActionListener(this);

        setSize(750, 830);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // setUndecorated(true);
        setVisible(true);
    }

    public static void main(String[] args) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnExit) {
            dispose();
        }else if(e.getSource() == btnDeposite){
            new Deposit(cardNo,pin);
            dispose();
        }
    }
}
