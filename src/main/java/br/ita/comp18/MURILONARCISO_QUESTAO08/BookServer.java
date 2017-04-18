package br.ita.comp18.MURILONARCISO_QUESTAO08;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookServer implements BookDB {

	@Override
	public int newBook(String title, String autor) {
        String sql = "INSERT INTO book(title,author) VALUES(?,?) RETURNING id";
        try (Connection conn = Server.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, title);
            pstmt.setString(2, autor);
            //pstmt.executeUpdate();
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
		return 0;
	}

	@Override
	public int getIdByTitle(String title) {
        String sql = "SELECT id "
                + "FROM book WHERE title = ?";
		try (Connection conn = Server.connect();
		   PreparedStatement pstmt  = conn.prepareStatement(sql)){
		  // set the value
		  pstmt.setString(1,title);
		  //
		  ResultSet rs  = pstmt.executeQuery();
		  // loop through the result set
		  while (rs.next()) {
		      return rs.getInt("id");
		  }
		  return 0;
		} catch (SQLException e) {
		  System.out.println(e.getMessage());
		}
		return 0;
	}
	//INSERT INTO book(title,author) VALUES("Star Wars","George Lucas");
	@Override
	public int getStatus(int bookId) {
        String sql = "SELECT id "
                + "FROM loan WHERE bookid = ?";
        String sql2 = "SELECT id "
                + "FROM book WHERE id = ?";
		try (Connection conn = Server.connect();
		  PreparedStatement pstmt  = conn.prepareStatement(sql)){
		  pstmt.setInt(1,bookId);
		  ResultSet rs  = pstmt.executeQuery();
		  // Retorna emprestado
		  while (rs.next()) {
		      return 2;
		  }
		} catch (SQLException e) {
		  System.out.println(e.getMessage());
		}
		try (
			Connection conn = Server.connect();
			PreparedStatement pstmt2  = conn.prepareStatement(sql2)
			)
		{
		  pstmt2.setInt(1,bookId);
		  ResultSet rs2  = pstmt2.executeQuery();
		  // Retorna disponível
		  while (rs2.next()) {
		      return 1;
		  }
		} catch (SQLException e) {
		  System.out.println(e.getMessage());
		}
		return 0;
	}

}
