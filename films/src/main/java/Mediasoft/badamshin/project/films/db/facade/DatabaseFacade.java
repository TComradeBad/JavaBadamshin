package Mediasoft.badamshin.project.films.db.facade;
import java.sql.Connection;
import Mediasoft.badamshin.project.films.db.exception.DatabaseException;

public interface DatabaseFacade {
	void connect(String login, String password) throws DatabaseException;
	Connection getConnection();
	void disconect();

}
