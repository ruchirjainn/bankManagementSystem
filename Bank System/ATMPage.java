// *****************CODE BY RUCHIR JAIN******************
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ATMPage extends JFrame implements ActionListener {

    JButton deposit, cashWithDrawal, fastCash, miniStatmenet, pinChange, balanceEnquiry, exit;
    String cardNo;

    ATMPage(String cardNumber) {
        setTitle("TRANSACTION PAGE");
        setLayout(null);

        this.cardNo = cardNumber;

        ImageIcon i1 = new ImageIcon(getClass().getResource("/images/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 795, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 795);
        add(image);

        JLabel text = new JLabel("PLEASE SELECT YOUR TRANSACTION");
        text.setFont(new Font("Raleway", Font.BOLD, 19));
        text.setBounds(180, 250, 700, 40);
        text.setForeground(Color.BLACK);
        image.add(text);

        deposit = new JButton("DEPOSIT");
        deposit.setFont(new Font("Raleway", Font.BOLD, 14));
        deposit.setBounds(160, 345, 200, 28);
        deposit.addActionListener(this);
        image.add(deposit);

        cashWithDrawal = new JButton("CASH WITHDRAWAL");
        cashWithDrawal.setFont(new Font("Raleway", Font.BOLD, 13));
        cashWithDrawal.setBounds(370, 345, 200, 28);
        cashWithDrawal.addActionListener(this);
        image.add(cashWithDrawal);

        fastCash = new JButton("FAST CASH");
        fastCash.setFont(new Font("Raleway", Font.BOLD, 14));
        fastCash.setBounds(160, 380, 200, 28);
        fastCash.addActionListener(this);
        image.add(fastCash);

        miniStatmenet = new JButton("MINI STATEMENT");
        miniStatmenet.setFont(new Font("Raleway", Font.BOLD, 14));
        miniStatmenet.setBounds(370, 380, 200, 28);
        miniStatmenet.addActionListener(this);
        image.add(miniStatmenet);

        pinChange = new JButton("PIN CHANGE");
        pinChange.setFont(new Font("Raleway", Font.BOLD, 14));
        pinChange.setBounds(160, 415, 200, 28);
        pinChange.addActionListener(this);
        image.add(pinChange);

        balanceEnquiry = new JButton("BALANCE ENQUIRY");
        balanceEnquiry.setFont(new Font("Raleway", Font.BOLD, 13));
        balanceEnquiry.setBounds(370, 415, 200, 28);
        balanceEnquiry.addActionListener(this);
        image.add(balanceEnquiry);

        exit = new JButton("EXIT");
        exit.setFont(new Font("Raleway", Font.BOLD, 14));
        exit.setBounds(370, 450, 200, 28);
        exit.addActionListener(this);
        image.add(exit);


        // MANDATORY THINGS
        getContentPane().setBackground(Color.WHITE);
        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ATMPage("");
    }


    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exit) {
            setVisible(false);
            new Login().setVisible(true);
        } else if (ae.getSource() == deposit) {
            setVisible(false);
            new Deposit(cardNo).setVisible(true);
        } else if (ae.getSource() == cashWithDrawal) {
            setVisible(false);
            new Withdrawal(cardNo).setVisible(true);
        } else if (ae.getSource() == fastCash) {
            setVisible(false);
            new FastCash(cardNo).setVisible(true);

        } else if (ae.getSource() == miniStatmenet) {
            setVisible(false);
            new MiniStatement(cardNo).setVisible(true);

        } else if (ae.getSource() == pinChange) {
            setVisible(false);
            new PinChange(cardNo).setVisible(true);
        } else if (ae.getSource() == balanceEnquiry) {
            setVisible(false);
            new BalanceEnquiry(cardNo).setVisible(true);

        }


    }
}
