package module05.oop.main;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

import module05.oop.models.Person;
import module05.oop.models.StackOfPersons;
import module05.oop.models.transact.Appointment;
import module05.oop.models.transact.Transaction;
import module05.oop.models.types.Doctor;
import module05.oop.models.types.Patient;
import module05.oop.models.types.Receptionist;
import module05.oop.randompms.MyRandomPersonTypeData;

/**
 * The `PatientVisitMain` class serves as the core of the clinic management
 * system. It simulates the patient visit process, encompassing various
 * interactions between patients, doctors, receptionists, and transaction
 * handling.
 */
public class PatientVisitMain {
	static Scanner input = new Scanner(System.in);

	/**
	 * Handles the complete patient check-in process, including doctor observations,
	 * prescriptions, transaction handling, and updating patient's financials.
	 */
	public static Transaction checkInProcess(Transaction transact, ArrayList<Person> personDatabase, Float oldSalary) {
		System.out.println("[Receptionist] Need patients(personID):");
		Long id = Long.parseLong(input.nextLine());
		// Verify if the entered ID matches the patient's ID in the ongoing transaction.

		if (id.equals(transact.getPatient().getId())) {
			// Initialize the patient visit process...
			// ===================================================
			Patient patient = transact.getPatient();
			// Collect reason for the patient's visit.
			System.out.println("Transaction started....");
			System.out.println("Reason for Visit : ");
			patient.setReasonVisit(input.nextLine());
			// Check if the patient has insurance.

			System.out.println("Do you have insurance... ");
			String answer = input.nextLine();
			if (answer.toUpperCase().charAt(0) == 'Y') {
				patient.setHasInsurance(true);
			}
			// Display patient information and indicate waiting status.
			System.out.println(patient);
			System.out.println("[Rec] - > patient waiting... for Doctor");
			// ===================================================
			Doctor doc = new Doctor(randomPerson(personDatabase));
			doc.setObservations(MyRandomPersonTypeData.random_observation());
			System.out.println("Doctor's obversation = " + doc.getObservations());
			doc.setPrescription(MyRandomPersonTypeData.random_prescription());
			System.out.println("Doctor's prescription = " + doc.getPrescription());
			// ===================================================
			// Process patient's checkout and transaction details.
			System.out.println("Checkout -> " + patient.getName());
			System.out.println("===================================================");
			System.out.println("===========Processing Tranasction==================");
			System.out.println("===================================================");
			System.out.println(patient.getName() + ", are you ready to pay bill? 1-Yes");
			String inString = input.nextLine();
			int ans = Integer.parseInt(inString);
			if (ans == 1) {
				// Finalize the transaction details.
				transact.setDoctor(doc);
				transact.startCharge();
				Float currentBalance = transact.getCharge().getCurrentBalance();
				Float newSalary = transact.getPatient().getFunds().getSalary() - currentBalance;
				transact.getPatient().getFunds().setSalary(newSalary);
				transact.getCharge().setCurrentBalance(0f);
				patient = transact.getPatient();
				// Display updated salary information.
				System.out.println("old salary...." + oldSalary);
				System.out.println("new salary...." + patient.getFunds().getSalary());
				System.out.println("net..........." + (oldSalary - patient.getFunds().getSalary()));

				// Store the transaction with the current timestamp.
				transact = storeTransaction(transact);
			}

		} else {
			System.out.println("Person does not exist");
		}
		return transact;
	}

	/**
	 * The main method orchestrates the simulation of multiple patient visits,
	 * guiding through the check-in, doctor observations, prescription, and
	 * transaction processes.
	 */
	public static void main(String[] args) {
		ArrayList<Transaction> transact_database = new ArrayList<>();
		boolean again = false;
		System.out.println("");
		// Start the simulation loop for multiple patient visits.

		do {
			Transaction transact = null;
			ArrayList<Person> personDatabase = getPersonData();
			System.out.println("Loading ... clinic database");
			printList(personDatabase);

			// Initialize a new transaction instance.
			transact = new Transaction();

			// ===================================================
			Receptionist rec = new Receptionist(randomPerson(personDatabase));
			rec.setAppointments(appointmentForm());
			rec.setCurrentTimedate(new Date());
			transact.setReceptionist(rec);
			System.out.println(
					"Loading ... a random Receptionist [" + rec.getName().getFname() + "] will be helping you:");
			Patient patient = new Patient(randomPerson(personDatabase));
			Float oldSalary = patient.getFunds().getSalary();
			// ===================================================
			System.out.println("Random Patient - " + patient);
			System.out.println("  Patient current salary -> $" + patient.getFunds().getSalary());
			transact.setPatient(patient);
			System.out.println("Patient >>  " + rec.getAppointments().getApptType());
			// Initiate the patient check-in process.
			transact = checkInProcess(transact, personDatabase, oldSalary);
			rec.setTransactions(transact);
			// Store the completed transaction in the database.
			transact_database.add(transact);

			printTransaction(transact_database);

			// Check if the user wants to simulate another patient visit.
			System.out.println("1-Again");
			String againString = input.nextLine();
			again = againString.charAt(0) == '1' ? true : false;
		} while (again);

	}

