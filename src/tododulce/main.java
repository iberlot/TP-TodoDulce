package tododulce;

import java.util.*;

public class main {

	private static Scanner leer = new Scanner(System.in);
	private static List <GoloInt> goloIntList = new ArrayList<GoloInt>();
	private static List <Golosinas> goloList = new ArrayList<Golosinas>();
	private static List <Integer> listaNumerica = new ArrayList <Integer>();
	
	public static void main(String[] args) {
		Dao daoClass = new Dao();
		//Punto A:
		Random numerosRandom = new Random();
		int dim = 10;
		while(dim != 0) {
		int num = numerosRandom.nextInt(10000);
		listaNumerica.add(num);
		dim--;
		if(num <= 999) {
			listaNumerica.remove(listaNumerica.size()-1);
			dim++;
		}
		}
		boolean continuar = true;
		while(continuar) {
			System.out.println("Ingrese el precio de la golosina: ");
			float precio = leer.nextFloat();
			System.out.println("Ingerese el codigo de la golosina: ");
			int codigo = leer.nextInt();
			System.out.println("Ingrese la descripcion: ");
			String descripcion = leer.nextLine();
			leer.nextLine();
			String vecSabores[] = new String[3];
			for(int i=0; i<vecSabores.length; i++) {
				System.out.println("Ingrese el nombre del sabor: ");
				vecSabores[i] = leer.nextLine();
			}
			goloList.add(new Golosinas(precio, codigo, descripcion, vecSabores));
			System.out.println("Desea agregar otra golosina?\nTrue para continuar: ");
			continuar = leer.nextBoolean();
		}
		goloIntList.add(new GoloInt(listaNumerica, goloList));
		
		//Punto B
		String valorMax = "El numero mayor es: " + Collections.max(listaNumerica);
		System.out.println(valorMax);
		
		//Punto C
		System.out.println("Escriba el indice que desea borrar de la lista de las golosinas: ");
		int i = leer.nextInt();
		removerItem(i);
		System.out.println("Objeto removido: " + i);
		//Punto D
		System.out.println("Lista ordenada de forma descendente segun el precio: ");
		Collections.sort(goloList);
		for(Golosinas gol: goloList) {
			System.out.println(gol.getPrecio());
		}
		//Punto E
		boolean dis = Collections.disjoint(goloList, goloList);
		String disjoint = "Tiene valores repetidos: " + dis;
		System.out.println(disjoint);
		
		
		daoClass.escribirSalida();
		
		
	}
	
	public static void removerItem(int i) {
		try {
			goloList.remove(i);
		}
		catch(Exception e) {
			System.out.println("Se ha producido un error: " + e);
		}
	}
	
	}

