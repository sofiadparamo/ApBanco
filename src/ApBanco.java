import java.io.IOException;
import java.util.Scanner;

public class ApBanco {
    public static void main(String[] args) throws IOException {
        int op;
        Banco miBanco = new Banco();

        do {
            System.out.print(
                    " 1) Nuevo Adulto                  2) Nueva Cuenta	\n" +
                    " 3) Deposito                      4) Retiro \n" +
                    " 5) Listar Cuentahabientes        6) Listar Cuentas\n" +
                    " 7) Nuevo Menor                   8) Transacciones\n"+
                    " 9) Nueva cuenta sin tarjeta     10) Nuevo Prestamo\n"+
                    "11) Pagar préstamo                                 \t:");

            try {
                Scanner captura = new Scanner(System.in);
                op = captura.nextInt();
            } catch (Exception e){
                op=0;
                System.out.println("Excepción en valor ingresado: "+e.toString());
            }

            if (op == 1) miBanco.registrarAdulto();
            if (op == 2) miBanco.crearCuenta();
            if (op == 3) miBanco.depositar();
            if (op == 4) miBanco.retirar();
            if (op == 5) miBanco.listarCuentahabientes();
            if (op == 6) miBanco.listarCuentas();
            if (op == 7) miBanco.registrarMenor();
            if (op == 8) miBanco.listarTransacciones();
            if(op == 9) miBanco.crearCuentaSinTarjeta();
            if(op == 10) miBanco.crearPrestamo();
            if (op==11) miBanco.pagarPrestamo();
        } while (op!=25565);
    }

}