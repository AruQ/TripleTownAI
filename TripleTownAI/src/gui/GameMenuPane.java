package gui;

import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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
import logic.Cell;
import logic.GameManager;
import logic.Item;
import logic.ItemManager;
import logic.WorldJDLV;

public class GameMenuPane extends Pane
{
	private final GameManager gameManager;
	private Text textScore;
	private final ImageView imageViewNextItem;
	final static double GAME_MENU_PANEL_DIMENSION = (GamePane.PANE_DIMENSION * 30) / 100;
	private final Font font = Font.loadFont("file:Sprites\\Font\\DroidSans-Bold.ttf", 28);
	private final MainGameApplication mainGamePanel;

	public GameMenuPane(MainGameApplication mainGamePanel, GameManager gameManager)
	{
		this.mainGamePanel = mainGamePanel;
		this.gameManager = gameManager;
		addHelpButton();

		addRectangle(5, 260, GAME_MENU_PANEL_DIMENSION - 10, 200);
		imageViewNextItem = new ImageView();
		imageViewNextItem.relocate((GAME_MENU_PANEL_DIMENSION - 100) / 2, 340);
		getChildren().add(imageViewNextItem);

		addScore();
		addNextItemText();
		addSolveButton();
		addRestartButton();

		setBackground(new Background(new BackgroundImage(new Image(
				"file:Sprites\\backgroundMenu.jpg"), BackgroundRepeat.REPEAT,
				BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
		AnimationTimer timer = new AnimationTimer()
		{

			@Override
			public void handle(long now)
			{
				GameMenuPane.this.mainGamePanel.graphicUpdate();
			};

		};
		timer.start();
	}

	private void addScore()
	{
		addRectangle(5, 90, GAME_MENU_PANEL_DIMENSION - 10, 120);
		ImageView iconScore = new ImageView(new Image("file:Sprites\\iconScore.png"));
		iconScore.relocate(5, 110);
		getChildren().add(iconScore);

		textScore = new Text();
		textScore.setFont(font);
		textScore.relocate(100, 140);
		textScore.setFill(Color.WHITE);
		getChildren().add(textScore);
	}

	private void addHelpButton()
	{
		Button helpButton = new Button();
		helpButton.setGraphic(new ImageView(new Image("file:Sprites\\helpButton.png")));
		helpButton.setStyle("-fx-background-color: transparent;");
		helpButton.setPrefSize(120, 80);

		helpButton.relocate((GAME_MENU_PANEL_DIMENSION - helpButton.getPrefWidth()) / 2, 490);
		getChildren().add(helpButton);

		helpButton.setOnMouseReleased(new EventHandler<MouseEvent>()
				{
			@Override
			public void handle(MouseEvent mouseEvent)
			{
				if (gameManager.isGameOver())
					return;
				GameMenuPane.this.callAI();

			}

				});
	}

	private void addRestartButton()
	{
		Button restartButton = new Button();
		restartButton.setGraphic(new ImageView(new Image("file:Sprites\\restartButton.png")));
		restartButton.setStyle("-fx-background-color: transparent;");
		restartButton.setPrefSize(100, 80);

		restartButton.relocate((GAME_MENU_PANEL_DIMENSION - restartButton.getPrefWidth()) / 2.5,
				10);
		getChildren().add(restartButton);

		restartButton.setOnMouseReleased(new EventHandler<MouseEvent>()
				{
			@Override
			public void handle(MouseEvent mouseEvent)
			{
				gameManager.reset();

			}
				});

	}

	private void addSolveButton()
	{
		Button solveButton = new Button();
		solveButton.setGraphic(new ImageView(new Image("file:Sprites\\solveButton.png")));
		solveButton.setStyle("-fx-background-color: transparent;");
		solveButton.setPrefSize(100, 80);

		solveButton.relocate((GAME_MENU_PANEL_DIMENSION - solveButton.getPrefWidth()) / 2.5, 560);
		getChildren().add(solveButton);

		solveButton.setOnMouseReleased(new EventHandler<MouseEvent>()
				{
			@Override
			public void handle(MouseEvent mouseEvent)
			{

				new Thread(new Runnable()
				{

					@Override
					public void run()
					{
						while (true)
						{
							if (!GameMenuPane.this.callAI())
							{
								System.out.println("Game over");
								break;
							}
							// try
							// {
							// Thread.sleep(500);
							// } catch (InterruptedException e)
							// {
							// // TODO Auto-generated catch block
							// e.printStackTrace();
							// }
						}
					}
				}).start();
			}
				});

	}

	private boolean callAI()
	{
		Item nextItem = GameMenuPane.this.gameManager.getNextItem();
		List<Cell> aiPlayer = null;
		if (nextItem == Item.CRISTAL)
		{
			aiPlayer = WorldJDLV.placeCristal(gameManager.getMatrix(), nextItem);
			Item cristalReplace = ItemManager.getInstance().getItemFromName(
					aiPlayer.get(0).getType());
			gameManager.setNextItem(cristalReplace);
		}
		else
		{
			aiPlayer = WorldJDLV.aiPlayer(GameMenuPane.this.gameManager.getMatrix(),
					GameMenuPane.this.gameManager.getMatrix().getMaxElement(), nextItem);
		}
		if (aiPlayer.isEmpty())
		{
			// FIXME isgameover
			System.out.println("Non ci sono mosse");
			return false;
			// throw new RuntimeException("No element from AI");
		}
		Cell cell = aiPlayer.get(0);
		GameMenuPane.this.gameManager.placeNextItem(cell.getX(), cell.getY());
		return true;
	}

	private void addNextItemText()
	{
		Text nextItem = new Text("Next item");
		nextItem.setFont(font);
		nextItem.relocate((GAME_MENU_PANEL_DIMENSION - 140) / 2, 290);
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
