import java.util.Scanner;

public class ContaExemplo {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		double valor;
		int numero;
		String agencia;

  	ContaCorrente cc1 = new ContaCorrente();
		ContaPoupanca cp1 = new ContaPoupanca();

		int opcao;
		do {
			System.out.println("");
			System.out.println("JAVABANK MENU");
			System.out.println("[01] - ABRIR CONTA CORRENTE");
			System.out.println("[02] - ABRIR CONTA POUPANÇA");
			System.out.println("[03] - DEPOSITO");
			System.out.println("[04] - SAQUE CONTA CORRENTE");
			System.out.println("[05] - SAQUE CONTA POUPANÇA");
			System.out.println("[06] - TRANSFERÊNCIA");
			System.out.println("[07] - SALDO");
			System.out.println("[08] - EXIBIR DADOS");
			System.out.println("[09] - FECHAR CONTA CORRENTE");
			System.out.println("[10] - FECHAR CONTA POUPANÇA");
			System.out.println("[0] - SAIR");
			System.out.print("DIGITE SUA OPÇÃO: ");
			System.out.println("");
			opcao = entrada.nextInt();

			switch (opcao) {

			case 1:
				System.out.println("ABRINDO CONTA CORRENTE");
				Pessoa p1 = new Pessoa();
				System.out.println("DIGITE SEU NOME: ");
				p1.setNome(entrada.next());
				System.out.println("DIGITE SEU CPF: ");
				p1.setCPF(entrada.next());
				System.out.println("DIGITE Agencia: ");
				agencia = entrada.next();
				System.out.println("DIGITE Número da Conta: ");
				numero = entrada.nextInt();
				cc1.abrirConta(p1, agencia, numero);
				if (cc1.getContaAtiva() == true) {
					System.out.println("VALOR PARA DEPÓSITO INICIAL: ");
					valor = entrada.nextDouble();
					cc1.depositar(valor);
				}
				break;

			case 2:
				System.out.println("ABRINDO CONTA POUPANÇA");
				Pessoa p2 = new Pessoa();
				System.out.println("DIGITE SEU NOME: ");
				p2.setNome(entrada.next());
				System.out.println("DIGITE SEU CPF: ");
				p2.setCPF(entrada.next());
				System.out.println("DIGITE Agencia: ");
				agencia = entrada.next();
				System.out.println("DIGITE Número da Conta: ");
				numero = entrada.nextInt();
				cp1.abrirConta(p2, agencia, numero);
				if (cp1.getContaAtiva()) {
					System.out.println("VALOR PARA DEPÓSITO INICIAL: ");
					valor = entrada.nextDouble();
					cp1.depositar(valor);
				}
				break;

			case 3:
				if (cc1.getContaAtiva()) {
					System.out.println("VALOR PARA DEPÓSITO : ");
					valor = entrada.nextDouble();
					cc1.depositar(valor);
				} else {
					System.out.println("Conta Corrente inativa");
				}
				break;

			case 4:
				if (cc1.getContaAtiva()) {
					System.out.println("VALOR PARA SACAR : ");
					valor = entrada.nextDouble();
					cc1.sacar(valor);
				} else {
					cc1.exibirStatusConta();
				}
				break;
			case 5:
				if (cp1.getContaAtiva()) {
					System.out.println("VALOR PARA SACAR : ");
					valor = entrada.nextDouble();
					cp1.sacar(valor);
				} else {
					cp1.exibirStatusConta();
				}
				break;


			case 6:
				if ((cc1.getContaAtiva())&& (cp1.getContaAtiva() == true)){
					System.out.println("VALOR PARA TRANSFERENCIA : ");
					valor = entrada.nextDouble();
					cc1.transferir(cp1, valor);
				} else {
					cc1.exibirStatusConta();
					cp1.exibirStatusConta();
				}

				break;

			case 7:
				if (cc1.getContaAtiva() ) {
					System.out.println("CONTA CORRENTE");
					cc1.exibirSaldo();
					System.out.println("");
				} else {
					cc1.exibirStatusConta();
				}
				if (cp1.getContaAtiva() ) {
					System.out.println("CONTA POUPANÇA");
					cp1.exibirSaldo();
					System.out.println("");
				} else {
					cp1.exibirStatusConta();
				}
				break;

			case 8:
				if (cc1.getContaAtiva() ) {
					cc1.exibirDados();
				} else {
					cc1.exibirStatusConta();
				}
				if (cp1.getContaAtiva() ) {
					cp1.exibirDados();
				} else {
					cp1.exibirStatusConta();
				}
				break;
			case 9:
				if (cc1.getContaAtiva() ) {
					cc1.fecharConta();
				} else {
					cc1.exibirStatusConta();
				}
				break;
			case 10:
				if (cp1.getContaAtiva() ) {
					cp1.fecharConta();
				} else {
					cp1.exibirStatusConta();
				}
				break;
			case 0:
				System.out.println("O JAVABANK AGRADECE A SUA PREFERÊNCIA.");
				break;
			default:
				System.out.print("Você digitou uma opção inválida: ");

			}
		} while (opcao != 0);

	}

};
