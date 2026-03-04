package org.ies.tierno.readers.scannerReaders;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.ies.tierno.model.Owner;
import org.ies.tierno.readers.Reader;

import java.util.Scanner;

@AllArgsConstructor
@Log4j
public class OwnerScannerReader implements Reader<Owner> {
    Scanner scanner;

    @Override
    public Owner read() {
        log.info("Introduce el NOMBRE del propietario: ");
        String name = readName();

        log.info("Introduce los APELLIDO del propietario: ");
        String surname = readSurname();

        return new Owner(name, surname);
    }

    public String readName() {
        String name = null;
        boolean cont = false;
        while (!cont){
            try {
                name = scanner.nextLine();
            } catch (NullPointerException e) {
                log.error("El nombre no puede estar vacío");
            } finally {
                cont = true;
            }
        }
        return name;
    }

    public String readSurname() {
        String surname = null;
        boolean cont = false;
        while (!cont){
            try {
                surname = scanner.nextLine();
            } catch (NullPointerException e) {
                log.error("Los apellidos no pueden estar vacíos");
            } finally {
                cont = true;
            }
        }
        return surname;
    }
}