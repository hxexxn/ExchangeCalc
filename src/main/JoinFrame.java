package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.MemberDB;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JoinFrame extends JFrame {
	boolean idDuplicate = false;
	
	private JPanel contentPane;
	private JTextField nameInputField;
	private JTextField idInputField;
	private JPasswordField passwordInputField;
	private JPasswordField rePasswordInputField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JoinFrame frame = new JoinFrame();
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
	public JoinFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 505, 362);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 240, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel joinLabel = new JLabel("회원 가입");
		joinLabel.setHorizontalAlignment(SwingConstants.CENTER);
		joinLabel.setFont(new Font("Noto Sans CJK HK", Font.BOLD, 20));
		joinLabel.setBounds(208, 12, 86, 41);
		contentPane.add(joinLabel);
		
		JLabel nameLabel = new JLabel("이름");
		nameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		nameLabel.setBounds(110, 84, 59, 18);
		contentPane.add(nameLabel);
		
		nameInputField = new JTextField();
		nameInputField.setBounds(195, 82, 114, 22);
		contentPane.add(nameInputField);
		nameInputField.setColumns(10);
		
		JLabel idLabel = new JLabel("아이디");
		idLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		idLabel.setBounds(110, 116, 59, 18);
		contentPane.add(idLabel);
		
		idInputField = new JTextField();
		idInputField.setColumns(10);
		idInputField.setBounds(195, 114, 114, 22);
		contentPane.add(idInputField);
		
		JLabel pwLabel = new JLabel("비밀번호");
		pwLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		pwLabel.setBounds(110, 146, 59, 18);
		contentPane.add(pwLabel);
		
		passwordInputField = new JPasswordField();
		passwordInputField.setBounds(195, 146, 114, 22);
		contentPane.add(passwordInputField);
		
		JLabel rePwLabel = new JLabel("비밀번호 확인");
		rePwLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		rePwLabel.setBounds(100, 176, 69, 18);
		contentPane.add(rePwLabel);
		
		rePasswordInputField = new JPasswordField();
		rePasswordInputField.setBounds(195, 176, 114, 22);
		contentPane.add(rePasswordInputField);
		
		JButton idDuplicateBtn = new JButton("중복 확인");
		idDuplicateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id = idInputField.getText();
				String resultId = id.trim().replaceAll(" ", "");
				String onlyEng = resultId.replaceAll("[^a-zA-Z0-9]", "");
				
				MemberDB md = new MemberDB();
				
				boolean idCheck = md.idDuplicateCheck(onlyEng);
				
				if (idCheck == true) {
					JOptionPane.showMessageDialog(contentPane, "중복되는 아이디입니다.", "아이디 사용 불가 X_X", JOptionPane.WARNING_MESSAGE);
					idInputField.setText("");
				 } else {
					 JOptionPane.showMessageDialog(contentPane, "사용 가능한 아이디입니다.", "아이디 사용 가능 O_O", JOptionPane.INFORMATION_MESSAGE);
					 idDuplicate = true;
				 }
			}
			
		});
		idDuplicateBtn.setBackground(new Color(240, 230, 140));
		idDuplicateBtn.setBounds(327, 114, 81, 23);
		contentPane.add(idDuplicateBtn);
		setVisible(false);
		
		JButton btnNewButton = new JButton("가입하기");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name = nameInputField.getText();
				
				// 아이디 유효성 검사				
				String id = idInputField.getText();
				String resultId = id.trim().replaceAll(" ", "");
				String onlyEng = resultId.replaceAll("[^a-zA-Z0-9]", "");
				
				boolean checkId = false;
				boolean checkPw = false;
				
				
				if (onlyEng.length() > 0) {
					checkId = true;
				} else {
					JOptionPane.showMessageDialog(contentPane, "아이디는 영문과 숫자로만 사용 가능합니다.", "아이디 사용 불가 X_X", JOptionPane.WARNING_MESSAGE);
				}
				
				if (id.equals(onlyEng)) {
					checkId = true;
				} else {
					JOptionPane.showMessageDialog(contentPane, "아이디를 입력해주세요.", "아이디가 없음T_T", JOptionPane.WARNING_MESSAGE);
				}

				// 비밀번호 유효성 검사
				String pw = passwordInputField.getText();
				String rePw = rePasswordInputField.getText();
				
				if (pw == null || pw.equals(" ") || pw.equals("")) {
					JOptionPane.showMessageDialog(contentPane, "비밀번호를 입력해주세요.", "비밀번호가 없음T_T", JOptionPane.WARNING_MESSAGE);
				} else {
					String resultPw = pw.trim().replace(" ", "");
					if (pw.equals(rePw)) {
						checkPw = true;
					} else {
						JOptionPane.showMessageDialog(contentPane, "비밀번호가 일치하지 않습니다.", "비밀번호 틀림 X_X", JOptionPane.WARNING_MESSAGE);
						passwordInputField.setText("");
						rePasswordInputField.setText("");
					}
				}
				
				// 아이디와 비밀번호 모두 true라면
				
				if (checkId == true && checkPw == true && idDuplicate == true) {
					MemberDB db = new MemberDB();
					db.joinInsert(name, onlyEng, pw);
					JOptionPane.showMessageDialog(contentPane, "회원 가입이 완료되었습니다.", "가입 축하!", JOptionPane.INFORMATION_MESSAGE);
					
					Main main = new Main();				
					
					main.setVisible(true);
					setVisible(false);				
				} else {
					JOptionPane.showMessageDialog(contentPane, "아이디나 비밀번호를 다시 입력해주세요.", "삐빅! 다시 입력!", JOptionPane.WARNING_MESSAGE);
					nameInputField.setText("");
					idInputField.setText("");
					passwordInputField.setText("");
					rePasswordInputField.setText("");
				}
			}
		});
		btnNewButton.setBackground(new Color(240, 230, 140));
		btnNewButton.setBounds(204, 225, 105, 28);
		contentPane.add(btnNewButton);
	}
}
