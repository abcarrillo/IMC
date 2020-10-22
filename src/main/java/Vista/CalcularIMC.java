package Vista;

import Modelo.IMC;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;



public class CalcularIMC extends Application {
	
	private TextField pesoText;
	private TextField alturaText;
	private Label IMCText;
	private Label textoInfo;
	private IMC imc = new IMC();
	StringConverter<Number> converter = new NumberStringConverter();
	SimpleStringProperty resultado = new SimpleStringProperty();
	
	private SimpleStringProperty darInfo() {
		double indice = imc.indiceProperty().get();
		String texto = "";
		
		if(indice < 18.5) {
			texto = "Bajo peso";
		}else if (18.5 <= indice && indice < 25) {
			texto = "Peso normal";
		}else if(25<= indice && indice < 30){
			texto = "Sobrepeso";
		}else {
			texto = "Obesidad";
		}
		resultado.set(texto);
		return resultado;
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		
		pesoText = new TextField();
		pesoText.setPrefColumnCount(4);
		pesoText.textProperty().bindBidirectional(imc.pesoProperty(), converter);
		
		alturaText = new TextField();
		alturaText.setPrefColumnCount(4);
		alturaText.textProperty().bindBidirectional(imc.alturaProperty(), converter);
		
		
		IMCText = new Label();
		IMCText.textProperty().bind(imc.indiceProperty().asString());
		
		
		textoInfo = new Label("Aqui deberia aparecer info");
		imc.indiceProperty().addListener(listener->{
			double indice = imc.indiceProperty().get();
			String texto = "";
			if(indice < 18.5) {
				texto = "Peso bajo";
			}else if(indice >= 18.5 && indice < 25) {
				texto = "normal";
			}else if(indice >= 25 && indice < 30){
				texto = "Sobrepeso";
			}else {
				texto = "Obesidad";
			}
			textoInfo.setText(texto);
		});
		
		
		
		
		
		
		HBox alturaBox = new HBox();
		Label textoLabel = new Label("Altura: ");
		Label texto2Label = new Label("cm");
		alturaBox.setAlignment(Pos.BASELINE_CENTER);
		alturaBox.setSpacing(5);
		alturaBox.getChildren().addAll(textoLabel, alturaText, texto2Label);
		
		HBox pesoBox = new HBox();
		Label texto3Label = new Label("Peso: ");
		Label texto4Label = new Label("kg");
		pesoBox.setAlignment(Pos.BASELINE_CENTER);
		pesoBox.setSpacing(5);
		pesoBox.getChildren().addAll(texto3Label, pesoText, texto4Label);
		
		HBox imcBox = new HBox();
		imcBox.setAlignment(Pos.BASELINE_CENTER);
		imcBox.setSpacing(5);
		imcBox.getChildren().addAll(IMCText);
		
		HBox infoBox = new HBox();
		infoBox.setAlignment(Pos.BASELINE_CENTER);
		infoBox.setSpacing(5);
		infoBox.getChildren().addAll(textoInfo);
		
		VBox root = new VBox();
		root.setSpacing(5);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(pesoBox, alturaBox, imcBox, infoBox);

		Scene escena = new Scene(root, 320, 200);
		
		primaryStage.setScene(escena);
		primaryStage.setTitle("Calcular IMC");
		primaryStage.show();
	}
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
