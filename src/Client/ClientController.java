package Client;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ClientController {
    @FXML
    public TextArea Log_TextArea;
    @FXML
    public Label lbl_Title;
    @FXML
    public Label lbl_Desc;
    @FXML
    public Label lbl_Priority;
    @FXML
    public Label lbl_Username;
    @FXML
    public Label lbl_Password;
    @FXML
    public TableView table_ToDo;
    @FXML
    public TableColumn tv_Name;
    @FXML
    public TableColumn tv_ID;
    @FXML
    public TableColumn tv_Title;
    @FXML
    public TableColumn tv_Desc;
    @FXML
    public TableColumn tv_Priority;
    @FXML
    public TextField tf_Title;
    @FXML
    public TextField tf_Desc;
    @FXML
    public TextField tf_Priority;
    @FXML
    public TextField tf_Username;
    @FXML
    public TextField tf_Password;
    @FXML
    public Button btn_Create;
    @FXML
    public Button btn_Delete;
    @FXML
    public Button btn_ListAll;
    @FXML
    public Button btn_CreateLogin;
    @FXML
    public Button btn_ChangePw;
    @FXML
    public Button btn_Login;
    @FXML
    public Button btn_Logout;
}
