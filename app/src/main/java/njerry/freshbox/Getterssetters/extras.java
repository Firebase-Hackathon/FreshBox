package njerry.freshbox.Getterssetters;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;

/**
 * Created by root on 8/7/15.
 */
@ParseClassName("extras")
public class extras extends ParseObject {

    public extras(){

    }

    public String getName(){
        return getString("Name");
    }

    public void setName(String Name){
        put("Name", Name);
    }

    public Number getPrice(){
        return getNumber("price");
    }

    public void setPrice(Number price){
        put("price", price);
    }

    public ParseFile getImage(){
        return getParseFile("Image");
    }

    public void setImage(ParseFile Image){
        put("Image", Image);
    }
}