package application;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import entities.Aluno;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Set<Aluno> set = new HashSet<>();

		AdicionarAluno.adicionarAluno(set, sc, "A");
		AdicionarAluno.adicionarAluno(set, sc, "B");
		AdicionarAluno.adicionarAluno(set, sc, "C");

		System.out.print("Total de alunos: " + set.size());

		sc.close();

	}

}
