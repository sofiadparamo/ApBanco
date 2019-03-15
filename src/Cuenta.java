import java.util.Date;


public class Cuenta{
	private String numero;
	private float saldo;
	private String rfc;
	private Date fecha;
	
	public Cuenta(String numero, float saldo, String rfc, Date fecha){
		this.numero=numero;
		this.saldo=saldo;
		this.rfc=rfc;
		this.fecha=fecha;
	}
	
	public Cuenta(){
		numero="null";
	}

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
	
	
}
