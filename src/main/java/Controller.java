import Animals.Animal;
import Animals.AnimalType;
import Animals.Gender;
import Animals.Reservor;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.time.LocalDate;
import java.util.*;

public class Controller implements Initializable {

    public ListView shelter_animalList;
    public TextField shelter_reservor;
    public Button shelter_reservorConfirm;
    public ListView shelter_info;
    public TextField shelter_infoEdit;
    public Button shelter_infoEditConfirm;

    public TextField addAnimal_tf_Name;
    public ComboBox addAnimal_cb_Type;
    public ToggleGroup addAnimal_rbg_Types;
    public RadioButton addAnimal_rb_Male;
    public RadioButton addAnimal_rb_Female;
    public Label addAnimal_lb_BadHabit;
    public TextField addAnimal_tb_BadHabit;
    public Button addAnimal_btn_Add;

    Reservation reservation = new Reservation();

    public Controller() {
        reservation.addObserver(new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                shelter_animalList.getItems().clear();
                for (Animal animal: reservation.getAnimals()){
                    shelter_animalList.getItems().add(animal.getName());
                }
            }
        });
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (Animal animal: reservation.getAnimals()){
            shelter_animalList.getItems().add(animal.getName());
        }
    }

    public boolean AddAnimal(ActionEvent actionEvent) {
        String name = addAnimal_tf_Name.textProperty().get();
        AnimalType animalType = addAnimal_cb_Type.getValue().toString().equals("Cat") ? AnimalType.Cat : AnimalType.Dog;
        Gender gender = addAnimal_rb_Male.isSelected() ? Gender.Male : Gender.Female;
        if (animalType == AnimalType.Cat) {
            reservation.NewCat(name, gender, addAnimal_tb_BadHabit.textProperty().get());
            return true;
        } else if (animalType == AnimalType.Dog) {
            reservation.NewDog(name, gender);
            return true;
        }
        return false;
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
        Reservor reservor=new Reservor(shelter_reservor.textProperty().get(), LocalDate.now());
        reservation.getAnimals().get(shelter_animalList.getSelectionModel().getSelectedIndex()).setReserver(reservor);
        SetInformationLogic();
    }

    public void ConfirmEdit(ActionEvent actionEvent) {
    }

    public void SetInformation(MouseEvent mouseEvent) {
        SetInformationLogic();
    }

    private void SetInformationLogic() {
        shelter_info.getItems().clear();
        String[] fields=reservation.getAnimals().get(shelter_animalList.getSelectionModel().getSelectedIndex()).toString().split("\\s*,\\s*");
        for (String field: fields) {
            shelter_info.getItems().add(field);
        }
    }
}
