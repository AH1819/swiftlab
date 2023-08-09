package Modelo;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Hitler
 */
public class Docente extends Persona {

    @Setter
    @Getter
    Integer numero_plaza;
    @Setter
    @Getter
    String institucion;
    @Setter
    @Getter
    String correo;
}
