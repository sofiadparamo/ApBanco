import java.util.Scanner;

public class ApBanco {
    public static void main(String[] args) {
        Scanner captura = new Scanner(System.in);
        int op;

        Banco miBanco = new Banco();
        do {
            System.out.print(
                    "1) Nuevo Adulto                  2) Nueva Cuenta	\n" +
                    "3) Deposito                      4) Retiro \n" +
                    "5) Listar Cuentahabientes        6) Listar Cuentas\n" +
                    "7) Nuevo Menor                   8) Transacciones\n"+
                    "9) Nueva cuenta sin tarjeta     10) Nuevo Prestamo\t\t:");
            op = captura.nextInt();

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
        } while (op!=25565);
    }
}