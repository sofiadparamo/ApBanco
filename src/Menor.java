import java.util.Date;

public class Menor extends Cuenta{
	private String nombre;
	private String tutor;
	
	public Menor(String numero, float saldo, String rfc, Date fecha, String tutor, String nombre){
		super(numero, saldo, rfc, fecha);
		this.nombre = nombre;
		this.tutor = tutor;
	}
	
	public Menor(){
		super();
	}
	
	public void setNombre(String nombre){
		this.nombre= nombre;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public void setTutor(String tutor){
		this.tutor = tutor;
	}
	
	public String getTutor(){
		return tutor;
	}
}