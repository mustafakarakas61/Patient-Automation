package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Helper.Helper;
import Model.doctorClass;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DoctorAddGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txt_name;
	private JTextField txt_surname;
	static doctorClass doctor_class;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoctorAddGUI frame = new DoctorAddGUI();
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
	public DoctorAddGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 464, 495);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_welcome = new JLabel("Ho\u015Fgeldiniz Say\u0131n ");
		lbl_welcome.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 24));
		lbl_welcome.setBounds(10, 11, 277, 50);
		contentPane.add(lbl_welcome);
		
		JLabel lbl_info = new JLabel("Eklemek \u0130stedi\u011Finiz doktora ait bilgileri giriniz.");
		lbl_info.setFont(new Font("Arial", Font.BOLD, 20));
		lbl_info.setBounds(10, 52, 442, 50);
		contentPane.add(lbl_info);
		
		JPanel panel_info_doctor = new JPanel();
		panel_info_doctor.setBackground(new Color(224, 255, 255));
		panel_info_doctor.setBounds(10, 92, 431, 353);
		contentPane.add(panel_info_doctor);
		panel_info_doctor.setLayout(null);
		
		JLabel lbl_name = new JLabel("Ad:");
		lbl_name.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lbl_name.setBounds(10, 11, 140, 66);
		panel_info_doctor.add(lbl_name);
		
		JLabel lbl_surname = new JLabel("Soyad:");
		lbl_surname.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lbl_surname.setBounds(10, 88, 140, 66);
		panel_info_doctor.add(lbl_surname);
		
		txt_name = new JTextField();
		txt_name.setFont(new Font("Arial", Font.ITALIC, 36));
		txt_name.setBounds(153, 11, 268, 66);
		panel_info_doctor.add(txt_name);
		txt_name.setColumns(10);
		
		txt_surname = new JTextField();
		txt_surname.setFont(new Font("Arial", Font.ITALIC, 36));
		txt_surname.setColumns(10);
		txt_surname.setBounds(153, 88, 268, 66);
		panel_info_doctor.add(txt_surname);
		
		JButton btn_clear = new JButton("TEM\u0130ZLE");
		btn_clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			txt_name.setText("");
			txt_surname.setText("");
				
			}
		});
		btn_clear.setBackground(new Color(255, 255, 204));
		btn_clear.setFont(new Font("Yu Gothic UI", Font.PLAIN, 39));
		btn_clear.setBounds(10, 239, 202, 103);
		panel_info_doctor.add(btn_clear);
		
		JButton btn_add = new JButton("EKLE");
		btn_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				doctor_class = new doctorClass();
				
				doctor_class.addDoctor(txt_name.getText(), txt_surname.getText());
				
				
			}
		});
		btn_add.setBackground(new Color(0, 204, 102));
		btn_add.setFont(new Font("Yu Gothic UI", Font.PLAIN, 39));
		btn_add.setBounds(219, 239, 202, 103);
		panel_info_doctor.add(btn_add);
	}
}
