package Model;

import Helper.DBConnection;

public class patient {
	public patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	private int idpatients,doctorID;
	String patientHour, patientName, patientSurname;
	DBConnection conn = new DBConnection();
	public patient(int idpatients, int doctorID, String patientHour, String patientName, String patientSurname) {
		super();
		this.idpatients = idpatients;
		this.doctorID = doctorID;
		this.patientHour = patientHour;
		this.patientName = patientName;
		this.patientSurname = patientSurname;
	}
	public int getIdpatients() {
		return idpatients;
	}
	public void setIdpatients(int idpatients) {
		this.idpatients = idpatients;
	}
	public int getDoctorID() {
		return doctorID;
	}
	public void setDoctorID(int doctorID) {
		this.doctorID = doctorID;
	}
	public String getPatientHour() {
		return patientHour;
	}
	public void setPatientHour(String patientHour) {
		this.patientHour = patientHour;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getPatientSurname() {
		return patientSurname;
	}
	public void setPatientSurname(String patientSurname) {
		this.patientSurname = patientSurname;
	}
	
	
	

}
