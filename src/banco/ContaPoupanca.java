package banco;

public class ContaPoupanca extends Conta {

	public ContaPoupanca(Cliente cliente, int agencia, String numeroConta, Banco banco) {
		super(cliente, agencia, numeroConta, banco);
		setNumeroOperacao(112);
	}
	
	public void imprimirExtrato() {
		System.out.println("+----------------+ Extrato +----------------+");
		System.out.println(getCliente());
		System.out.println(this + "\r\n");
		for(String a : this.acoes) {
			System.out.println(a);
		}
		System.out.println("+-------------------------------------------+");
	}
	
	@Override
	public String toString() {
		return "Conta Poupança: " + getAgencia() + " " +  getNumeroConta() + " " + getNumeroConta();
	}

}
