package com.fiap.carango;

import android.content.Context;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.fiap.carango.model.Car;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    private TextView name;
    private TextView description;
    private ImageView thumb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        name = (TextView) findViewById(R.id.dtlDesc);
        description = (TextView) findViewById(R.id.dtlDesc);
        thumb = (ImageView) findViewById(R.id.dtlImagem);

        if (getIntent() != null) {
            Car car = getIntent().getParcelableExtra("car");
            name.setText(car.getName());
            description.setText(car.getDescription());

            Picasso
                    .with(this)
                    .load(car.getImage())
                    .placeholder(R.mipmap.ic_launcher)
                    .error(R.mipmap.ic_launcher)
                    .into(thumb);
        }
    }
}
