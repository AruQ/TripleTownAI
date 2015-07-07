package gui;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import logic.GameManager;

public class GameMenuPane extends Pane
{
	private GameManager gameManager;
	private Text textScore;
	private ImageView imageViewNextItem;

	public GameMenuPane(GameManager gameManager)
	{
		Font font = Font.loadFont("file:Sprites\\Font\\DroidSans-Bold.ttf", 32);
		this.gameManager = gameManager;
		Button helpButton = new Button("Help");
		helpButton.relocate(100, 500);
		getChildren().add(helpButton);

		this.imageViewNextItem = new ImageView();
		this.imageViewNextItem.relocate(100, 300);
		getChildren().add(this.imageViewNextItem);

		this.textScore = new Text();
		this.textScore.setFont(font);
		this.textScore.relocate(100, 100);
		getChildren().add(this.textScore);
	}

	public void update()
	{
		this.textScore.setText(GameMenuPane.this.gameManager.getMatrix().getScore().toString());
		this.imageViewNextItem.setImage(ImageLoader.getInstance().getImage(
				this.gameManager.getNextItem().getName()));
	}
}
