package org.openjfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import org.json.simple.parser.ParseException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.awt.*;

public class PrimaryController {

    @FXML
    private Button goToLinkButton;
    @FXML
    private Text linkText;
    @FXML
    private Button nextRecipeButton;
    @FXML
    private ImageView recipeImage;
    private Recipe randomRecipe;

    @FXML
    public void goToLink(ActionEvent event) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI(randomRecipe.getUrl()));
    }

    @FXML
    public void nextRecipe(ActionEvent event) throws IOException, ParseException {
        this.randomRecipe = new Recipe();
        URL url = new URL(randomRecipe.imageUrl);
        Image image = new Image(String.valueOf(url));
        if(url!=null){
            recipeImage.setImage(image);
            linkText.setText(randomRecipe.getTitle());
        } else{
            System.out.println("null");
        }
    }
}
