package gui;

import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import logic.GameManager;

public class GameMenuPane extends Pane
{
	private final GameManager gameManager;
	private Text textScore;
	private final ImageView imageViewNextItem;
	final static double GAME_MENU_PANEL_DIMENSION = (GamePane.PANE_DIMENSION * 30) / 100;
	private final Font font = Font.loadFont("file:Sprites\\Font\\DroidSans-Bold.ttf", 28);

	public GameMenuPane(GameManager gameManager)
	{
		this.gameManager = gameManager;
		addHelpButton();

		addRectangle(5, 220, GAME_MENU_PANEL_DIMENSION - 10, 200);
		imageViewNextItem = new ImageView();
		imageViewNextItem.relocate((GAME_MENU_PANEL_DIMENSION - 100) / 2, 300);
		getChildren().add(imageViewNextItem);

		addScore();
		addNextItemText();

		setBackground(new Background(new BackgroundImage(new Image(
				"file:Sprites\\backgroundMenu.jpg"), BackgroundRepeat.REPEAT,
				BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
	}

	private void addScore()
	{
		addRectangle(5, 50, GAME_MENU_PANEL_DIMENSION - 10, 120);
		ImageView iconScore = new ImageView(new Image("file:Sprites\\iconScore.png"));
		iconScore.relocate(5, 70);
		getChildren().add(iconScore);

		textScore = new Text();
		textScore.setFont(font);
		textScore.relocate(100, 100);
		textScore.setFill(Color.WHITE);
		getChildren().add(textScore);
	}

	private void addHelpButton()
	{
		Button helpButton = new Button();
		helpButton.setGraphic(new ImageView(new Image("file:Sprites\\helpText.png")));
		helpButton.setStyle("-fx-background-color: transparent;");
		helpButton.setPrefSize(120, 80);

		helpButton.relocate((GAME_MENU_PANEL_DIMENSION - helpButton.getPrefWidth()) / 2, 500);
		getChildren().add(helpButton);
	}

	private void addNextItemText()
	{
		Text nextItem = new Text("Next item");
		nextItem.setFont(font);
		nextItem.relocate((GAME_MENU_PANEL_DIMENSION - 140) / 2, 250);
		nextItem.setFill(Color.WHITE);
		DropShadow ds = new DropShadow();
		ds.setOffsetY(3.0f);
		ds.setColor(Color.CHOCOLATE);
		nextItem.setEffect(ds);
		nextItem.setCache(true);
		getChildren().add(nextItem);
	}


	private void addRectangle(double x, double y, double width, double height)
	{
		Rectangle rectangleBackground = new Rectangle();
		rectangleBackground.setFill(Color.BLACK);
		rectangleBackground.setOpacity(0.5);
		rectangleBackground.setX(x);
		rectangleBackground.setY(y);
		rectangleBackground.setWidth(width);
		rectangleBackground.setHeight(height);
		rectangleBackground.setArcWidth(20);
		rectangleBackground.setArcHeight(20);
		getChildren().add(rectangleBackground);
	}

	public void update()
	{
		textScore.setText(GameMenuPane.this.gameManager.getMatrix().getScore().toString());
		imageViewNextItem.setImage(ImageLoader.getInstance().getImage(
				gameManager.getNextItem().getName()));
	}
}
