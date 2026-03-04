package org.ies.tierno.readers.scannerReaders;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.ies.tierno.model.Apartment;
import org.ies.tierno.model.Building;
import org.ies.tierno.readers.Reader;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

@AllArgsConstructor
@Log4j
public class BuildingScannerReader implements Reader<Building> {
    Scanner scanner;
    ApartmentScannerReader apartmentScannerReader;

    @Override
    public Building read(){
        return new Building(getDirection(), getMunicipality(), getZipCode(), getApartments(getNumApartments()));
    }

    private String getDirection(){
        String direction = null;

        do {
            log.info("Introduce la dirección del edificio: ");
            direction = scanner.nextLine();

            if (direction == null){
                log.error("La dirección no puede estar vacía.");
            }
        } while (direction == null);

        return direction;
    }

    private String getMunicipality(){
        String municipality = null;

        do {
            log.info("Introduce el municipio del edificio: ");
            municipality = scanner.nextLine();

            if (municipality == null){
                log.error("El municipio no puede estar vacía.");
            }
        } while (municipality == null);

        return municipality;
    }

    private Integer getZipCode(){
        Integer zipCode = null;

        do {
            try {
                log.info("Introduce el código postal del edificio: ");
                zipCode = scanner.nextInt();
            } catch (InputMismatchException e){
                log.error("El código postal debe ser un número.");
            } finally {
                scanner.nextLine();
            }
        } while (zipCode == null);

        return zipCode;
    }
    private Integer getNumApartments(){
        Integer numApartments = null;

        do {
            try {
                log.info("Introduce el número de apartamentos del edificio: ");
                numApartments = scanner.nextInt();
            } catch (InputMismatchException e){
                log.error("El número de apartamentos del edificio debe ser un número.");
            } finally {
                scanner.nextLine();
            }
        } while (numApartments == null);

        return numApartments;
    }

    private List<Apartment> getApartments(int numApartments){
        List<Apartment> apartments = new ArrayList<>();

        for (int a = 0; a < numApartments; a++){
            apartments.add(apartmentScannerReader.read());
        }

        return apartments;
    }
}
