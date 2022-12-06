module avaliacao.cadastroavaliacao {
    requires javafx.controls;
    requires javafx.fxml;

    opens avaliacao.cadastroavaliacao to javafx.fxml;
    exports avaliacao.cadastroavaliacao;
}
