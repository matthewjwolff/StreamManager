package streammanager;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class FieldEntry extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField leftTitleField;
	private JTextField rightTitleField;
	private JTextField leftNameField;
	private JTextField rightNameField;
	private int leftWins;
	private int rightWins;
	private FileWriter leftTitleWriter;
	private FileWriter rightTitleWriter;
	private FileWriter leftPlayerWriter;
	private FileWriter rightPlayerWriter;
	private FileWriter leftWinsWriter;
	private FileWriter rightWinsWriter;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FieldEntry frame = new FieldEntry();
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
	public FieldEntry() {
		leftWins = 0;
		rightWins = 0;
		setTitle("Stream Manager");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 194);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblLeftTitle = new JLabel("Left Title");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblLeftTitle, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblLeftTitle, 10, SpringLayout.WEST, contentPane);
		contentPane.add(lblLeftTitle);
		
		leftTitleField = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, leftTitleField, -3, SpringLayout.NORTH, lblLeftTitle);
		sl_contentPane.putConstraint(SpringLayout.WEST, leftTitleField, 14, SpringLayout.EAST, lblLeftTitle);
		contentPane.add(leftTitleField);
		leftTitleField.setColumns(10);
		
		JLabel lblRightTitle = new JLabel("Right Title");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblRightTitle, 0, SpringLayout.NORTH, lblLeftTitle);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblRightTitle, -10, SpringLayout.EAST, contentPane);
		contentPane.add(lblRightTitle);
		
		rightTitleField = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, rightTitleField, -3, SpringLayout.NORTH, lblLeftTitle);
		contentPane.add(rightTitleField);
		rightTitleField.setColumns(10);
		
		JLabel lblLeftName = new JLabel("Left Name");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblLeftName, 0, SpringLayout.WEST, lblLeftTitle);
		contentPane.add(lblLeftName);
		
		leftNameField = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblLeftName, 3, SpringLayout.NORTH, leftNameField);
		sl_contentPane.putConstraint(SpringLayout.EAST, leftNameField, 0, SpringLayout.EAST, leftTitleField);
		contentPane.add(leftNameField);
		leftNameField.setColumns(10);
		
		rightNameField = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, leftNameField, 0, SpringLayout.NORTH, rightNameField);
		sl_contentPane.putConstraint(SpringLayout.NORTH, rightNameField, 3, SpringLayout.SOUTH, rightTitleField);
		sl_contentPane.putConstraint(SpringLayout.WEST, rightTitleField, 0, SpringLayout.WEST, rightNameField);
		contentPane.add(rightNameField);
		rightNameField.setColumns(10);
		
		JLabel lblRightName = new JLabel("Right Name");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblRightName, 9, SpringLayout.SOUTH, lblRightTitle);
		sl_contentPane.putConstraint(SpringLayout.EAST, rightNameField, -6, SpringLayout.WEST, lblRightName);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblRightName, 0, SpringLayout.EAST, lblRightTitle);
		contentPane.add(lblRightName);
		
		JButton btnLeftIncrement = new JButton("Left Increment");
		btnLeftIncrement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				leftWins++;
				try {
					leftWinsWriter = new FileWriter("leftWins.txt");
					leftWinsWriter.write(leftWins);
					leftWinsWriter.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnLeftIncrement, 6, SpringLayout.SOUTH, leftNameField);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnLeftIncrement, 0, SpringLayout.WEST, lblLeftTitle);
		contentPane.add(btnLeftIncrement);
		
		JButton btnRightIncrement = new JButton("Right Increment");
		btnRightIncrement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				rightWins++;
				try {
					leftWinsWriter = new FileWriter("leftWins.txt");
					leftWinsWriter.write(leftWins);
					leftWinsWriter.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnRightIncrement, 0, SpringLayout.SOUTH, btnLeftIncrement);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnRightIncrement, 0, SpringLayout.EAST, lblRightTitle);
		contentPane.add(btnRightIncrement);
		
		JButton button = new JButton("<- SWAP ->");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tempName = leftNameField.getText();
				leftNameField.setText(rightNameField.getText());
				rightNameField.setText(tempName);
				int temp = leftWins;
				leftWins = rightWins;
				rightWins = temp;
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, button, 0, SpringLayout.NORTH, btnLeftIncrement);
		sl_contentPane.putConstraint(SpringLayout.WEST, button, 6, SpringLayout.EAST, btnLeftIncrement);
		sl_contentPane.putConstraint(SpringLayout.EAST, button, -6, SpringLayout.WEST, btnRightIncrement);
		contentPane.add(button);
		
		JButton btnUpdate = new JButton("UPDATE NAMES");
		sl_contentPane.putConstraint(SpringLayout.WEST, btnUpdate, 0, SpringLayout.WEST, lblLeftName);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnUpdate, 0, SpringLayout.EAST, leftTitleField);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Write all to files
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnUpdate, 11, SpringLayout.SOUTH, btnLeftIncrement);
		contentPane.add(btnUpdate);
		
		JButton btnNewSet = new JButton("NEW SET");
		btnNewSet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewSet, 0, SpringLayout.WEST, rightTitleField);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewSet, -2, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewSet, 0, SpringLayout.EAST, lblRightTitle);
		contentPane.add(btnNewSet);
	}
}
