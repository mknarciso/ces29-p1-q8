package br.ita.comp18.MURILONARCISO_QUESTAO08;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class LoanServer implements LoanDB {
	@Override
	public void newLoan(int bookId, String username, BookDB _bookDB) {
        String sql = "INSERT INTO loan(username,bookid,date) VALUES(?,?,?)";
        try (Connection conn = Server.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setInt(2, bookId);
            pstmt.setDate(3, new java.sql.Date(new Date(2017,04,17).getTime()));
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

	}

	@Override
	public void removeLoan(int id, String username, BookDB _bookDB) {
        String sql = "DELETE FROM loan WHERE bookid = ? AND username = ?";
        
        try (Connection conn = Server.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // set the corresponding param
            pstmt.setInt(1, id);
            pstmt.setString(2, username);
            // execute the delete statement
            pstmt.executeUpdate();
 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
	}
	@Override
	public boolean isLend(int bookid) {
		        String sql = "SELECT id "
		                   + "FROM loan WHERE bookid = ?";
		 try (Connection conn = Server.connect();
		      PreparedStatement pstmt  = conn.prepareStatement(sql)){
		     pstmt.setInt(1,bookid);
		     ResultSet rs  = pstmt.executeQuery();
		     while (rs.next()) {
		         return true;
		     }
		  	 return false;
		 } catch (SQLException e) {
		     System.out.println(e.getMessage());
		 }
			 return false;
		}
    public static void main(String[] args) {
    	LoanServer db = new LoanServer();
    	BookDB bdb = new BookServer();
    	db.newLoan(1,"antonio",bdb);
    	//db.removeLoan(1, "antonio", bdb);
    	System.out.println(db.isLend(1));
    }

	@Override
	public ArrayList<Book> getListByUser(String username) {
		// TODO Auto-generated method stub
		return null;
	}
}
