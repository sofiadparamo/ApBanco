import java.util.Scanner;

public abstract class Cuenta implements Registro {
    private String fecha;
    private float saldo;

    Cuenta(String fecha, float saldo) {
        this.saldo = saldo;
        this.fecha = fecha;
    }

    Cuenta() {

    }

    protected void imprimeDatos() {
        System.out.println("\n----------------------------");
        System.out.println("Saldo:              " + saldo);
        System.out.println("Fecha:              " + fecha);
    }

    protected boolean imprimeDatos(String text) {
        if (saldo > 0) {
            System.out.println("\n-------------" + text + "---------------");
            System.out.println("Saldo:              " + saldo);
            System.out.println("Fecha:              " + fecha);
            return true;
        } else
            return false;
    }

    protected void leerDatos() {
        boolean flag=false;
        System.out.println("\n--------------Nueva Cuenta--------");
        Scanner miScan = new Scanner(System.in);
        System.out.print("Fecha: ");
        fecha = miScan.nextLine();
        do {
            Scanner miScan2 = new Scanner(System.in);
            System.out.print("Saldo inicial: ");
            try {
                saldo = miScan2.nextFloat();
                flag=false;
            } catch (Exception e){
                System.out.println("Excepción en saldo inicial, debe ser flotante: "+e.toString());
                flag=true;
            }
        }while (flag);
    }

    protected void leerDatos(boolean flag) {
        System.out.println("\n--------------Nuevo Prestamo--------");
        Scanner miScan = new Scanner(System.in);
        System.out.print("Fecha: ");
        fecha = miScan.nextLine();
        saldo = 0f;
    }

    protected abstract String getNumero();

    protected abstract String getRfc();

    float getSaldo() {
        return saldo;
    }

    public String getFecha() {
        return fecha;
    }

    void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}









