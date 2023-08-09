package Dao;

import Conexion.ConexionBD;
import Modelo.Ipads;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hitler
 */
public class IpadDao {

    private static ResultSet Resultado;
    private ConexionBD conexion = ConexionBD.getInstance();
    ArrayList<Ipads> ipads;
    Ipads ipad;

    public ArrayList<Ipads> GetIpads() {
        ipads = new ArrayList<>();

        String sql = "select * from ipad";
        PreparedStatement comando = null;

        try {
            comando = conexion.conectar().prepareStatement(sql);
            Resultado = comando.executeQuery();

            while (Resultado.next()) {
                ipad = new Ipads();
                ipad.setNumero(Resultado.getString("id_ipad"));
                ipad.setCargador(Resultado.getString("cargador"));
                ipad.setObservaciones(Resultado.getString("observaciones"));
                ipads.add(ipad);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MacDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conexion.conectar().close();
                comando.close();
            } catch (SQLException ex) {
                Logger.getLogger(MacDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ipads;
    }
}
