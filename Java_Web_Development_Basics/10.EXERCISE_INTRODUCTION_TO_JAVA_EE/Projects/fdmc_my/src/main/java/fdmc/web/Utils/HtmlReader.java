package fdmc.web.Utils;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface HtmlReader {

    String readHtmlFile(String htmlFilePath) throws IOException;

}
