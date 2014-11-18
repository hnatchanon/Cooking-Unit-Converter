package ku.cooking.view;

import java.awt.BorderLayout;
import java.awt.Container;
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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.text.NumberFormatter;
import javax.xml.ws.WebServiceException;

import ku.cooking.model.CookingUnitDescription;
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
	private JLabel status;
	private double result;
	private Timer timer;
	private ConvertWorker worker;

	/**
	 * Constructor for this class.
	 * @param soap a Cooking Unit SOAP
	 */
	public GUI() {
		this.setTitle("Cooking Unit Converter");
		initComponent();
	}

	/**
	 * initialize all component.
	 */
	private void initComponent() {

		JPanel container = new JPanel(new BorderLayout());
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
				worker = new ConvertWorker(1);
				worker.execute();
			}
		});

		JButton button2 = new JButton("<< Convert");
		button2.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				worker = new ConvertWorker(2);
				worker.execute();
			}
		});

		left.add(button1);
		right.add(button2);

		pane.add(left);
		pane.add(right);

		container.add(pane, BorderLayout.CENTER);

		status = new JLabel("Status: Ready");

		timer = new Timer(100,new ActionListener() {

			int cnt = 1;

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(cnt%3==0)
					status.setText("Status: Calculating");
				else if(cnt%3==1)
					status.setText("Status: Calculating.");
				else
					status.setText("Status: Calculating..");
				cnt++;

				if(cnt==150) {
					worker.cancel(true);
					timer.stop();
					status.setText("Status: Timeout! Try again");
					cnt=0;
				}
			}
		});

		container.add(status, BorderLayout.SOUTH);

		this.add(container);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	/**
	 * Convert method.
	 * @param i type of convert left to right if 1; otherwise is right to left.
	 */
	protected void convert(int i) {
		double value = 0;
		if(i==1) {
			String input = field1.getText();
			try {
				value = Double.parseDouble(input);
				Cookings from = comboBox1.getItemAt(comboBox1.getSelectedIndex()).getUnit();
				Cookings to = comboBox2.getItemAt(comboBox2.getSelectedIndex()).getUnit();
				result = soap.changeCookingUnit(value, from, to);
			} catch (NumberFormatException e) {

			}
		}
		else {
			String input = field2.getText();
			try {
				value = Double.parseDouble(input);
				Cookings from = comboBox2.getItemAt(comboBox2.getSelectedIndex()).getUnit();
				Cookings to = comboBox1.getItemAt(comboBox1.getSelectedIndex()).getUnit();
				result = soap.changeCookingUnit(value, from, to);

			} catch (NumberFormatException e) {

			}
		}
	}

	/**
	 * create new soap.
	 */
	protected void createSoap() {
		try{
			CookingUnit cu = new CookingUnit();
			soap = cu.getCookingUnitSoap();
		} catch (WebServiceException e){
			int respose = JOptionPane.showConfirmDialog(null, "No internet access. Try again?","Error!",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (respose == JOptionPane.YES_OPTION) {
				createSoap();
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
		protected Double doInBackground(){

			status.setText("Status: Calculating");
			timer.start();
			if(soap==null) {
				createSoap();
			}
			convert(type);
			return null;
		}

		@Override
		protected void done() {
			if(type == 1)
				field2.setText(result + "");
			else
				field1.setText(result + "");
			timer.stop();
			status.setText("Status: Done");
		}

	}
}




