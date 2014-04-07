package dp.ievleva.gui;

import dp.ievleva.logic.Converter;
import dp.ievleva.logic.TemperatureType;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConverterListener implements ActionListener {
    private JTextField input;
    private JTextField output;
    private JLabel labelInputField;
    private JLabel labelOutputField;
    private TemperatureType inputType = TemperatureType.F;

    public ConverterListener(JTextField input, JTextField output, JLabel labelInputField, JLabel labelOutputField) {
        this.input = input;
        this.output = output;
        this.labelInputField = labelInputField;
        this.labelOutputField = labelOutputField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String currentInput = input.getText();

        if ("Convert".equals(e.getActionCommand())) {

            if ("°F".equals(labelInputField.getText())) {
                inputType = TemperatureType.F;
            } else {
                inputType = TemperatureType.C;
            }

            Double result = Converter.degreeConvert(Double.parseDouble(currentInput), inputType);
            output.setText(String.valueOf(result));

        } else if ("Switch".equals(e.getActionCommand())) {
            input.setText("");
            output.setText("");

            if (inputType.getTempType().equals(labelInputField.getText())) {

                labelInputField.setText(TemperatureType.C.getTempType());
                labelOutputField.setText(TemperatureType.F.getTempType());

            } else {

                labelInputField.setText(TemperatureType.F.getTempType());
                labelOutputField.setText(TemperatureType.C.getTempType());

            }
        }
    }
}
