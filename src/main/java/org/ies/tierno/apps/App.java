package org.ies.tierno.apps;

import org.ies.tierno.exceptions.ApartmentNotFoundExceptions;
import org.ies.tierno.exceptions.OptionOutOfMenuException;

public interface App{
    void run() throws ApartmentNotFoundExceptions, OptionOutOfMenuException;
}
