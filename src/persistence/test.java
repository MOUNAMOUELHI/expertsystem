package persistence;

import org.jpl7.Query;

import commons.JDBCConnectionManager;


public class test {

	public static void main(String[] args) {

	
		JDBCConnectionManager cnx = JDBCConnectionManager.getInstance();
		cnx.getSession();
		String p1 = "consult('C:/Users/Asus/workspace/SYS_EXPERT/src/commons/prolog/prolog.pl')";
		Query e1 = new Query(p1);
		System.out.println(p1 + " " + (e1.hasSolution()?"success": "fail"));
		// test initial commit 
	}

}
