package banco;

public class Banco {
	
	private String nome = "Banco De Blumenau"; 
	private String cnpj = "00.123.121/0001-00"; 
	private int agencia;
	private Cliente clientes[] = new Cliente[1];
	
	
	public int getAgencia() {
		return agencia;
	}
	
	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
	
	public Cliente[] getClientes() {
		return clientes;
	}
	
	public Cliente getCliente(int numConta) {
		for (int i = 0; i < clientes.length; i++) {
			if (clientes[i].getConta().getNumConta() == numConta) {
				return clientes[i]; 
			}
		}
		return null; 
	}
	
	public String adicionaCliente(Cliente cliente) {
		clientes = expandeArray(clientes); 
		int i; 
		for (i = 0; i < clientes.length; i++) {
			if (clientes[i] == null) {
				clientes[i] = cliente;
				break;
			}
		}
		return "0000 - Operação Realizada com Sucesso."; 
	}

	private Cliente[] expandeArray(Cliente clientes[]) {
		Cliente novoCli[] = new Cliente[clientes.length + 1];
		for (int i = 0; i < clientes.length; i++) {
			novoCli[i] = clientes[i]; 
		}
		return novoCli; 
	}
}
