package com.example.fizzbuzz.leafapo;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.fizzbuzz.leafapo.com.base.BaseActivity;

public class ScrollViewActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_view);

        init();
        setListItem();
    }

    public void setListItem(){
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.scrollLinearContainer);

        for(int i = 0; i< this.apoPages.size(); i++){
            View v = this.getLayoutInflater().inflate(R.layout.single_row_item, (ViewGroup) findViewById(R.id.scrollLinearContainer), false);

            //View v = LayoutInflater.from(this.getApplicationContext()).inflate(R.layout.single_row_item, null);
            TextView tv = new TextView(this);
            tv.setBackgroundColor(Color.parseColor("#ffffff"));
            tv.setText("aaa");
            tv.setHeight(1000);

            final int jump = i;
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(ScrollViewActivity.this, MainActivity.class);
                    intent.putExtra("jump", jump);
                    startActivity(intent);
                }
            });

            linearLayout.addView(v);
        }


    }
}
