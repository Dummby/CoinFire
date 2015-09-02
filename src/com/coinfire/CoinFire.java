package com.coinfire;

import java.io.File;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import com.coinfire.api.PullData;
import com.coinfire.util.Constants;
import com.coinfire.util.Log;
import com.coinfire.util.OnOff;

/*
 * @author Adam InTae Gerard
 */

public class CoinFire extends Application {

	
	public static File logFile = null;
	public static File csvFile = null;
	private static Scene scene1 = null;
	public static Text display = new Text(250, 250, Constants.introString);

	public static final ComboBox<String> comboBox1 = new ComboBox<String>();
	public static final ComboBox<String> comboBox2 = new ComboBox<String>();
	public static final ComboBox<String> comboBox3 = new ComboBox<String>();

	public static TextField calcText = new TextField();
	public static TextField calcOutputText = new TextField();

	public static CheckBox btcCheckBox;
	public static CheckBox ethereumCheckBox;
	public static CheckBox rippleCheckBox;
	public static CheckBox ltcCheckBox;
	public static CheckBox dashCheckox;
	
	public static CheckBox coinmarketcapCheckBox;
	public static CheckBox cryptocoinchartsCheckBox;
	public static CheckBox bitcoinchartsCheckBox;

	public static CheckBox csvDump;

	private double xOffset = 0;
	private double yOffset = 0;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {

		comboBox1.getItems().addAll("USD", "EUR", "CNY", "CAD", "RUB", "BTC");
		comboBox1.setValue("Select Price Currency:");

		comboBox2.getItems().addAll("USD", "EUR", "CNY", "CAD", "RUB", "BTC");
		comboBox2.setValue("Currency One:");

		comboBox3.getItems().addAll("BTC", "ETH", "XRP", "LTC", "DASH");
		comboBox3.setValue("Currency Two:");

		Label calcLabel = new Label("Currency Conversion");

		calcText.setText("0");
		calcText.setMaxWidth(100);
		calcText.setMinWidth(100);

		calcOutputText.setText("0");
		calcOutputText.setMaxWidth(100);
		calcOutputText.setMinWidth(100);

		Pane pane = new Pane();

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
		csvDump = new CheckBox("Create File For Each Selected Currency");
		VBox vb2 = new VBox();
		vb2.getChildren().addAll(xmlLabel, csvDump);
		
		Label marketLabel = new Label("Select Markets:");
		coinmarketcapCheckBox = new CheckBox("Coin Market-Cap");
		cryptocoinchartsCheckBox = new CheckBox("Cryptocoin Charts");
		bitcoinchartsCheckBox = new CheckBox("Bitcoin Charts");
		VBox vb3 = new VBox();
		vb3.getChildren().addAll(marketLabel, coinmarketcapCheckBox, cryptocoinchartsCheckBox, bitcoinchartsCheckBox);
		
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

		pane.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				xOffset = event.getSceneX();
				yOffset = event.getSceneY();
			}
		});
		pane.setOnMouseDragged(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				stage.setX(event.getScreenX() - xOffset);
				stage.setY(event.getScreenY() - yOffset);
			}
		});

		pane.setId("pane1");
		pane.getChildren().addAll(vb1, vb2, vb3, logButton, pullButton, display,
				exitButton, calcText, calcLabel, comboBox1, comboBox2,
				comboBox3, calcOutputText);

		calcLabel.setId("calcLabel");
		calcLabel.setLayoutX(55);
		calcLabel.setLayoutY(263);

		calcText.setId("calcText");
		calcText.setLayoutX(55);
		calcText.setLayoutY(283);

		calcOutputText.setId("calcOutputText");
		calcOutputText.setLayoutX(272);
		calcOutputText.setLayoutY(283);

		comboBox1.setId("comparisonCurrency");
		comboBox1.setLayoutX(55);
		comboBox1.setLayoutY(215);
		
		comboBox2.setId("calcCurrency1");
		comboBox2.setLayoutX(155);
		comboBox2.setLayoutY(283);
		
		comboBox3.setId("calcCurrency2");
		comboBox3.setLayoutX(372);
		comboBox3.setLayoutY(283);

		vb1.setLayoutX(55);
		vb1.setLayoutY(50);
		vb2.setLayoutX(55);
		vb2.setLayoutY(165);
		vb3.setLayoutX(550);
		vb3.setLayoutY(240);

		display.setLayoutX(125);
		display.setLayoutY(-175);
		display.setId("display");

		logButton.setLayoutX(105);
		logButton.setLayoutY(370);
		pullButton.setLayoutX(315);
		pullButton.setLayoutY(370);
		exitButton.setLayoutX(550);
		exitButton.setLayoutY(370);

		scene1 = new Scene(pane, 800, 500);
		scene1.getStylesheets().add(
				CoinFire.class.getResource("assets/style.css")
						.toExternalForm());

		stage.initStyle(StageStyle.UNDECORATED);
		stage.setTitle("CoinFire");
		stage.setScene(scene1);
		stage.setMaxHeight(800);
		stage.setMaxWidth(800);
		stage.setMinHeight(800);
		stage.setMinWidth(800);
		stage.show();
	}
}
