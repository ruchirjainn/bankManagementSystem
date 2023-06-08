import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class PinChange extends JFrame implements ActionListener {

    JTextField pinTextField, confirmPinTextField;
    JButton change, back;
    String cardNo;

    PinChange(String cardNo) {

        setTitle("PIN CHANGE PAGE");
        setLayout(null);

        this.cardNo = cardNo;

        ImageIcon i1 = new ImageIcon(getClass().getResource("/images/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 795, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 795);
        add(image);

        JLabel newPin = new JLabel("NEW PIN:");
        newPin.setFont(new Font("Raleway", Font.BOLD, 15));
        newPin.setBounds(180, 270, 100, 40);
        newPin.setForeground(Color.BLACK);
        image.add(newPin);

        pinTextField = new JTextField();
        pinTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        pinTextField.setBounds(330, 270, 200, 40);
        image.add(pinTextField);

        JLabel confirmNewPin = new JLabel("CONFIRM NEW PIN:");
        confirmNewPin.setFont(new Font("Raleway", Font.BOLD, 15));
        confirmNewPin.setBounds(180, 320, 200, 40);
        confirmNewPin.setForeground(Color.BLACK);
        image.add(confirmNewPin);

        confirmPinTextField = new JTextField();
        confirmPinTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        confirmPinTextField.setBounds(330, 320, 200, 40);
        image.add(confirmPinTextField);

        change = new JButton("CHANGE");
        change.setFont(new Font("Raleway", Font.BOLD, 14));
        change.setBounds(355, 380, 150, 30);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("BACK");
        back.setFont(new Font("Raleway", Font.BOLD, 14));
        back.setBounds(355, 420, 150, 30);
        back.addActionListener(this);
        image.add(back);

        // MANDATORY THINGS
        getContentPane().setBackground(Color.WHITE);
        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);
    }

    public static void main(String[] args) {
        new PinChange("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
            new ATMPage(this.cardNo).setVisible(true);
        } else if (ae.getSource() == change) {
            String newPin = pinTextField.getText();
            String confirmNewPin = confirmPinTextField.getText();
            try {
                if (newPin.equals("") || confirmNewPin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Enter the necessary fields");
                } else {
                    if (newPin.equals(confirmNewPin)) {

                        Conn c = new Conn();
                        String query = "update details set password='" + confirmNewPin + "' where accountNo='" + this.cardNo + "'";
                        int rs = c.s.executeUpdate(query);
                        if (rs > 0) {
                            JOptionPane.showMessageDialog(null, "Pin number updated successfully");
                        } else {
                            JOptionPane.showMessageDialog(null, "Error! Pin number not updated ");
                        }
                        c.s.close();

                        setVisible(false);
                        new ATMPage(this.cardNo).setVisible(true);

                    } else {
                        JOptionPane.showMessageDialog(null, "New Pin & Confirm Pin doesn't match");
                    }

                }
            } catch (Exception e) {
                System.out.println(e);
            }


        }

    }
}
