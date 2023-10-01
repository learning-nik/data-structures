package test;



enum CriteriaType {
    
    REPETITIVE_ACCESS("Repetitive Access"),
    HIGH_FREQUENCY_OF_ACCESS("High-Frequency Of Access"),
    TIME_OF_DAY("Time Of Day"),
    FIRST_TIME_LOGIN("First-Time Login"),
    TIME_LAPSE_SINCE_LAST_ACCESS("Time Lapse Since Last Access"),
    REGISTERED_COMPUTER("Registered Computer"),
    REGISTERED_NETWORK("Registered Network"),
	EXCLUDED_USERS("Excluded Users"),
	GEO_USER_PROFILE_COUNTRY("GEO_USER_PROFILE_COUNTRY"), 
	INCLUDED_GEOLOCATION("Included Geolocations"),
    EXTERNAL_PROVIDER("External Provider"), 
    UNKNOWN_DEVICE("Unknown Device");


    /** The value associated with enum. */
    private String value;
    
    private CriteriaType(String newValue) {
        value = newValue;
    }
    
    @Override
    public String toString() {        
        return value;
    }
    /**
     * Gets the {@link CriteriaType} from the string passed.
     * 
     * @param id the id of the type
     * @return The corresponding Enum to the value passed. null if no value
     */
    public static CriteriaType getValue(String id) {
        for (CriteriaType type : CriteriaType.values()) {
            if (type.value.equalsIgnoreCase(id)) {
                return type;
            }
        }
        return null;
    }    
    
}



public class TestEnum {

	public static void main(String[] args) {
		System.out.println(CriteriaType.REGISTERED_NETWORK.toString());

	}

}
