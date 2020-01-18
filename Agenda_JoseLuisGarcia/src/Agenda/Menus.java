package Agenda;

import java.io.IOException;
import java.util.*;

public class Menus extends Principal{
	private static Scanner teclado = new Scanner(System.in);
	
	public static void MenuPrincipal() throws IOException {
		int opc=0,opc2=0,opc3=0;
		
		do {
			try {
		System.out.println("    AGENDA    "); //IMPRIME POR PANTALLA
		System.out.println("MENU PRINCIPAL"
				+ "\n--------------------"
				+ "\n1. Insertar Contacto"
				+ "\n2. Eliminar Contacto"
				+ "\n3. Mostrar Contacto"
				+ "\n4. Mostrar todos los Contactos"
				+ "\n5. Mostrar todos los Contactos de un tipo"
				+ "\n6. Guardar Agenda"
				+ "\n7. Cargar Agenda"
				+ "\n0. Salir");
		
		// SELECCION DE OPCIÓN //
		
		opc=teclado.nextInt();
		teclado.nextLine();//LO USAMOS PARA VACIAR EL TECLADO
	// OPCION 1 //
			if (opc==1) {
				if (ListaContactos.size() < 100) { // SE HARA EN CASO DE QUE LA AGENDA NO TENGA MAS DE 100 CONTACTOS
				System.out.println("Seleccione tipo de contacto"
						+ "\n--------------------"
						+ "\n1. Familiar"
						+ "\n2. Amigo"
						+ "\n0. Volver al Menu Principal");
				// SELECCION DE OPCIÓN //
				opc2=teclado.nextInt();
				teclado.nextLine();//LO USAMOS PARA VACIAR EL TECLADO
				}else {
					System.out.println("La agenda está completa"); //EN CASO DE HABER 100 CONTACTOS MOSTRARÁ ESE MENSAJE
				}
					if (opc2==1) {
						Principal.InsertarFamiliar(); // ME LLEVA AL METODO DE INSERTAR FAMILIAR EN LA CLASE PRINCIPAL
					}
					if (opc2==2) {
						Principal.InsertarAmigo(); // ME LLEVA AL METODO DE INSERTAR AMIGO EN LA CLASE PRINCIPAL
					}
					if (opc2==0) {
						MenuPrincipal(); // VUELVE AL MENU PRINCIPAL
					}
			}
	// OPCION 2 //
			if (opc==2) {
				Principal.EliminarContacto(); // ME LLEVA AL METODO DE ELIMINAR
			}
	// OPCION 3 //		
			if (opc==3) {
				Principal.MostrarUno();	// ME LLEVA AL METODO DE MOSTRAR UN CONTACTO
			}
	// OPCION 4 //
			if (opc==4) {
				Principal.MostrarTodo(); // ME LLEVA AL METODO DE MOSTRAR TODO
			}
	// OPCION 5 //
			if (opc==5) {
				System.out.println("Seleccione tipo de contacto"
						+ "\n--------------------"
						+ "\n1. Familiar"
						+ "\n2. Amigo"
						+ "\n0. Volver al Menu Principal");
				// SELECCION DE OPCIÓN //
				opc3=teclado.nextInt();
				teclado.nextLine();//LO USAMOS PARA VACIAR EL TECLADO
					if (opc3==1) {
						Principal.MostrarFamiliares(); // ME LLEVA AL METODO DE MOSTRAR FAMILIAR EN LA CLASE PRINCIPAL
					}
					if (opc3==2) {
						Principal.MostrarAmigo(); // ME LLEVA AL METODO DE MOSTRAR AMIGO EN LA CLASE PRINCIPAL
					}
					if (opc3==0) {
						MenuPrincipal(); // VUELVE AL MENU PRINCIPAL
					}
			}
	// OPCION 6 //
			if (opc==6) {
				Principal.GuardarAgenda(); // ME LLEVA LA METODO DE GUARDAR AGENDA
			}
	// OPCION 7 //
			if (opc==7) {
				Principal.CargarAgenda(); // ME LLEVA AL METODO DE CARGAR AGENDA
			}
	// OPCION 8 //
			if (opc==0) {
				System.out.println("Programa Finalizado"); // MENSAJE DE SALIDA DEL PROGRAMA
			}
			}catch(InputMismatchException e) {
				teclado.nextLine();
				System.out.println("Valor no valido");
				MenuPrincipal();
			}
		}while(opc!=0);
		
	}
	
	
}
