package Mediasoft.badamshin.project.films.db.service;
import Mediasoft.badamshin.project.films.db.facade.*;
import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import Mediasoft.badamshin.project.films.Movie;
import Mediasoft.badamshin.project.films.db.exception.*;
import Mediasoft.badamshin.project.films.db.facade.PostgresDatabaseFacade;

public class MovieDatabaseService implements MovieService {

	private DatabaseFacade databaseFacade = new PostgresDatabaseFacade();
	private final String databaseLogin = "comradeuser";
    private final String databasePassword = "root1234";
    private final String tableName = "movies";
    

	
	@Override
	public List<Movie> getAllMovie() throws MovieDataSourceException {
		List<Movie> movies = new ArrayList<Movie>();
		try {
			this.databaseFacade.connect(databaseLogin, databasePassword);
			Connection connection = databaseFacade.getConnection();
			if(connection != null) {
				Statement statement = connection.createStatement();
				String sql = "select * from " + this.tableName;
				ResultSet resultSet = statement.executeQuery(sql);
				while(resultSet.next()) {
					Movie movie = new Movie();
					movie.setTitle(resultSet.getString("title"));
					movie.setSlogan(resultSet.getString("slogan"));
					movie.setBudget(resultSet.getInt("budget"));
					movie.setFees(resultSet.getInt("fees"));
					movie.setCreationDate(resultSet.getDate("creation_date").toLocalDate());
					movie.setGenres((String[])resultSet.getArray("genre").getArray());
					movie.setRating(resultSet.getString("rating"));
					movies.add(movie);
				}
			}
		}catch(DatabaseException de) {
			throw new MovieDataSourceException("unable to get movie list " + de.getMessage());
		}catch(SQLException sqle) {
			throw new MovieDataSourceException("Error with the database statement " + sqle.getMessage()); 
			}
				
		return movies;
	}

	
	@Override
	public void pushMoviestoDB(List<Movie> movies) throws MovieDataSourceException {
		try {
			this.databaseFacade.connect(databaseLogin, databasePassword);
			Connection connection = databaseFacade.getConnection();
			Statement statement = connection.createStatement();
			for(Movie movie : movies) {
				String sql = "INSERT INTO "+this.tableName+ "(title, slogan, budget, fees, rating, genre, creation_date) \n" +
			"VALUES ('"+movie.getTitle()+"', '"+movie.getSlogan()+"', "+movie.getBudget()+", "+movie.getFees()+", '"
			+movie.getRating().name()+"', '"+movie.getGenresStr()+"', '"+movie.getCreationDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))+"');";
			statement.executeQuery(sql);
			}
			
		}catch(DatabaseException de) {
			throw new MovieDataSourceException(de.getMessage());
		}catch(SQLException sqle) {
			///Ошибка запрос не вернул результата
			throw new MovieDataSourceException(sqle.getMessage());
		}

	}

}
