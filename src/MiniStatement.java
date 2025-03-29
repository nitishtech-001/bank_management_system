
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.ResultSet;

import javax.swing.*;
// import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableModel;

public class MiniStatement extends JFrame implements ActionListener {
    String cardNo, pin;
    String columns[] = { "Type", "Amount", "Date", "Time" };
    String[][] data;
    JButton btnCheck, btnBack;
    JPasswordField inputPin;
    JLabel labelImage;

    MiniStatement(String cardNo, String pin) {
        this.cardNo = cardNo;
        this.pin = pin;
        setLayout(null);
        getContentPane().setBackground(Color.BLACK);

        // Title for the ministatement
        URL imageUrl = getClass().getResource("/images/atm.jpg");
        ImageIcon imgIcon;
        Image img;
        if (imageUrl != null) {
            imgIcon = new ImageIcon(imageUrl);
            img = imgIcon.getImage().getScaledInstance(1550, 760, Image.SCALE_DEFAULT);
        } else {
            System.out.println("Image not found");
            return;
        }
        imgIcon = new ImageIcon(img);
        labelImage = new JLabel(imgIcon);
        labelImage.setBounds(0, 0, 1050, 830);
        add(labelImage);

        // header
        JLabel title = new JLabel("MINI STATEMENT INTERFACE");
        title.setFont(new Font("Raleway", Font.BOLD, 24));
        title.setBounds(200, 6, 570, 20);
        title.setForeground(Color.GREEN);
        labelImage.add(title);

        String name = "", balance = "0";
        try {
            Connect c = new Connect();
            String queryNameBalance = "SELECT * FROM login WHERE card_no = '" + cardNo + "'";
            ResultSet result = c.s.executeQuery(queryNameBalance);
            if (result.next()) {
                name = result.getString("customer_name");
                balance = result.getString("balance");
            } else {
                System.out.println("User not found");
            }
            c.disconnect();
        } catch (Exception error) {
            System.out.println("User not found!");
        }

        // Greeting
        JLabel greet = new JLabel("Hello, ");
        greet.setFont(new Font("System", Font.BOLD, 22));
        greet.setBounds(200, 50, 100, 22);
        labelImage.add(greet);

        JLabel greetName = new JLabel(name);
        greetName.setFont(new Font("System", Font.BOLD, 22));
        greetName.setForeground(Color.BLUE);
        greetName.setBounds(265, 50, 400, 22);
        labelImage.add(greetName);

        // bank balance
        JLabel labelBal = new JLabel("your Current Balance: ");
        labelBal.setFont(new Font("System", Font.BOLD, 22));
        labelBal.setBounds(200, 80, 300, 28);
        labelImage.add(labelBal);

        JLabel balvalue = new JLabel("Rs " + balance);
        balvalue.setForeground(Color.BLUE);
        balvalue.setFont(new Font("System", Font.BOLD, 22));
        balvalue.setBounds(450, 80, 200, 24);
        labelImage.add(balvalue);

        // Greeting
        JLabel infoText = new JLabel("Enter the pin to See the Mini Statement.... ");
        infoText.setForeground(Color.BLACK);
        infoText.setFont(new Font("System", Font.BOLD, 20));
        infoText.setBounds(200, 120, 600, 24);
        labelImage.add(infoText);

        // Greeting
        JLabel textPin = new JLabel("PIN : ");
        textPin.setFont(new Font("System", Font.BOLD, 20));
        textPin.setBounds(200, 160, 100, 20);
        labelImage.add(textPin);

        inputPin = new JPasswordField();
        inputPin.setFont(new Font("System", Font.BOLD, 18));
        inputPin.setBounds(300, 160, 200, 22);
        labelImage.add(inputPin);

        btnCheck = new JButton("Check Mini statement");
        btnCheck.setFont(new Font("Ststem", Font.BOLD, 20));
        btnCheck.setBackground(Color.BLACK);
        btnCheck.setForeground(Color.GREEN);
        btnCheck.setBounds(250, 200, 250, 35);
        labelImage.add(btnCheck);
        btnCheck.setFocusPainted(false);
        btnCheck.addActionListener(this);

        // Back button
        btnBack = new JButton("BACK");
        btnBack.setFont(new Font("Ststem", Font.BOLD, 20));
        btnBack.setBackground(Color.BLACK);
        btnBack.setForeground(Color.GREEN);
        btnBack.setBounds(550, 200, 150, 35);
        labelImage.add(btnBack);
        btnBack.setFocusPainted(false);
        btnBack.addActionListener(this);

        setLocation(550, 20);
        setSize(750, 830);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    public void showMiniStatement() {
        labelImage.revalidate();
        labelImage.repaint();
        // Create Table Model and JTable
        DefaultTableModel model = new DefaultTableModel(data, columns);
        JTable table = new JTable(model);
        table.setBackground(Color.BLACK);
        table.setForeground(Color.WHITE);
        table.setRowHeight(24);
        table.setFont(new Font("System", Font.BOLD, 14));
        table.getTableHeader().setBackground(Color.DARK_GRAY);
        table.getTableHeader().setForeground(Color.WHITE);
        table.getTableHeader().setFont(new Font("System", Font.BOLD, 16));
        // Add table to scroll pane
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(14, 294, 637, 250);
        labelImage.add(scrollPane);
    }


    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == btnBack) {
            dispose();
            new Transaction(cardNo, pin);
            return;
        }
        String strPin = String.valueOf(inputPin.getPassword());
        if (strPin.isEmpty() || strPin == null) {
            JOptionPane.showMessageDialog(null, "Enter The Pin First!");
            return;
        } else if (!strPin.equals(pin)) {
            JOptionPane.showMessageDialog(null, "Password is incorrect!");
            return;
        }
        try {
            Connect c = new Connect();
            String query = "SELECT * FROM transaction WHERE card_no = '" + cardNo + "'";
            ResultSet result = c.s.executeQuery(query);
            int row = 0, col = 4;
            if (!result.next()) {
                JOptionPane.showMessageDialog(null, "Transaction not found!");
                return;
            }
            while (result.next()) {
                row++;
            }
            data = new String[row + 1][col];
            result = c.s.executeQuery(query);
            for (int i = 0; result.next(); i++) {
                data[i][0] = "  " + result.getString("type");
                data[i][1] = "  " + result.getString("amount");
                data[i][2] = "  " + result.getString("date").toString();
                data[i][3] = "  " + result.getString("time");
            }
            showMiniStatement();
            c.disconnect();
        } catch (Exception error) {
            System.out.println("Error : " + error);
        }
    }
}
