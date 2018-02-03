package pdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;
import domain.Article;
import domain.Review;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Bartłomiej Skibiński
 */
public class ReviewToPdf extends AbstractPdfView {

    //TODO: Edytować pdf z recenzją
    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter pdfWriter, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Article article = (Article) model.get("article");
        Review review = (Review) model.get("review");
        
        Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, BaseColor.BLACK);
        Font headerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14, BaseColor.BLACK);
        Font labelFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 11, BaseColor.LIGHT_GRAY);
        Font contentFont = FontFactory.getFont(FontFactory.HELVETICA, 12, BaseColor.DARK_GRAY);
        
        Paragraph header = new Paragraph(article.getTitle(), titleFont);
        DottedLineSeparator separator = new DottedLineSeparator();
        separator.setOffset(-2);
        separator.setGap(2f);
        header.add(separator);
        document.add(header);
        
        Paragraph authors = new Paragraph(article.getAuthors(), labelFont);
        authors.add(separator);
        document.add(authors);
        
        Paragraph reviewInfo = new Paragraph();
        reviewInfo.add(new Paragraph("Recenzent: " + review.getUser().getTitle() + " " + review.getUser().getFirstname() + " " + review.getUser().getLastname(), contentFont));
        reviewInfo.add(new Paragraph("Organizacja: " + review.getUser().getOrganization(), contentFont));
        reviewInfo.add(separator);
        document.add(reviewInfo);
        
        Paragraph description = new Paragraph();
        description.add(new Paragraph("Opis", headerFont));
        description.add(new Paragraph(review.getDescription(), contentFont));
        document.add(description);
    }
    
}
