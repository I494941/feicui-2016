package android.wjf.android06.feicuiedu.com.newsapp.ui;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.wjf.android06.feicuiedu.com.newsapp.R;

import org.xutils.view.annotation.ViewInject;

/**
 * Created by chenyan on 2016/11/23.
 */

public class LeftFragment extends Fragment {


    //左侧分类
    @ViewInject(R.id.rl_news)
    private RelativeLayout rlNews;
    @ViewInject(R.id.rl_reading)
    private RelativeLayout rlRead;
    @ViewInject(R.id.rl_local)
    private RelativeLayout rlLocal;
    @ViewInject(R.id.rl_commnet)
    private RelativeLayout rlComment;
    @ViewInject(R.id.rl_photo)
    private RelativeLayout rlPhoto;

    Intent intent;
    Activity fromActivity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_left, container, false);

        fromActivity = getActivity();

        rlNews = (RelativeLayout) view.findViewById(R.id.rl_news);
        rlRead = (RelativeLayout) view.findViewById(R.id.rl_reading);
        rlLocal = (RelativeLayout) view.findViewById(R.id.rl_local);
        rlComment = (RelativeLayout) view.findViewById(R.id.rl_commnet);
        rlPhoto = (RelativeLayout) view.findViewById(R.id.rl_photo);

        // android:background="#33c85555"

        // rlNews.setBackgroundResource(R.color.colorRL);

        rlNews.setOnClickListener(oclRL);
        rlRead.setOnClickListener(oclRL);
        rlLocal.setOnClickListener(oclRL);
        rlComment.setOnClickListener(oclRL);
        rlPhoto.setOnClickListener(oclRL);


        return view;
    }

    private void initRL() {

        rlNews.setBackgroundResource(R.color.colorRLW);
        rlRead.setBackgroundResource(R.color.colorRLW);
        rlLocal.setBackgroundResource(R.color.colorRLW);
        rlComment.setBackgroundResource(R.color.colorRLW);
        rlPhoto.setBackgroundResource(R.color.colorRLW);
    }


    private View.OnClickListener oclRL = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            initRL();

            switch (view.getId()) {
                case R.id.rl_news:
                    rlNews.setBackgroundResource(R.color.colorRL);
                    intent = new Intent();
                    intent.setClass(fromActivity, FragmentMain.class);
                    startActivity(intent);
                    break;
                case R.id.rl_reading:
                    rlRead.setBackgroundResource(R.color.colorRL);
                    intent = new Intent();
                    intent.setClass(fromActivity, ActivityRead.class);
                    startActivity(intent);

                    break;
                case R.id.rl_local:
                    rlLocal.setBackgroundResource(R.color.colorRL);
                    break;
                case R.id.rl_commnet:
                    rlComment.setBackgroundResource(R.color.colorRL);
                    break;
                case R.id.rl_photo:
                    rlPhoto.setBackgroundResource(R.color.colorRL);
                    break;
            }
        }
    };
}
