package com.ngansop.opencoffee;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JProgressBar;

public class CupSelection extends JFrame {
	
	private JRadioButton tiny_cup;
	private JRadioButton regular_cup;
	private JRadioButton king_cup;
	private int tinyCups=20;
	private int regularCups=20;
	private int kingCups=20;
	
	static Timer t;
	static ActionListener al;

	/**
	 * Create the frame.
	 */
	public CupSelection() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Ngans\\eclipse-workspace\\OpenCoffee\\src\\com\\ngansop\\opencoffee\\Cof_icon3.png"));
		setBounds(100, 100, 387, 267);
		setTitle("OpenCoffee");
		setUndecorated(true);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 387, 267);
		panel.setBackground(new Color(0, 204, 102));
		panel.setBorder(new LineBorder(Color.WHITE, 5, true));
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Take a Cup");
		lblNewLabel.setForeground(SystemColor.desktop);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(121, 11, 137, 31);
		panel.add(lblNewLabel);
		
		JButton cancelBtn = new JButton("CANCEL");
		cancelBtn.setBackground(Color.RED);
		cancelBtn.setForeground(Color.WHITE);
		cancelBtn.setBounds(10, 11, 101, 31);
		cancelBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MainWindow mw = new MainWindow();
				mw.setVisible(true);
				mw.setResizable(false);
				CupSelection.this.dispose();
			}
		});
		panel.add(cancelBtn);
		
		JPanel cupPanel = new JPanel();
		cupPanel.setBackground(new Color(204, 204, 255));
		cupPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Select Cup",TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		cupPanel.setBounds(20, 53, 344, 150);
		panel.add(cupPanel);
		cupPanel.setLayout(null);
		
		king_cup = new JRadioButton("King Cup");
		king_cup.setBounds(10, 21, 96, 23);
		king_cup.setBackground(new Color(204, 204, 255));
		cupPanel.add(king_cup);
		king_cup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				if(king_cup.isSelected()) {
					tiny_cup.setSelected(false);
					regular_cup.setSelected(false);
				}
			}
		});
		JLabel king = new JLabel("");
		king.setFont(new Font("Liberation Serif", Font.BOLD, 1));
		king.setIcon(new ImageIcon(MainWindow.class.getResource("king.png")));
		king.setBounds(0, 42, 88, 105);
		cupPanel.add(king);
		
		regular_cup = new JRadioButton("Regular Cup");	
		regular_cup.setBounds(124, 21, 113, 23);
		regular_cup.setBackground(new Color(204, 204, 255));
		cupPanel.add(regular_cup);
		regular_cup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(regular_cup.isSelected()) {
					tiny_cup.setSelected(false);
					king_cup.setSelected(false);
				}
			}
		});
		JLabel regular = new JLabel("");
		regular.setFont(new Font("Liberation Serif", Font.BOLD, 1));
		regular.setIcon(new ImageIcon(MainWindow.class.getResource("regular.png")));
		regular.setBounds(134, 51, 69, 89);
		cupPanel.add(regular);
		
		tiny_cup = new JRadioButton("Tiny Cup");
		tiny_cup.setBounds(260, 21, 84, 23);
		tiny_cup.setBackground(new Color(204, 204, 255));
		cupPanel.add(tiny_cup);
		tiny_cup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tiny_cup.isSelected()) {
					regular_cup.setSelected(false);
					king_cup.setSelected(false);
				}
			}
		});
		JLabel tiny = new JLabel("");
		tiny.setFont(new Font("Liberation Serif", Font.BOLD, 1));
		tiny.setIcon(new ImageIcon(MainWindow.class.getResource("tin.png")));
		tiny.setBounds(265, 58, 69, 77);
		cupPanel.add(tiny);
		

		JProgressBar progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		progressBar.setForeground(Color.DARK_GRAY);
		progressBar.setBounds(166, 214, 198, 36);
		panel.add(progressBar);
		
		JButton okBtn = new JButton("OK");
		okBtn.setBackground(SystemColor.textHighlight);
		okBtn.setForeground(new Color(255, 255, 255));
		okBtn.setBounds(22, 214, 89, 36);
		okBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				select();
			}	
		});
		panel.add(okBtn);
		al = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(progressBar.getValue()<100)
					progressBar.setValue(progressBar.getValue()+10);
				else
					progressBar.setString("Cup Ready");
			}
			
		};
		t = new Timer(250,al);
	}
	public void select() {
		if(king_cup.isSelected()) {
			if(kingCups>=1) {
				t.start();
				kingCups -= 1;
			}	
			else if(kingCups<1){
				JOptionPane.showMessageDialog(this, "Sorry! Out of stocks!");
			}				
		}
		else if(regular_cup.isSelected()) {
			if(regularCups>=1) {
				t.start();
				regularCups -= 1;
			}	
			else if(regularCups<1)
				JOptionPane.showMessageDialog(this, "Sorry! Out of stocks!");
		}
		else if(tiny_cup.isSelected()) {
			if(tinyCups>=1) {
				t.start();
				tinyCups -= 1;
			}
			else if(tinyCups<1)
				JOptionPane.showMessageDialog(this, "Sorry! Out of stocks!");
		}
		else
			JOptionPane.showMessageDialog(this, "You must take a cup!");
	}
}
