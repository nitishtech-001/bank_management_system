
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SignupTwo extends JFrame implements ActionListener{
    //declaring variable global so access on click btn
    JTextField inputAdharNo,inputPanNo;
    JComboBox<String> selectReligion,selectCategory,selectEducation,selectIncome,selectOccupation;
    JRadioButton seniorCitizenYes,seniorCitizenNo,existingAcYes,existingAcNo;
    int formNo;
    SignupTwo(int formNo) {
        this.formNo = formNo;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM PAGE 2");
        setBackground(Color.WHITE);

        // default value for the attributes
        int Fx = 200, Fy = 70, Iw = 380, Ih = 30;
        // Header Additional information
        JLabel title = new JLabel("Page 2: Additional Information");
        title.setFont(new Font("Raleway", Font.BOLD, 22));
        title.setBounds(Fx, Fy, Iw, Ih);
        add(title);

        // default setting for the attributes
        Fx = 100;
        Fy = 150;
        Iw = 300;
        Ih = 30;
        int IFx = 300;
        Font font = new Font("Raleway", Font.CENTER_BASELINE, 20);

        // Religion
        JLabel religion = new JLabel("Religion:");
        religion.setFont(font);
        religion.setBounds(Fx, Fy, Iw, Ih);
        add(religion);
        String arrReligions[] = {"Hindu","Muslim","Sikh","Chirstian","Other"};
        selectReligion = new JComboBox<String>(arrReligions);
        selectReligion.setFont(font);
        selectReligion.setBounds(IFx,Fy,Iw,Ih);
        add(selectReligion);

        // Category
        Fy += 50;
        JLabel category = new JLabel("Category:");
        category.setFont(font);
        category.setBounds(Fx, Fy, Iw, Ih);
        add(category);
        String arrCategory[] = {"General","OBC","SC","ST","Other"};
        selectCategory = new JComboBox<String>(arrCategory);
        selectCategory.setFont(font);
        selectCategory.setBounds(IFx,Fy,Iw,Ih);
        add(selectCategory);

        // Income
        Fy += 50;
        JLabel income = new JLabel("Income:");
        income.setFont(font);
        income.setBounds(Fx, Fy, Iw, Ih);
        add(income);
        String arrIncome[] = {"null","< 1,50,000","< 2,50,000","< 5,00,000","Upto 10,00,000"};
        selectIncome = new JComboBox<String>(arrIncome);
        selectIncome.setFont(font);
        selectIncome.setBounds(IFx,Fy,Iw,Ih);
        add(selectIncome);

        // Education qualification
        Fy += 50;
        JLabel education = new JLabel("Educational");
        education.setFont(font);
        education.setBounds(Fx, Fy, Iw, Ih);
        add(education);
        Fy += 20;
        JLabel qualification = new JLabel("Qualification:");
        qualification.setFont(font);
        qualification.setBounds(Fx, Fy, Iw, Ih);
        add(qualification);
        String arrEducation[] = {"Matriculate","Intermediate","Graduate","Post-Graduate","Doctory","Engineering","Other"};
        selectEducation = new JComboBox<String>(arrEducation);
        selectEducation.setFont(font);
        selectEducation.setBounds(IFx,Fy,Iw,Ih);
        add(selectEducation);

        // Occupation
        Fy += 50;
        JLabel occupation = new JLabel("Occupation");
        occupation.setFont(font);
        occupation.setBounds(Fx, Fy, Iw, Ih);
        add(occupation);
        String arrOccupation[] = {"Salaried","Self Employed","Businessman","House Wife","Student","Retired","Other"};
        selectOccupation = new JComboBox<String>(arrOccupation);
        selectOccupation.setFont(font);
        selectOccupation.setBounds(IFx,Fy,Iw,Ih);
        add(selectOccupation);
        
        // Pan card
        Fy += 50;
        JLabel panCard = new JLabel("PAN Number:");
        panCard.setFont(font);
        panCard.setBounds(Fx, Fy, Iw, Ih);
        add(panCard);
        inputPanNo = new JTextField();
        inputPanNo.setFont(font);
        inputPanNo.setBounds(IFx,Fy,Iw,Ih);
        add(inputPanNo);


        // Adhar Number
        Fy += 50;
        JLabel adharNumber = new JLabel("Aadhar Number:");
        adharNumber.setFont(font);
        adharNumber.setBounds(Fx, Fy, Iw, Ih);
        add(adharNumber);
        inputAdharNo = new JTextField();
        inputAdharNo.setFont(font);
        inputAdharNo.setBounds(IFx,Fy,Iw,Ih);
        add(inputAdharNo);

        // Senior Citizen
        Fy += 50;
        JLabel seniorCitizen = new JLabel("Senior Citizen:");
        seniorCitizen.setFont(font);
        seniorCitizen.setBounds(Fx, Fy, Iw, Ih);
        add(seniorCitizen);

        seniorCitizenYes = new JRadioButton("Yes");
        seniorCitizenYes.setFont(font);
        seniorCitizenYes.setBounds(IFx+30,Fy,Iw-150,Ih);

        seniorCitizenNo = new JRadioButton("No");
        seniorCitizenNo.setFont(font);
        seniorCitizenNo.setBounds(IFx+250,Fy,Iw-150,Ih);

        add(seniorCitizenYes);
        add(seniorCitizenNo);
        ButtonGroup seniorCitizenGroup = new ButtonGroup();
        seniorCitizenGroup.add(seniorCitizenYes);
        seniorCitizenGroup.add(seniorCitizenNo);

        // Existing account Number
        Fy += 50;
        JLabel existingAc = new JLabel("Existing Account:");
        existingAc.setFont(font);
        existingAc.setBounds(Fx, Fy, Iw, Ih);
        add(existingAc);

        existingAcYes = new JRadioButton("Yes");
        existingAcYes.setFont(font);
        existingAcYes.setBounds(IFx+30,Fy,Iw-150,Ih);

        existingAcNo = new JRadioButton("No");
        existingAcNo.setFont(font);
        existingAcNo.setBounds(IFx+250,Fy,Iw-150,Ih);

        add(existingAcYes);
        add(existingAcNo);
        ButtonGroup existingAcGroup = new ButtonGroup();
        existingAcGroup.add(existingAcYes);
        existingAcGroup.add(existingAcNo);

        //adding the submit btn
        Fy+=50;
        JButton btnSubmit = new JButton("NEXT");
        btnSubmit.setFont(font);
        btnSubmit.setBounds(IFx+150,Fy,150,40);
        btnSubmit.setBackground(Color.BLACK);
        btnSubmit.setForeground(Color.WHITE);
        add(btnSubmit);
        btnSubmit.addActionListener(this);
        btnSubmit.setFocusPainted(false);


        setSize(750, 830);
        setLocation(550, 20);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new SignupTwo(25);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        String strReligion = (String) selectReligion.getSelectedItem();
        String strCategory = (String) selectCategory.getSelectedItem();
        String strIncome = (String) selectIncome.getSelectedItem();
        String strEducation = (String) selectEducation.getSelectedItem();
        String strOccupation = (String) selectOccupation.getSelectedItem();
        String strPanNo = inputPanNo.getText();
        String strAdharNo = inputAdharNo.getText();

        String strSeniorCitizen;
        if(seniorCitizenYes.isSelected()){
            strSeniorCitizen = "Yes";
        }else if(seniorCitizenNo.isSelected()){
            strSeniorCitizen = "No";
        }else{
            JOptionPane.showMessageDialog(null, "Checkout the Senior Citizen option!!");
            return ;
        }
        String strExistingAc;
        if(existingAcYes.isSelected()){
            strExistingAc = "Yes";
        }else if(existingAcNo.isSelected()){
            strExistingAc = "No";
        }else{
            JOptionPane.showMessageDialog(null, "Checkout the Existing Account option!!");
            return ;
        }
        try {
            if(strPanNo.isEmpty()){
                JOptionPane.showMessageDialog(null, "Enter the PAN Number!");
                return ;
            }else if(strAdharNo.isEmpty()){
                JOptionPane.showMessageDialog(null, "Enter the Aadhar Card Number!");
                return ;
            }
            //connection to the database
            String query = "INSERT INTO signuptwo VALUES ('"+formNo+"','"+strReligion+"','"+strCategory+"','"+strIncome+"','"+strEducation+"','"+strOccupation+"','"+strPanNo+"','"+strAdharNo+"','"+strSeniorCitizen+"','"+strExistingAc+"')";
            Connect c = new Connect();
            c.s.executeUpdate(query);
            System.out.println("Data Added To SIGNUPTWO Table Successfully !!");
            new SignupThree(formNo);
            dispose();
        } catch (Exception error) {
            System.out.print(error);
        }
    }
}
