package Mediasoft.badamshin.project.films;
import java.util.*;
import java.time.*;

public class Movie {
	
	private String title;
	private LocalDate creationDate = LocalDate.now();
	private String slogan;
	private EnumSet<Genre> genres = EnumSet.of(Genre.None);
	private Rating rating = Rating.None;
	private int budget;
	private int fees;
	private List<Person> persons = new ArrayList<Person>();
	
	
	public Movie() {
		
	}
		
	
	
	public Movie(String title) {
		this.setTitle(title);		
	}
	
	
	
	public void setCreationDate(int year, String month, int day) {
		try {
			this.creationDate = LocalDate.of(year,Month.valueOf(month),day);
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
	
	
	public void setSlogan(String slogan) {
		this.slogan=slogan;
	}

	
	
	public String getSlogan(){
	return this.slogan;		
	}
	


	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public LocalDate getCreationDate() {
		return creationDate;
	}



	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}



	public EnumSet<Genre> getGenre() {
		return genres;
	}



	public void setGenres(Genre...genres ) {
		try{
			this.genres.addAll(Arrays.asList(genres));
			if(this.genres.contains(Genre.None)) {
				this.genres.remove(Genre.None);
			}
		}catch(NullPointerException e ) {
			System.out.println(e);
		}
	}
	
	
	
	public void setGenres(String[] genresMs){
		try {
			for(String genreToAdd : genresMs) {
			this.genres.add(Genre.valueOf(genreToAdd));
			}
			if(this.genres.contains(Genre.None)) {
				this.genres.remove(Genre.None);
			}			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	
	
	public String getGenresStr() {
		String result ="{";
		for(Genre genre : this.genres) {
			result += genre.name()+", ";
		}
		result = result.substring(0,result.length()-2);
		result+="}";
		return result;
	}	
	



	public Rating getRating() {
		return rating;
	}



	public void setRating(Rating rating) {
		this.rating = rating;
	}
	
	
	
	public void setRating(String string) {
		try {
		this.rating = Rating.valueOf(string);	
		}catch(Exception e) {
			System.out.println(e);
			}
	}	
	



 	public int getBudget() {
		return budget;
	}



	public void setBudget(int budget) {
		this.budget = budget;
	}



	public int getFees() {
		return fees;
	}



	public void setFees(int fees) {
		this.fees = fees;
	}

	
	
	@Override
	public String toString() {
		String result;
		result=this.title + " " + this.slogan + " " + this.getCreationDate().toString()
				+ " " + this.budget + " " + this.fees + this.genres.toString() 
				+ " " + this.rating.toString();
		return result;
	}



	public List<Person> getActorPersons() {
		List<Person> resultPersons=new ArrayList<Person>();
		for(Person p:persons) {
			if(p.GetProfessions().contains(Profession.Actor)) {
				resultPersons.add(p);
			}
		}	
		return resultPersons;
	}
	
	
	
	public List<Person> getDirectorPersons() {
		List<Person> resultPersons=new ArrayList<Person>();
		for(Person p:persons) {
			if(p.GetProfessions().contains(Profession.FilmDirector)) {
				resultPersons.add(p);
			}
		}
		return resultPersons;
	}



	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}



	
	
	

}
