package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Funcionarios;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		List<Funcionarios> funcionarios = new ArrayList<>();

		System.out.print("Entre o caminho do arquivo: ");
		String caminho = sc.nextLine();

		try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {

			String linha = br.readLine();

			while (linha != null) {

				String[] campos = linha.split(",");
				String nome = campos[0];
				String email = campos[1];
				Double salario = Double.parseDouble(campos[2]);

				funcionarios.add(new Funcionarios(nome, email, salario));

				linha = br.readLine();
			}

			System.out.print("Entre o salario: ");
			double compSalario = sc.nextDouble();

			Comparator<String> comp = (s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase());

			List<String> funEmail = funcionarios.stream().filter(x -> x.getSalario() > compSalario)
					.map(x -> x.getEmail()).sorted(comp).collect(Collectors.toList());

			System.out.println("\nEmail dos funcionarios com salario maior que " + compSalario + ": ");
			funEmail.forEach(System.out::println);

			double somaSalarioM = funcionarios.stream().filter(x -> x.getName().charAt(0) == 'M')
					.mapToDouble(x -> x.getSalario()).sum();

			System.out.println("\nSoma dos salarios dos funcionarios cujo o nome começa com a letra M:");
			System.out.printf("%.2f", somaSalarioM);

		} catch (IOException e) {
			System.out.print("Error: " + e.getMessage());
		}

		sc.close();
	}

}
