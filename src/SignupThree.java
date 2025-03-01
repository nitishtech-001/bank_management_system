
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

public class SignupThree extends JFrame implements ActionListener {
    // decalering the attribute Class scope
    JRadioButton btnSavingAc, btnFixedAc, btnCurrentAc, btnRecuringAc;
    JCheckBox checkAtmCard, checkInternetBank, checkMobileBank, checkChequeBook, checkAlert, checkEStatement,
            checkStatement, checkPrivacyPolicy;
    JButton btnCancel,btnSubmit;
    int formNo;
    String customerName;
    SignupThree(int formNo,String name) {
        this.formNo = formNo;
        this.customerName = name;
        setLayout(null);
        setTitle("NEW APPLICATION FORM PAGE 1");
        setBackground(Color.WHITE);

        // default value for the attributes
        int Fx = 240, Fy = 70, Iw = 300, Ih = 30;
        // Heading for page 3
        JLabel title = new JLabel("Page 3: Account Details");
        title.setFont(new Font("Raleway", Font.BOLD, 22));
        title.setBounds(Fx, Fy, Iw, Ih);
        add(title);

        // default value for fields
        Fx = 100;
        Fy = 150;
        Iw = 300;
        int IFx = 380;
        Font font = new Font("Raleway", Font.CENTER_BASELINE, 20);

        // Type of Account
        JLabel accountType = new JLabel("Account Type:");
        accountType.setFont(font);
        accountType.setBounds(Fx, Fy, Iw, Ih);
        add(accountType);
        // radio buttons
        btnSavingAc = new JRadioButton("Saving Account");
        btnSavingAc.setFont(font);
        btnSavingAc.setBounds(Fx + 20, Fy + 40, 190, Ih);
        add(btnSavingAc);

        btnFixedAc = new JRadioButton("Fixed Deposite Account");
        btnFixedAc.setFont(font);
        btnFixedAc.setBounds(Fx + 280, Fy + 40, 270, Ih);
        add(btnFixedAc);

        btnCurrentAc = new JRadioButton("Current  Account");
        btnCurrentAc.setFont(font);
        btnCurrentAc.setBounds(Fx + 20, Fy + 80, 190, Ih);
        add(btnCurrentAc);

        btnRecuringAc = new JRadioButton("Recuring Deposite Account");
        btnRecuringAc.setFont(font);
        btnRecuringAc.setBounds(Fx + 280, Fy + 80, 300, Ih);
        add(btnRecuringAc);

        ButtonGroup btnGroupAcType = new ButtonGroup();
        btnGroupAcType.add(btnSavingAc);
        btnGroupAcType.add(btnFixedAc);
        btnGroupAcType.add(btnCurrentAc);
        btnGroupAcType.add(btnRecuringAc);

        // card number
        Fy += 150;
        JLabel cardNo = new JLabel("Card Number:");
        cardNo.setFont(font);
        cardNo.setBounds(Fx, Fy, Iw, Ih);
        add(cardNo);

        JLabel cardInfo = new JLabel("Your 16 digit CARD number...");
        cardInfo.setFont(new Font("Raleway", Font.ITALIC, 16));
        cardInfo.setBounds(Fx, Fy + 20, Iw, Ih);
        add(cardInfo);

        JLabel number = new JLabel("XXXX-XXXX-XXXX-3457");
        number.setFont(font);
        number.setBounds(IFx, Fy, Iw, Ih);
        add(number);

        // Pin Number
        Fy += 60;
        JLabel pinNo = new JLabel("PIN Number:");
        pinNo.setFont(font);
        pinNo.setBounds(Fx, Fy, Iw, Ih);
        add(pinNo);

        JLabel pinInfo = new JLabel("Your 4 digit PIN number...");
        pinInfo.setFont(new Font("Raleway", Font.ITALIC, 16));
        pinInfo.setBounds(Fx, Fy + 20, Iw, Ih);
        add(pinInfo);

        JLabel pinNumber = new JLabel("XXXX");
        pinNumber.setFont(font);
        pinNumber.setBounds(IFx, Fy, Iw, Ih);
        add(pinNumber);

        // serveses required
        Fy += 60;
        JLabel serviceReq = new JLabel("Services Required:");
        serviceReq.setFont(font);
        serviceReq.setBounds(Fx, Fy, Iw, Ih);
        add(serviceReq);

        // font fo the check box
        Fy += 40;
        Font font1 = new Font("Raleway", Font.PLAIN, 18);
        checkAtmCard = new JCheckBox("Atm Card");
        checkAtmCard.setFont(font1);
        checkAtmCard.setBounds(Fx + 20, Fy, 110, 28);
        add(checkAtmCard);

        checkInternetBank = new JCheckBox("Internet Banking");
        checkInternetBank.setFont(font1);
        checkInternetBank.setBounds(Fx + 170, Fy, 160, 28);
        add(checkInternetBank);

        checkMobileBank = new JCheckBox("Mobile Banking");
        checkMobileBank.setFont(font1);
        checkMobileBank.setBounds(Fx + 370, Fy, 150, 28);
        add(checkMobileBank);

        Fy += 35;
        checkChequeBook = new JCheckBox("Cheque Book");
        checkChequeBook.setFont(font1);
        checkChequeBook.setBounds(Fx + 20, Fy, 135, 28);
        add(checkChequeBook);

        checkAlert = new JCheckBox("Email & SMS Alert");
        checkAlert.setFont(font1);
        checkAlert.setBounds(Fx + 170, Fy, 180, 28);
        add(checkAlert);

        checkEStatement = new JCheckBox("E-Statement");
        checkEStatement.setFont(font1);
        checkEStatement.setBounds(Fx + 370, Fy, 150, 28);
        add(checkEStatement);

        checkStatement = new JCheckBox("");

        JLabel st = new JLabel("I hearby declare that all the information enter by me is correct, And it ");
        st.setBounds(Fx + 20, Fy + 50, 560, 30);
        st.setFont(new Font("Raleway", Font.ITALIC, 16));
        checkStatement.setFont(new Font("Raleway", Font.ITALIC, 16));

        JLabel st1 = new JLabel("there is any incorrect information than it is my responsibility.");
        checkStatement.setBounds(Fx, Fy + 50, 20, 30);
        st1.setBounds(Fx + 20, Fy + 60, 560, 50);
        st1.setFont(new Font("Raleway", Font.ITALIC, 16));
        checkStatement.setFont(new Font("Raleway", Font.ITALIC, 16));
        add(checkStatement);
        add(st1);
        add(st);

        // Privacy policy
        Fy += 60;
        checkPrivacyPolicy = new JCheckBox("");

        JLabel pr = new JLabel("I read the term & condition provided by the bank and I agree with that.");
        pr.setBounds(Fx + 20, Fy + 50, 560, 30);
        pr.setFont(new Font("Raleway", Font.ITALIC, 16));
        checkPrivacyPolicy.setFont(new Font("Raleway", Font.ITALIC, 16));

        JLabel pr1 = new JLabel("information an I will be cusomer of that Bank and Accept Privacy Policy.");
        checkPrivacyPolicy.setBounds(Fx, Fy + 50, 20, 30);
        pr1.setBounds(Fx + 20, Fy + 60, 560, 50);
        pr1.setFont(new Font("Raleway", Font.ITALIC, 16));
        checkPrivacyPolicy.setFont(new Font("Raleway", Font.ITALIC, 16));
        add(checkPrivacyPolicy);
        add(pr1);
        add(pr);

        // creating button
        Fy += 140;
        btnCancel = new JButton("CANCEL");
        btnCancel.setFont(new Font("Raleway", Font.BOLD, 20));
        btnCancel.setBounds(Fx + 200, Fy, 150, 40);
        btnCancel.setBackground(Color.BLACK);
        btnCancel.setForeground(Color.WHITE);
        add(btnCancel);

        btnSubmit = new JButton("SUBMIT");
        btnSubmit.setFont(new Font("Raleway", Font.BOLD, 20));
        btnSubmit.setBounds(Fx + 370, Fy, 150, 40);
        btnSubmit.setBackground(Color.BLACK);
        btnSubmit.setForeground(Color.WHITE);
        add(btnSubmit);

        btnCancel.addActionListener(this);
        btnSubmit.addActionListener(this);
        //setting the focus painted to false
        btnCancel.setFocusPainted(false);
        btnSubmit.setFocusPainted(false);
        setSize(750, 830);
        setLocation(550, 20);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new SignupThree(1966,"unknown");
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == btnCancel) {
            dispose();
            new Login();
            return;
        } else if (event.getSource() == btnSubmit) {
            String strAccountType;
            // checking that Account type is selected or not
            if (btnSavingAc.isSelected()) {
                strAccountType = "Saving";
            } else if (btnFixedAc.isSelected()) {
                strAccountType = "Fixed";
            } else if (btnRecuringAc.isSelected()) {
                strAccountType = "Recuring";
            } else if (btnCurrentAc.isSelected()) {
                strAccountType = "Current";
            } else {
                JOptionPane.showMessageDialog(null, "Please Select the Type Of Account!");
                return;
            }
            // checking that what Service required bt the customer
            String strServiceReq = "";
            if (checkAtmCard.isSelected()) {
                strServiceReq = strServiceReq + "ATM Card";
            }
            if (checkInternetBank.isSelected()) {
                strServiceReq = strServiceReq + ", Internet Banking";
            }
            if (checkMobileBank.isSelected()) {
                strServiceReq = strServiceReq + ", Mobile Banking";
            }
            if (checkChequeBook.isSelected()) {
                strServiceReq = strServiceReq + ", Cheque Book";
            }
            if (checkAlert.isSelected()) {
                strServiceReq = strServiceReq + ", SMS & EMAIL Alerts";
            }
            if (checkEStatement.isSelected()) {
                strServiceReq = strServiceReq + ", E-Statement";
            }
            if (strServiceReq.length() < 3) {
                JOptionPane.showMessageDialog(null, "Please Select Atleast One Service!");
                return;
            }

            // checking that self declaration and privacy policy is selected or not
            if (!checkStatement.isSelected()) {
                JOptionPane.showMessageDialog(null, "Please check the Self Declaration!");
                return;
            } else if (!checkPrivacyPolicy.isSelected()) {
                JOptionPane.showMessageDialog(null, "Please check the Privacy Policy!");
                return;
            }

            // Generating random number for the CARDNUMBER
            Random random = new Random();
            String strCardNo = "" + Math.abs(random.nextLong() % 900000000L + 4771100000000000L);

            String strPinNo = "" + Math.abs((random.nextLong() % 790000L + 187000L)%1000000L);
            try {
                // Query to insert in the database
                String query = "INSERT INTO signupthree VALUES ('" + formNo + "','" + strAccountType + "','" + strCardNo
                        + "','" + strPinNo + "','" + strServiceReq + "')";
                Connect c = new Connect();
                c.s.executeUpdate(query);
                // Query to add the login creadential to the Login table
                String loginQuery = "INSERT INTO login VALUES ('"+formNo+"','"+strCardNo+"','"+strPinNo+"','0','"+customerName+"')";
                System.out.println("Data Saved In SIGNUPTHREE Table Succesfully!!");
                c.s.executeUpdate(loginQuery);
                System.out.println("Login Credential Saved To LOGIN Table Succesfully!!");
                JOptionPane.showMessageDialog(null, "Your Card Number: " + strCardNo + "\n" + "PIN Code: " + strPinNo);
                dispose();
                new Deposit(strCardNo,strPinNo);
            } catch (Exception error) {
                System.out.println(error);
            }
        }
    }
}
