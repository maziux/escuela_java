package sinensia.modelo.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import sinensia.modelo.persistencia.IUserDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sinensia.modelo.User;

/**
 * @author Miguel Maseda
 */
public class UserDAO_DerbyDB implements IUserDAO {

    private static final String CONEX_DB = "jdbc:derby://localhost:1527/db_users";
    private static final String USER_DB = "root";
    private static final String PSSWD_DB = "1234";

    public UserDAO_DerbyDB() {
        try {
            // cargamos el driver de derby DB. Está basado en JDBC,
            // Una implementación de ODBC para Java
            Class.forName("org.apache.derby.jdbc.CientDriver");
            DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
        } catch (Exception ex) {
            Logger.getLogger(UserDAO_DerbyDB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public User create(User user) throws SQLException {

        Connection con = DriverManager.getConnection(CONEX_DB, USER_DB, PSSWD_DB);
        /* String sqlQuery = "INSERT INTO users (email, password, name, age) VALUES ("
                + " '" + user.getEmail()
                + "', '" + user.getPassword()
                + "', '" + user.getName()
                + "', " + user.getAge() + " )";
        Statement stmt = con.createStatement();
        stmt.executeUpdate(sqlQuery); */
        // Los ? son los parámetros de la sentencia SQL. Evitamos SQL Injection
        String sqlQuery = "INSERT INTO users (email, password, name, age) VALUES (?,?,?,?)";
        PreparedStatement prepStmt = con.prepareCall(sqlQuery);
        prepStmt.setString(1, user.getEmail());
        prepStmt.setString(2, user.getPassword());
        prepStmt.setString(3, user.getName());
        prepStmt.setInt(4, user.getAge());
        prepStmt.executeUpdate();
        int aux = getIdFromEmail(user.getEmail());
        user.setId(aux);
        con.close();
        return user;
    }

    @Override
    public List<User> getAll() throws SQLException {
        try (Connection con = DriverManager.getConnection(CONEX_DB, USER_DB, PSSWD_DB)) {
            ArrayList<User> userList = new ArrayList<>();
            String sqlQuery = "SELECT id, email, password, name, age FROM users";
            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery(sqlQuery);
            while (res.next()) {
                int id = res.getInt("id");
                String email = res.getString("email");
                String password = res.getString("password");
                String name = res.getString("name");
                int age = res.getInt("age");
                User newUser = new User(email, password, name, age);
                newUser.setId(id);
                userList.add(newUser);
            }
            return userList;
        }
    }

    @Override
    public boolean remove(int id) throws SQLException {
        try (Connection con = DriverManager.getConnection(CONEX_DB, USER_DB, PSSWD_DB)) {
            String sqlQuery = "DELETE FROM users WHERE id = ?";
            PreparedStatement prepStmt = con.prepareCall(sqlQuery);
            prepStmt.setInt(1, id);
            prepStmt.executeUpdate();
            return true;
        }
    }

    @Override
    public boolean remove(User user) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getIdFromEmail(String email) throws SQLException {
        int id = 0;
        try (Connection con = DriverManager.getConnection(CONEX_DB, USER_DB, PSSWD_DB)) {
            String sqlQuery = "SELECT id FROM USERS WHERE email = ?";
            PreparedStatement prepStmt = con.prepareCall(sqlQuery);
            prepStmt.setString(1, email);
            ResultSet res = prepStmt.executeQuery();
            while (res.next()) {
                id = res.getInt("id");
            }
        }
        return id;
    }

    @Override
    public User modifyUser(User oldUser, String email, String password, String name, Integer age) throws SQLException {

        User userResult = null;
        int userId = oldUser.getId();
        if (email.isEmpty()) {
            email = oldUser.getEmail();
        }
        if (password.isEmpty()) {
            password = oldUser.getPassword();
        }
        if (name.isEmpty()) {
            name = oldUser.getName();
        }
        if (age == null) {
            age = oldUser.getAge();
        }

        try (Connection con = DriverManager.getConnection(CONEX_DB, USER_DB, PSSWD_DB)) {
            String sqlQuery = "UPDATE users SET email = ?, password = ?, name = ?, age = ?"
                    + " WHERE id = ?";
            PreparedStatement prepStmt = con.prepareCall(sqlQuery);
            prepStmt.setString(1, email);
            prepStmt.setString(2, password);
            prepStmt.setString(3, name);
            prepStmt.setInt(4, age);
            prepStmt.setInt(5, userId);
            int cont = prepStmt.executeUpdate();
            if (cont == 1) {
                userResult = new User(email, password, name, age);
                userResult.setId(userId);
            }
            return userResult;
        }
    }

    @Override
    public User updateUser(User u) throws SQLException {
        try (Connection con = DriverManager.getConnection(CONEX_DB, USER_DB, PSSWD_DB)) {
            String sqlQuery = "UPDATE users SET email = ?, password = ?, name = ?, age = ?"
                    + " WHERE id = ?";
            PreparedStatement prepStmt = con.prepareCall(sqlQuery);
            prepStmt.setString(1, u.getEmail());
            prepStmt.setString(2, u.getPassword());
            prepStmt.setString(3, u.getName());
            prepStmt.setInt(4, u.getAge());
            prepStmt.setInt(5, u.getId());
            int cont = prepStmt.executeUpdate();
            if (cont == 1) {
                return u;
            }
            return null;
        }
    }

}
