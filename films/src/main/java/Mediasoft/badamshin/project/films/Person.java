package Mediasoft.badamshin.project.films;
import java.util.*;
import java.time.LocalDate;
import java.time.Month;


public class Person  {
	
	private String firstName;
	private String lastName;
	private LocalDate birthDate = LocalDate.MIN;
	private LocalDate deathDate = LocalDate.MIN;
	private EnumSet<Profession> profession = EnumSet.of(Profession.None);
	private List<Movie> movieHistory = null;
	
	public Person() {
		
	}
	
	
	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;	
		
	}	
	
	
	public void setName(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	
	public String getName() {
		String name = new String(this.firstName + " "+ this.lastName);
		return name;
	}
	
	
	public void setBirthDate(int year, String month, int day) {
		try {
			this.birthDate = LocalDate.of(year, Month.valueOf(month), day);	
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
	
	public LocalDate getBirthDate() {
		return this.birthDate;
	}
	
	
	public void setDeathDate(int year, String month, int day) {
		try {
			this.deathDate = LocalDate.of(year, Month.valueOf(month), day);
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
		
	
	public LocalDate getDeathDate() {
		return this.deathDate;		
	}	
	
	
	public void addMovie(Movie...movies) {
		try {
		this.movieHistory.addAll(Arrays.asList(movies));
		}catch(NullPointerException e) {
			System.out.println(e);
		}
	}	
	
	
	public void setProfession(Profession...professions) {
		try {
			this.profession.addAll(Arrays.asList(professions));
			if(this.profession.contains(Profession.None)) {
				this.profession.remove(Profession.None);
			}
			
		}catch(NullPointerException e) {
			System.out.println(e);
		}
		
	}	
	
	
	public void setProfession(String[] professions) {
		try {
			for(String s:professions) {
				this.profession.add(Profession.valueOf(s));
				}
			if(this.profession.contains(Profession.None)) {
				this.profession.remove(Profession.None);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}		
	
	
	@Override
	public String toString() {
		String result;
		result = this.getName() + " " + this.getBirthDate().toString()+ " " + this.getDeathDate().toString()
				+ " " + this.GetProfessions().toString();
				
		return result;		
	}	
	
	
	public EnumSet<Profession> GetProfessions(){		
		return this.profession;
	}
	

}
 