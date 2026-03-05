package org.ies.tierno.exceptions;

public class OptionOutOfMenuException extends Exception {
    public final int OptionSelected;

    public OptionOutOfMenuException(int optionSelected) {
        super("La opción " + optionSelected + " no está en el menú.");
        OptionSelected = optionSelected;
    }
}
