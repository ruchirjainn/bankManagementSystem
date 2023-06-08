// *****************CODE BY RUCHIR JAIN******************
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import com.toedter.calendar.JDateChooser;


public class Register extends JFrame implements ActionListener {

    long random;
    JTextField accountTextField, nameTextField, addressTextField, cityTextField, stateTextFields, pinCodeTextFields, panTextFields, aadharTextFields, initialAmountTextField, passwordTextFields;
    JDateChooser dateChooser;
    JRadioButton male, female, r1, r2, r3, r4;
    JComboBox eduBox, categoryBox, incomeBox;
    JButton register, clear;


    Register() {
        setTitle("REGISTER PAGE");
        setLayout(null);

        JLabel personalDetails = new JLabel("PAGE : CLIENT DETAILS");
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 30));
        personalDetails.setBounds(260, 40, 400, 30);
        add(personalDetails);

        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);
        JLabel formNo = new JLabel("ACCOUNT NO:");
        formNo.setFont(new Font("Raleway", Font.BOLD, 20));
        formNo.setBounds(30, 90, 300, 40);
        add(formNo);

        accountTextField = new JTextField("" + random);
        accountTextField.setFont(new Font("Raleway", Font.BOLD, 17));
        accountTextField.setBounds(210, 91, 170, 40);
        add(accountTextField);

        JLabel name = new JLabel("NAME:");
        name.setFont(new Font("Raleway", Font.BOLD, 22));
        name.setBounds(30, 140, 300, 40);
        add(name);

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        nameTextField.setBounds(210, 140, 170, 40);
        add(nameTextField);

        JLabel dob = new JLabel("DATE OF BIRTH:");
        dob.setFont(new Font("Raleway", Font.BOLD, 22));
        dob.setBounds(30, 190, 300, 40);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(210, 193, 170, 40);
        dateChooser.setForeground(new Color(105, 105, 105));
        dateChooser.setFont(new Font("Raleway", Font.BOLD, 14));
        add(dateChooser);

        JLabel gender = new JLabel("GENDER:");
        gender.setFont(new Font("Raleway", Font.BOLD, 22));
        gender.setBounds(30, 240, 300, 40);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(210, 250, 60, 30);
        male.setBackground(Color.WHITE);
        add(male);
        female = new JRadioButton("Female");
        female.setBounds(280, 250, 120, 30);
        female.setBackground(Color.WHITE);
        add(female);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        JLabel accountType = new JLabel("ACCOUNT TYPE:");
        accountType.setFont(new Font("Raleway", Font.BOLD, 22));
        accountType.setBounds(30, 290, 300, 40);
        add(accountType);

        r1 = new JRadioButton("Saving Account");
        r1.setBounds(30, 330, 130, 20);
        r1.setBackground(Color.WHITE);
        add(r1);
        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setBounds(200, 330, 200, 20);
        r2.setBackground(Color.WHITE);
        add(r2);
        r3 = new JRadioButton("Current Account");
        r3.setBounds(30, 370, 130, 20);
        r3.setBackground(Color.WHITE);
        add(r3);
        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setBounds(200, 370, 200, 20);
        r4.setBackground(Color.WHITE);
        add(r4);

        ButtonGroup accountTypeGroup = new ButtonGroup();
        accountTypeGroup.add(r1);
        accountTypeGroup.add(r2);
        accountTypeGroup.add(r3);
        accountTypeGroup.add(r4);

        JLabel address = new JLabel("ADDRESS:");
        address.setFont(new Font("Raleway", Font.BOLD, 22));
        address.setBounds(30, 410, 300, 40);
        add(address);

        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        addressTextField.setBounds(30, 450, 363, 40);
        add(addressTextField);

        JLabel city = new JLabel("CITY:");
        city.setFont(new Font("Raleway", Font.BOLD, 22));
        city.setBounds(30, 500, 300, 40);
        add(city);

        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        cityTextField.setBounds(210, 500, 170, 40);
        add(cityTextField);

        JLabel state = new JLabel("STATE:");
        state.setFont(new Font("Raleway", Font.BOLD, 22));
        state.setBounds(30, 550, 300, 40);
        add(state);

        stateTextFields = new JTextField();
        stateTextFields.setFont(new Font("Raleway", Font.BOLD, 14));
        stateTextFields.setBounds(210, 550, 170, 40);
        add(stateTextFields);

        JLabel pinCode = new JLabel("PINCODE:");
        pinCode.setFont(new Font("Raleway", Font.BOLD, 22));
        pinCode.setBounds(30, 600, 300, 40);
        add(pinCode);

        pinCodeTextFields = new JTextField();
        pinCodeTextFields.setFont(new Font("Raleway", Font.BOLD, 14));
        pinCodeTextFields.setBounds(210, 600, 170, 40);
        add(pinCodeTextFields);

        JLabel education = new JLabel("EDUCATION & ");
        education.setFont(new Font("Raleway", Font.BOLD, 22));
        education.setBounds(420, 90, 400, 40);
        add(education);

        JLabel qualification = new JLabel("QUALIFICATION:");
        qualification.setFont(new Font("Raleway", Font.BOLD, 22));
        qualification.setBounds(420, 120, 400, 40);
        add(qualification);

        String valEdu_Qua[] = {"Non-Graduate", "Graduate", "Post-Graduate", "Doctrate", "Others"};
        eduBox = new JComboBox(valEdu_Qua);
        eduBox.setBounds(620, 105, 200, 40);
        eduBox.setBackground(Color.WHITE);
        add(eduBox);


        JLabel panNo = new JLabel("PAN NUMBER:");
        panNo.setFont(new Font("Raleway", Font.BOLD, 22));
        panNo.setBounds(420, 175, 400, 40);
        add(panNo);

        panTextFields = new JTextField();
        panTextFields.setFont(new Font("Raleway", Font.BOLD, 14));
        panTextFields.setBounds(620, 175, 200, 40);
        add(panTextFields);

        JLabel aadharNo = new JLabel("AADHAR NO:");
        aadharNo.setFont(new Font("Raleway", Font.BOLD, 22));
        aadharNo.setBounds(420, 225, 200, 40);
        add(aadharNo);

        aadharTextFields = new JTextField();
        aadharTextFields.setFont(new Font("Raleway", Font.BOLD, 14));
        aadharTextFields.setBounds(620, 225, 200, 40);
        add(aadharTextFields);

        JLabel category = new JLabel("CATEGORY:");
        category.setFont(new Font("Raleway", Font.BOLD, 22));
        category.setBounds(420, 275, 200, 40);
        add(category);

        String valCategory[] = {"OPEN", "OBC", "SC", "NT", "OTHER"};
        categoryBox = new JComboBox(valCategory);
        categoryBox.setBounds(620, 275, 200, 40);
        categoryBox.setBackground(Color.WHITE);
        add(categoryBox);

        JLabel income = new JLabel("INCOME:");
        income.setFont(new Font("Raleway", Font.BOLD, 22));
        income.setBounds(420, 325, 200, 40);
        add(income);

        String valIncome[] = {"NULL", "<1,50,000", "<2,50,000", "<5,00,000", "Upto 10,00,000"};
        incomeBox = new JComboBox(valIncome);
        incomeBox.setBounds(620, 325, 200, 40);
        incomeBox.setBackground(Color.WHITE);
        add(incomeBox);

        JLabel initialAmount = new JLabel("INITIAL AMOUNT:");
        initialAmount.setFont(new Font("Raleway", Font.BOLD, 22));
        initialAmount.setBounds(420, 375, 200, 40);
        add(initialAmount);

        initialAmountTextField = new JTextField();
        initialAmountTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        initialAmountTextField.setBounds(620, 375, 200, 40);
        add(initialAmountTextField);

        JLabel password = new JLabel("GENERATE PIN:");
        password.setFont(new Font("Raleway", Font.BOLD, 22));
        password.setBounds(420, 425, 200, 40);
        add(password);

        passwordTextFields = new JPasswordField();
        passwordTextFields.setFont(new Font("Raleway", Font.BOLD, 14));
        passwordTextFields.setBounds(620, 425, 200, 40);
        add(passwordTextFields);


        register = new JButton("REGISTER");
        register.setBackground(Color.BLACK);
        register.setForeground(Color.WHITE);
        register.setBounds(280, 670, 100, 40);
        register.addActionListener(this);
        add(register);

        clear = new JButton("CLEAR");
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.setBounds(420, 670, 100, 40);
        clear.addActionListener(this);
        add(clear);


        // MANDATORY THINGS
        getContentPane().setBackground(Color.WHITE);
        setSize(900, 800);
        setVisible(true);
        setLocation(300, 10);
    }

    public static void main(String[] args) {
        new Register();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == clear) {
            nameTextField.setText("");
            addressTextField.setText("");
            cityTextField.setText("");
            stateTextFields.setText("");
            pinCodeTextFields.setText("");
            panTextFields.setText("");
            aadharTextFields.setText("");
            initialAmountTextField.setText("");
            passwordTextFields.setText("");
        } else if (ae.getSource() == register) {
            String accountNo = "" + random;   //long   & "" converts it to string
            String name = nameTextField.getText();
            String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
            String gender = null;
            if (male.isSelected()) {
                gender = "Male";
            } else if (female.isSelected()) {
                gender = "Female";
            }
            String accountType = null;
            if (r1.isSelected()) {
                accountType = "Saving Account";
            } else if (r2.isSelected()) {
                accountType = "Fixed Deposit Account";
            } else if (r3.isSelected()) {
                accountType = "Current Account";
            } else if (r4.isSelected()) {
                accountType = "Recurring Deposit Account";
            }
            String address = addressTextField.getText();
            String city = cityTextField.getText();
            String state = stateTextFields.getText();
            String pinCode = pinCodeTextFields.getText();
            String education = (String) eduBox.getSelectedItem();
            String pan = panTextFields.getText();
            String aadhar = aadharTextFields.getText();
            String category = (String) categoryBox.getSelectedItem();
            String income = (String) incomeBox.getSelectedItem();
            String initialAmount = initialAmountTextField.getText();
            String password = passwordTextFields.getText();

            try {
                if (name.equals("") || pan.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "All Fields entries are Required");
                } else {
                    Conn c = new Conn();
                    String query = "insert into register values('" + accountNo + "','" + name + "','" + dob + "','" + gender + "','" + accountType + "','" + address + "','" + city + "','" + state + "','" + pinCode + "','" + education + "','" + pan + "','" + aadhar + "','" + category + "','" + income + "','" + initialAmount + "','" + password + "')";
                    c.s.executeUpdate(query);
                    String query2 = "insert into details values('" + accountNo + "','" + name + "','" + initialAmount + "','" + password + "')";
                    c.s.executeUpdate(query2);

                    setVisible(false);
                    new Login().setVisible(true);
                }
            } catch (Exception e) {
                System.out.println(e);
            }

        }

    }
}
