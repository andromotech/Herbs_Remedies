package andromo.herbsremedies.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HerbsView {
    @SerializedName("herbs")
    @Expose

    private List<HerbsModel> mantralist;

    public List<HerbsModel> getMantraView(){
        return mantralist;
    }

    public void setMantraView(List<HerbsModel> mantralist){
        this.mantralist = mantralist;
    }
}