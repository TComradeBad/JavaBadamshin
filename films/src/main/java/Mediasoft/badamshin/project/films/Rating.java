package Mediasoft.badamshin.project.films;

public enum Rating {
	G("G"),
	PG("PG"),
	PG13("PG13"),
	R("R"),
	NC17("NC17"),
	None("None");
	
private String value;
	
	Rating(String val){
		this.value = val;
		
	}
	
	@Override
	public String toString() {
		return this.value;
	}
	
	public String getValue() {
		return value;
	}
	
	public static Rating getEnum(String val){
		Rating rat = null;
		for(Rating rating : values()) {
			if(rating.getValue().equalsIgnoreCase(val)) {
			rat = rating;	
			}
			
		}
		return rat;
		
		
	}

}
