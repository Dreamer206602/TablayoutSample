package com.mx.tablayoutsample.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.mx.tablayoutsample.R;
import com.mx.tablayoutsample.model.AnswerInfo;
import com.mx.tablayoutsample.model.QuestionInfo;
import com.zhy.base.adapter.ViewHolder;
import com.zhy.base.adapter.recyclerview.CommonAdapter;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class OldAnswerFragment extends Fragment {

    /**
     * 能否更改答案
     */
    private boolean bEdit = false;

    private static OldAnswerFragment sOldAnswerFragment;
    @Bind(R.id.recyclerView)
    RecyclerView mRecyclerView;

    private ArrayList<QuestionInfo>mInfos=new ArrayList<>();



    public static OldAnswerFragment getInstance() {

        sOldAnswerFragment = new OldAnswerFragment();

        return sOldAnswerFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_old_answer, container, false);
        ButterKnife.bind(this, view);
        return view;

    }

    @Override
    public void onResume() {
        super.onResume();
        for (int i = 0; i < 4; i++) {
            QuestionInfo info = new QuestionInfo();
            info.setId(i+"bygone");
            info.setQuestion("问题" + (i + 1) + ":第二次世界大战开始于？");
            ArrayList<AnswerInfo> answerInfos = new ArrayList<>();
            answerInfos.add(new AnswerInfo(i+"bygone", "A", "A、1939年9月1日，波兰", true, true));
            answerInfos.add(new AnswerInfo(i+"bygone", "B", "B、1939年4月1日，波兰"));
            answerInfos.add(new AnswerInfo(i+"bygone", "C", "C、1929年9月1日，波兰"));
            answerInfos.add(new AnswerInfo(i+"bygone", "D", "D、1939年1月1日，波兰"));
            info.setAnswerList(answerInfos);
            mInfos.add(info);
        }

        LinearLayoutManager manager=new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(new CommonAdapter<QuestionInfo>(getActivity(), R.layout.item_today_question, mInfos) {
            @Override
            public void convert(final ViewHolder viewHilder, final QuestionInfo info) {


                final int position = getPosition(viewHilder);
                viewHilder.setText(R.id.listadapter_answer_tv_question,info.getQuestion());
                for (int i = 0; i < info.getAnswerList().size(); i++) {
                    if ("A".equals(info.getAnswerList().get(i).getAnswerId())) {
                        viewHilder.setText(R.id.listadapter_answer_rb_answer1,info.getAnswerList().get(i).getAnswerContent());
                        if (info.getAnswerList().get(i).isSelected()) {
                            viewHilder.setChecked(R.id.listadapter_answer_rb_answer1,true);
                        }
                    } else if ("B".equals(info.getAnswerList().get(i).getAnswerId())) {
                        viewHilder.setText(R.id.listadapter_answer_rb_answer2,info.getAnswerList().get(i).getAnswerContent());
                        if (info.getAnswerList().get(i).isSelected()) {
                            viewHilder.setChecked(R.id.listadapter_answer_rb_answer2,true);
                        }
                    } else if ("C".equals(info.getAnswerList().get(i).getAnswerId())) {
                        viewHilder.setText(R.id.listadapter_answer_rb_answer3,info.getAnswerList().get(i).getAnswerContent());
                        if (info.getAnswerList().get(i).isSelected()) {
                            viewHilder.setChecked(R.id.listadapter_answer_rb_answer3,true);
                        }
                    } else if ("D".equals(info.getAnswerList().get(i).getAnswerId())) {
                        viewHilder.setText(R.id.listadapter_answer_rb_answer4,info.getAnswerList().get(i).getAnswerContent());
                        if (info.getAnswerList().get(i).isSelected()) {
                            viewHilder.setChecked(R.id.listadapter_answer_rb_answer4,true);
                        }
                    }
                }

                if (bEdit) {
                    viewHilder.setOnCheckedChangeListener(R.id.listadapter_answer_rg_answer,new RadioGroup.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(RadioGroup group, int checkedId) {
                            int i = 0;
                            if (checkedId == viewHilder.getView(R.id.listadapter_answer_rb_answer1).getId()) {
                                i = 0;
                                info.getAnswerList().get(i).setSelected(true);

                            } else if (checkedId == viewHilder.getView(R.id.listadapter_answer_rb_answer2).getId()) {
                                i = 1;
                                info.getAnswerList().get(i).setSelected(true);
                            } else if (checkedId == viewHilder.getView(R.id.listadapter_answer_rb_answer3).getId()) {
                                i = 2;
                                info.getAnswerList().get(i).setSelected(true);
                            } else if (checkedId == viewHilder.getView(R.id.listadapter_answer_rb_answer4).getId()) {
                                i = 3;
                                info.getAnswerList().get(i).setSelected(true);
                            }

//                            for (int j = 0 ; j < info.getAnswerList().size() ; j++) {
//                                if (i == j) {
//                                    info.getAnswerList().get(j).setSelected(true);
//                                } else {
//                                    info.getAnswerList().get(j).setSelected(false);
//                                }
//                            }
                            mInfos.set(position, info);
//                            Message msg = new Message();
//                            msg.obj = QuestionAdapter.this;
//                            msg.what = CmnObjectDefines.Handler_ListItemClicked;
//                            Bundle bundle = new Bundle();
//                            bundle.putSerializable(CmnObjectDefines.Const_Serializable_Key, info);
//                            msg.setData(bundle);
//                            mHandler.sendMessage(msg);
                        }
                    });
                } else {
                    viewHilder.setClickable2(R.id.listadapter_answer_rg_answer,false);
                    viewHilder.setClickable(R.id.listadapter_answer_rb_answer1,false);
                    viewHilder.setClickable(R.id.listadapter_answer_rb_answer2,false);
                    viewHilder.setClickable(R.id.listadapter_answer_rb_answer3,false);
                    viewHilder.setClickable(R.id.listadapter_answer_rb_answer4,false);

                }



            }
        });




    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
