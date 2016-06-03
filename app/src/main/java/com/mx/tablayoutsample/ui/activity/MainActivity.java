package com.mx.tablayoutsample.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.flyco.tablayout.SegmentTabLayout;
import com.mx.tablayoutsample.R;
import com.mx.tablayoutsample.ui.fragment.OldAnswerFragment;
import com.mx.tablayoutsample.ui.fragment.RelatedBookFragment;
import com.mx.tablayoutsample.ui.fragment.TodayAnswerFragment;
import com.mx.tablayoutsample.utils.ViewFindUtils;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    private String[]titles={"相关电子书","今日答题","往日答题"};

    private ArrayList<Fragment>mFragments=new ArrayList<>();
    private View mDecorView;
    private SegmentTabLayout mTabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDecorView=getWindow().getDecorView();
        mTabLayout= ViewFindUtils.find(mDecorView,R.id.tabLayout);



            mFragments.add( RelatedBookFragment.getInstance());
            mFragments.add( TodayAnswerFragment.getInstance());
            mFragments.add( OldAnswerFragment.getInstance());


        mTabLayout.setTabData(titles,this,R.id.container,mFragments);


    }
}
