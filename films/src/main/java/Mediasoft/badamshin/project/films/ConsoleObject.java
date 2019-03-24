package Mediasoft.badamshin.project.films;

public enum ConsoleObject {
	Movie("Movie"),
	Person("Person");

	private String value;
	
	ConsoleObject(String val){
		this.value = val;
		
	}
	
	@Override
	public String toString() {
		return this.value;
	}
	
	public String getValue() {
		return value;
	}
	
	public static ConsoleObject getEnum(String val){
		ConsoleObject co = null;
		for(ConsoleObject consoleObject : values()) {
			if(consoleObject.getValue().equalsIgnoreCase(val)) {
			co = consoleObject;	
			}
			
		}
		return co;
		
		
	}

}
