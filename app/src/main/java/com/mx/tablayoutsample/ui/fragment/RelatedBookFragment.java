package com.mx.tablayoutsample.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.mx.tablayoutsample.R;
import com.mx.tablayoutsample.model.ReleatedEBookInfo;
import com.mx.tablayoutsample.ui.activity.MainActivity;
import com.zhy.base.adapter.ViewHolder;
import com.zhy.base.adapter.recyclerview.CommonAdapter;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */

/**
 * 相关电子书界面
 */
public class RelatedBookFragment extends Fragment {


    private static RelatedBookFragment sRelatedBookFragment;
    @Bind(R.id.recyclerView)
    RecyclerView mRecyclerView;
    public static RelatedBookFragment getInstance() {
        sRelatedBookFragment = new RelatedBookFragment();
        return sRelatedBookFragment;
    }

    private ArrayList<ReleatedEBookInfo> mList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_related_book, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        initData();




    }

    private void initData() {
        for (int i = 0; i <12; i++) {
            mList.add(new ReleatedEBookInfo("标题标题标题标题"+i,"标签"+i));
        }

        GridLayoutManager manager=new GridLayoutManager(getActivity(),3, LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(new CommonAdapter<ReleatedEBookInfo>(getActivity(), R.layout.item_related_book, mList) {
            @Override
            public void convert(ViewHolder holder, ReleatedEBookInfo releatedEBookInfo) {
                holder.setText(R.id.listadapter_releated_ebook_tv_title,releatedEBookInfo.getTitle() );
                holder.setText(R.id.listadapter_releated_ebook_tv_label,releatedEBookInfo.getLabel() );

                final int position = getPosition(holder);

                holder.getConvertView().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Toast.makeText(getActivity(),"position:"+position,Toast.LENGTH_SHORT).show();
                    }
                });

            }


        });



    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
