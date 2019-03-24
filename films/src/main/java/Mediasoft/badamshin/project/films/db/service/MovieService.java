package Mediasoft.badamshin.project.films.db.service;
import java.util.List;
import Mediasoft.badamshin.project.films.Movie;
import Mediasoft.badamshin.project.films.db.exception.MovieDataSourceException;;



public interface MovieService {
	List<Movie> getAllMovie() throws MovieDataSourceException;
	void pushMoviestoDB(List<Movie> movies) throws MovieDataSourceException;

}
