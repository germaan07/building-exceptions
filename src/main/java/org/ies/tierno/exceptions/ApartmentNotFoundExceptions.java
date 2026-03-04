package org.ies.tierno.exceptions;

public class ApartmentNotFoundExceptions extends Exception {
  private final int floor;
  private final String door;

  public ApartmentNotFoundExceptions(int floor, String door) {
    super("No se ha encontrado el apartamento" + floor + door + ".");
    this.floor = floor;
    this.door = door;
  }
}
