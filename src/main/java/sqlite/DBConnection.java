package sqlite;

import java.sql.*;

public class DBConnection {
public static Connection connect() {
	
	Connection con = null;
	
	try {
		Class.forName("org.sqlite.JDBC");
		System.out.println("DB connected");
	} catch (ClassNotFoundException e) {
	        e.printStackTrace();
	 }

	return con;
}

public static void close(ResultSet rs, PreparedStatement preparedStatement, Connection connection) {

    try {
        if (rs != null && !rs.isClosed()) {
            rs.close();
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    try {
        if (preparedStatement != null && !preparedStatement.isClosed()) {
            preparedStatement.close();
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    try {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

}
