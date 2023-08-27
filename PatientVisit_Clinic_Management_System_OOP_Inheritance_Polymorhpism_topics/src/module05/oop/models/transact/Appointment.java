package module05.oop.models.transact;

/**
 * This class represents an appointment type for a patient in 
 * the clinic management system.
 * It includes the type of appointment, such as consultation, 
 * follow-up, diagnostic, or procedure.
 */
public class Appointment {

    private String apptType;

    /**
     * Default constructor for Appointment class.
     */
    public Appointment() {
        super();
    }
    /**
     * Constructor for Appointment class with specified appointment type.
     * @param apptType The type of appointment.
     */
    public Appointment(String apptType) {
        super();
        this.apptType = apptType;
    }
    /**
     * Retrieves the appointment type.
     * @return The appointment type.
     */
    public String getApptType() {
        return apptType;
    }
    /**
     * Sets the appointment type.
     * @param apptType The appointment type to be set.
     */
    public void setApptType(String apptType) {
        this.apptType = apptType;
    }
    /**
     * Returns the string representation of the Appointment object.
     * @return A string containing the appointment type.
     */
    @Override
    public String toString() {
        return "Appointment [apptType=" + apptType + "]";
    }
}
