package andromo.herbsremedies;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import andromo.herbsremedies.RestCall.Client;
import andromo.herbsremedies.RestCall.Server;
import andromo.herbsremedies.adapter.RemedyAdp;
import andromo.herbsremedies.model.RemedyModel;
import andromo.herbsremedies.model.RemedyView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RemedyActivity extends Fragment {
    private List<RemedyModel> spllist;
    private View myFragmentView;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        myFragmentView = inflater.inflate(
                R.layout.audio_play, container, false);

        try {
            Client Clt = new Client();
            Server apiServer =
                    Clt.getClient().create(Server.class);
            Call<RemedyView> call = apiServer.getText();
            call.enqueue(new Callback<RemedyView>() {
                @Override
                public void onResponse(Call<RemedyView> call, Response<RemedyView> response) {
                    List<RemedyModel> items = response.body().getText();
                    spllist = new ArrayList<>();
                    RemedyAdp firstAdapter = new RemedyAdp(getContext(), items);
                    RecyclerView firstRecyclerView = (RecyclerView) myFragmentView.findViewById(R.id.recycler_view1);
                    RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 2);
                    firstRecyclerView.setLayoutManager(mLayoutManager);
                    firstRecyclerView.setAdapter(firstAdapter);
                }

                @Override
                public void onFailure(Call<RemedyView> call, Throwable t) {
                    Log.d("Error", t.getMessage());
                    Toast.makeText(getContext(), "Error Fetching Data!", Toast.LENGTH_SHORT).show();

                }
            });
        } catch (Exception e) {
            Log.d("Error", e.getMessage());
            Toast.makeText(getContext(), e.toString(), Toast.LENGTH_SHORT).show();
        }

        return myFragmentView;
    }




}