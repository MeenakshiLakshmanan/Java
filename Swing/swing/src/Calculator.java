import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Calculator {

	private JFrame frame;
	private JTextField txtNumber1;
	private JTextField txtNumber2;
	private JTextField txtResult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator window = new Calculator();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Calculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNumber = new JLabel("Number1");
		lblNumber.setBounds(6, 55, 61, 16);
		frame.getContentPane().add(lblNumber);
		
		JLabel lblNumber_1 = new JLabel("Number2");
		lblNumber_1.setBounds(6, 102, 61, 16);
		frame.getContentPane().add(lblNumber_1);
		
		txtNumber1 = new JTextField();
		txtNumber1.setBounds(97, 49, 134, 28);
		frame.getContentPane().add(txtNumber1);
		txtNumber1.setColumns(10);
		
		txtNumber2 = new JTextField();
		txtNumber2.setBounds(97, 96, 134, 28);
		frame.getContentPane().add(txtNumber2);
		txtNumber2.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result=Integer.parseInt(txtNumber1.getText())+Integer.parseInt(txtNumber2.getText());
				txtResult.setText(Integer.toString(result));
			}
		});
		btnAdd.setBounds(6, 158, 117, 29);
		frame.getContentPane().add(btnAdd);
		
		JButton btnSubtract = new JButton("Subtract");
		btnSubtract.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result=Integer.parseInt(txtNumber1.getText())-Integer.parseInt(txtNumber2.getText());
				txtResult.setText(Integer.toString(result));
			}
		});
		btnSubtract.setBounds(143, 158, 117, 29);
		frame.getContentPane().add(btnSubtract);
		
		txtResult = new JTextField();
		txtResult.setBounds(107, 216, 134, 28);
		frame.getContentPane().add(txtResult);
		txtResult.setColumns(10);
		
		JLabel lblResult = new JLabel("Result: ");
		lblResult.setBounds(6, 222, 61, 16);
		frame.getContentPane().add(lblResult);
	}

}
