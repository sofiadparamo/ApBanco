import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;

class Banco {
    private int contCuentas, contCuentahabientes, contTransacciones;
    private Cuenta[] misCuentas = new Cuenta[1500];
    private Cuentahabiente[] cuentahabientes = new Cuentahabiente[1000];
    private Transaccion[] misTransacciones = new Transaccion[10000];

    Banco() throws IOException {
        Path directorio = Paths.get("data");

        if (!Files.exists(directorio)){
            System.out.println("Entra");
            new File("data").mkdirs();

            PrintWriter blank[] = {null,null,null};

            try {
                blank[0] = new PrintWriter(new FileWriter("data/cuentas.txt"));
                blank[0].close();
                blank[1] = new PrintWriter(new FileWriter("data/cuentahabientes.txt"));
                blank[1].close();
                blank[2] = new PrintWriter(new FileWriter("data/transacciones.txt"));
                blank[2].close();
            } catch (Exception e) {
                System.out.println("Error FATAL en creacion de archivos de base de datos.");
            }
        }
        contCuentahabientes = 0;
        contCuentas = 0;
        contTransacciones = 0;


        BufferedReader entrada = null;
        String linein;
        int paramcount, contsubs;
        String[] params;
        char c;

        /*

                LECTURA DE CUENTAHABIENTES

         */

        try {
            entrada = new BufferedReader(new FileReader("data/cuentahabientes.txt"));
            while ((linein = entrada.readLine()) != null) {
                //SE LEE NUEVA LINEA
                paramcount = 0;
                contsubs = 0;
                linein = linein + " ";//Agregado para evitar que se corte el ultimo parametro

                //SE CUENTAN LOS PARAMETROS
                for (int i = 0; i < linein.length(); i++) {
                    if (linein.charAt(i) == '|') {
                        paramcount++;
                    }
                }


                if (paramcount == 5) {       //CASO PARA ADULTOS
                    params = new String[6]; //Se ajusta numero de datos

                    for (int i = 0; i < params.length; i++) { //Se recore cada uno de los paramteros
                        c = ' ';
                        if (i >= 1) //Se corta en pedazos de parametro a partir de la primera división
                            linein = linein.substring(contsubs);
                        for (contsubs = 0; c != '|' && contsubs < linein.length(); contsubs++) { //Se cuentan los caracteres entre divisiones
                            c = linein.charAt(contsubs);
                        }
                        params[i] = linein.substring(0, contsubs - 1); //Se corta el primer parametro desde la izquierda
                    }
                    cuentahabientes[contCuentahabientes] = new Adulto(params[0], params[1], params[2], params[3], params[4], params[5]);
                } else if (paramcount == 6) { //CASO PARA MENORES

                    params = new String[7];

                    for (int i = 0; i < params.length; i++) {
                        c = ' ';
                        if (i >= 1)
                            linein = linein.substring(contsubs);
                        for (contsubs = 0; c != '|' && contsubs < linein.length(); contsubs++) {
                            c = linein.charAt(contsubs);
                        }
                        params[i] = linein.substring(0, contsubs - 1);
                    }
                    cuentahabientes[contCuentahabientes] = new Menor(params[0], params[1], params[2], params[3], params[4], params[5], params[6]);
                } else {
                    System.out.println("Error severo en lectura de datos, el archivo puede estar corrupto.");
                    return;
                }
                contCuentahabientes++;
            }
        } catch (FileNotFoundException e){
            PrintWriter blank = new PrintWriter(new FileWriter("data/cuentahabientes.txt"));
            blank.close();
        } catch (Exception e) {
            System.out.println(e.toString() + ": Error en lectura inicial.");
            e.printStackTrace();
        } finally {
            if (entrada != null) {
                entrada.close();
            }
        }

        /*

                LECTURA DE CUENTAS

         */
        try {
            entrada = new BufferedReader(new FileReader("data/cuentas.txt"));
            while ((linein = entrada.readLine()) != null) {
                //SE LEE NUEVA LINEA
                paramcount = 0;
                contsubs = 0;
                linein = linein + " ";//Agregado para evitar que se corte el ultimo parametro

                //SE CUENTAN LOS PARAMETROS
                for (int i = 0; i < linein.length(); i++) {
                    if (linein.charAt(i) == '|') {
                        paramcount++;
                    }
                }


                if (paramcount == 3) {       //CASO PARA CUENTA NORMAL
                    params = new String[4]; //Se ajusta numero de datos

                    for (int i = 0; i < params.length; i++) { //Se recore cada uno de los paramteros
                        c = ' ';
                        if (i >= 1) //Se corta en pedazos de parametro a partir de la primera división
                            linein = linein.substring(contsubs);
                        for (contsubs = 0; c != '|' && contsubs < linein.length(); contsubs++) { //Se cuentan los caracteres entre divisiones
                            c = linein.charAt(contsubs);
                        }
                        params[i] = linein.substring(0, contsubs - 1); //Se corta el primer parametro desde la izquierda
                    }
                    misCuentas[contCuentas] = new CuentaNormal(params[0], Float.parseFloat(params[1]), params[2], params[3]);
                } else if (paramcount == 5) { //CASO PARA CUENTA SIN TARJETA

                    params = new String[6];

                    for (int i = 0; i < params.length; i++) {
                        c = ' ';
                        if (i >= 1)
                            linein = linein.substring(contsubs);
                        for (contsubs = 0; c != '|' && contsubs < linein.length(); contsubs++) {
                            c = linein.charAt(contsubs);
                        }
                        params[i] = linein.substring(0, contsubs - 1);

                    }
                    misCuentas[contCuentas] = new CuentaSinTarjeta(params[0], Float.parseFloat(params[1]), params[2], params[3], params[4], Integer.parseInt(params[5]));
                } else if (paramcount == 4) {
                    params = new String[5];

                    for (int i = 0; i < params.length; i++) {
                        c = ' ';
                        if (i >= 1)
                            linein = linein.substring(contsubs);
                        for (contsubs = 0; c != '|' && contsubs < linein.length(); contsubs++) {
                            c = linein.charAt(contsubs);
                        }
                        params[i] = linein.substring(0, contsubs - 1);

                    }
                    misCuentas[contCuentas] = new Prestamo(params[0], params[1], Float.parseFloat(params[2]), Float.parseFloat(params[3]), params[4]);
                } else {
                    System.out.println("Error severo en lectura de datos, el archivo puede estar corrupto.");
                    return;
                }
                contCuentas++;
            }
        } catch (FileNotFoundException e){
            PrintWriter blank = new PrintWriter(new FileWriter("data/cuentas.txt"));
            blank.close();
        } catch (Exception e) {
            System.out.println(e.toString() + ": Error en lectura inicial.");
            e.printStackTrace();
        } finally {
            if (entrada != null) {
                entrada.close();
            }
        }

        /*

                LECTURA DE TRANSACCIONES

         */
        try {
            entrada = new BufferedReader(new FileReader("data/transacciones.txt"));
            while ((linein = entrada.readLine()) != null) {
                //SE LEE NUEVA LINEA
                paramcount = 0;
                contsubs = 0;
                linein = linein + " ";//Agregado para evitar que se corte el ultimo parametro

                //SE CUENTAN LOS PARAMETROS
                for (int i = 0; i < linein.length(); i++) {
                    if (linein.charAt(i) == '|') {
                        paramcount++;
                    }
                }


                if (paramcount == 5) {
                    params = new String[6]; //Se ajusta numero de datos

                    for (int i = 0; i < params.length; i++) { //Se recore cada uno de los paramteros
                        c = ' ';
                        if (i >= 1) //Se corta en pedazos de parametro a partir de la primera división
                            linein = linein.substring(contsubs);
                        for (contsubs = 0; c != '|' && contsubs < linein.length(); contsubs++) { //Se cuentan los caracteres entre divisiones
                            c = linein.charAt(contsubs);
                        }
                        params[i] = linein.substring(0, contsubs - 1); //Se corta el primer parametro desde la izquierda
                    }
                    misTransacciones[contTransacciones] = new Transaccion(params[0].charAt(0), Integer.parseInt(params[1]), params[2], params[3], params[4], Float.parseFloat(params[5]), true);
                } else {
                    System.out.println("Error severo en lectura de datos, el archivo puede estar corrupto.");
                    return;
                }
                contTransacciones++;
            }
        } catch (FileNotFoundException e){
            PrintWriter blank = new PrintWriter(new FileWriter("data/transacciones.txt"));
            blank.close();
        } catch (Exception e) {
            System.out.println(e.toString() + ": Error FATAL en lectura inicial.");
            e.printStackTrace();
        } finally {
            if (entrada != null) {
                entrada.close();
            }
        }
    }

