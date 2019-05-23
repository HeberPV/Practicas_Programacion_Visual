package application;
	
import java.util.Base64;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;


public class Encriptador extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane grid = new GridPane();
			grid.setAlignment(Pos.CENTER);
			grid.setHgap(10);
			grid.setVgap(10);
			grid.setPadding(new Insets(5,5,5,5));
			
			Scene scene = new Scene(grid,250,100);
			
			Label etiqueta = new Label("Palabra:");
			grid.add(etiqueta, 0, 0);
			
			TextField palabra = new TextField();
			grid.add(palabra, 1, 0);
			
			Button encripta = new Button("Encriptar");
			grid.add(encripta, 0, 1);
			
			Button desencripta = new Button("desencripta");
			grid.add(desencripta, 1, 1);
			
			encripta.setOnAction(new EventHandler<ActionEvent>() {
				
					@Override
					public void handle(ActionEvent event) {
						byte[] palabraE = palabra.getText().getBytes();
						String palabraEncriptada = Base64.getEncoder().encodeToString(palabraE);
						palabra.setText(palabraEncriptada);
						try {
							
						}catch(Exception sn) {
							System.out.println("No sea meco :v");
						}
					}
					
				} );
			
			desencripta.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent event) {
					byte[] palabraE = palabra.getText().getBytes();
					byte[] palabraDes = Base64.getDecoder().decode(palabraE);
					String palabraDesencriptada = new String(palabraDes);
					palabra.setText(palabraDesencriptada);
					try {
						
					}catch(Exception sn) {
						System.out.println("No sea meco :v");
					}
				}
				
			} );
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
