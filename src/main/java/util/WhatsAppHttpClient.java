package util;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WhatsAppHttpClient {

    private static final String PHONE_NUMBER_ID = "901177416408756"; // Your sending number ID
    private static final String ACCESS_TOKEN = "EAAREQDbTOrIBQGZBlJmzVZAXtJKisqN7dyrg6w602avXx95CWxX6cKgtZBbT4zUFZCNA3QJwusFQ56OUf0IumdcnLRZAl6qNH2UbBmajtVYzfkjZA9lr7BYbW8HPa340hGcDFZCxwiUWh2giblcmdE3NTeEFFXW1ectWwsW4IsSLfRRrMZA2DB68oOIjnTSdekP0exMBgjY8GZBaYe11O9dYalrZA6lFmhvdtx0gb4UHSqDOulJMF9BljI49ZBqypcWjuBbhOwPeKBIhplloErQAaW7BUbrJwjUntLhZAZANkjQZDZD";

    public static String sendTemplateMessage(String recipient, String templateName) {
        try {

            // Correct WhatsApp template JSON including components
            String jsonBody = "{"
                    + "\"messaging_product\":\"whatsapp\","
                    + "\"to\":\"" + recipient + "\","
                    + "\"type\":\"template\","
                    + "\"template\":{"
                    + "\"name\":\"" + templateName + "\","
                    + "\"language\":{"
                    + "\"code\":\"en_US\""
                    + "},"
                    + "\"components\":["
                    + "{"
                    + "\"type\":\"body\","
                    + "\"parameters\":["
                    + "{\"type\":\"text\",\"text\":\"Uditha\"},"
                    + "{\"type\":\"text\",\"text\":\"Isanka\"},"
                    + "{\"type\":\"text\",\"text\":\"3.30PM\"}"
                    + "]"
                    + "}"
                    + "]"
                    + "}"
                    + "}";


            // Build HTTP POST request
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://graph.facebook.com/v22.0/" + PHONE_NUMBER_ID + "/messages"))
                    .header("Authorization", "Bearer " + ACCESS_TOKEN)
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                    .build();

            // Send the request
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Print response
            System.out.println("Status Code: " + response.statusCode());
            System.out.println("Response Body: " + response.body());

            return response.body();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
