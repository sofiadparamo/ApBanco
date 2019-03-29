import java.util.Scanner;

public class Prestamo extends Cuenta {

    private String rfc;
    private float monto;
    private String concepto;

    public Prestamo() {
        super();
    }


    public Prestamo(String rfc, float monto, float saldo, String fecha, String concepto) {
        super(fecha, saldo);
        this.rfc = rfc;
        this.monto = monto;
        this.concepto = concepto;
    }


    @Override
    public void imprime(){
        super.imprimeDatos("Prestamo");
        System.out.println("RFC:                "+rfc);
        System.out.println("Monto:              "+monto);
        System.out.println("Concepto:           "+concepto);
    }

    @Override
    public void leer() {
        super.leerDatos();
        Scanner leer = new Scanner(System.in);

        System.out.print("RFC: ");
        rfc = leer.nextLine();
        System.out.print("Ingrese el monto del prestamo: ");
        monto = Float.parseFloat(leer.nextLine());
        System.out.print("Ingrese la razón del préstamo: ");
        concepto = leer.nextLine();

    }

    @Override
    public String getNumero(){
        return "null";
    }

    public String getRfc() {
        return rfc;
    }

    public float getMonto() {
        return monto;
    }

    public float getSaldo() {
        return super.getSaldo();
    }

    public String getFecha() {
        return super.getFecha();
    }

    public String getConcepto() {
        return concepto;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public void setSaldo(float saldo) {
        super.setSaldo(saldo);
    }

    public void setFecha(String fecha) {
        super.setFecha(fecha);
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

}