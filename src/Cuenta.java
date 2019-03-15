import java.util.Date;


public class Cuenta{
	
	private float saldo;
	private Date fecha;
	
	public Cuenta(float saldo,Date fecha){
		this.saldo=saldo;
		this.fecha=fecha;
	}
	
	public Cuenta(){
		
	}


    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
	
	
}
