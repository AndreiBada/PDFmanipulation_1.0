package GUIselectFile;

import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import lombok.SneakyThrows;

import java.io.FileOutputStream;
import java.io.IOException;

public class WriteTextPDF {
    @SneakyThrows

    public WriteTextPDF() {

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

            //Set text font and size. Set pozition in the page
            pageContentByte.setFontAndSize (baseFont, 30);
            pageContentByte.setTextMatrix (300, 720);

            //Write text
            pageContentByte.setWordSpacing (12);
            pageContentByte.showText ("Embossing Type T2");
            pageContentByte.endText ();

            pdfStamper.close ();

            System.out.println ("PDF modified successfully.");
        } catch (Exception e) {
            e.printStackTrace ();
        }
    }
}

