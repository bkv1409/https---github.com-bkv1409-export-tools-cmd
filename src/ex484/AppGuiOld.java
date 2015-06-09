package ex484;

import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class AppGuiOld {

	private JFrame frame;
	private JTextField textField;
	private JButton btnSource;
	private JTextField textField_1;
	private JButton btnDestination;
	private JButton btnSave;
	private JButton btnOpen_1;
	private JLabel lblSelectSource;
	private JLabel lblSelectDestination;
	private JTextArea txtrOutputCmd;
	private JScrollPane scroll;
	private JButton btnClearLogs;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppGuiOld window = new AppGuiOld();
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
	public AppGuiOld() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 630, 368);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("152px:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(98dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(69dlu;default):grow"),},
			new RowSpec[] {
				FormFactory.NARROW_LINE_GAP_ROWSPEC,
				RowSpec.decode("37px"),
				RowSpec.decode("37px"),
				RowSpec.decode("37px"),
				RowSpec.decode("37px"),
				RowSpec.decode("37px"),
				RowSpec.decode("37px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				RowSpec.decode("37px:grow"),}));
		
		JLabel lblExportExcelTools = new JLabel("Export Excel Tools");
		lblExportExcelTools.setFont(new Font("Tahoma", Font.BOLD, 14));
		frame.getContentPane().add(lblExportExcelTools, "1, 2, 3, 1, fill, fill");
		
		lblSelectSource = new JLabel("Select Source");
		lblSelectSource.setFont(new Font("Tahoma", Font.ITALIC, 11));
		frame.getContentPane().add(lblSelectSource, "1, 3");
		
		textField = new JTextField();
		textField.setEditable(false);
		//default value set xmls folder
		textField.setText("xmls");
		frame.getContentPane().add(textField, "1, 4, 3, 1, fill, fill");
		textField.setColumns(10);
		
		btnSource = new JButton("Source");
		btnSource.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pathSource= choseSource();
				textField.setText(pathSource);
			}
		});
		btnSource.setToolTipText("Select Source Folder or XML Files");
		frame.getContentPane().add(btnSource, "7, 4, center, fill");
		
		lblSelectDestination = new JLabel("Select Destination");
		lblSelectDestination.setFont(new Font("Tahoma", Font.ITALIC, 11));
		frame.getContentPane().add(lblSelectDestination, "1, 5");
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		//default value set exports folder
		textField_1.setText("exports");
		frame.getContentPane().add(textField_1, "1, 6, 3, 1, fill, fill");
		textField_1.setColumns(10);
		
		btnDestination = new JButton("Destination");
		btnDestination.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pathDest = choseDestination();
				textField_1.setText(pathDest);
			}
		});
		btnDestination.setToolTipText("Select Destination Folder");
		frame.getContentPane().add(btnDestination, "7, 6, center, fill");
		
		btnSave = new JButton("Convert");
		
		btnClearLogs = new JButton("Clear Logs");
		btnClearLogs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cleanLogs();
			}
		});
		frame.getContentPane().add(btnClearLogs, "3, 7, center, fill");
		
		btnOpen_1 = new JButton("Open Destination Folder");
		btnOpen_1.setToolTipText("Open file in Out Dirs");
		frame.getContentPane().add(btnOpen_1, "7, 7, center, fill");
		
		btnOpen_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				FileList.pathFile="\""+textField_1.getText()+"\"";
				
//				FileList.pathFile="exports";
//				System.out.println("path to open: "+FileList.pathFile);
//				FileList.show();
//				FileManager.filePath="exports";
//				FileManager.filePath="\""+textField_1.getText()+"\"";
				System.out.println("path file: "+textField_1.getText());
				System.out.println("path file: "+"\""+textField_1.getText()+"\"");
				FileManager.filePath=textField_1.getText();
				System.out.println("path to open: "+FileList.pathFile);
				FileManager.main(null);
				
			}
		});
		txtrOutputCmd = new JTextArea();
		txtrOutputCmd.setWrapStyleWord(true);
		txtrOutputCmd.setLineWrap(true);
		txtrOutputCmd.setText("---- Output cmd ------");
		//move to add scroll
//		frame.getContentPane().add(txtrOutputCmd, "1, 10, 3, 1, fill, fill");

        scroll = new JScrollPane ();
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        
        scroll.setViewportView(txtrOutputCmd);
        frame.getContentPane().add(scroll,"1, 10, 7, 1, fill, fill");

		
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String in = textField.getText();
				String out = textField_1.getText();
				String ret;
				try {
					ret = converExcel(in,out);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					ret ="";
				}
				System.out.println("test:"+ret);
