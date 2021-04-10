public class ContaCorrente extends Conta {
	public double desconto = 10;

	// Desafio - Tentar resolver o bug do sacar com desconto
	// Mandar no privado para o professor!!
	@Override
	boolean sacar(double valor) {
		if (validaValor(valor)) {
			valor = valor + desconto;
			if (super.sacar(valor)) {
				return true;
			} else {
				return false;
			}

		} else {
			System.out.println("Valor Inválido");
			return false;
		}
	}

	@Override
	void exibirDados() {
		System.out.println("Conta Corrente");
		super.exibirDados();

	}
	
	@Override
	public void exibirStatusConta() {
		// TODO Auto-generated method stub
	 if (getContaAtiva() ) {
		 System.out.println("Conta Corrente Ativa");
	 }else {
		 System.out.println("Conta Corrente Inativa");
	 }
	}
	
}
