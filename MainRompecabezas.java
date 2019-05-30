package application;
	
import java.util.Base64;
import java.util.Random;

import javax.swing.JButton;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;


public class MainRompecabezas extends Application {
	Image goku = new Image("image/goku.jpg");
	ImageView img1 = new ImageView(goku);
	Image luffy = new Image("image/luffy.jpg");
	ImageView img2 = new ImageView(luffy);
	Image naruto = new Image("image/naruto.jpg");
	ImageView img3 = new ImageView(naruto);
	
	ImageView seleccionado;
	String seleccionadoId;
	
	ImageView[][] tablero = new ImageView[4][3];
	ImageView[][] problema = new ImageView[4][3];
	ImageView[][] resultado = new ImageView[4][3];
	
	ImageView pos1 = new ImageView();
	ImageView pos2 = new ImageView();
	ImageView pos3 = new ImageView();
	ImageView pos4 = new ImageView();
	ImageView pos5 = new ImageView();
	ImageView pos6 = new ImageView();
	ImageView pos7 = new ImageView();
	ImageView pos8 = new ImageView();
	ImageView pos9 = new ImageView();
	ImageView pos10 = new ImageView();
	ImageView pos11 = new ImageView();
	ImageView pos12 = new ImageView();
	
	ImageView pieza1 = new ImageView();
	ImageView pieza2 = new ImageView();
	ImageView pieza3 = new ImageView();
	ImageView pieza4 = new ImageView();
	ImageView pieza5 = new ImageView();
	ImageView pieza6 = new ImageView();
	ImageView pieza7 = new ImageView();
	ImageView pieza8 = new ImageView();
	ImageView pieza9 = new ImageView();
	ImageView pieza10 = new ImageView();
	ImageView pieza11 = new ImageView();
	ImageView pieza12 = new ImageView();
	
	ImageView piezaAgarrada = new ImageView();
	Boolean agarroPieza=false;
	Boolean p1c=false;
	Boolean p2c=false;
	Boolean p3c=false;
	Boolean p4c=false;
	Boolean p5c=false;
	Boolean p6c=false;
	Boolean p7c=false;
	Boolean p8c=false;
	Boolean p9c=false;
	Boolean p10c=false;
	Boolean p11c=false;
	Boolean p12c=false;
	
	int piezasColocadas;
	
	Image marcoPos = new Image("image/marcoPos.jpg");
	
