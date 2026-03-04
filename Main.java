public class Main {
    public static void main(String[] args) {

        System.out.println("Main thread continues processing...");

        // List of URLs to fetch
        String[] urls = {
                " https://www.example.com",
                "https://www.wikipedia.org",
                "https://httpbin.org/get"

        };

        // Start a separate thread for each URL
        for (int i = 0; i < urls.length; i++) {
            Thread t = new Thread(new URLFetcherThread(urls[i]));
            t.setName("FetcherThread-" + (i + 1));
            t.start();
        }
        // Main thread can continue doing other tasks
        System.out.println("Main thread can keep doing other work while URLs are being fetched...");
    }
}