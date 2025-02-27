
import java.awt.*;
import java.net.URL;
// import java.sql.Date;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

public class Deposit extends JFrame implements ActionListener {
    JTextField inputDeposit, inputPin;
    JButton btnDeposit, btnBack;
    String pin,cardNo;

    Deposit(String cardNo,String pin) {
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
            System.out.println("Image is not found");
            return;
        }
        imgIcon = new ImageIcon(img);
        JLabel labelImage = new JLabel(imgIcon);
        labelImage.setBounds(0, 0, 750, 830);
        add(labelImage);

        // header
        JLabel title = new JLabel("Deposit INTERFACE");
        title.setFont(new Font("Raleway", Font.BOLD, 24));
        title.setBounds(240, 6, 270, 20);
        title.setForeground(Color.GREEN);
        labelImage.add(title);

        // Text for ask amount to Deposit
        JLabel amount = new JLabel("Enter Amount To Deposit...");
        amount.setFont(new Font("System", Font.ITALIC, 18));
        amount.setBounds(170, 325, 250, 20);
        amount.setForeground(Color.WHITE);
        labelImage.add(amount);

        // text field for the amount input
        JLabel textAmount = new JLabel("Amount:");
        textAmount.setFont(new Font("Raleway", Font.BOLD, 16));
        textAmount.setForeground(Color.GREEN);
        textAmount.setBounds(170, 380, 120, 22);

        labelImage.add(textAmount);
        inputDeposit = new JTextField();
        inputDeposit.setFont(new Font("System", Font.CENTER_BASELINE, 18));
        inputDeposit.setBounds(240, 380, 180, 22);
        labelImage.add(inputDeposit);

        // for pin text and input
        JLabel textPin = new JLabel("Pin:");
        textPin.setFont(new Font("Raleway", Font.BOLD, 16));
        textPin.setForeground(Color.GREEN);
        textPin.setBounds(170, 420, 120, 22);
        labelImage.add(textPin);

        inputPin = new JTextField();
        inputPin.setFont(new Font("System", Font.CENTER_BASELINE, 18));
        inputPin.setBounds(240, 420, 180, 22);
        labelImage.add(inputPin);

        // btn Deposit
        btnDeposit = new JButton("Deposit");
        btnDeposit.setFont(new Font("System", Font.BOLD, 18));
        btnDeposit.setBounds(290, 480, 130, 28);
        btnDeposit.setForeground(Color.GREEN);
        btnDeposit.setBackground(Color.GRAY);
        labelImage.add(btnDeposit);

        // btn Back
        btnBack = new JButton("BACK");
        btnBack.setFont(new Font("System", Font.BOLD, 18));
        btnBack.setBounds(290, 512, 130, 25);
        btnBack.setForeground(Color.GREEN);
        btnBack.setBackground(Color.GRAY);
        labelImage.add(btnBack);

        // Adding the action listener for both buttons
        btnDeposit.addActionListener(this);
        btnBack.addActionListener(this);

        // focus text button border to fasle
        btnDeposit.setFocusPainted(false);
        btnBack.setFocusPainted(false);

        setLocation(550, 20);
        setSize(750, 830);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Deposit("235689797","1234");
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == btnDeposit) {
            String strAmount = inputDeposit.getText();
            String strPin = inputPin.getText();
            if(strAmount.isEmpty() || Long.parseLong(strAmount) < 50){
                JOptionPane.showMessageDialog(null, "Enter The Valid Amount!");
                return;
            }else if(strPin.isEmpty()){
                JOptionPane.showMessageDialog(null, "Enter The Pin Number!");
                return;
            }else if(strPin.equals(pin)) {
                Date date = new Date(System.currentTimeMillis());
                try{
                    String query = "INSERT INTO bank VALUES ('"+cardNo+"','Deposit','"+strAmount+"','"+date+"' )";
                    Connect c = new Connect();
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Deposited "+strAmount+" To Your Account Succesfully!");
                    new Transaction(cardNo, pin);
                    dispose();
                }catch(Exception error){
                    System.out.println(error);
                }

                
            }else{
                JOptionPane.showMessageDialog(null, "Pin is incorrect!");
            }
        } else {
            new Transaction(cardNo, pin);
            dispose();
        }
    }
}
