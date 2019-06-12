package persistence.dao;

import java.sql.Connection;
import java.sql.SQLException;

import commons.JDBCConnectionManager;
import persistence.to.ruleTO;

public class ruleDAO {
	
	
	public void insetRule(ruleTO rule){
		
		 	JDBCConnectionManager cnxManager = JDBCConnectionManager.getInstance();
		    Connection cx = cnxManager.getSession();
		    if(cx != null){
		    	System.out.println("Connection to Rules DB with success");
		    }
		    
		    String requete = "insert into RULE VALUE (?,?,?,?)";
		    try {
				cnxManager.executeQueryFromString(requete);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		    	
	}

}
