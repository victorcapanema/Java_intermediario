package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Map<String, Integer> mapa = new HashMap<>();
		
		System.out.print("Entre o caminho do arquivo: ");
		String caminho = sc.nextLine();

		try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {

			

			String linha = br.readLine();

			while (linha != null) {

				String[] campos = linha.split(",");
				String nome = campos[0];
				int votos = Integer.parseInt(campos[1]);

				if (mapa.containsKey(nome) == true) {
					mapa.put(nome, votos+mapa.get(nome));
				} 
				else {
					mapa.put(nome, votos);
				}

				linha = br.readLine();
			}
			
			for(String nome: mapa.keySet()) {
				System.out.print(nome+": ");
				System.out.print(mapa.get(nome)+"\n");
				
			}
			

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		sc.close();

	}

}
