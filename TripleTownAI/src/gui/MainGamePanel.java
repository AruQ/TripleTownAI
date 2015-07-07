package gui;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import logic.GameManager;

public class MainGamePanel extends Application
{
	private final GameManager gameManager = new GameManager();
	private final GameMenuPane gameMenuPane = new GameMenuPane(this.gameManager);
	private final Pane gamePane = new GamePane(this.gameManager, this.gameMenuPane);

	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage primaryStage)
	{

		// Pane canvas = new Pane();
		// canvas.setStyle("-fx-background-color: black;");
		// canvas.setPrefSize(500, 500);
		// Circle circle = new Circle(50, Color.BLUE);
		// circle.relocate(20, 20);
		// Rectangle rectangle = new Rectangle(100, 100, Color.RED);
		// rectangle.relocate(0, 0);
		// canvas.getChildren().addAll(circle, rectangle);
		// primaryStage.setScene(new Scene(canvas));
		// primaryStage.show();

		// primaryStage.setTitle("Hello World!");
		// Button btn = new Button();
		// btn.setText("Say 'Hello World'");
		// btn.setOnAction(new EventHandler<ActionEvent>()
		// {
		//
		// @Override
		// public void handle(ActionEvent event)
		// {
		// System.out.println("Hello World!");
		// }
		// });
		//
		// StackPane root = new StackPane();
		// root.getChildren().add(btn);
		// primaryStage.setScene(new Scene(root, 300, 250));
		// primaryStage.show();

		SplitPane sp = createSplitPane();
		primaryStage.setResizable(false);
		primaryStage.setScene(new Scene(sp));
		primaryStage
				.getScene()
				.getStylesheets()
				.add(".static-split .split-pane *.horizontal-grabber { -fx-background-color: transparent; }.static-split .split-pane *.vertical-grabber { -fx-background-color: transparent; }");
		primaryStage.show();

		disableDividers(sp);
	}

	private SplitPane createSplitPane()
	{
		SplitPane sp = new SplitPane();
		double width = GamePane.PANE_DIMENSION + ((GamePane.PANE_DIMENSION * 30) / 100);
		sp.setPrefSize(width, GamePane.PANE_DIMENSION);
		final StackPane sp1 = new StackPane();
		sp1.getChildren().add(this.gamePane);
		final StackPane sp2 = new StackPane();
		sp2.getChildren().add(this.gameMenuPane);
		sp.getItems().addAll(sp1, sp2);
		sp.setDividerPositions((float) (GamePane.PANE_DIMENSION / width));
		sp.getStyleClass().add("static-split");
		return sp;
	}

	private void disableDividers(SplitPane split)
	{
		for (Node divider : split.lookupAll(".split-pane-divider"))
		{
			divider.setMouseTransparent(true);
		}
	}
}
