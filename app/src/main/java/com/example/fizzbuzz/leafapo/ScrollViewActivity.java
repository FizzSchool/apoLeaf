package com.example.fizzbuzz.leafapo;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Outline;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.fizzbuzz.leafapo.com.base.BaseActivity;

public class ScrollViewActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_view);
        init();

        TextView twentySixDay = (TextView) findViewById(R.id.twentySixDay);
        twentySixDay.setTypeface(this.typeface);
        TextView msg = (TextView) findViewById(R.id.msg);
        msg.setTypeface(this.typeface);

        setListItem();
    }

    public void setListItem(){
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.scrollLinearContainer);

        for(int i = 0; i< this.apoPages.size(); i++){
            View v = this.getLayoutInflater().inflate(R.layout.single_row_item, (ViewGroup) findViewById(R.id.scrollLinearContainer), false);


            ImageView imageView = (ImageView) v.findViewById(R.id.singleImage);
            imageView.setImageResource(this.apoPages.get(i).getImage());

            // search view config for greater android version
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP){
                // Do something for lollipop and above versions
                imageView.setOutlineProvider(new ViewOutlineProvider() {
                    @Override
                    public void getOutline(View view, Outline outline) {
                        outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), 8);
                    }
                });
                imageView.setClipToOutline(true);
                imageView.setElevation(10);
            }

            TextView singleMusicName = (TextView) v.findViewById(R.id.singleMusicName);
            singleMusicName.setText(this.apoPages.get(i).getMusicName());
            singleMusicName.setTextSize(14);
            singleMusicName.setTextColor(Color.parseColor("#000000"));
            singleMusicName.setTypeface(this.typeface);

            TextView day = (TextView) v.findViewById(R.id.day);
            day.setText("Ngày " + (i+1));
            day.setTextSize(11);
            day.setTypeface(this.typeface);

            TextView singleNote = (TextView) v.findViewById(R.id.singleNote);
            singleNote.setText("Note: "+ this.apoPages.get(i).getNote());
            singleNote.setTextSize(11);
            singleNote.setTypeface(this.typeface);

            final int jump = i;
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(ScrollViewActivity.this, MainActivity.class);
                    intent.putExtra("jump", jump + 1);
                    startActivity(intent);
                }
            });

            linearLayout.addView(v);
        }


    }
}
