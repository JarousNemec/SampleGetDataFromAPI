import org.yaml.snakeyaml.Yaml;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.stream.Collectors;





public class Main {

    public static void main(String[] args) throws Exception {
        // Create a neat value object to hold the URL
        URL url = new URL("https://v6.exchangerate-api.com/v6/602e2ce3b4ad5516605f9c03/latest/USD");

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        InputStream responseStream = connection.getInputStream();


        String text = new BufferedReader(
                new InputStreamReader(responseStream, StandardCharsets.UTF_8))
                .lines()
                .collect(Collectors.joining("\n"));

        Yaml yaml = new Yaml();
        Map<String, Object> data = yaml.load(text);
        Map<String, Object> data2 = (Map<String, Object>) data.get("conversion_rates");
        System.out.println(data2.get("CZK"));
    }
}
