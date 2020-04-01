package application;

import model.entities.Client;

public class Program {
	public static void main(String[] args) {

		// 14.07 Generics - hashCode e equals 
		
		String a = "Maria";
		String b = "Alex";
		String c = "Maria";
		
		// hashCode cria um número e compara ele
		// 100% quando não for igual, já quase certamente quando for igual
		System.out.println("hashCode a: " + a.hashCode());
		System.out.println("hashCode b: " + b.hashCode());
		
		// compara especificamente - Mais demorado mas 100% acerto
		System.out.println("a = b: " + a.equals(b));
		
		// tratamento especial
		// mas se for criado com: String a = new String("Maria", "maria@gmail.com";
		// não dará "true", pois cai na questão seguinte
		System.out.println("a == c: " + (a == c));
		
		System.out.println();
		
		Client c1 = new Client("Maria", "maria@gmail.com");
		Client c2 = new Client("Bob", "bob@gmail.com");
		Client c3 = new Client("Maria", "maria@gmail.com");
		
		System.out.println("hashCode c1: " + c1.hashCode());
		System.out.println("hashCode c2: " + c2.hashCode());
		System.out.println("hashCode c3: " + c3.hashCode());
		
		System.out.println("c1 = c2: " + c1.equals(c2));
		System.out.println("c1 = c3: " + c1.equals(c3));
		
		// compara o endereço na memória
		System.out.println("c1 == c3: " + (c1 == c3));
	}
}