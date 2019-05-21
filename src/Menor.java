import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Menor extends Cuentahabiente {

    private String rfcTutor;
    private String nombrePadre;
    private String nombreMadre;

    Menor(String nombre, String domicilio, String rfc,
          String fechaNacimiento,
          String rfcTutor, String nombrePadre,
          String nombreMadre) {
        super(nombre, domicilio, rfc, fechaNacimiento);
        this.rfcTutor = rfcTutor;
        this.nombrePadre = nombrePadre;
        this.nombreMadre = nombreMadre;
    }

    Menor() {
        super();
    }


    @Override
    public void imprime() {
        super.imprimeDatos();
        System.out.println("RFC Tutor    :" + rfcTutor);
        System.out.println("Madre        :" + nombreMadre);
        System.out.println("Padre        :" + nombrePadre);
    }

    @Override
    public void leer(String rfc,String rfcTutor) {
        super.leerDatos(rfc);
        Scanner miScan = new Scanner(System.in);
        this.rfcTutor = rfcTutor;
        System.out.print("Nombre Padre: ");
        nombrePadre = miScan.nextLine();
        System.out.print("Nombre Madre: ");
        nombreMadre = miScan.nextLine();

        guardar();
        System.out.println("Guardado");
    }

    @Override
    public void guardar(){
        String line;
        line = super.getNombre()+"|"+super.getDomicilio()+"|"+super.getRfc()+"|"+super.getFechaNacimiento()+"|"+rfcTutor+"|"+nombrePadre+"|"+nombreMadre;
        ArrayList<String> input = new ArrayList<>();
        String linein;
        BufferedReader entrada;
        PrintWriter salida=null;

        try{
            entrada = new BufferedReader(new FileReader("data/cuentahabientes.txt"));
            while((linein = entrada.readLine()) != null){
                input.add(linein);
            }

            entrada.close();
            salida = new PrintWriter(new FileWriter("data/cuentahabientes.txt"));

            for (String elemento:input) {
                salida.write(elemento+"\n");
            }
            salida.write(line+"\n");


        } catch (IOException e){
            System.out.println("Error em guardado de menor");
        } finally {
            if(salida != null){
                salida.close();
            }
        }
    }


    @Override
    public void leer(String rfc){
    }


}