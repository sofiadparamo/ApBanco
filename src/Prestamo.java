import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Prestamo extends Cuenta {

    private String rfc, concepto;
    private float monto;

    public Prestamo() {
        super();
    }


    public Prestamo(String fecha, String rfc, float monto, float saldo, String concepto) {
        super(fecha, saldo);
        this.rfc = rfc;
        this.monto = monto;
        this.concepto = concepto;
    }


    @Override
    public void imprime(){
        if (super.imprimeDatos("Prestamo")) {
            System.out.println("RFC:                " + rfc);
            System.out.println("Monto:              " + monto);
            System.out.println("Concepto:           " + concepto);
        }
    }

    @Override
    public void guardar(){
        String line;
        line = super.getFecha()+"|"+rfc+"|"+monto+"|"+getSaldo()+"|"+concepto;
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
    public void leer(String rfc) {
        super.leerDatos(true);
        boolean flag;
        Scanner leer = new Scanner(System.in);

        this.rfc = rfc;
        do {
            System.out.print("Ingrese el monto del prestamo: ");
            Scanner leer2 = new Scanner(System.in);
            try {
                monto = Float.parseFloat(leer2.nextLine());
                flag=false;
            } catch (Exception e){
                System.out.println("Excepción en monto, debe ser flotante: "+e.toString());
                flag=true;
            }

        }while (flag);

        System.out.print("Ingrese la razón del préstamo: ");
        concepto = leer.nextLine();
        super.setSaldo(monto*1.25f);

        guardar();
    }

    @Override
    public void leer(String rfc, String numeroGenerado){

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