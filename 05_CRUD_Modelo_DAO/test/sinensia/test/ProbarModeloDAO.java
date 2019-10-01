/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sinensia.test;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sinensia.model.logic.UserService;
import sinensia.modelo.User;
import sinensia.modelo.persistencia.IUserDAO;
import sinensia.modelo.persistencia.UserDAO_DerbyDB;

/**
 *
 * @author alumno
 */
public class ProbarModeloDAO {
    
    UserService userSrv;
    
    public ProbarModeloDAO() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        IUserDAO daoUsers = new UserDAO_DerbyDB();
        userSrv = new UserService(daoUsers);
    }
    
    @After
    public void tearDown() {
    }


     @Test
    public void creteAndListUsersFail() {
        
        List<User> allUsers;
        try {
            allUsers = userSrv.getAll();
            int totalUsersBefore = allUsers.size();
            User u1 = userSrv.create(null, null, null, 0);
            User u2 = userSrv.create("","p1234", "J J", 20);
            User u3 = userSrv.create("er@dd", null, "J J", 20);
            User u4 = userSrv.create("er@dd","p1234", "", 20);
            User u5 = userSrv.create("er@dd","p1234", "J J", 0);

            assertNull(u1);
            assertNull(u2);
            assertNull(u3);
            assertNull(u4);
            assertNull(u5);

            allUsers = userSrv.getAll();
            assertEquals(totalUsersBefore, allUsers.size());
        } catch (SQLException ex) {
            Logger.getLogger(ProbarModeloDAO.class.getName()).log(Level.SEVERE, null, ex);
            fail("Error en SQL: " + ex.getMessage());
        }
    }    
    
   @Test
    public void creteAndListUsersOk() {
        
        List<User> allUsers;
        try {
            allUsers = userSrv.getAll();
            
            int totalUsersBefore = allUsers.size();

            User u1 = userSrv.create("aaa@mail.com","a1234", "Aaaaa", 20);
            User u2 = userSrv.create("bbb@mail.com","b1234", "B. Bbbb", 30);
            User u3 = userSrv.create("ccc@mail.com","c1234", "Cccc C.", 40);
            User u4 = userSrv.create("ddd@mail.com","d1234", "D. D. Dd", 50);

            assertNotNull(u1);
            assertEquals("B. Bbbb", u2.getName());
            assertTrue("ccc@mail.com".equals(u3.getEmail()));
            assertFalse(u4.getAge() != 50);

          
            // Repetido que debe fallar
            try {
                User u5 = userSrv.create("ddd@mail.com","d1234", "D. D. Dd", 50);
                fail("No debe crearse un usuario, está duplicado");
            } catch (Exception e) {
            }
            
            

            
            allUsers = userSrv.getAll();
            assertEquals(totalUsersBefore + 4, allUsers.size());
            
            // Eliminar los 4 usuarios creados
            
            boolean aux = userSrv.remove(u1.getId());
            assertEquals(true,aux);
            aux = userSrv.remove(u2.getId());
            assertEquals(true,aux);
            aux = userSrv.remove(u3.getId());
            assertEquals(true,aux);
            aux = userSrv.remove(u4.getId());
            assertEquals(true,aux);
            
            allUsers = userSrv.getAll();
            assertEquals(totalUsersBefore, allUsers.size());
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ProbarModeloDAO.class.getName()).log(Level.SEVERE, null, ex);
            fail("Error en SQL: " + ex.getMessage());
        }
    }
    
    @Test
    public void modify(){
        
        try {
            User u_before = userSrv.create("ttt@mail.com","t1234", "Ttttt", 20);
            int ub_id = u_before.getId();
            User u_after = userSrv.modifyUser(u_before, "new@mail.com", "newPass","newName", 90);
            int ua_id = u_after.getId();
            assertEquals(ub_id, ua_id);
            assertEquals(u_after.getEmail(),"new@mail.com");            
            assertEquals(u_after.getPassword() ,"newPass");            
            assertEquals(u_after.getName() ,"newName");
            assertEquals(u_after.getAge(),90);
            
        } catch (SQLException ex) {
            Logger.getLogger(ProbarModeloDAO.class.getName()).log(Level.SEVERE, null, ex);
            fail("Error en SQL: " + ex.getMessage());
        }
        
        
    }

}
