package br.ita.comp18.MURILONARCISO_QUESTAO08;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Server{

    public void startTables(){
    	//User
    	this.createTable(
    			"CREATE TABLE IF NOT EXISTS user (\n"
                + "	username text PRIMARY KEY NOT NULL\n"
                + ");");
    	//Book
    	this.createTable(
    			"CREATE TABLE IF NOT EXISTS book (\n"
                + "	id integer PRIMARY KEY AUTOINCREMENT,\n"
                + "	title text,\n"
                + "	author text\n"
                + ");");    	
    	//Block
    	this.createTable(
    			"CREATE TABLE IF NOT EXISTS block (\n"
                + "	id integer PRIMARY KEY AUTOINCREMENT,\n"
                + "	username text,\n"
                + "	startdate text,\n"
                + "	days integer\n"
                + ");");    	
    	//Loan
    	this.createTable(
    			"CREATE TABLE IF NOT EXISTS loan (\n"
                + "	id integer PRIMARY KEY AUTOINCREMENT,\n"
                + "	username text,\n"
                + "	book text,\n"
                + "	date text\n"
                + ");");
    }

    public void createTable(String sql) {
        
        try (Connection conn = connect();
            Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
            System.out.println(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    static Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:server.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    public static void main(String[] args) {
    }
}