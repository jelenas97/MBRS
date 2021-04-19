package ${class.typePackage};

public interface MediatekaEnumerationInterface<T> {
	T getValue();
	
	static <E extends Enum<E> &  MediatekaEnumerationInterface<?>> E getEnumForValue(final Class<E> className, final Object value) {
		
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