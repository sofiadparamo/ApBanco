import java.io.*;
import java.util.ArrayList;
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
    public void guardar(){
        String line;
        line = super.getFecha()+"|"+super.getSaldo()+"|"+vigencia+"|"+numTelefono+"|"+codigo+"|"+nip;
        PrintWriter salida=null;
        BufferedReader entrada;
        ArrayList<String> input = new ArrayList<>();
        String linein;

        try{
            entrada = new BufferedReader(new FileReader("data/cuentas.txt"));
            while((linein = entrada.readLine()) != null){
                input.add(linein);
            }

            entrada.close();

            salida = new PrintWriter(new FileWriter("data/cuentas.txt"));

            for (String elemento:input) {
                salida.write(elemento+"\n");
            }
            salida.write(line+"\n");

        } catch (IOException e){
            System.out.println("Error en guardado de cuenta normal");
        } finally {
            if(salida != null){
                salida.close();
            }
        }

    }

    @Override
    public void leer(String tel){
        super.leerDatos();
        boolean flag=false;
        Scanner miScan = new Scanner(System.in);
        System.out.print("Vigencia: ");
        vigencia = miScan.nextLine();
        numTelefono=tel;
        System.out.print("Codigo: ");
        codigo = miScan.nextLine();
        do {
            Scanner miScan2 = new Scanner(System.in);

            System.out.print("NIP: ");
            try {
                nip = miScan2.nextInt();
                flag=false;
            } catch (Exception e){
                System.out.println("Excepción en NIP, debe ser entero: "+e.toString());
                flag=true;
            }
        }while (flag);

        guardar();
    }

    public void leer(String rfc,String numeroGenerado){}

    @Override
    public String getNumero(){
        return numTelefono;
    }

    public String getRfc(){
        return "null";
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









