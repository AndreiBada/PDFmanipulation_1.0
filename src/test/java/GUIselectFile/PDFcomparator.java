package GUIselectFile;

import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;

public class PDFcomparator extends JFrame {

    private JButton Insert;
    private JButton comparaButton;
    private JPanel MainPanel;
    private JButton WriteText;

    public PDFcomparator() {
        setContentPane (MainPanel);
        setTitle ("PDFComparator");
        setDefaultCloseOperation (EXIT_ON_CLOSE);
        setSize (300, 200);
        setLocationRelativeTo (null);
        setVisible (true);

        Insert.addActionListener (new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource () == Insert) {
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
        });

        WriteText.addActionListener (new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource () == WriteText) {
                    String SRC = "C:\\Users\\andre\\OneDrive\\Desktop\\PDF Files\\Free_Test_Data_100KB_PDF.pdf";
                    String DEST = "C:\\Users\\andre\\OneDrive\\Desktop\\PDF Files\\Results\\Result.pdf";

                    try {
                        //Create PdfReader instance.
                        PdfReader pdfReader =
                                new PdfReader (SRC);

                        //Create PdfStamper instance.
                        PdfStamper pdfStamper = new PdfStamper (pdfReader,
                                new FileOutputStream (DEST));

                        //Create BaseFont instance.
                        BaseFont baseFont = BaseFont.createFont (
                                BaseFont.TIMES_ROMAN,
                                BaseFont.CP1252, BaseFont.NOT_EMBEDDED);

                        //Get the number of pages in pdf.
                        int pages = pdfReader.getNumberOfPages ();
                        System.out.println (pdfStamper.getOverContent (1));

                        //Contain the pdf data.
                        PdfContentByte pageContentByte = pdfStamper.getOverContent (1);
                        pageContentByte.setFlatness (89);
                        pageContentByte.beginText ();

                        //Set text font and size. Set position in the page
                        pageContentByte.setFontAndSize (baseFont, 30);
                        pageContentByte.setTextMatrix (300, 720);

                        //Write text
                        pageContentByte.setWordSpacing (12);
                        pageContentByte.showText ("Embossing Type T2");
                        pageContentByte.endText ();

                        pdfStamper.close ();



                        System.out.println ("PDF modified successfully.");
                    } catch (Exception f) {
                        f.printStackTrace ();
                    }
                }
            }
        });

    }


    public static void main(String[] args) {
        new PDFcomparator ();
        new WriteTextPDF ();

    }

}