	/**
	 * Creates an appointment based on user input for the appointment type. If the
	 * user selects an appointment, the patient is allowed to see the doctor
	 * immediately. If the user selects a walk-in visit, the patient will wait for
	 * their turn.
	 * 
	 * @return The created Appointment instance.
	 */
	private static Appointment appointmentForm() {
		Appointment appointment = new Appointment();

		// Ask the user if they have an appointment or if it's a walk-in visit
		System.out.println("Do you have an appointment or is this just a walk-in visit?");
		System.out.println("1 - Appointment | Any other key - Walk-in");
		String userInput = input.nextLine();

		String appointmentType;
		if (userInput.equals("1")) {
			// User has an appointment, they can see the doctor immediately
			System.out.println("You have an appointment. You may see the doctor now.");
			appointmentType = "Appointment";
		} else {
			// User has a walk-in visit, they'll need to wait for their turn
			System.out.println("This is a walk-in visit. You'll need to wait for your turn.");
			appointmentType = "Walk-in";
		}

		appointment.setApptType(appointmentType);
		return appointment;
	}

	/**
	 * Prints detailed information about each transaction in the transaction
	 * database.
	 * 
	 * @param transact_database The list of transactions to be printed.
	 */

	private static void printTransaction(ArrayList<Transaction> transact_database) {

		int i = 0;

		for (Transaction transaction : transact_database) {
			System.out.println(" =========== Transaction Receipt ======== ");
			System.out.print(" row#[" + i + "] ");
			System.out.print(" | T-ID = " + transaction.getTransactID());
			System.out.print(" | T-Receptionist = ID=" + transaction.getReceptionist().getId() + " - "
					+ transaction.getReceptionist().getName().getFname());
			System.out.print(" | T-Doctor Observation= " + transaction.getDoctor().getObservations());
			System.out.print(" | T-Patient reason= " + transaction.getPatient().getReasonVisit());
			System.out.print(" | T-Patient salary= " + transaction.getPatient().getFunds().getSalary());
			System.out.print(" | T-Patient balance= " + transaction.getPatient().getFunds().getCurrentBalance());
			System.out.print(" | T-Charge = " + transaction.getCharge().getCurrentBalance());
			System.out.println(" | T-TransactDate = " + transaction.getTransactDate());
			System.out.println(" ========================================= ");
			i++;
		}

	}

	/**
	 * Stores the completed transaction with the current timestamp.
	 * 
	 * @param transact The transaction to be stored.
	 * @return The stored transaction with the updated timestamp.
	 */
	private static Transaction storeTransaction(Transaction transact) {
		Transaction t = transact;
		Date timeStamp = new Date();
		t.setTransactDate(timeStamp);
		return t;
	}

	/**
	 * Generates a random person from the provided person database.
	 * 
	 * @param personDatabase The list of persons to choose from.
	 * @return A random person from the database.
	 */
	private static Person randomPerson(ArrayList<Person> personDatabase) {
		// TODO Auto-generated method stub
		return personDatabase.get(new Random().nextInt(0, personDatabase.size() - 1));
	}

	/**
	 * Prints the list of persons in the person database.
	 * 
	 * @param personDatabase The list of persons to be printed.
	 */
	private static void printList(ArrayList<Person> personDatabase) {
		int i = 0;
		for (Person person : personDatabase) {
			System.out.println("[" + i + "]=>" + person);
			i++;
		}

	}

	/**
	 * Retrieves a list of persons from the StackOfPersons database.
	 * 
	 * @return The ArrayList of persons from the database.
	 */
	private static ArrayList<Person> getPersonData() {
		// Create an instance of the StackOfPersons class (30-100)
		int max = new Random().nextInt(30, 100);

		// Create an instance of the StackOfPersons class
		StackOfPersons stack = new StackOfPersons(max);
		// Populate the stack with initial data
		bulkStackPersons(stack, max);
		stack.printAllPersons();
		return convertStackToArrayList(stack);
	}

	/**
	 * Fills the StackOfPersons database with a bulk of persons.
	 * 
	 * @param stk The StackOfPersons database to be filled.
	 * @param num The number of persons to add.
	 * @return The filled StackOfPersons database.
	 */
	private static StackOfPersons bulkStackPersons(StackOfPersons stk, int num) {

		for (int i = 0; i < num - 1; i++) {

			Person newPerson1 = new Person();
			stk.push(newPerson1);

		}
		return stk;
	}

	/**
	 * Converts the StackOfPersons database to an ArrayList of persons.
	 * 
	 * @param stack The StackOfPersons database to be converted.
	 * @return The ArrayList of persons converted from the database.
	 */
	private static ArrayList<Person> convertStackToArrayList(StackOfPersons stack) {
		ArrayList<Person> arrayList = new ArrayList<>();
		System.out.println("Stack size = " + stack.getPersonCount());
		System.out.println("ArrayList size = " + arrayList.size());
		int i = 0;
		for (i = stack.getPersonCount(); i > 0; i--) {
			arrayList.add(stack.pop());
		}
		System.out.println("Stack size = " + stack.getPersonCount());
		System.out.println("ArrayList size = " + arrayList.size());

		return arrayList;
	}

}
