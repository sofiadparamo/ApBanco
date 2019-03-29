import java.util.Scanner;

public abstract class Cuenta {
    private String fecha;
    private float saldo;

    Cuenta(String fecha, float saldo) {
        this.saldo = saldo;
        this.fecha = fecha;
    }

    Cuenta(){

    }

    protected void imprimeDatos(){
        System.out.println("\n----------------------------");
        System.out.println("Saldo:              "+saldo);
        System.out.println("Fecha:              "+fecha);
    }

    protected void imprimeDatos(String text){
        System.out.println("\n-------------"+text+"---------------");
        System.out.println("Saldo:              "+saldo);
        System.out.println("Fecha:              "+fecha);
    }

    protected void leerDatos(){
        System.out.println("\n--------------Nuevo Cuenta--------");
        Scanner miScan = new Scanner(System.in);
        System.out.print("Fecha: ");
        fecha = miScan.nextLine();
        System.out.print("Saldo inicial: ");
        saldo = miScan.nextFloat();
    }

    protected abstract void imprime();

    protected abstract void leer();

    protected abstract String getNumero();

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









