package ${class.typePackage};

public interface ${app_name}EnumerationInterface<T> {
	T getValue();
	
	static <E extends Enum<E> &  ${app_name}EnumerationInterface<?>> E getEnumForValue(final Class<E> className, final Object value) {
		
		E[] possibleValues = className.getEnumConstants();
		E returnValue = null;
		
		for(E certainEnum : possibleValues) {
			if (certainEnum.getValue().equals(value)) {
				returnValue = certainEnum;
			}
		}
	
		return returnValue;
	}
}