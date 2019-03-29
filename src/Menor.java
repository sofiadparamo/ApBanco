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
        imprimeDatos();
    }

    public void imprimeDatos() {
        super.imprimeDatos();
        System.out.println("RFC Tutor    :" + rfcTutor);
        System.out.println("Madre        :" + nombreMadre);
        System.out.println("Padre        :" + nombrePadre);
    }


    @Override
    public void leer() {
        leerDatos();
    }

    @Override
    public void leerDatos() {
        super.leerDatos();
        Scanner miScan = new Scanner(System.in);
        System.out.print("RFC Tutor: ");
        rfcTutor = miScan.nextLine();
        System.out.print("Nombre Padre: ");
        nombrePadre = miScan.nextLine();
        System.out.print("Nombre Madre: ");
        nombreMadre = miScan.nextLine();
    }


    public String getRfcTutor() {
        return rfcTutor;
    }

    public String getNombrePadre() {
        return nombrePadre;
    }

    public String getNombreMadre() {
        return nombreMadre;
    }

    public void setRfcTutor() {
        this.rfcTutor = rfcTutor;
    }

    public void setNombrePadre() {
        this.nombrePadre = nombrePadre;
    }

    public void setNombreMadre() {
        this.nombreMadre = nombreMadre;
    }

}