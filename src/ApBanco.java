import java.util.Scanner;

public class ApBanco{
	
	public static void main(String[] args){
		Scanner leer = new Scanner(System.in);
		
		Banco miBanco = new Banco();
		
		int op;
		
		do{
			mostrarMenu();
			op= leer.nextInt();
			switch(op){
				case 1:
					miBanco.crearCuenta();
					break;
				case 2:
					if(miBanco.registrarCuentahabiente()){
						System.out.println("Éxito");
					} else {
						System.out.println("Este RFC ya existe");
					}
					break;
				case 3:
					miBanco.depositar();
					break;
				case 4:
					miBanco.retirar();
					break;
				case 5:
					//miBanco.transferencia();
					break;
				case 6:
					//miBanco.nuevoPrestamo();
					break;
				case 7:
					//miBanco.pagarPrestamo();
					break;
				case 8:
					//miBanco.estadoDeCuenta();
					break;
				case 9:
					miBanco.mostrarCuentas();
					break;
				case 10:
					miBanco.mostrarCuentahabientes();
					break;
				case 11:
					miBanco.mostrarTransacciones();
					break;
				case 12:
					miBanco.mostrarTransacciones(true);
					break;
				case 13:
					miBanco.crearCuenta(true);
					break;
				default:
					System.out.println("Por favor ingrese una opción válida");
			}
		}while(op!=25565);
		
		System.out.println("Apagando...");
	}
	
	private static void mostrarMenu(){
		System.out.print(" 1) Nueva cuenta\n 2) Nuevo Cuentahabiente\n 3) Depósito a cuenta\n 4) Retiro\n 5) Transferencia\n 6) Nuevo prestamo\n 7) Pago\n 8) Estado de cuenta\n 9) Mostrar cuentas\n10) Mostrar cuentahabientes\n11) Mostrar transacciones\n12) Mostrar transacciones por cuenta\n13) Crear cuenta para menor de edad\nOpción: ");	}
}