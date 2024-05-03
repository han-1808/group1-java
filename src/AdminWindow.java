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

        history.setOnAction(event -> {
            cBox.setValue(name);
            if(!stretched) {
                int aa = Integer.parseInt("2BC6", 16);
                char sign = (char) aa;
                history.setText(sign + " History");
                stretched=true;
            }else{
                int aa = Integer.parseInt("2BC8", 16);
                char sign = (char) aa;
                history.setText(sign + " History");
                stretched=false;
            }
            animate.setButtonAnimation(issuedBooks,addRemBooks,finance);
            Thread thread=new Thread(animate);
            thread.start();
        });

        action.setOnAction(event -> {
            cBox.setValue(name);
            if(!stretchedAction) {
                int aa = Integer.parseInt("2BC6", 16);
                char sign = (char) aa;
                action.setText(sign + " Actions");
                stretchedAction=true;
            }else{
                int aa = Integer.parseInt("2BC8", 16);
                char sign = (char) aa;
                action.setText(sign + " Actions");
                stretchedAction=false;
            }
            animate.setButtonAnimation(issueBook,receiveBooks,add, remove, financeActivity);
            Thread thread=new Thread(animate);
            thread.start();
        });

        cBox.getItems().addAll(
                name,"Profile",
                "Log Out");
        cBox.setValue(name);

        HBox top1_Left = new HBox();
        top1_Left.getChildren().add(lbl);
        top1_Left.setAlignment(Pos.CENTER_LEFT);

        HBox top1_Right = new HBox();
        top1_Right.getChildren().addAll(hb);
        top1_Right.setAlignment(Pos.TOP_RIGHT);

        HBox top1= new HBox();
        top1.getChildren().addAll(top1_Left, top1_Right);
        top1_Left.setPrefWidth(750);
        top1_Right.setPrefWidth(750);
        top1.setOnMousePressed(event -> {
            clickedX=(int)event.getScreenX();
            clickedY=(int)event.getScreenY();
            posX=(int)arg0.getX();
            posY=(int)arg0.getY();
        });
        top1.setOnMouseDragged(event -> {
            arg0.setX(posX+(event.getScreenX()-clickedX));
            arg0.setY(posY+(event.getScreenY()-clickedY));
        });
        top1.setOnMouseReleased(event -> {
            posX=(int)arg0.getX();
            posY=(int)arg0.getY();
        });


        VBox topV = new VBox();
        topV.getChildren().addAll(top1, top2);
        bor.setBottom(bottomLeftBox);
        bor.setTop(topV);

        VBox left = new VBox();
        bor.setLeft(left);
        left.setStyle("-fx-background-color: linear-gradient(#F8F8FF,#DCDCDC);" +
                "-fx-border-width: 3 3 3 3;" +
                "-fx-border-color: linear-gradient(#F8F8FF,#A9A9A9);");

        Button financeEmployee= new Button("Employee");
        Button financeMember =new Button("Member");
        financeEmployee.setMinSize(200,200);
        financeEmployee.setPrefSize(200,200);
        financeEmployee.setMaxSize(200,200);
        financeMember.setMinSize(200,200);
        financeMember.setPrefSize(200,200);
        financeMember.setMaxSize(200,200);
        HBox financeChoice= new HBox();
        financeChoice.setSpacing(40);
        financeChoice.setAlignment(Pos.CENTER);

        if(abilityLevel.equals("Admin")){
            financeChoice.getChildren().addAll(financeEmployee,financeMember);
        }else{
            financeChoice.getChildren().add(financeMember);
        }
        Random random=new Random();

        Button book= new Button("Books");
        Button employee =new Button("Employees");
        Button member =new Button("Members");
        book.setMinSize(200,200);
        book.setPrefSize(200,200);
        book.setMaxSize(200,200);
        employee.setMinSize(200,200);
        employee.setPrefSize(200,200);
        employee.setMaxSize(200,200);
        member.setMinSize(200,200);
        member.setPrefSize(200,200);
        member.setMaxSize(200,200);
        HBox dashboardChoice= new HBox();
        switch (abilityLevel) {
            case "Admin":
            case "Employee":
                dashboardChoice.getChildren().addAll(book, employee, member);
                left.getChildren().addAll(dashboard,  history, issuedBooks, addRemBooks, finance, action, issueBook, receiveBooks, add, remove, financeActivity);

                break;
            case "Member":
                dashboardChoice.getChildren().addAll(book);
                left.getChildren().addAll(dashboard,  issuedBooks);
                issuedBooks.setMaxSize(300, 40);
                issuedBooks.setPrefSize(300, 40);
                issuedBooks.setMinSize(300, 40);
                break;
        }
        dashboardChoice.setSpacing(40);
        dashboardChoice.setAlignment(Pos.CENTER);

        bor.setCenter(dashboardChoice);
        book.setOnAction(event -> bor.setCenter(BooksWindow.getBookWindow()));
        employee.setOnAction(event -> bor.setCenter((EmployeeWindow.getBookWindow(abilityLevel))));
        member.setOnAction(event -> bor.setCenter(MemberWindow.getBookWindow()));
        issuedBooks.setOnAction(event -> {
            cBox.setValue(name);
            bor.setCenter(IssuedBook.getIssueWindow(abilityLevel, ID));
        });
        dashboard.setOnAction(event -> {
            cBox.setValue(name);
            bor.setCenter(dashboardChoice);
        });
        addRemBooks.setOnAction(event -> {
            cBox.setValue(name);
            bor.setCenter(AddRemoveWindow.getAddRemBookWindow());
        });
        finance.setOnAction(event -> {
            cBox.setValue(name);
            bor.setCenter(financeChoice);
        });
        financeEmployee.setOnAction(event -> {
            cBox.setValue(name);
            bor.setCenter(FinanceWindow.getFinanceWindow());
        });
        financeMember.setOnAction(event -> {
            cBox.setValue(name);
            bor.setCenter(FinanceWindow.getFinanceMemberWindow());
        });

        add.setOnAction(event -> {

            cBox.setValue(name);
            Button addMember= new Button("Add Member");
            Button addBook =new Button("Add Book");
            addMember.setMinSize(200,200);
            addMember.setPrefSize(200,200);
            addMember.setMaxSize(200,200);
            addBook.setMinSize(200,200);
            addBook.setPrefSize(200,200);
            addBook.setMaxSize(200,200);
            HBox halfAdd= new HBox();

            halfAdd.getChildren().addAll(addMember,addBook);
            halfAdd.setSpacing(40);
            halfAdd.setAlignment(Pos.CENTER);
            Button addEmployee= new Button("Add Employee");
            Button addAdmin =new Button("Add Admin");
            addEmployee.setMinSize(200,200);
            addEmployee.setPrefSize(200,200);
            addEmployee.setMaxSize(200,200);
            addAdmin.setMinSize(200,200);
            addAdmin.setPrefSize(200,200);
            addAdmin.setMaxSize(200,200);
            HBox otherHalfAdd= new HBox();
            otherHalfAdd.getChildren().addAll(addEmployee,addAdmin);
            otherHalfAdd.setSpacing(40);
            otherHalfAdd.setAlignment(Pos.CENTER);
            VBox full= new VBox();
            full.setSpacing(40);
            if(abilityLevel.equals("Admin")) {
                full.getChildren().addAll(halfAdd, otherHalfAdd);
            }else{
                full.getChildren().add(halfAdd);
            }
            full.setAlignment(Pos.CENTER);
            bor.setCenter(full);

            addMember.setOnAction(event1 -> {
                Registration reg=Registration.getInstance();
                reg.addMember(ID, password);
            });
            addBook.setOnAction(event1 -> {
                Registration reg= Registration.getInstance();
                reg.addBooks(ID,password);
            });
            addEmployee.setOnAction(event1 -> {
                Registration reg= Registration.getInstance();
                reg.addEmployee(ID,password);
            });
            addAdmin.setOnAction(event1 -> {
                Registration reg= Registration.getInstance();
                reg.addAdmin(ID,password);
            });
        });

        remove.setOnAction(event -> {

            cBox.setValue(name);

            Button remMember= new Button("Remove Member");
            Button remBook =new Button("Remove Book");
            remMember.setMinSize(200,200);
            remMember.setPrefSize(200,200);
            remMember.setMaxSize(200,200);
            remBook.setMinSize(200,200);
            remBook.setPrefSize(200,200);
            remBook.setMaxSize(200,200);
            HBox halfRem= new HBox();
            halfRem.getChildren().addAll(remMember,remBook);
            halfRem.setSpacing(40);
            halfRem.setAlignment(Pos.CENTER);
            Button remEmployee= new Button("Remove Employee");
            Button remAdmin =new Button("Remove Admin");
            remEmployee.setMinSize(200,200);
            remEmployee.setPrefSize(200,200);
            remEmployee.setMaxSize(200,200);
            remAdmin.setMinSize(200,200);
            remAdmin.setPrefSize(200,200);
            remAdmin.setMaxSize(200,200);
            HBox otherHalfRem= new HBox();
            otherHalfRem.getChildren().addAll(remEmployee,remAdmin);
            otherHalfRem.setSpacing(40);
            otherHalfRem.setAlignment(Pos.CENTER);
            VBox full= new VBox();
            full.setSpacing(40);
            if(abilityLevel.equals("Admin")) {
                full.getChildren().addAll(halfRem, otherHalfRem);
            }else{
                full.getChildren().add(halfRem);
            }
            full.setAlignment(Pos.CENTER);
            bor.setCenter(full);

            remMember.setOnAction(event1 -> {
                Registration reg=Registration.getInstance();
                reg.remMember(ID, password);
            });
            remBook.setOnAction(event1 -> {
                Registration reg= Registration.getInstance();
                reg.remBooks(ID,password);
            });
            remEmployee.setOnAction(event1 -> {
                Registration reg= Registration.getInstance();
                reg.remEmployee(ID,password);
            });
            remAdmin.setOnAction(event1 -> {
                Registration reg= Registration.getInstance();
                reg.remAdmin(ID,password);
            });
        });

        issueBook.setOnAction(event -> {
            cBox.setValue(name);
            Issue bookIssue=Issue.getInstance();
            bor.setCenter(bookIssue.getIssueWindow(ID,password));
        });

        receiveBooks.setOnAction(event -> {
            cBox.setValue(name);
            TextField issueID = new TextField();
            TextField shelfID = new TextField();
            issueID.setPrefSize(300, 55);
            issueID.setMaxSize(300, 55);
            issueID.setPromptText("Issue ID");
            issueID.setFocusTraversable(false);
            shelfID.setPrefSize(300, 55);
            shelfID.setMaxSize(300, 55);
            shelfID.setPromptText("Shelf ID");
            shelfID.setFocusTraversable(false);

            Button confirm = new Button("Confirm");
            confirm.setPrefSize(120, 25);
            confirm.setMaxSize(120, 25);
            Button clear = new Button("Clear");
            clear.setPrefSize(120, 25);
            clear.setMaxSize(120, 25);
            HBox hbox=new HBox();
            hbox.setAlignment(Pos.CENTER);
            hbox.setSpacing(20);
            hbox.getChildren().addAll(clear, confirm);

            VBox issueBox= new VBox();
            issueBox.setAlignment(Pos.CENTER);
            issueBox.getChildren().addAll(issueID, shelfID, hbox);
            issueBox.setSpacing(30);
            issueBox.setPrefWidth(330);
            issueBox.setMinWidth(330);

            bor.setCenter(issueBox);
            clear.setOnAction(e -> {
                shelfID.clear();
                issueID.clear();
            });

            confirm.setOnAction(e -> {
                ConnectionClass mycon=ConnectionClass.getInstance();
                try {
                    mycon.receiveBook(ID,issueID.getText(),shelfID.getText());
                    shelfID.clear();
                    issueID.clear();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            });

        });

        cBox.setOnAction(event -> {

            switch (cBox.getValue()){
                case "Log Out":
                    arg0.close();
                    arg.show();
                    break;
                case "Profile":
                    Label nameProfile= new Label();
                    nameProfile.setText("Name :");
                    Label idProfile=new Label();
                    idProfile.setText("ID :");
                    Label emailProfile=new Label();
                    emailProfile.setText("Email :");
                    Label phoneProfile=new Label();
                    phoneProfile.setText("Phone Number :");

                    VBox leftBox= new VBox();
                    leftBox.getChildren().addAll(nameProfile, idProfile, emailProfile, phoneProfile);
                    leftBox.setAlignment(Pos.BASELINE_LEFT);

                    Label nameP= new Label();
                    nameP.setText(name);
                    Label idP=new Label();
                    idP.setText(""+ID);
                    Label emailP=new Label();
                    emailP.setText(email);
                    Label phoneP=new Label();
                    phoneP.setText(""+phoneNumber);
                    VBox rightBox= new VBox();
                    rightBox.getChildren().addAll(nameP, idP, emailP, phoneP);
                    rightBox.setAlignment(Pos.TOP_CENTER);

                    HBox box= new HBox();
                    box.setAlignment(Pos.CENTER);
                    box.getChildren().addAll(leftBox, rightBox);
                    leftBox.setPrefSize(500,250);
                    leftBox.setMinSize(500,250);
                    leftBox.setMaxSize(500,250);
                    rightBox.setPrefSize(500,250);
                    rightBox.setMinSize(500,250);
                    rightBox.setMaxSize(500,250);
                    box.setPrefSize(1000,500);
                    box.setSpacing(20);

                    bor.setCenter(box);
                    break;
            }
        });

        financeActivity.setOnAction(event -> {
            cBox.setValue(name);
            Finance fin=Finance.getInstance();
            bor.setCenter(fin.getBox(abilityLevel,ID));
        });

        close.setOnAction(event -> arg0.close());
        minimize.setOnAction(event -> arg0.setIconified(true));

        Scene sc = new Scene(bor, 1500, 800);

        sc.getStylesheets().add("style.css");
        arg0.initStyle(StageStyle.UNDECORATED);
        arg0.setScene(sc);
        arg0.show();

    }

}