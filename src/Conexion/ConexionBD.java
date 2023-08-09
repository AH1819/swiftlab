package Conexion;

import Modelo.ErrorsAndSuccesses;
import Modelo.Logeo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private Logeo lg = new Logeo();
    private ErrorsAndSuccesses eas = new ErrorsAndSuccesses();
    private String driver = "org.postgresql.Driver";
    private String Cadenacon;

    public ConexionBD() {
    }

    public static ConexionBD getInstance() {
        return ConexionHolder.INSTANCE;
    }

    private static class ConexionHolder {

        private static final ConexionBD INSTANCE = new ConexionBD();
    }

    public Connection conectar() {

        Connection con = null;
        Cadenacon = "jdbc:postgresql://" + lg.getIp() + ":" + lg.getPuerto() + "/" + lg.getBase() + "";
        System.out.println(Cadenacon);
        try {

            con = DriverManager.getConnection(Cadenacon, lg.getUsuario(), lg.getPassword());
            eas.setConexion(true);
        } catch (SQLException ex) {
            eas.setConexion(false);
            if (ex.getMessage().contains("la autentificaci")) {
                eas.setCadenaErrorBD("Usuario o Contraseña incorrecta.");
            } else if (ex.getMessage().contains("no existe la base de datos")) {
                eas.setCadenaErrorBD("La base de datos no existe.");
            } else {
                eas.setCadenaErrorBD("Error al conectar a la base de datos: " + ex.getMessage());
            }
        }
        return con;
    }
}
