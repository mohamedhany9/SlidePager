package com.example.slidescreen;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SlideAdapter  extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SlideAdapter(Context context) {
        this.context = context;
    }

    public int[] slide_img = {

            R.drawable.eat,
            R.drawable.code,
            R.drawable.sleep,
    };
    public String[] slide_name = {

            "Eat",
            "Sleep",
            "Code"
    };
    public String[] slide_des = {

            "An international organization, based in New York which aims to preserve peace around the world ",
            " Other branches of the United Nations include the World Bank, the International",
            "Secretary General of the United Nations is Kofi Annan"
    };

    @Override
    public int getCount() {
        return slide_name.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view==(RelativeLayout)o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout,container,false);

        ImageView slideImageView = view.findViewById(R.id.img);
        TextView slideHeading = view.findViewById(R.id.slide_name);
        TextView slideDesc = view.findViewById(R.id.slide_des);

        slideImageView.setImageResource(slide_img[position]);
        slideHeading.setText(slide_name[position]);
        slideDesc.setText(slide_des[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((RelativeLayout) object);
    }
}






