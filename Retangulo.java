package sef.module4.activity;

public class Retangulo {
	
	    private double lado1;
	    private double lado2;
	    private double area;
	    private double perimetro;

	    public Retangulo() {
	    }

	    public Retangulo(double lado1, double lado2) {
	        this.lado1 = lado1;
	        this.lado2 = lado2;
	    }

	    public void calcularArea() {
	        area = lado1 * lado2;
	        System.out.println("Área: " + area);
	    }

	    public void calcularPerimetro() {
	        perimetro = 2 * (lado1 + lado2);
	        System.out.println("Perímetro: " + perimetro);
	    }

	    public double getLado1() {
	        return lado1;
	    }

	    public void setLado1(double lado1) {
	        this.lado1 = lado1;
	    }

	    public double getLado2() {
	        return lado2;
	    }

	    public void setLado2(double lado2) {
	        this.lado2 = lado2;
	    }

	    public static void main(String[] args) {
	        Retangulo novoRetangulo = new Retangulo();
	        novoRetangulo.setLado1(10);
	        novoRetangulo.setLado2(5);
	        novoRetangulo.calcularArea();
	        novoRetangulo.calcularPerimetro();

	        novoRetangulo.setLado2(7);
	        novoRetangulo.calcularArea();
	        novoRetangulo.calcularPerimetro();

	        Retangulo retangulo1 = new Retangulo(8, 4);
	        retangulo1.calcularArea();
	        retangulo1.calcularPerimetro();

	        Retangulo retangulo2 = new Retangulo(6, 3);
	        retangulo2.calcularArea();
	        retangulo2.calcularPerimetro();

	        Retangulo retangulo3 = new Retangulo(5, 2);
	        retangulo3.calcularArea();
	        retangulo3.calcularPerimetro();

	        Retangulo retangulo4 = new Retangulo(9, 6);
	        retangulo4.calcularArea();
	        retangulo4.calcularPerimetro();

	        Retangulo retangulo5 = new Retangulo(7, 3.5);
	        retangulo5.calcularArea();
	        retangulo5.calcularPerimetro();
	    }
	}

