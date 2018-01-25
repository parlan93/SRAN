package helper;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Bartłomiej Skibiński
 */
public class FileReaderHelper {
    
    private static final String PATH = "G:/DATA/PSS/";
    
    public static File convert(MultipartFile file) throws IOException {
        File conv = new File(PATH + file.getOriginalFilename() + "-" + String.valueOf(new Date().getTime()) + ".pdf");
        conv.createNewFile();
        file.transferTo(conv);
        return conv;
    }
    
    public static File convertRevision(MultipartFile file) throws IOException {
        File conv = new File(PATH + file.getOriginalFilename() + "-" + String.valueOf(new Date().getTime()) + "-poprawiony.pdf");
        conv.createNewFile();
        file.transferTo(conv);
        return conv;
    }
    
}
