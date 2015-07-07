package gui;

import java.util.List;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import logic.GameManager;
import logic.Item;
import logic.ItemManager;
import logic.Matrix;

public class GamePane extends Pane
{
	public static final int MAX_IMAGE_DIMENSION = 120;
	private final ImageLoader imageLoader = ImageLoader.getInstance();
	private final GameManager gameManager;

	private final Matrix matrix;

	private final Group itemGroup = new Group();
	private final Group utilGroup = new Group();
	public static int PANE_DIMENSION = MAX_IMAGE_DIMENSION * Matrix.DIMENSION;
	private GameMenuPane gameMenuPane;

	// private final int screenWidth = Screen.getMainScreen().getWidth();
	// private final int screenHeight = Screen.getMainScreen().getHeight();

	public GamePane(final GameManager gameManager, GameMenuPane gameMenuPane)
	{
		this.gameMenuPane = gameMenuPane;
		this.gameManager = gameManager;
		this.matrix = gameManager.getMatrix();
		setBackground(new Background(new BackgroundImage(new Image(
				"file:Sprites\\grass-pattern.png"), BackgroundRepeat.REPEAT,
				BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
		setPrefSize(PANE_DIMENSION, PANE_DIMENSION);

		getChildren().add(this.itemGroup);
		getChildren().add(this.utilGroup);
		loadImages();

		update();
		drawMatrix();

		setOnMouseReleased(new EventHandler<MouseEvent>()
		{
			@Override
			public void handle(MouseEvent mouseEvent)
			{
				int x = (int) (mouseEvent.getX() / MAX_IMAGE_DIMENSION);
				int y = (int) (mouseEvent.getY() / MAX_IMAGE_DIMENSION);
				if (GamePane.this.gameManager.placeNextItem(x, y))
					GamePane.this.update();
			}
		});
	}

	private void drawMatrix()
	{
		double distanceBetweenLinesVertical = getPrefWidth() / this.matrix.getDimension();
		double distanceBetweenLinesOrizzontal = getPrefHeight() / this.matrix.getDimension();
		for (int i = 0; i < this.matrix.getDimension(); i++)
		{

			this.utilGroup.getChildren().addAll(
					new Line(0, i * distanceBetweenLinesOrizzontal, getPrefWidth(), i
							* distanceBetweenLinesOrizzontal));
			for (int j = 0; j < this.matrix.getDimension(); j++)
			{
				this.utilGroup.getChildren().addAll(
						new Line(j * distanceBetweenLinesVertical, 0, j
								* distanceBetweenLinesVertical, getPrefHeight()));
			}
		}
	}

	public void update()
	{
		this.itemGroup.getChildren().clear();
		for (int i = 0; i < this.matrix.getDimension(); i++)
		{
			for (int j = 0; j < this.matrix.getDimension(); j++)
			{
				if (this.matrix.getItemFromPosition(j, i) == Item.EMPTY)
					continue;

				ImageView imageView = new ImageView(this.imageLoader.getImage(this.matrix
						.getItemFromPosition(j, i).getName()));
				double graphicX = ((j * getPrefWidth()) / this.matrix.getDimension())
						+ ((MAX_IMAGE_DIMENSION - imageView.getImage().getWidth()) / 2);
				double graphicY = ((i * getPrefHeight()) / this.matrix.getDimension())
						+ ((MAX_IMAGE_DIMENSION - imageView.getImage().getHeight()) / 2);
				imageView.relocate(graphicX, graphicY);
				this.itemGroup.getChildren().addAll(imageView);
			}
		}
		this.gameMenuPane.update();
	}

	private void loadImages()
	{
		List<Item> items = ItemManager.getInstance().getItems();
		for (Item item : items)
		{
			if (item != Item.EMPTY)
				this.imageLoader.insertImage(item.getName(), "file:Sprites\\"
						+ item.getName().toLowerCase() + ".png");
		}

	}

}
