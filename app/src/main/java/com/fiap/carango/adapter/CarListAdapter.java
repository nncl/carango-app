package com.fiap.carango.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fiap.carango.R;
import com.fiap.carango.model.Car;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CarListAdapter extends RecyclerView.Adapter<CarListAdapter.CarsViewHolder> {

    private Context c;
    private List<Car> cars;

    public CarListAdapter(Context c, List<Car> cars) {
        this.c = c;
        this.cars = cars; // that's our f data, and now we bind this information
    }

    // Create viewholder
    @Override
    public CarsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(c)
                .inflate(R.layout.car_item, parent, false);

        return new CarsViewHolder(v);
    }

    // Bind list items
    @Override
    public void onBindViewHolder(CarsViewHolder holder, int position) {
        holder.tvName.setText(cars.get(position).getName());
        holder.tvDesc.setText(cars.get(position).getDescription());

        // TODO cache images
        Picasso
                .with(c)
                .load(cars.get(position).getImage())
                .placeholder(R.mipmap.ic_launcher) // default image while image is loadind
                .error(R.mipmap.ic_launcher) // default image when some error has ocurred whilte loading image from Webservice
                .into(holder.ivImage);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class CarsViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvDesc;
        ImageView ivImage;

        public CarsViewHolder(View itemView) {
            super(itemView);

            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvDesc = (TextView) itemView.findViewById(R.id.tvDesc);
            ivImage = (ImageView) itemView.findViewById(R.id.ivImage);
        }
    }

}
