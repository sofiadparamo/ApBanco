public class Transaccion {
    private char tipo;
    private int folio;
    private String cuenta;
    private String referencia;
    private String fecha;
    private float monto;

    public Transaccion(char tipo, int folio, String cuenta, String referencia,
                       String fecha, float monto) {
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

    public int getFolio() {
        return folio;
    }

    public String getCuenta() {
        return cuenta;
    }

    public String getReferencia() {
        return referencia;
    }

    public String getFecha() {
        return fecha;
    }

    public float getMonto() {
        return monto;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }
}







