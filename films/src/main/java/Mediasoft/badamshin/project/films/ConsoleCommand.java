package Mediasoft.badamshin.project.films;

public enum ConsoleCommand {
	Create("Create"),
	Show("Show"),
	Push("Push"),
	GetAll("GetAll"),
	Exit("Exit");
	
private String value;
	
	ConsoleCommand(String val){
		this.value = val;
		
	}
	
	@Override
	public String toString() {
		return this.value;
	}
	
	public String getValue() {
		return value;
	}
	
	public static ConsoleCommand getEnum(String val){
		ConsoleCommand cm = null;
		for(ConsoleCommand consoleCommand : values()) {
			if(consoleCommand.getValue().equalsIgnoreCase(val)) {
			cm = consoleCommand;	
			}
			
		}
		return cm;
		
		
	}

}
