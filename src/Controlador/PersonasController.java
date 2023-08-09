package Controlador;

import Dao.AlumnoDao;
import Dao.DocenteDao;
import Modelo.Alumno;
import Modelo.Datos_Cargados;
import Modelo.Docente;
import java.util.ArrayList;

/**
 *
 * @author Hitler
 */
public class PersonasController {

    Datos_Cargados DC = new Datos_Cargados();
    DocenteDao PD = new DocenteDao();
    AlumnoDao AD = new AlumnoDao();

    public void CargarDocentes() {
        ArrayList<Docente> docentes = PD.GetAll();
        DC.setDocentes_guardadas(docentes);
    }

    public void CargarAlumnos() {
        ArrayList<Alumno> alumnos = AD.GetAll();
        DC.setAlumnos_guardadas(alumnos);
    }
}
