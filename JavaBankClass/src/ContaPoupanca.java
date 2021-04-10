public class ContaPoupanca extends Conta {
	public double bonus = 10;

	@Override
	void exibirDados() {
		System.out.println("Conta Poupan�a");
		super.exibirDados();
	}

	@Override
	public void exibirStatusConta() {
		// TODO Auto-generated method stub
	 if (getContaAtiva() ) {
		 System.out.println("Conta Poupan�a Ativa");
	 }else {
		 System.out.println("Conta Poupan�a Inativa");
	 }
	}
	
	@Override
	void depositar(double valor) {			
		valor = valor + bonus;	
		super.depositar(valor);		
		}
	
}
