package disease;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class MySQLConnectionTest  {

	@Test
	public void testConnect() {
		String dbUrl = "jdbc:mysql://localhost/agdisease";
		String dbClass = "com.mysql.jdbc.Driver";
		String query = "Select * from tb_dermatology";
		String username = "root";
		String password = "";
		try {
			Class.forName(dbClass);
			Connection connection = DriverManager.getConnection(dbUrl,
					username, password);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				String tableName = resultSet.getString(1);
				//System.out.println("Table name : " + tableName);
			}
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
