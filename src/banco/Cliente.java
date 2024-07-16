package banco;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
	private String nome;
	private String cpf;
	private List<Conta> contas;
	
	public Cliente(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
		this.contas = new ArrayList<>();
	}
	
	public void imprimirContas() {
		if(!contas.isEmpty()) {
			System.out.println("+----------------+ Contas +-----------------+");
			System.out.println(this);
			for(Conta c : contas) {
				System.out.println(c);
			}
			System.out.println("+-------------------------------------------+");
		}
	}
	
	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public List<Conta> getContas() {
		return contas;
	}

	@Override
	public String toString() {
		return "Nome: " + getNome() + " - CPF: " + getCpf();
	}
}
