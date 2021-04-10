public class ContaPoupanca extends Conta {
	public double bonus = 10;

	@Override
	void exibirDados() {
		System.out.println("Conta Poupança");
		super.exibirDados();
	}

	@Override
	public void exibirStatusConta() {
		// TODO Auto-generated method stub
	 if (getContaAtiva() ) {
		 System.out.println("Conta Poupança Ativa");
	 }else {
		 System.out.println("Conta Poupança Inativa");
	 }
	}
	
	@Override
	void depositar(double valor) {			
		valor = valor + bonus;	
		super.depositar(valor);		
		}
	
}
