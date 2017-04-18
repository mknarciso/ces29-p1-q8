package br.ita.comp18.MURILONARCISO_QUESTAO08;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserServer implements UserDB {
	//private String url = "jdbc:sqlite:server.db";
	@Override
	public void newUser(String username) {
        String sql = "INSERT INTO user(username) VALUES(?)";
        try (Connection conn = Server.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

	}

	@Override
	public void removeUser(String username) {
        String sql = "DELETE FROM user WHERE username = ?";
        
        try (Connection conn = Server.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // set the corresponding param
            pstmt.setString(1, username);
            // execute the delete statement
            pstmt.executeUpdate();
 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

	}

	@Override
	public boolean loginUser(String username) {
            String sql = "SELECT username "
                       + "FROM user WHERE username = ?";
     try (Connection conn = Server.connect();
          PreparedStatement pstmt  = conn.prepareStatement(sql)){
         // set the value
         pstmt.setString(1,username);
         //
         ResultSet rs  = pstmt.executeQuery();
         // loop through the result set
         while (rs.next()) {
             System.out.println("Inserido no BD:"+rs.getString("username"));
             return true;
         }
      	 return false;
     } catch (SQLException e) {
         System.out.println(e.getMessage());
     }
 	 return false;
	}
    public static void main(String[] args) {
    	UserServer db = new UserServer();
    	db.newUser("antonio");
    	db.loginUser("antonio");
    }
}
