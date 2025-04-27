/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.sql.*;

/**
 *
 * @author Ing. Narvaez Mejia
 */
public class Clientes {
   
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
     private String ocupacion;
      private String sexo;
    
public ResultSet listarCliente() {
    Conector db = new Conector();
    ResultSet rs = null;

    try {
        db.conectar();
        String query = "SELECT * FROM clientes";
        rs = db.executeSelect(query);
    } catch (SQLException e) {
        System.err.println("Error al listar los clientes Metodo: " + e.getMessage());
    }

    return rs;
}
   
    // Método para insertar un nuevo cliente en la base de datos
    public int guardarCliente(String nombre, String apellido, String direccion,
                              String telefono, String ocupacion, String sexo)
                              throws SQLException {
        Conector db = new Conector();
        db.conectar();
        String sql = "INSERT INTO clientes "
                   + "(nombre, apellido, direccion, telefono, ocupacion, sexo) "
                   + "VALUES (?, ?, ?, ?, ?, ?)";
        return db.executeUpdate(sql, nombre, apellido, direccion, telefono, ocupacion, sexo);
    }

    public int actualizarCliente(int id, String nombre, String apellido,
                                 String direccion, String telefono,
                                 String ocupacion, String sexo)
                                 throws SQLException {
        Conector db = new Conector();
        db.conectar();
        String sql = "UPDATE clientes SET "
                   + "nombre=?, apellido=?, direccion=?, telefono=?, "
                   + "ocupacion=?, sexo=? WHERE id=?";
        return db.executeUpdate(sql,
            nombre, apellido, direccion, telefono, ocupacion, sexo, id);
    }

    public int eliminarCliente(int id) throws SQLException {
        Conector db = new Conector();
        db.conectar();
        String sql = "DELETE FROM clientes WHERE id=?";
        return db.executeUpdate(sql, id);
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the ocupacion
     */
    public String getOcupacion() {
        return ocupacion;
    }

    /**
     * @param ocupacion the ocupacion to set
     */
    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    
}
