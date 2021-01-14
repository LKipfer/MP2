package Testing_and_Old_Stuff;

import Server.ServerModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class ServerController_old {

    final private ServerModel model;

    @FXML
    public Button btn_Go;
    @FXML
    public TextField tf_ServerPort;
    @FXML
    public Label lbl_MessageLog;
    @FXML
    public TextArea TextArea_Server;

    protected ServerController_old(ServerModel model) {
        this.model = model;

        btn_Go.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Integer port = new Integer(tf_ServerPort.getText());
                model.startServerSocket(port);
            }
        });

/*      old code, might delete after

        public void handleBtnGo (ActionEvent ActionEvent){
            Integer port = new Integer(tf_ServerPort.getText());
            model.startServerSocket(port);
        }

 */
    }

    public void handleBtnGo(ActionEvent actionEvent) {
    }
}
