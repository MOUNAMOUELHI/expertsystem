package services.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jpl7.Query;

import commons.JDBCConnectionManager;
import persistence.dao.ruleDAO;
import persistence.to.ruleTO;

@WebServlet("/prolog")
public class prologServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String query = request.getParameter("query");
	    String rule = request.getParameter("rule");
	    
	    // save rule 
	   ruleTO ruleto = new ruleTO();
	   ruleto.setName(rule);
	  
	   new ruleDAO().insetRule(ruleto);
	    
	    
	    
	    
	    

	 
	    
	    // compilation ce fichier prolog
		String p1 = "consult('C:/Users/Asus/workspace/SYS_EXPERT/src/commons/prolog/prolog.pl')";
		Query e1 = new Query(p1);
		System.out.println(query + " " + (e1.hasSolution()? "compiled" : "error"));

	    // query executin
		Query e2 = new Query(query);
		System.out.println(query + " " + (e1.hasSolution()? "resolved" : "error"));
		
		

		
	}

}