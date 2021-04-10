
public abstract class Conta {
	private Pessoa pessoa; // Será preciso criar uma pessoa antes da conta.
	private int numero;
	private String agencia;
	private double limite;
	private double saldo;
	private boolean contaAtiva = false;

	public abstract void exibirStatusConta();

	void exibirDados() {
		System.out.println("Numero Conta " + this.getNumero());
		System.out.println("Numero Agencia " + this.getAgencia());
		System.out.println("Nome " + this.getPessoa().getNome());
		System.out.println("CPF " + this.getPessoa().getCPF());

	}

	void exibirSaldo() {
		System.out.println("Seu saldo é: " + this.saldo);
	}

	void depositar(double valor) {
		if (validaValor(valor)) {
			this.saldo = saldo + valor;
		} else {
			System.err.println("Impossivel depositar");
		}

	}

	boolean validaValor(double valor) {
		if (valor > 0) {
			return true;
		} else {
			return false;
		}
	}

	boolean sacar(double valor) {
		if (valor <= this.saldo && validaValor(valor)) {
			this.saldo = saldo - valor;

			return true;
		} else if (valor <= 0) {
			System.out.println("Valor inválido");
			return false;
		} else {
			System.out.println("Saldo insuficiente");
			return false;
		}
	}

	void transferir(Conta contaDestino, double valor) {
		if (this.sacar(valor)) {
			contaDestino.depositar(valor);
		}
	}

	void abrirConta(Pessoa novapessoa, String agencia, int numero) {

		if (this.getContaAtiva()) {
			System.out.println("conta já está ativa");
			setPessoa(novapessoa);
			setAgencia(agencia);
			setNumero(numero);
			setSaldo(0);
			this.setContaAtiva(true);
			System.out.println("Conta Aberta com sucesso");
		} else {
			setPessoa(novapessoa);
			setAgencia(agencia);
			setNumero(numero);
			setSaldo(0);
			this.setContaAtiva(true);
			System.out.println("Conta Aberta com sucesso");
		}
	}

	void fecharConta() { // só poderá fechar uma conta se o valor for = 0;
		if (this.getContaAtiva()) {
			if (this.getSaldo() > 0) {
				System.out.println("Conta não pode ser fechada porque ainda tem saldo!");
				exibirSaldo();
		} else {
				this.setContaAtiva(false);
				System.out.println("Conta fechada com sucesso!");
			}
		} else {
			System.out.println("Conta já está inativa");
		}
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return "Conta [pessoa=" + pessoa + ", numero=" + numero + ", agencia=" + agencia + ", limite=" + limite
				+ ", saldo=" + saldo + "]";
	}

	public boolean getContaAtiva() {
		return contaAtiva;
	}

	public void setContaAtiva(boolean contaAtiva) {
		this.contaAtiva = contaAtiva;
	}

}
