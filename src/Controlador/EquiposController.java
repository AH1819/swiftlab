package Controlador;

import Dao.IpadDao;
import Dao.MacDao;
import Modelo.Datos_Cargados;
import Modelo.Ipads;
import Modelo.Macs;
import java.util.ArrayList;

/**
 *
 * @author Hitler
 */
public class EquiposController {

    Datos_Cargados DC = new Datos_Cargados();
    IpadDao ID = new IpadDao();
    MacDao MD = new MacDao();

    public void CargarIpad() {
        ArrayList<Ipads> ipads = ID.GetIpads();
        if (ipads != null) {
            DC.setIpads_guardadas(ipads);
        }
    }

    public void CargarMacs() {
        ArrayList<Macs> macs = MD.GetMacs();
        if (macs != null) {
            DC.setMacs_guardadas(macs);
        }
    }
}
