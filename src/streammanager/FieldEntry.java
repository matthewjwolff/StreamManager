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

public class FieldEntry extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

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
		setTitle("Stream Manager");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 159);
		
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
		
		textField = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField, -3, SpringLayout.NORTH, lblLeftTitle);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField, 14, SpringLayout.EAST, lblLeftTitle);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblRightTitle = new JLabel("Right Title");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblRightTitle, 0, SpringLayout.NORTH, lblLeftTitle);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblRightTitle, -10, SpringLayout.EAST, contentPane);
		contentPane.add(lblRightTitle);
		
		textField_1 = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField_1, -3, SpringLayout.NORTH, lblLeftTitle);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblLeftName = new JLabel("Left Name");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblLeftName, 0, SpringLayout.WEST, lblLeftTitle);
		contentPane.add(lblLeftName);
		
		textField_2 = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblLeftName, 3, SpringLayout.NORTH, textField_2);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField_2, 0, SpringLayout.EAST, textField);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField_2, 0, SpringLayout.NORTH, textField_3);
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField_3, 3, SpringLayout.SOUTH, textField_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField_1, 0, SpringLayout.WEST, textField_3);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblRightName = new JLabel("Right Name");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblRightName, 9, SpringLayout.SOUTH, lblRightTitle);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField_3, -6, SpringLayout.WEST, lblRightName);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblRightName, 0, SpringLayout.EAST, lblRightTitle);
		contentPane.add(lblRightName);
		
		JButton btnLeftIncrement = new JButton("Left Increment");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnLeftIncrement, 6, SpringLayout.SOUTH, textField_2);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnLeftIncrement, 0, SpringLayout.WEST, lblLeftTitle);
		contentPane.add(btnLeftIncrement);
		
		JButton btnRightIncrement = new JButton("Right Increment");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnRightIncrement, 0, SpringLayout.SOUTH, btnLeftIncrement);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnRightIncrement, 0, SpringLayout.EAST, lblRightTitle);
		contentPane.add(btnRightIncrement);
		
		JButton button = new JButton("<- SWAP ->");
		sl_contentPane.putConstraint(SpringLayout.NORTH, button, 0, SpringLayout.NORTH, btnLeftIncrement);
		sl_contentPane.putConstraint(SpringLayout.WEST, button, 6, SpringLayout.EAST, btnLeftIncrement);
		sl_contentPane.putConstraint(SpringLayout.EAST, button, -6, SpringLayout.WEST, btnRightIncrement);
		contentPane.add(button);
	}
}
