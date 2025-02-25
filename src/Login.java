
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import javax.swing.*;

class Login extends JFrame implements ActionListener {

    // DECLARING THE BUTTONS
    JButton btnLogin, btnSignup, btnClear;
    //DECLARING TEXTFIELD
    JTextField inputCardNo;
    JPasswordField inputPin;

    Login() {
        // Creating a JFrame instanc
        // Set size of the frame (width, height)
        setTitle("AUTOMATED TELLER MACHINE");
        getContentPane().setBackground(Color.WHITE);
        // Preventing the default laout
        setLayout(null);
        // ADDING THE BACKGROUND IMAGE
        URL imgIconUrl = getClass().getResource("./images/logo.jpg");
        ImageIcon imgIcon;
        Image img ;
        if(imgIconUrl != null){
            imgIcon = new ImageIcon(imgIconUrl);
            img = imgIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        }else{
            System.out.println("Image is not found");
            return ;
        }
        imgIcon = new ImageIcon(img);
        JLabel label = new JLabel(imgIcon);
        label.setBounds(70, 10, 100, 100);
        add(label);
        // ADDING THE TEXT for the panel
        JLabel text = new JLabel("WELCOME TO NITISH ATM");
        text.setBounds(190, 40, 500, 50);
        text.setFont(new Font("Osward", Font.BOLD, 34));
        add(text);

        // ADDING THE CARD FIELD TEXT
        JLabel cardNo = new JLabel("Card No:");
        cardNo.setFont(new Font("Raieway", Font.BOLD, 22));
        cardNo.setBounds(70, 150, 100, 40);
        add(cardNo);
        // ADDING THE INPUT FIELD FOR CARD
        inputCardNo = new JTextField("");
        inputCardNo.setFont(new Font("Raieway", Font.BOLD, 22));
        inputCardNo.setBounds(200, 150, 300, 40);
        add(inputCardNo);

        // ADDING THE PIN FIELD TEXT
        JLabel pin = new JLabel("PIN :");
        pin.setFont(new Font("Raieway", Font.BOLD, 22));
        pin.setBounds(70, 210, 100, 40);
        add(pin);
        // ADDING THE INPUT FIELD FOR PIN
        inputPin = new JPasswordField("");
        inputPin.setFont(new Font("Raieway", Font.BOLD, 22));
        inputPin.setBounds(200, 210, 300, 40);
        add(inputPin);

        // CREATING THREE BUTTON 
        // SIGNUP BUTTON
        btnSignup = new JButton("SIGNUP");
        btnSignup.setFont(new Font("Raieway", Font.CENTER_BASELINE, 20));
        btnSignup.setBounds(200, 270, 130, 40);
        btnSignup.addActionListener(this);
        add(btnSignup);
        // CLEAR BUTTON
        btnClear = new JButton("CLEAR");
        btnClear.setFont(new Font("Raieway", Font.CENTER_BASELINE, 20));
        btnClear.setBounds(370, 270, 130, 40);
        btnClear.addActionListener(this);
        add(btnClear);
        // LOGIN BUTTON
        btnLogin = new JButton("LOGIN");
        btnLogin.setFont(new Font("Raieway", Font.CENTER_BASELINE, 20));
        btnLogin.setBounds(200, 330, 300, 45);
        btnLogin.addActionListener(this);
        add(btnLogin);
        setSize(700, 600);
        setLocation(350, 200);
        // set default close operation (exit the application when window is closed)
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Login();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand() == "LOGIN"){
            if(inputCardNo.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Enter the Card Number!");
                return ;
            }else if(String.valueOf(inputPin.getPassword()).isEmpty()){
                JOptionPane.showMessageDialog(null, "Ente the password!");
                return ;
            }
        }
        switch (e.getActionCommand()) {
            case "SIGNUP" -> {
                System.out.println("Clicked on SIGNUP BUTTON");
                new SignupOne();
                dispose();
                // setVisible(false);
            }
            case "CLEAR" -> {
                System.out.println("Clicked on CLEAR BUTTON");
                System.out.println(inputCardNo.getText());
                inputCardNo.setText("");
                inputPin.setText("");
            }
            default ->
                System.out.println("Clicked on LOGIN BTN BUTTON");
        }
    }
}
