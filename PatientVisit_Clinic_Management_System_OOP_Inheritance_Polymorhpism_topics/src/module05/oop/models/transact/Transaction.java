package module05.oop.models.transact;

import java.util.Date;
import java.util.Random;

import module05.oop.models.Funds;
import module05.oop.models.types.Doctor;
import module05.oop.models.types.Patient;
import module05.oop.models.types.Receptionist;

public class Transaction {
	
	private Long transactID;
	private Date transactDate;
	private Doctor doctor;
	private Receptionist receptionist;
	private Patient patient;
	private Funds charge; 
	
	
	
	
	public Funds getCharge() {
		return charge;
	}




	public void startCharge() {
		//set balance
		int points=getTotalPoints();	
		Float currentCost=getCostByPoints(points);		
		charge=new Funds(); 
		charge.setSalary(doctorValue());
		currentCost=insuranceCheck(currentCost); 
		charge.setCurrentBalance(currentCost);
		 
		 
	}
	
	
	
	
	public void setCharge(Funds charge) {
		this.charge = charge;
	}




	private Float doctorValue() {
		Float percentCost = doctor.getFunds().getSalary();
		percentCost=percentCost*0.01f;
		return percentCost;
	}
	private Float insuranceCheck(Float currentCost) {
		if(patient.isHasInsurance()) {
			currentCost=(float) (currentCost-(currentCost*.65));
		}
		return currentCost;
	}
	private Float getCostByPoints(int points) {
		Float balance=0f;
		 if(points<3) {
			 balance=175.00f;
		 }else if(points<6){
			 balance=675.00f;			 
		 }else {
			 balance=1275.00f;			 
		 }
		return balance;
	}
	private int getTotalPoints() {
		int total=0;
		total+=pointString(doctor.getObservations());
		total+=pointString(doctor.getPrescription());
		return total;
	}
	private int pointString(String str) { 
		return Integer.parseInt(str.charAt(0)+""); 
	}
	public Transaction() {
		super();
		transactID=new Random().nextLong(4444000001L, 4445000001L);
		transactDate=new Date();
	}
	public Long getTransactID() {
		return transactID;
	}
	public void setTransactID(Long transactID) {
		this.transactID = transactID;
	}
	public Date getTransactDate() {
		return transactDate;
	}
	public void setTransactDate(Date transactDate) {
		this.transactDate = transactDate;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		
		this.doctor = doctor;
	}
	public Receptionist getReceptionist() {
		return receptionist;
	}
	public void setReceptionist(Receptionist receptionist) {
		this.receptionist = receptionist;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	@Override
	public String toString() {
		return "Transaction [transactID=" + transactID + ", transactDate=" +
				transactDate + ", doctor= Dr. " + doctor.getName().getLname()
				+ " with ID=["+doctor.getId()+"], receptionist=" + 
				receptionist.getName().getFname() + " with ID=["
				+receptionist.getId()+"], patient=" + patient.getName().getFname() +
				" "+patient.getReasonVisit()+"]";
	}
	

}
