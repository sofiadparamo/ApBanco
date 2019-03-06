import java.util.Scanner;
import java.util.Random;
import java.util.Date;

public class Banco{
	
	private Cuenta cuentasBancarias[] = new Cuenta[1000];
	
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
		
		for(int i= 10; i<cuentasBancarias.length ; i++){
			cuentasBancarias[i] = new Cuenta();
		}
		
	}
	
	public void crearCuenta(){
		Random ran = new Random();
		Scanner leer = new Scanner(System.in);
		
		boolean empty=false;
		int indice=0,cuarto;
		String numeroGenerado="",cuartoGenerado="";
		
		while(!empty){
			indice++;
			if(cuentasBancarias[indice].getNumero().equals("null")){
				empty=true;
			}
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
	
	private boolean comprobarNumero(String numero){
		int indice=0;
		boolean empty=false;
		while(!empty){
			indice++;
			
			if(numero.equals(cuentasBancarias[indice].getNumero()))
				return false;
			
			if(cuentasBancarias[indice].getNumero().equals("null"))	
				empty=true;
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
	
	public boolean depositar(String cuenta,float monto){
	
	return false;
	}
	
	public boolean retirar(String cuenta,float monto){
	
	return false;
	}
	
	public void registrarCuentahabiente(){
	
	}
	
}