package andromo.herbsremedies.RestCall;
import andromo.herbsremedies.model.HerbsView;
import andromo.herbsremedies.model.RemedyView;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Server {
    @GET("/herb/rem.json")
    Call<RemedyView> getText();
    @GET("/herb/herbs.json")
    Call<HerbsView> getMantraView();
}

