package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import Model.patientClass;

import javax.swing.JTextField;
import javax.swing.JButton;

public class PatientQueueGUI extends JFrame {

	static patientClass patient_class = new patientClass();

	private JPanel contentPane;

	private DefaultTableModel patienceModel;
	private Object[] patienceData = null;
	private JTable table_Patience;
	private JTextField txt_Editor;
	static boolean IsMainFrameOn = true;
	public static JLabel lbl_patientName;
	public static JLabel lbl_NowTime;
 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientQueueGUI frame = new PatientQueueGUI(patient_class);

					frame.setVisible(true);

					/*
					 * SimpleDateFormat shapeTime = new SimpleDateFormat("hh:mm:ss"); Date time =
					 * new Date();
					 */
					// lbl_NowTime.setText(shapeTime.format(time) + " ");

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 */
	public PatientQueueGUI(patientClass patient_class) throws SQLException {
		setBackground(Color.DARK_GRAY);
		patienceModel = new DefaultTableModel();
		Object[] colPatience = new Object[1];

		colPatience[0] = "BEKLEYEN HASTA LÝSTESÝ";

		patienceModel.setColumnIdentifiers(colPatience);

		patienceData = new Object[1];

		for (int i = 0; i < patient_class.getPatientList().size(); i++) {
			patienceData[0] = " " + patient_class.getPatientList().get(i).getPatientHour() + " "
					+ patient_class.getPatientList().get(i).getPatientName() + " "
					+ patient_class.getPatientList().get(i).getPatientSurname();
			patienceModel.addRow(patienceData);
		}

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbl_doctor = new JLabel("Dr. AY\u015EEN ABAY");
		lbl_doctor.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 36));
		lbl_doctor.setForeground(Color.WHITE);
		lbl_doctor.setBounds(10, 11, 462, 58);
		contentPane.add(lbl_doctor);

		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBorder(new LineBorder(new Color(255, 200, 0), 4));
		panel.setBounds(0, 64, 854, 645);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lbl_patientInside = new JLabel("\u0130\u00E7erideki Hasta");
		lbl_patientInside.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_patientInside.setFont(new Font("Verdana", Font.BOLD, 50));
		lbl_patientInside.setForeground(Color.ORANGE);
		lbl_patientInside.setBounds(10, 149, 834, 71);
		panel.add(lbl_patientInside);

		JLabel lbl_patientNumber = new JLabel("9");
		lbl_patientNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_patientNumber.setForeground(Color.ORANGE);
		lbl_patientNumber.setFont(new Font("Verdana", Font.BOLD, 180));
		lbl_patientNumber.setBounds(10, 220, 834, 162);
		panel.add(lbl_patientNumber);
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		lbl_patientName = new JLabel("HASTA ÝSMÝ");

		lbl_patientName.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_patientName.setForeground(Color.ORANGE);
		lbl_patientName.setFont(new Font("Verdana", Font.BOLD, 80));
		lbl_patientName.setBounds(10, 379, 834, 98);
		panel.add(lbl_patientName);

		SimpleDateFormat shapeDate = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();

		JLabel lbl_todayDate = new JLabel(shapeDate.format(date) + "" + " ");// + " "
		lbl_todayDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_todayDate.setForeground(Color.WHITE);
		lbl_todayDate.setFont(new Font("Arial Black", Font.ITALIC, 17));
		lbl_todayDate.setBounds(1224, 0, 126, 33);
		contentPane.add(lbl_todayDate);

		lbl_NowTime = new JLabel();// + " "
		lbl_NowTime.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_NowTime.setForeground(Color.WHITE);
		lbl_NowTime.setFont(new Font("Arial Black", Font.ITALIC, 17));
		lbl_NowTime.setBounds(1224, 19, 126, 33);
//-----------------------------------------------------------------SAAT
		Timer t = new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
				lbl_NowTime.setText(sdf.format(new java.util.Date()) + " ");
				String nowTime = lbl_NowTime.getText().toString();
				char[] hourMinute = new char[5];
				nowTime.getChars(0, 5, hourMinute, 0);
				// System.out.println(hourMinute); //HH:mm
				String hM = "";
				hM = hM.valueOf(hourMinute);
				//System.out.println(hM);			//HH:mm
				if (nowTime.equals("17:13:00 ")) {
					lbl_patientName.setText("Batuhan Yalçýntürk");
					lbl_patientNumber.setText(hM);
				}
				if (nowTime.equals("17:31:00 ")) {
					lbl_patientName.setText("El Eyyubi");
					lbl_patientNumber.setText(hM);
				}
			}
		});
		t.start();
//------------------------------------------------------------------Saat
		contentPane.add(lbl_NowTime);

		txt_Editor = new JTextField();
		txt_Editor.setDisabledTextColor(Color.DARK_GRAY);
		txt_Editor.setEditable(false);
		txt_Editor.setForeground(Color.WHITE);
		txt_Editor.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		txt_Editor.setHorizontalAlignment(SwingConstants.RIGHT);
		txt_Editor.setText("Mustafa Karaka\u015F  ");
		txt_Editor.setBorder(null);
		txt_Editor.setBackground(Color.DARK_GRAY);
		txt_Editor.setBounds(850, 709, 500, 20);
		contentPane.add(txt_Editor);
		txt_Editor.setColumns(10);

		JScrollPane scrollPane_Patience = new JScrollPane();
		scrollPane_Patience.setViewportBorder(new LineBorder(new Color(255, 200, 0), 4));
		scrollPane_Patience.setBackground(Color.DARK_GRAY);
		scrollPane_Patience.setBounds(850, 64, 501, 647);
		contentPane.add(scrollPane_Patience);

		table_Patience = new JTable(patienceModel);
		table_Patience.setEnabled(false);
		table_Patience.setSelectionBackground(Color.DARK_GRAY);
		table_Patience.setSelectionForeground(Color.ORANGE);
		table_Patience.setRowHeight(50);

		JTableHeader Theader = table_Patience.getTableHeader();
		Theader.setBackground(Color.ORANGE);
		Theader.setBorder(new LineBorder(new Color(255, 200, 0), 2));
		Theader.setFont(new Font("Arial", Font.CENTER_BASELINE, 35));

		Theader.setEnabled(false);

		// table_Patience.getColumnModel().getColumn(0).setResizable(false);

		table_Patience.setShowGrid(false);
		table_Patience.setFillsViewportHeight(true);
		table_Patience.setForeground(Color.ORANGE);
		table_Patience.setFont(new Font("Tahoma", Font.PLAIN, 35));
		table_Patience.setBackground(Color.DARK_GRAY);

		scrollPane_Patience.setViewportView(table_Patience);

	}
}
