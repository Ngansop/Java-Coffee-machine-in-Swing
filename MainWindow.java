package com.ngansop.opencoffee;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Toolkit;
public class MainWindow extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
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
	public MainWindow() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindow.class.getResource("/com/ngansop/opencoffee/Cof_icon3.png")));
		setBounds(100, 100, 393, 240);
		setTitle("OpenCoffee");
		setUndecorated(true);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 391, 241);
		panel.setBackground(new Color(0, 204, 102));
		panel.setBorder(new LineBorder(Color.WHITE, 5, true));
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("OpenCoffee");
		lblNewLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 21));
		lblNewLabel.setBounds(44, 11, 120, 28);
		panel.add(lblNewLabel);
		
		
		JButton commandBtn = new JButton("COMMAND");
		commandBtn.setFont(new Font("Tahoma", Font.BOLD, 11));
		commandBtn.setForeground(SystemColor.text);
		commandBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CupSelection cs = new CupSelection();
				cs.setVisible(true);
				cs.setResizable(false);
				MainWindow.this.dispose();
			}
		});
		commandBtn.setBackground(SystemColor.textHighlight);
		commandBtn.setBounds(242, 63, 99, 39);
		panel.add(commandBtn);
		
		JButton quitBtn = new JButton("QUIT");
		quitBtn.setForeground(SystemColor.text);
		quitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent args0) {
				MainWindow.this.dispose();
			}
		});
		quitBtn.setFont(new Font("Tahoma", Font.BOLD, 11));
		quitBtn.setBackground(Color.RED);
		quitBtn.setBounds(242, 156, 99, 39);
		panel.add(quitBtn);
		
		JLabel machine = new JLabel("");
		machine.setFont(new Font("Liberation Serif", Font.BOLD, 1));
		machine.setIcon(new ImageIcon(MainWindow.class.getResource("machine.png")));
		machine.setBounds(24, 42, 187, 193);
		panel.add(machine);
	}
}
/*private static ActionListener progress(Component parent) {
return(ae) ->{
	new Thread(()->{
		ProgressMonitor pm = new ProgressMonitor(parent, "Getting cup ready", "Ready in", 0,100);
		
		pm.setMillisToDecideToPopup(100);
		for(int i = 1; i<=100; i++) {
			pm.setNote("Ready in: " + i);
			pm.setProgress(i);
			try {
				TimeUnit.MILLISECONDS.sleep(200);
			}catch(InterruptedException e){
				System.err.println(e);
			}
		}
		pm.setNote("Your cup is ready");
	}).start();
};
}*/