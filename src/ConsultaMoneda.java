import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;



public class ConsultaMoneda {
    private String monedaBase = "USD";
    private String monedaObjetivo = "COP";
    private double valorDeLaConversion = 1.0;


    public void setMonedaBase(String monedaBase) {
        this.monedaBase = monedaBase;
    }

    public void setMonedaObjetivo(String monedaObjetivo) {
        this.monedaObjetivo = monedaObjetivo;
    }

    public void setValorDeLaConversion(double valorDeLaConversion) {
        this.valorDeLaConversion = valorDeLaConversion;
    }

    public Moneda buscaMoneda(){
        URI direccion = URI.create("https://v6.exchangerate-api.com" +
                "/v6/58710787d1315e714e4a090b/pair/"+monedaBase+"/"+monedaObjetivo+"/"+valorDeLaConversion);


        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moneda.class);
        }catch (Exception e){
            throw new RuntimeException("No encontre esta moneda");
        }
    }
}
