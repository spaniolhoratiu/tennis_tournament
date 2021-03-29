package layer_presentation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.User;
import repo.GenericRepo;
import repo.UserRepo;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;


public class GUI extends Application //implements EventHandler<ActionEvent>
{
    private Stage window;

    public static void main( String[] args )
    {
//        User user = User.builder().mail("horatiusmail").password("parola").name("horatiu").build();
//        GenericRepo.save(user);

//        User dbUser = UserRepo.findUserByMail("r");
//        System.out.println(dbUser);
//        dbUser.setMail("mail");
//        GenericRepo.update(dbUser);
//
//        dbUser = UserRepo.findUserByMail("mail");
//        System.out.println(dbUser);
//
//        User dbUserAfterDelete = UserRepo.findUserByMail("horatiusmail");
//        System.out.println(dbUserAfterDelete);

//        User user1 = User.builder().mail("user1mail").password("pass1").name("user1").build();
//        User user2 = User.builder().mail("user2mail").password("pass2").name("user2").build();
//        User user3 = User.builder().mail("user3mail").password("pass3").name("user3").build();
//        GenericRepo.save(user1);
//        GenericRepo.save(user2);
//        GenericRepo.save(user3);

        List<User> users = GenericRepo.getAll(User.class);
        users.forEach(System.out::println);

        //launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        ClassLoader classLoader = GUI.class.getClassLoader();
        Parent root = FXMLLoader.load(classLoader.getResource("login.fxml")); // resources/login.fxml
        window=primaryStage;

        Scene mainScene = new Scene(root);
        mainScene.getStylesheets().add("Style.css");
        window.setScene(mainScene);
        window.setTitle("Assignment1");
        window.show();
    }


    public static Scene changeScene(String fxml) throws IOException{
        ClassLoader classLoader = GUI.class.getClassLoader();
        Parent pane = FXMLLoader.load(classLoader.getResource(fxml));

        Stage stage = new Stage();
        Scene newScene = new Scene(pane);
        newScene.getStylesheets().add("Style.css");
        stage.setScene(newScene);
        stage.show();

        return newScene;
    }
}
