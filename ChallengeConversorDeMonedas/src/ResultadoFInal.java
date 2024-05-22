import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ResultadoFInal {
    private String moneda;
    private String cambio;
    private Double monto;
    private Double conversion_rate;
    private Double resultado;
    private String fechaConsulta;

    public ResultadoFInal(ResultadoConsulta respuesta, Double monto) {
        this.moneda = respuesta.base_code();
        this.cambio = respuesta.target_code();
        this.monto = monto;
        this.conversion_rate = respuesta.conversion_rate();
        this.resultado = respuesta.conversion_result();
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        this.fechaConsulta = myDateObj.format(myFormatObj);

    }

    public String getFechaConsulta() {
        return fechaConsulta;
    }

    public String toString() {
        return  "1.0" + "[" + moneda + "] " +"= " + conversion_rate +"[" + cambio + "]" + "\n" +
                "El valor de " + monto +
                "[" + moneda + "]"+
                " corresponde al valor final de ==> " + resultado +
                "[" + cambio + "]";
    }

}
