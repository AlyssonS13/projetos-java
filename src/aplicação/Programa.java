package aplicação;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entidade.Funcionarios;

public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Locale.setDefault(Locale.US);
		Scanner leitor = new Scanner(System.in);
		
		List<Funcionarios> lista = new ArrayList<>();
		
		System.out.println("Digite a quantidade de funcionários a serem cadastrados: ");
		int numeroFuncionarios = leitor.nextInt();
		
		for (int i = 1; i <= numeroFuncionarios; i++) {
			System.out.println("Funcionário #" + i + ": ");
			System.out.print("Id: ");
			int id = leitor.nextInt();
			System.out.print("Nome: ");
			leitor.nextLine();
			String nome = leitor.nextLine();
			System.out.print("Salário: ");
			double salario = leitor.nextDouble();
			
			lista.add(new Funcionarios(id, nome, salario));
			
		}
		
		System.out.println();
		System.out.println("Digite o id do funcionário que vai receber um aumento: ");
		int id = leitor.nextInt();
		Funcionarios func = lista.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		if (func == null) {
			System.out.println("O id digitado não existe no banco de cadastros.");
		} else {
			System.out.println("Digite a porcentagem de aumento: ");
			double porcentagem = leitor.nextDouble();
			func.aumentoSalarial(porcentagem);
		}
		
		for (Funcionarios obj : lista) {
			System.out.print(obj);
		}
		
		leitor.close();
	}

}
