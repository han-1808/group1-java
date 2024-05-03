import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.sql.SQLException;

public class Admin {

    public void start(Stage arg0,Scene prevSc, String s) {

        GridPane grid = new GridPane();
        Button logIn = new Button("Log in");
        Button back = new Button("Back");
        TextField user = new TextField();
        PasswordField password = new PasswordField();
        Label welcome= new Label();
        Button close =new Button();
        char sign=10005;
        char minsign=9866;
        Button minimize=new Button(""+minsign);
        Label empty= new Label();                                                      //used to create empty space
        HBox hb= new HBox();
        Label wrong=new Label();
        VBox wrongBox=new VBox();
        Image image = new Image("loginBanner.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(400);
        imageView.setFitHeight(650);
//        imageView.setPreserveRatio(true);

        grid.setPadding(new Insets(0, 0, 20, 20));

        grid.setVgap(20);
        grid.setHgap(30);

        logIn.setPrefSize(220, 35);
        logIn.setMaxSize(220, 35);


        back.setPrefSize(220, 35);
        back.setMaxSize(220, 35);
        back.setOnAction(event -> arg0.setScene(prevSc));


        user.setPrefSize(500, 55);
        user.setPromptText("Username");
        user.setFocusTraversable(false);

        password.setPrefSize(500, 55);
        password.setPromptText("Password");
        password.setFocusTraversable(false);

        welcome.setPrefSize(460,55);
        welcome.setMinSize(460,55);
        welcome.setAlignment(Pos.CENTER);

        empty.setMinSize(50,35);
        switch (s){
            case "Admin":
                welcome.setText("Bookstore X - Admin Portal");
                break;
            case "Employee":
                welcome.setText("Bookstore X - Employee Portal");
                welcome.setStyle(" -fx-font-size: 30");
                break;
            case "Member":
                welcome.setText("Bookstore X - Member Portal");
                break;
        }
        grid.add(imageView, 5, 1, 1, 10);
        close.setText(""+sign);

        close.setMinSize(40,30);
        close.setPrefSize(40,30);
        close.setMaxSize(40,30);

        minimize.setMinSize(40,30);
        minimize.setPrefSize(40,30);
        minimize.setMaxSize(40,30);

        minimize.setTranslateX(460);
        close.setTranslateX(460);
        minimize.getStyleClass().add("buttonClose");
//        minimize.setStyle("-fx-background-color:transparent;");
//        close.setStyle("-fx-background-color:transparent;");
        close.getStyleClass().add("buttonClose");
        minimize.getStyleClass().add("buttonMinimize");

        hb.getChildren().addAll(minimize,close);
        hb.setAlignment(Pos.CENTER_RIGHT);

        wrong.setText("Wrong user address or password");
        wrong.setStyle(" -fx-text-fill: white;" +
                " -fx-font-size: 16;");
        wrongBox.getChildren().add(wrong);
        wrongBox.setAlignment(Pos.CENTER);

        grid.getChildren().addAll(hb, welcome, user, password, logIn, empty, back, wrongBox);

        GridPane.setConstraints(hb, 2, 0,2,1);
        GridPane.setConstraints(welcome, 0, 5,4,1);
        GridPane.setConstraints(user, 0, 6,3,1);
        GridPane.setConstraints(password, 0, 7,3,1);
        GridPane.setConstraints(logIn, 0, 8,1,1);
        GridPane.setConstraints(empty, 1, 8,1,1);
        GridPane.setConstraints(back, 0, 9,1,1);
        GridPane.setConstraints(wrongBox, 0, 10,4,1);

        grid.autosize();

        Scene sc = new Scene(grid, 900, 600);

        sc.getStylesheets().add("style.css");
        logIn.setOnAction(event -> {
            ConnectionClass conn = ConnectionClass.getInstance();
            try {
                AdminWindow a;
                switch (s) {
                    case "Admin":
                        if ((a = conn.adminCheck(user.getText(), password.getText())) != null) {
                            arg0.close();
                            a.start(arg0, sc);
                            user.clear();
                            password.clear();
                        }else{
                            wrong.setStyle(" -fx-text-fill: red;" +
                                    "  -fx-font-size: 16;");
                            password.clear();
                        }
                        break;
                    case "Employee":
                        if ((a = conn.employeeCheck(user.getText(), password.getText())) != null) {
                            arg0.close();
                            a.start(arg0, sc);
                            user.clear();
                            password.clear();
                        }else{
                            wrong.setStyle(" -fx-text-fill: red;" +
                                    "  -fx-font-size: 16;");
                            password.clear();
                        }
                        break;
                    case "Member":
                        if ((a = conn.memberCheck(user.getText(), password.getText())) != null) {
                            arg0.close();
                            a.start(arg0, sc);
                            user.clear();
                            password.clear();
                        }else{
                            wrong.setStyle(" -fx-text-fill: red;" +
                                    "  -fx-font-size: 16;");
                            password.clear();
                        }
                        break;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        password.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            switch (event.getCode()){
                case ENTER:
                    ConnectionClass conn = ConnectionClass.getInstance();
                    try {
                        AdminWindow a;
                        switch (s) {
                            case "Admin":
                                if ((a = conn.adminCheck(user.getText(), password.getText())) != null) {
                                    arg0.close();
                                    a.start(arg0, sc);
                                    user.clear();
                                    password.clear();
                                }else{
                                    wrong.setStyle(" -fx-text-fill: red;" +
                                            "  -fx-font-size: 16;");
                                    password.clear();
                                }
                                break;
                            case "Employee":
                                if ((a = conn.employeeCheck(user.getText(), password.getText())) != null) {
                                    arg0.close();
                                    a.start(arg0, sc);
                                    user.clear();
                                    password.clear();
                                }else{
                                    wrong.setStyle(" -fx-text-fill: red;" +
                                            "  -fx-font-size: 16;");
                                    password.clear();
                                }
                                break;
                            case "Member":
                                if ((a = conn.memberCheck(user.getText(), password.getText())) != null) {
                                    arg0.close();
                                    a.start(arg0, sc);
                                    user.clear();
                                    password.clear();
                                }else{
                                    wrong.setStyle(" -fx-text-fill: red;" +
                                            "  -fx-font-size: 16;");
                                    password.clear();
                                }
                                break;
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

            }
        });
        user.setOnMouseClicked(event -> wrong.setStyle(" -fx-text-fill: white;"));
        password.setOnMouseClicked(event -> wrong.setStyle(" -fx-text-fill: white;"));
        close.setOnAction(event -> arg0.close());
        minimize.setOnAction(event -> arg0.setIconified(true));
        password.setOnAction(event -> {
            Stage alarm=new Stage();
            Label doom= new Label();
            char[] ch= Character.toChars(128541);
            doom.setText("Bookstore X! "+String.valueOf(ch));
            Button okey=new Button("Continue");
            VBox vBox=new VBox();
            vBox.setAlignment(Pos.CENTER);
            vBox.getChildren().addAll(doom,okey);
            Scene dooming=new Scene(vBox,430,200);
            dooming.getStylesheets().add("style.css");
            alarm.setScene(dooming);
            alarm.initStyle(StageStyle.UNDECORATED);
            alarm.initModality(Modality.APPLICATION_MODAL);
            okey.setOnAction(event1 -> alarm.close());
            alarm.show();
        });

        arg0.setScene(sc);
        arg0.show();
    }
}