	Stage primaryStage;
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage=primaryStage;
		stageMenu();
	}
	
	public void stageMenu() {
		Button startGame = new Button("Iniciar Juego");
		
		try {
			GridPane grid1 = new GridPane();
			
			grid1.setHgap(10);
			grid1.setVgap(10);
			grid1.setPadding(new Insets(2,2,2,2));
			
			Scene scene = new Scene(grid1,1130,350);
			primaryStage.setTitle("Rompecabezas: Menu");
			primaryStage.setResizable(false);
			
			Label titulo = new Label("Selecciona que imagen quieres armar");
			titulo.setFont(Font.font("Veredana", FontWeight.BOLD, FontPosture.ITALIC, 20));
			titulo.setTextFill(Color.DARKRED);
			grid1.add(titulo, 2, 0);
			
			startGame.setPrefWidth(360);
			startGame.setVisible(false);
			startGame.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent event) {
					stageGame();
					primaryStage.close();
				}
			} );
			grid1.add(startGame, 2, 2);
			
			img1.setFitWidth(360);
			img1.setFitHeight(240);
			img1.setId("goku");
			img1.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
				
				@Override
				public void handle(MouseEvent event) {					
					startGame.setVisible(true);
					seleccionado=img1;
					seleccionadoId=img1.getId();
					img1.setOpacity(.3);
					img2.setOpacity(1);
					img3.setOpacity(1);
				}
				
			});
			
			grid1.add(img1, 1, 1);
			
			
			img2.setFitWidth(360);
			img2.setFitHeight(240);
			img2.setId("luffy");
			
			img2.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
				
				@Override
				public void handle(MouseEvent event) {					
					startGame.setVisible(true);
					seleccionado=img2;
					seleccionadoId=img2.getId();
					img1.setOpacity(1);
					img2.setOpacity(.3);
					img3.setOpacity(1);
				}
				
			});
			
			grid1.add(img2,2, 1);
			
			
			img3.setFitWidth(360);
			img3.setFitHeight(240);
			img3.setId("naruto");
			
			img3.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
				
				@Override
				public void handle(MouseEvent event) {					
					startGame.setVisible(true);
					seleccionado=img3;
					seleccionadoId=img3.getId();
					img1.setOpacity(1);
					img2.setOpacity(1);
					img3.setOpacity(.3);
				}
				
			});
			
			grid1.add(img3, 3, 1);
			
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void stageGame() {
		piezasColocadas=0;
		
        Stage stage = new Stage();
        HBox hbox = new HBox();
        
        GridPane grid1 = new GridPane();
		grid1.setHgap(0);
		grid1.setVgap(0);
		grid1.setPadding(new Insets(10,10,10,10));
		
		GridPane grid2 = new GridPane();
		grid2.setHgap(10);
		grid2.setVgap(10);
		grid2.setPadding(new Insets(10,10,10,10));
		
		Button reiniciar=new Button("Reiniciar");
		grid2.add(reiniciar, 0, 3);
		reiniciar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				stage.close();
				Platform.runLater(() -> {
					try {
						new MainRompecabezas().start(new Stage());
					}catch(Exception e) {
						e.printStackTrace();
					}
				});
			}
		} );
		
		Button termina = new Button("Terminar todo");
		termina.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				stage.close();
			}
		} );
		grid2.add(termina, 1, 3,2,1);

	
		resultado=respuesta();
		

		problema=desordenado();
	
		tablero=pocisiones();
		//AGREGA LAS POSICIONES
		pos1=tablero[0][0];
		grid1.add(pos1, 0, 0);
		pos2=tablero[0][1];
		grid1.add(pos2, 0, 1);
		pos3=tablero[0][2];
		grid1.add(pos3, 0, 2);
		pos4=tablero[1][0];
		grid1.add(pos4, 1, 0);
		pos5=tablero[1][1];
		grid1.add(pos5, 1, 1);
		pos6=tablero[1][2];
		grid1.add(pos6, 1, 2);
		pos7=tablero[2][0];
		grid1.add(pos7, 2, 0);
		pos8=tablero[2][1];
		grid1.add(pos8, 2, 1);
		pos9=tablero[2][2];
		grid1.add(pos9, 2, 2);
		pos10=tablero[3][0];
		grid1.add(pos10, 3, 0);
		pos11=tablero[3][1];
		grid1.add(pos11, 3, 1);
		pos12=tablero[3][2];
		grid1.add(pos12, 3, 2);
		
		//AGREGA LAS PIEZAS REVUELTAS
		
		pieza1=problema[0][0];
		pieza1.setId(problema[0][0].getId());
		grid2.add(pieza1, 0, 0);
		pieza2=problema[0][1];
		pieza2.setId(problema[0][1].getId());
		grid2.add(pieza2, 0, 1);
		pieza3=problema[0][2];
		pieza3.setId(problema[0][2].getId());
		grid2.add(pieza3, 0, 2);
		pieza4=problema[1][0];
		pieza4.setId(problema[1][0].getId());
		grid2.add(pieza4, 1, 0);
		pieza5=problema[1][1];
		pieza5.setId(problema[1][1].getId());
		grid2.add(pieza5, 1, 1);
		pieza6=problema[1][2];
		pieza6.setId(problema[1][2].getId());
		grid2.add(pieza6, 1, 2);
		pieza7=problema[2][0];
		pieza7.setId(problema[2][0].getId());
		grid2.add(pieza7, 2, 0);
		pieza8=problema[2][1];
		pieza8.setId(problema[2][1].getId());
		grid2.add(pieza8, 2, 1);
		pieza9=problema[2][2];
		pieza9.setId(problema[2][2].getId());
		grid2.add(pieza9, 2, 2);
		pieza10=problema[3][0];
		pieza10.setId(problema[3][0].getId());
		grid2.add(pieza10, 3, 0);
		pieza11=problema[3][1];
		pieza11.setId(problema[3][1].getId());
		grid2.add(pieza11, 3, 1);
		pieza12=problema[3][2];
		pieza12.setId(problema[3][2].getId());
		grid2.add(pieza12, 3, 2);
		
		//AÑADE ACCIONES
		
		pieza1.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {					
				if(agarroPieza==false) {
					agarroPieza=true;
					piezaAgarrada=pieza1;
					piezaAgarrada.setId(pieza1.getId());
					pieza1.setOpacity(.3);
					pieza1.setDisable(true);
				}
			}	
		});
		pieza2.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {					
				if(agarroPieza==false) {
					agarroPieza=true;
					piezaAgarrada=pieza2;
					pieza2.setOpacity(.3);
					pieza2.setDisable(true);
				}
			}	
		});
		pieza3.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {					
				if(agarroPieza==false) {
					agarroPieza=true;
					piezaAgarrada=pieza3;
					pieza3.setOpacity(.3);
					pieza3.setDisable(true);
				}
			}	
		});
		pieza4.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {					
				if(agarroPieza==false) {
					agarroPieza=true;
					piezaAgarrada=pieza4;
					pieza4.setOpacity(.3);
					pieza4.setDisable(true);
				}
			}	
		});
		pieza5.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {					
				if(agarroPieza==false) {
					agarroPieza=true;
					piezaAgarrada=pieza5;
					pieza5.setOpacity(.3);
					pieza5.setDisable(true);
				}
			}	
		});
		pieza6.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {					
				if(agarroPieza==false) {
					agarroPieza=true;
					piezaAgarrada=pieza6;
					pieza6.setOpacity(.3);
					pieza6.setDisable(true);
				}
			}	
		});
		pieza7.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {					
				if(agarroPieza==false) {
					agarroPieza=true;
					piezaAgarrada=pieza7;
					pieza7.setOpacity(.3);
					pieza7.setDisable(true);
				}
			}	
		});
		pieza8.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {					
				if(agarroPieza==false) {
					agarroPieza=true;
					piezaAgarrada=pieza8;
					pieza8.setOpacity(.3);
					pieza8.setDisable(true);
				}
			}	
		});
		pieza9.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {					
				if(agarroPieza==false) {
					agarroPieza=true;
					piezaAgarrada=pieza9;
					pieza9.setOpacity(.3);
					pieza9.setDisable(true);
				}
			}	
		});
		pieza10.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {					
				if(agarroPieza==false) {
					agarroPieza=true;
					piezaAgarrada=pieza10;
					pieza10.setOpacity(.3);
					pieza10.setDisable(true);
				}
			}	
		});
		pieza11.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {					
				if(agarroPieza==false) {
					agarroPieza=true;
					piezaAgarrada=pieza11;
					pieza11.setOpacity(.3);
					pieza11.setDisable(true);
				}
			}	
		});
		pieza12.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {					
				if(agarroPieza==false) {
					agarroPieza=true;
					piezaAgarrada=pieza12;
					pieza12.setOpacity(.3);
					pieza12.setDisable(true);
				}
			}	
		});
		
		pos1.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if(p1c==false && agarroPieza==true) {
					piezasColocadas++;
					agarroPieza=false;
					p1c=true;
					pos1.setImage(piezaAgarrada.getImage());
					pos1.setId(piezaAgarrada.getId());
					tablero[0][0].setId(piezaAgarrada.getId());
					System.out.println(piezasColocadas);
					if(piezasColocadas==12) {
						comprobarVictoria();
					}
				}else if(p1c==true && agarroPieza==false) {
					p1c=false;
					piezaAgarrada=pos1;
					piezaAgarrada.setId(pos1.getId());
					pos1.setImage(marcoPos);
					recolocar();
					piezasColocadas--;
				}
			}	
		});
		
		pos2.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if(p2c==false && agarroPieza==true) {
					piezasColocadas++;
					agarroPieza=false;
					p2c=true;
					pos2.setImage(piezaAgarrada.getImage());
					pos2.setId(piezaAgarrada.getId());
					tablero[0][1].setId(piezaAgarrada.getId());
					if(piezasColocadas==12) {
						comprobarVictoria();
					}
				}else if(p2c==true && agarroPieza==false) {
					p2c=false;
					piezaAgarrada=pos2;
					piezaAgarrada.setId(pos2.getId());
					pos2.setImage(marcoPos);
					recolocar();
					piezasColocadas--;
				}
			}	
		});
		
		pos3.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if(p3c==false && agarroPieza==true) {
					piezasColocadas++;
					agarroPieza=false;
					p3c=true;
					pos3.setImage(piezaAgarrada.getImage());
					pos3.setId(piezaAgarrada.getId());
					tablero[0][2].setId(piezaAgarrada.getId());
					if(piezasColocadas==12) {
						comprobarVictoria();
					}
				}else if(p3c==true && agarroPieza==false) {
					p3c=false;
					piezaAgarrada=pos3;
					piezaAgarrada.setId(pos3.getId());
					pos3.setImage(marcoPos);
					recolocar();
					piezasColocadas--;
				}
			}	
		});
		
		pos4.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if(p4c==false && agarroPieza==true) {
					piezasColocadas++;
					agarroPieza=false;
					p4c=true;
					pos4.setImage(piezaAgarrada.getImage());
					pos4.setId(piezaAgarrada.getId());
					tablero[1][0].setId(piezaAgarrada.getId());
					if(piezasColocadas==12) {
						comprobarVictoria();
					}
				}else if(p4c==true && agarroPieza==false) {
					p4c=false;
					piezaAgarrada=pos4;
					piezaAgarrada.setId(pos4.getId());
					pos4.setImage(marcoPos);
					recolocar();
					piezasColocadas--;
				}
			}	
		});
		
		pos5.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if(p5c==false && agarroPieza==true) {
					piezasColocadas++;
					agarroPieza=false;
					p5c=true;
					pos5.setImage(piezaAgarrada.getImage());
					pos5.setId(piezaAgarrada.getId());
					tablero[1][1].setId(piezaAgarrada.getId());
					if(piezasColocadas==12) {
						comprobarVictoria();
					}
				}else if(p5c==true && agarroPieza==false) {
					p5c=false;
					piezaAgarrada=pos5;
					piezaAgarrada.setId(pos5.getId());
					pos5.setImage(marcoPos);
					recolocar();
					piezasColocadas--;
				}
			}	
		});
		
		pos6.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if(p6c==false && agarroPieza==true) {
					piezasColocadas++;
					agarroPieza=false;
					p6c=true;
					pos6.setImage(piezaAgarrada.getImage());
					pos6.setId(piezaAgarrada.getId());
					tablero[1][2].setId(piezaAgarrada.getId());
					if(piezasColocadas==12) {
						comprobarVictoria();
					}
				}else if(p6c==true && agarroPieza==false) {
					p6c=false;
					piezaAgarrada=pos6;
					piezaAgarrada.setId(pos6.getId());
					pos6.setImage(marcoPos);
					recolocar();
					piezasColocadas--;
				}
			}	
		});
		
		pos7.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if(p7c==false && agarroPieza==true) {
					piezasColocadas++;
					agarroPieza=false;
					p7c=true;
					pos7.setImage(piezaAgarrada.getImage());
					pos7.setId(piezaAgarrada.getId());
					tablero[2][0].setId(piezaAgarrada.getId());
					if(piezasColocadas==12) {
						comprobarVictoria();
					}
				}else if(p7c==true && agarroPieza==false) {
					p7c=false;
					piezaAgarrada=pos7;
					piezaAgarrada.setId(pos7.getId());
					pos7.setImage(marcoPos);
					recolocar();
					piezasColocadas--;
				}
			}	
		});
		
		pos8.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if(p8c==false && agarroPieza==true) {
					piezasColocadas++;
					agarroPieza=false;
					p8c=true;
					pos8.setImage(piezaAgarrada.getImage());
					pos8.setId(piezaAgarrada.getId());
					tablero[2][1].setId(piezaAgarrada.getId());
					if(piezasColocadas==12) {
						comprobarVictoria();
					}
				}else if(p8c==true && agarroPieza==false) {
					p8c=false;
					piezaAgarrada=pos8;
					piezaAgarrada.setId(pos8.getId());
					pos8.setImage(marcoPos);
					recolocar();
					piezasColocadas--;
				}
			}	
		});
		
		pos9.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if(p9c==false && agarroPieza==true) {
					piezasColocadas++;
					agarroPieza=false;
					p9c=true;
					pos9.setImage(piezaAgarrada.getImage());
					pos9.setId(piezaAgarrada.getId());
					tablero[2][2].setId(piezaAgarrada.getId());
					if(piezasColocadas==12) {
						comprobarVictoria();
					}
				}else if(p9c==true && agarroPieza==false) {
					p9c=false;
					piezaAgarrada=pos9;
					piezaAgarrada.setId(pos9.getId());
					pos9.setImage(marcoPos);
					recolocar();
					piezasColocadas--;
				}
			}	
		});
		
		pos10.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if(p10c==false && agarroPieza==true) {
					piezasColocadas++;
					agarroPieza=false;
					p10c=true;
					pos10.setImage(piezaAgarrada.getImage());
					pos10.setId(piezaAgarrada.getId());
					tablero[3][0].setId(piezaAgarrada.getId());
					if(piezasColocadas==12) {
						comprobarVictoria();
					}
				}else if(p10c==true && agarroPieza==false) {
					p10c=false;
					piezaAgarrada=pos10;
					piezaAgarrada.setId(pos10.getId());
					pos10.setImage(marcoPos);
					recolocar();
					piezasColocadas--;
				}
			}	
		});
		
		pos11.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if(p11c==false && agarroPieza==true) {
					piezasColocadas++;
					agarroPieza=false;
					p11c=true;
					pos11.setImage(piezaAgarrada.getImage());
					pos11.setId(piezaAgarrada.getId());
					tablero[3][1].setId(piezaAgarrada.getId());
					if(piezasColocadas==12) {
						comprobarVictoria();
					}
				}else if(p11c==true && agarroPieza==false) {
					p11c=false;
					piezaAgarrada=pos11;
					piezaAgarrada.setId(pos11.getId());
					pos11.setImage(marcoPos);
					recolocar();
					piezasColocadas--;
				}
			}	
		});
		
		pos12.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if(p12c==false && agarroPieza==true) {
					piezasColocadas++;
					agarroPieza=false;
					p12c=true;
					pos12.setImage(piezaAgarrada.getImage());
					pos12.setId(piezaAgarrada.getId());
					tablero[3][2].setId(piezaAgarrada.getId());
					if(piezasColocadas==12) {
						comprobarVictoria();
					}
				}else if(p12c==true && agarroPieza==false) {
					p12c=false;
					piezaAgarrada=pos12;
					piezaAgarrada.setId(pos12.getId());
					pos12.setImage(marcoPos);
					recolocar();
					piezasColocadas--;
				}
			}	
		});
		
		
		hbox.getChildren().addAll(grid1, grid2);
		Scene scene = new Scene(hbox);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Hora de jugar");
        stage.show();
    }
	
	public void recolocar() {
		if(piezaAgarrada.getId()==pieza1.getId()) {
			pieza1.setOpacity(1);
			pieza1.setDisable(false);
		}else if(piezaAgarrada.getId()==pieza2.getId()) {
			pieza2.setOpacity(1);
			pieza2.setDisable(false);
		}else if(piezaAgarrada.getId()==pieza3.getId()) {
			pieza3.setOpacity(1);
			pieza3.setDisable(false);
		}
		else if(piezaAgarrada.getId()==pieza4.getId()) {
			pieza4.setOpacity(1);
			pieza4.setDisable(false);
		}else if(piezaAgarrada.getId()==pieza5.getId()) {
			pieza5.setOpacity(1);
			pieza5.setDisable(false);
		}else if(piezaAgarrada.getId()==pieza6.getId()) {
			pieza6.setOpacity(1);
			pieza6.setDisable(false);
		}else if(piezaAgarrada.getId()==pieza7.getId()) {
			pieza7.setOpacity(1);
			pieza7.setDisable(false);
		}else if(piezaAgarrada.getId()==pieza8.getId()) {
			pieza8.setOpacity(1);
			pieza8.setDisable(false);
		}else if(piezaAgarrada.getId()==pieza9.getId()) {
			pieza9.setOpacity(1);
			pieza9.setDisable(false);
		}else if(piezaAgarrada.getId()==pieza10.getId()) {
			pieza10.setOpacity(1);
			pieza10.setDisable(false);
		}else if(piezaAgarrada.getId()==pieza11.getId()) {
			pieza11.setOpacity(1);
			pieza11.setDisable(false);
		}else if(piezaAgarrada.getId()==pieza12.getId()) {
			pieza12.setOpacity(1);
			pieza12.setDisable(false);
		}
	}
	
	public void comprobarVictoria() {
		Boolean ganado = false;
		for(int i=0;i<4;i++) {
			for(int j=0;j<3;j++) {
				System.out.println(tablero[i][j].getId());
				System.out.println(resultado[i][j].getId());
				if(tablero[i][j].getId().compareTo(resultado[i][j].getId())!=0) {
					ganado=false;
					i=3;
					j=2;
				}else if(tablero[i][j].getId().compareTo(resultado[i][j].getId())==0 && i==3 && j==2) {
					ganado=true;
				}
			}
		}
		
		if(ganado==true) {
			Alert dialogoGano = new Alert(AlertType.INFORMATION);
			dialogoGano.setTitle("¡¡¡GANASTE!!!");
			dialogoGano.setHeaderText(null);
			dialogoGano.setContentText("ARMASTE LA IMAGEN, GANASTE");
			dialogoGano.initStyle(StageStyle.UTILITY);
			dialogoGano.showAndWait();
		}
		if(ganado==false) {
			Alert dialogoMal = new Alert(AlertType.INFORMATION);
			dialogoMal.setTitle("ALGO ANDA MAL");
			dialogoMal.setHeaderText(null);
			dialogoMal.setContentText("REVISA BIEN LAS IMAGENES");
			dialogoMal.initStyle(StageStyle.UTILITY);
			dialogoMal.showAndWait();
		}
		
		
	}
	
	public ImageView[][] respuesta() {
		int aux=1;
		Image parte;
		String ruta = "";
		ImageView guardParte;
		String nombreImagen="";
		ImageView[][] armado = new ImageView[4][3]; 
		for(int i=0;i<3;i++) {
			for(int j=0;j<4;j++) {
				ruta = "";
				nombreImagen="";
				nombreImagen=seleccionadoId+"_"+aux;
				ruta="image/"+nombreImagen+".jpg";
				parte=new Image(ruta);
				guardParte=new ImageView(parte);
				guardParte.setFitWidth(70);
				guardParte.setFitHeight(70);
				guardParte.setId(nombreImagen);
				armado[j][i]=guardParte;
				aux++;
			}
		}
		return armado;
	}
	
	public ImageView[][] pocisiones() {
		ImageView p;
		ImageView[][] pos = new ImageView[4][3]; 
		for(int i=0;i<3;i++) {
			for(int j=0;j<4;j++) {
				p = new ImageView(marcoPos);
				p.setId("SN");
				p.setFitWidth(70);
				p.setFitHeight(70);
				pos[j][i]=p;
			}
		}
		return pos;
	}
	
	public ImageView[][] desordenado() {
		int aux=1;
		Image parte;
		String ruta = "";
		ImageView guardParte;
		String nombreImagen="";
		ImageView[][] desor = new ImageView[4][3];
		Random r = new Random();
		int f, c;
		int bandera=0;
		
		for(int i=0;i<12;i++) {
				bandera=0;
				ruta = "";
				nombreImagen="";
				nombreImagen=seleccionadoId+"_"+aux;
				ruta="image/"+nombreImagen+".jpg";
				parte=new Image(ruta);
				guardParte=new ImageView(parte);
				guardParte.setFitWidth(70);
				guardParte.setFitHeight(70);
				guardParte.setId(nombreImagen);
				
				while(bandera==0) {
				f=Math.abs((r.nextInt()%4));
				c=Math.abs((r.nextInt()%3));
				
				if(desor[f][c]==null) {
					desor[f][c]=guardParte;
					bandera=1;
				}else {
					bandera=0;
				}
				
				}
				
				
				aux++;
		}
		return desor;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
