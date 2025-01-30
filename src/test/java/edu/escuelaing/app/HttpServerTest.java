package edu.escuelaing.app;

import static org.junit.jupiter.api.Assertions.*;

        import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpServerTest {

    private static Thread serverThread;

    @BeforeAll
    static void startServer() {
        serverThread = new Thread(() -> {
            try {
                HttpServer.main(new String[]{});
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        serverThread.start();

        // Esperar unos segundos para que el servidor inicie
        try { Thread.sleep(3000); } catch (InterruptedException ignored) {}
    }

    @AfterAll
    static void stopServer() {
        serverThread.interrupt();
    }

    @Test
    void testGetIndexHtml() throws Exception {
        URL url = new URL("http://localhost:35000/");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        assertEquals(200, conn.getResponseCode());
        String contentType = conn.getHeaderField("Content-Type");
        assertEquals("text/html", contentType);
    }

    @Test
    void testGetNotFound() throws Exception {
        URL url = new URL("http://localhost:35000/noexiste.html");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        assertEquals(404, conn.getResponseCode());
    }

    @Test
    void testRestServiceGet() throws Exception {
        URL url = new URL("http://localhost:35000/app/rest-service");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        assertEquals(200, conn.getResponseCode());
        String responseBody = readResponse(conn);
        assertTrue(responseBody.contains("\"names\""));
    }

    @Test
    void testRestServicePost() throws Exception {
        URL url = new URL("http://localhost:35000/app/rest-service?name=TestUser");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");

        assertEquals(201, conn.getResponseCode());
        String responseBody = readResponse(conn);
        assertTrue(responseBody.contains("\"name\":\"TestUser\""));
    }

    private String readResponse(HttpURLConnection conn) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }
}
