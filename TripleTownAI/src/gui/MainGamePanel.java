package gui;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import logic.GameManager;

public class MainGamePanel extends Application
{
	private final GameManager gameManager = new GameManager();
	private final Pane pane = new GamePanel(gameManager);
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
		primaryStage.setResizable(false);
		primaryStage.setScene(new Scene(pane));
		primaryStage.show();
	}



}


