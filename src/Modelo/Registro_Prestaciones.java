package Modelo;

import java.sql.Date;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Hitler
 */
public class Registro_Prestaciones {

    @Getter
    @Setter
    String nombre;
    @Getter
    @Setter
    String matricula_plaza;
    @Getter
    @Setter
    String mac;
    @Getter
    @Setter
    String ipad;
    @Getter
    @Setter
    String cargadormac;
    @Getter
    @Setter
    String cargadoripad;
    @Getter
    @Setter
    Date fecha;
    @Getter
    @Setter
    String hora_entrada;
    @Getter
    @Setter
    String hora_salida;
}
