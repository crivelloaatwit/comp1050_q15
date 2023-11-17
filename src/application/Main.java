package application;

import javafx.stage.Stage;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;

public class Main extends Application {

	public void start(Stage primaryStage) {
		StackPane sp = new StackPane();
		Arc arc = new Arc();
		arc.setCenterX(50.0f);
		arc.setCenterY(50.0f);
		arc.setRadiusX(50.0f);
		arc.setRadiusY(50.0f);
		arc.setStartAngle(45.0f);
		arc.setLength(270.0f);
		arc.setType(ArcType.ROUND);
		arc.setStroke(Color.BLACK);
		arc.setFill(Color.YELLOW);
		sp.getChildren().add(arc);
		
		HBox hBox = new HBox();
		hBox.setSpacing(10);
		hBox.setAlignment(Pos.CENTER);
		Button btnEnlarge = new Button("+");
		btnEnlarge.setOnAction(e->{arc.setRadiusX(arc.getRadiusX()+2);arc.setRadiusY(arc.getRadiusY()+2);});
		Button btnShrink = new Button("-");
		btnShrink.setOnAction(e->{arc.setRadiusX(arc.getRadiusX()-2);arc.setRadiusY(arc.getRadiusY()-2);});
		hBox.getChildren().add(btnEnlarge);
		hBox.getChildren().add(btnShrink);
		
		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(sp);
		borderPane.setBottom(hBox);
		BorderPane.setAlignment(hBox, Pos.CENTER);
		Scene scene = new Scene(borderPane, 300, 250);
		primaryStage.titleProperty().bind(arc.radiusXProperty().asString("Pac in Wonderland,R=%.0f"));
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);

	}

}