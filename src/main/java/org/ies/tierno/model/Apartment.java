package org.ies.tierno.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.log4j.Log4j;
import org.ies.tierno.exceptions.OwnerNotFoundExcepcions;

import java.util.List;

@Data
@AllArgsConstructor
@Log4j
public class Apartment {
    private int floor;
    private String door;
    private List<Owner> owners;

    public boolean showInfo(){
        log.info("Número de planta: " + floor);
        log.info("Puerta: " + door);
        for (Owner o : owners) {
            o.showInfo();
        }
        return true;
    }

    public boolean thisApartment(int floor, String door){
        if (floor == this.floor){
            if (door.equals(this.door)){
                return true;
            }
        }
        return false;
    }

    public Owner getOwner(String name, String surname) throws OwnerNotFoundExcepcions {
        for (Owner o : owners){
            if (o.exist(name, surname)){
                return o;
            }
        }
        throw new OwnerNotFoundExcepcions(name, surname);
    }
}
