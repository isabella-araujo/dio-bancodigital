package banco;

public class Main {

	public static void main(String[] args) {
		Banco banco = new Banco("Banco 01");
		
		Cliente cliente1 = new Cliente("Cliente 01", "123.456.789-89");
		Cliente cliente2 = new Cliente("Cliente 02", "852.456.789-89");
		
		ContaCorrente cc1 = new ContaCorrente(cliente1, 7419, "789456-9", banco);
		ContaPoupanca cp1 = new ContaPoupanca(cliente1, 9634, "453685-7", banco);
		ContaCorrente cc2 = new ContaCorrente(cliente2, 8747, "896522-9", banco);
		
		cc1.deposito(100);
		cc1.transferencia(35, cp1);
		cc1.saque(10);
		cc1.transferencia(50, cc2);
		
		cc1.imprimirExtrato();
		System.out.println(" ");
		cc2.imprimirExtrato();
		System.out.println(" ");
		cc1.imprimirSaldo();
		
		System.out.println(" ");
		banco.imprimirContas();
		cliente1.imprimirContas();
		
	}
}