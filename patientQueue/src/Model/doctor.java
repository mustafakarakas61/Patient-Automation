package Model;

import Helper.DBConnection;

public class doctor {

	public doctor() {
	}
	private int iddoctors;
	String doctorsName,doctorsSurname;
	DBConnection conn = new DBConnection();
	public doctor(int iddoctors, String doctorsName, String doctorsSurname) {
		this.iddoctors = iddoctors;
		this.doctorsName = doctorsName;
		this.doctorsSurname = doctorsSurname;
	}
	public doctor(int int1) {
		// TODO Auto-generated constructor stub
	}
	public int getIddoctors() {
		return iddoctors;
	}
	public void setIddoctors(int iddoctors) {
		this.iddoctors = iddoctors;
	}
	public String getDoctorsName() {
		return doctorsName;
	}
	public void setDoctorsName(String doctorsName) {
		this.doctorsName = doctorsName;
	}
	public String getDoctorsSurname() {
		return doctorsSurname;
	}
	public void setDoctorsSurname(String doctorsSurname) {
		this.doctorsSurname = doctorsSurname;
	}
	
	

}
