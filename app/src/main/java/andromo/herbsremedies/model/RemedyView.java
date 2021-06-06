package andromo.herbsremedies.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RemedyView {
    @SerializedName("remedy")
    @Expose

    private List<RemedyModel> spllist;


    public List<RemedyModel> getText(){
        return spllist;
    }

    public void setAlbums(List<RemedyModel> spllist){
        this.spllist = spllist;
    }
}
