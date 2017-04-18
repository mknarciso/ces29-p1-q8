package br.ita.comp18.MURILONARCISO_QUESTAO08;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class BlockServer implements BlockDB {

	@Override
	public void newBlock(String username, Date start, int days) {
        String sql = "INSERT INTO block(username,startdate,days) VALUES(?,?,?)";
        try (Connection conn = Server.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setDate(2, new java.sql.Date(start.getTime()));
            pstmt.setInt(3, days);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
	}

	@Override
	public void removeBlocks(String username) {
        String sql = "DELETE FROM block WHERE username = ?";
        
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
	public boolean isBlocked(String username) {
		        String sql = "SELECT username "
		                + "FROM block WHERE username = ?";
		try (Connection conn = Server.connect();
		  PreparedStatement pstmt  = conn.prepareStatement(sql)){
		  // set the value
		  pstmt.setString(1,username);
		  //
		  ResultSet rs  = pstmt.executeQuery();
		  // loop through the result set
		  while (rs.next()) {
		      //System.out.println("Inserido no BD:"+rs.getString("username"));
		      return true;
		  }
			 return false;
		} catch (SQLException e) {
		  System.out.println(e.getMessage());
		}
		return false;
	}

}
