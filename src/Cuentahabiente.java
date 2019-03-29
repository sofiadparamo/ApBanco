import java.util.Scanner;

public abstract class Cuentahabiente {
    private String nombre, domicilio, rfc, fechaNacimiento;

    Cuentahabiente(String nombre, String domicilio, String rfc,
                          String fechaNacimiento) {
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.rfc = rfc;
        this.fechaNacimiento = fechaNacimiento;
    }

    Cuentahabiente() {

    }


    protected void imprimeDatos() {
        System.out.println("-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-");
        System.out.println("Nombre       :" + nombre);
        System.out.println("Domicilio    :" + domicilio);
        System.out.println("RFC          :" + rfc);
        System.out.println("FechaNac     :" + fechaNacimiento);
    }

    protected void leerDatos() {
        System.out.println("\n--------------Nuevo Cuentahabiente --------");
        Scanner miScan = new Scanner(System.in);
        System.out.print("Nombre: ");
        nombre = miScan.nextLine();
        System.out.print("Domicilio: ");
        domicilio = miScan.nextLine();
        System.out.print("RFC: ");
        rfc = miScan.nextLine();
        System.out.print("Fecha de Nacim: ");
        fechaNacimiento = miScan.nextLine();
    }

    protected abstract void imprime();


    protected abstract void leer();



    public String getNombre() {
        return nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public String getRfc() {
        return rfc;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}