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
        // Đặt nền trong suốt cho helloLbl và welcomeLabel
        helloLbl.setStyle("-fx-background-color: transparent;");
        welcomeLabel.setStyle("-fx-background-color: transparent;");
//        top2.getChildren().add(labelsHBox);
        top2.getChildren().addAll(cBox);
        top2.setAlignment(Pos.BOTTOM_RIGHT);
        HBox bottomLeftBox = new HBox();
        bottomLeftBox.setAlignment(Pos.CENTER_LEFT); // Align content to the left
        bottomLeftBox.getChildren().add(cBox); // Add the ComboBox to this HBox
        bottomLeftBox.setPadding(new Insets(10, 10, 10, 10));
        String name = firstName+" "+lastName;

        Button dashboard = new Button("\uD83D\uDCC5 Dashboard");
        dashboard.getStyleClass().add("btn");
        dashboard.setMaxSize(300, 60);
        dashboard.setPrefSize(300, 60);
        dashboard.setMinSize(300, 60);
        String as="2BC8";
        int a= Integer.parseInt(as,16);
        char ss=(char)a;

        Button history = new Button("\uD83D\uDCDA History");
        history.getStyleClass().add("btn");
        history.setMaxSize(300, 60);
        history.setPrefSize(300, 60);
        history.setMinSize(300, 60);


        Button issuedBooks = new Button(" Issued Books");
        issuedBooks.getStyleClass().add("btn");
        issuedBooks.setStyle("-fx-font-size:16");
        issuedBooks.setMaxSize(300, 60);
        issuedBooks.setPrefSize(300, 0);
        issuedBooks.setMinSize(300, 0);

        Button addRemBooks = new Button("Add/Remove Books");
        addRemBooks.getStyleClass().add("btn");
        addRemBooks.setStyle("-fx-font-size:16");
        addRemBooks.setMaxSize(300, 60);
        addRemBooks.setPrefSize(300, 0);
        addRemBooks.setMinSize(300, 0);

        Button finance = new Button("Finance");
        finance.getStyleClass().add("btn");
        finance.setStyle("-fx-font-size:16");
        finance.setMaxSize(300, 60);
        finance.setPrefSize(300, 0);
        finance.setMinSize(300, 0);

        Button action = new Button("\u2699 Actions");
        action.getStyleClass().add("btn");
        action.setMaxSize(300, 60);
        action.setPrefSize(300, 60);
        action.setMinSize(300, 60);

        Button issueBook = new Button(" Issue Book");
        issueBook.getStyleClass().add("btn");
        issueBook.setStyle("-fx-font-size:16");
        issueBook.setMaxSize(300, 60);
        issueBook.setPrefSize(300, 0);
        issueBook.setMinSize(300, 0);

        Button receiveBooks = new Button("Receive Book");
        receiveBooks.getStyleClass().add("btn");
        receiveBooks.setStyle("-fx-font-size:16");
        receiveBooks.setMaxSize(300, 60);
        receiveBooks.setPrefSize(300, 0);
        receiveBooks.setMinSize(300, 0);

        Button add = new Button("Add");
        add.getStyleClass().add("btn");
        add.setStyle("-fx-font-size:16");
        add.setMaxSize(300, 60);
        add.setPrefSize(300, 0);
        add.setMinSize(300, 0);

        Button remove = new Button("Remove");
        remove.getStyleClass().add("btn");
        remove.setStyle("-fx-font-size:16");
        remove.setMaxSize(300, 60);
        remove.setPrefSize(300, 0);
        remove.setMinSize(300, 0);

        Button financeActivity = new Button("Finance");
        financeActivity.getStyleClass().add("btn");
        financeActivity.setStyle("-fx-font-size:16");
        financeActivity.setMaxSize(300, 60);
        financeActivity.setPrefSize(300, 0);
        financeActivity.setMinSize(300, 0);

}
