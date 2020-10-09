package Modelo;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class IMC {
	private DoubleProperty altura;
	private DoubleProperty peso;
	private DoubleProperty indice;
	
	public double calcularIndice() {
		return this.getPeso() / Math.pow(this.getAltura()/100, 2);
	}

	public final DoubleProperty alturaProperty() {
		return this.altura;
	}

	public final double getAltura() {
		return this.alturaProperty().get();
	}

	public final void setAltura(double altura) {
		this.alturaProperty().set(altura);
	}

	public final DoubleProperty pesoProperty() {
		return this.peso;
	}

	public final double getPeso() {
		return this.pesoProperty().get();
	}

	public final void setPeso(double peso) {
		this.pesoProperty().set(peso);
	}
	
	public IMC() {
		this.altura = new SimpleDoubleProperty();
		this.peso = new SimpleDoubleProperty();
	}

}
