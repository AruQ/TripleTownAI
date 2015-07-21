package gui;

import javafx.event.EventHandler;
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
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class StartMenuPane extends Pane
{
	private final Font font = new Font("Valken Regular", 40);
	private final MainGameApplication mainGamePanel;

	public StartMenuPane(MainGameApplication mainGamePanel)
	{
		this.mainGamePanel = mainGamePanel;
		setPrefSize(GamePane.PANE_DIMENSION + GameMenuPane.GAME_MENU_PANEL_DIMENSION,
				GamePane.PANE_DIMENSION);

		addLogo();
		addBackground();
		addPlayButton();
		addExitButton();

	}

	private void addPlayButton()
	{
		Text play = createText("PLAY", 100, GamePane.PANE_DIMENSION / 2);
		play.setOnMouseReleased(new EventHandler<MouseEvent>()
		{
			@Override
			public void handle(MouseEvent mouseEvent)
			{
				StartMenuPane.this.mainGamePanel.startGame();
			}
		});
		getChildren().add(play);
	}

	private void addExitButton()
	{
		Text exit = createText("EXIT", getPrefWidth() - 150, GamePane.PANE_DIMENSION / 2);
		exit.setOnMouseReleased(new EventHandler<MouseEvent>()
		{
			@Override
			public void handle(MouseEvent mouseEvent)
			{
				StartMenuPane.this.mainGamePanel.closeGame();
			}
		});
		getChildren().add(exit);
	}

	Text createText(String stringText, double x, double y)
	{
		Text text = new Text(stringText);
		text.setFont(this.font);
		text.setFill(Color.WHITE);
		text.setStyle("-fx-stroke: firebrick;");
		text.relocate(x, y);
		DropShadow ds = new DropShadow();
		ds.setOffsetY(3.0f);
		ds.setColor(Color.FIREBRICK);
		text.setEffect(ds);
		text.setCache(true);
		return text;
	}

	private void addBackground()
	{
		Image backgroundImage = new Image("file:Sprites\\menuBackgrond.jpg",
				GamePane.PANE_DIMENSION + GameMenuPane.GAME_MENU_PANEL_DIMENSION,
				GamePane.PANE_DIMENSION, false, false);
		setBackground(new Background(new BackgroundImage(backgroundImage,
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
				BackgroundSize.DEFAULT)));
	}

	private void addLogo()
	{
		Image imageLogo = new Image("file:Sprites\\logo.png");
		ImageView logo = new ImageView(imageLogo);
		logo.relocate((getPrefWidth() - imageLogo.getWidth()) / 2, 10);
		getChildren().add(logo);
	}

}
