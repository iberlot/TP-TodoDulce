package tododulce;

import java.util.*;

public class GoloInt {

	private List <Integer> numeros = new ArrayList <Integer>();
	private List <Golosinas> goloList = new ArrayList <Golosinas>();
	
	public GoloInt() {}
	
	public GoloInt(List <Integer> numeros, List <Golosinas> goloList) {
		this.numeros = numeros; this.goloList = goloList;
	}
	
	public List <Integer> getNumeros() {
		return numeros;
	}
	public void setNumeros(List <Integer> numeros) {
		this.numeros = numeros;
	}
	public List <Golosinas> getGoloList() {
		return goloList;
	}
	public void setGoloList(List <Golosinas> goloList) {
		this.goloList = goloList;
	}
	
}
