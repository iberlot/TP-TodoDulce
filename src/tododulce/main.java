package tododulce;

import java.util.*;

public class main {

	private static Scanner leer = new Scanner(System.in);
	private static List <GoloInt> goloIntList = new ArrayList<GoloInt>();
	private static List <Golosinas> goloList = new ArrayList<Golosinas>();
	private static List <Integer> listaNumerica = new ArrayList <Integer>();
	
	public static void main(String[] args) throws ExceptionsPropia {
		
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
		
		
		//Punto F
//		igualValores(List &lt;Integer&gt;): 
//		indica si la colección recibida como argumento
//		tiene algún valor en común, respecto a la estructura existente.
		List <Integer> argsInt = new ArrayList <Integer>();
		
		for (int z=0; z<args.length;z++) {
			argsInt.add(Integer.parseInt(args[z]));
		}
		boolean valRepetido = Collections.disjoint(argsInt, goloIntList);
		System.out.println("Existen valores repetidos " + valRepetido);
		
		//Punto G
//		agregar(List &lt;Golosinas&gt;): agrega la lista recibida como argumento al final del
//		ArrayList propio.
		for (int c=0;c<goloIntList.size();c++) {
			goloIntList.add(new GoloInt(argsInt, goloList));
		}
		
		
//		h) busquedaMultiple(Integer): retorna la cantidad de veces que se encuentra un
//		número en la colección. De no existir, lanza la misma excepción del punto c.
		
		puntoH();
		
		
//		i) distintosValores(List &lt;Golosinas&gt;): devuelve un ArrayList con aquellos objetos
//		que no coinciden con los recibidos como argumentos.
		
		puntoI(goloList);
  
		
//		j) copiarLista(int pos1, int pos1): copiar en una lista nueva las posiciones de la lista
//		de enteros, comprendidas entre los argumentos recibidos.
		int pos1=Integer.parseInt(args[args.length]);
		int pos2=Integer.parseInt(args[(args.length)-1]);
		int aux=0;
		if (pos1<pos2) {
			aux=pos2;
			pos2=pos1;
			pos1=aux;
		} else {
			List <Integer> copiaDeLista = new ArrayList<Integer>(); 
			for (int k=pos1;k<pos2;k++) {
				
		        copiaDeLista = (List<Integer>) ((ArrayList) argsInt).clone(); 
			}
		}

		
		daoClass.escribirSalida();
	}
	private static List <Golosinas> puntoI(List <Golosinas> auxGolo) {
		System.out.println("Escriba un número cualquiera: ");
		int num = leer.nextInt();
		for (int i=0;i<auxGolo.size();i++) {
			if (num==auxGolo.get(i).getCodigo()) {
				System.out.println("Se ha eliminado el codigo: "+num);
				auxGolo.remove(i);
			}
		}
		return auxGolo;
	}
	public static void puntoH () throws ExceptionsPropia {

		int frec = Collections.frequency(goloIntList, 5);
		System.out.println("El número 5 se repite "+frec+" veces.");
	}
	
	public static void removerItem(int i) throws ExceptionsPropia {
		goloList.remove(i);
	}
	
	}

