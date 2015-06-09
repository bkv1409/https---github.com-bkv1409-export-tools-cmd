package ex484;

import java.awt.*;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.Border;
import javax.swing.filechooser.FileSystemView;

import java.io.File;
import java.io.FileFilter;
import java.util.TimerTask;

/**
This code uses a JList in two forms (layout orientation vertical & horizontal wrap) to
display a File[].  The renderer displays the file icon obtained from FileSystemView.
*/
class FileList {
	public static String pathFile;
    public Component getGui(File[] all, boolean vertical) {
        // put File objects in the list..
        JList fileList = new JList(all);
        // ..then use a renderer
        fileList.setCellRenderer(new FileRenderer(!vertical));

        if (!vertical) {
            fileList.setLayoutOrientation(javax.swing.JList.HORIZONTAL_WRAP);
            fileList.setVisibleRowCount(-1);
        } else {
            fileList.setVisibleRowCount(9);
        }
        return new JScrollPane(fileList);
    }

   
    public static void show(){
    	SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	System.out.println("pathFile: "+pathFile);
//                File f = new File("file:/"+pathFile);
                File f = new File(pathFile);
                FileList fl = new FileList();
                Component c1 = fl.getGui(f.listFiles(),true);

                //f = new File(System.getProperty("user.home"));
                Component c2 = fl.getGui(f.listFiles(),false);

                JFrame frame = new JFrame("File List");
                JPanel gui = new JPanel(new BorderLayout());
//                gui.add(c1,BorderLayout.WEST);
                gui.add(c2,BorderLayout.CENTER);
                c2.setPreferredSize(new Dimension(375,100));
                gui.setBorder(new EmptyBorder(3,3,3,3));

                frame.setContentPane(gui);
                frame.pack();
                frame.setLocationByPlatform(true);
//                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
    public static void main(String[] args) {
//    	FileList.pathFile="C:\\Program Files";
//    	FileList.show();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	System.out.println("path: "+System.getProperty("user.home"));
//                File f = new File(System.getProperty("user.home"));
//                File f = new File("C:\\Program Files");
                File f = new File(pathFile);
                FileList fl = new FileList();
                
//                Component c1 = fl.getGui(f.listFiles(new TextFileFilter()),true);
                Component c1 = fl.getGui(f.listFiles(),true);
                System.out.println("size: "+f.listFiles().length);
                //f = new File(System.getProperty("user.home"));
//                Component c2 = fl.getGui(f.listFiles(new TextFileFilter()),false);
//                Component c2 = fl.getGui(f.listFiles(),false);
                File[] parentFile = {f};
                Component c2 = fl.getGui(parentFile,false);

                JFrame frame = new JFrame("File List");
                JPanel gui = new JPanel(new BorderLayout());
                gui.add(c1,BorderLayout.WEST);
                gui.add(c2,BorderLayout.CENTER);
                c2.setPreferredSize(new Dimension(375,100));
                gui.setBorder(new EmptyBorder(3,3,3,3));

                frame.setContentPane(gui);
                frame.pack();
                frame.setLocationByPlatform(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

class TextFileFilter implements FileFilter {

    public boolean accept(File file) {
        // implement the logic to select files here..
        String name = file.getName().toLowerCase();
        //return name.endsWith(".java") || name.endsWith(".class");
        return name.length()<20;
    }
}

class FileRenderer extends DefaultListCellRenderer {

    private boolean pad;
    private Border padBorder = new EmptyBorder(3,3,3,3);

    FileRenderer(boolean pad) {
        this.pad = pad;
    }

    @Override
    public Component getListCellRendererComponent(
        JList list,
        Object value,
        int index,
        boolean isSelected,
        boolean cellHasFocus) {

        Component c = super.getListCellRendererComponent(
            list,value,index,isSelected,cellHasFocus);
        JLabel l = (JLabel)c;
        File f = (File)value;
        l.setText(f.getName());
        l.setIcon(FileSystemView.getFileSystemView().getSystemIcon(f));
        if (pad) {
            l.setBorder(padBorder);
        }

        return l;
    }
}
