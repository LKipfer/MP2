package Client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class ClientController implements Initializable {
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

    public void handleBtnCreateTask(ActionEvent actionEvent)
    {
        //add Method
    }

    public void handleBtnDelete(ActionEvent actionEvent)
    {
        DeleteSelectedRow();
        //SaveToFile();
        table_ToDo.refresh();
    }

    public void handleBtnList(ActionEvent actionEvent)
    {
        table_ToDo.refresh();
    }

    public void handleBtnCreateLogin(ActionEvent actionEvent)
    {
        //add Method
    }

    public void handleBtnChangePw(ActionEvent actionEvent)
    {
        //add Method
    }

    public void handleBtnLogin(ActionEvent actionEvent)
    {
        //add Method
    }

    public void handleBtnLogout(ActionEvent actionEvent)
    {
        //add Method
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

    }


    private void DeleteSelectedRow()
    {
        table_ToDo.getItems().removeAll(table_ToDo.getSelectionModel().getSelectedItem());
    }

    /* FILEWRITER
    private void SaveToFile()
    {
        FileWriter fw;

        try{
            fw = new FileWriter(new File("todo-savefile.txt"));

            for (var item:table_ToDo.getItems()
            ) {
                fw.write(String.format("%s-%s-%s-%s-%s-%s", item.getId(), item.getName(), item.getArea(), item.getPopulation(), item.getFog(), item.getListOfStates()));
                fw.write(System.lineSeparator());
            }

            fw.close();
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }*/

    /*  FILEREADER
    private String[] ReadFromFile()
    {
        BufferedReader fr;
        String[] lineList;

        try{
            fr = new BufferedReader(new FileReader("todo-savefile.txt"));

            int lines = 0;
            while (fr.readLine() != null) {
                lines++;
            }

            fr = new BufferedReader(new FileReader("todo-savefile.txt"));
            lineList = new String[lines];
            int i = 0;
            while (i < lines)
            {
                lineList[i] = fr.readLine();
                i++;
            }

            return lineList;
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
            return null;
        }
    } */


}
