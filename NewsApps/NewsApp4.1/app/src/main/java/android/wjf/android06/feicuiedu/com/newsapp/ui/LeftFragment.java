package android.wjf.android06.feicuiedu.com.newsapp.ui;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.wjf.android06.feicuiedu.com.newsapp.R;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

/**
 * Created by chenyan on 2016/11/23.
 */

public class LeftFragment extends Fragment {

    private SlidingMenu menu;

    public LeftFragment() {
    }

    private String title = "";
    private IResponse2 iResponse2;

    public SlidingMenu getMenu() {
        return menu;
    }

    public void setMenu(SlidingMenu menu) {
        this.menu = menu;
    }

    public LeftFragment(SlidingMenu menu, IResponse2 iResponse2) {

        this.menu = menu;
        this.iResponse2 = iResponse2;
    }

    //左侧分类
    private RelativeLayout rlNews;
    private RelativeLayout rlRead;
    private RelativeLayout rlLocal;
    private RelativeLayout rlComment;
    private RelativeLayout rlPhoto;

    private Activity fromActivity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_left, container, false);

        fromActivity = getActivity();

        rlNews = (RelativeLayout) view.findViewById(R.id.rl_news);
        rlRead = (RelativeLayout) view.findViewById(R.id.rl_reading);
        rlLocal = (RelativeLayout) view.findViewById(R.id.rl_local);
        rlComment = (RelativeLayout) view.findViewById(R.id.rl_commnet);
        rlPhoto = (RelativeLayout) view.findViewById(R.id.rl_photo);

        rlNews.setBackgroundResource(R.color.colorRL);

        rlNews.setOnClickListener(oclRL);
        rlRead.setOnClickListener(oclRL);
        rlLocal.setOnClickListener(oclRL);
        rlComment.setOnClickListener(oclRL);
        rlPhoto.setOnClickListener(oclRL);


        return view;
    }

    private void setSelected() {

        rlNews.setBackgroundResource(R.color.colorRLW);
        rlRead.setBackgroundResource(R.color.colorRLW);
        rlLocal.setBackgroundResource(R.color.colorRLW);
        rlComment.setBackgroundResource(R.color.colorRLW);
        rlPhoto.setBackgroundResource(R.color.colorRLW);
    }

    private View.OnClickListener oclRL = new View.OnClickListener() {

        @Override
        public void onClick(View view) {

            setSelected();
            menu.toggle();

            switch (view.getId()) {

                case R.id.rl_news:
                    title = "新闻";
                    rlNews.setBackgroundResource(R.color.colorRL);
                    Toast.makeText(fromActivity, "新闻", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.rl_reading:
                    title = "收藏";
                    rlRead.setBackgroundResource(R.color.colorRL);
                    Toast.makeText(fromActivity, "收藏", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.rl_local:
                    title = "本地";
                    rlLocal.setBackgroundResource(R.color.colorRL);
                    Toast.makeText(fromActivity, "本地", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.rl_commnet:
                    title = "跟帖";
                    rlComment.setBackgroundResource(R.color.colorRL);
                    Toast.makeText(fromActivity, "跟帖", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.rl_photo:
                    title = "图片";
                    rlPhoto.setBackgroundResource(R.color.colorRL);
                    Toast.makeText(fromActivity, "图片", Toast.LENGTH_SHORT).show();
                    break;
            }
            iResponse2.onReturn(title);

        }
    };

    public interface IResponse2 {
        public void onReturn(String result);
    }
}
