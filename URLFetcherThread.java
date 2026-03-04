import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class URLFetcherThread implements Runnable {

    private final String urlString;

    public URLFetcherThread(String url) {
        this.urlString = url;
    }

    @Override
    public void run() {
        BufferedReader reader = null;
        try {
            URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Thread [" + Thread.currentThread().getName() + "]: Line from URL: " + line);
            }
        } catch (MalformedURLException e) {
            System.out.println(
                    "Thread [" + Thread.currentThread().getName() + "] Error: Malformed URL - " + e.getMessage());
        } catch (IOException e) {
            System.out.println(
                    "Thread [" + Thread.currentThread().getName() + "] Error: IO Exception - " + e.getMessage());
        } finally {
            try {
                if (reader != null)
                    reader.close();
            } catch (IOException e) {
                System.out.println(
                        "Thread [" + Thread.currentThread().getName() + "] Error closing reader: " + e.getMessage());
            }
        }
    }
}