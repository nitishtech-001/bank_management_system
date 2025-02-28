
import java.awt.*;
import java.net.URL;
// import java.sql.Date;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

public class FastCash extends JFrame implements ActionListener {
    JTextField inputDeposit, inputPin;
    JButton btnRs100, btnRs500, btnRs1000, btnRs2000, btnRs5000, btnRs10000, btnRs15000, btnBack;
    String pin, cardNo;

    FastCash(String cardNo, String pin) {
        this.cardNo = cardNo;
        this.pin = pin;
        setLayout(null);
        getContentPane().setBackground(Color.BLACK);

        // Adding Image to the frame
        URL imgIconUrl = getClass().getResource("./images/atm.jpg");
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
        JLabel title = new JLabel("FASTCASH INTERFACE");
        title.setFont(new Font("Raleway", Font.BOLD, 24));
        title.setBounds(210, 6, 300, 20);
        title.setForeground(Color.GREEN);
        labelImage.add(title);

        // Text for ask amount to FastCash
        JLabel header = new JLabel("Select Amount For FastCash...");
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

        inputPin = new JTextField();
        inputPin.setFont(new Font("System", Font.CENTER_BASELINE, 18));
        inputPin.setBounds(240, 380, 180, 22);
        labelImage.add(inputPin);

        // Default values for Butons
        int Fx = 140, Fy = 415, Iw = 130, Ih = 27;
        Font font = new Font("Raleway", Font.BOLD, 16);
        // Color white = new Color(0,0,0);
        Color gray = new Color(128, 128, 128);

        // button for 100 withdraw
        btnRs100 = new JButton("Rs 100");
        btnRs100.setFont(font);
        btnRs100.setBounds(Fx, Fy, Iw, Ih);
        btnRs100.setBackground(gray);
        btnRs100.setForeground(Color.GREEN);
        btnRs100.setFocusPainted(false);
        labelImage.add(btnRs100);

        // button for 500 withdraw
        btnRs500 = new JButton("Rs 500");
        btnRs500.setFont(font);
        btnRs500.setBounds(Fx + 150, Fy, Iw, Ih);
        btnRs500.setFocusPainted(false);
        btnRs500.setBackground(gray);
        btnRs500.setForeground(Color.GREEN);
        labelImage.add(btnRs500);

        // button for 1000 withdraw
        btnRs1000 = new JButton("Rs 1000");
        btnRs1000.setFont(font);
        btnRs1000.setBounds(Fx, Fy + 32, Iw, Ih);
        btnRs1000.setFocusPainted(false);
        btnRs1000.setBackground(gray);
        btnRs1000.setForeground(Color.GREEN);
        labelImage.add(btnRs1000);

        // button for 2000 withdraw
        btnRs2000 = new JButton("Rs 2000");
        btnRs2000.setFont(font);
        btnRs2000.setBounds(Fx + 150, Fy + 32, Iw, Ih);
        btnRs2000.setFocusPainted(false);
        btnRs2000.setBackground(gray);
        btnRs2000.setForeground(Color.GREEN);
        labelImage.add(btnRs2000);

        // button for 5000 withdraw
        btnRs5000 = new JButton("Rs 5000");
        btnRs5000.setFont(font);
        btnRs5000.setBounds(Fx, Fy + 64, Iw, Ih);
        btnRs5000.setFocusPainted(false);
        btnRs5000.setBackground(gray);
        btnRs5000.setForeground(Color.GREEN);
        labelImage.add(btnRs5000);

        // button for 10000 withdraw
        btnRs10000 = new JButton("Rs 10000");
        btnRs10000.setFont(font);
        btnRs10000.setBounds(Fx + 150, Fy + 64, Iw, Ih);
        btnRs10000.setFocusPainted(false);
        btnRs10000.setBackground(gray);
        btnRs10000.setForeground(Color.GREEN);
        labelImage.add(btnRs10000);

        // button for 15000 withdraw
        btnRs15000 = new JButton("Rs 15000");
        btnRs15000.setFont(font);
        btnRs15000.setBounds(Fx, Fy + 95, Iw, Ih);
        btnRs15000.setFocusPainted(false);
        btnRs15000.setBackground(gray);
        btnRs15000.setForeground(Color.GREEN);
        labelImage.add(btnRs15000);

        // btn Back
        btnBack = new JButton("BACK");
        btnBack.setFont(new Font("System", Font.BOLD, 18));
        btnBack.setBounds(290, 512, 130, 25);
        btnBack.setForeground(Color.GREEN);
        btnBack.setBackground(Color.GRAY);
        labelImage.add(btnBack);

        // Adding the action listener for both buttons
        btnRs100.addActionListener(this);
        btnRs500.addActionListener(this);
        btnRs1000.addActionListener(this);
        btnRs2000.addActionListener(this);
        btnRs5000.addActionListener(this);
        btnRs10000.addActionListener(this);
        btnRs15000.addActionListener(this);
        btnBack.addActionListener(this);

        // focus text button border to fasle
        btnRs100.setFocusPainted(false);
        btnRs500.setFocusPainted(false);
        btnRs1000.setFocusPainted(false);
        btnRs5000.setFocusPainted(false);
        btnRs10000.setFocusPainted(false);
        btnRs15000.setFocusPainted(false);
        btnBack.setFocusPainted(false);

        setLocation(550, 20);
        setSize(750, 830);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new FastCash("235689797", "1234");
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == btnBack) {
            new Transaction(cardNo, pin);
            dispose();
        }
        String strPin = inputPin.getText();
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
                    if (Long.parseLong(strBalance) < Long.parseLong(strAmount) - 99) {
                        JOptionPane.showMessageDialog(null, "Insufficient Balance!");
                        return;
                    }
                    strBalance = "" + (Long.parseLong(strBalance) - Long.parseLong(strAmount));
                    String query = "INSERT INTO bank VALUES ('" + cardNo + "','FastCash','" + strAmount + "','"
                            + date + "' )";
                    c.s.executeUpdate(query);
                    String queryUpdateBal = "UPDATE login SET balance = '" + strBalance + "' WHERE card_no = '"
                            + cardNo + "' AND pin = '" + pin + "'";
                    c.s.executeUpdate(queryUpdateBal);
                    JOptionPane.showMessageDialog(null,
                            "FastCash Rs." + strAmount + " From Your Account Succesfully!");
                    new Transaction(cardNo, pin);
                    dispose();
                }else{
                    JOptionPane.showInternalMessageDialog(null, "User Not Found in Database!");
                    return;
                }
            } catch (Exception error) {
                System.out.println(error);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Pin is incorrect!");
        }
    }
}
