package commons;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCConnectionManager {
	public static Connection session = null;
	public static JDBCConnectionManager instance = null ;
	
	public static JDBCConnectionManager getInstance(){
		if (instance == null){
			instance = new JDBCConnectionManager();
			return instance;
		}else{
			return instance;
		}
	}

	
	private Connection createConnection(){
		Connection con = null;
		 try {
	            Class.forName("oracle.jdbc.driver.OracleDriver");
	            final String url = "jdbc:mysql://127.0.0.1:3306/systemexpert?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	            con = DriverManager.getConnection(url, "root", "root");

	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	            System.out.println("cound not establish connection with DB");
	        } catch (SQLException e) {
	        	 e.printStackTrace();
		         System.out.println("cound not establish connection with DB");
	        }
		 
		 return con;
	}
	
	
	public Connection getSession(){
		Connection con = null;
		if (this.session != null){
			con= this.session;
		}else{
			this.session = createConnection();
			con= this.session;
		}
		return this.session;
	}
	
	
	public ResultSet executeStoredProc(String procName, Object... params) throws SQLException{
		CallableStatement stmt = null;
		ResultSet result = null;
		int count = 0;
		if(procName != null){
			   String executor = "{call " + procName + "}";
			   Connection session = getSession();
			   if(session != null){
				   try {
					stmt = getSession().prepareCall(executor);
				   } catch (SQLException e) {
					System.out.println("procedure not found or issue with parameters");				
				   }
		   
			   }else {
				   System.out.println("session issue");				
				   throw new SQLException();

			   }
		}
		if(stmt != null){
		
			for (Object param : params){
				if (param.getClass() == Integer.class) {
					try{
					Integer value = (Integer) param;
				    stmt.setInt(count, value.intValue());
					}catch(ClassCastException ex){
						System.out.println("cannot cas param to integer");
					}
				}else if (param.getClass() == Double.class) {
					try{
						Double value = (Double) param;
					    stmt.setDouble(count, value.doubleValue());	
						}catch(ClassCastException ex){
							System.out.println("cannot cas param to double");
						}
				}else if (param.getClass() == Date.class) {
					try{
						Date value = (Date) param;
					    stmt.setDate(count, value);	
						}catch(ClassCastException ex){
							System.out.println("cannot cas param to Date");
						}
				}
				else if (param.getClass() == String.class) {
					try{
						String value = (String) param;
					    stmt.setString(count, value);	
						}catch(ClassCastException ex){
							System.out.println("cannot cas param to double");
						}
				}
			}
			
			// execute the call for the procedure
		  result = stmt.executeQuery();
		}	
	    return result;
	}
		
	
	public ResultSet executeQueryFromString(String query) throws SQLException{
		Statement stmt = null;
		ResultSet result = null;
		int count = 0;
	   Connection session = getSession();
	   if(session != null){
		   try {
			stmt = getSession().createStatement();
			result = stmt.executeQuery(query);
		   } catch (SQLException e) {
			System.out.println("procedure not found or issue with parameters");				
		   }
   
	   }else {
		   System.out.println("session issue");				
		   throw new SQLException();
	   }
	    return result;
	}
		
	
}
