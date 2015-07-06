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

public class GamePanel extends Pane
{
	private static final int MAX_IMAGE_DIMENSION = 120;
	private final ImageLoader imageLoader = new ImageLoader();
	private final GameManager gameManager;

	private final Matrix matrix;

	private final Group itemGroup = new Group();
	private final Group utilGroup = new Group();

	// private final int screenWidth = Screen.getMainScreen().getWidth();
	// private final int screenHeight = Screen.getMainScreen().getHeight();


	public GamePanel(final GameManager gameManager)
	{

		this.gameManager = gameManager;
		matrix = gameManager.getMatrix();
		setBackground(new Background(new BackgroundImage(
				new Image(".\\Sprites\\grass-pattern.png"), BackgroundRepeat.REPEAT,
				BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
		setPrefSize(MAX_IMAGE_DIMENSION * matrix.getDimension(),
				MAX_IMAGE_DIMENSION * matrix.getDimension());

		getChildren().add(itemGroup);
		getChildren().add(utilGroup);
		loadImages();

		update();
		drawMatrix();

		this.setOnMouseReleased(new EventHandler<MouseEvent>()
				{
			@Override
			public void handle(MouseEvent mouseEvent)
			{
				int x = (int) (mouseEvent.getX() / MAX_IMAGE_DIMENSION);
				int y = (int) (mouseEvent.getY() / MAX_IMAGE_DIMENSION);
				if (GamePanel.this.gameManager.placeNextItem(x, y))
					GamePanel.this.update();
			}
				});
	}

	private void drawMatrix()
	{
		double distanceBetweenLinesVertical = this.getPrefWidth() / matrix.getDimension();
		double distanceBetweenLinesOrizzontal = this.getPrefHeight()
				/ matrix.getDimension();
		for (int i = 0; i < matrix.getDimension(); i++)
		{

			utilGroup.getChildren().addAll(
					new Line(0, i * distanceBetweenLinesOrizzontal, this.getPrefWidth(), i
							* distanceBetweenLinesOrizzontal));
			for (int j = 0; j < matrix.getDimension(); j++)
			{
				utilGroup.getChildren().addAll(
						new Line(j * distanceBetweenLinesVertical, 0, j
								* distanceBetweenLinesVertical, this.getPrefHeight()));
			}
		}
	}

	public void update()
	{
		itemGroup.getChildren().clear();
		for (int i = 0; i < matrix.getDimension(); i++)
		{
			for (int j = 0; j < matrix.getDimension(); j++)
			{
				if (matrix.getItemFromPosition(j, i) == Item.EMPTY)
					continue;
				double graphicX = ((j * this.getPrefWidth()) / matrix.getDimension());
				double graphicY = ((i * this.getPrefHeight()) / matrix.getDimension());
				ImageView imageView = new ImageView(imageLoader.getImage(matrix
						.getItemFromPosition(j, i).getName()));
				imageView.relocate(graphicX,
						graphicY);
				itemGroup.getChildren().addAll(imageView);
			}
		}
	}
	private void loadImages()
	{
		List<Item> items = ItemManager.getInstance().getItems();
		for (Item item : items)
		{
			if (item != Item.EMPTY)
				imageLoader.insertImage(item.getName(), "file:Sprites\\"
						+ item.getName().toLowerCase() + ".png");
		}


	}

}
