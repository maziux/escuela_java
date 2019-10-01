package sinensia.modelo.persistencia;

import java.sql.SQLException;
import java.util.List;
import sinensia.modelo.User;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/** Interfaz DAO para gestión de usuarios. Todas las sentencias
 * pueden lanzar SQLException.
 *
 * @author alumno
 */
public interface IUserDAO {
    User create(User user)throws SQLException ;
    List<User> getAll()throws SQLException ;
    boolean remove(int id)throws SQLException ;
    boolean remove(User user)throws SQLException ;
    int getIdFromEmail(String email) throws SQLException;
    User modifyUser(User oldUser, String email, String password, String name, Integer age) throws SQLException;
    User updateUser(User u) throws SQLException;
}
