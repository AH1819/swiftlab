package Modelo;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Hitler
 */
public class Alumno extends Persona {

    @Setter
    @Getter
    String matricula;
    @Setter
    @Getter
    String procedencia;
    @Setter
    @Getter
    String semestre;
    @Setter
    @Getter
    String grupo;
    @Setter
    @Getter
    String correo;
}
