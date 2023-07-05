/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USUARIO
 */
public class SQLUsuarios extends Conexion{
    public boolean registrar(Usuarios usr){
        
        PreparedStatement ps = null;
        Connection con= getConexion();
        
        String sql = "INSERT INTO usuarios (password, nombre, correo,tipoUsuario) VALUES(?,?,?,?)";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,usr.getPassword());
            ps.setString(2,usr.getNombre());
            ps.setString(3,usr.getCorreo());
            ps.setInt(4, usr.getTipoUsuario());
            ps.execute();
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(SQLUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            return false;
            
        }
    }
}
