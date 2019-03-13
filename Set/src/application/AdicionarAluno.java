package application;

import java.util.Scanner;
import java.util.Set;

import entities.Aluno;

public class AdicionarAluno {

	public static void adicionarAluno(Set<Aluno> set, Scanner sc, String curso) {

		System.out.print("Quantos alunos para o curso " + curso + " : ");
		int qtd = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < qtd; i++) {

			set.add(new Aluno(sc.nextInt(), curso));
			sc.nextLine();
		}

	}

}
