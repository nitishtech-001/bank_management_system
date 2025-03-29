import java.awt.*;
import java.net.URL;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

public class CardInfo extends JFrame implements ActionListener {
    JPasswordField inputPin, inputNewPin, inputConfirmNewPin;
    JButton btnChange, btnBack, btnPinChange;
    String pin, cardNo;
    JLabel labelImage;

    CardInfo(String cardNo, String pin) {
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
        labelImage = new JLabel(imgIcon);
        labelImage.setBounds(0, 0, 750, 830);
        add(labelImage);

        // header
        JLabel title = new JLabel("CARD INFO AND PIN CHANGE");
        title.setFont(new Font("Raleway", Font.BOLD, 24));
        title.setBounds(190, 6, 360, 20);
        title.setForeground(Color.GREEN);
        labelImage.add(title);

        // fetching the name of the owner
        String name = "";
        String balance = "";
        try {
            String queryName = "SELECT * FROM Login WHERE card_no = '" + cardNo + "' AND pin ='" + pin
                    + "'";
            Connect c = new Connect();
            ResultSet resultName = c.s.executeQuery(queryName);
            if (resultName.next()) {
                name = resultName.getString("customer_name");
                balance = resultName.getString("balance");
            } else {
                System.out.println("That user does not exist!");
            }
        } catch (Exception error) {
            System.out.println(error);
            return;
        }
        // Text for ask amount to Deposit
        JLabel header = new JLabel(name + " Card Information...");
        header.setFont(new Font("System", Font.ITALIC, 18));
        header.setBounds(170, 305, 250, 20);
        header.setForeground(Color.WHITE);
        labelImage.add(header);

        // text Showing card number
        JLabel textCardno = new JLabel("Card No:");
        textCardno.setFont(new Font("Raleway", Font.BOLD, 16));
        textCardno.setForeground(Color.GREEN);
        textCardno.setBounds(170, 340, 120, 22);
        labelImage.add(textCardno);

        JLabel strCardNumber = new JLabel("  " + cardNo.substring(0,6)+"XXXXXX"+cardNo.substring(12));
        strCardNumber.setFont(new Font("Raleway", Font.BOLD, 16));
        strCardNumber.setBackground(Color.GRAY);
        strCardNumber.setOpaque(true);
        strCardNumber.setBounds(240, 340, 180, 22);
        labelImage.add(strCardNumber);

        // text showeinf Balance
        JLabel textBal = new JLabel("Balance:");
        textBal.setFont(new Font("Raleway", Font.BOLD, 16));
        textBal.setForeground(Color.GREEN);
        textBal.setBounds(170, 367, 120, 22);
        labelImage.add(textBal);

        JLabel textBalValue = new JLabel("  Rs " + balance);
        textBalValue.setFont(new Font("Raleway", Font.BOLD, 16));
        textBalValue.setBackground(Color.GRAY);
        textBalValue.setOpaque(true);
        textBalValue.setBounds(240, 367, 180, 22);
        labelImage.add(textBalValue);

        // Button for pin change
        btnChange = new JButton("Change");
        btnChange.setFont(new Font("System", Font.BOLD, 18));
        btnChange.setBounds(290, 480, 130, 28);
        btnChange.setForeground(Color.GREEN);
        btnChange.setBackground(Color.GRAY);
        labelImage.add(btnChange);

        // btn Back
        btnBack = new JButton("BACK");
        btnBack.setFont(new Font("System", Font.BOLD, 18));
        btnBack.setBounds(290, 512, 130, 25);
        btnBack.setForeground(Color.GREEN);
        btnBack.setBackground(Color.GRAY);
        labelImage.add(btnBack);

        // Adding the action listener for both buttons
        btnChange.addActionListener(this);
        btnBack.addActionListener(this);

        // focus text button border to fasle
        btnChange.setFocusPainted(false);
        btnBack.setFocusPainted(false);

        showPinChangeLayout(false);
        setLocation(550, 20);
        setSize(750, 830);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void showPinChangeLayout(boolean wantPinChange) {
        if (!wantPinChange) {
            if (btnPinChange == null) {
                // BUTTON FOR ASKIING TO CHNAGE THE PIN
                btnPinChange = new JButton("WANT'S PIN CHANGE");
                btnPinChange.setFont(new Font("Raleway", Font.ITALIC, 16));
                btnPinChange.setBounds(190, 480, 220, 28);
                btnPinChange.setBackground(Color.WHITE);
                btnPinChange.setForeground(Color.RED);
                labelImage.add(btnPinChange);
                btnPinChange.setFocusPainted(false);
                btnPinChange.addActionListener(this);
                btnChange.setVisible(false);
            } else {
                labelImage.remove(btnPinChange); // Remove old button if switching to PIN change
                btnPinChange = null;
            }
            labelImage.revalidate();
            labelImage.repaint();
        } else {
            labelImage.revalidate();
            labelImage.repaint();

            JLabel textPin = new JLabel("Old Pin:");
            textPin.setFont(new Font("Raleway", Font.BOLD, 16));
            textPin.setForeground(Color.GREEN);
            textPin.setBounds(170, 395, 200, 22);
            labelImage.add(textPin);

            inputPin = new JPasswordField();
            inputPin.setFont(new Font("System", Font.CENTER_BASELINE, 16));
            inputPin.setBounds(240, 395, 180, 22);
            labelImage.add(inputPin);

            // For New pin
            JLabel textNewPin = new JLabel("New Pin:");
            textNewPin.setBackground(Color.RED);
            textNewPin.setFont(new Font("Raleway", Font.BOLD, 16));
            textNewPin.setForeground(Color.GREEN);
            textNewPin.setBounds(170, 422, 200, 22);
            labelImage.add(textNewPin);

            inputNewPin = new JPasswordField();
            inputNewPin.setFont(new Font("System", Font.CENTER_BASELINE, 16));
            inputNewPin.setBounds(240, 422, 180, 22);
            labelImage.add(inputNewPin);

            // Confirm new pin
            JLabel textConfirmNewPin = new JLabel("Confirm Pin:");
            textConfirmNewPin.setFont(new Font("Raleway", Font.BOLD, 16));
            textConfirmNewPin.setForeground(Color.GREEN);
            textConfirmNewPin.setBounds(145, 450, 200, 22);
            labelImage.add(textConfirmNewPin);

            inputConfirmNewPin = new JPasswordField();
            inputConfirmNewPin.setFont(new Font("System", Font.CENTER_BASELINE, 16));
            inputConfirmNewPin.setBounds(240, 450, 180, 22);
            labelImage.add(inputConfirmNewPin);

            btnChange.setVisible(true);
        }

    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == btnPinChange) {
            btnPinChange.setVisible(false);
            showPinChangeLayout(true);
            // new CardInfo(cardNo, pin);
        } else if (event.getSource() == btnChange) {
            String strPin = String.valueOf(inputPin.getPassword());
            if (strPin.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Enter The Pin Number!");
                return;
            } else if (strPin.equals(pin)) {
                String newPin = String.valueOf(inputNewPin.getPassword());
                String confirmNewPin = String.valueOf(inputConfirmNewPin.getPassword());
                if (!newPin.equals(confirmNewPin) || newPin == null || newPin.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Retype Pin, Enter data Mismatch!!");
                    return;
                }
                try {
                    pin = String.valueOf(inputConfirmNewPin.getPassword());
                    Connect c = new Connect();
                    String queryChnagePin = "UPDATE login  SET pin = '" + pin + "' WHERE card_no = '" + cardNo + "'";
                    c.s.executeUpdate(queryChnagePin);
                    JOptionPane.showMessageDialog(null, "Pin Changed Succesfully!");
                    dispose();
                    new Transaction(cardNo, pin);
                } catch (Exception error) {
                    System.out.println(error);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Pin is incorrect!");
            }
        } else {
            dispose();
            new Transaction(cardNo, pin);
        }
    }
}
