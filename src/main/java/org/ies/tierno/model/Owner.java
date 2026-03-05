package org.ies.tierno.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.log4j.Log4j;

@Data
@AllArgsConstructor
@Log4j
public class Owner {
    public String name;
    public String surname;

    public boolean showInfo(){
        log.info("Nombre: " + name);
        log.info("Apellido: " + surname);
        return true;
    }

    public boolean exist(String name, String surname){
        return name.equals(this.name) && surname.equals(this.surname);
    }
}
