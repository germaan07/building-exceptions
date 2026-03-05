package org.ies.tierno.apps;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.log4j.Log4j;
import org.ies.tierno.exceptions.OptionOutOfMenuException;

import java.util.InputMismatchException;
import java.util.Scanner;

@Data
@AllArgsConstructor
@Log4j
public class BuildingApp1 implements App<BuildingApp1>{
    Scanner scanner;
    @Override
    public void run(){
        printMenu();
    }

    private void printMenu(){
        log.info("1. Dado un número de vuelo, devuelve los pasajeros del vuelo.");
        log.info("2. Dado un número de vuelo, devuelve los clientes que son pasajeros en el vuelo.");
        log.info("3. Dado unos apellidos (String), devuelve la lista de clientes que tengan ese apellido.");
        log.info("4. Dado un número de vuelo y un nif, devuelve el asiento del pasajero. Si no existe el vuelo o el pasajero, devuelve null.");
        log.info("5. Dado un número de vuelo, un nif y un luggage, añade el luggage a ese pasajero. En caso de que no exista el vuelo o el pasajero, muestra en pantalla un mensaje de error explicativo.");
        log.info("6. Dado un nif, devuelve los vuelos en los que ese cliente es pasajero.");
        log.info("7. Salir.");
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
        if (optionSelected > 7 || optionSelected < 1){
            return optionSelected;
        }
        throw new OptionOutOfMenuException(optionSelected);
    }

    private void menu(Bui) throws OptionOutOfMenuException {
        int optionSelected = 0;
        do {
            printMenu();
            optionSelected = selectOption();

            if (optionSelected == 1){

            } else if (optionSelected == 2){

            } else if (optionSelected == 3){

            } else if (optionSelected == 4){

            } else if (optionSelected == 5){

            } else if (optionSelected == 6){

            }
        } while (optionSelected!=7);


    }
}
