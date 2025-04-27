/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Clases;
import Clases.Conector;
import java.sql.*;
/**
 *
 * @author Ing. Narvaez Mejia
 */
public class Usuarios {
    String nombre;
    String apellido;
    String username;
    String password;
    String tipo;
    
       // Método para verificar las credenciales del usuario
    public boolean verificarCredenciales(String pUsername, String pPassword) {
        Conector db = new Conector();
        
        try {
            db.conectar();
            String query = "SELECT * FROM usuarios WHERE username = ? AND clave = ?";
            ResultSet rs = db.executeSelect(query, pUsername, pPassword);
            return rs.next();
            
        }catch (SQLException e) {
            System.err.println("Error al verificar las credenciales: " + e.getMessage());
            return false;
        }finally {
           db.desconectar();
        }
       
    }
    
    
   public ResultSet listarUsuarios() {
    Conector db = new Conector();
    ResultSet rs = null;

    try {
        db.conectar();
        String query = "SELECT * FROM usuarios";
        rs = db.executeSelect(query);
    } catch (SQLException e) {
        System.err.println("Error al listar los clientes Metodo: " + e.getMessage());
    }

    return rs;
}
   
    // Método para insertar un nuevo cliente en la base de datos
    public int guardarUsuario(String nombre, String apellido, String username, String email, String clave) throws SQLException {
        Conector db = new Conector();
        db.conectar();
        String query = "INSERT INTO usuarios (nombre, apellido, username, email, clave) VALUES (?, ?, ?, ?, ?)";
        return db.executeUpdate(query, nombre, apellido, username, email, clave);
    }

    // Método para actualizar un cliente existente en la base de datos
    public int actualizarUsuario(int id,String nombre, String apellido, String username, String email, String clave) throws SQLException {
        Conector db = new Conector();
        db.conectar();
        String query = "UPDATE usuarios SET nombre = ?, apellido = ?, direccion = ?, telefono = ? WHERE id = ?";
        return db.executeUpdate(query, nombre, apellido, username, email, clave, id);
    }

    // Método para eliminar un cliente de la base de datos
    public int eliminarUsuario(int id) throws SQLException {
        Conector db = new Conector();
        db.conectar();
        String query = "DELETE FROM usuarios WHERE id = ?";
        return db.executeUpdate(query, id);
    } 

    public void guardarUsuarios(String text, String text0, String text1, String text2) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void guardarUsuario(String text, String text0, String text1) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
   
}
