package tododulce;

import java.io.*;

public class Dao {

	public void escribirSalida() {
		try {
			File arc = new File("Ejercicio2.txt");
			PrintStream redireccionamientoSalida = new PrintStream (arc);
			FileWriter escribir = new FileWriter(arc, true);
			if(!arc.exists()) {
				arc.createNewFile();
			}
			String text = redireccionamientoSalida + "";
			escribir.write(text);
			escribir.close();
		}
		catch(Exception e) {
			System.out.println("Se ha producido un error: " + e);
		}
	}
	
}
