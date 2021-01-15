package Client;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.WindowEvent;

public class ClientController {

    final private ClientModel model;
    final private ClientView view;

    protected ClientController(ClientModel model, ClientView view) {
        this.model = model;
        this.view = view;

        // register ourselves to listen for button clicks
        view.btnGo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String ip = view.txtIP.getText();
                Integer port = new Integer(view.txtPort.getText());
                model.init(ip, port);
                view.txtMessages.setText("Initialized");
            }
        });

        // register ourselves to listen for button clicks
        view.btnCreateLogin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String result = model.sayCreateLogin(view.txtClientName.getText());
                view.txtMessages.appendText("\nSaid 'create login', received: " + result);
            }
        });

        // register ourselves to listen for button clicks
        view.btnLogin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String result = model.sayLogin(view.txtClientName.getText());
                view.txtMessages.appendText("\nSaid 'login', received: " + result);
            }
        });

        // register ourselves to listen for button clicks
        view.btnChangePw.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String result = model.sayChangePw(view.txtClientName.getText());
                view.txtMessages.appendText("\nSaid 'change password', received: " + result);
            }
        });

        // register ourselves to listen for button clicks
        view.btnLogout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String result = model.sayLogout(view.txtClientName.getText());
                view.txtMessages.appendText("\nSaid 'logout', received: " + result);
            }
        });

        // register ourselves to listen for button clicks
        view.btnCreateToDo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String result = model.sayCreateToDo(view.txtClientName.getText());
                view.txtMessages.appendText("\nSaid 'create to do', received: " + result);
            }
        });

        // register ourselves to listen for button clicks
        view.btnDeleteToDo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String result = model.sayDeleteToDo(view.txtClientName.getText());
                view.txtMessages.appendText("\nSaid 'delete to do', received: " + result);
            }
        });

        // register ourselves to listen for button clicks
        view.btnGetToDo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String result = model.sayGetToDo(view.txtClientName.getText());
                view.txtMessages.appendText("\nSaid 'get to do', received: " + result);
            }
        });

        // register ourselves to listen for button clicks
        view.btnListToDo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String result = model.sayListToDo(view.txtClientName.getText());
                view.txtMessages.appendText("\nSaid 'list to do', received: " + result);
            }
        });

        // register ourselves to listen for button clicks
        view.btnPing.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String result = model.sayPing(view.txtClientName.getText());
                view.txtMessages.appendText("\nSaid 'ping', received: " + result);
            }
        });

        // register ourselves to listen for button clicks
        view.btnGoodbye.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String result = model.sayGoodbye(view.txtClientName.getText());
                view.txtMessages.appendText("\nSaid 'goodbye', received: " + result);
            }
        });

        // register ourselves to handle window-closing event
        view.getStage().setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                view.stop();
                Platform.exit();
            }
        });
    }
}

