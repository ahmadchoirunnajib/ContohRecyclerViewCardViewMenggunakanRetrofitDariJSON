package id.co.pln.plnweeeeew;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import id.co.pln.plnweeeeew.adapter.PlnweeeeewAdapter;
import id.co.pln.plnweeeeew.api.RetrofitArrayAPI;
import id.co.pln.plnweeeeew.model.Plnweeeeew;
import id.co.pln.plnweeeeew.utils.Params;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    List<Plnweeeeew>  listUnit;
    private RecyclerView recyclerView;
    PlnweeeeewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getBaseContext(), 1);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        listUnit = new ArrayList<>();

        panggilDataUnit();
    }

    private void panggilDataUnit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Params.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitArrayAPI service = retrofit.create(RetrofitArrayAPI.class);
        Call<List<Plnweeeeew>> call = service.getPerizinanUnit();
        call.enqueue(new Callback<List<Plnweeeeew>>() {
            @Override
            public void onResponse(Call<List<Plnweeeeew>> call, Response<List<Plnweeeeew>> response) {

                try {
                    final List<Plnweeeeew> responseData = response.body();
                    if (!responseData.isEmpty()) {
                        listUnit = responseData;
                        adapter = new PlnweeeeewAdapter(getBaseContext(), listUnit);

                        adapter.notifyDataSetChanged();

                        recyclerView.setAdapter(adapter);
                    } else {
                        Toast.makeText(getBaseContext(), "Gagal konek server", Toast.LENGTH_SHORT).show();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void onFailure(Call<List<Plnweeeeew>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Gagal Embuh = "+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
