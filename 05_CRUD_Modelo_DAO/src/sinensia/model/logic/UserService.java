package sinensia.model.logic;

import java.sql.SQLException;
import java.util.List;
import sinensia.modelo.User;
import sinensia.modelo.persistencia.IUserDAO;
import sinensia.modelo.persistencia.UserDAO_DerbyDB;

/**@author Miguel Maseda
 */
public class UserService {
    
    IUserDAO daoUsers;
    
    public UserService(IUserDAO daoUsers) {
        this.daoUsers = daoUsers;
    }
    
    public User create(String email, String password, String name, int age) throws SQLException {
        
        User u = null; 
        
        if (email != null && password != null && name != null) {
            if (email.length() > 3 
                    && ! password.equals("")
                    && ! name.equals("")
                    && age > 0) {
                u = new User(email, password, name, age);
                u = daoUsers.create(u);
            }
        }        
        return u;
    }
    
    public List<User> getAll() throws SQLException {
        return daoUsers.getAll();
    }
    
    public int getIdFromEmail(String email) throws SQLException {
        return daoUsers.getIdFromEmail(email);
    }
    
    public boolean remove(int id) throws SQLException {
        return daoUsers.remove(id);
    }
    
    public User modifyUser(User oldUser, String email, String password, String name, int age) throws SQLException {
        return daoUsers.modifyUser(oldUser, email, password, name, age);
    }
}
