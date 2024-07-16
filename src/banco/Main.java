package banco;

public class Main {

	public static void main(String[] args) {
		Banco uchinaga = new Banco("Uchinaga");
		
		Cliente cliente1 = new Cliente("Aeri Uchinaga", "123.456.789-89");
		Cliente cliente2 = new Cliente("Ning Yizhuo", "852.456.789-89");
		
		ContaCorrente cc1 = new ContaCorrente(cliente1, 7419, "789456-9", uchinaga);
		ContaPoupanca cp1 = new ContaPoupanca(cliente1, 9634, "453685-7", uchinaga);
		ContaCorrente cc2 = new ContaCorrente(cliente2, 8747, "896522-9", uchinaga);
		
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
		uchinaga.imprimirContas();
		cliente1.imprimirContas();
		
	}
}