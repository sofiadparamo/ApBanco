
import java.util.Date;

public class Cuentahabiente{
	private String rfc;
	private String nombre;
	private String domicilio;
	private Date fecha_nacimiento;
	private String telefono;
	
	public Cuentahabiente(String nombre, String domicilio, String rfc, Long fecha_nacimiento, String telefono){
		this.rfc=rfc;
		this.nombre=nombre;
		this.domicilio=domicilio;
		Date fechaConvertida = new Date(fecha_nacimiento);
		this.fecha_nacimiento =  fechaConvertida;
		this.telefono=telefono;
	}
	
	public Cuentahabiente(String nombre, String domicilio, String rfc, Date fecha_nacimiento, String telefono){
		this.rfc=rfc;
		this.nombre=nombre;
		this.domicilio=domicilio;
		this.rfc=rfc;
		this.fecha_nacimiento =  fecha_nacimiento;
		this.telefono=telefono;
	}
	
	public Cuentahabiente(){
		rfc = "null";
	}
	

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
	
	
}
