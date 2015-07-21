package gui;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import logic.GameManager;

public class MainGameApplication extends Application
{
	private final GameManager gameManager = new GameManager();
	private final GameMenuPane gameMenuPane = new GameMenuPane(this, this.gameManager);
	private final GamePane gamePane = new GamePane(this.gameManager, this.gameMenuPane);
	private Stage primaryStage;

	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage primaryStage)
	{

		this.primaryStage = primaryStage;
		StartMenuPane mainPane = new StartMenuPane(this);
		primaryStage.setScene(new Scene(mainPane));
		primaryStage.show();
		// SplitPane sp = createSplitPane();
		// primaryStage.setResizable(false);
		// primaryStage.setScene(new Scene(sp));
		// // primaryStage
		// // .getScene()
		// // .getStylesheets()
		// //
		// .add(".static-split .split-pane *.horizontal-grabber { -fx-background-color: transparent; }.static-split .split-pane *.vertical-grabber { -fx-background-color: transparent; }");
		// primaryStage.show();
		//
		// disableDividers(sp);
	}

	private SplitPane createSplitPane()
	{
		SplitPane sp = new SplitPane();
		double width = GamePane.PANE_DIMENSION + GameMenuPane.GAME_MENU_PANEL_DIMENSION;
		sp.setPrefSize(width, GamePane.PANE_DIMENSION);
		final StackPane sp1 = new StackPane();
		sp1.getChildren().add(this.gamePane);
		final StackPane sp2 = new StackPane();
		sp2.getChildren().add(this.gameMenuPane);
		sp.getItems().addAll(sp1, sp2);
		sp.setDividerPositions((float) (GamePane.PANE_DIMENSION / width));
		// sp.getStyleClass().add("static-split");
		return sp;
	}

	private void disableDividers(SplitPane split)
	{
		for (Node divider : split.lookupAll(".split-pane-divider"))
		{
			divider.setMouseTransparent(true);
		}
	}

	public void startGame()
	{
		SplitPane sp = createSplitPane();
		this.primaryStage.setResizable(false);
		this.primaryStage.setScene(new Scene(sp));
		disableDividers(sp);
	}

	public void closeGame()
	{
		javafx.application.Platform.exit();
	}

	public void graphicUpdate()
	{
		this.gameMenuPane.update();
		this.gamePane.update();
	}
}
