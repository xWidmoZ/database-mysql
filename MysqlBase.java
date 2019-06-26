import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//CLASS From widmo-apis
//Author: WidmoZ

public class MysqlBase {
	
	public static MysqlBase db;
	
	public Connection connection;
	
	public void execute(String value){
		try {	
			connection.createStatement().executeUpdate(value);
		}catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public void openConnection(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://" + @HOSTNAME@ + ":"+ @PORT@ +"/" + @BASE-NAME@, @BASE-USER@, @PASSWORD@);
			return;
		}catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void closeConnection(){
		try {
			connection.close();
		} catch (SQLException e) {	
			e.printStackTrace();
		}
		connection = null;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public static MysqlBase getDb() {
		if(db==null) db = new MysqlBase();
		return db;
	}

	public static void setDb(MysqlBase db) {
		MysqlBase.db = db;
	}
}
