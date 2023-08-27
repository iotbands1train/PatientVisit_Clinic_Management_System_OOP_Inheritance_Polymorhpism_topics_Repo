package module05.oop.models.types;
 
import java.util.Date;

import module05.oop.models.Contact;
import module05.oop.models.Funds;
import module05.oop.models.Location;
import module05.oop.models.Name;
import module05.oop.models.Person;
import module05.oop.models.transact.Appointment;
import module05.oop.models.transact.Transaction;

public class Receptionist  extends Person{
	
	private Date currentTimedate;
	private Appointment appointments;
	private Transaction transactions;
	private Person person;
	public Receptionist(Date currentTimedate, Appointment appointments, Transaction transactions) {
		super();
		this.currentTimedate = currentTimedate;
		this.appointments = appointments;
		this.transactions = transactions;
	}
	public Receptionist() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Receptionist(Long id, Name name, Location location, Contact contact, Funds funds) {
		super(id, name, location, contact, funds);
		// TODO Auto-generated constructor stub
	}
	public Receptionist(Person p) {
		super(p);
		person=p;
	}
	public Date getCurrentTimedate() {
		return currentTimedate;
	}
	public void setCurrentTimedate(Date currentTimedate) {
		this.currentTimedate = currentTimedate;
	}
	public Appointment getAppointments() {
		return appointments;
	}
	public void setAppointments(Appointment appointments) {
		this.appointments = appointments;
	}
	public Transaction getTransactions() {
		return transactions;
	}
	public void setTransactions(Transaction transactions) {
		this.transactions = transactions;
	}
	@Override
	public String toString() {
		return "Receptionist [currentTimedate=" + currentTimedate + ", appointments=" + appointments + ", transactions="
				+ transactions +", person-data: "+person+ "]";
	}
	 

	
	
}

