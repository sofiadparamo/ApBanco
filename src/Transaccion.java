import java.util.Date;


public class Transaccion{
	private char tipo;
	private int folio;
	private String cuenta;
	private String referencia;
	private Date fecha;
	private float monto;
	
	public Transaccion(char tipo, int folio, String cuenta, String referencia, Date fecha, float monto){
		this.tipo = tipo;
		this.folio = folio;
		this.cuenta = cuenta;
		this.referencia = referencia;
		this.fecha = fecha;
		this.monto = monto;
	}

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }
	
	
}
