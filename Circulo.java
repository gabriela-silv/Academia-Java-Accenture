package sef.module4.activity;

public class Circulo {
	
	  private double raio;
	  private double area;
	  private double perimetro;
	    
	  
	    public Circulo() {
	        this.raio = 0.0;
	        this.area = 0.0;
	        this.perimetro = 0.0;
	    }
	    
	    public Circulo(double raio) {
	        this.raio = raio;
	        this.area = 0.0;
	        this.perimetro = 0.0;
	    }
	    
	  
	    public void calcularArea() {
	        this.area = this.raio * this.raio * 3.14;
	        System.out.println("Área do círculo: " + this.area);
	    }
	    
	   
	    public void calcularPerimetro() {
	        this.perimetro = 2 * 3.14 * this.raio;
	        System.out.println("Perímetro do círculo: " + this.perimetro);
	    }

	    public static void main(String[] args) {
	       
	        Circulo novoCirculo = new Circulo();
	        
	       
	        novoCirculo.raio = 10;
	        
	        novoCirculo.calcularArea();
	        
	        novoCirculo.calcularPerimetro();
	        
	        novoCirculo.raio = 4;
	        
	        novoCirculo.calcularArea();
	        novoCirculo.calcularPerimetro();
	        
	        Circulo circulo1 = new Circulo(3);
	        circulo1.calcularArea();
	        circulo1.calcularPerimetro();
	        
	        Circulo circulo2 = new Circulo(5);
	        circulo2.calcularArea();
	        circulo2.calcularPerimetro();
	        
	        Circulo circulo3 = new Circulo(7);
	        circulo3.calcularArea();
	        circulo3.calcularPerimetro();
	        
	        Circulo circulo4 = new Circulo(2);
	        circulo4.calcularArea();
	        circulo4.calcularPerimetro();
	        
	        Circulo circulo5 = new Circulo(6);
	        circulo5.calcularArea();
	        circulo5.calcularPerimetro();
	    }
	}

