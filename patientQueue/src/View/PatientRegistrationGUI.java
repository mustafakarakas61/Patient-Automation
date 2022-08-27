package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Model.doctorClass;
import Model.patient;
import Model.patientClass;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import java.awt.SystemColor;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class PatientRegistrationGUI extends JFrame {

	static doctorClass doctor_class = new doctorClass();
	static patientClass patient_class = new patientClass();
	
	private JPanel contentPane;
	private JTextField txt_patientName;
	private JTextField txt_patientSurname;
	private JLabel lbl_patientSurname;
	private JLabel lbl_patientTC;
	private JTextField txt_patientTC;
	private JPanel panel_doctors;
	private JLabel lbl_hour;
	private JComboBox comboBox_Hour;
	
	private DefaultTableModel doctorModel;
	private Object[] doctorData = null;
	
	public String hours[];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientRegistrationGUI frame = new PatientRegistrationGUI(doctor_class);
					frame.setResizable(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PatientRegistrationGUI(doctorClass doctor_class) throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 647, 610);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel_doctors = new JPanel();
		panel_doctors.setBackground(new Color(102, 205, 170));
		panel_doctors.setBounds(0, 303, 647, 307);
		contentPane.add(panel_doctors);
		panel_doctors.setLayout(null);

		JLabel lbl_doctorSelect = new JLabel("Doktor:");
		lbl_doctorSelect.setBounds(10, 11, 168, 57);
		panel_doctors.add(lbl_doctorSelect);
		lbl_doctorSelect.setForeground(Color.WHITE);
		lbl_doctorSelect.setFont(new Font("Arial", Font.BOLD, 31));

		JComboBox comboBox_Doctors = new JComboBox();
		comboBox_Doctors.setFont(new Font("Tahoma", Font.PLAIN, 31));
		comboBox_Doctors.setBounds(166, 11, 300, 57);

		/////////////////////////////////////////////////////////////////
		doctorData = new Object[5];
		comboBox_Doctors.addItem("<Doktor Seçiniz>");
		for (int i = 0; i < doctor_class.getDoctorList().size(); i++) {
			doctorData[i] = doctor_class.getDoctorList().get(i).getDoctorsName()+" "+doctor_class.getDoctorList().get(i).getDoctorsSurname();
			comboBox_Doctors.addItem(doctorData[i]);
		}
		panel_doctors.add(comboBox_Doctors);

		lbl_hour = new JLabel("Saat:");
		lbl_hour.setForeground(Color.WHITE);
		lbl_hour.setFont(new Font("Arial", Font.BOLD, 31));
		lbl_hour.setBounds(10, 79, 168, 57);
		panel_doctors.add(lbl_hour);

		comboBox_Hour = new JComboBox();
		comboBox_Hour.setFont(new Font("Tahoma", Font.PLAIN, 31));
		comboBox_Hour.setBounds(166, 79, 145, 57);

		hours = new String[5];

		hours[0] = "<Saat>";
		hours[1] = "09:10";
		hours[2] = "09:20";
		hours[3] = "09:30";
		hours[4] = "09:40";

		////
		
		//System.out.println(doctor_class.getDoctorId("Melik", "Karakaþ"));
		////
		
		for (int i = 0; i < hours.length; i++) {
			comboBox_Hour.addItem(hours[i]);
		}

		panel_doctors.add(comboBox_Hour);

		JButton btnNewButton = new JButton("Olu\u015Ftur");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String doctorWhoSelected;
				
				int tmp=0;
			doctorWhoSelected=comboBox_Doctors.getSelectedItem().toString();
			for(int i = 0; i < doctorWhoSelected.length();i++)
			{
				if(doctorWhoSelected.charAt(i)==' ')
				{
					tmp=i;
					break;
				}
			}//BURADA SORUN VAR !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			char[] name = new char[tmp],surname=new char[doctorWhoSelected.length()-1-tmp];
			doctorWhoSelected.getChars(0, tmp, name, 0);
			doctorWhoSelected.getChars(tmp+1, doctorWhoSelected.length(), surname, 0);
			String hM = "";
			String mH = "";
			mH = mH.valueOf(surname);
			hM = hM.valueOf(name);
		
			try {
			
				
				
				System.out.println(doctor_class.getDoctorId(hM, mH).toString().charAt(1)+"");//idyi çekiyor
		
			
			
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			try {
				patient_class.addPatient(
						doctor_class.getDoctorId(hM, mH).toString().charAt(1),
						comboBox_Hour.getSelectedItem().toString(), 
						txt_patientName.getText(), 
						txt_patientSurname.getText()
						);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				System.out.println(e1);
			}
				
			}
		});
		btnNewButton.setBackground(new Color(50, 205, 50));
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 31));
		btnNewButton.setBounds(321, 157, 145, 94);
		panel_doctors.add(btnNewButton);

		JButton btnTemizle = new JButton("Temizle");
		btnTemizle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_patientName.setText("");
				txt_patientSurname.setText("");
				txt_patientTC.setText("");
				comboBox_Doctors.setSelectedIndex(0);
				comboBox_Hour.setSelectedIndex(0);
			}
		});
		btnTemizle.setBackground(new Color(169, 169, 169));
		btnTemizle.setFont(new Font("Times New Roman", Font.PLAIN, 31));
		btnTemizle.setBounds(166, 157, 145, 94);
		panel_doctors.add(btnTemizle);

		JPanel panel_patientInfo = new JPanel();
		panel_patientInfo.setBackground(new Color(95, 158, 160));
		panel_patientInfo.setBounds(0, 0, 647, 610);
		contentPane.add(panel_patientInfo);
		panel_patientInfo.setLayout(null);

		JLabel lbl_patientInfo = new JLabel("Hasta Bilgileri");
		lbl_patientInfo.setForeground(Color.WHITE);
		lbl_patientInfo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lbl_patientInfo.setBounds(10, 11, 168, 57);
		panel_patientInfo.add(lbl_patientInfo);

		txt_patientName = new JTextField();
		txt_patientName.setHorizontalAlignment(SwingConstants.CENTER);
		txt_patientName.setFont(new Font("Tahoma", Font.PLAIN, 31));
		txt_patientName.setBounds(166, 79, 300, 57);
		panel_patientInfo.add(txt_patientName);
		txt_patientName.setColumns(10);

		JLabel lbl_patientName = new JLabel("Ad:");
		lbl_patientName.setForeground(Color.WHITE);
		lbl_patientName.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lbl_patientName.setBounds(10, 79, 168, 57);
		panel_patientInfo.add(lbl_patientName);

		txt_patientSurname = new JTextField();
		txt_patientSurname.setHorizontalAlignment(SwingConstants.CENTER);
		txt_patientSurname.setFont(new Font("Tahoma", Font.PLAIN, 31));
		txt_patientSurname.setColumns(10);
		txt_patientSurname.setBounds(166, 147, 300, 57);
		panel_patientInfo.add(txt_patientSurname);

		lbl_patientSurname = new JLabel("Soyad:");
		lbl_patientSurname.setForeground(Color.WHITE);
		lbl_patientSurname.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lbl_patientSurname.setBounds(10, 147, 168, 57);
		panel_patientInfo.add(lbl_patientSurname);

		lbl_patientTC = new JLabel("TC Kimlik No:");
		lbl_patientTC.setForeground(Color.WHITE);
		lbl_patientTC.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lbl_patientTC.setBounds(10, 214, 168, 57);
		panel_patientInfo.add(lbl_patientTC);

		txt_patientTC = new JTextField();
		txt_patientTC.setHorizontalAlignment(SwingConstants.CENTER);
		txt_patientTC.setFont(new Font("Tahoma", Font.PLAIN, 31));
		txt_patientTC.setColumns(10);
		txt_patientTC.setBounds(166, 214, 300, 57);
		panel_patientInfo.add(txt_patientTC);
	}
}
