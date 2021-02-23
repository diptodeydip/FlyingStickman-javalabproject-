package interfac;

import javafx.stage.*;
import javafx.util.Duration;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javafx.geometry.*;

public class ConfirmBox {

	// Create variable
	static boolean answer;
	public static boolean confirmDisplay(String title, String message) throws Exception{
		File file = new File("src/highscore.txt");
		BufferedWriter bf = new BufferedWriter(new FileWriter(file));
		startingwindow.highScore= Integer.toString(startingwindow.hScore);
		bf.write(startingwindow.highScore);
		bf.close();
		
		Stage window = new Stage();
		DropShadow shadow = new DropShadow();
		shadow.setColor(Color.RED);
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		// window.setMinWidth(250);
		Label label = new Label();
		label.setText(message);
		// label.setFont(new Font("Bold",20));

		// Create two buttons
		Button yesButton = new Button("Yes");
		Button noButton = new Button("No");
		yesButton.setPrefHeight(30);
		yesButton.setPrefWidth(60);
		noButton.setPrefHeight(30);
		noButton.setPrefWidth(60);
		// noButton.setFont(new Font("Bold",15));
		noButton.setStyle("-fx-background-color : #E80C0C");
		// yesButton.setFont(new Font("Bold",15));
		yesButton.setStyle("-fx-background-color : #34E80C");

		// Clicking will set answer and close window
		yesButton.setOnAction(e -> {
			if (MainWindow.choiceOfSound.equals("On")) {
				//MainWindow.Clicksound.seek(Duration.ZERO);
				MainWindow.Clicksound.play();
			}
			answer = true;
			window.close();
		});
		noButton.setOnAction(e -> {
			if (MainWindow.choiceOfSound.equals("On")) {
				//Clicksound.seek(Duration.ZERO);
				MainWindow.Clicksound.play();
			}
			answer = false;
			window.close();
		});
		noButton.setOnMouseEntered(e ->{
			shadow.setColor(Color.GREEN);
			noButton.setEffect(shadow);
		});
		noButton.setOnMouseExited(e ->{
			shadow.setColor(Color.RED);
			noButton.setEffect(null);
		});
		yesButton.setOnMouseEntered(e ->{
			yesButton.setEffect(shadow);
		});
		yesButton.setOnMouseExited(e ->{
			yesButton.setEffect(null);
		});
		
		VBox layout = new VBox(10);

		// Add buttons
		layout.getChildren().addAll(label, yesButton, noButton);
		layout.setAlignment(Pos.CENTER);
		Scene scene = new Scene(layout, 300, 200);
		scene.getStylesheets().add("confirm.css");
		window.setScene(scene);
		window.setResizable(false);
		window.showAndWait();

		// Make sure to return answer
		return answer;
	}
}
