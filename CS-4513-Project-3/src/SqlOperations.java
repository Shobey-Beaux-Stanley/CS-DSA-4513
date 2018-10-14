import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
/*
 * This class will handle all sql operations. Each operation
 * is performed in its own method.
 */
public class SqlOperations {
	private Connection connection;
	
	/*
	 * Default constructor that sets up connection with database.
	 */
	public SqlOperations() {
		// Connect to database
		final String url = "jdbc:sqlserver://stan8884-sql-server.database.windows.net:"
				+ "1433;database=cs-dsa-4513-sql-project-3;user=stan8884@stan8884-sql-server;password="
				+ "Mario1991!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*"
				+ ".database.windows.net;loginTimeout=30;";
		//try (final Connection connection = DriverManager.getConnection(url)) {
		try {
			this.connection = DriverManager.getConnection(url);
			final String schema = connection.getSchema();
			System.out.println("Successful connection - Schema:" + schema);
			System.out.println("Query data example:");
			System.out.println("=========================================");
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void operation1() {
		try {
			Statement statement = this.connection.createStatement();
		}
		catch (SQLException e) {
			System.out.println("An error occured");
			e.printStackTrace();
		}
	}
	
	/*
	 * This method will increase the compensation of an author,
	 * identified by aid from user input. The compensation will depend
	 * on the amount of problems created by the author in
	 * the Problem table.
	 */
	public void operation2(int userInputAid) {
		try {
			Statement statement = this.connection.createStatement();
			ResultSet resultSet =statement.executeQuery("EXEC operation2 @aid = " + userInputAid);
			int place = 1;
			while (resultSet.next()) {
				int aid = resultSet.getInt("aid");
				if (userInputAid == aid) {
					Statement updateStatement = this.connection.createStatement();
					switch (place) {
						case 1:
							updateStatement.executeUpdate("EXEC updateCompensation @aid = " + aid + ", @compIncrease =  " + "1.2");
							break;
						case 2:
							updateStatement.executeUpdate("EXEC updateCompensation @aid = " + aid + ", @compIncrease =  " + "1.15");
							break;
						case 3:
							updateStatement.executeUpdate("EXEC updateCompensation @aid = " + aid + ", @compIncrease =  " + "1.1");
							break;
						default:
							updateStatement.executeUpdate("EXEC updateCompensation @aid = " + aid + " @compIncrease =  " + "1.05");
							break;
					}
				}
				place++;
			}
		}
		catch (SQLException e) {
			System.out.println("An error occured");
			e.printStackTrace();
		}
	}
	
	/*
	 * This method will display the problem and author table contents.
	 */
	public void operation3() {
		try  {
			Statement statement1 = this.connection.createStatement();
			Statement statement2 = this.connection.createStatement();
			ResultSet  authorResultSet = statement1.executeQuery("SELECT * FROM Author");
			ResultSet problemResultSet = statement2.executeQuery("SELECT * FROM Problem");
			System.out.println("Author Table");
			System.out.println("aid           aname          compensation");
			while (authorResultSet.next()) {
				int aid = authorResultSet.getInt("aid");
				String aname = authorResultSet.getString("aname");
				int compensation = authorResultSet.getInt("compensation");
				System.out.println(aid + "            " + aname + "            "  + compensation);
			}
			System.out.println("Problem Table");
			System.out.println("pid          pname                    max_score         aid");
			while (problemResultSet.next()) {
				int pid = problemResultSet.getInt("pid");
				String pname = problemResultSet.getString("pname");
				int max_score = problemResultSet.getInt("max_score");
				int aid = problemResultSet.getInt("aid");
				System.out.println(pid + "            " + pname + "                      "  + max_score + "       "  +  aid);
			}
			System.out.println();
		} 
		catch (SQLException e) {
			System.out.println("An error occured");
			e.printStackTrace();
		}
	}
}
