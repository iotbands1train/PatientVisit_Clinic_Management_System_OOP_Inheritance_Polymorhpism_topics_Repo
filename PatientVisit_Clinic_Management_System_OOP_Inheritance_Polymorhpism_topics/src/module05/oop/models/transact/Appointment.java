package module05.oop.models.transact;

public class Appointment {
	
	private String apptType;

	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Appointment(String apptType) {
		super();
		this.apptType = apptType;
	}

	public String getApptType() {
		return apptType;
	}

	public void setApptType(String apptType) {
		this.apptType = apptType;
	}

	@Override
	public String toString() {
		return "Appointment [apptType=" + apptType + "]";
	}

	 

}
