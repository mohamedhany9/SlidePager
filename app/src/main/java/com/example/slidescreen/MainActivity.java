package com.example.slidescreen;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ViewPager mslideViewPager;
    private LinearLayout mDotsLayout;
    private TextView[]mdots;

    private SlideAdapter slideAdapter;
    Button nextButton;
    Button prevButton;
    private int mCurrentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mslideViewPager = findViewById(R.id.viewPager);
        mDotsLayout = findViewById(R.id.dotslayout);
        nextButton = findViewById(R.id.next_button);
        prevButton = findViewById(R.id.previs_button);

        slideAdapter = new SlideAdapter(this);
        mslideViewPager.setAdapter(slideAdapter);

        addDotsIndicator(0);
        mslideViewPager.addOnPageChangeListener(viewListener);


        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mslideViewPager.setCurrentItem(mCurrentPage + 1);
            }
        });
        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mslideViewPager.setCurrentItem(mCurrentPage - 1);
            }
        });
    }

    public void addDotsIndicator(int position)
    {
        mdots=new TextView[3];
        mDotsLayout.removeAllViews();
        for (int i = 0 ; i<mdots.length ; i++)
        {
            mdots[i] =new TextView(this);
            mdots[i].setText(Html.fromHtml("&#8226"));
            mdots[i].setTextSize(35);
            mdots[i].setTextColor(getResources().getColor(R.color.colorAdots2));

            mDotsLayout.addView(mdots[i]);
        }

        if (mdots.length>0)
        {
            mdots[position].setTextColor(getResources().getColor(R.color.colorAdots));
        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {

            addDotsIndicator(i);

            mCurrentPage =i;
            if (i==0)
            {
                nextButton.setEnabled(true);
                prevButton.setEnabled(false);
                prevButton.setVisibility(View.INVISIBLE);

                nextButton.setText("Next");
                prevButton.setText("");
            }
            else if (i==mdots.length-1)
            {
                nextButton.setEnabled(true);
                prevButton.setEnabled(true);
                prevButton.setVisibility(View.VISIBLE);

                nextButton.setText("Finish");
                prevButton.setText("Back");
            }
            else {
                nextButton.setEnabled(true);
                prevButton.setEnabled(true);
                prevButton.setVisibility(View.VISIBLE);

                nextButton.setText("Next");
                prevButton.setText("Back");
            }
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };

}







