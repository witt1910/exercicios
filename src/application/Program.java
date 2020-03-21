package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {
	public static void main(String[] args) throws ParseException {

		// 08.04 Inheritance 05 - Polimorfismo

//		Fazer um programa para ler os dados de N
//		produtos (N fornecido pelo usuário). Ao final,
//		mostrar a etiqueta de preço de cada produto na
//		mesma ordem em que foram digitados.
//		Todo produto possui nome e preço. Produtos
//		importados possuem uma taxa de alfândega, e
//		produtos usados possuem data de fabricação.
//		Estes dados específicos devem ser
//		acrescentados na etiqueta de preço conforme
//		exemplo (próxima página). Para produtos
//		importados, a taxa e alfândega deve ser
//		acrescentada ao preço final do produto.

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Product> list = new ArrayList<>();

		System.out.print("Enter the number of product: ");
		int quantity = sc.nextInt();

		for (int count = 1; count <= quantity; count++) {
			System.out.println("Product #" + count + " data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			char op = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Price: ");
			double price = sc.nextDouble();
			if (op == 'i') {
				System.out.print("Customs fee: ");
				double customFee = sc.nextDouble();
				Product product = new ImportedProduct(name, price, customFee);
				list.add(product);
			}
			if (op == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date manufactureDate = sdf.parse(sc.next());
				Product product = new UsedProduct(name, price, manufactureDate);
				list.add(product);
			}
			if (op == 'c') {
				Product product = new Product(name, price);
				list.add(product);
			}
		}

		System.out.println();
		System.out.println("PRICE TAGS:");
		for (Product p : list) {
			System.out.println(p.priceTag());
		}

	}
}