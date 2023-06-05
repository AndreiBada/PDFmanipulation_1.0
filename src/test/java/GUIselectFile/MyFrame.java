package GUIselectFile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.jar.JarEntry;

public class MyFrame extends JFrame implements ActionListener {

    JButton button;

    MyFrame() {
        this.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        this.setLayout (new FlowLayout ());

        button = new JButton ("Select File");
        button.addActionListener (this);

        this.add (button);
        this.pack ();
        this.setVisible (true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource () == button) {
            JFileChooser fileChooser = new JFileChooser ();

            // seteaza implicit locatia fisierului de unde sa-mi selectez documentele

//            fileChooser.setCurrentDirectory (new File (".")); // seteaza locatia din fisierul din proiectul actual
            fileChooser.setCurrentDirectory (new File ("C:\\Users\\andre\\OneDrive\\Desktop\\PDF Files"));
//            fileChooser.showOpenDialog (null); // select file to open
//            System.out.println (fileChooser.showOpenDialog (null)); // select file to open

            int response = fileChooser.showOpenDialog (null);
            if (response == JFileChooser.APPROVE_OPTION) {
                File file = new File (fileChooser.getSelectedFile ().getAbsolutePath ());
                System.out.println (file);
            }
        }

    }

}
