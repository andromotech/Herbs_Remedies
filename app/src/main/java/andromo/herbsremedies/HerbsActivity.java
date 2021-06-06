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
import andromo.herbsremedies.adapter.HerbsAdp;
import andromo.herbsremedies.model.HerbsModel;
import andromo.herbsremedies.model.HerbsView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HerbsActivity extends Fragment {
    private List<HerbsModel> spllist;
    private View myFragmentView;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        myFragmentView = inflater.inflate(
                R.layout.audio_play, container, false);

            try {
                Client Clt = new Client();
                Server apiServer =
                        Clt.getClient().create(Server.class);
                Call<HerbsView> call = apiServer.getMantraView();
                call.enqueue(new Callback<HerbsView>() {
                    @Override
                    public void onResponse(Call<HerbsView> call, Response<HerbsView> response) {
                        List<HerbsModel> items = response.body().getMantraView();
                        spllist = new ArrayList<>();
                        HerbsAdp firstAdapter = new HerbsAdp(getContext(), items);
                        RecyclerView firstRecyclerView = (RecyclerView) myFragmentView.findViewById(R.id.recycler_view1);
                        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 2);
                        firstRecyclerView.setLayoutManager(mLayoutManager);
                        firstRecyclerView.setAdapter(firstAdapter);
                    }

                    @Override
                    public void onFailure(Call<HerbsView> call, Throwable t) {
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

