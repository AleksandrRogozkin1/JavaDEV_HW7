import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpStatusChecker {
    public String getStatusImage(int code) throws IOException {
        String stringUrl = Utils.START_URL + code + Utils.EXTENSION;
        HttpURLConnection connection = (HttpURLConnection) new URL(stringUrl).openConnection();
        int responseCode = connection.getResponseCode();
        if(responseCode == 404) {
            throw new FileNotFoundException(String.format(Utils.FILE_NOT_FOUND_EXCEPTION_TEXT, code));
        } else {
            return stringUrl;
        }

    }
}
