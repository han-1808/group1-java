import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
public class Launcher extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage arg0) throws NoSuchAlgorithmException, InvalidKeySpecException {
        ImageView imageView = new ImageView(new Image("icon-bookstore.png"));
        GridPane grid = new GridPane();
        Button admin = new Button("Admin");
        Button libraryStuff = new Button("Employee");
        Button member = new Button("Member");
        Label welcome= new Label("Welcome to Bookstore X");
        Button close =new Button();
        char sign=10005;
        char minsign=9866;
        char db=(char)Integer.parseInt("26C3",16);
        Button minimize=new Button(""+minsign);
        HBox hb= new HBox();
        Scene sc = new Scene(grid, 500, 600);
        HBox dbBox= new HBox();
        Button dbBtn= new Button();
        // Đặt chiều rộng và chiều cao của ImageView
        imageView.setFitHeight(120); // Thay đổi kích thước tùy theo nhu cầu
        imageView.setFitWidth(120);

        GridPane.setValignment(imageView, VPos.TOP);


        grid.setPadding(new Insets(0, 0, 20, 20));
        grid.setVgap(20);
        grid.setHgap(30);

        admin.setPrefSize(300,55);
        libraryStuff.setPrefSize(300,55);
        member.setPrefSize(300,55);
        welcome.setPrefSize(400,55);
        welcome.setMinSize(400,55);

        close.setText(""+sign);
        close.setMinSize(40,30);
        close.setPrefSize(40,30);
        close.setMaxSize(40,30);
        close.setTranslateX(-29);
        minimize.setMinSize(40,30);
        minimize.setPrefSize(40,30);
        minimize.setMaxSize(40,30);
        minimize.setTranslateX(-29);
        minimize.getStyleClass().add("buttonClose");
        close.getStyleClass().add("buttonClose");
        minimize.getStyleClass().add("buttonMinimize");

        dbBtn.setText(""+db);
        dbBox.setAlignment(Pos.CENTER_RIGHT);
        dbBox.getChildren().add(dbBtn);


        hb.getChildren().addAll(minimize,close);
        hb.setAlignment(Pos.CENTER_LEFT);
        grid.getChildren().addAll(hb,welcome,admin, libraryStuff, member, dbBox);
        GridPane.setConstraints(hb,4,0,2,1);
        GridPane.setConstraints(welcome,2,5,3,1);
        GridPane.setConstraints(admin, 3, 7);
        GridPane.setConstraints(libraryStuff, 3, 8);
        GridPane.setConstraints(member, 3, 9);
        GridPane.setConstraints(dbBox,2,10,2,1);

        grid.autosize();

        sc.getStylesheets().add("style.css");
        admin.setOnAction(event -> {
            Admin a=new Admin();
            a.start(arg0,sc,"Admin");});
        libraryStuff.setOnAction(event -> {
            Admin a=new Admin();
            a.start(arg0,sc,"Employee");});
        member.setOnAction(event -> {
            Admin a=new Admin();
            a.start(arg0,sc, "Member");});
            dbBtn.setOnAction(event -> {
                Stage alarm=new Stage();
                Label dbinfo= new Label();
                VBox vBox=new VBox();
                Button apply=new Button("Apply");
                Button cancel=new Button("Cancel");
                Scene serverinfo=new Scene(vBox,430,230);
                TextField url=new TextField();
                TextField username= new TextField();
                PasswordField password = new PasswordField();
                PasswordField softPass= new PasswordField();
                HBox btnBox=new HBox();
    
                dbinfo.setText("Database Information ");
                dbinfo.setStyle(" -fx-font-size: 16");
    
                url.setPromptText("Database url (Default: jdbc:mysql://localhost:3306/library)");
                url.setFocusTraversable(false);
                url.setOnMouseClicked(event1 -> apply.setText("Apply"));
                username.setPromptText("Database username (Default: root)");
                username.setFocusTraversable(false);
                username.setOnMouseClicked(event1 -> apply.setText("Apply"));
                password.setPromptText("Database user password Default: ");
                password.setFocusTraversable(false);
                password.setOnMouseClicked(event1 -> apply.setText("Apply"));
                softPass.setPromptText("Software password");
                softPass.setFocusTraversable(false);
                softPass.setOnMouseClicked(event1 -> apply.setText("Apply"));
    
                btnBox.setAlignment(Pos.CENTER);
                btnBox.setSpacing(20);
                btnBox.getChildren().addAll(cancel, apply);
                vBox.setAlignment(Pos.CENTER);
                vBox.setSpacing(5);
    
                vBox.getChildren().addAll(dbinfo,url,username,password,softPass,btnBox);
    
                serverinfo.getStylesheets().add("style.css");
                alarm.setScene(serverinfo);
                alarm.initStyle(StageStyle.UNDECORATED);
                alarm.initModality(Modality.APPLICATION_MODAL);
                cancel.setOnAction(event1 -> alarm.close());
                apply.setOnAction(event1 ->{
                    ConnectionClass conn=ConnectionClass.getInstance();
                    if(conn.changeServer(url.getText(), username.getText(), password.getText(), softPass.getText())){
                        apply.setText("Done");
                        apply.setDisable(true);
                        cancel.setText("Close");
                    }else{
                        apply.setText("Failed");
                    }
    
                });
                alarm.show();
            });
    
            close.setOnAction(event -> arg0.close());
            minimize.setOnAction(event -> arg0.setIconified(true));
    
            arg0.initStyle(StageStyle.UNDECORATED);
            arg0.setScene(sc);
            arg0.show();
    
    
    
        }
    
    }
    