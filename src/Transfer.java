
import java.awt.*;
import java.net.URL;
// import java.sql.Date;
import java.sql.*;
import java.time.LocalTime;

import javax.swing.*;
import java.awt.event.*;

public class Transfer extends JFrame implements ActionListener {
    JTextField inputTransfer, inputCardno;
    JPasswordField inputPin;
    JButton btnTransfer, btnBack;
    String pin, cardNo;

    Transfer(String cardNo, String pin) {
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
            System.out.println("Image is not found");
            return;
        }
        imgIcon = new ImageIcon(img);
        JLabel labelImage = new JLabel(imgIcon);
        labelImage.setBounds(0, 0, 750, 830);
        add(labelImage);

        // header
        JLabel title = new JLabel("TRANSFER INTERFACE");
        title.setFont(new Font("Raleway", Font.BOLD, 24));
        title.setBounds(240, 6, 300, 20);
        title.setForeground(Color.GREEN);
        labelImage.add(title);

        // Text for ask amount to Transfer
        JLabel amount = new JLabel("Enter Card No To Transfer...");
        amount.setFont(new Font("System", Font.ITALIC, 18));
        amount.setBounds(170, 300, 240, 20);
        amount.setForeground(Color.WHITE);
        labelImage.add(amount);

        // Card number to transfer
        JLabel cardNumber = new JLabel("Card No:");
        cardNumber.setFont(new Font("Raleway", Font.BOLD, 16));
        cardNumber.setForeground(Color.GREEN);
        cardNumber.setBounds(170, 340, 120, 22);
        labelImage.add(cardNumber);

        inputCardno = new JTextField();
        inputCardno.setFont(new Font("System", Font.CENTER_BASELINE, 18));
        inputCardno.setBounds(240, 340, 180, 22);
        labelImage.add(inputCardno);

        // text field for the amount input
        JLabel textAmount = new JLabel("Amount:");
        textAmount.setFont(new Font("Raleway", Font.BOLD, 16));
        textAmount.setForeground(Color.GREEN);
        textAmount.setBounds(170, 380, 120, 22);

        labelImage.add(textAmount);
        inputTransfer = new JTextField();
        inputTransfer.setFont(new Font("System", Font.CENTER_BASELINE, 18));
        inputTransfer.setBounds(240, 380, 180, 22);
        labelImage.add(inputTransfer);

        // for pin text and input
        JLabel textPin = new JLabel("Pin:");
        textPin.setFont(new Font("Raleway", Font.BOLD, 16));
        textPin.setForeground(Color.GREEN);
        textPin.setBounds(170, 420, 120, 22);
        labelImage.add(textPin);

        inputPin = new JPasswordField();
        inputPin.setFont(new Font("System", Font.CENTER_BASELINE, 18));
        inputPin.setBounds(240, 420, 180, 22);
        labelImage.add(inputPin);

        // btn Transfer
        btnTransfer = new JButton("Transfer");
        btnTransfer.setFont(new Font("System", Font.BOLD, 18));
        btnTransfer.setBounds(290, 480, 130, 28);
        btnTransfer.setForeground(Color.GREEN);
        btnTransfer.setBackground(Color.GRAY);
        labelImage.add(btnTransfer);

        // btn Back
        btnBack = new JButton("BACK");
        btnBack.setFont(new Font("System", Font.BOLD, 18));
        btnBack.setBounds(290, 512, 130, 25);
        btnBack.setForeground(Color.GREEN);
        btnBack.setBackground(Color.GRAY);
        labelImage.add(btnBack);

        // Adding the action listener for both buttons
        btnTransfer.addActionListener(this);
        btnBack.addActionListener(this);

