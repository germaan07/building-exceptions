package org.ies.tierno.exceptions;

import lombok.Data;

@Data
public class OwnerNotFoundExcepcions extends RuntimeException {
    public final String name;
    public final String surname;

    public OwnerNotFoundExcepcions(String name, String surname) {
        super("No se ha encontrado al propietario: " + name + surname);
        this.name = name;
        this.surname = surname;
    }
}
