package com.fiap.carango.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.fiap.carango.R;
import com.fiap.carango.adapter.CarListAdapter;
import com.fiap.carango.api.CarAPI;
import com.fiap.carango.contants.Constants;
import com.fiap.carango.model.Car;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class CarsFragment extends Fragment implements Callback<List<Car>> {

    private String type;
    private CarListAdapter adapter;
    protected RecyclerView rvCars;

    public CarsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);

        if (getArguments() != null) {
            this.type = getArguments().getString("type");
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_cars, container, false);
        rvCars = (RecyclerView) v.findViewById(R.id.rvCars);
        rvCars.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvCars.setHasFixedSize(true);

        // Inflate the layout for this fragment
        return v;
    }

    @Override
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        loadCars();
    }

    private void loadCars() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.HeiderURL.getUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // prepara a chamada no Retrofit 2.0
        CarAPI carAPI = retrofit.create(CarAPI.class);
        Call<List<Car>> call = carAPI.findBy(type);

        // async call
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<List<Car>> call, Response<List<Car>> response) {
        adapter = new CarListAdapter(getContext(), response.body());
        rvCars.setAdapter(adapter);
    }


    // Handle error
    @Override
    public void onFailure(Call<List<Car>> call, Throwable t) {
        Toast.makeText(getContext(),
                "Daahell yo, " + t.getMessage(),
                Toast.LENGTH_LONG).show();
    }
}
