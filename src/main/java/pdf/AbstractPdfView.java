package pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.ByteArrayOutputStream;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.view.AbstractView;

/**
 *
 * @author Bartłomiej Skibiński
 */
public abstract class AbstractPdfView extends AbstractView {

    public AbstractPdfView() {
        initView();
    }

    private void initView() {
        setContentType("application/pdf");
    }

    @Override
    protected boolean generatesDownloadContent() {
        return true;
    }

    @Override
    protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        ByteArrayOutputStream baos = createTemporaryOutputStream();

        Document document = new Document(PageSize.A4);
        PdfWriter pdfWriter = PdfWriter.getInstance(document, baos);
        prepareWriter(model, pdfWriter, request);
        buildPdfMetaData(model, document, request);

        document.open();
        buildPdfDocument(model, document, pdfWriter, request, response);
        document.close();

        writeToResponse(response, baos);
    }

    protected void prepareWriter(Map<String, Object> model, PdfWriter pdfWriter, HttpServletRequest request) {
        pdfWriter.setViewerPreferences(getViewerPreferences());
    }

    protected int getViewerPreferences() {
        return PdfWriter.ALLOW_PRINTING | PdfWriter.PageLayoutSinglePage;
    }

    protected void buildPdfMetaData(Map<String, Object> model, Document document, HttpServletRequest request) {
        document.addCreationDate();
        document.addTitle("Artykuł Naukowy");
    }

    protected abstract void buildPdfDocument(
            Map<String, Object> model,
            Document document,
            PdfWriter pdfWriter,
            HttpServletRequest request,
            HttpServletResponse response)
            throws Exception;

}
