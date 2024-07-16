package banco;

public interface IConta {
	void deposito(double valor);
	void saque(double valor);
	void transferencia(double valor, Conta conta);
	void imprimirSaldo();
}
