package andromo.herbsremedies.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HerbsModel {
       @SerializedName("name")
       @Expose
        private String name;
        @SerializedName("pic")
        @Expose
        private String pic;

        @SerializedName("txt")
        @Expose
        private String txt;


        public HerbsModel(String name, String txt, String pic) {
            this.name = name;
            this.txt = txt;
            this.pic = pic;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTxt() {
            return txt;
        }

        //public void setBenifits(String benifits)
        public void setTxt(String txt) {
            this.txt = txt;
        }


        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }
}
