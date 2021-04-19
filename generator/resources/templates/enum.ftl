package ${enum.typePackage};

public enum ${enum.name} implements MediatekaEnumerationInterface<String> {
	
	private final String value;
	
	${enum.name}(String value) { this.value = value; }
	
	@Override
	public String getValue() { return value; }

}