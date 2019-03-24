package Mediasoft.badamshin.project.films;

public enum Genre {
	
	Action("Action"),
	Adventure("Adventure"),
	Comedy("Comedy"),
	Crime("Crime"),
	Drama("Drama"),
	Historical("Historical"),
	Horror("Horror"),
	Musical("Musical"),
	Scifi("Scifi"),
	War("War"),
	Western("Western"),
	None("None");
	
	private String value;
	
	Genre(String val){
		this.value = val;
		
	}
	
	@Override
	public String toString() {
		return this.value;
	}
	
	public String getValue() {
		return value;
	}
	
	public static Genre getEnum(String val){
		Genre gen = null;
		for(Genre genre : values()) {
			if(genre.getValue().equalsIgnoreCase(val)) {
			gen = genre;	
			}
			
		}
		return gen;
		
		
	}
}
