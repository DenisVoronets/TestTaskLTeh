package com.test.testtasklteh;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.test.testtasklteh.RecyclerListActivity;
import com.test.testtasklteh.R;

import androidx.annotation.Nullable;

public class ItemRecyclerListActivity extends Activity {
    private TextView titleOpen,descriptionOpen,dateOpen;
    private ImageView picOpen;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_item);
        titleOpen = findViewById(R.id.textView_title_open);
        descriptionOpen = findViewById(R.id.textView_description_open);
        dateOpen = findViewById(R.id.textView_date_open);
        picOpen = findViewById(R.id.imageView_pic_open);
        if(getIntent()!= null){
            titleOpen.setText(getIntent().getStringExtra("title"));
            descriptionOpen.setText(getIntent().getStringExtra("description"));
            dateOpen.setText(getIntent().getStringExtra("date"));
            picOpen.setImageDrawable(Constans.PIC_NAME);
        } else {
            titleOpen.setText("Error Load");
            descriptionOpen.setText(getIntent().getStringExtra("Error Load"));
            dateOpen.setText(getIntent().getStringExtra("Error Load"));
            picOpen.setImageResource(R.drawable.logo);
        }
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, RecyclerListActivity.class));
        finish();
    }
}
