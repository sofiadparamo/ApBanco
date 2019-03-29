import java.util.Scanner;

public class CuentaSinTarjeta extends Cuenta {
    private String vigencia, numTelefono, codigo;
    private int nip;

    CuentaSinTarjeta(String fecha, float saldo,
                            String vigencia, String numTelefono,
                            String codigo, int nip) {
        super(fecha, saldo);
        this.vigencia = vigencia;
        this.numTelefono = numTelefono;
        this.codigo = codigo;
        this.nip = nip;
    }

    CuentaSinTarjeta(){
        super();
    }

    @Override
    public void imprime(){
        super.imprimeDatos();
        System.out.println("Vigencia:           " + vigencia);
        System.out.println("Numero de teléfono: " + numTelefono);
        //System.out.println("Codigo:             " + codigo);
        //System.out.println("NIP:                " + nip);
    }

    @Override
    public void leer(){
        super.leerDatos();
        Scanner miScan = new Scanner(System.in);
        System.out.print("Vigencia: ");
        vigencia = miScan.nextLine();
        System.out.print("Num de teléfono: ");
        numTelefono = miScan.nextLine();
        System.out.print("Codigo: ");
        codigo = miScan.nextLine();
        System.out.print("NIP: ");
        nip = miScan.nextInt();
    }

    @Override
    public String getNumero(){
        return numTelefono;
    }

    public String getVigencia() {
        return vigencia;
    }

    String getNumTelefono() {
        return numTelefono;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getNip() {
        return nip;
    }

    public void setVigencia(String vigencia) {
        this.vigencia = vigencia;
    }

    public void setNumTelefono(String numTelefono) {
        this.numTelefono = numTelefono;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNip(int nip) {
        this.nip = nip;
    }
}









