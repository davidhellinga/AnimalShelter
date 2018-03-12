import Animals.Animal;
import Animals.AnimalType;
import Animals.Gender;
import Animals.Reservor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.net.URL;
import java.time.LocalDate;
import java.util.*;

public class Controller implements Initializable {
    @FXML
    private ListView<String> shelter_animalList;
    @FXML
    private TextField shelter_reservor;
    @FXML
    private ListView<String> shelter_info;
    @FXML
    private TextField addAnimal_tf_Name;
    @FXML
    private ComboBox addAnimal_cb_Type;
    @FXML
    private RadioButton addAnimal_rb_Male;
    @FXML
    private Label addAnimal_lb_BadHabit;
    @FXML
    private TextField addAnimal_tb_BadHabit;

    private Reservation reservation = new Reservation();

    public Controller() {
        reservation.addObserver((o, arg) -> {
            shelter_animalList.getItems().clear();
            PopulateAnimalList();
        });
    }

    private void PopulateAnimalList() {
        for (Animal animal : reservation.getAnimals()) {
            shelter_animalList.getItems().add(animal.getName());
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        PopulateAnimalList();
    }

    public void AddAnimal(ActionEvent actionEvent) {
        String name = addAnimal_tf_Name.textProperty().get();
        AnimalType animalType = addAnimal_cb_Type.getValue().toString().equals("Cat") ? AnimalType.Cat : AnimalType.Dog;
        Gender gender = addAnimal_rb_Male.isSelected() ? Gender.Male : Gender.Female;
        if (animalType == AnimalType.Cat) {
            reservation.NewCat(name, gender, addAnimal_tb_BadHabit.textProperty().get());
        } else {
            reservation.NewDog(name, gender);

        }
    }


    public void HabitShown(ActionEvent actionEvent) {
        if (addAnimal_cb_Type.getValue().toString().equals("Cat")) {
            addAnimal_lb_BadHabit.setVisible(true);
            addAnimal_tb_BadHabit.setVisible(true);
        } else {
            addAnimal_lb_BadHabit.setVisible(false);
            addAnimal_tb_BadHabit.setVisible(false);
        }
    }

    public void ConfirmReservor(ActionEvent actionEvent) {
        Reservor reservor = new Reservor(shelter_reservor.textProperty().get(), LocalDate.now());
        reservation.getAnimals().get(shelter_animalList.getSelectionModel().getSelectedIndex()).setReserver(reservor);
        SetInformationLogic();
    }

    public void ConfirmEdit(ActionEvent actionEvent) {
        //Extra function, no backend support and not specified in project description.
        throw new NotImplementedException();
    }

    public void SetInformation(MouseEvent mouseEvent) {
        SetInformationLogic();
    }

    private void SetInformationLogic() {
        shelter_info.getItems().clear();
        String[] fields = reservation.getAnimals().get(shelter_animalList.getSelectionModel().getSelectedIndex()).toString().split("\\s*,\\s*");
        for (String field : fields) {
            shelter_info.getItems().add(field);
        }
    }
}
