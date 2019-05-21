import java.io.*;
import java.util.ArrayList;

public class Transaccion {
    private char tipo;
    private int folio;
    private String cuenta;
    private String referencia;
    private String fecha;
    private float monto;

    public Transaccion(char tipo, int folio, String cuenta, String referencia,
                       String fecha, float monto) {
        this.tipo = tipo;
        this.folio = folio;
        this.cuenta = cuenta;
        this.referencia = referencia;
        this.fecha = fecha;
        this.monto = monto;

        guardar();
    }

    public Transaccion(char tipo, int folio, String cuenta, String referencia,
                       String fecha, float monto,boolean flag) {
        this.tipo = tipo;
        this.folio = folio;
        this.cuenta = cuenta;
        this.referencia = referencia;
        this.fecha = fecha;
        this.monto = monto;

    }

    public void imprime() {
        if (tipo == 'D')
            System.out.print("Deposito\t\t");
        else
            System.out.print("Retiro\t\t\t");
        System.out.println("Cuenta: " + cuenta + "\t\tMonto: " + monto);
        System.out.println();
    }

    public void guardar() {
        String line;
        line = tipo + "|" + folio + "|" + cuenta + "|" + referencia + "|" + fecha + "|" + monto;
        PrintWriter salida = null;
        BufferedReader entrada;
        ArrayList<String> input = new ArrayList<>();
        String linein;

        try {
            entrada = new BufferedReader(new FileReader("data/transacciones.txt"));
            while ((linein = entrada.readLine()) != null) {
                input.add(linein);
            }

            entrada.close();

            salida = new PrintWriter(new FileWriter("data/transacciones.txt"));

            for (String elemento : input) {
                salida.write(elemento + "\n");
            }
            salida.write(line + "\n");

        } catch (
                IOException e) {
            System.out.println("Error en guardado de cuenta normal");
        } finally {
            if (salida != null) {
                salida.close();
            }
        }
    }


    public char getTipo() {
        return tipo;
    }

    public int getFolio() {
        return folio;
    }

    public String getCuenta() {
        return cuenta;
    }

    public String getReferencia() {
        return referencia;
    }

    public String getFecha() {
        return fecha;
    }

    public float getMonto() {
        return monto;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }
}







