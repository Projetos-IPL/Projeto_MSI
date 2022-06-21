package pt.ipleiria.ti.utils;

import pt.ipleiria.ti.datamodel.ErrorMessage;

import javax.swing.*;

public class Error {

    public static void showErrorMessage(ErrorMessage message) {
        JOptionPane.showMessageDialog(null, message, "Erro", JOptionPane.ERROR_MESSAGE);
    }
}
