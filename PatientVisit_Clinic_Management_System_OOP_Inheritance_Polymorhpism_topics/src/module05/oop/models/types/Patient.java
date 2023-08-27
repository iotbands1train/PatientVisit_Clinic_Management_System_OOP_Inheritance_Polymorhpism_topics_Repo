package module05.oop.models.types;

import module05.oop.models.Contact;
import module05.oop.models.Funds;
import module05.oop.models.Location;
import module05.oop.models.Name;
import module05.oop.models.Person;

/**
 * The Patient class represents a patient entity 
 * in the clinic management system.
 * It extends the functionality of the Person class 
 * with patient-specific attributes.
 */
public class Patient extends Person {
	// Reason for the patient's visit.
    private String reasonVisit; 
 // Indicates whether the patient has insurance.
    private boolean hasInsurance; 
 // Associated person data.
    private Person person; 
    /**
     * Parameterized constructor for creating a Patient instance with a 
     * reason for the visit and insurance status.
     * @param reasonVisit The reason for the patient's visit.
     * @param hasInsurance Indicates whether the patient has insurance.
     */
    public Patient(String reasonVisit, boolean hasInsurance) {
        super();
        this.reasonVisit = reasonVisit;
        this.hasInsurance = hasInsurance;
    }
    /**
     * Default constructor for creating a Patient instance.
     */
    public Patient() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor for creating a Patient instance with specific attributes.
     * @param id The unique identifier of the patient.
     * @param name The name of the patient.
     * @param location The location information of the patient.
     * @param contact The contact information of the patient.
     * @param funds The funds information of the patient.
     */
    public Patient(Long id, Name name, Location location, Contact contact, 
    		Funds funds) {
        super(id, name, location, contact, funds);
        // TODO Auto-generated constructor stub
    }
    /**
     * Constructor for creating a Patient instance based on a provided 
     * Person instance.
     * @param p The Person instance associated with the patient.
     */
    public Patient(Person p) {
        super(p);
        person = p;
    }
    /**
     * Retrieves the reason for the patient's visit.
     * @return The reason for the patient's visit.
     */
    public String getReasonVisit() {
        return reasonVisit;
    }
    /**
     * Sets the reason for the patient's visit.
     * @param reasonVisit The reason for the patient's visit.
     */
    public void setReasonVisit(String reasonVisit) {
        this.reasonVisit = reasonVisit;
    }

    /**
     * Checks whether the patient has insurance.
     * @return True if the patient has insurance, false otherwise.
     */
    public boolean isHasInsurance() {
        return hasInsurance;
    }
    /**
     * Sets the insurance status of the patient.
     * @param hasInsurance Indicates whether the patient has insurance.
     */
    public void setHasInsurance(boolean hasInsurance) {
        this.hasInsurance = hasInsurance;
    }
    /**
     * Returns a string representation of the Patient instance.
     * @return A string representation of the Patient instance.
     */
    @Override
    public String toString() {
        return "Patient [reasonVisit=" + reasonVisit + ", hasInsurance=" +
        		hasInsurance + ", person-data: " + person + "]";
    }
}