    void listarTransacciones() {
        System.out.println("\n--------------Lista de Transacciones --------");
        for (int i = 0; i < contTransacciones; i++) {
            misTransacciones[i].imprime();
        }
    }

    void listarCuentahabientes() {
        for (int i = 0; i < contCuentahabientes; i++) {
            cuentahabientes[i].imprime();
        }
    }


    void listarCuentas() {
        for (int i = 0; i < contCuentas; i++) {
            misCuentas[i].imprime();
        }
    }

    void crearCuenta() {
        Scanner miScan = new Scanner(System.in);
        String rfc;
        StringBuilder numeroGenerado;
        boolean flag;

        System.out.print("Ingrese su RFC: ");
        rfc = miScan.nextLine();

        if (!isCuentahabiente(rfc)) {
            System.out.println("Necesita ser cuentahabiente para abrir una cuenta.");
            return;
        }

        do {
            numeroGenerado = new StringBuilder();
            for (int i = 0; i < 4; i++) {
                numeroGenerado.append(generarCuarto());
            }

            flag = obtenIndiceCuenta(numeroGenerado.toString()) >= 0;

        } while (flag);

        System.out.print("Numero generado: " + numeroGenerado);

        misCuentas[contCuentas] = new CuentaNormal();
        misCuentas[contCuentas++].leer(rfc, numeroGenerado.toString());

        misTransacciones[contTransacciones++] = new Transaccion('D',contTransacciones,misCuentas[contCuentas-1].getNumero(),"Apertura",misCuentas[contCuentas-1].getFecha(),misCuentas[contCuentas-1].getSaldo());
    ;
    }

