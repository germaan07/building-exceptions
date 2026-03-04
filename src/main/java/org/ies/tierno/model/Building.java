package org.ies.tierno.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.ies.tierno.exceptions.ApartmentNotFoundExceptions;

import java.util.List;

@Data
@AllArgsConstructor
public class Building {
    private String direction;
    private String municipality;
    private int zipCode;
    private List<Apartment> apartments;

    public boolean showApartments(){
        for (Apartment a : apartments){
            a.showInfo();
        }
        return true;
    }

    public Apartment getApartment(int floor, String door) throws ApartmentNotFoundExceptions{
        for (Apartment a : apartments){
            if (a.thisApartment(floor, door)){
                return a;
            }
        }
        throw new ApartmentNotFoundExceptions(floor, door);
    }

    public List<Owner> getOwners(int floor, String door) throws ApartmentNotFoundExceptions{
        for (Apartment a : apartments){
            if (a.thisApartment(floor, door)){
                if (!a.getOwners().isEmpty()){
                    return a.getOwners();
                }
            }
        }
        throw new ApartmentNotFoundExceptions(floor, door);
    }


}
