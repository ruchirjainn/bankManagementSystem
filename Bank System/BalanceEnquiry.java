import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {

    JButton  back;
    String cardNo;
    String balanceAmount;

    BalanceEnquiry(String cardNo) {

        setTitle("BALANCE ENQUIRY PAGE");
        setLayout(null);

        this.cardNo = cardNo;

        ImageIcon i1 = new ImageIcon(getClass().getResource("/images/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 795, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 795);
        add(image);

        try {
            Conn c = new Conn();
            String query = "SELECT amount FROM details WHERE accountNo='" + this.cardNo + "'";
            ResultSet rs = c.s.executeQuery(query);
            if (rs.next()) {
                int amountFromDB = rs.getInt("amount");
                System.out.println(amountFromDB);
                balanceAmount = String.valueOf(amountFromDB);
                System.out.println(balanceAmount);
            } else {
                System.out.println("No records found for account number: " + this.cardNo);
            }
            rs.close();
            c.s.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        JLabel text = new JLabel("CURRENT BALANCE: "+balanceAmount);
        text.setFont(new Font("Raleway", Font.BOLD, 20));
        text.setBounds(200, 300, 700, 40);
        text.setForeground(Color.BLACK);
        image.add(text);


        back = new JButton("BACK");
        back.setFont(new Font("Raleway", Font.BOLD, 16));
        back.setBounds(355, 400, 150, 30);
        back.addActionListener(this);
        image.add(back);

        // MANDATORY THINGS
        getContentPane().setBackground(Color.WHITE);
        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);
    }

    public static void main(String[] args) {
        new BalanceEnquiry("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
            new ATMPage(this.cardNo).setVisible(true);
        }

    }
}
