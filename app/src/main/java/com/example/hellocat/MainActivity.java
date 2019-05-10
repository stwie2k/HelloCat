package com.example.hellocat;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.hellocat.fragment.BreedFragment;
import com.example.hellocat.fragment.FavouriteFragment;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {



    @BindView(R.id.tl_tabs)
    TabLayout tabLayout;
    @BindView(R.id.vp_content)
    ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Logger.addLogAdapter(new AndroidLogAdapter());


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);



        viewPager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0:

                        return new BreedFragment();
                    case 1:
                        return new FavouriteFragment();

                    case 2:


                    default:
                        return new BreedFragment();
                }
            }

            @Override
            public int getCount() {
                return 3;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                super.destroyItem(container, position, object);
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {

                switch (position) {
                    case 0:
                        return "Breed";
                    case 1:
                        return "Favourite";

                    case 2:

                    default:
                        return "ff";
                }

            }
        });

        tabLayout.setupWithViewPager(viewPager);


    }

//    @Override//从P层获取到的数据  在P层里获取到M层请求的数据
//    public void view(List<Breed> data) {
//        BreedAdapter adapter = new BreedAdapter(this, data);
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//        mRecyclerView.setAdapter(adapter);
//
//    }
}
