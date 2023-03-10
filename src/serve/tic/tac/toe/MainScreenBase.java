package serve.tic.tac.toe;



import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class MainScreenBase extends AnchorPane {
    public static Server ourServer;
    
    protected final ImageView imageView;
    protected final Rectangle rectangle;
    protected final ImageView imageView0;
    protected final ImageView imageView1;
    protected final Button startServerButton;
    protected final ImageView imageView2;
    protected final Button showPlayersButton;

    public MainScreenBase() {

        imageView = new ImageView();
        rectangle = new Rectangle();
        imageView0 = new ImageView();
        imageView1 = new ImageView();
        startServerButton = new Button();
        imageView2 = new ImageView();
        showPlayersButton = new Button();

        setId("AnchorPane");
        setPrefHeight(480.0);
        setPrefWidth(750.0);
        getStylesheets().add("/serve/tic/tac/toe/mainscreen.css");

        imageView.setFitHeight(480.0);
        imageView.setFitWidth(750.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("Photos/background.jpg").toExternalForm()));

        rectangle.setArcHeight(5.0);
        rectangle.setArcWidth(5.0);
        rectangle.setFill(javafx.scene.paint.Color.valueOf("#2a47ad"));
        rectangle.setHeight(268.0);
        rectangle.setLayoutX(209.5);
        rectangle.setLayoutY(126.0);
        rectangle.setStroke(javafx.scene.paint.Color.valueOf("#2a47ad"));
        rectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle.getStyleClass().add("corner");
        rectangle.setWidth(331.0);

        imageView0.setFitHeight(152.0);
        imageView0.setFitWidth(397.0);
        imageView0.setLayoutX(185.0);
        imageView0.setLayoutY(50.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        imageView0.setImage(new Image(getClass().getResource("Photos/logo.png").toExternalForm()));

        imageView1.setFitHeight(60.0);
        imageView1.setFitWidth(221.0);
        imageView1.setLayoutX(272.0);
        imageView1.setLayoutY(190.0);
        imageView1.setPickOnBounds(true);
        imageView1.setPreserveRatio(true);
        imageView1.setImage(new Image(getClass().getResource("Photos/buttonbackground.png").toExternalForm()));

        startServerButton.setLayoutX(272.0);
        startServerButton.setLayoutY(194.0);
        startServerButton.setMnemonicParsing(false);
        startServerButton.setPrefHeight(48.0);
        startServerButton.setPrefWidth(210.0);
        startServerButton.getStyleClass().add("backGroundButton");
        startServerButton.setText("Start Server");
        if(Server.isRunning)
        {
            startServerButton.setText("Stop Server");
        }else
        {
            startServerButton.setText("Start Server");
        }
        startServerButton.setTextFill(javafx.scene.paint.Color.valueOf("#2a47ad"));
        startServerButton.setTextOverrun(javafx.scene.control.OverrunStyle.CLIP);
        startServerButton.setFont(new Font("Serif Regular", 29.0));
        startServerButton.setOnAction((event)->{
            
            if(startServerButton.getText().equals("Start Server") ){
                Server.isRunning=true;
                ourServer=new Server();
                ourServer.start();
                startServerButton.setText("Stop Server");
                
            }else{
                startServerButton.setText("Start Server");
                Server.isRunning=false;
                if(ourServer.isAlive())
                ourServer.close();
                
                
            }
        });

        imageView2.setFitHeight(60.0);
        imageView2.setFitWidth(221.0);
        imageView2.setLayoutX(272.0);
        imageView2.setLayoutY(252.0);
        imageView2.setPickOnBounds(true);
        imageView2.setPreserveRatio(true);
        imageView2.setImage(new Image(getClass().getResource("Photos/buttonbackground.png").toExternalForm()));

        showPlayersButton.setLayoutX(272.0);
        showPlayersButton.setLayoutY(252.0);
        showPlayersButton.setMnemonicParsing(false);
        showPlayersButton.setPrefHeight(48.0);
        showPlayersButton.setPrefWidth(210.0);
        showPlayersButton.getStyleClass().add("backGroundButton");
        showPlayersButton.setText("Show Players");
        showPlayersButton.setTextFill(javafx.scene.paint.Color.valueOf("#2a47ad"));
        showPlayersButton.setTextOverrun(javafx.scene.control.OverrunStyle.CLIP);
        showPlayersButton.setFont(new Font("Serif Regular", 29.0));
        showPlayersButton.setOnAction((event)->{
                   if(Server.isRunning)
                       ServeTicTacToe.scene.setRoot(new PlayersScreenBase());
                   else{
                       Alert alert=new Alert(Alert.AlertType.ERROR,"Error",ButtonType.OK);
                       alert.setContentText("Server Is Not Running !!\n Start Server First");
                       alert.show();
                   }

                });

        getChildren().add(imageView);
        getChildren().add(rectangle);
        getChildren().add(imageView0);
        getChildren().add(imageView1);
        getChildren().add(startServerButton);
        getChildren().add(imageView2);
        getChildren().add(showPlayersButton);

    }
}