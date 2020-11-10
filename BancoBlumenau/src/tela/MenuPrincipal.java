package tela;

import java.util.Scanner;

import banco.*;

public class MenuPrincipal {

	public static void main(String[] args) {
		
		char menu = ' '; 
		Scanner sc = new Scanner(System.in); 
		
		Banco bancoBlumenau = new Banco(); 
		
		while(menu != 'f') {
			System.out.println("-- Menu Principal --");
			System.out.println("   'A'brir Conta"    );
			System.out.println("    'D'epositar     ");
			System.out.println("      'S'acar       ");
			System.out.println(" 'C'onsultar Saldo  ");
			System.out.println("      'F'im         ");
			menu = sc.next().toLowerCase().charAt(0);
			
			switch (menu) {
			//case 'C':
			case 'a': 
				System.out.println("Nome Cliente: ");
				String nome = sc.next();
				System.out.println("CPF: ");
				String cpf = sc.next();
				System.out.println("RG: ");
				String rg = sc.next();
				System.out.println("Endereço: ");
				String endereco = sc.next(); 
				
				Cliente cliente = new Cliente(nome, cpf, rg, endereco, null);
				
				System.out.println("Numero da nova Conta: ");
				int numConta = sc.nextInt();
				System.out.println("Tipo de Conta '1' - CC ou '2' - CP");
				int tipo = sc.nextInt(); 
				
				Conta conta = new Conta(numConta, tipo, 123456, bancoBlumenau);
				cliente.setConta(conta);
				bancoBlumenau.adicionaCliente(cliente); 
				
				break;
				
			case 'd': 
				System.out.println("Numero da Conta: ");
				numConta = sc.nextInt();
				
				
				System.out.println("Valor Deposito: ");
				double valorDeposito = sc.nextDouble();
				
				String msnRetorno = bancoBlumenau.getCliente(numConta).getConta().depositar(valorDeposito); 
				System.out.println(msnRetorno);
				
				break;			

			case 's': 
				
				System.out.println("Número da Conta: ");
				numConta = sc.nextInt(); 
				
				System.out.println("Valor do Saque:");
				double valorSaque = sc.nextDouble(); 
				
				msnRetorno = bancoBlumenau.getCliente(numConta).getConta().sacar(valorSaque); 
				System.out.println(msnRetorno);
				
				
				break;
				
			case 'c':
				
				System.out.println("Número da Conta: ");
				numConta = sc.nextInt();
			
				
				double saldo = bancoBlumenau.getCliente(numConta).getConta().getSaldo();
				
				System.out.println("Saldo: " + saldo);
				
			default:
				System.out.println("Opção Inválida!");
				break;
			}
			
		}
		
		
	}

}
