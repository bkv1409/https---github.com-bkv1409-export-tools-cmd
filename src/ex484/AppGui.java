package ex484;

import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ResourceBundle;

import javax.swing.ScrollPaneConstants;

public class AppGui {

	private JFrame frame;
	private JTextField txtSource;
	private JTextField txtDestination;
	private JLabel lblPhnMmQun;
	private JLabel lblVersion;
	private JLabel lblSource;
	private JLabel lblDestination;
	private JLabel lblHistorylog;
	private JTextArea logArea;
	private ResourceBundle utf8ResourceBundle = Utf8ResourceBundle.getBundle("gui_vn");
	private FileReader reader;
	private File logFile = new File("export.log");
	private String outputExecOnceTime;
	private static String HEADER_LABEL="header.label";
	private static String VERSION_LABEL="version.label";
	private static String SOURCE_TEXT_LABEL="source.text.label";
	private static String SOURCE_BUTTON_LABEL="source.button.label";
	private static String SOURCE_BUTTON_TOOLTIPS="source.button.tooltips";
	private static String DEST_TEXT_LABEL="dest.text.label";
	private static String DEST_BUTTON_LABEL="dest.button.label";
	private static String DEST_BUTTON_TOOLTIPS="dest.button.tooltips";
	private static String CONVERT_BUTTON_LABEL="convert.button.label";
	private static String CONVERT_BUTTON_TOOLTIPS="convert.button.tooltips";
	private static String CLEAR_BUTTON_LABEL="clear.button.label";
	private static String CLEAR_BUTTON_TOOLTIPS="clear.button.tooltips";
	private static String OPEN_BUTTON_LABEL="open.button.label";
	private static String OPEN_BUTTON_TOOLTIPS="open.button.tooltips";
	private static String AREALOG_BUTTON_LABEL="log.button.label";
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppGui window = new AppGui();
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
	public AppGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 573, 525);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		lblPhnMmQun = new JLabel("FLY MANAGEMENT");
		lblPhnMmQun.setFont(new Font("Tahoma", Font.BOLD, 13));
		if (!"".equals(utf8ResourceBundle.getString(HEADER_LABEL))) {
			lblPhnMmQun.setText(utf8ResourceBundle.getString(HEADER_LABEL));
		}
		lblVersion = new JLabel("Version: 1.0");
		if (!"".equals(utf8ResourceBundle.getString(VERSION_LABEL))) {
			lblVersion.setText(utf8ResourceBundle.getString(VERSION_LABEL));
		}
		
		lblSource = new JLabel("source");
		if (!"".equals(utf8ResourceBundle.getString(SOURCE_TEXT_LABEL))) {
			lblSource.setText(utf8ResourceBundle.getString(SOURCE_TEXT_LABEL));
		}
		
		txtSource = new JTextField();
		txtSource.setText("xmls");
		txtSource.setEditable(false);
		txtSource.setColumns(10);
		
		JButton btnChoosesource = new JButton("chooseSource");
		if (!"".equals(utf8ResourceBundle.getString(SOURCE_BUTTON_LABEL))) {
			btnChoosesource.setText(utf8ResourceBundle.getString(SOURCE_BUTTON_LABEL));
		}
		if (!"".equals(utf8ResourceBundle.getString(SOURCE_BUTTON_TOOLTIPS))) {
			btnChoosesource.setToolTipText(utf8ResourceBundle.getString(SOURCE_BUTTON_TOOLTIPS));
		}
		btnChoosesource.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chooseSource();
			}
		});
		
		lblDestination = new JLabel("destination");
		if (!"".equals(utf8ResourceBundle.getString(SOURCE_TEXT_LABEL))) {
			lblDestination.setText(utf8ResourceBundle.getString(SOURCE_TEXT_LABEL));
		}
		txtDestination = new JTextField();
		txtDestination.setText("exports");
		txtDestination.setEditable(false);
		txtDestination.setColumns(10);
		
		JButton btnChoosedest = new JButton("chooseDest");
		if (!"".equals(utf8ResourceBundle.getString(DEST_BUTTON_LABEL))) {
			btnChoosedest.setText(utf8ResourceBundle.getString(DEST_BUTTON_LABEL));
		}
		if (!"".equals(utf8ResourceBundle.getString(DEST_BUTTON_TOOLTIPS))) {
			btnChoosedest.setToolTipText(utf8ResourceBundle.getString(DEST_BUTTON_TOOLTIPS));
		}
		btnChoosedest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chooseDestination();
			}
		});
		
		JButton btnConvert = new JButton("convert");
		if (!"".equals(utf8ResourceBundle.getString(CONVERT_BUTTON_LABEL))) {
			btnConvert.setText(utf8ResourceBundle.getString(CONVERT_BUTTON_LABEL));
		}
		if (!"".equals(utf8ResourceBundle.getString(CONVERT_BUTTON_TOOLTIPS))) {
			btnConvert.setToolTipText(utf8ResourceBundle.getString(CONVERT_BUTTON_TOOLTIPS));
		}
		btnConvert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				convert();
			}
		});
		
		JButton btnClearhistory = new JButton("clearLog");
		if (!"".equals(utf8ResourceBundle.getString(CLEAR_BUTTON_LABEL))) {
			btnClearhistory.setText(utf8ResourceBundle.getString(CLEAR_BUTTON_LABEL));
		}
		if (!"".equals(utf8ResourceBundle.getString(CLEAR_BUTTON_TOOLTIPS))) {
			btnClearhistory.setToolTipText(utf8ResourceBundle.getString(CLEAR_BUTTON_TOOLTIPS));
		}
		btnClearhistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearHistoryLog();
			}
		});
		
		JButton btnOpendestination = new JButton("openDestination");
		if (!"".equals(utf8ResourceBundle.getString(OPEN_BUTTON_LABEL))) {
			btnOpendestination.setText(utf8ResourceBundle.getString(OPEN_BUTTON_LABEL));
		}
		if (!"".equals(utf8ResourceBundle.getString(OPEN_BUTTON_TOOLTIPS))) {
			btnOpendestination.setToolTipText(utf8ResourceBundle.getString(OPEN_BUTTON_TOOLTIPS));
		}
		btnOpendestination.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openDestinationFolder();
			}
		});
		
		lblHistorylog = new JLabel("historyLog");
		if (!"".equals(utf8ResourceBundle.getString(AREALOG_BUTTON_LABEL))) {
			lblHistorylog.setText(utf8ResourceBundle.getString(AREALOG_BUTTON_LABEL));
		}
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
//		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
//		scroll = new JScrollPane ();
//        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
//        
//        scroll.setViewportView(logArea);
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(37)
					.addComponent(lblPhnMmQun)
					.addContainerGap(431, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(410, Short.MAX_VALUE)
					.addComponent(lblVersion)
					.addGap(89))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblDestination)
							.addContainerGap())
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblHistorylog)
								.addContainerGap())
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblSource)
								.addContainerGap(495, Short.MAX_VALUE))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(btnConvert, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
								.addGap(68)
								.addComponent(btnClearhistory, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
								.addComponent(btnOpendestination)
								.addGap(54))
							.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
									.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
											.addComponent(txtDestination, Alignment.LEADING)
											.addComponent(txtSource, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE))
										.addPreferredGap(ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
											.addComponent(btnChoosedest, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(btnChoosesource, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
								.addGap(27)))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblPhnMmQun)
					.addGap(18)
					.addComponent(lblVersion)
					.addGap(18)
					.addComponent(lblSource)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtSource, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnChoosesource))
					.addGap(25)
					.addComponent(lblDestination)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtDestination, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnChoosedest))
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnConvert)
						.addComponent(btnClearhistory)
						.addComponent(btnOpendestination))
					.addGap(18)
					.addComponent(lblHistorylog)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(32, Short.MAX_VALUE))
		);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setOrientation(JScrollBar.HORIZONTAL);
		scrollPane.setColumnHeaderView(scrollBar);
		
		logArea = new JTextArea();
		logArea.setLineWrap(true);
		logArea.setWrapStyleWord(true);
		scrollPane.setViewportView(logArea);
		logArea.setText("");
		frame.getContentPane().setLayout(groupLayout);
	}

	protected void openDestinationFolder() {
		File fileOpenCheck = new File(txtDestination.getText());
		if (fileOpenCheck.exists()) {
			try {
				Desktop.getDesktop().open(fileOpenCheck);
			} catch (IOException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(frame, "path to folder invalid","Error",JOptionPane.ERROR_MESSAGE);
			}
		} 
	}

	protected void clearHistoryLog() {
		//clean log file
		PrintWriter writer = null;
		try {
//			File file = new File("export.log");
			if (logFile.exists()) {logFile.delete();}
			
			if (!logFile.exists()) logFile.createNewFile(); 
			writer = new PrintWriter(logFile);
			writer.print("");
			reader = null;
			reader = new FileReader(logFile);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			writer.close();
		}
		//emty text area
		logArea.setText("");
		
	}

	protected void convert() {
		
		String in = txtSource.getText();
		String out = txtDestination.getText();
		boolean ret=false;
		try {
			ret = converExcel(in,out);
		} catch (InterruptedException e1) {
			JOptionPane.showMessageDialog(frame, "error in processing!!","Error",JOptionPane.ERROR_MESSAGE);
			e1.printStackTrace();
		} 
		System.out.println("test:"+ret);
	    int currentPos = logArea.getCaretPosition();
	    System.out.println("start: "+currentPos);
	    if (ret) {
//	    	FileReader reader = null;
			try {
//				File fileInput = new File("export.log");
				reader = new FileReader(logFile);
				logArea.read(reader,"export.log"); //Object of JTextArea
				logArea.setCaretPosition(logArea.getDocument().getLength());
				System.out.println("end: "+logArea.getCaretPosition());
			} catch (Exception e1) {
				e1.printStackTrace();
				logArea.setText("error in processing");
				JOptionPane.showMessageDialog(frame, "error in processing!!","Error",JOptionPane.ERROR_MESSAGE);
			}
	    }
		
		
	}

	protected boolean converExcel(String in, String out) throws InterruptedException {
		boolean ret = false;
		try {
		    // Execute command
//		    String command = "cmd /c start cmd.exe";
			ResourceBundle rb = ResourceBundle.getBundle("command");
//		    String command = "cmd /c start java -Dfile.encoding=utf-8 -cp \"exportExcel-1.0-SNAPSHOT.jar;lib/*\" com.dc.utils.Run";
		    String command = rb.getString("base.command");
		    command += " -i "+"\""+in+"\"";
		    command += " -o "+"\""+out+"\"";
//			String command = "ping -n 3 google.com";
		    Process process = Runtime.getRuntime().exec(command);
		    InputStream stdin = process.getInputStream();
		    InputStreamReader isr = new InputStreamReader(stdin);
		    BufferedReader br = new BufferedReader(isr);
		    String s = null;
		    StringBuilder stringBuilder = new StringBuilder();
		    while ((s = br.readLine()) != null) {
		        System.out.println("a:"+s);
		        stringBuilder.append(s);
		    }
		 
		    int r = process.waitFor(); // Let the process finish.
		    if (r == 0) { // No error
		       ret = true;
		       
		       outputExecOnceTime = stringBuilder.toString();
		    }
		    System.out.println("outputExecOnceTime: "+outputExecOnceTime);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ret;
	}
	
	protected void chooseDestination() {
		String pathDest = createFileChooser("chooserDestination",JFileChooser.DIRECTORIES_ONLY);
		if (!"".equals(pathDest)) {
			txtDestination.setText(pathDest);
		}
		
	}

	protected void chooseSource() {
		String pathSource= createFileChooser("chooserSource",JFileChooser.FILES_AND_DIRECTORIES);
		if (!"".equals(pathSource)) {
			txtSource.setText(pathSource);
		}
		
	}
	
	protected String createFileChooser(String title, int mode){
		JFileChooser chooser = new JFileChooser();
	    chooser.setCurrentDirectory(new java.io.File("."));
	    chooser.setDialogTitle(title);
	    chooser.setFileSelectionMode(mode);
	    chooser.setAcceptAllFileFilterUsed(false);
	    String ret = "";
	    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
	      System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
	      System.out.println("getSelectedFile() : " + chooser.getSelectedFile());
	      ret = chooser.getSelectedFile().getAbsolutePath();
	    } else {
	      System.out.println("No Selection ");
	    }
	    
		return ret;
	}
}
