package tester;

import java.sql.*;
import static Utils.DBUtils.openConnection;

public class TestStatement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (// 1.establish db connection
				Connection cn = openConnection();
				// 2.create empty statement object to hold queries
				// API of connection i/f:Statement craeteStatement() throws SQLException
				Statement st = cn.createStatement();
				// 3.execute select query n get resultset
				// API of statement i/f: public ResultSet executeQuery(String sql) throws
				// SQLException
				ResultSet rst = st.executeQuery("select * from users");) {
			// Resultset processing
			// cursor:befor 1st row
			while (rst.next()) {
				//read row data using column position
				System.out.printf("ID %d First_Name %s Last_Name %s Email %s Password %s Dob %s Status %b Role %s %n",
						rst.getInt(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getDate(6),rst.getBoolean(7),rst.getString(8));
			}
			
			//rst.close,st.close,cn.close)
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
