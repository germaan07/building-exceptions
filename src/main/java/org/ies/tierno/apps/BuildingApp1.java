package org.ies.tierno.apps;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.log4j.Log4j;
import org.ies.tierno.exceptions.ApartmentNotFoundExceptions;
import org.ies.tierno.exceptions.OptionOutOfMenuException;
import org.ies.tierno.model.Building;
import org.ies.tierno.model.Owner;
import org.ies.tierno.readers.scannerReaders.BuildingScannerReader;

import java.util.InputMismatchException;
import java.util.Scanner;

@Data
@AllArgsConstructor
@Log4j
public class BuildingApp1 implements App{
    Scanner scanner;
    BuildingScannerReader buildingReader;

    @Override
    public void run() throws ApartmentNotFoundExceptions, OptionOutOfMenuException {
        Building building = buildingReader.read();
        menu(building);
    }

    private void printMenu(){
        log.info("1. Mostrar apartamentos.");
        log.info("2. Ver apartamento.");
        log.info("3. Ver propietarios de apartamento.");
        log.info("4. Salir.");
    }

    private int selectOption() throws OptionOutOfMenuException{
        Integer optionSelected = null;
        do {
            try{
                log.info("Introduce la opción que desea realizar: ");
                optionSelected = scanner.nextInt();
            }catch (InputMismatchException e){
                log.error("La opción debe ser un número: ");
            } finally {
                scanner.nextLine();
            }
        } while (optionSelected == null);
        if (optionSelected > 4 || optionSelected < 1){
            return optionSelected;
        }
        throw new OptionOutOfMenuException(optionSelected);
    }

    private void menu(Building building) throws OptionOutOfMenuException, ApartmentNotFoundExceptions {
        int optionSelected = 0;
        do {
            printMenu();
            optionSelected = selectOption();

            if (optionSelected == 1){
                optionOne(building);
            } else if (optionSelected == 2){
                optionTwo(building);
            } else if (optionSelected == 3){
                optionThree(building);
            }
        } while (optionSelected!=4);
    }

    private void optionOne(Building building){
        building.showApartments();
    }

    private void optionTwo(Building building) throws ApartmentNotFoundExceptions {
        int floor = getFloor();
        String door = getDoor();

        building.getApartment(floor, door).showInfo();
    }

    private String getDoor() {
        log.info("Introduce la puerta: ");
        String door = scanner.nextLine();
        return door;
    }

    private int getFloor() {
        log.info("Introduce la planta: ");
        int floor = scanner.nextInt();
        scanner.nextLine();
        return floor;
    }

    private void optionThree(Building building) throws ApartmentNotFoundExceptions {
        int floor = getFloor();
        String door = getDoor();

        building.getOwners(floor, door).forEach(Owner::showInfo);
    }
}
