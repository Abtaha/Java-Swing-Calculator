import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame{
    private JPanel mainPanel;
    private JTextField Output;

    private JButton Button0;
    private JButton Button1;
    private JButton Button2;
    private JButton Button3;
    private JButton Button4;
    private JButton Button5;
    private JButton Button6;
    private JButton Button7;
    private JButton Button8;
    private JButton Button9;

    private JButton DecButton;
    private JButton OpenBrButton;
    private JButton CloseBrButton;

    private JButton DELButton;
    private JButton ACButton;
    private JButton MulButton;
    private JButton DivButton;
    private JButton AddButton;
    private JButton SubButton;
    private JButton EqualsButton;
    private JButton sinButton;

    private JButton cosButton;
    private JButton tanButton;
    private JButton sqButton;
    private JButton sqrtButton;
    private JButton asinButton;
    private JButton atanButton;
    private JButton acosButton;
    private JButton logButton;
    private JButton piButton;
    private JButton eulerButton;
    private JButton absButton;
    private JButton lnButton;


    public GUI(){
        super("Calculator");


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setMaximumSize(new Dimension(300, 800));

        actions();

        this.pack();
    }

    private void actions(){
        JButton numButtons[] = {Button0, Button1, Button2, Button3, Button4, Button5, Button6, Button7, Button8, Button9};
        for (JButton button:numButtons) {
            button.addActionListener(e -> Output.setText(Output.getText() + button.getText()));
        }

        JButton commandButtons[] = {DecButton, OpenBrButton, CloseBrButton, MulButton, DivButton, SubButton, AddButton};
        for (JButton button:commandButtons) {
            button.addActionListener(e -> Output.setText(Output.getText() + button.getText()));
        }

        JButton trigFunc[] = {sinButton, cosButton, tanButton, asinButton, acosButton, atanButton};
        for (JButton button:trigFunc) {
            button.addActionListener(e -> Output.setText(Output.getText() + button.getText() + "("));
        }

        logButton.addActionListener(e -> Output.setText(Output.getText() + "log10("));
        lnButton.addActionListener(e -> Output.setText(Output.getText() + "ln("));
        absButton.addActionListener(e -> Output.setText(Output.getText() + "abs("));

        piButton.addActionListener(e -> Output.setText(Output.getText() + "π"));
        eulerButton.addActionListener(e -> Output.setText(Output.getText() + "e"));

        sqButton.addActionListener(e -> Output.setText(Output.getText() + "^2"));
        sqrtButton.addActionListener(e -> Output.setText(Output.getText() + "sqrt("));

        ACButton.addActionListener(e -> Output.setText(""));
        DELButton.addActionListener(e -> {
            if (Output.getText().length() > 0)
                Output.setText(Output.getText().substring(0, Output.getText().length() - 1));
        });

        Logic logic = new Logic();
        EqualsButton.addActionListener(e -> Output.setText(logic.solve(Output.getText())));
    }
}
