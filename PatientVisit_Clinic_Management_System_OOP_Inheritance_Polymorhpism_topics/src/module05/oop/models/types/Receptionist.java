package module05.oop.models.types;

import java.util.Date;

import module05.oop.models.Contact;
import module05.oop.models.Funds;
import module05.oop.models.Location;
import module05.oop.models.Name;
import module05.oop.models.Person;
import module05.oop.models.transact.Appointment;
import module05.oop.models.transact.Transaction;

/**
 * The Receptionist class represents a receptionist entity in the clinic
 * management system. It extends the functionality of the Person class with
 * receptionist-specific attributes.
 */
public class Receptionist extends Person {
	// Current date and time for the receptionist.
	private Date currentTimedate;
	// Appointments associated with the receptionist.
	private Appointment appointments;
	// Transactions associated with the receptionist.
	private Transaction transactions;
	// Associated person data.
	private Person person;

	/**
	 * Parameterized constructor for creating a Receptionist 
	 * instance with current
	 * time, appointments, and transactions.
	 * 
	 * @param currentTimedate The current date and time for the receptionist.
	 * @param appointments    Appointments associated with the receptionist.
	 * @param transactions    Transactions associated with the receptionist.
	 */
	public Receptionist(Date currentTimedate, Appointment appointments, 
			Transaction transactions) {
		super();
		this.currentTimedate = currentTimedate;
		this.appointments = appointments;
		this.transactions = transactions;
	}

	/**
	 * Default constructor for creating a Receptionist instance.
	 */
	public Receptionist() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor for creating a Receptionist instance with specific attributes.
	 * 
	 * @param id       The unique identifier of the receptionist.
	 * @param name     The name of the receptionist.
	 * @param location The location information of the receptionist.
	 * @param contact  The contact information of the receptionist.
	 * @param funds    The funds information of the receptionist.
	 */
	public Receptionist(Long id, Name name, Location location, 
			Contact contact, Funds funds) {
		super(id, name, location, contact, funds);
		// TODO Auto-generated constructor stub
	}
	/**
	 * Constructor for creating a Receptionist instance based on a 
	 * provided Person instance. 
	 * @param p The Person instance associated with the receptionist.
	 */
	public Receptionist(Person p) {
		super(p);
		person = p;
	}
	/**
	 * Retrieves the current date and time for the receptionist. 
	 * @return The current date and time for the receptionist.
	 */
	public Date getCurrentTimedate() {
		return currentTimedate;
	}
	/**
	 * Sets the current date and time for the receptionist. 
	 * @param currentTimedate The current date and time for the receptionist.
	 */
	public void setCurrentTimedate(Date currentTimedate) {
		this.currentTimedate = currentTimedate;
	}
	/**
	 * Retrieves the appointments associated with the receptionist. 
	 * @return The appointments associated with the receptionist.
	 */
	public Appointment getAppointments() {
		return appointments;
	}
	/**
	 * Sets the appointments associated with the receptionist. 
	 * @param appointments The appointments associated with the receptionist.
	 */
	public void setAppointments(Appointment appointments) {
		this.appointments = appointments;
	}
	/**
	 * Retrieves the transactions associated with the receptionist. 
	 * @return The transactions associated with the receptionist.
	 */
	public Transaction getTransactions() {
		return transactions;
	}
	/**
	 * Sets the transactions associated with the receptionist. 
	 * @param transactions The transactions associated with the receptionist.
	 */
	public void setTransactions(Transaction transactions) {
		this.transactions = transactions;
	}
	/**
	 * Returns a string representation of the Receptionist instance. 
	 * @return A string representation of the Receptionist instance.
	 */
	@Override
	public String toString() {
		return "Receptionist [currentTimedate=" + currentTimedate +
				", appointments=" + appointments + ", transactions="
				+ transactions + ", person-data: " + person + "]";
	}
}
