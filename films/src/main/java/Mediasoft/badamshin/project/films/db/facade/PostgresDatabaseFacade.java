package Mediasoft.badamshin.project.films.db.facade;

import java.sql.*;

import Mediasoft.badamshin.project.films.db.exception.DatabaseException;


public class PostgresDatabaseFacade implements DatabaseFacade {

	private String className = "org.postgresql.Driver";
	private String url = "jdbc:postgresql://localhost:5432/comradedatabase";
	private Connection connection = null;
	
	@Override
	public void connect(String login, String password) throws DatabaseException {
		try {
			Class.forName(className);
			this.connection = DriverManager.getConnection(this.url,login,password);
			
		}catch(ClassNotFoundException cnfe) {
			throw new DatabaseException("driver not found");
		}catch(SQLException sqle) {
			throw new DatabaseException("unable to login" + sqle.getMessage());
		}

		
	}

	@Override
	public Connection getConnection() {
		return this.connection;
	}

	@Override
	public void disconect() {
		if(this.connection!=null) {
			try {
				this.connection.close();
			}catch(SQLException sqle) {
				this.connection = null;
				sqle.printStackTrace();
			}
		}
		
	}

}
