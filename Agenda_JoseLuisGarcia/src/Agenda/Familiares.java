package Agenda;

public class Familiares extends Contactos {

		// ATRIBUTOS //
	private String Direccion;
	private String Parentesco;
	
//--------------------------------------------------------------//
	// GETTERS Y SETTERS //
	public String getDireccion() {
		return Direccion;
	}
	public void setDireccion(String direccion) {
		Direccion = direccion;
	}
	public String getParentesco() {
		return Parentesco;
	}
	public void setParentesco(String parentesco) {
		Parentesco = parentesco;
	}
	
//--------------------------------------------------------------//
	// CONSTRUCTORES //
	
	public Familiares(String direccion, String parentesco) {
		super();
		Direccion = direccion;
		Parentesco = parentesco;
	}
	public Familiares(String direccion) {
		super();
		Direccion = direccion;
	}

	public Familiares() {
		
	}
	
//--------------------------------------------------------------//
	// MÉTODO TO STRING //
	
	public String toString() {
		String Familiares=("Nombre: "+this.Nombre +"\nApellidos: "
		+ this.Apellidos+ "\nCorreo: "+this.Correo+"\nTelefono: "
		+this.Telefono+"\nDireccion: "+this.Direccion+"\nParentesco: "+this.Parentesco);
		return Familiares;
	}
}











