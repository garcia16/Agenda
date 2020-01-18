package Agenda;

import java.io.*;
import java.util.*;

public class Principal {
	
	static ArrayList<Contactos> ListaContactos = new ArrayList <Contactos>(); //ARRAYLIST DONDE SE GUARDARA EL OBJETO CON LOS ATRIBUTOS DE CADA CONTACTO
	static ArrayList<Integer> ListaAmigos = new ArrayList <Integer>(); //ARRAYLIST DONDE DE GUARDARA EL GRADO DE AFINIDAD DE LOS AMIGOS
	static ArrayList<String> ListaFamilia = new ArrayList <String>(); //ARRAYLIST DONDE SE GUARDARA EL APELLIDO DE LOS FAMILIARES
	static ArrayList<String> ListaNumeros = new ArrayList <String>(); //ARRALIST DONDE SE GUARDARA EL TELEFONO DE CADA CONTACTO
	
	private static Scanner teclado = new Scanner(System.in);
	
// INSERTAR UN FAMILIAR	
	public static void InsertarFamiliar() throws IOException {
		boolean bandera=true;
		// CREACION DEL OBJETO //
		Familiares Familiar1 = new Familiares(); // CREACION DEL OBJETO
		
		// INTRODUCCION DE DATOS //
		System.out.println("Introduce el Nombre");
		Familiar1.setNombre(teclado.nextLine()); // INTRODUCIMOS EL NOMBRE POR TECLADO
	System.out.println("Introduce los Apellidos");
		Familiar1.setApellidos(teclado.nextLine()); // INTRODUCIMOS EL APELLIDO POR TECLADO
			do {
	System.out.println("Introduce su Correo");
		Familiar1.setCorreo(teclado.nextLine()); // INTRODUCIMOS EL CORREO POR TECLADO
			}while(Familiar1.getCorreo().indexOf("@")==1); // CONDICIONA QUE LLEVE UN ARROBA
			do {
	System.out.println("Introduce su Telefono");
		bandera=true;
		Familiar1.setTelefono(teclado.nextLine()); // INTRODUCIMOS EL TELEFONO POR TECLADO
			for(int f=0;f<ListaContactos.size();f++) {
				if(Familiar1.getTelefono().equalsIgnoreCase(ListaContactos.get(f).getTelefono())==true) { // FUNCIONA COMO CONDICION DE QUE SI YA EXISTE UN CONTACTO CON ESE TELEFONO NO PODAMOS INTRODUCIRLO
					bandera=false;
					System.out.println("Telefono ya existente");
				}
			}
			}while(bandera==false);
	System.out.println("Introduce su Direccion");
		Familiar1.setDireccion(teclado.nextLine()); // INTRODUCIMOS LA DIRECCION POR TECLADO
		do {
	System.out.println("Introduce su Parentesco"
			+ "\nCercano o Lejano");
		Familiar1.setParentesco(teclado.nextLine()); //INTRODUCIMOS EL PARENTESCO POR TECLADO
		}while ((Familiar1.getParentesco().equalsIgnoreCase("cercano")||Familiar1.getParentesco().equalsIgnoreCase("lejano"))==false);
		ListaContactos.add(Familiar1); // AÑADIMOS EL OBJETO AL ARRAY
		ListaFamilia.add(Familiar1.getApellidos()); // AÑADIMOS EL ATRIBUTO DEL OBJETO AL ARRAY DE LOS APELLIDOS
		ListaNumeros.add(Familiar1.getTelefono()); // AÑADIMOS EL ATRIBUTO DEL OBJETO AL ARRAY DE LOS TELEFONOS
			System.out.println("CONTACTO GUARDADO");
		System.out.println("-------------------------"
				+"\n");
		Menus.MenuPrincipal(); // NOS LLEVA DE NUEVO AL MENU PRINCIPAL
	}
	
// INSERTAR UN AMIGO	
	public static void InsertarAmigo() throws IOException {
		boolean bandera=true;
		// CREACION DEL OBJETO //
		Amigos Amigo1 = new Amigos(); // CREAMOS EL OBJETO
		
		// INTRODUCCION DE DATOS //
	System.out.println("Introduce el Nombre"); 
		Amigo1.setNombre(teclado.nextLine()); // INTRODUCIMOS EL NOMBRE POR TECLADO
	System.out.println("Introduce los Apellidos");
		Amigo1.setApellidos(teclado.nextLine()); // INTRODUCIMOS EL APELLIDO POR TECLADO
		do {
	System.out.println("Introduce su Correo");
		Amigo1.setCorreo(teclado.nextLine()); // INTRODUCIMOS EL CORREO POR TECLADO
		}while(Amigo1.getCorreo().indexOf("@")==1); // CONDICIONA QUE LLEVE UN ARROBA
		do {
	System.out.println("Introduce su Telefono");
	bandera=true;
		Amigo1.setTelefono(teclado.nextLine()); // INTRODUCIMOS EL TELEFONO POR TECLADO
		for(int f=0;f<ListaContactos.size();f++) {
			if(Amigo1.getTelefono().equalsIgnoreCase(ListaContactos.get(f).getTelefono())==true) { // FUNCIONA COMO CONDICION DE QUE SI YA EXISTE UN CONTACTO CON ESE TELEFONO NO PODAMOS INTRODUCIRLO
				bandera=false;
			}
		}
		}while(bandera==false);
		
		boolean correcto = false;
		do {
	System.out.println("Introduce su Grado de Afinidad de 1 a 5");
		//SE REPITE HASTA ESCRIBIR UN NUMERO
			try {
				Amigo1.setGradoAfinidad(teclado.nextInt()); // INTRODUCIMOS EL GRADO DE AFINIDAD POR TECLADO
				correcto = true;
			}catch (InputMismatchException e) { // SI INTRODUCE ALGO QUE NO SEA UN NUMERO
				System.out.println("Tiene que escribir un número"); //IMPRIME MENSAJE DE ERROR
			} finally {
				teclado.nextLine();//LIMPIA
			}
		} while (!correcto || Amigo1.getGradoAfinidad()<1 || Amigo1.getGradoAfinidad()>5);
		ListaContactos.add(Amigo1); // AÑADIMOS EL ATRIBUTO DEL OBJETO AL ARRAY
		ListaAmigos.add(Amigo1.getGradoAfinidad()); // AÑADIMOS EL ATRIBUTO DEL OBJETO AL ARRAY DE LOS GRADOS DE AFINIDAD
		ListaNumeros.add(Amigo1.getTelefono()); // AÑADIMOS EL ATRIBUTO DEL OBJETO AL ARRAY DE LOS TELEFONOS
			System.out.println("CONTACTO GUARDADO"); // MENSAJE DE EXITO
		System.out.println("-------------------------"
				+"\n");
		Menus.MenuPrincipal();
		}
	
// ELIMINAR CONTACTO 	
	public static void EliminarContacto() throws IOException {
		String telefono;
		int bandera=0;
		if (ListaContactos.size()==0) {
			System.out.println("No existen Contactos que eliminar, seleccione otra opcion");
		}else {
		System.out.println("Introduce el telefono del contacto a eliminar");
		telefono=teclado.nextLine(); 
		for (int i=0;i<ListaContactos.size();i++) { // DENTRO DE LA LISTA DE CONTACTOS
				if (telefono.equals(ListaContactos.get(i).getTelefono())) { // COMPARA EL TELEFONO INTRODUCIDO POR TECLADO
																			//CON EL TELEFONO ASIGNADO A LOS CONTACTOS DE LA LISTA
					ListaContactos.remove(ListaContactos.get(i)); // ELIMINACION DEL CONTACTO (ELIMINAMOS EL OBJETO)
					System.out.println("CONTACTO ELIMINADO");
				}else { // EN CASO DE NO ENCONTRAR EL CONTACTO HARÁ LO SIGUIENTE
					System.out.println("Ese contacto no existe"
							+"\nSi desea volver a intentarlo pulsa 1"
							+"\nSi desea volver al menu pulsa 2");
				
					// SELECCION DE OPCIÓN //
				
					bandera=teclado.nextInt();
					teclado.nextLine();// LO USAMOS PARA VACIAR EL TECLADO
					if (bandera==1) {
						EliminarContacto(); // VOLVEMOS AL PRINCIPIO DE ESTE METODO
					}
					if (bandera==2) {
						System.out.println("-------------------------"
								+"\n");
						Menus.MenuPrincipal(); // VOLVEMOS AL MENU PRINCIPAL
					}
				}
		}
		System.out.println("-------------------------"
				+"\n");
		Menus.MenuPrincipal(); // NOS LLEVA AL MENU PRINCIPAL DE NUEVO
		}
	}
// MOSTRAR UN SOLO CONTACTO
	public static void MostrarUno() throws IOException {
		String telefono;
		int bandera=0;
		System.out.println("Introduce el telefono del contacto a mostrar");
		telefono=teclado.nextLine(); // INTRODUCIMOS EL TELEFONO DEL CONTACTO A MOSTRAR
		for (int i=0;i<ListaContactos.size();i++) { // DENTRO DE LA LISTA DE CONTACTOS
				if (telefono.equals(ListaContactos.get(i).getTelefono())) { // COMPARA EL TELEFONO INTRODUCIDO POR TECLADO
																			//CON EL TELEFONO ASIGNADO A LOS CONTACTOS DE LA LISTA
					System.out.println(ListaContactos.get(i) //MUESTRA EL CONTACTO QUE COINCIDE CON EL TELEFONO INTRODUCIDO POR TECLADO
								+"\n-------------------------"
								+"\n");
					Menus.MenuPrincipal();  // ME LLEVA AL MENU PRINCIPAL DE NUEVO
					
				}else { // EN CASO DE NO ENCONTRAR EL CONTACTO HARÁ LO SIGUIENTE
					System.out.println("Ese contacto no existe"
								+"\nSi desea volver a intentarlo pulsa 1"
								+"\nSi desea volver al menu pulsa 2");
					
					// SELECCION DE OPCIÓN //
					
					bandera=teclado.nextInt();
					teclado.nextLine();// LO USAMOS PARA VACIAR EL TECLADO
					if (bandera==1) {
						MostrarUno(); // VOLVERÁ AL INICIO DEL MÉTODO
					}
					if (bandera==2) {
						System.out.println("-------------------------"
								+"\n");
						Menus.MenuPrincipal(); // NOS LLEVA DE NUEVO AL MENU PRINCIPAL
					}
				}
				
			}

		}
	
// MOSTRAR TODOS LOS CONTACTOS
	public static void MostrarTodo() throws IOException {
		// USAREMOS UN CONTADOR PARA LUEGO IMPRIMIR LA CANTIDAD TOTAL DE CONTACTOS
		int cont=0;
		System.out.println("      Contactos      ");
		System.out.println("---------------------");
		
		// ORDENAR EL ARRAY
		Collections.sort(ListaNumeros);
		
		for (int i=0;i<ListaContactos.size();i++) { //BUSCA EN EL ARRAY DE CONTACTOS 
			for ( int f=0;f<ListaNumeros.size();f++) {
				if (ListaNumeros.get(f)== ListaContactos.get(i).getTelefono()) { // COMPARAMOS LOS 2 ARRAYS
					System.out.println(ListaContactos.get(i).toString()); //MUESTRA LOS CONTACTOS AMIGOS QUE COINCIDEN
					cont=cont+1; //CON UN CONTADOR OBTENDREMOS LA SUMA DE LOS CONTACTOS
					System.out.println(".......................");
				}
			}
	}
		
		System.out.println("Total Contactos: "+cont 
				+"\n-------------------------"
				+"\n");
		Menus.MenuPrincipal(); // NOS LLEVA DE NUEVO AL MENU PRINCIPAL
	}
	
// MOSTRAR CONTACTOS AMIGOS
	public static void MostrarAmigo() throws IOException {
		// USAREMOS UN CONTADOR PARA LUEGO IMPRIMIR LA CANTIDAD DE CONTACTOS AMIGOS
		int cont=0;
		System.out.println("  Contactos Amigos  ");
		System.out.println("--------------------");
		
		// ORDENAR EL ARRAY
		
				//LA IDEA ES CREAR OTRO ARRAYLIST DE TIPO INTEGER, AÑADIR AHI LOS GRADOS DE AFINIDAD DE CADA OBJETO
				//Y DESPUES DE ESO YA ME DEJARA USAR EL "COLLECTIONS.SORT", QUE SIRVE PARA ORDENAR EL ARRAY
				
		        Collections.sort(ListaAmigos);
		
		for (int i=0;i<ListaAmigos.size();i++) { //BUSCA EN EL ARRAY DE CONTACTOS AMIGOS
			if (ListaAmigos.get(i)==(((Amigos) ListaContactos.get(i)).getGradoAfinidad())) { // COMPARAMOS LOS 2 ARRAYS
				System.out.println(ListaContactos.get(i).toString()); //MUESTRA LOS CONTACTOS AMIGOS QUE COINCIDEN
				cont=cont+1; //CON UN CONTADOR OBTENDREMOS LA SUMA DE LOS CONTACTOS
				System.out.println(".......................");
			}
			}
		System.out.println("-------------------------");
		System.out.println("Contactos Amigos: "+cont); // MUESTRA EL NUMERO DE CONTACTOS AMIGOS
		System.out.println("-------------------------"
				+"\n");
		Menus.MenuPrincipal(); // NOS LLEVA DE NUEVO AL MENU PRINCIPAL
	}
	
// MOSTRAR CONTACTOS FAMILIARES
	public static void MostrarFamiliares() throws IOException {
		// USAREMOS UN CONTADOR PARA LUEGO IMPRIMIR LA CANTIDAD DE CONTACTOS FAMILIARES
		int cont=0;
		System.out.println("  Contactos Familiares  ");
		System.out.println("------------------------");
		
		// ORDENAR EL ARRAY
		
		//LA IDEA ES CREAR OTRO ARRAYLIST DE TIPO STRING, AÑADIR AHI LOS APELLIDOS DE CADA OBJETO
		//Y DESPUES DE ESO YA ME DEJARA USAR EL "COLLECTIONS.SORT", QUE SE USA PARA ORDENAR LOS ELEMENTOS
		//DEL ARRAY EN ORDEN
		
        Collections.sort(ListaFamilia);
        
		for (int i=ListaFamilia.size()-1;i>=0;i--) {  //BUSCA EN EL ARRAY DE CONTACTOS
			for (int f=0; f<ListaContactos.size();f++) {
				if (ListaFamilia.get(i).equals(ListaContactos.get(f).getApellidos())) { // COMPARAMOS LOS 2 ARRAYS
					System.out.println(ListaContactos.get(i).toString()); // MUESTRA EL CONTACTO QUE COINCIDE
					cont=cont+1; //CON UN CONTADOR OBTENDREMOS LA SUMA DE LOS CONTACTOS
					System.out.println(".......................");
				}
			}
		}
		System.out.println("-------------------------");
		System.out.println("Contactos Familiares: "+cont); // MUESTRA EL NUMERO DE CONTACTOS FAMILIARES
		System.out.println("-------------------------"
				+"\n");
		Menus.MenuPrincipal(); // NOS LLEVA DE NUEVO AL MENU PRINCIPAL
		}
		
		
// GUARDAR AGENDA
	public static void GuardarAgenda() {
		
		boolean guardar = false;
		BufferedWriter bw = null;
		File agendaFichero = null;
		
		System.out.println("Escriba la ruta donde guardar el archivo");
		String ruta = teclado.nextLine(); // INTRODUCIMOS LA RUTA POR TECLADO
		System.out.println("Escribe el nombre de la agenda");
		String nombreagenda = teclado.nextLine(); // INTRODUCIMOS POR TECLADO EL NOMBRE PARA LA AGENDA
		agendaFichero = new File (ruta, nombreagenda);
		if (agendaFichero.exists()) { // EN CASO DE EXISTIR UN FICHERO CON ESE NOMBRE SE REEMPLAZARÁ
			System.out.println("El archivo ya existe, el contenido se reemplazará");
			if (Confirmar()) {
				guardar = true;
			}
		} else { // EN CASO DE NO EXISTIR EL FICHERO
			try {
				agendaFichero.createNewFile(); // CREA EL FICHERO CON LOS DATOS QUE INTRODUCIMOS ARRIBA
				guardar = true;
				System.out.println("Nuevo fichero creado"); // MENSAJE DE EXITO
			} catch (IOException e) { // SI LA RUTA NO ES VALIDA SALTA ESTA EXCEPCION
				System.out.println("La ruta no es válida");
			}
		}		
		if (guardar) {
			try {
				bw = new BufferedWriter (new FileWriter (agendaFichero));
				for (Contactos p : ListaContactos) { 
					bw.write(String.valueOf(p.getClass()));
					bw.newLine();
					bw.write(p.getNombre());
					bw.newLine();
					bw.write(p.getApellidos());
					bw.newLine();
					bw.write(p.getCorreo());
					bw.newLine();
					bw.write(p.getTelefono());
					bw.newLine();
					if (p instanceof Familiares) {
						bw.write(((Familiares) p).getDireccion());
						bw.newLine();
						bw.write(((Familiares) p).getParentesco());
						bw.newLine();
					} else if (p instanceof Amigos) {
						bw.write(String.valueOf(((Amigos) p).getGradoAfinidad()));
						bw.newLine();
					}
					bw.write("---------------------------");
					bw.newLine();
				}
			} catch (IOException e) {
				e.printStackTrace(); // EXCEPCION
			} finally {
				try {
					System.out.println("AGENDA GUARDADA"); // MENSAJE DE EXITO
					bw.close();
					guardar = true;
				} catch (IOException e) {
					e.printStackTrace(); // EXCEPCION
				}
			}
		} else {
			System.out.println("No se ha podido guardar el archivo"); // MENSAJE DE ERROR
		}
		
	}
	//CONFIRMAR BORRADO
	static boolean Confirmar () {
		boolean confirmar = false;
		//PARA CONFIRMAR QUE SE BORRA
			boolean correcto = true;
			do {
				System.out.println("Se guardarán los cambios. ¿Desea continuar? (Si/No)");
				String opc = teclado.nextLine().toLowerCase(); // INTRODUCIMOS LA OPCION QUE QUEREMOS
				switch (opc) {
				case "Si": // OPCION 1
					confirmar = true;
					break;
				case "No": // OPCION 2
					confirmar = false;
					break;
				default:
					System.out.println("Opción no válida"); // SALTA EL MENSAJE EN CASO DE NO ESCRIBIR "Si" O "No" 
					correcto = false;
				}
			} while (!correcto);
		return confirmar;
	}
	
// CARGAR AGENDA
	public static void CargarAgenda() throws IOException{
		
		BufferedReader br = null; // PERMITE LEER LAS LINEAS DEL FICHERO
		File agendaFichero = null;
		
		System.out.println("Escriba la ruta del archivo a cargar");
		String ruta = teclado.nextLine(); // SE INTRODUCE LA RUTA POR TECLADO
		agendaFichero = new File (ruta);
		
		if (agendaFichero.exists() && agendaFichero.isFile()) {
			br = new BufferedReader (new FileReader (agendaFichero));
			String linea = br.readLine();
			//SE BORRA EL CONTENIDO DEL ARRAYLIST QUE TENIAMOS, PARA INTRODUCIR LO NUEVO
			ListaContactos.removeAll(ListaContactos); // BORRAMOS EL CONTENIDO DEL ARRAY
			ListaAmigos.removeAll(ListaAmigos);  // BORRAMOS EL CONTENIDO DEL ARRAY
			ListaFamilia.removeAll(ListaFamilia); // BORRAMOS EL CONTENIDO DEL ARRAY
			ListaNumeros.removeAll(ListaNumeros); // BORRAMOS EL CONTENIDO DEL ARRAY
			while (linea != null) { // MIENTRAS QUE HAYA LINEAS HARA LO SIGUIENTE
				if (linea.equalsIgnoreCase("class Agenda.Familiares")) { // EN CASO DE ENCONTRAR UNA LINEA DE FAMILIARES
					Familiares familiar = new Familiares(); // CREAMOS EL OBJETO
					
					linea = br.readLine();
					familiar.setNombre(linea);
					System.out.println(familiar.getNombre());
					
					linea = br.readLine();
					familiar.setApellidos(linea);
					System.out.println(familiar.getApellidos());
					
					linea = br.readLine();
					familiar.setCorreo(linea);
					System.out.println(familiar.getCorreo());
					
					linea = br.readLine();
					familiar.setTelefono(linea);
					System.out.println(familiar.getTelefono());
					
					linea = br.readLine();
					familiar.setDireccion(linea);
					System.out.println(familiar.getDireccion());
					
					linea = br.readLine();
					familiar.setParentesco(linea);
					System.out.println(familiar.getParentesco());
					System.out.println("---------------------------");
					
					ListaContactos.add(familiar); // AÑADIMOS EL OBJETO AL ARRAY DE CONTACTOS
					ListaFamilia.add(familiar.getApellidos()); // AÑADIMOS EL ATRIBUTO AL ARRAY DE APELLIDOS
					ListaNumeros.add(familiar.getTelefono()); // AÑADIMOS EL ATRIBUTO AL ARRAY DE TELEFONOS
					
				} else if (linea.equalsIgnoreCase("class Agenda.Amigos")) {// EN CASO DE ENCONTRAR UNA LINEA DE AMIGOS
					
					
					Amigos Amigo1 = new Amigos(); // CREAMOS EL OBJETO
					
					linea = br.readLine();
					Amigo1.setNombre(linea);
					System.out.println(Amigo1.getNombre());
					
					linea = br.readLine();
					Amigo1.setApellidos(linea);
					System.out.println(Amigo1.getApellidos());
					
					linea = br.readLine();
					Amigo1.setCorreo(linea);
					System.out.println(Amigo1.getCorreo());
					
					linea = br.readLine();
					Amigo1.setTelefono(linea);
					System.out.println(Amigo1.getTelefono());
					
					linea = br.readLine();
					Amigo1.setGradoAfinidad(Integer.parseInt(linea));
					System.out.println(Amigo1.getGradoAfinidad());
					System.out.println("---------------------------");
					
					ListaContactos.add(Amigo1); // AÑADIMOS EL OBJETO AL ARRAY DE CONTACTOS
					ListaAmigos.add(Amigo1.getGradoAfinidad()); // AÑADIMOS EL ATRIBUTO AL ARRAY DE GRADOS DE AFINIDAD
					ListaNumeros.add(Amigo1.getTelefono()); // AÑADIMOS EL ATRIBUTO AL ARRAY DE TELEFONOS
				}		
				// LEE LINEAS DE SEPARACION
				linea = br.readLine();
				linea = br.readLine();
			} 
			br.close();
			System.out.println("Total: " + ListaContactos.size() + "\n"); // MUESTRA EL TOTAL DE CONTACTOS
		} else {
			System.out.println("No se encuentra el archivo"); // MENSAJE EN CASO DE NO ENCONTRAR EL ARCHIVO
			CargarAgenda(); // VOLVEMOS AL PRINCIPIO DEL METODO CARGAR AGENDA
		}
		
	}
	
}
