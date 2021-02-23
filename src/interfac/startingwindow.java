package interfac;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javafx.animation.Animation;
import javafx.animation.FillTransition;
import javafx.animation.KeyFrame;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.media.AudioSpectrumListener;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.transform.Translate;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

public class startingwindow extends Application {
	static Stage window;
	static String highScore;
	static int hScore;
	public static void main(String args[]) throws Exception{
		//////////////
		File file = new File("src/highscore.txt");
		BufferedReader bf = new BufferedReader(new FileReader(file));
		highScore=bf.readLine();
		hScore = Integer.parseInt(highScore);
		bf.close();
		//////////////
		
		launch(args);
	}
	
	@Override
	public void start(Stage primary) throws Exception {
		
		window = primary;
		window.setTitle("Flying StickMan");
		//Label
		Label label = new Label("Loading");
		label.setTranslateX(1200);
		label.setTranslateY(690);
		label.setStyle("-fx-font-color : white; -fx-font-size : 40; -fx-font-weight : 900;");
		Label label1 = new Label();
		//Image
		Image image = new Image("loading.png");
		ImageView iv = new ImageView(image);
		iv.setTranslateX(450);
		iv.setLayoutY(150);
		RotateTransition ivr = new RotateTransition(Duration.seconds(1),iv);
		ivr.setCycleCount(ivr.INDEFINITE);
		ivr.setByAngle(360);
		ivr.setDelay(Duration.seconds(0));
		ivr.setRate(1000);
		ivr.play();
		
		//Layout
		Pane pane = new Pane();
		pane.getChildren().addAll(label,iv,label1);
		pane.setStyle("-fx-background-color : black;");
		//Scene
		Scene scene = new Scene(pane,1420,750);
		window.setScene(scene);
		//window.setWidth(1420);
		//window.setHeight(750);
		window.setResizable(false);
		window.show();
		
//		Timeline timeline = new Timeline(new KeyFrame(Duration.millis(3000),e ->
//		{
//			primary.close();
//			MainWindow.Main();
//		}));
//		timeline.play();
		Timeline timeline1 = new Timeline(new KeyFrame(Duration.millis(500),e1 ->
		{
			label.setText("Loading.");
			Timeline timeline2 = new Timeline(new KeyFrame(Duration.millis(500),e2 ->
		{
			label.setText("Loading..");
			Timeline timeline3 = new Timeline(new KeyFrame(Duration.millis(500),e3 ->
		{
			label.setText("Loading...");
			Timeline timeline4 = new Timeline(new KeyFrame(Duration.millis(500),e4 ->
		{
			//primary.close();
			ivr.stop();
			MainWindow.Main();
			window.setScene(MainWindow.scene);
			
		}));
		timeline4.play();
		}));
		timeline3.play();
		}));
		timeline2.play();
		}));
		timeline1.play();
		//MainWindow.Main();
		//window.setScene(MainWindow.scene);
		//ivr.stop();

		
}
}