package module05.oop.models.transact;

import java.util.Date;
import java.util.Random;

import module05.oop.models.Funds;
import module05.oop.models.types.Doctor;
import module05.oop.models.types.Patient;
import module05.oop.models.types.Receptionist;
/**
 * This class represents a transaction that occurs when a patient 
 * visits the clinic.
 * It includes information about the transaction ID, date, doctor, 
 * receptionist, patient, and the associated charges.
 */
public class Transaction {
    // Attributes of the Transaction class
	private Long transactID;
	private Date transactDate;
	private Doctor doctor;
	private Receptionist receptionist;
	private Patient patient;
	private Funds charge; 

    /**
     * Default constructor for the Transaction class.
     * Initializes the transaction ID and date.
     */
	public Transaction() {
		super();
		transactID=new Random().nextLong(4444000001L, 4445000001L);
		transactDate=new Date();
	}
    /**
     * Retrieves the funds charge associated with the transaction.
     *
     * @return The funds charge.
     */
	public Funds getCharge() {
		return charge;
	}
    /**
     * Calculates and starts the charge for the transaction 
     * based on doctor observations and prescription.
     */
	public void startCharge() {
		//set balance
		int points=getTotalPoints();	
		Float currentCost=getCostByPoints(points);		
		charge=new Funds(); 
		charge.setSalary(doctorValue());
		currentCost=insuranceCheck(currentCost); 
		charge.setCurrentBalance(currentCost); 	 
	}
    /**
     * Retrieves the funds charge associated with the transaction.
     * @return The funds charge.
     */
	public void setCharge(Funds charge) {
		this.charge = charge;
	} 
    /**
     * Calculates the value based on the doctor's salary for the charge.
     * @return The calculated value.
     */ 
	private Float doctorValue() {
		Float percentCost = doctor.getFunds().getSalary();
		percentCost=percentCost*0.01f;
		return percentCost;
	}
    /**
     * Checks if the patient has insurance and adjusts the current
     *  cost accordingly.
     *
     * @param currentCost The initial cost.
     * @return The adjusted cost.
     */
	private Float insuranceCheck(Float currentCost) {
		if(patient.isHasInsurance()) {
			currentCost=(float) (currentCost-(currentCost*.65));
		}
		return currentCost;
	}
    /**
     * Calculates the cost based on the total points obtained 
     * from doctor observations and prescription.
     *
     * @param points The total points.
     * @return The calculated cost.
     */
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
    /**
     * Calculates and returns the total points based on doctor 
     * observations and prescription.
     *
     * @return The total points.
     */
	private int getTotalPoints() {
		int total=0;
		total+=pointString(doctor.getObservations());
		total+=pointString(doctor.getPrescription());
		return total;
	}
    /**
     * Converts the first character of a string to an integer.
     *
     * @param str The input string.
     * @return The converted integer.
     */
	private int pointString(String str) { 
		return Integer.parseInt(str.charAt(0)+""); 
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
    /**
     * Returns a string representation of the Transaction object.
     * @return A string containing transaction information.
     */
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
