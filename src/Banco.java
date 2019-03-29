import java.util.Scanner;

class Banco {
    private int contCuentas, contCuentahabientes, contPrestamo, contTransacciones;
    private Cuenta[] misCuentas = new Cuenta[1500];
    private Cuentahabiente[] cuantahabientes = new Cuentahabiente[1000];
    private Transaccion[] misTransacciones = new Transaccion[10000];

    Banco() {
        misCuentas[0] = new CuentaNormal("2019-01-01", 1000, "1234567891", "AUCL990101");
        misCuentas[1] = new CuentaNormal("2019-01-01", 500, "2356452751", "PEJZ990101");
        misCuentas[2] = new CuentaNormal("2019-01-01", 500, "9874521585", "POCE990621");
        misCuentas[3] = new CuentaNormal("2019-01-01", 1000, "7847852936", "AUCL990101");
        misCuentas[4] = new CuentaSinTarjeta("2018-01-01", 5000, "2018-01-08", "44347565678",
                "1234-1234-1234", 4321);
        cuantahabientes[0] = new Adulto("Aguilar Calderon Luis Fernando",
                "Av Madero 1200 col. Centro", "AUCL990101", "1999-01-01",
                "4431234365", "Empleado de la SEP");
        cuantahabientes[1] = new Adulto("Granados Dominguez Liliana",
                "Calz.Ventura Puente 100 col. Ventura Puente", "GADL990101",
                "1999-01-01", "4434020202", "Educadora");
        cuantahabientes[2] = new Adulto("Perez Jiménez Zoe Benjamin",
                "Av. Morelos #345 Col. Felix Ireta", "PEJZ990101",
                "1999-01-01", "4434030303", "Conductor UBER");
        cuantahabientes[3] = new Menor("Perez Granados Benji",
                "Av. Morelos #345 Col. Felix Ireta", "PEGB060101",
                "2006-01-01",
                "4425542533", "Perez Jiménez Zoe Benjamin",
                "Granados Dominguez Liliana");
        cuantahabientes[4] = new Menor("Avalos Rojas Aleli",
                "Lago de Chapala 420", "AVRA110101",
                "2011-01-01",
                "4431234365", "Avalos Castro Agustin",
                "Rojas Diaz Elisa");

        contCuentas = 5;
        contCuentahabientes = 5;
        contPrestamo = 1 ;
        contTransacciones = 0;
    }

    void listarTransacciones() {
        System.out.println("\n--------------Lista de Transacciones --------");
        for (int i = 0; i < contTransacciones; i++) {
            if (misTransacciones[i].getTipo() == 'D')
                System.out.print("Deposito\t\t");
            else
                System.out.print("Retiro\t\t");
            System.out.print("Cuenta: " +
                    misTransacciones[i].getCuenta());
            System.out.println("\t\tMonto: " +
                    misTransacciones[i].getMonto());
        }
        System.out.println();
    }

    void listarCuentahabientes() {
        for (int i = 0; i < contCuentahabientes; i++) {
            cuantahabientes[i].imprime();
        }
    }


    void listarCuentas() {
        for (int i = 0; i < contCuentas; i++) {
            misCuentas[i].imprime();
        }
    }

    void crearCuenta(){
        misCuentas[contCuentas] = new CuentaNormal();
        misCuentas[contCuentas++].leer();
    }

    void crearCuentaSinTarjeta(){
        misCuentas[contCuentas] = new CuentaSinTarjeta();
        misCuentas[contCuentas++].leer();
    }

    void registrarAdulto() {
        cuantahabientes[contCuentahabientes] = new Adulto();
        cuantahabientes[contCuentahabientes++].leer();
    }

    void registrarMenor() {
        cuantahabientes[contCuentahabientes] = new Menor();
        cuantahabientes[contCuentahabientes++].leer();
    }

    void crearPrestamo(){
        misCuentas[contCuentas] = new Prestamo();
        misCuentas[contCuentas++].leer();
    }

    private int obtenIndiceCuenta(String cuenta) {
        //vamos a buscar la cuenta y regresar el indice correcto
        //si falla regresaremos -1
        for (int i = 0; i < contCuentas; i++)
            if (cuenta.equals(misCuentas[i].getNumero()))
                return i;
        return -1;
    }

    void depositar() {
        System.out.println("\n--------------Nuevo deposito-------");
        String cuenta;
        float monto;
        String referencia;
        Scanner miScan = new Scanner(System.in);
        System.out.print("A que cuenta vas a depositar: ");
        cuenta = miScan.nextLine();
        System.out.print("Introduce el concepto: ");
        referencia = miScan.nextLine();
        System.out.print("Introduce el monto a depositar: ");
        monto = Math.abs(miScan.nextFloat());

        int indice = obtenIndiceCuenta(cuenta);//validar si la cuenta existe
        if (indice < 0) {
            System.out.println("Error cuenta incorrecta " + cuenta);
            return;
        }
        misTransacciones[contTransacciones++] = new Transaccion('D',
                contTransacciones + 1, cuenta, referencia,
                "2019-01-01", monto);
        misCuentas[indice].setSaldo(misCuentas[indice].getSaldo() + monto);
    }

    void retirar() {
        System.out.println("\n--------------Nuevo retiro-------");
        String cuenta;
        float monto;
        String referencia;
        Scanner miScan = new Scanner(System.in);
        System.out.print("De que cuenta vas a retirar: ");
        cuenta = miScan.nextLine();
        System.out.print("Introduce el concepto: ");
        referencia = miScan.nextLine();
        System.out.print("Introduce el monto a retirar: ");
        monto = Math.abs(miScan.nextFloat());
        int indice = obtenIndiceCuenta(cuenta);//validar si la cuenta existe
        if (indice < 0) {
            System.out.println("Error cuenta incorrecta " + cuenta);
            return;
        }
        if(monto>misCuentas[indice].getSaldo()){
            System.out.println("Error, no hay suficiente saldo");
            return;
        }

        misTransacciones[contTransacciones++] = new Transaccion('R',
                contTransacciones + 1, cuenta, referencia,
                "2019-01-01", -1*monto);
        misCuentas[indice].setSaldo(misCuentas[indice].getSaldo() - monto);
    }
}