    private String generarCuarto() {
        Random ran = new Random();
        int cuarto;
        cuarto = ran.nextInt(8889) + 1111;
        return (cuarto + " ");
    }

    void crearCuentaSinTarjeta() {
        Scanner miScan = new Scanner(System.in);
        String tel;
        System.out.print("Ingrese su numero de teléfono: ");
        tel = miScan.nextLine();
        if (obtenIndiceCuenta(tel) >= 0) {
            System.out.println("Ya existe una cuenta con este número de telefono.");
            return;
        }

        misCuentas[contCuentas] = new CuentaSinTarjeta();
        misCuentas[contCuentas++].leer(tel);

        misTransacciones[contTransacciones++] = new Transaccion('D',contTransacciones,misCuentas[contCuentas-1].getNumero(),"Apertura",misCuentas[contCuentas-1].getFecha(),misCuentas[contCuentas-1].getSaldo());
    }

    void registrarAdulto() {
        Scanner miScan = new Scanner(System.in);
        String rfc;
        System.out.print("Ingrese su RFC: ");
        rfc = miScan.nextLine();

        if (isCuentahabiente(rfc)) {
            System.out.println("¡Ya es cuentahabiente!");
            return;
        }

        cuentahabientes[contCuentahabientes] = new Adulto();
        cuentahabientes[contCuentahabientes++].leer(rfc);
    }

