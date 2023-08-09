package Modelo;

import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Hitler
 */
public class Datos_Cargados {

    @Setter
    @Getter
    private static ArrayList<Macs> macs_guardadas;
    @Setter
    @Getter
    private static ArrayList<Ipads> ipads_guardadas;
    @Setter
    @Getter
    private static ArrayList<Docente> docentes_guardadas;
    @Setter
    @Getter
    private static ArrayList<Alumno> alumnos_guardadas;
}
