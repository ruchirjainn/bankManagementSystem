// *****************CODE BY RUCHIR JAIN******************
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainPage extends JFrame implements ActionListener {

    JButton nextPage;

    MainPage() {
        setTitle("MAIN PAGE");
        setLayout(null);

        ImageIcon i1 = new ImageIcon(getClass().getResource("/images/banner2.png"));
        Image i2 = i1.getImage().getScaledInstance(1536, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(0, 0, 1536, 800);
        add(label);


        nextPage = new JButton("GET STARTED");
        nextPage.setBackground(Color.CYAN);
        nextPage.setForeground(Color.BLACK);
        nextPage.setFont(new Font("arial", Font.BOLD, 26));
        nextPage.setBounds(630, 370, 300, 50);
        nextPage.addActionListener(this);
        add(nextPage);

        // MANDATORY THINGS
        getContentPane().setBackground(Color.WHITE);
        setSize(1536, 864);
        setVisible(true);
        setLocation(0, 0);

    }

    public static void main(String[] args) {
        new MainPage();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == nextPage) {
            new Login().setVisible(true);
        }

    }
}
