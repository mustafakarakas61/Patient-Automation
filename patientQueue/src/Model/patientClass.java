package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.xdevapi.PreparableStatement;

import Helper.Helper;

public class patientClass extends patient {
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement preparedStatement = null;
	Connection con = conn.connDb();
	Helper helper;

	public patientClass() {
		super();
		// TODO Auto-generated constructor stub
	}

	public patientClass(int idpatients, int doctorID, String patientHour, String patientName, String patientSurname) {
		super(idpatients, doctorID, patientHour, patientName, patientSurname);
		// TODO Auto-generated constructor stub
	}

	public ArrayList<patient> getPatientList() throws SQLException {
		ArrayList<patient> list = new ArrayList<>();

		patient obj;
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM patients");
			while (rs.next()) {
				obj = new patient(rs.getInt("idpatients"), rs.getInt("doctorID"), rs.getString("patientHour"),
						rs.getString("patientName"), rs.getString("patientSurname"));
				list.add(obj);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	public boolean addPatient(char doctorID, String patientHour, String patientName,
			String patientSurname) {

		int key = 0;// Veri eklendi mi eklenmedi mi?
		//IDPatients kullanmýyoruz çünkü Primary Key
		String query = "INSERT INTO patients" + "(doctorID,patientHour,patientName,patientSurname) VALUES"
				+ "(?,?,?,?)";
		try {
			System.out.println("doktor id :"+doctorID);
			System.out.println("patient hour :"+patientHour);
			System.out.println("patient name :"+patientName);
			System.out.println("patient surname :"+patientSurname);
			
			
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(doctorID+""));
			preparedStatement.setString(2, patientHour);
			preparedStatement.setString(3, patientName);
			preparedStatement.setString(4, patientSurname);
			preparedStatement.executeUpdate();
			key = 1;
		} catch (SQLException e) {
			System.out.println("Eklenemedi\n"+e);
			
		}
		if(key == 1)
		{
			helper.showMsg("success");
			return true;
		}
		else
			return false;
	}

}
