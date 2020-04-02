package application;

import java.util.Map;
import java.util.TreeMap;

public class Program {
	public static void main(String[] args) {

		// 14.15 - Map (e principais métodos)

		// Cria conjunto com chaves e valores, tipo TreeMap (ordenado)
		Map<String, String> cookies = new TreeMap<>();

		// O método PUT insere chaves e valores
		cookies.put("username", "maria");
		cookies.put("email", "maria@gmail.com");
		cookies.put("phone", "99771122");

		// O método REMOVE retira do conjunto
		cookies.remove("email");

		// Novos valores nas mesmas chaves os sobrepõem
		cookies.put("phone", "99771133");

		// Verifica se uma dada chave existe no conjunto (true/false)
		System.out.println("Contains 'phone' key: " + cookies.containsKey("phone"));

		// Verifica o valor de determinada chave
		System.out.println("Phone number: " + cookies.get("phone"));
		
		// Se a chave buscada não existir, retorna 'null'
		System.out.println("Email: " + cookies.get("email"));

		// Verifica o tamanho do conjunto (cada par chave-valor conta como um)
		System.out.println("Size: " + cookies.size());

		System.out.println();

		// Meio de imprimir chaves e valores
		System.out.println("ALL COOKIES:");
		for (String key : cookies.keySet()) {
			System.out.println(key + ": " + cookies.get(key));
		}

	}
}