package ex484;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TTBoardPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public TTBoardPanel() {
		
		JLabel lblExportExcelTools = new JLabel("Export Excel Tools");
		add(lblExportExcelTools);
		
		textField = new JTextField();
		add(textField);
		textField.setColumns(10);
		
		JButton btnTarget = new JButton("Source");
		add(btnTarget);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		add(textField_1);
		
		JButton btnDestination = new JButton("Destination");
		btnDestination.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(btnDestination);
		
		JButton btnSave = new JButton("Save");
		add(btnSave);
		
		JButton btnOpen = new JButton("Open");
		add(btnOpen);

	}

}
