import javax.swing.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        JFrame frame = new GUI();
        frame.setSize(600,600);
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        frame.setVisible(true);
    }
}
