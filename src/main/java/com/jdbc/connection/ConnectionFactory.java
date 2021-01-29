package com.jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionFactory {
	
	private static final String DRIVER = "";
	private static final String URL = "";
	private static final String USER = "";
	private static final String PASSWORD = "";

	
	
	
	
	
	
	
	
	public static void main(String[] args) {
        String connectionUrl = "jdbc:sqlserver://localhost:1433;"
        			    + "database=licor;"
        			    + "user=sa;"
        			    + "password=123456;"
        			    + "encrypt=true;"
        			    + "trustServerCertificate=true;"
        			    + "loginTimeout=30;"
        			    + "useSSL=false";

        ResultSet resultSet = null;

        try (Connection connection = DriverManager.getConnection(connectionUrl);
                Statement statement = connection.createStatement();) {

            // Create and execute a SELECT SQL statement.
            String selectSql = "SELECT IdProduto, Descricao, Qtd, Valor, IdCategria from Produto";
            resultSet = statement.executeQuery(selectSql);

            // Print results from select statement
            while (resultSet.next()) {
                System.out.println(resultSet.getString("IdProduto") + " " + resultSet.getString("Descricao"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
