package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;

public class ExchangeFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;


	public ExchangeFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 603, 238);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(253, 245, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("환율 조회");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Noto Sans CJK HK Medium", Font.BOLD, 20));
		label.setBounds(213, 12, 184, 30);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(112, 86, 114, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel exchangeResultLabel = new JLabel("");
		exchangeResultLabel.setHorizontalAlignment(SwingConstants.CENTER);
		exchangeResultLabel.setBackground(new Color(238, 232, 170));
		exchangeResultLabel.setBounds(399, 86, 91, 23);
		exchangeResultLabel.setOpaque(true);
		contentPane.add(exchangeResultLabel);
		
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(255, 215, 0));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"달러", "엔화"}));
		comboBox.setBounds(260, 84, 91, 27);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("조회하기");
		btnNewButton.setBackground(new Color(240, 230, 140));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String exchangeResult = textField.getText();
				String exchangeSelect = comboBox.getSelectedItem().toString();
				double us = 1227.20;
				double jp = 976.48;
				
				if (exchangeResult == null || exchangeResult == "" || exchangeResult == " "){
					JOptionPane.showMessageDialog(contentPane, "값을 입력해주세요.", "X_X", JOptionPane.WARNING_MESSAGE);
				}
				
				if (exchangeSelect.equals("달러")) {
					double dollar = Double.parseDouble(exchangeResult) * us;
					double resultDollar = Math.round(dollar * 100)/100.0;
					exchangeResultLabel.setText(Double.toString(resultDollar) + "원");
				} else if (exchangeSelect.equals("엔화")) {
					double jpy = Double.parseDouble(exchangeResult) * jp;
					double resultJpy = Math.round(jpy * 100) / 100.0;
					exchangeResultLabel.setText(Double.toString(resultJpy) + "원");
				} else {
					exchangeResultLabel.setText("값을 입력해주세요.");
				}
				
				
			}
			
		});
		btnNewButton.setBounds(253, 144, 105, 28);
		contentPane.add(btnNewButton);
		
		
	}
}
