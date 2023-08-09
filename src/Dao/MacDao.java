package Dao;

import Conexion.ConexionBD;
import Modelo.Macs;
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
public class MacDao {

    private static ResultSet Resultado;
    private ConexionBD conexion = ConexionBD.getInstance();
    ArrayList<Macs> macs;
    Macs mac;

    public ArrayList<Macs> GetMacs() {
        macs = new ArrayList<>();

        String sql = "select * from mac";
        PreparedStatement comando = null;

        try {
            comando = conexion.conectar().prepareStatement(sql);
            Resultado = comando.executeQuery();

            while (Resultado.next()) {
                mac = new Macs();
                mac.setNumero(Resultado.getString("id_mac"));
                mac.setCargador(Resultado.getString("cargador"));
                mac.setObservaciones(Resultado.getString("observaciones"));
                macs.add(mac);
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
        return macs;
    }
}