        // focus text button border to fasle
        btnTransfer.setFocusPainted(false);
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
            return;
        }
        String userCardNo = inputCardno.getText();
        String strAmount = inputTransfer.getText();
        String strPin = String.valueOf(inputPin.getPassword());
        if (userCardNo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Enter The Card Number Where You Want To Transfer!");
            return;
        } else if (userCardNo.length() > 16) {
            JOptionPane.showMessageDialog(null, "Card Number Should be 16 Digit!");
            return;
        } else if (strAmount.isEmpty() || Long.parseLong(strAmount) < 10) {
            JOptionPane.showMessageDialog(null, "Enter The Valid Amount!");
            return;
        } else if (strPin.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Enter The Pin Number!");
            return;
        } else if (!strPin.equals(pin)) {
            JOptionPane.showMessageDialog(null, "Pin is incorrect!");
            return;
        } else {
            Date date = new Date(System.currentTimeMillis());
            try {
                Connect c = new Connect();
                // Checking that user Exist or not
                String queryFind = "SELECT * FROM login WHERE card_no = '" + userCardNo + "' ";
                ResultSet userFind = c.s.executeQuery(queryFind);
                if (!userFind.next()) {
                    JOptionPane.showMessageDialog(null, "User Not Found For This Card Number!!");
                    return;
                }
                String queryPrevBal = "SELECT balance FROM login WHERE card_no = '" + cardNo + "' AND pin = '" + pin
                        + "' ";
                ResultSet balance = c.s.executeQuery(queryPrevBal);
                if (balance.next()) {
                    // inserting into the BANK Table
                    String strBalance = balance.getString("balance");
                    // updating the existing balance to the new
                    if (Long.parseLong(strBalance) < Long.parseLong(strAmount) + 100) {
                        JOptionPane.showMessageDialog(null, "Insuficient Balance!");
                        return;
                    }
                    strBalance = "" + (Long.parseLong(strBalance) - Long.parseLong(strAmount));
                    LocalTime localTime = LocalTime.now();
                    String time = ("" + localTime).substring(0, 8);
                    // INSERTING THE TRANSACTION OF THE SENDER INFORMATION
                    String Transfer = "Transfer(" + userCardNo.substring(12) + ")";
                    String query = "INSERT INTO transaction VALUES ('" + cardNo + "','" + Transfer + "','" + strAmount
                            + "','"
                            + date + "','" + time + "')";
                    c.s.executeUpdate(query);
                    // UPDATING THE BALANCE OF THE SENDER IN LOGIN TABLE
                    String queryUpdateBal = "UPDATE login SET balance = '" + strBalance + "' WHERE card_no = '" + cardNo
                            + "' AND pin = '" + pin + "'";
                    c.s.executeUpdate(queryUpdateBal);

                    // INSERTING THE TRANSACTION OF THE RECEIVER INFORMATION
                    String Deposite = "Deposite(" + cardNo.substring(12) + ")";
                    String queryCardnoBal = "INSERT INTO transaction VALUES ('" + userCardNo + "','" + Deposite + "','"
                            + strAmount + "','"
                            + date + "','" + time + "')";
                    c.s.executeUpdate(queryCardnoBal);

                    // INSERTING THE TRANSACTION OF THE SENDER IN LOGIN TABLE
                    String queryPrevUserBal = "SELECT balance FROM login WHERE card_no = '" + userCardNo + "' ";
                    ResultSet userBalance = c.s.executeQuery(queryPrevUserBal);
                    if (userBalance.next()) {
                        // inserting into the BANK Table
                        String strUserBalance = userBalance.getString("balance");
                        // updating the existing balance to the new
                        strUserBalance = "" + (Long.parseLong(strUserBalance) + Long.parseLong(strAmount));
                        String queryUpdateUserBal = "UPDATE login SET balance = '" + strUserBalance
                                + "' WHERE card_no = '"
                                + userCardNo + "'";
                        c.s.executeUpdate(queryUpdateUserBal);
                        JOptionPane.showMessageDialog(null, "Rs "+strAmount+" Transfer Succesfully!");
                    } else {
                        JOptionPane.showMessageDialog(null, "User does not exist or Some internal error");
                        return;
                    }
                    c.disconnect();
                    dispose();
                    new Transaction(cardNo, pin);
                } else {
                    JOptionPane.showMessageDialog(null, "User Balance Not found!");
                    return;
                }
            } catch (Exception error) {
                System.out.println(error);
            }
        }

    }
}
