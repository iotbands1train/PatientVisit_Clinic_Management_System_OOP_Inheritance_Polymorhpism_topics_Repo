package module05.oop.models;

import module05.oop.randompms.MyRandomPersonData;

/**
 * The Location class represents the address information of a person.
 */
public class Location {
    private Long locationID;
    private Short streetNo;
    private String streetName;
    private String city;
    private String state;
    private Integer zip;

    /**
     * Default constructor for Location class.
     * Initializes address components with random values.
     */
    public Location() {
        super();
        this.streetNo = (short) Math.abs(MyRandomPersonData.random(1, 21222));
        this.streetName = MyRandomPersonData.randomStreet();
        this.city = MyRandomPersonData.randomCity();
        this.state = MyRandomPersonData.randomState();
        this.zip = (int) Math.abs(MyRandomPersonData.random(21222, 92992));

        String combinedValue = streetNo + streetName + city + state + zip;
        this.locationID = charsDecimalValuesOfString(combinedValue);
    }

    /**
     * Parameterized constructor for Location class.
     *
     * @param streetNo   The street number of the address.
     * @param streetName The street name of the address.
     * @param city       The city of the address.
     * @param state      The state of the address.
     * @param zip        The ZIP code of the address.
     */
    public Location(Short streetNo, String streetName, String city, String state, Integer zip) {
        super();
        this.streetNo = streetNo;
        this.streetName = streetName;
        this.city = city;
        this.state = state;
        this.zip = zip;

        String combinedValue = streetNo + streetName + city + state + zip;
        this.locationID = charsDecimalValuesOfString(combinedValue);
    }

    /**
     * Convert characters to decimal values and calculate their sum.
     *
     * @param input The input string.
     * @return The sum of decimal values of characters in the input string.
     */
    private long charsDecimalValuesOfString(String input) {
        long result = 0;
        for (char c : input.toCharArray()) {
            result += (long) c; // Adding the decimal value of the character
        }
        return result;
    }

    /**
     * Get the location ID.
     *
     * @return The location ID.
     */
    public Long getLocationID() {
        return locationID;
    }

    /**
     * Set the location ID.
     *
     * @param locationID The location ID to set.
     */
    public void setLocationID(Long locationID) {
        this.locationID = locationID;
    }

    /**
     * Get the street number.
     *
     * @return The street number.
     */
    public Short getStreetNo() {
        return streetNo;
    }

    /**
     * Set the street number.
     *
     * @param streetNo The street number to set.
     */
    public void setStreetNo(Short streetNo) {
        this.streetNo = streetNo;
    }

    /**
     * Get the street name.
     *
     * @return The street name.
     */
    public String getStreetName() {
        return streetName;
    }

    /**
     * Set the street name.
     *
     * @param streetName The street name to set.
     */
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    /**
     * Get the city.
     *
     * @return The city.
     */
    public String getCity() {
        return city;
    }

    /**
     * Set the city.
     *
     * @param city The city to set.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Get the state.
     *
     * @return The state.
     */
    public String getState() {
        return state;
    }

    /**
     * Set the state.
     *
     * @param state The state to set.
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Get the ZIP code.
     *
     * @return The ZIP code.
     */
    public Integer getZip() {
        return zip;
    }

    /**
     * Set the ZIP code.
     *
     * @param zip The ZIP code to set.
     */
    public void setZip(Integer zip) {
        this.zip = zip;
    }

    /**
     * Format the ZIP code.
     *
     * @return The formatted ZIP code.
     */
    private String showZip() {
        return String.format("%05d", zip);
    }

    /**
     * Convert the Location object to a string representation.
     *
     * @return The string representation of Location.
     */
    @Override
    public String toString() {
        return "Location [locationID=" + locationID + ", streetNo=" + streetNo + ", streetName=" + streetName
                + ", city=" + city + ", state=" + state + ", zip=" + showZip() + "]";
    }
}
