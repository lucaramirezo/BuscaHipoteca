package buscaHipoteca.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ComparadorController {

    // Campos del formulario
    @FXML
    private TextField importeInicialField;

    @FXML
    private ComboBox<String> tipoHipotecaComboBox;

    @FXML
    private ComboBox<String> finalidadComboBox;

    @FXML
    private ComboBox<String> bancoComboBox;

    @FXML
    private FlowPane chipsFlowPane; // Para mostrar los bancos seleccionados como "chips".

    @FXML
    private Button compararButton;

    // Tarjetas de comparación
    @FXML
    private VBox banco1Card;
    @FXML
    private Label banco1NombreLabel;
    @FXML
    private Label banco1PrecioLabel;
    @FXML
    private ListView<String> banco1CaracteristicasListView;
    @FXML
    private Button banco1Button;

    @FXML
    private VBox banco2Card;
    @FXML
    private Label banco2NombreLabel;
    @FXML
    private Label banco2PrecioLabel;
    @FXML
    private ListView<String> banco2CaracteristicasListView;
    @FXML
    private Button banco2Button;

    // Lista de bancos seleccionados
    private final List<String> bancosSeleccionados = new ArrayList<>();

    @FXML
    public void initialize() {
        // Inicialización de opciones en los ComboBox
        tipoHipotecaComboBox.getItems().addAll("Fija", "Variable", "Mixta");
        finalidadComboBox.getItems().addAll("Primera vivienda", "Segunda vivienda", "Inversión");
        bancoComboBox.getItems().addAll("Santander", "ING", "BBVA", "CaixaBank");

        // Configuración del botón "Comparar"
        compararButton.setOnAction(event -> realizarComparacion());
    }

    /**
     * Método que se ejecuta al pulsar el botón "Comparar".
     */
    private void realizarComparacion() {
        if (importeInicialField == null || tipoHipotecaComboBox == null || finalidadComboBox == null) {
            mostrarAlerta("Error interno", "Algunos campos del formulario no están cargados correctamente.");
            return;
        }

        String importe = (importeInicialField.getText() != null) ? importeInicialField.getText().trim() : "";
        String tipoHipoteca = tipoHipotecaComboBox.getValue();
        String finalidad = finalidadComboBox.getValue();

        if (importe.isEmpty() || tipoHipoteca == null || finalidad == null || bancoComboBox == null) {
            mostrarAlerta("Datos incompletos", "Por favor, completa todos los campos y selecciona al menos un banco.");
            return;
        }

        // Simulación de resultados de comparación
        mostrarResultados("Santander", "€50 / mes", Arrays.asList("Interés fijo 1.5%", "Plazo 30 años"));
        mostrarResultados("ING", "€45 / mes", Arrays.asList("Interés variable Euribor + 1.2%", "Plazo 25 años"));
    }


    /**
     * Muestra los resultados en las tarjetas de comparación.
     */
    private void mostrarResultados(String banco, String precio, List<String> caracteristicas) {
        if (banco.equals("Santander")) {
            banco1NombreLabel.setText(banco);
            banco1PrecioLabel.setText(precio);
            banco1CaracteristicasListView.getItems().setAll(caracteristicas);
            banco1Card.setVisible(true);
        } else if (banco.equals("ING")) {
            banco2NombreLabel.setText(banco);
            banco2PrecioLabel.setText(precio);
            banco2CaracteristicasListView.getItems().setAll(caracteristicas);
            banco2Card.setVisible(true);
        }
    }

    /**
     * Muestra una alerta al usuario.
     */
    private void mostrarAlerta(String titulo, String mensaje) {
        System.out.println(titulo + ": " + mensaje); // Puedes reemplazarlo por un cuadro de diálogo en JavaFX si prefieres
    }

    /**
     * Método para manejar la selección de un banco desde el ComboBox.
     */
    @FXML
    private void agregarBancoSeleccionado() {
        String bancoSeleccionado = bancoComboBox.getValue();
        if (bancoSeleccionado != null && !bancosSeleccionados.contains(bancoSeleccionado)) {
            bancosSeleccionados.add(bancoSeleccionado);
            Label chip = new Label(bancoSeleccionado);
            chip.setStyle("-fx-background-color: #E2E8F0; -fx-padding: 5 10; -fx-border-radius: 15; -fx-background-radius: 15;");
            chipsFlowPane.getChildren().add(chip);
        }
    }
}
