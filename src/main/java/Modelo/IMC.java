package Modelo;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class IMC {
	private SimpleDoubleProperty altura;
	private SimpleDoubleProperty peso;
	private SimpleDoubleProperty indice;
	
	
	public final SimpleDoubleProperty indiceProperty() {
		return this.indice;
	}

	public final SimpleDoubleProperty alturaProperty() {
		return this.altura;
	}

	public final double getAltura() {
		return this.alturaProperty().get();
	}

	public final void setAltura(double altura) {
		this.alturaProperty().set(altura);
	}

	public final SimpleDoubleProperty pesoProperty() {
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
		this.indice = new SimpleDoubleProperty();
		
		indice.bind(pesoProperty().divide( (alturaProperty().divide(100).multiply(alturaProperty().divide(100))) ));
	}

}
