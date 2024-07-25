package sef.module4.activity;


public class PrincipalContaCorrente {
	public static void main(String[] args) {
        
        Cliente cliente1 = new Cliente("João", "123.456.789-00", "Silva");
        Cliente cliente2 = new Cliente("Maria", "987.654.321-00", "Santos");

        
        ContaCorrente conta1 = new ContaCorrente(1, "Conta Corrente João", cliente1);
        ContaCorrente conta2 = new ContaCorrente(2, "Conta Corrente Maria", cliente2);

       
        System.out.println("Saldo inicial da Conta 1: R$" + conta1.getSaldo());
        System.out.println("Saldo inicial da Conta 2: R$" + conta2.getSaldo());

     
        conta1.Depositar(1000);
        System.out.println("Novo saldo da Conta 1 após depósito: R$" + conta1.getSaldo());

       
        double valorTransferencia = 500;
        System.out.println("\nTransferência de Conta 1 para Conta 2:");
        System.out.println("Saldo inicial da Conta 1: R$" + conta1.getSaldo());
        System.out.println("Saldo inicial da Conta 2: R$" + conta2.getSaldo());
        conta1.Transferir(valorTransferencia, conta2);
        System.out.println("Novo saldo da Conta 1 após transferência: R$" + conta1.getSaldo());
        System.out.println("Novo saldo da Conta 2 após transferência: R$" + conta2.getSaldo());

      
        valorTransferencia = 2000;
        System.out.println("\nTentativa de transferência de Conta 2 para Conta 1:");
        System.out.println("Saldo inicial da Conta 1: R$" + conta1.getSaldo());
        System.out.println("Saldo inicial da Conta 2: R$" + conta2.getSaldo());
        conta2.Transferir(valorTransferencia, conta1);
        System.out.println("Novo saldo da Conta 1 após tentativa de transferência: R$" + conta1.getSaldo());
        System.out.println("Novo saldo da Conta 2 após tentativa de transferência: R$" + conta2.getSaldo());

      
        System.out.println("\nCliente da Conta 1: " + conta1.getCliente().getNome() + " " + conta1.getCliente().getSobrenome());
        
	}
	
	public static void runGarbageCollector() {
        Runtime.getRuntime().runFinalization();
        Runtime.getRuntime().gc();
    }

	
}

