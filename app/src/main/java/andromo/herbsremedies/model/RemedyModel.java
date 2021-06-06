package andromo.herbsremedies.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RemedyModel {
    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("pic")
    @Expose
    private String pic;

    @SerializedName("url")
    @Expose
    private String url;

    @SerializedName("txt")
    @Expose
    private String txt;


    public RemedyModel(String name, String url, String pic , String txt) {
        this.name = name;
        this.url = url;
        this.pic = pic;
        this.txt = txt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    //public void setBenifits(String benifits)
    public void setUrl(String url) {
        this.url = url;
    }


    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }
}
