package com.coinfire.main;

import java.io.File;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/*
 * @author Adam InTae Gerard
 */

public class CoinFire extends Application {

	public static File logFile = null;
	public static File csvFile = null;
	private static Scene scene1 = null;
	public static Text display = new Text(250, 250, "Hello, please choose a log file.");

	public static CheckBox btcCheckBox;
	public static CheckBox ethereumCheckBox;
	public static CheckBox rippleCheckBox;
	public static CheckBox ltcCheckBox;
	public static CheckBox dashCheckox;
	
	public static CheckBox xmlDump;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {

		Label cryptoLabel = new Label("Select Cryptocurrencies:");
		btcCheckBox = new CheckBox("BTC");
		ethereumCheckBox = new CheckBox("ETH");
		rippleCheckBox = new CheckBox("XRP");
		ltcCheckBox = new CheckBox("LTC");
		dashCheckox = new CheckBox("DASH");

		VBox vb1 = new VBox();

		vb1.getChildren().addAll(cryptoLabel, btcCheckBox, ethereumCheckBox,
				rippleCheckBox, ltcCheckBox, dashCheckox);
		
		Label xmlLabel = new Label("Store Data In CSV Format:");
		xmlDump = new CheckBox("Create File For Each Selected Currency");
		
		VBox vb2 = new VBox();
		
		vb2.getChildren().addAll(xmlLabel, xmlDump);

		Button logButton = new Button("Set Log File Location");
		logButton.setId("log-Button");
		logButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				FileChooser fileChooser = new FileChooser();
				fileChooser.setTitle("Save Log File");
				FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
						"Select Log File", "*.log");
				fileChooser.getExtensionFilters().add(extFilter);
				logFile = fileChooser.showSaveDialog(stage);
				Log.log("Log file created.");
			}
		});

		Button pullButton = new Button("Pull Cryptocurrency Data");
		pullButton.setId("Pull-Button");
		pullButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				if (logFile != null) {

					if (pullButton.getText().equals("Pull Cryptocurrency Data")) {
						OnOff.turnOn();
						PullData pd = new PullData(1);
						pd.start();

						pullButton.setText("Stop Pull");
					} else {
						OnOff.turnOff();
						pullButton.setText("Pull Cryptocurrency Data");
					}
				} else {
					Log.log("A log file must be selected");
				}
			}
		});

		Button exitButton = new Button("Exit Program");
		exitButton.setId("Exit-Button");
		exitButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				OnOff.turnOff();
				if (OnOff.onOff.equals(0)) {
					System.exit(0);
				}
			}
		});

		// input text
		// selection menu - generated from checkboxes.

		Pane pane1 = new Pane();
		pane1.setId("pane1");
		pane1.getChildren().addAll(vb1, vb2, logButton, pullButton, display,
				exitButton);

		vb1.setLayoutX(55);
		vb1.setLayoutY(50);
		vb2.setLayoutX(55);
		vb2.setLayoutY(165);
		display.setLayoutX(75);
		display.setLayoutY(-175);
		display.setId("display");
		logButton.setLayoutX(55);
		logButton.setLayoutY(275);
		pullButton.setLayoutX(250);
		pullButton.setLayoutY(275);
		exitButton.setLayoutX(475);
		exitButton.setLayoutY(275);

		scene1 = new Scene(pane1, 700, 400);
		scene1.getStylesheets().add(
				CoinFire.class.getResource("style.css").toExternalForm());

		stage.initStyle(StageStyle.UNDECORATED);
		stage.setTitle("CoinFire");
		stage.setScene(scene1);
		stage.setMaxHeight(400);
		stage.setMaxWidth(700);
		stage.setMinHeight(400);
		stage.setMinWidth(700);
		stage.show();
	}
}
