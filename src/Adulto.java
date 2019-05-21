import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Adulto extends Cuentahabiente {

    private String telefono;
    private String ocupacion;

    public Adulto(String nombre, String domicilio, String rfc,
                  String fechaNacimiento,
                  String telefono, String ocupacion) {
        super(nombre, domicilio, rfc, fechaNacimiento);
        this.telefono = telefono;
        this.ocupacion = ocupacion;
    }

    public Adulto() {
        super();
    }

    @Override
    public void guardar(){
        String line;
        line = super.getNombre()+"|"+super.getDomicilio()+"|"+super.getRfc()+"|"+super.getFechaNacimiento()+"|"+telefono+"|"+ocupacion;
        PrintWriter salida=null;
        BufferedReader entrada;
        ArrayList<String> input = new ArrayList<>();
        String linein;

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
            System.out.println("Error en guardado de mayor");
        } finally {
            if(salida != null){
                salida.close();
            }
        }

    }

    @Override
    public void imprime() {
        super.imprimeDatos();
        System.out.println("Telefono     :" + telefono);
        System.out.println("Ocupacion    :" + ocupacion);
    }


    @Override
    public void leer(String rfc){
        super.leerDatos(rfc);
        Scanner miScan = new Scanner(System.in);
        System.out.print("Telefono: ");
        telefono = miScan.nextLine();
        System.out.print("Ocupacion: ");
        ocupacion = miScan.nextLine();
        try {
            guardar();
        } catch (Exception e){
            System.out.println("\tExcepción no cubierta.");
            e.printStackTrace();
        }
    }

    @Override
    public void leer(String rfc, String rfctutor){}


    public String getTelefono() {
        return telefono;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion() {
        this.ocupacion = ocupacion;
    }

    public void setTelefono() {
        this.telefono = telefono;
    }

}