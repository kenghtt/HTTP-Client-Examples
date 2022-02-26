import VO.RootItem;
import VO.Users_Good;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClientTest {


    private static final String GET_API_URL = "https://jsonplaceholder.typicode.com/users";

    public static void main(String[] args) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .header("accept","application/json")
                .uri(URI.create(GET_API_URL))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String jsonString = "{\n" +
                "  \"name\": \"Jeremy\",\n" +
                "  \"id\": \"124\"\n" +
                "}\n";

        Gson gson = new Gson();
        RootItem[] usersGoodResponse =  gson.fromJson(response.body(), RootItem[].class);
//        Employee usersGoodResponse =  gson.fromJson(jsonString, Employee.class);



        System.out.println(usersGoodResponse);



    }
}
