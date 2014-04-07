package dp.ievleva.gui;


import dp.ievleva.logic.Validator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyConverterListener extends KeyAdapter{

    private JTextField input;
    private JButton convertButton;

    public KeyConverterListener(JTextField input, JButton convertButton) {
        this.input = input;
        this.convertButton = convertButton;

    }

    @Override
     public void keyTyped(KeyEvent e) {
        char typedKey = e.getKeyChar();

        if(!(Character.isDigit(typedKey) || typedKey == KeyEvent.VK_MINUS
                || typedKey == KeyEvent.VK_PERIOD)) {
            e.consume();
        }
     }

    @Override
    public void keyReleased(KeyEvent e) {
        Toolkit.getDefaultToolkit().beep();

        if(!Validator.isValid(input.getText()) || input.getText().isEmpty()) {
            input.setBorder(BorderFactory.createLineBorder(Color.RED));
            convertButton.setEnabled(false);
        } else {
            input.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
            convertButton.setEnabled(true);
        }
    }
}

