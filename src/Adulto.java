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
    public void imprime() {
        imprimeDatos();
    }


    public void imprimeDatos() {
        super.imprimeDatos();
        System.out.println("Telefono     :" + telefono);
        System.out.println("Ocupacion    :" + ocupacion);
    }


    @Override
    public void leer() {
        leerDatos();
    }

    public void leerDatos() {
        super.leerDatos();
        Scanner miScan = new Scanner(System.in);
        System.out.print("Telefono: ");
        telefono = miScan.nextLine();
        System.out.print("Ocupacion: ");
        ocupacion = miScan.nextLine();

    }


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