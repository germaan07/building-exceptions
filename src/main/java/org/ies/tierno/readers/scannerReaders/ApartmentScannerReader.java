package org.ies.tierno.readers.scannerReaders;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.ies.tierno.model.Apartment;
import org.ies.tierno.model.Owner;
import org.ies.tierno.readers.Reader;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

@AllArgsConstructor
@Log4j
public class ApartmentScannerReader implements Reader<Apartment> {
    Scanner scanner;
    OwnerScannerReader ownerScannerReader;

    @Override
    public Apartment read(){
        return new Apartment(getFloor(), getDoor(), getOwners());
    }

    public Integer getFloor(){
        Integer floor = null;
        do {
            try {
                log.info("Introduce la planta: ");
                floor = scanner.nextInt();
            } catch (InputMismatchException e){
                log.error("La planta debe ser un número.");
            } finally {
                scanner.nextLine();
            }
        } while (floor == null);
        return floor;
    }

    public String getDoor(){
        String door = null;
        do {
            log.info("Introduce la puerta: ");
            door = scanner.nextLine();

            if (door == null){
                log.error("La puerta no puede estar vacía.");
            }
        } while (door == null);
        return door;
    }

    private Integer getNumOwners(){
        Integer numOwners = null;
        do {
            try {
                log.info("Introduce el número de propietarios: ");
                numOwners = scanner.nextInt();
            } catch (InputMismatchException e){
                log.error("El número de propietarios debe ser un número.");
            } finally {
                scanner.nextLine();
            }
        } while (numOwners == null);
        return numOwners;
    }

    public List<Owner> getOwners(){
        int numOwners = getNumOwners();
        List<Owner> owners = new ArrayList<>();
        for (int o = 0; o < numOwners; o++){
            owners.add(ownerScannerReader.read());
        }
        return owners;
    }
}
