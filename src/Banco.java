import java.util.Scanner;
import java.util.Random;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Banco{
	
	private Cuenta cuentasBancarias[] = new Cuenta[10000];
	private Cuentahabiente clientes[] = new Cuentahabiente[10000];
	private Transaccion operaciones[] = new Transaccion[100000000];
	private Menor menores[] = new Menor[1000];
	private int transaccionActual=0;
	
	public Banco(){
		Date today = new Date();
		
		cuentasBancarias[0] = new Cuenta("4152 3134 5661 5280",20.0f,"MAPA000811H45",today);
		cuentasBancarias[1] = new Cuenta("4152 3465 3546 6546",150302.00f,"MAPE720728M30",today);
		cuentasBancarias[2] = new Cuenta("4152 4578 1325 2531",564654.00f,"POLA860926K28",today);
		cuentasBancarias[3] = new Cuenta("4152 9846 6546 2134",325465.25f,"TULA000204H85",today);
		cuentasBancarias[4] = new Cuenta("4152 3215 9875 4735",6546.34f,"PETE650117M75",today);
		cuentasBancarias[5] = new Cuenta("4152 6544 6545 7641",9878.95f,"CACO971227M86",today);
		cuentasBancarias[6] = new Cuenta("4152 3465 1325 4675",1003.45f,"YOTU871123L98",today);
		cuentasBancarias[7] = new Cuenta("4152 8975 1325 3216",25565.17f,"RETP610721H12",today);
		cuentasBancarias[8] = new Cuenta("4152 3465 3456 6565",654.31f,"RATO760816L35",today);
		cuentasBancarias[9] = new Cuenta("4152 6546 6485 6498",3.0f,"PERA910408H73",today);
		
		
		clientes[0] = new Cuentahabiente("Encarnación Almonte Mendoza","Calle Estivalis No. 452","POLA860926K28",58492800000L,"(252) 677-6933");
		clientes[1] = new Cuentahabiente("Solana Gastelum Fialho","Real del Egidos No. 959","TULA000204H85",460684800000L,"(343) 344-1091");
		clientes[2] = new Cuentahabiente("Romelio Albes Guija","Boulevard De la Encina No. 579","YOTU871123L98",-276825600000L,"(252) 643-6123");
		clientes[3] = new Cuentahabiente("Dionisio Doz Portellano","Cerrada Humanez No. 878","PETE650117M75",-97977600000L,"(333) 911-0278");
		clientes[4] = new Cuentahabiente("Baldovino N. Arambul Munt","Calle Farriol No. 879","RETP610721H12",10800000000L,"(636) 111-2074");
		clientes[5] = new Cuentahabiente("Adolfo E. Urruchua Perea","Avenida Beti No. 590","CACO971227M86",-38966400000L,"(141) 322-1613");
		clientes[6] = new Cuentahabiente("Axel Iván Magallón Páramo","Manuel Ponce No. 236","MAPA000811H45",965952000000L,"(443) 354-0516");
		clientes[7] = new Cuentahabiente("Everardo Magallón Padilla","Ruben C. Navarro No. 197","MAPE720728M30",83808000000L,"(443) 132-0007");
		clientes[8] = new Cuentahabiente("Leonelo K. Noheda Juanhuix","Boulevard Victor No. 681","RATO760816L35",6134400000L,"(757) 611-6795");
		clientes[9] = new Cuentahabiente("Guadalupe J. Bustos Rebordosa","Calle Urkiaga No. 645","PERA910408H73",58492800000L,"(040) 299-9474");
		
		for(int i= 10; i<cuentasBancarias.length ; i++){
			cuentasBancarias[i] = new Cuenta();
		}
		
		for(int i= 10; i<clientes.length ; i++){
			clientes[i] = new Cuentahabiente();
		}
		
		for(int i = 0; i<menores.length; i++){
			menores[i] = new Menor();
		}
	}
	
	public void tests(){
		
	}
	
	public void crearCuenta(){
		Random ran = new Random();
		Scanner leer = new Scanner(System.in);
		
		boolean empty=false;
		int indice=0,cuarto;
		String numeroGenerado="",cuartoGenerado="";
		
		while(!empty){
			
			if(cuentasBancarias[indice].getNumero().equals("null")){
				empty=true;
				indice--;
			}
			indice++;
		}
		System.out.println("Creando cuenta: ");
		System.out.print("Ingrese su rfc: ");
		cuentasBancarias[indice].setRfc(leer.nextLine());
		System.out.print("Ingrese el saldo de apertura: ");
		cuentasBancarias[indice].setSaldo(Float.parseFloat(leer.nextLine()));
		
		do{
			System.out.println("Generando número de cuenta...");
			for(int i =0; i < 4; i++){
				cuarto=ran.nextInt(8888)+1111;
				cuartoGenerado = Integer.toString(cuarto);
				if(i!=3){
					cuartoGenerado+=" ";
				}
				numeroGenerado += cuartoGenerado;
			}
			System.out.println("Comprobando número de cuenta...");
		}while(!comprobarNumero(numeroGenerado));
		
		System.out.println("Se generó: "+numeroGenerado);
		cuentasBancarias[indice].setNumero(numeroGenerado);
		System.out.println("Asignando fecha");
		Date today = new Date();
		System.out.println("Se ha creado en " + today);
		cuentasBancarias[indice].setFecha(today);
		
	}
	
	public void crearCuenta(boolean flag){
		Random ran = new Random();
		Scanner leer = new Scanner(System.in);
		
		boolean empty=!flag,emptymajor=false;
		int indice=0,indicemajor=0,cuarto;
		String numeroGenerado="",cuartoGenerado="",rfc;
		
		while(!empty){
			
			if(menores[indice].getNumero().equals("null")){
				empty=true;
				indice--;
			}
			indice++;
		}
		while(!emptymajor){
			
			if(cuentasBancarias[indicemajor].getNumero().equals("null")){
				emptymajor=true;
				indicemajor--;
			}
			indicemajor++;
		}
		
		System.out.println("Creando cuenta: ");
		System.out.print("Ingrese el rfc del tutor: ");
		
		rfc = leer.nextLine();
		
		if(!comprobarRfc(rfc,indicemajor)){
			menores[indice].setTutor(rfc);
		} else {
			System.out.println("El tutor debe ser derechohabiente antes de declarar un menor.");
			return;
		}
		
		
		System.out.print("Ingrese curp del menor: ");
		menores[indice].setRfc(leer.nextLine());
		System.out.print("Ingrese el nombre del menor: ");
		menores[indice].setNombre(leer.nextLine());
		System.out.print("Ingrese el saldo de apertura: ");
		menores[indice].setSaldo(Float.parseFloat(leer.nextLine()));
		
		do{
			System.out.println("Generando número de cuenta...");
			for(int i =0; i < 3; i++){
				cuarto=ran.nextInt(8888)+1111;
				cuartoGenerado = Integer.toString(cuarto);
				if(i!=3){
					cuartoGenerado+=" ";
				}
				numeroGenerado += cuartoGenerado;
			}
			System.out.println("Comprobando número de cuenta...");
		}while(!comprobarNumero(numeroGenerado,false));
		
		System.out.println("Se generó: "+numeroGenerado);
		menores[indice].setNumero(numeroGenerado);
		System.out.println("Asignando fecha");
		Date today = new Date();
		System.out.println("Se ha creado en " + today);
		menores[indice].setFecha(today);
		
	}
	
	private boolean comprobarNumero(String numero){
		int indice=0;
		boolean empty=false;
		while(!empty){
			
			if(numero.equals(cuentasBancarias[indice].getNumero()))
				return false;
			
			if(cuentasBancarias[indice].getNumero().equals("null"))	
				empty=true;
			
			indice++;
		}
		return true;
	}
	
	private boolean comprobarNumero(String numero, boolean empty){
		int indice=0;
		
		while(!empty){
			
			if(numero.equals(menores[indice].getNumero()))
				return false;
			
			if(menores[indice].getNumero().equals("null"))	
				empty=true;
			
			indice++;
		}
		return true;
	}
	
	public void mostrarCuentas(){
		int indice=0;
		boolean empty=false;
		
		while(!empty){
			
			if(!cuentasBancarias[indice].getNumero().equals("null"))
				System.out.println("Numero: "+cuentasBancarias[indice].getNumero()+"\tSaldo: "+cuentasBancarias[indice].getSaldo()+"\t\tRFC: "+cuentasBancarias[indice].getRfc()+"\t Fecha: "+cuentasBancarias[indice].getFecha());
			
			if(cuentasBancarias[indice].getNumero().equals("null")){
				
				empty=true;
			}
			
			indice++;
		}
	}
	
	public void mostrarTransacciones(){
		
		for(int i = 0; i < transaccionActual; i++){
			System.out.println("Tipo: "+operaciones[i].getTipo()+"\tFolio: "+operaciones[i].getFolio()+"\tCuenta: "+operaciones[i].getCuenta()+"\tFecha: "+operaciones[i].getFecha()+"\tMonto: "+operaciones[i].getMonto()+"\tReferencia: "+operaciones[i].getReferencia());
		}
	}
	
	public void mostrarTransacciones(boolean empty){
		Scanner leer = new Scanner(System.in);
		int cont=0;
		
		System.out.print("Ingrese el número de cuenta: ");
		String cuenta = leer.nextLine();
		
		
		for(int i = 0; i < transaccionActual; i++){
			if(operaciones[i].getCuenta().equals(cuenta)){
				System.out.println("Tipo: "+operaciones[i].getTipo()+"\tFolio: "+operaciones[i].getFolio()+"\tFecha: "+operaciones[i].getFecha()+"\tMonto: "+operaciones[i].getMonto()+"\tReferencia: "+operaciones[i].getReferencia());
				cont++;
			}
		}
		if(cont==0)
			System.out.println("No hay transacciones registradas para esta cuenta");
	}
	
	public void mostrarCuentahabientes(){
		int indice=0;
		boolean empty=false;
		
		while(!empty){
			
			if(!clientes[indice].getRfc().equals("null"))
				System.out.println("RFC: "+clientes[indice].getRfc()+"\tNombre: "+clientes[indice].getNombre()+"\t\tDomicilio: "+clientes[indice].getDomicilio()+"\tFecha de nacimiento: "+clientes[indice].getFecha_nacimiento()+"\tTelefono: "+clientes[indice].getTelefono());
			
			if(clientes[indice].getRfc().equals("null")){
				
				empty=true;
			}
			
			indice++;
		}
	}
	
	public void depositar(){
		
		
		Scanner leer = new Scanner(System.in);
		String cuenta, referencia;
		float cantidad;
		boolean empty=false;
		int indice=0;
		
		System.out.print("Ingrese el número de cuenta: ");
		cuenta = leer.nextLine();
		System.out.print("Ingrese la cantidad que desea depositar: ");
		cantidad = Float.parseFloat(leer.nextLine());
		System.out.print("Ingrese el motivo del deposito: ");
		referencia = leer.nextLine();
		
		while(!empty){
			
			if(cuentasBancarias[indice].getNumero().equals(cuenta)){
				System.out.println("Se ha encontrado la cuenta.");
				System.out.println("Saldo anterior: "+cuentasBancarias[indice].getSaldo());
				System.out.println("Cantidad depositada: "+cantidad);
				cuentasBancarias[indice].setSaldo(cuentasBancarias[indice].getSaldo()+cantidad);
				System.out.println("Saldo actual: "+cuentasBancarias[indice].getSaldo());
				empty=true;
				
				Date hoy = new Date();
				
				operaciones[transaccionActual] = new Transaccion('d',transaccionActual+1,cuenta,referencia,hoy,cantidad);
				transaccionActual++;
				
				
			}
				
			
			if(clientes[indice].getRfc().equals("null")){
				System.out.println("No se encontró ninguna cuenta.");
				empty=true;
			}
			
			indice++;
		}
		
		
	}
	
	public void retirar(){
		Scanner leer = new Scanner(System.in);
		String cuenta,referencia;
		float cantidad;
		boolean empty=false,suficiente=true;
		int indice=0;
		
		System.out.print("Ingrese el número de cuenta: ");
		cuenta = leer.nextLine();
		System.out.print("Ingrese la cantidad que desea retirar: ");
		cantidad = Float.parseFloat(leer.nextLine());
		System.out.print("Ingrese el motivo del retiro: ");
		referencia = leer.nextLine();
		
		
		
		while(!empty && suficiente){
			
			if(cuentasBancarias[indice].getNumero().equals(cuenta)){
				System.out.println("Se ha encontrado la cuenta.");
				if(cuentasBancarias[indice].getSaldo()>=cantidad){
					System.out.println("Saldo anterior: "+cuentasBancarias[indice].getSaldo());
					System.out.println("Cantidad retirada: "+cantidad);
					cuentasBancarias[indice].setSaldo(cuentasBancarias[indice].getSaldo()-cantidad);
					System.out.println("Saldo actual: "+cuentasBancarias[indice].getSaldo());
					empty=true;
					
					Date hoy = new Date();
					
					operaciones[transaccionActual] = new Transaccion('r',transaccionActual+1,cuenta,referencia,hoy,-1*cantidad);
					transaccionActual++;
				} else {
					System.out.println("Error, saldo insuficiete.");
					suficiente=false;
				}
				
			}
				
			
			if(clientes[indice].getRfc().equals("null")){
				System.out.println("No se encontró ninguna cuenta.");
				empty=true;
			}
			
			indice++;
		}
	
	
	
	}
	
	public boolean registrarCuentahabiente(){
		Scanner leer = new Scanner(System.in);
		
		boolean empty=false;
		String rfc;
		int indice=0,year,month,day;
		
		while(!empty){
			
			if(clientes[indice].getRfc().equals("null")){
				empty=true;
				indice--;
			}
			indice++;
		}
		System.out.println("Registrando cuentahabiente: ");
		System.out.print("Ingrese su RFC: ");
		
		rfc=leer.nextLine();
		
		if(!comprobarRfc(rfc,indice)){
			return false;
		}
		clientes[indice].setRfc(rfc);
		
		System.out.print("Ingrese su nombre: ");
		clientes[indice].setNombre(leer.nextLine());
		System.out.print("Ingrese su dirección: ");
		clientes[indice].setDomicilio(leer.nextLine());
		System.out.print("Ingrese su telefono: ");
		clientes[indice].setTelefono(leer.nextLine());
		
		System.out.println("Ingrese su año de nacimiento");
		year = leer.nextInt();
		System.out.println("Ingrese su mes de nacimiento");
		month = leer.nextInt();
		System.out.println("Ingrese su día de nacimiento");
		day = leer.nextInt();
		
		Calendar cumpleFecha = new GregorianCalendar(year,month,day);
		
		Date cumple = cumpleFecha.getTime();
		
		clientes[indice].setFecha_nacimiento(cumple);
		
		return true;
	}
	
	public boolean comprobarRfc(String rfc,int indice){
		for(int i = 0; i<indice;i++){
			if(rfc.equals(clientes[i].getRfc())){
				return false;
			}
		}
		return true;
	}
	
}