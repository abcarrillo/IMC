package Vista;

import Modelo.IMC;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class CalcularIMC extends Application {
	
	private TextField pesoText;
	private TextField alturaText;
	private Label IMCText;
	private Label textoInfo;
	private IMC imc = new IMC();
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		
		
		pesoText = new TextField();
		pesoText.setPrefColumnCount(4);
		pesoText.textProperty().addListener(event->{
			if(pesoText.textProperty().get() != "") {
				imc.setPeso(Double.parseDouble(pesoText.textProperty().get()));
				
				double indice = imc.calcularIndice();
				String texto = "";
				IMCText.setText("IMC: " + indice);
				if(indice < 18.5) {
					texto = "Bajo peso";
				}else if (18.5 <= indice && indice < 25) {
					texto = "Peso normal";
				}else if(25<= indice && indice < 30){
					texto = "Sobrepeso";
				}else {
					texto = "Obesidad";
				}
				textoInfo.setText(texto);
			}
		});
		
		alturaText = new TextField();
		alturaText.setPrefColumnCount(4);
		alturaText.textProperty().addListener(event->{
			if(alturaText.textProperty().get() != "") {
				imc.setAltura(Double.parseDouble(alturaText.textProperty().get()));

				double indice = imc.calcularIndice();
				String texto = "";
				IMCText.setText("IMC: " + indice);
				if(indice < 18.5) {
					texto = "Bajo peso";
				}else if (18.5 <= indice && indice < 25) {
					texto = "Peso normal";
				}else if(25<= indice && indice < 30){
					texto = "Sobrepeso";
				}else {
					texto = "Obesidad";
				}
				textoInfo.setText(texto);
			}
		});
		IMCText = new Label("IMC: " + imc.calcularIndice());
		textoInfo = new Label("");
		
		
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
