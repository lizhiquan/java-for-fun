import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;

/**
 * Drives the game.
 */
public class Main extends Application {
    public static int CELL_WIDTH = 20;
    public static int CELL_HEIGHT = 20;

    private GridPane root;
    private Game game;

    public Main() {
        root = new GridPane();
        game = new Game();
    }

    public void start(Stage stage) {
        renderWorld();

        root.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                root.getChildren().clear();
                game.passTime();
                renderWorld();
            }
        });

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("The Game of Life");
        stage.setResizable(false);
        stage.show();
    }

    private void renderWorld() {
        for(int row = 0; row < Game.WORLD_HEIGHT; row++)
            for(int col = 0; col < Game.WORLD_WIDTH; col++) {
                Rectangle r = new Rectangle(CELL_WIDTH, CELL_HEIGHT);
                r.setFill(game.getColor(row, col));
                r.setStrokeType(StrokeType.INSIDE);
                r.setStrokeWidth(0.5);
                r.setStroke(Color.BLACK);
                root.add(r, col, row);
            }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