    void registrarMenor() {
        Scanner miScan = new Scanner(System.in);
        String rfc, rfctutor;
        System.out.print("Ingrese su RFC: ");
        rfc = miScan.nextLine();

        if (isCuentahabiente(rfc)) {
            System.out.println("¡Ya es cuentahabiente!");
            return;
        }

        System.out.print("Ingrese el RFC del tutor: ");
        rfctutor = miScan.nextLine();

        if (!isCuentahabiente(rfctutor)) {
            System.out.println("Necesita ser cuentahabiente para poder registrar un menor.");
            return;
        }

        if (!isAdulto(rfctutor)) {
            System.out.println("Necesita ser adulto para registrar un menor: ");
            return;
        }

        cuentahabientes[contCuentahabientes] = new Menor();
        cuentahabientes[contCuentahabientes++].leer(rfc, rfctutor);
    }

    void crearPrestamo() {
        Scanner miScan = new Scanner(System.in);
        String rfc;
        int cont = 0;
        System.out.print("Ingresa tu RFC: ");
        rfc = miScan.nextLine();

        if (!isCuentahabiente(rfc)) {
            System.out.println("Neciestas ser cuentahabiente antes de pedir un préstamo");
            return;
        }

        for (int i = 0; i < contCuentas; i++) {
            if (misCuentas[i].getNumero().equals("null") && misCuentas[i].getRfc().equals(rfc) && misCuentas[i].getSaldo() > 0) {
                cont++;
            }
        }
        if (cont > 0) {
            System.out.println("Ya tienes un préstamo activo, no puedes solicitar uno nuevo. Primero liquida la cuenta.");
            return;
        }

        misCuentas[contCuentas] = new Prestamo();
        misCuentas[contCuentas++].leer(rfc);
    }

    private int obtenIndiceCuenta(String cuenta) {
        for (int i = 0; i < contCuentas; i++)
            if (cuenta.equals(misCuentas[i].getNumero()))
                return i;
        return -1;
    }

    private boolean isCuentahabiente(String rfc) {
        for (int i = 0; i < contCuentahabientes; i++) {
            if (cuentahabientes[i].getRfc().equals(rfc)) {
                return true;
            }
        }
        return false;
    }

    private boolean isAdulto(String rfc) {
        for (int i = 0; i < contCuentahabientes; i++) {
            if (cuentahabientes[i].getRfc().equals(rfc) && cuentahabientes[i].getClass().equals(Adulto.class)) {
                return true;
            }
        }
        return false;
    }

    void pagarPrestamo() {
        Scanner miScan = new Scanner(System.in);
        String rfc, fecha;
        int indice = 0, cont = 0;
        float deposito = 0;
        boolean flag;
        System.out.println("\n---------- Nuevo Pago de Préstamo ----------");

        System.out.print("Ingresa tu RFC: ");
        rfc = miScan.nextLine();
        for (int i = 0; i < contCuentas; i++) {
            if (misCuentas[i].getNumero().equals("null") && misCuentas[i].getRfc().equals(rfc) && misCuentas[i].getSaldo() > 0) {
                indice = i;
                cont++;
            }
        }
        if (cont < 1) {
            System.out.println("No se encontró ningún préstamo para ese RFC.");
            return;
        }
        System.out.println("Saldo pendiende: " + misCuentas[indice].getSaldo());
        do {
            Scanner leer = new Scanner(System.in);

            System.out.print("Ingresa la cantidad a pagar: ");
            try {
                deposito = Float.parseFloat(leer.nextLine());
                flag = false;
            } catch (Exception e) {
                System.out.println("Excepción en pago, debe ser float: " + e.toString());
                flag = true;
            }

        } while (flag);

        if (deposito > misCuentas[indice].getSaldo()) {
            System.out.println("No puede depositar más de la cantidad que debe del préstamo.");
            return;
        }

        System.out.print("Ingrese la fecha de hoy: ");
        fecha = miScan.nextLine();

        misCuentas[indice].setSaldo(misCuentas[indice].getSaldo() - deposito);

        if (misCuentas[indice].getSaldo() == 0) {
            System.out.println("Felicidades, ¡ya ha pagado el préstamo!");
        } else {
            System.out.println("Quedan $" + misCuentas[indice].getSaldo() + " por pagar.");
        }

        misTransacciones[contTransacciones++] = new Transaccion('P', contTransacciones, rfc, "Pago de préstamo", fecha, deposito);

        guardarCuentas();
    }

