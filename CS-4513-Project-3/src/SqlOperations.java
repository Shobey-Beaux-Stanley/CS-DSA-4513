import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;

public class SqlOperations {
	private Connection connection;
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
		
	}
	
	public void operation2() {
		
	}
	
	public void operation3() {
		final String url = "jdbc:sqlserver://stan8884-sql-server.database.windows.net:"
				+ "1433;database=cs-dsa-4513-sql-project-3;user=stan8884@stan8884-sql-server;password="
				+ "Mario1991!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*"
				+ ".database.windows.net;loginTimeout=30;";
		try  {
			System.out.println("Here");
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
			e.printStackTrace();
		}
	}
}
