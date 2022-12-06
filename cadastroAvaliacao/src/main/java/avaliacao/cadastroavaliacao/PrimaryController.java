package avaliacao.cadastroavaliacao;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class PrimaryController {
    ObservableList<Principal> lista = FXCollections.observableArrayList();
    boolean novo = true; 
    
    @FXML
    private Button btnDeletar;

    @FXML
    private Button btnSalvar;

    @FXML
    private ComboBox<String> cbTipo;

    @FXML
    private TableColumn<Principal, String> columEmail;

    @FXML
    private TableColumn<Principal, Integer> columId;

    @FXML
    private TableColumn<Principal, String> columNome;

    @FXML
    private TableColumn<Principal, String> columTel;

    @FXML
    private TableColumn<Principal, String> columTipo;

    @FXML
    private TableView<Principal> tabela;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtTelefone;
    
      @FXML
    void deletar(ActionEvent event) {
        if(tabela.getSelectionModel().getSelectedItem()!=null){
            Alert confirmacao = new Alert(Alert.AlertType.CONFIRMATION);
            Principal contatoDeletar = tabela.getSelectionModel().getSelectedItem();
            confirmacao.setTitle("Deseja mesmo deletar o contato "+contatoDeletar.getNome()+"?");
            confirmacao.setContentText("Deletar "+contatoDeletar.getNome()+"?");
            Optional<ButtonType> retorno = confirmacao.showAndWait();
            if(retorno.get()==ButtonType.OK){
                int indice = tabela.getSelectionModel().getSelectedIndex();
                lista.remove(indice);
            }
        }
        else{
            Alert mensagemErro = new Alert(Alert.AlertType.INFORMATION);
            mensagemErro.setTitle("Selecione um registro para deletar");
            mensagemErro.setContentText("É preciso selecionar um registro");
        }

    }

    @FXML
    void salvar(ActionEvent event) {
        String nome = txtNome.getText();
        String email = txtEmail.getText();
        String telefone = txtTelefone.getText();
        String tipoContato = cbTipo.getSelectionModel().getSelectedItem();
        if(novo){
            int id = gerarId();
            lista.add(new Principal(id, nome, email, telefone, tipoContato));
        }
        else{
            int indice = tabela.getSelectionModel().getSelectedIndex();
            int id = tabela.getSelectionModel().getSelectedItem().getId();
            lista.remove(indice);
            lista.add(indice, new Principal(id, nome, email, telefone, tipoContato));
        }
        limparCampos();
    }
    
    @FXML
    public int gerarId(){
        Random aleatorio = new Random();
        return aleatorio.nextInt(1000);
        
    }
    
    @FXML
    public void limparCampos(){
        txtNome.setText("");
        txtEmail.setText("");
        txtTelefone.setText("");
        cbTipo.getSelectionModel().clearSelection();
        novo = true;
        
    }
     
   @FXML
    public void initialize(){
        System.out.println("oi");
        ObservableList<String>listaTipoContato = FXCollections.observableArrayList();
        listaTipoContato.add("Amigo");
        listaTipoContato.add("Família");
        listaTipoContato.add("Trabalho");
        listaTipoContato.add("Outros");
        cbTipo.setItems(listaTipoContato);
        columId.setCellValueFactory(new PropertyValueFactory("id"));
        columNome.setCellValueFactory(new PropertyValueFactory("nome"));
        columTel.setCellValueFactory(new PropertyValueFactory("telefone"));
        columEmail.setCellValueFactory(new PropertyValueFactory("email"));
        columTipo.setCellValueFactory(new PropertyValueFactory("tipoContato"));
        tabela.setItems(lista);
    }
    
    @FXML
    void selecionar(MouseEvent event){
        if(tabela.getSelectionModel().getSelectedItem()!=null){
            Principal contato = tabela.getSelectionModel().getSelectedItem();
            txtNome.setText(contato.getNome());
            txtEmail.setText(contato.getEmail());
            txtTelefone.setText(contato.getTelefone());
            cbTipo.getSelectionModel().select(contato.getTipoContato());
            novo = false;
        }
        
    }
    
    
    

   
}
