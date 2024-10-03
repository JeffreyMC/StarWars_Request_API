import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        ConsultaPelicula consulta = new ConsultaPelicula();

        Scanner escritura = new Scanner(System.in);
        System.out.print("Escriba el numero de la pelicula de Star Wars a consultar: ");

        try{
            var numeroPelicula = Integer.valueOf(escritura.nextLine());

            Pelicula pelicula = consulta.buscaPelicula(numeroPelicula);

            System.out.println(pelicula);

            GeneradorDeArchivo crearArchivo = new GeneradorDeArchivo();
            crearArchivo.guardarJson(pelicula);

        }catch (NumberFormatException e){
            System.out.println("Numero no encontrado: " + e.getMessage());
        } catch (RuntimeException | IOException e) {
            System.out.println(e.getMessage());;
            System.out.println("Finalizando la aplicacion...");
        }
    }
}
