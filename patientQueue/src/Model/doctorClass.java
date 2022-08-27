package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Helper.Helper;

public class doctorClass extends doctor {
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement preparedStatement = null;
	Connection con = conn.connDb();
	static Helper helper ;

	public doctorClass() {
		super();
		// TODO Auto-generated constructor stub
	}

	public doctorClass(int iddoctors, String doctorsName, String doctorsSurname) {
		super(iddoctors, doctorsName, doctorsSurname);
		// TODO Auto-generated constructor stub
	}

	public ArrayList<doctor> getDoctorList() throws SQLException {
		ArrayList<doctor> list = new ArrayList<>();

		doctor obj;
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM doctors");
			while (rs.next()) {
				obj = new doctor(rs.getInt("iddoctors"), rs.getString("doctorsName"), rs.getString("doctorsSurname"));
				list.add(obj);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<Integer> getDoctorId(String hM, String mH) throws SQLException {
		ArrayList<Integer> list = new ArrayList<>();

		Integer obj;
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM patients.doctors WHERE doctorsName = '" + hM
					+ "' AND doctorsSurname = '" + mH + "'");

			while (rs.next()) {
				obj = new Integer(rs.getInt("iddoctors"));
				if (rs.getInt("iddoctors") > 0) {
					list.add(obj);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean addDoctor(String doctorsName, String doctorsSurname) {
		int key = 0;

		String query = "INSERT INTO doctors" + "(doctorsName,doctorsSurname) VALUES" + "(?,?)";

		try {
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, doctorsName);
			preparedStatement.setString(2, doctorsSurname);
			preparedStatement.executeUpdate();
			key = 1;
		} catch (SQLException e) {
			System.out.println("Eklenemedi\n" + e);
		}

		if (key == 1)
		{
			helper.showMsg("success");
			return true;
		}
		else
			return false;
	}

}
