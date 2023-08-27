package module05.oop.models.types;

import module05.oop.models.Person;

/**
 * The Doctor class represents a doctor entity in the 
 * clinic management system.
 * It extends the functionality of the Person class with 
 * doctor-specific attributes.
 */
public class Doctor extends Person {

	// Observations made by the doctor.
	private String observations;
	// Prescription provided by the doctor.
	private String prescription;
	// Associated person data.
	private Person person;

	/**
	 * Parameterized constructor for creating a Doctor 
	 * instance with observations and prescription.
	 * 
	 * @param observations Observations made by the doctor.
	 * @param prescription Prescription provided by the doctor.
	 */
	public Doctor(String observations, String prescription) {
		super();
		this.observations = observations;
		this.prescription = prescription;
	}

	/**
	 * Default constructor for creating a Doctor instance.
	 */
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor for creating a Doctor instance based 
	 * on a provided Person instance.
	 * 
	 * @param p The Person instance associated with the doctor.
	 */
	public Doctor(Person p) {
		super(updateDoctorSalary(p));
		person = p;
	}
	/**
	 * Updates the salary of the provided Person instance 
	 * to reflect the doctor's salary increase.
	 * 
	 * @param p The Person instance to be updated.
	 * @return The updated Person instance.
	 */
	public static Person updateDoctorSalary(Person p) {
		Float salary = p.getFunds().getSalary();
		salary += 75_000.00f;
		p.getFunds().setSalary(salary);
		return p;
	}
	/**
	 * Retrieves the observations made by the doctor.
	 * @return The observations made by the doctor.
	 */
	public String getObservations() {
		return observations;
	}
	/**
	 * Sets the observations made by the doctor.
	 * @param observations The observations made by 
	 * the doctor.
	 */
	public void setObservations(String observations) {
		this.observations = observations;
	}

	/**
	 * Retrieves the prescription provided by the doctor. 
	 * @return The prescription provided by the doctor.
	 */
	public String getPrescription() {
		return prescription;
	}
	/**
	 * Sets the prescription provided by the doctor. 
	 * @param prescription The prescription provided by
	 *  the doctor.
	 */
	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}
	/**
	 * Returns a string representation of the Doctor instance.
	 * @return A string representation of the Doctor instance.
	 */
	@Override
	public String toString() {
		return "Doctor [observations=" + observations + ", prescription=" + prescription + ", person-data: " + person
				+ "]";
	}
}
