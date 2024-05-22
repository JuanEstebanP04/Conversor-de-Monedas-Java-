import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {
    public ResultadoConsulta consulta(String moneda, String cambio, Double monto){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/a8a03b41d17e3aaeb5067c5f/pair/"+moneda+"/"+cambio+"/"+monto);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(),ResultadoConsulta.class);
        } catch (Exception e ){
            throw new RuntimeException("No se logró realizar el cambio de moneda");
        }
    }
}