    void depositar() {
        System.out.println("\n--------------Nuevo deposito-------");
        String cuenta;
        float monto = 0;
        int indice;
        boolean flag;
        String referencia, fecha;
        Scanner miScan = new Scanner(System.in);
        System.out.print("A que cuenta vas a depositar: ");
        cuenta = miScan.nextLine();

        indice = obtenIndiceCuenta(cuenta);//validar si la cuenta existe
        if (indice < 0) {
            System.out.println("Error cuenta incorrecta " + cuenta);
            return;
        }

        System.out.print("Introduce el concepto: ");
        referencia = miScan.nextLine();
        do {
            Scanner leer = new Scanner(System.in);
            System.out.print("Introduce el monto a depositar: ");
            try {
                monto = Math.abs(leer.nextFloat());
                flag = false;
            } catch (Exception e) {
                System.out.println("Excepción en monto, debe ser flotante: " + e.toString());
                flag = true;
            }
        } while (flag);

        System.out.print("Ingrese la fecha de hoy: ");
        fecha = miScan.nextLine();

        misTransacciones[contTransacciones++] = new Transaccion('D', contTransacciones, cuenta, referencia, fecha, monto);
        misCuentas[indice].setSaldo(misCuentas[indice].getSaldo() + monto);

        guardarCuentas();


    }

    void retirar() {
        System.out.println("\n--------------Nuevo retiro-------");
        String cuenta;
        float monto = 0;
        String referencia, fecha;
        boolean flag;
        Scanner miScan = new Scanner(System.in);
        System.out.print("De que cuenta vas a retirar: ");
        cuenta = miScan.nextLine();

        int indice = obtenIndiceCuenta(cuenta);
        if (indice < 0) {
            System.out.println("Error cuenta incorrecta " + cuenta);
            return;
        }

        System.out.print("Introduce el concepto: ");
        referencia = miScan.nextLine();
        do {
            Scanner leer = new Scanner(System.in);
            System.out.print("Introduce el monto a retirar: ");
            try {
                monto = Math.abs(leer.nextFloat());
                flag = false;
            } catch (Exception e) {
                System.out.println("Excepción en monto, debe ser flotante: " + e.toString());
                flag = true;
            }
        } while (flag);

        System.out.print("Ingrese la fecha de hoy: ");

        fecha = miScan.nextLine();


        if (monto > misCuentas[indice].getSaldo()) {
            System.out.println("Error, no hay suficiente saldo");
            return;
        }

        misTransacciones[contTransacciones++] = new Transaccion('R', contTransacciones, cuenta, referencia, fecha, -1 * monto);
        misCuentas[indice].setSaldo(misCuentas[indice].getSaldo() - monto);

        guardarCuentas();
    }

    private void guardarCuentas(){
        PrintWriter blank = null;

        try {
            blank = new PrintWriter(new FileWriter("data/cuentas.txt"));
        } catch (Exception e) {
            System.out.println("Error FATAL en respaldo de base de datos.");
        } finally {
            if (blank != null) {
                blank.close();
            }
        }

        for (int i = 0; i < contCuentas; i++) {
            misCuentas[i].guardar();
        }
    }
}