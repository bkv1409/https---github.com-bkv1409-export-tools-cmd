package ex484;

import java.io.FileReader;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TestGUI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		   //FRAME
		JFrame frame = new JFrame ("Test");
		frame.setSize(500,500);
		frame.setResizable(false);
		//

		//TEXT AREA
		JTextArea textArea = new JTextArea("TEST");
		textArea.setSize(400,400);    

		    textArea.setLineWrap(true);
		    textArea.setEditable(false);
		    textArea.setVisible(true);
		    FileReader reader;
			try {
				reader = new FileReader("export.log");
				textArea.read(reader,"export.log"); //Object of JTextArea
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		    JScrollPane scroll = new JScrollPane (textArea);
		    scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		          scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		    frame.add(scroll);
		    frame.setVisible(true);
		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
