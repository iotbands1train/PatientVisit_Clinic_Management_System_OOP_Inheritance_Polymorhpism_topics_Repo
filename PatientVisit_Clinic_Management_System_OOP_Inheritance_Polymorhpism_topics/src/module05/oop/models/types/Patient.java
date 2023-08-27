package module05.oop.models.types;

import module05.oop.models.Contact;
import module05.oop.models.Funds;
import module05.oop.models.Location;
import module05.oop.models.Name;
import module05.oop.models.Person;

public class Patient  extends Person{
	
	
	private String reasonVisit;
	private boolean hasInsurance;
	private Person person;
	public Patient(String reasonVisit, boolean hasInsurance) {
		super();
		this.reasonVisit = reasonVisit;
		this.hasInsurance = hasInsurance;
	}
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Patient(Long id, Name name, Location location, Contact contact, Funds funds) {
		super(id, name, location, contact, funds);
		// TODO Auto-generated constructor stub
	}
	public Patient(Person p) {
		super(p);
		person=p;
	}
	public String getReasonVisit() {
		return reasonVisit;
	}
	public void setReasonVisit(String reasonVisit) {
		this.reasonVisit = reasonVisit;
	}
	public boolean isHasInsurance() {
		return hasInsurance;
	}
	public void setHasInsurance(boolean hasInsurance) {
		this.hasInsurance = hasInsurance;
	}
	@Override
	public String toString() {
		return "Patient [reasonVisit=" + reasonVisit + ", hasInsurance=" + hasInsurance +", person-data: "+person+ "]";
	}

	
}
