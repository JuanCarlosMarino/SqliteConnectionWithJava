/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Clases.Cancion;
import Modelo.Persistencia.CRUD;
import Modelo.Persistencia.DbConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JUAN MARIÑO
 */
public abstract class Controller {

    public static boolean registrarCancion(String nombre, String artista, String genero) throws SQLException {
        Cancion c1 = new Cancion(0, nombre, artista, genero);
        CRUD.setConnection(DbConnection.ConexionBD());
        String sentencia = "INSERT INTO Cancion(nombre,artista,genero) "
                + " VALUES ('" + c1.getNombre() + "','" + c1.getArtista() + "','" + c1.getGenero() + "');";
        if (CRUD.setAutoCommitBD(false)) {
            if (CRUD.insertarBD(sentencia)) {
                CRUD.commitBD();
                CRUD.cerrarConexion();
                return true;
            } else {
                CRUD.rollbackBD();
                CRUD.cerrarConexion();
                return false;
            }
        } else {
            CRUD.cerrarConexion();
            return false;
        }
    }

    public static boolean actualizarCancion(int id, String nombre, String artista, String genero) {
        Cancion c1 = new Cancion(id, nombre, artista, genero);
        CRUD.setConnection(DbConnection.ConexionBD());
        String Sentencia = "UPDATE `Cancion` SET nombre='" + c1.getNombre() + "',artista='" + c1.getArtista() + "',genero='" + c1.getGenero()
                + "' WHERE id=" + c1.getID() + ";";
        if (CRUD.setAutoCommitBD(false)) {
            if (CRUD.actualizarBD(Sentencia)) {
                CRUD.commitBD();
                CRUD.cerrarConexion();
                return true;
            } else {
                CRUD.rollbackBD();
                CRUD.cerrarConexion();
                return false;
            }
        } else {
            CRUD.cerrarConexion();
            return false;
        }
    }

    public static boolean borrarCancion(int id) {
        CRUD.setConnection(DbConnection.ConexionBD());
        String Sentencia = "DELETE FROM `Cancion` WHERE `id`='" + id + "';";
        if (CRUD.setAutoCommitBD(false)) {
            if (CRUD.actualizarBD(Sentencia)) {
                CRUD.commitBD();
                CRUD.cerrarConexion();
                return true;
            } else {
                CRUD.rollbackBD();
                CRUD.cerrarConexion();
                return false;
            }
        } else {
            CRUD.cerrarConexion();
            return false;
        }
    }

    public static Cancion obtenerCancion(int id) {
        CRUD.setConnection(DbConnection.ConexionBD());
        String sql = "select * from Cancion where id=" + id + "";
        ResultSet rs = CRUD.consultarBD(sql);
        Cancion c1 = new Cancion();
        try {
            if (rs.next()) {
                c1.setID(rs.getInt("ID"));
                c1.setNombre(rs.getString("nombre"));
                c1.setArtista(rs.getString("artista"));
                c1.setGenero(rs.getString("genero"));

                CRUD.cerrarConexion();
            } else {
                CRUD.cerrarConexion();
                return null;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return c1;
    }

    public static List<Cancion> listarCanciones() {
        CRUD.setConnection(DbConnection.ConexionBD());
        List<Cancion> listaCanciones = new ArrayList<>();
        try {
            String sql = "select * from Cancion";

            ResultSet rs = CRUD.consultarBD(sql);
            Cancion c1 = new Cancion();
            while (rs.next()) {
                c1.setID(rs.getInt("ID"));
                c1.setNombre(rs.getString("nombre"));
                c1.setArtista(rs.getString("artista"));
                c1.setGenero(rs.getString("genero"));
                listaCanciones.add(c1);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {

            CRUD.cerrarConexion();
        }

        return listaCanciones;
    }

}