//				txtrOutputCmd.append(ret);
			    int currentPos = txtrOutputCmd.getCaretPosition();
			    System.out.println("start: "+currentPos);

				FileReader reader;
				try {
					reader = new FileReader("export.log");
					txtrOutputCmd.read(reader,"export.log"); //Object of JTextArea
					txtrOutputCmd.setCaretPosition(txtrOutputCmd.getDocument().getLength());
					System.out.println("end: "+txtrOutputCmd.getCaretPosition());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnSave.setToolTipText("Button convert XML to XLXS");
		frame.getContentPane().add(btnSave, "1, 7, center, fill");
		
		
		
//		list = new JList();
//		frame.getContentPane().add(list, "1, 8, 3, 1, fill, fill");
	}

	protected void cleanLogs() {
		PrintWriter writer = null;
		try {
			File file = new File("export.log");
			file.delete();
//			writer = new PrintWriter(file);
//			writer.print("");
			if (!file.exists()) file.createNewFile(); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
//			writer.close();
		}
		//emty text area
		txtrOutputCmd.setText("");

		
	}

	protected String converExcel(String in, String out) throws InterruptedException {
		String ret = "";
		try {
		    // Execute command
//		    String command = "cmd /c start cmd.exe";
			ResourceBundle rb = ResourceBundle.getBundle("command");
//		    String command = "cmd /c start java -Dfile.encoding=utf-8 -cp \"exportExcel-1.0-SNAPSHOT.jar;lib/*\" com.dc.utils.Run";
		    String command = rb.getString("base.command");
		    command += " -i "+"\""+in+"\"";
		    command += " -o "+"\""+out+"\"";
//			String command = "ping -n 3 google.com";
		    Process child = Runtime.getRuntime().exec(command);

//		    // Get output stream to write from it
//		    StringOutputStream outStream = (StringOutputStream) child.getOutputStream();
//		    		   OutputStream outStream = new OutputStream()
//		    {
//		        private StringBuilder string = new StringBuilder();
//		        @Override
//		        public void write(int b) throws IOException {
//		            this.string.append((char) b );
//		        }
//
//		        //Netbeans IDE automatically overrides this toString()
//		        public String toString(){
//		            return this.string.toString();
//		        }
//		    };
//		    try {
//		        String outRet = new String(outStream.toByteArray(), "UTF-8");
//		    } catch (Exception e) {
//		        e.printStackTrace();
//		    }
//		    StringOutputStream sos = new StringOutputStream();
//		    someclass.somemethod(sos,"Some random method which needs an output stream");
//		    System.out.println(sos.toString());

//		    outStream.write("cd C:/ /r/n".getBytes());
//		    outStream.flush();
//		    outStream.write("dir /r/n".getBytes());
//		    
//		    outStream.close();
//		    ret = outStream.toString();
//		    BufferedReader br = new BufferedReader(new InputStreamReader(child.getInputStream()));
//		    StringBuffer sb = new StringBuffer();
//		    String line;
//		    while ((line = br.readLine()) != null) {
//		      sb.append(line).append("\n");
//		    }
//		    ret = sb.toString();
//		    System.out.println("ret: "+ret);
//		    ProcessBuilder   ps=new ProcessBuilder("java.exe","-version");

		  //From the DOC:  Initially, this property is false, meaning that the 
		  //standard output and error output of a subprocess are sent to two 
		  //separate streams
//		  ps.redirectErrorStream(true);
//
//		  Process pr = ps.start();  
//
//		  BufferedReader in = new BufferedReader(new 
//
//		  InputStreamReader(pr.getInputStream()));
//		  String line;
//		  while ((line = in.readLine()) != null) {
//		      System.out.println(line);
//		  }
//		  pr.waitFor();
//		  System.out.println("ok!");
//
//		  in.close();
//		  System.exit(0);
		    //not use
//		    BufferedReader inBr = new BufferedReader(new InputStreamReader(child.getInputStream()));
//		    String line;
//		    while ((line = inBr.readLine()) != null) {
//		        System.out.println(line);
//		    }
//		    child.waitFor();
//		    System.out.println("ok!");
//
//		    inBr.close();
		} catch (IOException e) {
			ret ="";
		}
		return ret;
	}

	protected String choseDestination() {
		JFileChooser chooser = new JFileChooser();
	    chooser.setCurrentDirectory(new java.io.File("."));
	    chooser.setDialogTitle("chooserDestinationFolder");
	    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	    chooser.setAcceptAllFileFilterUsed(false);

	    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
	      System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
	      System.out.println("getSelectedFile() : " + chooser.getSelectedFile());
	    } else {
	      System.out.println("No Selection ");
	    }
		String ret = chooser.getSelectedFile().getAbsolutePath();
		return ret;
	}

	protected String choseSource() {
		JFileChooser chooser = new JFileChooser();
	    chooser.setCurrentDirectory(new java.io.File("."));
	    chooser.setDialogTitle("chooserSource");
//	    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	    chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
	    chooser.setAcceptAllFileFilterUsed(false);

	    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
	      System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
	      System.out.println("getSelectedFile() : " + chooser.getSelectedFile());
	    } else {
	      System.out.println("No Selection ");
	    }
	    String ret = chooser.getSelectedFile().getAbsolutePath();
		return ret;
	}
	
	public boolean editFile(final File file) {
		  if (!Desktop.isDesktopSupported()) {
		    return false;
		  }

		  Desktop desktop = Desktop.getDesktop();
		  if (!desktop.isSupported(Desktop.Action.EDIT)) {
		    return false;
		  }

		  try {
		    desktop.edit(file);
		  } catch (IOException e) {
		    // Log an error
		    return false;
		  }

		  return true;
		}

}
