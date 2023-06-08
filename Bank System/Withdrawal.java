// *****************CODE BY RUCHIR JAIN******************
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Withdrawal extends JFrame implements ActionListener {


    JTextField amountTextField;
    JButton withDrawal, back;
    String cardNo;

    Withdrawal(String cardNo) {

        setTitle("WITHDRAW PAGE");
        setLayout(null);

        this.cardNo = cardNo;

        ImageIcon i1 = new ImageIcon(getClass().getResource("/images/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 795, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 795);
        add(image);

        JLabel text = new JLabel("ENTER THE AMOUNT YOU WANT TO WITHDRAW");
        text.setFont(new Font("Raleway", Font.BOLD, 15));
        text.setBounds(180, 250, 700, 40);
        text.setForeground(Color.BLACK);
        image.add(text);

        amountTextField = new JTextField();
        amountTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        amountTextField.setBounds(200, 320, 320, 25);
        image.add(amountTextField);

        withDrawal = new JButton("With-Draw");
        withDrawal.setFont(new Font("Raleway", Font.BOLD, 14));
        withDrawal.setBounds(355, 370, 150, 30);
        withDrawal.addActionListener(this);
        image.add(withDrawal);

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
        new Withdrawal("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
            new ATMPage(this.cardNo).setVisible(true);
        } else if (ae.getSource() == withDrawal) {
            String amount = amountTextField.getText();
            try {
                if (amount.equals("")) {
                    JOptionPane.showMessageDialog(null, "Enter amount to be debited");
                } else {
                    Conn c = new Conn();
                    String query = "SELECT amount FROM details WHERE accountNo='" + this.cardNo + "'";
                    ResultSet rs = c.s.executeQuery(query);

                    if (rs.next()) {
                        int amountFromDB = rs.getInt("amount");
                        int withDrawingAmount = Integer.parseInt(amount);
                        int updatedAmount = 0;

                        LocalDate currentDate = LocalDate.now();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                        String formattedDate = currentDate.format(formatter);


                        if (withDrawingAmount > amountFromDB) {
                            JOptionPane.showMessageDialog(null, "Insufficient amount in the account");
                        } else {
                            updatedAmount = amountFromDB - withDrawingAmount;

                        }
                        // Perform the update
                        String updateQuery = "UPDATE details SET amount = " + updatedAmount + " WHERE accountNo = '" + this.cardNo + "'";
                        int rowsAffected = c.s.executeUpdate(updateQuery);
                        String query2 = "insert into transaction values('" + this.cardNo + "','Withdraw','" + amount + "','" + formattedDate + "')";
                        c.s.executeUpdate(query2);
                        if (rowsAffected > 0) {
                            JOptionPane.showMessageDialog(null, "Amount debited Successfully!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Failed to withdraw amount");
                        }
                    }

                    rs.close();
                    c.s.close();

                    setVisible(false);
                    new ATMPage(this.cardNo).setVisible(true);
                }
            } catch (Exception e) {
                System.out.println(e);
            }


        }

    }
}
