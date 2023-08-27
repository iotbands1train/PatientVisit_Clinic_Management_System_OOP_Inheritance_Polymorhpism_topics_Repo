package module05.oop.randompms;

import java.util.ArrayList;
import java.util.Random;

/**
 * This class provides methods to generate random data related to person types.
 */
public class MyRandomPersonTypeData {
	/**
	 * Generates a random observation for a doctor's visit.	 *
	 * @return A random observation.
	 */
	public static String random_observation() {
		String[] OBSERVATIONS = { "1*see a specialization doctor", 
				"2*common illness", "3*need x-ray visit" };
		return randomElementFromStringArray(OBSERVATIONS);
	}
	/**
	 * Generates a random observation for a doctor's visit.	 *
	 * @return A random observation.
	 */
	public static String random_prescription() {
		String[] PRESCRIPTION = { "3*Antibiotics and plenty of rest",
				"2*Pain relievers and fluids",
				"3*Anti-inflammatory medication", 
				"2*Prescription medication as directed",
				"4*Physical therapy sessions", "5*Specialized treatment plan", 
				"1*Follow-up appointments" };
		return randomElementFromStringArray(PRESCRIPTION);
	}
	/**
	 * Generates a random reason for a patient's visit.	 *
	 * @return A random reason for the visit.
	 */
	public static String random_reasonVisit() {
		String[] REASON_VISITS = { "Routine checkup", "Flu symptoms", 
				"Injury assessment", "Follow-up appointment",
				"X-ray required", "Health consultation", "Vaccination", 
				"Chronic condition management" };
		return randomElementFromStringArray(REASON_VISITS);
	}
	/**
	 * Generates a random boolean value to indicate 
	 * whether a patient has insurance or not.
	 *
	 * @return A random boolean value.
	 */
	public static boolean random_hasInsurance() {
		return new Random().nextBoolean();
	}
	/**
	 * Generates a random list of appointment types.
	 * @return A list of random appointment types.
	 */
	public static ArrayList<String> random_appointments() {

		String[] APPOINTMENT_TYPES = { "Consultation", "Follow-up", 
				"Diagnostic", "Procedure" };
		int numAppointments = new Random().nextInt(1, APPOINTMENT_TYPES.length);
		ArrayList<String> appointments = new ArrayList<>();
		for (int i = 0; i < numAppointments; i++) {
			String randomAppointment = randomElementFromStringArray(APPOINTMENT_TYPES);
			appointments.add(randomAppointment);
		}
		return appointments;
	}
	/**
	 * Retrieves a random element from a given array.
	 *
	 * @param arr The array to choose from.
	 * @return A randomly selected element from the array.
	 */
	public static String randomElementFromStringArray(String[] arr) {
		if (arr == null || arr.length == 0) {
			throw new IllegalArgumentException("Array must not be null or empty");
		}
		int randomIndex = new Random().nextInt(arr.length);
		return arr[randomIndex];
	}
}
