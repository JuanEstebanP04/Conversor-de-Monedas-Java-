import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConsultaMoneda consulta = new ConsultaMoneda();
        Historial historial = new Historial();
        String moneda = "";
        String cambio = "";
        Double monto = 0.0;
        String mensaje = """
                  
                  "***********************************************
                  Sea bienvenid@ al conversor de monedas
                  ***********************************************+
                  Menú de opciones
                 
                  -------------------------------
                  1) Dólar >>> Peso Argentino
                  2) Peso argentino >>> Dólar
                  3) Dólar >>> Real Brasileño
                  4) Real brasileño >>> Dólar
                  5) Dólar >>> Peso Colombiano
                  6) Peso Colombiano >>> Dólar
                  7) Ver historial de consultas
                  8) Salir del programa
                  -------------------------------
                  """;
        System.out.println(mensaje);
        while (true){
            System.out.println("Elija la opción deseada: ");
             var busqueda = Integer.valueOf(lectura.nextLine());
            if(busqueda.equals(8)){
                break;
            }
            switch (busqueda){
                case 1:{
                    moneda = "USD";
                    cambio = "ARS";
                    break;
                }
                case 2:{
                    moneda = "ARS";
                    cambio = "USD";
                    break;
                }
                case 3:{
                    moneda = "USD";
                    cambio = "BRL";
                    break;
                }
                case 4:{
                    moneda = "BRL";
                    cambio = "USD";
                    break;
                }
                case 5:{
                    moneda = "USD";
                    cambio = "COP";
                    break;
                }
                case 6:{
                    moneda = "COP";
                    cambio = "USD";
                    break;
                }
                case 7:{
                    System.out.println(historial);
                    break;
                }
                default: {
                    System.out.println("Opcion incorrecta");
                    break;
                }

            }
            if(busqueda<=6) {
                System.out.println("Ingresa el monto a convertir: ");
                monto = Double.parseDouble(lectura.nextLine());
                ResultadoConsulta resultado = consulta.consulta(moneda, cambio, monto);
                ResultadoFInal response = new ResultadoFInal(resultado, monto);
                historial.AddConsulta(response);
                System.out.println(response);
            }
        }
        System.out.println("Finalizando la aplicación");
    }
}
