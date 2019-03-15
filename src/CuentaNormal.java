import java.util.Date;

public class CuentaNormal extends Cuenta{
	
	private String numero;
	private String rfc;
	
	public CuentaNormal(String numero,  float saldo, String rfc, Date fecha){
		super(saldo,fecha);
		this.numero=numero;
		this.rfc=rfc;
	}
	
	public CuentaNormal(){
		super();
		numero="null";
	}
	
	public String getNumero(){
		return numero;
	}
	
	public void setNumero(String numero){
		this.numero = numero;
	}
	
	public float getSaldo(){
		return super.getSaldo();
	}
	
	public void setSaldo(float saldo){
		super.setSaldo(saldo);
	}
	
	public String getRfc(){
		return rfc;
	}
	
	public void setRfc(String rfc){
		this.rfc = rfc;
	}
	
	public Date getFecha(){
		return super.getFecha();
	}
	
	public void setFecha(Date fecha){
		super.setFecha(fecha);
	}

}