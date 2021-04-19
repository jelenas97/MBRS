package ${enum.typePackage};

public enum ${enum.name} implements ${app_name}EnumerationInterface<String> {
	
<#list values as value>
    ${value?upper_case}("${value?lower_case}")<#sep>,</#sep>
</#list>
<#lt>;
	
	private final String value;
	
	${enum.name}(String value) { this.value = value; }
	
	@Override
	public String getValue() { return value; }

}
