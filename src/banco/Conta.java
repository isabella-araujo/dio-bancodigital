package banco;

import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public abstract class Conta implements IConta {
	NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
	LocalDateTime hora;
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
	
	private Cliente cliente;
	private int agencia;
	private String numeroConta;
	private double saldo = Double.MIN_VALUE;
	private Banco banco;
	private int numeroOperacao;
	protected List<String> acoes = new ArrayList<>();
	
	public Conta(Cliente cliente, int agencia, String numeroConta, Banco banco) {
		super();
		this.cliente = cliente;
		this.agencia = agencia;
		this.numeroConta = numeroConta;
		this.banco = banco;
		banco.contas.add(this);
		cliente.getContas().add(this);
	}

	@Override
	public void deposito(double valor) {
		if(valor >= saldo) {
			saldo += valor;
			hora = LocalDateTime.now();
			String acao = "Depósito de " + currencyFormat.format(valor) + " em " + hora.format(formatter);
			acoes.add(acao);
		} else {
			System.out.println("Valor para depósito inválido");
		}
	}

	@Override
	public void saque(double valor) {
		if(valor <= saldo) {
			saldo -= valor;
			hora = LocalDateTime.now();
			String acao = "Saque de " + currencyFormat.format(valor) + " em " + hora.format(formatter);
			acoes.add(acao);
		}
		
	}

	@Override
	public void transferencia(double valor, Conta conta) {
		if(!banco.contas.isEmpty()) {
			for(Conta c : banco.contas) {
				if(c.numeroConta.equalsIgnoreCase(conta.numeroConta)) {
					if(valor <= saldo) {
						saldo -= valor;
						c.receber(valor);
						hora = LocalDateTime.now();
						String acao = "Tranferência de " + currencyFormat.format(valor) + " em " + hora.format(formatter);
						acoes.add(acao);
					} else {
						System.out.println("Valor para transferência inválido");
					}
				}
			}
		}
	}
	
	public void receber(double valor) {
		saldo += valor;
		hora = LocalDateTime.now();
		String acao = "Tranferência de " + currencyFormat.format(valor) + " recebida em " + hora.format(formatter);
		acoes.add(acao);
	}

	@Override
	public void imprimirSaldo() {
		System.out.println(this);
		System.out.println("Saldo atual: " + currencyFormat.format(saldo));
	}

	public Cliente getCliente() {
		return cliente;
	}

	public int getAgencia() {
		return agencia;
	}

	public String getNumeroConta() {
		return numeroConta;
	}

	public double getSaldo() {
		return saldo;
	}	
	
	public Banco getBanco() {
		return banco;
	}	
	
	public int getNumeroOperacao() {
		return numeroOperacao;
	}
	
	public void setNumeroOperacao(int num) {
		numeroOperacao = num;
	}
	
}
