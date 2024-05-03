import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.sql.SQLException;
import java.util.Random;

import java.util.concurrent.TimeUnit;
public class AdminWindow {
    private int ID;
    private String firstName;
    private String lastName;
    private int phoneNumber;
    private String email;
    private String password;
    private boolean stretched;
    private boolean stretchedAction;
    private String abilityLevel;
    private int posX;
    private int posY;
    private int clickedX;
    private int clickedY;
    public AdminWindow(int id,String firstName,String lastName,String email, String password, int phoneNumber, String abilityLavel){
        ID=id;
        this.firstName=firstName;
        this.lastName=lastName;
        this.password=password;
        this.phoneNumber=phoneNumber;
        this.email=email;
        stretched=false;
        stretchedAction=false;
        this.abilityLevel=abilityLavel;
    }
    public void start(Stage arg,Scene prevSc) throws SQLException {
        Stage arg0=new Stage();
        arg0.centerOnScreen();
        BorderPane bor = new BorderPane();

        Animation animate=Animation.getInstance();
        Label helloLbl = new Label("\u1F60 Hello, ");
        char[] bookIcon = Character.toChars(0x1F4D6);
        Label lbl = new Label(" " + String.valueOf(bookIcon) + "  Bookstore X");
        lbl.setAlignment(Pos.CENTER_LEFT);
//        helloLbl.setAlignment(Pos.BASELINE_LEFT);
        // Welcome Back Icon
        ImageView userIcon = new ImageView(new Image("file:icon-bookstore.png")); // Adjust the path to where your actual image is
        userIcon.setFitHeight(70);  // Set the size as needed
        userIcon.setFitWidth(70);
        // Welcome Back text
        Label welcomeLabel = new Label("Welcome back, " + firstName + " " + lastName + " ");
        welcomeLabel.setStyle("-fx-font-family: 'Segoe UI Emoji'; -fx-font-size: 24;");
        Button close =new Button();
        char signClose=10005;
        close.setText(""+signClose);
        char minSign=9866;
        Button minimize=new Button(""+minSign);
        close.setMinSize(40,30);
        close.setPrefSize(40,30);
        close.setMaxSize(40,30);
        close.setTranslateX(-1);
        minimize.setMinSize(40,30);
        minimize.setPrefSize(40,30);
        minimize.setMaxSize(40,30);
        minimize.setTranslateX(-1);
        minimize.getStyleClass().add("buttonClose");
        close.getStyleClass().add("buttonClose");
        minimize.getStyleClass().add("buttonMinimize");



        HBox hb= new HBox();
        hb.getChildren().addAll(minimize,close);
        hb.setAlignment(Pos.TOP_RIGHT);

        HBox top2 = new HBox();
        top2.getChildren().add(welcomeLabel);
        top2.setPrefHeight(60);
        ComboBox<String> cBox = new ComboBox<String>();
        cBox.setMinSize(300, 50);  // Increase min width to 400
        cBox.setPrefSize(300, 50);  // Increase preferred width to 400
//        cBox.setMaxSize(Double.MAX_VALUE, 50);  // Allow maximum width as needed for flexibility


//        Line color
        top2.setStyle("-fx-background-color: linear-gradient(#d5d8f0, #d5d8f0)");

}
