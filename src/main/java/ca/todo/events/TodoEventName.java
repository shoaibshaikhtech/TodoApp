package ca.todo.events;

import java.util.HashMap;
import java.util.Map;

public enum TodoEventName {
	
	CREATED("CREATED", 1),
	COMPLETED("COMPLETED", 2),
	DELETED("DELETED",3);
	

	private final String key;
	private final Integer value;
	
	private static Map<Integer, TodoEventName> valueToTextMapping;

	TodoEventName(String key, Integer value) {
		this.key = key;
		this.value = value;
	}
	
	public static TodoEventName getStatus(Integer i){
        if(valueToTextMapping == null){
            initMapping();
        }
        return valueToTextMapping.get(i);
    }

    private static void initMapping(){
        valueToTextMapping = new HashMap<>();
        for(TodoEventName s : values()){
            valueToTextMapping.put(s.value, s);
        }
    }

	public String getKey() {
		return key;
	}

	public Integer getValue() {
		return value;
	}
}
