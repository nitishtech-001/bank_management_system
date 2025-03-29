
import java.awt.*;
import java.net.URL;
// import java.sql.Date;
import java.sql.*;
import java.time.LocalTime;

import javax.swing.*;
import java.awt.event.*;

public class Donation extends JFrame implements ActionListener {
    JPasswordField inputPin;
    JButton btnRs50, btnRs100, btnRs200, btnRs250, btnRs500, btnRs750, btnRs1000, btnBack;
    String pin, cardNo;

    Donation(String cardNo, String pin) {
        this.cardNo = cardNo;
        this.pin = pin;
        setLayout(null);
        getContentPane().setBackground(Color.BLACK);

        // Adding Image to the frame
        URL imgIconUrl = getClass().getResource("/images/atm.jpg");
        ImageIcon imgIcon;
        Image img;
        if (imgIconUrl != null) {
            imgIcon = new ImageIcon(imgIconUrl);
            img = imgIcon.getImage().getScaledInstance(750, 760, Image.SCALE_DEFAULT);
        } else {
            System.out.println("Image is not found!");
            return;
        }
        imgIcon = new ImageIcon(img);
        JLabel labelImage = new JLabel(imgIcon);
        labelImage.setBounds(0, 0, 750, 830);
        add(labelImage);

        // header
        JLabel title = new JLabel("DONATION INTERFACE");
        title.setFont(new Font("Raleway", Font.BOLD, 24));
        title.setBounds(210, 6, 300, 20);
        title.setForeground(Color.GREEN);
        labelImage.add(title);

        // Text for ask amount to Donation
        JLabel header = new JLabel("Select Amount For Donation...");
        header.setFont(new Font("System", Font.ITALIC, 18));
        header.setBounds(170, 325, 250, 20);
        header.setForeground(Color.WHITE);
        labelImage.add(header);

        // for pin text and input
        JLabel textPin = new JLabel("Pin:");
        textPin.setFont(new Font("Raleway", Font.BOLD, 16));
        textPin.setForeground(Color.GREEN);
        textPin.setBounds(170, 380, 120, 22);
        labelImage.add(textPin);

        inputPin = new JPasswordField();
        inputPin.setFont(new Font("System", Font.CENTER_BASELINE, 18));
        inputPin.setBounds(240, 380, 180, 22);
        labelImage.add(inputPin);

        // Default values for Butons
        int Fx = 140, Fy = 415, Iw = 130, Ih = 27;
        Font font = new Font("Raleway", Font.BOLD, 16);
        // Color white = new Color(0,0,0);
        Color gray = new Color(128, 128, 128);

        // button for 100 withdraw
        btnRs50 = new JButton("Rs 50");
        btnRs50.setFont(font);
        btnRs50.setBounds(Fx, Fy, Iw, Ih);
        btnRs50.setBackground(gray);
        btnRs50.setForeground(Color.GREEN);
        btnRs50.setFocusPainted(false);
        labelImage.add(btnRs50);

        // button for 500 withdraw
        btnRs100 = new JButton("Rs 100");
        btnRs100.setFont(font);
        btnRs100.setBounds(Fx + 150, Fy, Iw, Ih);
        btnRs100.setFocusPainted(false);
        btnRs100.setBackground(gray);
        btnRs100.setForeground(Color.GREEN);
        labelImage.add(btnRs100);

        // button for 1000 withdraw
        btnRs200 = new JButton("Rs 200");
        btnRs200.setFont(font);
        btnRs200.setBounds(Fx, Fy + 32, Iw, Ih);
        btnRs200.setFocusPainted(false);
        btnRs200.setBackground(gray);
        btnRs200.setForeground(Color.GREEN);
        labelImage.add(btnRs200);

        // button for 2000 withdraw
        btnRs250 = new JButton("Rs 250");
        btnRs250.setFont(font);
        btnRs250.setBounds(Fx + 150, Fy + 32, Iw, Ih);
        btnRs250.setFocusPainted(false);
        btnRs250.setBackground(gray);
        btnRs250.setForeground(Color.GREEN);
        labelImage.add(btnRs250);

        // button for 5000 withdraw
        btnRs500 = new JButton("Rs 500");
        btnRs500.setFont(font);
        btnRs500.setBounds(Fx, Fy + 64, Iw, Ih);
        btnRs500.setFocusPainted(false);
        btnRs500.setBackground(gray);
        btnRs500.setForeground(Color.GREEN);
        labelImage.add(btnRs500);

        // button for 10000 withdraw
        btnRs750 = new JButton("Rs 750");
        btnRs750.setFont(font);
        btnRs750.setBounds(Fx + 150, Fy + 64, Iw, Ih);
        btnRs750.setFocusPainted(false);
        btnRs750.setBackground(gray);
        btnRs750.setForeground(Color.GREEN);
        labelImage.add(btnRs750);

        // button for 15000 withdraw
        btnRs1000 = new JButton("Rs 1000");
        btnRs1000.setFont(font);
        btnRs1000.setBounds(Fx, Fy + 95, Iw, Ih);
        btnRs1000.setFocusPainted(false);
        btnRs1000.setBackground(gray);
        btnRs1000.setForeground(Color.GREEN);
        labelImage.add(btnRs1000);

        // btn Back
        btnBack = new JButton("BACK");
        btnBack.setFont(new Font("System", Font.BOLD, 18));
        btnBack.setBounds(290, 512, 130, 25);
        btnBack.setForeground(Color.GREEN);
        btnBack.setBackground(Color.GRAY);
        labelImage.add(btnBack);

        // Adding the action listener for both buttons
        btnRs50.addActionListener(this);
        btnRs100.addActionListener(this);
        btnRs200.addActionListener(this);
        btnRs250.addActionListener(this);
        btnRs500.addActionListener(this);
        btnRs750.addActionListener(this);
        btnRs1000.addActionListener(this);
        btnBack.addActionListener(this);

        // focus text button border to fasle
        btnRs50.setFocusPainted(false);
        btnRs100.setFocusPainted(false);
        btnRs200.setFocusPainted(false);
        btnRs250.setFocusPainted(false);
        btnRs500.setFocusPainted(false);
        btnRs750.setFocusPainted(false);
        btnRs1000.setFocusPainted(false);
        btnBack.setFocusPainted(false);

        setLocation(550, 20);
        setSize(750, 830);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }


    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == btnBack) {
            dispose();
            new Transaction(cardNo, pin);
            return ;
        }
        String strPin = String.valueOf(inputPin.getPassword());
        if (strPin.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Enter The Pin First!");
            return;
        }else if(strPin.equals(pin)){
            String strAmount = event.getActionCommand().substring(3);
            Date date = new Date(System.currentTimeMillis());
            try {
                Connect c = new Connect();
                String queryCheckBalance = "SELECT balance FROM login WHERE card_no = '" + cardNo + "' AND pin = '"
                        + pin + "'";
                ResultSet balance = c.s.executeQuery(queryCheckBalance);
                if (balance.next()) {
                    String strBalance = balance.getString("balance");
                    if (Long.parseLong(strBalance) < Long.parseLong(strAmount) + 100) {
                        JOptionPane.showMessageDialog(null, "Insufficient Balance!");
                        return;
                    }
                    strBalance = "" + (Long.parseLong(strBalance) - Long.parseLong(strAmount));
                    LocalTime localTime = LocalTime.now();
                    String time = (""+localTime).substring(0,8);
                    String query = "INSERT INTO transaction VALUES ('" + cardNo + "','Donation','" + strAmount + "','"
                            + date + "','"+time+"' )";
                    c.s.executeUpdate(query);
                    String queryUpdateBal = "UPDATE login SET balance = '" + strBalance + "' WHERE card_no = '"
                            + cardNo + "' AND pin = '" + pin + "'";
                    c.s.executeUpdate(queryUpdateBal);
                    JOptionPane.showMessageDialog(null,
                            "Donation Rs." + strAmount + " Debited From Your Account Succesfully!");
                    dispose();
                    new Transaction(cardNo, pin);
                }else{
                    JOptionPane.showInternalMessageDialog(null, "User Not Found in Database!");
                    return;
                }
                c.disconnect();
            } catch (Exception error) {
                System.out.println(error);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Pin is incorrect!");
        }
    }
}
