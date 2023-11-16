package Utils;
import java.sql.*;

public class DBUtils {
	// add a method to return DB connection
	public static Connection openConnection() throws ClassNotFoundException, SQLException
	{
		//1.load type4 JDBC driver-->pure java (optional step(since JDBC 4.x))
		//Class.forName("com.mysql.cj.jdbc.Driver"); (optional step from jdk 8 onward)
		//2.get connection to database
		//API: java.sql.DriverManager: class
		//method: public static Connection getConnection(String dbURL,String username,String password)
		String dbURL = "jdbc:mysql://localhost:3306/advjava?useSSL=false&allowPublicKeyRetrieval=true";
		return DriverManager.getConnection(dbURL,"root","root123");
	}
}
