package Mediasoft.badamshin.project.films;
import Mediasoft.badamshin.project.films.db.exception.MovieDataSourceException;
import Mediasoft.badamshin.project.films.db.service.*;

import java.util.*;

public class App 
{ 
	private static ArrayList<Movie> movieArray = new ArrayList<Movie>();
	
	private static ArrayList<Person> personArray = new ArrayList<Person>();

	public static void main( String[] args )
    {
		
        Terminal.terminalCycle();
        System.out.print("exiting");
    }
    
	///Класс обработки консольных команд
	public static class Terminal {
		
		public static void terminalCycle() {
			
			Scanner in = new Scanner(System.in);
			first:{
				while(true) {
					try {
						String inputString= in.nextLine();
						String[] stringMassiv = inputString.split(" ");
						ConsoleCommand command = ConsoleCommand.getEnum(stringMassiv[0]);
						switch(command) {
							case Create:{
								createSwitch(stringMassiv);
								break;
							}
							case Show:{
								showSwitch(stringMassiv);
								break;
							}
							case Exit:{
								System.out.println("Выход из программы");
								break first;
							}
							case Push:{
								pushSwitch(stringMassiv);
								break;
							}
							case GetAll:{
								getAllSwitch(stringMassiv);
								break;
							}
							default: System.out.println("не введена нужная команда");
							}
						
					}catch(Exception e){
						System.out.println(e.getMessage());
					}
				}
			}
		}
		
		///Выбор типа обЪекта для получения массива из базы данных
		private static void getAllSwitch(String[] stringMassiv) {
			ConsoleObject consoleObject = ConsoleObject.getEnum(stringMassiv[1]);
			switch(consoleObject) {
			case Movie:{
				getAllMovie();
				System.out.println("Done");
				break;
			}
			default: System.out.println("неверное имя класса");
			}
			
		}

		///Получение массива фильмов и вывод на консоль
		private static void getAllMovie() {
			try{
				MovieService movieService = new MovieDatabaseService();
				List<Movie> movies = movieService.getAllMovie();
				for(Movie movie : movies) {
					System.out.println(movie.toString());
				}
			}catch(MovieDataSourceException mdse) {
				mdse.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}

		///Выбор типа объекта для отправления массива в базу данных
		private static void pushSwitch(String[] stringMassiv) {
			ConsoleObject consoleObject = ConsoleObject.getEnum(stringMassiv[1]);
			switch(consoleObject) {
			case Movie:{
				pushToDb();
				break;
			}
			default: System.out.println("неверное имя класса");
			}
			
		}

		///Отправка в базу данных массива фильмо
		private static void pushToDb() {
			try{
				MovieService movieService = new MovieDatabaseService();
				movieService.pushMoviestoDB(movieArray);
			}catch(MovieDataSourceException mdse) {
				mdse.printStackTrace();
			}
			System.out.println("Done");
			System.out.println();
		}

		///Выбор типа объекта для
		private static void createSwitch(String[] creatingClass){
			ConsoleObject consoleObject = ConsoleObject.getEnum(creatingClass[1]);
			switch(consoleObject) {
			case Movie:{
				createMovie();
				break;
			}
			case Person:{
				createPerson();
				break;
			}
			default: System.out.println("неверное имя класса");
			
			
			}			
		}
		
		///Создание фильма
		private static void createMovie(){
			try {
			Movie movie=new Movie();
			Scanner setter=new Scanner(System.in);
			
			System.out.print("Title="); 
			movie.setTitle(setter.nextLine());
			
			System.out.print("Slogan = "); 
			movie.setSlogan(setter.nextLine());
			
			System.out.println("Creation Date"); 
			
			System.out.print("year = "); 
			int year=setter.nextInt();
			setter.nextLine();
			
			System.out.print("month = "); 
			String month=setter.nextLine();
			
			System.out.print("day = ");
			int day=setter.nextInt();
			movie.setCreationDate(year, month, day);
			
			System.out.print("Genres = "); 
			setter.nextLine();
			String genreStr=setter.nextLine();
			String[] genres=genreStr.split(" ");
			movie.setGenres(genres);
			
			System.out.print("Rating = ");
			movie.setRating(setter.nextLine());
			
			System.out.print("Budget = "); 
			movie.setBudget(setter.nextInt());
			
			System.out.print("fees = "); 
			movie.setFees(setter.nextInt());
			
			movieArray.add(movie);
			}catch(Exception e) {
				System.out.println(e);
				}
			
		}
		
		///Создание персоны
		private static void createPerson() {
			try {
			Person person = new Person();
			Scanner setter=new Scanner(System.in);
			
			System.out.print("first name="); 
			String firstName = setter.nextLine();
			
			System.out.print("last name="); 
			String lastName = setter.nextLine();
			person.setName(firstName, lastName);
			
			System.out.println("birth date");
			
			System.out.print("year = "); 
			int birthYear = setter.nextInt();
			setter.nextLine();
			
			System.out.print("month = ");
			String birthMonth = setter.nextLine();
			
			System.out.print("day = "); 
			int birthDay = setter.nextInt();
			setter.nextLine();
			
			person.setBirthDate(birthYear, birthMonth, birthDay);
			
			System.out.println("death date");
			
			System.out.print("year = "); 
			int deathYear = setter.nextInt();
			setter.nextLine();
			
			System.out.print("month = "); 
			String deathMonth = setter.nextLine();
			
			System.out.print("day = "); 
			int deathDay = setter.nextInt();
			setter.nextLine();
			
			person.setDeathDate(deathYear, deathMonth, deathDay);
			
			System.out.print("Professions = ");
			String professionsStr = setter.nextLine();
			String[] professions = professionsStr.split(" ");
			person.setProfession(professions);
			
			personArray.add(person);
			}catch(Exception e) {
				System.out.println(e);
				}
			
		}	
		
		///Выбор типа объекта для вывода на консоль массива
		private static void showSwitch(String[] showingClass) {
			ConsoleObject consoleObject = ConsoleObject.getEnum(showingClass[1]);
			switch(consoleObject) {
			case Movie:{
				showMovies();
				break;
			}
			case Person:{
				showPerson();
				break;
			}
			default: System.out.println("неверное имя класса");
			}
		}

		///Вывод на консоль массива фильмов
		private static void showMovies() {
			
			for(Movie movie :App.movieArray) {
				System.out.println(movie);
			}
						
		}

		///Вывод на консоль массива персон
		private static void showPerson() {
			for(Person person:App.personArray) {
				System.out.println(person);
			}
						
		}
		}
	}
