package banco;

import java.util.ArrayList;
import java.util.List;

public class Banco {
	private String nome;
	protected List<Conta> contas;
	
	public Banco(String nome) {
		this.nome = nome;
		this.contas = new ArrayList<>();
	}
	
	public void imprimirContas() {
		System.out.println("+-----------------+ Banco +-----------------+");
		System.out.println("Nome do Banco: " + nome + "\r\n");
		for(Conta c : contas) {
			System.out.println(c.getCliente());
			System.out.println(c);
		}
		System.out.println("+-------------------------------------------+");
	}
	
}
