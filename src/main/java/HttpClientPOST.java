import VO.RootItem;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClientPOST {


    private static final String GET_API_URL = "https://jsonplaceholder.typicode.com/users";

    public static void main(String[] args) throws IOException, InterruptedException {

        String postEndpoint = "http://dummy.restapiexample.com/api/v1/create";

        String inputJson = "{ \"name\":\"tammy133\", \"salary\":\"5000\", \"age\":\"20\" }";

        var request = HttpRequest.newBuilder()
                .uri(URI.create(postEndpoint))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(inputJson))
                .build();

        var client = HttpClient.newHttpClient();

        var response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.statusCode());
        System.out.println(response.body());



    }
}
