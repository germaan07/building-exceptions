package org.ies.tierno.mains;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.ies.tierno.apps.BuildingApp1;
import org.ies.tierno.exceptions.ApartmentNotFoundExceptions;
import org.ies.tierno.exceptions.OptionOutOfMenuException;
import org.ies.tierno.readers.scannerReaders.ApartmentScannerReader;
import org.ies.tierno.readers.scannerReaders.BuildingScannerReader;
import org.ies.tierno.readers.scannerReaders.OwnerScannerReader;

import java.util.Scanner;

@Data
public class BuildingApp1Main {
    public static void main(String[] args) throws ApartmentNotFoundExceptions, OptionOutOfMenuException {
        Scanner scanner = new Scanner(System.in);
        OwnerScannerReader ownerScannerReader = new OwnerScannerReader(scanner);
        ApartmentScannerReader apartmentScannerReader = new ApartmentScannerReader(scanner, ownerScannerReader)
        BuildingScannerReader buildingScannerReader = new BuildingScannerReader(scanner, apartmentScannerReader);
        BuildingApp1 buildingApp1 = new BuildingApp1(scanner, buildingScannerReader);
        
        buildingApp1.run();
    }
}
