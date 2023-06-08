// *****************CODE BY RUCHIR JAIN******************
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class MiniStatement extends JFrame implements ActionListener {

    String cardNo;
    JButton back;

    MiniStatement(String cardNo) {
        setTitle("FAST CASH PAGE");
        setLayout(null);

        this.cardNo = cardNo;

        JLabel text = new JLabel("TRANSACTION DETAILS:");
        text.setFont(new Font("Raleway", Font.BOLD, 28));
        text.setBounds(50, 35, 700, 40);
        text.setForeground(Color.BLACK);
        add(text);

        // Create JTextArea to display transaction details
        JTextArea transactionTextArea = new JTextArea();
        transactionTextArea.setBounds(50, 85, 800, 600);
        transactionTextArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(transactionTextArea);
        scrollPane.setBounds(50, 85, 800, 600);
        add(scrollPane);

        try {
            Conn c = new Conn();
            String query = "SELECT * FROM transaction WHERE cardNo = '" + cardNo + "'";
            ResultSet rs = c.s.executeQuery(query);

            StringBuilder miniStatement = new StringBuilder();
            while (rs.next()) {
                String type = rs.getString("type");
                double amount = rs.getDouble("amount");
                String date = rs.getString("date");

                miniStatement.append("TYPE: ").append(type).append("  ");
                miniStatement.append("AMOUNT: ").append(amount).append("  ");
                miniStatement.append("DATE: ").append(date).append("\n");
            }

            transactionTextArea.setText(miniStatement.toString());

            rs.close();
            c.s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        back = new JButton("BACK");
        back.setFont(new Font("Raleway", Font.BOLD, 14));
        back.setBounds(570, 705, 150, 30);
        back.addActionListener(this);
        add(back);

        // MANDATORY THINGS
        getContentPane().setBackground(Color.WHITE);
        setSize(900, 800);
        setLocation(300, 10);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MiniStatement("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
            new ATMPage(this.cardNo).setVisible(true);
        }
    }
}
