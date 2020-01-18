package Agenda;

public class Amigos extends Contactos {

		// ATRIBUTO //
	private int GradoAfinidad;

//--------------------------------------------------------------//
	// GETTERS Y SETTERS //
	public int getGradoAfinidad() {
		return GradoAfinidad;
	}

	public void setGradoAfinidad(int gradoAfinidad) {
		GradoAfinidad = gradoAfinidad;
	}

//--------------------------------------------------------------//
	// CONSTRUCTORES //
	public Amigos(int gradoAfinidad) {
		super();
		GradoAfinidad = gradoAfinidad;
	}
	public Amigos() {
		
	}

//--------------------------------------------------------------//
	// MÉTODO TO STRING //
	
	public String toString() {
		String Amigos=("Nombre: "+this.Nombre +"\nApellidos: "
		+ this.Apellidos+ "\nCorreo: "+this.Correo+"\nTelefono: "
		+this.Telefono+"\nGrado de Afinidad: "+this.GradoAfinidad);
		return Amigos;
	}
}







