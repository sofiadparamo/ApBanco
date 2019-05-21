import java.io.*;
import java.util.ArrayList;

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
    public void leer(String rfc){
    }

    @Override
    public void guardar(){
        String line;
        line = super.getFecha()+"|"+super.getSaldo()+"|"+numero+"|"+rfc;
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
    public void leer(String rfc, String numeroGenerado){
        super.leerDatos();
        this.rfc=rfc;
        this.numero=numeroGenerado.trim();
        guardar();
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









