import java.util.Scanner;

public class CuentaNormal extends Cuenta {
    private String numero, rfc;

    CuentaNormal(String fecha, float saldo,
                        String numero, String rfc) {
        super(fecha, saldo);
        this.numero = numero;
        this.rfc = rfc;
    }

    CuentaNormal(){
        super();
    }

    @Override
    public void imprime(){
        super.imprimeDatos();
        System.out.println("Número:             " + numero);
        System.out.println("RFC:                " + rfc);
    }

    @Override
    public void leer(){
        super.leerDatos();
        Scanner miScan = new Scanner(System.in);
        System.out.print("Numero: ");
        numero = miScan.nextLine();
        System.out.print("RFC: ");
        rfc = miScan.nextLine();
    }

    @Override
    public String getNumero(){
        return numero;
    }

    /*public String getNumero() {
        return numero;
    }*/

    public String getRfc() {
        return rfc;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }
}









