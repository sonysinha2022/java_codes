package tester;
import java.sql.*;
import static Utils.DBUtils.openConnection;
public class TestMysqlConnection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(Connection cn=openConnection()){
			System.out.println("Connected to DB:"+cn);
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
