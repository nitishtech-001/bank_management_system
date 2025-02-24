
import java.awt.*;
import java.util.Random;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener {
    // Formnumber for applicant
    long formNo;
    // JtextField
    JTextField inputName, inputFname, inputMname, inputEmail, inputAddress, inputCity, inputPincode, inputState;
    // JRadioButtons
    JRadioButton male, female, other, married, Unmarried;
    // JDateChooser input for Date of Birth
    JDateChooser inputDob;
    // next button
    JButton btnNext;

    SignupOne() {
        // creatin a jpanel to just shocasing that it is signup page
        setLayout(null);
        setTitle("NEW APPLICATION FORM PAGE 1");
        setBackground(Color.WHITE);
        // creating the Fx -> distance from frame, Fy, Ix , Ih
        int Fx = 200, Fy = 30, Iw = 380, Ih = 30;
        // creating a page name that show form no
        Random random = new Random();
        formNo = Math.abs(random.nextLong() % 10000 + 1234L);
        JLabel form = new JLabel("APPLICATION FORM NO : " + formNo);
        form.setFont(new Font("Sen-serif", Font.BOLD, 24));
        form.setBounds(Fx, Fy, Iw, Ih);
        add(form);

        // persional details
        JLabel persional = new JLabel("Page 1 : Persional Details");
        persional.setFont(new Font("Raleway", Font.CENTER_BASELINE, 22));
        persional.setBounds(Fx + 30, Fy + 30, Iw, Ih);
        add(persional);
        // setting the font for the below attricute
        Fx = 100;
        Fy = 150;
        Iw = 300;
        int IFx = 300;
        Font font = new Font("Raleway", Font.CENTER_BASELINE, 20);

        // NAME OF PERSON
        JLabel name = new JLabel("Name: ");
        name.setFont(font);
        name.setBounds(Fx, Fy, Iw, Ih);
        add(name);
        inputName = new JTextField();
        inputName.setFont(font);
        inputName.setBounds(IFx, Fy, Iw, Ih);
        add(inputName);

        // Father name
        Fy += 50;
        JLabel fname = new JLabel("Father's Name: ");
        fname.setFont(font);
        fname.setBounds(Fx, Fy, Iw, Ih);
        add(fname);
        inputFname = new JTextField();
        inputFname.setFont(font);
        inputFname.setBounds(IFx, Fy, Iw, Ih);
        add(inputFname);

        // Mother name
        Fy += 50;
        JLabel mname = new JLabel("Mother's Name: ");
        mname.setFont(font);
        mname.setBounds(Fx, Fy, Iw, Ih);
        add(mname);
        inputMname = new JTextField();
        inputMname.setFont(font);
        inputMname.setBounds(IFx, Fy, Iw, Ih);
        add(inputMname);

        // Date of Birth
        Fy += 50;
        JLabel dob = new JLabel("Date of Birth: ");
        dob.setFont(font);
        dob.setBounds(Fx, Fy, Iw, Ih);
        add(dob);
        inputDob = new JDateChooser();
        inputDob.setFont(font);
        inputDob.setBounds(IFx, Fy, Iw, Ih);
        add(inputDob);

        // Gender
        Fy += 50;
        JLabel gender = new JLabel("Gender: ");
        gender.setFont(font);
        gender.setBounds(Fx, Fy, Iw, Ih);
        add(gender);
        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        other = new JRadioButton("Other");
        male.setFont(font);
        male.setBounds(IFx, Fy, 100, Ih);
        female.setFont(font);
        female.setBounds(IFx + 100, Fy, 100, Ih);
        other.setFont(font);
        other.setBounds(IFx + 200, Fy, 100, Ih);
        add(male);
        add(female);
        add(other);
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(other);
        // Email Address
        Fy += 50;
        JLabel email = new JLabel("Email Address: ");
        email.setFont(font);
        email.setBounds(Fx, Fy, Iw, Ih);
        add(email);
        inputEmail = new JTextField();
        inputEmail.setFont(font);
        inputEmail.setBounds(IFx, Fy, Iw, Ih);
        add(inputEmail);

        // Merital status
        Fy += 50;
        JLabel mstatus = new JLabel("Merital Status: ");
        mstatus.setFont(font);
        mstatus.setBounds(Fx, Fy, Iw, Ih);
        add(mstatus);
        married = new JRadioButton("Married");
        Unmarried = new JRadioButton("UnMarried");
        married.setFont(font);
        married.setBounds(IFx, Fy, 150, Ih);
        Unmarried.setFont(font);
        Unmarried.setBounds(IFx + 150, Fy, 150, Ih);
        add(married);
        add(Unmarried);
        ButtonGroup marrageStatus = new ButtonGroup();
        marrageStatus.add(married);
        marrageStatus.add(Unmarried);
        // Address of the user
        Fy += 50;
        JLabel address = new JLabel("Address: ");
        address.setFont(font);
        address.setBounds(Fx, Fy, Iw, Ih);
        add(address);
        inputAddress = new JTextField();
        inputAddress.setFont(font);
        inputAddress.setBounds(IFx, Fy, Iw, Ih);
        add(inputAddress);

        // City name
        Fy += 50;
        JLabel city = new JLabel("City: ");
        city.setFont(font);
        city.setBounds(Fx, Fy, Iw, Ih);
        add(city);
        inputCity = new JTextField();
        inputCity.setFont(font);
        inputCity.setBounds(IFx, Fy, Iw, Ih);
        add(inputCity);

        // State name
        Fy += 50;
        JLabel state = new JLabel("State: ");
        state.setFont(font);
        state.setBounds(Fx, Fy, Iw, Ih);
        add(state);
        inputState = new JTextField();
        inputState.setFont(font);
        inputState.setBounds(IFx, Fy, Iw, Ih);
        add(inputState);

        // Pincode name
        Fy += 50;
        JLabel pincode = new JLabel("Pin Code: ");
        pincode.setFont(font);
        pincode.setBounds(Fx, Fy, Iw, Ih);
        add(pincode);
        inputPincode = new JTextField();
        inputPincode.setFont(font);
        inputPincode.setBounds(IFx, Fy, Iw, Ih);
        add(inputPincode);

        // adding the NEXT BUTTON
        Fy += 50;
        btnNext = new JButton("NEXT");
        btnNext.setFont(font);
        btnNext.setBounds(IFx + 200, Fy, 100, 40);
        btnNext.setBackground(Color.BLACK);
        btnNext.setForeground(Color.WHITE);
        add(btnNext);
        btnNext.addActionListener(this);

        setSize(750, 830);
        setLocation(550, 20);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
    }

    public static void main(String[] args) {
        new SignupOne();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int formNumber = (int) formNo;
        String name = inputName.getText();
        String fname = inputFname.getText();
        String mname = inputMname.getText();
        String dob = ((JTextField) inputDob.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (male.isSelected()) {
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";
        } else if (other.isSelected()) {
            gender = "Other";
        }
        String email = inputEmail.getText();
        String marital = null;
        if (married.isSelected()) {
            marital = "Married";
        } else if (Unmarried.isSelected()) {
            marital = "Unmarried";
        }
        String address = inputAddress.getText();
        String city = inputCity.getText();
        String state = inputState.getText();
        int pin = 1000;
        try {
            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Name is required!");
                return;
            } else if (fname.equals("")) {
                JOptionPane.showMessageDialog(null, "Father's name is required!");
                return;
            } else if (mname.equals("")) {
                JOptionPane.showMessageDialog(null, "Mother's name is required!");
                return;
            } else if (dob.equals("")) {
                JOptionPane.showMessageDialog(null, "Date of Birth is required!");
                return;
            } else if (gender.equals("")) {
                JOptionPane.showMessageDialog(null, "Gender is required!");
                return;
            } else if (marital.equals("")) {
                JOptionPane.showMessageDialog(null, "Marital status is required!");
                return;
            } else if (address.equals("")) {
                JOptionPane.showMessageDialog(null, "Address is required!");
                return;
            } else if (city.equals("")) {
                JOptionPane.showMessageDialog(null, "City is required!");
                return;
            } else if (state.equals("")) {
                JOptionPane.showMessageDialog(null, "State is required!");
                return;
            }
            if (inputPincode.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Pin code is required!");
                return;
            } else if (inputPincode.getText().length() < 3 || Integer.parseInt(inputPincode.getText()) < 1000) {
                JOptionPane.showMessageDialog(null, "Pin code must 4 digit and above 1000!");
                return;
            }
            pin = Integer.parseInt(inputPincode.getText());
            Connect c = new Connect();
            String query = "INSERT INTO signup VALUES ('" + formNumber + "','" + name + "','" + fname + "','" + mname
                    + "','" + dob + "','" + gender + "','" + email + "','" + marital + "','" + address + "','" + city
                    + "','" + state + "','" + pin + "')";

            c.s.executeUpdate(query);
            System.out.println("Data Addedd To SIGNUP Table Successfully !!!");

            new SignupTwo(formNumber);
            dispose();

        } catch (

        Exception err) {
            System.out.println(err);
        }
    }
}