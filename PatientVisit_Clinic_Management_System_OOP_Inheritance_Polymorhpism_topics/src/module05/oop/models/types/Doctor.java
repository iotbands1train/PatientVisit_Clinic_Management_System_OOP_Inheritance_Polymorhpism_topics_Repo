package module05.oop.models.types;

import java.util.ArrayList;

import module05.oop.models.Contact;
import module05.oop.models.Funds;
import module05.oop.models.Location;
import module05.oop.models.Name;
import module05.oop.models.Person;

public class Doctor extends Person {
	
	private String observations;
	private String prescription;
	private Person person;
	public Doctor(String observations, String prescription) {
		super();
		
		this.observations = observations;
		this.prescription = prescription;
	}
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	} 
	public Doctor(Person p) {
		super(updateDoctorSalary(p));
		person=p;
	}
	
	public static Person updateDoctorSalary(Person p) {
		Float salary=p.getFunds().getSalary();
		salary+=75_000.00f;
		p.getFunds().setSalary(salary);
		return p;
	}
	
	public String getObservations() {
		return observations;
	}
	public void setObservations(String observations) {
		this.observations = observations;
	}
	public String getPrescription() {
		return prescription;
	}
	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}
	@Override
	public String toString() {
		return "Doctor [observations=" + observations + ", prescription=" + prescription + ", person-data: "+person+"]";
	}
	
	

}
