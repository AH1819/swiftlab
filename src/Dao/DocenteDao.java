package Dao;

import Conexion.ConexionBD;
import Modelo.Docente;
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
public class DocenteDao {
    
    private static ResultSet Resultado;
    private ConexionBD conexion = ConexionBD.getInstance();
    ArrayList<Docente> docentes;
    Docente docente;
    
    public ArrayList<Docente> GetAll() {
        docentes = new ArrayList<>();
        
        String sql = "select * from docente";
        PreparedStatement comando = null;
        
        try {
            comando = conexion.conectar().prepareStatement(sql);
            Resultado = comando.executeQuery();
            
            while (Resultado.next()) {
                docente = new Docente();
                docente.setNumero_plaza(Resultado.getInt("numero_plaza"));
                docente.setNombre(Resultado.getString("nombre"));
                docente.setApellido_p(Resultado.getString("app"));
                docente.setApellido_m(Resultado.getString("apm"));
                docente.setEdad(Resultado.getInt("edad"));
                docente.setSexo(Resultado.getString("sexo"));
                docente.setInstitucion(Resultado.getString("institucion"));
                docente.setCorreo(Resultado.getString("correo"));
                docentes.add(docente);
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
        return docentes;
    }
    
    public ArrayList<Docente> GetPersonas() {
        docentes = new ArrayList<>();
        
        String sql = "select * from docente";
        PreparedStatement comando = null;
        
        try {
            comando = conexion.conectar().prepareStatement(sql);
            Resultado = comando.executeQuery();
            
            while (Resultado.next()) {
                docente = new Docente();
                docente.setNumero_plaza(Resultado.getInt("numero_plaza"));
                docente.setNombre(Resultado.getString("nombre"));
                docente.setApellido_p(Resultado.getString("app"));
                docente.setApellido_m(Resultado.getString("apm"));
                docente.setEdad(Resultado.getInt("edad"));
                docente.setSexo(Resultado.getString("sexo"));
                docente.setInstitucion(Resultado.getString("institucion"));
                docente.setCorreo(Resultado.getString("correo"));
                docentes.add(docente);
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
        return docentes;
    }
}
