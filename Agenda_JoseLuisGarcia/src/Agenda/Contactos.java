package Agenda;

public class Contactos {

		// ATRIBUTOS //
	protected String Nombre;
	protected String Apellidos;
	protected String Correo;
	protected String Telefono;
	
//--------------------------------------------------------------//
	// GETTERS Y SETTERS //
		
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellidos() {
		return Apellidos;
	}
	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}
	public String getCorreo() {
		return Correo;
	}
	public void setCorreo(String correo) {
		Correo = correo;
	}
	public String getTelefono() {
		return Telefono;
	}
	public void setTelefono(String telefono) {
		Telefono = telefono;
	}

//--------------------------------------------------------------//
	// CONSTRUCTORES //
	
	public Contactos(String nombre, String apellidos, String correo, String telefono) {
		super();
		Nombre = nombre;
		Apellidos = apellidos;
		Correo = correo;
		Telefono = telefono;
	}
	public Contactos(String nombre, String apellidos, String correo) {
		super();
		Nombre = nombre;
		Apellidos = apellidos;
		Correo = correo;
	}
	public Contactos(String nombre, String apellidos) {
		super();
		Nombre = nombre;
		Apellidos = apellidos;
	}
	public Contactos(String nombre) {
		super();
		Nombre = nombre;
	}
	public Contactos() {
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public int getGradoAfinidad() {
		return 0;
	}
}
