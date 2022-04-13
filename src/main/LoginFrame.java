package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField loginIdInputField;
	private JPasswordField loginPasswordInputField;
	private JButton loginBtn;
	private JButton joinBtn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(253, 245, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel loginIdLabel = new JLabel("아이디");
		loginIdLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		loginIdLabel.setBounds(103, 71, 59, 18);
		contentPane.add(loginIdLabel);
		
		JLabel loginPwLabel = new JLabel("비밀번호");
		loginPwLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		loginPwLabel.setBounds(103, 116, 59, 18);
		contentPane.add(loginPwLabel);
		
		loginIdInputField = new JTextField();
		loginIdInputField.setBounds(207, 69, 114, 22);
		contentPane.add(loginIdInputField);
		loginIdInputField.setColumns(10);
		
		loginPasswordInputField = new JPasswordField();
		loginPasswordInputField.setBounds(207, 114, 114, 22);
		contentPane.add(loginPasswordInputField);
		
		loginBtn = new JButton("로그인");
		loginBtn.setBackground(new Color(240, 230, 140));
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		loginBtn.setBounds(80, 168, 105, 28);
		contentPane.add(loginBtn);
		
		joinBtn = new JButton("회원가입");
		joinBtn.setBackground(new Color(240, 230, 140));
		joinBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		joinBtn.setBounds(265, 168, 105, 28);
		contentPane.add(joinBtn);
	}

}
