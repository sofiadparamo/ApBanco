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
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				case 6:
					break;
				case 7:
					break;
				case 8:
					break;
				case 9:
					miBanco.mostrarCuentas();
					break;
				default:
			}
		}while(op!=25565);
		
		System.out.println("Apagando...");
	}
	
	private static void mostrarMenu(){
		System.out.print("1) Nueva cuenta\t\t2) Nuevo Cuentahabiente\t3) Depósito a cuenta\t4) Retiro\n5) Transferencia\t6) Nuevo prestamo\t7) Pago\t\t\t8) Estado de cuenta\t9)Mostrar cuentas\nOpción: ");
	}
}