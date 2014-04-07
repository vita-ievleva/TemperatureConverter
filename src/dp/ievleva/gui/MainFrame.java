package dp.ievleva.gui;

import dp.ievleva.logic.TemperatureType;

import javax.swing.*;

public class MainFrame {

    public MainFrame() {
        JFrame frame = new JFrame("FC Degree Converter");
        frame.setSize(250, 210);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = createConverterPanel();

        frame.add(panel);
        frame.setVisible(true);
    }

    private JPanel createConverterPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JTextField input = new JTextField();

        JLabel labelInputField = new JLabel(TemperatureType.F.getTempType());
        labelInputField.setBounds(10, 17, 40, 30);
        panel.add(labelInputField);

        JLabel labelOutputField = new JLabel(TemperatureType.C.getTempType());
        labelOutputField.setBounds(10, 97, 40, 30);
        panel.add(labelOutputField);

        JTextField output = new JTextField();
        output.setBounds(30, 100, 200, 25);
        output.setEditable(false);
        panel.add(output);

        JButton switchButton = new JButton("Switch");
        switchButton.setBounds(80, 60, 100, 25);
        switchButton.addActionListener(new ConverterListener(input, output, labelInputField, labelOutputField));
        panel.add(switchButton);

        JButton convertButton = new JButton("Convert");
        convertButton.setBounds(80, 140, 100, 25);
        convertButton.setEnabled(false);
        convertButton.addActionListener(new ConverterListener(input, output, labelInputField, labelOutputField));
        panel.add(convertButton);

        input.setBounds(30, 20, 200, 25);
        input.addKeyListener(new KeyConverterListener(input, convertButton));

        panel.add(input);

        return panel;
    }

}