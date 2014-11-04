package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;

import model.CookingUnitDescription;
import net.webservicex.CookingUnit;
import net.webservicex.CookingUnitSoap;
import net.webservicex.Cookings;

/**
 * GUI Class of this project
 * @author Natchanon Hongladaromp 5510546034
 *
 */
public class GUI extends JFrame implements Runnable {
	
	private CookingUnitSoap soap;
	
	private JComboBox<CookingUnitDescription> comboBox1;
	private JComboBox<CookingUnitDescription> comboBox2;
	private JTextField field1;
	private JTextField field2;
	private double result;
	
	/**
	 * Constructor for this class.
	 * @param soap a Cooking Unit SOAP
	 */
	public GUI(CookingUnitSoap soap) {
		this.soap = soap;
		this.setTitle("Cooking Unit Converter");
		initComponent();
	}

	/**
	 * initialize all component.
	 */
	private void initComponent() {
		JPanel pane = new JPanel(new FlowLayout());
		
		JPanel left = new JPanel();
		left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
		left.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		JPanel right = new JPanel();
		right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));
		right.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		
		comboBox1 = new JComboBox<CookingUnitDescription>();
		comboBox2 = new JComboBox<CookingUnitDescription>();
		
		for(Cookings c: Cookings.values()) {
			CookingUnitDescription cd = new CookingUnitDescription(c.value(), c);
			comboBox1.addItem(cd);
			comboBox2.addItem(cd);
		}
		
		left.add(comboBox1);
		right.add(comboBox2);
	    
	    field1 = new JTextField();
	    field2 = new JTextField();
		
		left.add(field1);
		right.add(field2);
		
		JButton button1 = new JButton("Convert >>");
		button1.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new ConvertWorker(1).execute();
			}
		});
		
		JButton button2 = new JButton("<< Convert");
		button2.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new ConvertWorker(2).execute();
			}
		});
		
		left.add(button1);
		right.add(button2);
		
		pane.add(left);
		pane.add(right);
		
		this.add(pane);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	/**
	 * Convert method.
	 * @param i type of convert left to right if 1; otherwise is right to left.
	 */
	protected void convert(int i) {
		if(i==1) {
			String input = field1.getText();
			try {
				double value = Double.parseDouble(input);
				Cookings from = comboBox1.getItemAt(comboBox1.getSelectedIndex()).getUnit();
				Cookings to = comboBox2.getItemAt(comboBox2.getSelectedIndex()).getUnit();
				result = soap.changeCookingUnit(value, from, to);
			} catch (NumberFormatException e) {
				;
			}
		}
		else {
			String input = field2.getText();
			try {
				double value = Double.parseDouble(input);
				Cookings from = comboBox2.getItemAt(comboBox2.getSelectedIndex()).getUnit();
				Cookings to = comboBox1.getItemAt(comboBox1.getSelectedIndex()).getUnit();
				result = soap.changeCookingUnit(value, from, to);
			} catch (NumberFormatException e) {
				;
			}
		}
	}

	@Override
	public void run() {
		pack();
		setVisible(true);
	}
	
	/**
	 * Class to perform requests a cooking unit conversion,
	 * so that UI does not block while waiting for web service reply.
	 * It enables service to fail gracefully.
	 * @author hnatchanon
	 *
	 */
	class ConvertWorker extends javax.swing.SwingWorker<Double, String> {
		
		private int type;
		
		/**
		 * Constructor of this class.
		 * @param n
		 */
		public ConvertWorker (int n) {
			type = n;
		}
		
		@Override
		protected Double doInBackground() throws Exception {
			convert(type);
			return null;
		}

		@Override
		protected void done() {
			if(type == 1)
				field2.setText(result + "");
			else
				field1.setText(result + "");
		}
		
	}
}




