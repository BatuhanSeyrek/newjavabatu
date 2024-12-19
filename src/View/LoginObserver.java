package View;

import Observer.Observer;

import javax.swing.*;

public class LoginObserver implements Observer {
    private JFrame frame;

    public LoginObserver(JFrame frame) {
        this.frame = frame;
    }

    @Override
    public void update(String message) {
        JOptionPane.showMessageDialog(frame, message);
    }
}
