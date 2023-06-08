import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class FastCash extends JFrame implements ActionListener {

    JButton n100, n200, n500, n2000, back;
    String cardNo;

    FastCash(String cardNo) {

        setTitle("FAST CASH PAGE");
        setLayout(null);

        this.cardNo = cardNo;

        ImageIcon i1 = new ImageIcon(getClass().getResource("/images/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 795, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 795);
        add(image);

        JLabel text = new JLabel("PLEASE SELECT THE AMOUNT");
        text.setFont(new Font("Raleway", Font.BOLD, 19));
        text.setBounds(218, 250, 700, 40);
        text.setForeground(Color.BLACK);
        image.add(text);

        n100 = new JButton("100");
        n100.setFont(new Font("Raleway", Font.BOLD, 14));
        n100.setBounds(160, 345, 200, 28);
        n100.addActionListener(this);
        image.add(n100);

        n200 = new JButton("200");
        n200.setFont(new Font("Raleway", Font.BOLD, 13));
        n200.setBounds(370, 345, 200, 28);
        n200.addActionListener(this);
        image.add(n200);

        n500 = new JButton("500");
        n500.setFont(new Font("Raleway", Font.BOLD, 14));
        n500.setBounds(160, 380, 200, 28);
        n500.addActionListener(this);
        image.add(n500);

        n2000 = new JButton("2000");
        n2000.setFont(new Font("Raleway", Font.BOLD, 14));
        n2000.setBounds(370, 380, 200, 28);
        n2000.addActionListener(this);
        image.add(n2000);

        back = new JButton("BACK");
        back.setFont(new Font("Raleway", Font.BOLD, 14));
        back.setBounds(370, 450, 200, 28);
        back.addActionListener(this);
        image.add(back);


        // MANDATORY THINGS
        getContentPane().setBackground(Color.WHITE);
        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);

    }

    public static void main(String[] args) {
        new FastCash("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String amount = null;
        if (ae.getSource() == back) {
            setVisible(false);
            new ATMPage(this.cardNo).setVisible(true);
        } else if (ae.getSource() == n100) {
            amount = "100";
        } else if (ae.getSource() == n200) {
            amount = "200";
        } else if (ae.getSource() == n500) {
            amount = "500";
        } else if (ae.getSource() == n2000) {
            amount = "2000";
        }
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
                    if (withDrawingAmount > amountFromDB) {
                        JOptionPane.showMessageDialog(null, "Insufficient amount in the account");
                    } else {
                        updatedAmount = amountFromDB - withDrawingAmount;

                    }
                    // Perform the update
                    String updateQuery = "UPDATE details SET amount = " + updatedAmount + " WHERE accountNo = '" + this.cardNo + "'";
                    int rowsAffected = c.s.executeUpdate(updateQuery);
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
