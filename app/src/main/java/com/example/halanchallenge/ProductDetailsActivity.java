package com.example.halanchallenge;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.arindicatorview.ARIndicatorView;
import com.example.halanchallenge.model.Product;


public class ProductDetailsActivity extends AppCompatActivity {

    Product product;

    TextView description, title, price;
    Button back;
    ARIndicatorView indicatorView;

    RecyclerView imagesListRV;

    ImagesAdapter imagesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        description = findViewById(R.id.product_description_tv);
        title = findViewById(R.id.product_title_tv);
        back = findViewById(R.id.materialButton);
        price = findViewById(R.id.product_price_tv);
        imagesListRV = findViewById(R.id.product_images_banner);
        indicatorView = findViewById(R.id.ar_indicator);

        Bundle bundle = getIntent().getBundleExtra("PARCELABLE");
        product = (Product) bundle.getParcelable("ITEM");

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        description.setText(product.getDealDescription());
        title.setText(product.getArName());
        description.setMovementMethod(new ScrollingMovementMethod());
        price.setText("كاش" + "           " + product.getPrice() + "جنيه");

        imagesAdapter = new ImagesAdapter(this, product.getImages());
        imagesListRV.setAdapter(imagesAdapter);

        indicatorView.attachTo(imagesListRV, true);

    }


}