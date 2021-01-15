package Client;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ClientView {
    private ClientModel model;
    private Stage stage;

    protected Label lblIP = new Label("IP");
    protected TextField txtIP = new TextField("127.0.0.1");
    protected Label lblPort = new Label("Port");
    protected TextField txtPort = new TextField("8080");
    protected Label lblClientName = new Label("Client name");
    protected TextField txtClientName = new TextField("");
    protected Label lblUsername = new Label("Username");
    protected TextField txtUsername = new TextField("");
    protected Label lblPW = new Label("Password");
    protected TextField txtPW = new TextField("");
    protected Label lblTitle = new Label("Title");
    protected TextField txtTitle = new TextField("");
    protected Label lblPriority = new Label("Priority");
    protected TextField txtPriority = new TextField("");
    protected Label lblDescription = new Label("Description");
    protected TextField txtDescription = new TextField("");

    protected Button btnGo = new Button("Go");
    protected Button btnCreateLogin = new Button("Create Login");
    protected Button btnLogin = new Button("Login");
    protected Button btnChangePw = new Button("Change password");
    protected Button btnLogout = new Button("Logout");
    protected Button btnCreateToDo = new Button("Create To Do");
    protected Button btnDeleteToDo = new Button("Delete To Do");
    protected Button btnGetToDo = new Button("Get To Do");
    protected Button btnListToDo = new Button("List To Do");
    protected Button btnGoodbye = new Button("Goodbye");
    protected Button btnPing = new Button("Ping");
    protected TextArea txtMessages = new TextArea();

    protected ClientView(Stage stage, ClientModel model) {
        this.stage = stage;
        this.model = model;

        stage.setTitle("Plain text client");

        BorderPane root = new BorderPane();

        HBox topBox = new HBox();
            topBox.setId("TopBox");
            Region spacer = new Region();
            Region spacer2 = new Region();
            Region spacer3 = new Region();
            Region spacer4 = new Region();
            Region spacer5 = new Region();
            Region spacer6 = new Region();
            Region spacer7 = new Region();
            Region spacer8 = new Region();
            Region spacer9 = new Region();
            Region spacer10 = new Region();
            Region spacer11 = new Region();

            HBox.setHgrow(spacer, Priority.ALWAYS);
            HBox.setHgrow(spacer2, Priority.ALWAYS);
            HBox.setHgrow(spacer3, Priority.ALWAYS);


        root.setTop(topBox);

            topBox.getChildren().addAll(lblIP, txtIP, spacer, lblPort, txtPort, spacer2, lblClientName, txtClientName, spacer3, btnGo);
            txtIP.setId("IP");
            txtPort.setId("Port");

        ScrollPane scrollPane = new ScrollPane();
            scrollPane.setHbarPolicy(ScrollBarPolicy.NEVER);
            scrollPane.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
            scrollPane.setFitToHeight(true);
            scrollPane.setFitToWidth(true);
        root.setCenter(scrollPane);
            scrollPane.setContent(txtMessages);
            txtMessages.setWrapText(true);


        VBox leftBox = new VBox();
            topBox.setId("leftBox");
            leftBox.setAlignment(Pos.CENTER);

            HBox.setHgrow(spacer4, Priority.ALWAYS);
            HBox.setHgrow(spacer5, Priority.ALWAYS);
            HBox.setHgrow(spacer6, Priority.ALWAYS);


                HBox fieldBoxTitle = new HBox();
                    topBox.setId("FieldBoxTitle");
                    fieldBoxTitle.getChildren().addAll(lblTitle, spacer4, txtTitle);
                    HBox.setHgrow(spacer,Priority.ALWAYS);

                HBox fieldBoxPriority = new HBox();
                    topBox.setId("FieldBoxPriority");
                    fieldBoxPriority.getChildren().addAll(lblPriority, spacer5, txtPriority);
                    HBox.setHgrow(spacer,Priority.ALWAYS);

                HBox fieldBoxDescription = new HBox();
                    topBox.setId("FieldBoxDescription");
                    fieldBoxDescription.getChildren().addAll(lblDescription, spacer6, txtDescription);
                    HBox.setHgrow(spacer,Priority.ALWAYS);

                HBox buttonBoxTodo = new HBox();
                    topBox.setId("ButtonBoxTodo");
                    buttonBoxTodo.getChildren().addAll(btnCreateToDo, btnDeleteToDo, btnGetToDo, btnListToDo);
                    HBox.setHgrow(spacer, Priority.ALWAYS);


        HBox bottomBox = new HBox();
            topBox.setId("bottomBox");

            HBox.setHgrow(spacer7, Priority.ALWAYS);
            HBox.setHgrow(spacer8, Priority.ALWAYS);
            HBox.setHgrow(spacer9, Priority.ALWAYS);
            HBox.setHgrow(spacer10, Priority.ALWAYS);
            HBox.setHgrow(spacer11, Priority.ALWAYS);

                VBox credentialsBox = new VBox();
                credentialsBox.setAlignment(Pos.CENTER_LEFT);

                        HBox usernameBox = new HBox();
                            topBox.setId("UsernameBox");
                            usernameBox.getChildren().addAll(lblUsername, spacer7, txtUsername);
                            HBox.setHgrow(spacer, Priority.ALWAYS);


                        HBox passwordBox = new HBox();
                            topBox.setId("PasswordBox");
                            passwordBox.getChildren().addAll(lblPW, spacer8, txtPW);
                            HBox.setHgrow(spacer, Priority.ALWAYS);

                credentialsBox.getChildren().addAll(usernameBox, passwordBox);


                HBox credentialButtonsBox = new HBox();
                credentialButtonsBox.setAlignment(Pos.CENTER);

                credentialButtonsBox.getChildren().addAll(btnLogin, btnLogout, btnCreateLogin, btnChangePw);


                HBox goodbyeBox = new HBox();
                goodbyeBox.setAlignment(Pos.CENTER_RIGHT);

                goodbyeBox.getChildren().addAll(btnGoodbye);


        leftBox.getChildren().addAll(fieldBoxTitle, fieldBoxPriority, fieldBoxDescription, buttonBoxTodo);
        root.setLeft(leftBox);

        bottomBox.getChildren().addAll(credentialsBox,spacer10, credentialButtonsBox, spacer11, goodbyeBox);
        root.setBottom(bottomBox);


        Scene scene = new Scene(root);
        //scene.getStylesheets().add(
        //        getClass().getResource("Example.css").toExternalForm());
        stage.setScene(scene);
    }

    public void start() {
        stage.show();
    }

    /**
     * Stopping the view - just make it invisible
     */
    public void stop() {
        stage.hide();
    }

    /**
     * Getter for the stage, so that the controller can access window events
     */
    public Stage getStage() {
        return stage;
    }
}
