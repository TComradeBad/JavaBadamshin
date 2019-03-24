package Mediasoft.badamshin.project.films;

public enum Profession {
	Actor("Actor"),
	FilmDirector("FilmDirector"),
	Operator("Operator"),
	Producer("Producer"),
	Composer("Composer"),
	Designer("Designer"),
	FilmEditor("FilmEditor"),
	None("None");
private String value;
	
	Profession(String val){
		this.value = val;
		
	}
	
	@Override
	public String toString() {
		return this.value;
	}
	
	public String getValue() {
		return value;
	}
	
	public static Profession getEnum(String val){
		Profession prof = null;
		for(Profession profession : values()) {
			if(profession.getValue().equalsIgnoreCase(val)) {
			prof = profession;	
			}
			
		}
		return prof;
		
		
	}
	
	

}
