package Dao;

import Conexion.ConexionBD;
import Modelo.Alumno;
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
public class AlumnoDao {
    
    private static ResultSet Resultado;
    private ConexionBD conexion = ConexionBD.getInstance();
    ArrayList<Alumno> alumnos;
    Alumno alumno;
    
    public ArrayList<Alumno> GetAll() {
        alumnos = new ArrayList<>();
        
        String sql = "select * from alumno";
        PreparedStatement comando = null;
        
        try {
            comando = conexion.conectar().prepareStatement(sql);
            Resultado = comando.executeQuery();
            
            while (Resultado.next()) {
                alumno = new Alumno();
                alumno.setMatricula(Resultado.getString("matricula"));
                alumno.setNombre(Resultado.getString("nombre"));
                alumno.setApellido_p(Resultado.getString("app"));
                alumno.setApellido_m(Resultado.getString("apm"));
                alumno.setEdad(Resultado.getInt("edad"));
                alumno.setSexo(Resultado.getString("sexo"));
                alumno.setProcedencia(Resultado.getString("procedencia"));
                alumno.setSemestre(Resultado.getString("semestre"));
                alumno.setGrupo(Resultado.getString("grupo"));
                alumno.setCorreo(Resultado.getString("correo"));
                alumnos.add(alumno);
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
        return alumnos;
    }
}
