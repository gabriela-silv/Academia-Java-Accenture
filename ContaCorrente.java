package sef.module4.activity;

import java.sql.Date;

public class ContaCorrente {
	    private int numero;
	    private String nome;
	    private double saldo;
	    private Date data;
	    private Cliente cliente;

	    
	    public ContaCorrente(int numero, String nome, Cliente cliente) {
	        this.numero = numero;
	        this.nome = nome;
	        this.saldo = 0.0; 
	        this.data = new Date(numero); 
	        this.cliente = cliente;
	    }

	    
	    public void Depositar(double valor) {
	        if (valor > 0) {
	            saldo += valor;
	            System.out.println("Depósito de R$" + valor + " realizado com sucesso.");
	        } else {
	            System.out.println("Valor inválido para depósito.");
	        }
	    }

	    public void Sacar(double valor) {
	        if (valor > 0 && valor <= saldo) {
	            saldo -= valor;
	            System.out.println("Saque de R$" + valor + " realizado com sucesso.");
	        } else {
	            System.out.println("Saldo insuficiente para saque.");
	        }
	    }

	    public void ExibirExtrato() {
	        System.out.println("Extrato da Conta: ");
	        System.out.println("Cliente: " + cliente.getNome() + " " + cliente.getSobrenome());
	        System.out.println("CPF: " + cliente.getCpf());
	        System.out.println("Número da Conta: " + numero);
	        System.out.println("Saldo Atual: R$" + saldo);
	        System.out.println("Data de Abertura: " + data);
	    }
	    public void Transferir(double valor, ContaCorrente contaDestino) {
	        if (valor > 0 && valor <= saldo) {
	            saldo -= valor;
	            contaDestino.Depositar(valor);
	            System.out.println("Transferência de R$" + valor + " realizada para a conta de " + 
	                               contaDestino.cliente.getNome() + " " + contaDestino.cliente.getSobrenome());
	        } else {
	            System.out.println("Saldo insuficiente para transferência.");
	        }
	    }


	    public int getNumero() {
	        return numero;
	    }

	    public void setNumero(int numero) {
	        this.numero = numero;
	    }

	    public String getNome() {
	        return nome;
	    }

	    public void setNome(String nome) {
	        this.nome = nome;
	    }

	    public double getSaldo() {
	        return saldo;
	    }

	    public void setSaldo(double saldo) {
	        this.saldo = saldo;
	    }

	    public Date getData() {
	        return data;
	    }

	    public void setData(Date data) {
	        this.data = data;
	    }

	    public Cliente getCliente() {
	        return cliente;
	    }

	    public void setCliente(Cliente cliente) {
	        this.cliente = cliente;
	    }
}


