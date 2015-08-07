package njerry.freshbox.Getterssetters;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;

/**
 * Created by root on 8/7/15.
 */
@ParseClassName("Categories")
public class Categories extends ParseObject {

    public Categories(){

    }

    public String getType(){
        return getString("type");
    }

    public void setType(String type){
        put("type", type);
    }

    public ParseFile getcategoryimage(){
        return getParseFile("categoryimage");
    }

    public void setcategoryimage(ParseFile file){
        put("categoryimage", file);
    }
}
