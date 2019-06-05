import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyChat extends JFrame {
//    private JButton button = new JButton("Отправить");
//    private JTextField input = new JTextField("", 2);
//    private JLabel label = new JLabel("Ввод: ");
//
//    public MyChat() {
//        super("MyChat");
//        this.setBounds(200, 200, 450, 200);
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        Container container = this.getContentPane();
//        container.setLayout(new GridLayout(3, 2, 5, 5));
//        container.add(label);
//        container.add(input);
//
//        button.addActionListener(new ButtonEventListener());
//        container.add(button);
//    }
//
//    class ButtonEventListener implements ActionListener {
//
//        public void actionPerformed (ActionEvent e) {
//            String message = "";
//            message += input.getText() + "\n";
//            JOptionPane.showMessageDialog(null, message, "Output", JOptionPane.PLAIN_MESSAGE);
//        }
//    }
//}

    JTextArea textArea;
    JTextField textMassage;

    MyChat() {
        setTitle("MyChat");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(400, 100, 600, 500);

        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(Color.GRAY);
        centerPanel.setLayout(new BorderLayout());
        add(centerPanel, BorderLayout.CENTER);

        JPanel bottonPanel = new JPanel();
        bottonPanel.setBackground(Color.BLACK);
        bottonPanel.setLayout(new BorderLayout());
        bottonPanel.setPreferredSize(new Dimension(1,60));
        add(bottonPanel, BorderLayout.SOUTH);

        JButton startButton = new JButton("Отправить");
        bottonPanel.add(startButton, BorderLayout.EAST);

        textArea = new JTextArea();
        JScrollPane textAreaScroll = new JScrollPane(textArea);
        centerPanel.add(textAreaScroll, BorderLayout.CENTER);
        textArea.setEditable(false);

        textMassage = new JTextField();
        bottonPanel.add(textMassage, BorderLayout.CENTER);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addText();
            }
        });

        textMassage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addText();
            }
        });

        setVisible(true);
    }
    void addText(){
        textArea.append(textMassage.getText() + "\n");
        textMassage.setText("");
    }

 }

