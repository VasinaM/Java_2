package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

interface AuthService {

    String getNick (String login, String pass);

    void connect();

    void disconnect();

}
 class AuthServiceImpl implements AuthService {

    private static Connection connection;
    private static Statement statement;

     @Override
     public void connect() {
         try {
             connection = DriverManager.getConnection("jdbc:sqlite:db");
             statement = connection.createStatement();
         } catch (SQLException e) {
             e.printStackTrace();
         }
     }

     @Override
     public void disconnect() {
         try {
             connection.close();
         } catch (SQLException e) {
             e.printStackTrace();
         }
     }

     @Override
     public String getNick(String login, String pass) {
         return null;
     }
 }