package pt.ipleiria.ti.utils;

import pt.ipleiria.ti.datamodel.ErrorMessage;

import javax.swing.*;
import java.awt.*;

public class Error {

    public static void showErrorMessage(Component parent, ErrorMessage message) {
        JOptionPane.showMessageDialog(parent, message, "Erro", JOptionPane.ERROR_MESSAGE);
    }
}
