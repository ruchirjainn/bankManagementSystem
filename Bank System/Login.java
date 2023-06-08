// *****************CODE BY RUCHIR JAIN******************
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JTextField accountTextField, pinTextFields;
    JButton login, register, reset;

    Login() {
        setTitle("LOGIN PAGE");
        setLayout(null);


        // LABEL OF BANK
        JLabel text = new JLabel("WELCOME TO ATM");
        text.setFont(new Font("Osward", Font.BOLD, 35));
        text.setBounds(120, 30, 400, 40);
        add(text);

        //LABEL WITH TEXT FIELDS
        JLabel accountNumber = new JLabel("ACCOUNT NUMBER:");
        accountNumber.setFont(new Font("Raleway", Font.BOLD, 24));
        accountNumber.setBounds(30, 120, 300, 40);
        add(accountNumber);

        accountTextField = new JTextField();
        accountTextField.setBounds(275, 120, 225, 40);
        accountTextField.setFont(new Font("Arial", Font.BOLD, 16));
        add(accountTextField);

        JLabel pin = new JLabel("PIN NUMBER:");
        pin.setFont(new Font("Raleway", Font.BOLD, 24));
        pin.setBounds(30, 220, 300, 40);
        add(pin);

        pinTextFields = new JPasswordField();
        pinTextFields.setBounds(275, 220, 225, 40);
        pinTextFields.setFont(new Font("Arial", Font.BOLD, 16));
        add(pinTextFields);

        // BUTTONS
        login = new JButton("LOGIN");
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.setBounds(120, 300, 100, 40);
        add(login);
        login.addActionListener(this);

        reset = new JButton("RESET");
        reset.setBackground(Color.BLACK);
        reset.setForeground(Color.WHITE);
        reset.setBounds(240, 300, 100, 40);
        reset.addActionListener(this);
        add(reset);

        register = new JButton("REGISTER");
        register.setBackground(Color.BLACK);
        register.setForeground(Color.WHITE);
        register.setBounds(360, 300, 100, 40);
        register.addActionListener(this);
        add(register);


        // MANDATORY THINGS
        getContentPane().setBackground(Color.WHITE);
        setSize(600, 450);
        setVisible(true);
        setLocation(480, 200);
    }

    public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == reset) {
            accountTextField.setText("");
            pinTextFields.setText("");
        } else if (ae.getSource() == login) {
            Conn conn = new Conn();
            String cardNumber = accountTextField.getText();
            String pinNumber = pinTextFields.getText();
            String query = "select * from details where accountNo='" + cardNumber + "' and password='" + pinNumber + "'";
            try {
                ResultSet rs = conn.s.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new ATMPage(cardNumber).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin Number");
                }
            } catch (Exception e) {
                System.out.println(e);
            }

        } else if (ae.getSource() == register) {
            setVisible(false);
            new Register().setVisible(true);
        }

    }
}
