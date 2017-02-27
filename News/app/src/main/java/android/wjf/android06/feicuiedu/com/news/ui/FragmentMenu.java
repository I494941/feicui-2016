package android.wjf.android06.feicuiedu.com.news.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.wjf.android06.feicuiedu.com.news.R;

/**
 * Created by ad06-wjf on 2016/11/30.
 */

/**
 * 左边侧拉界面
 **/
public class FragmentMenu extends Fragment {
    private RelativeLayout[] rls = new RelativeLayout[5];

    //重写onCreateView方法，设置当前的布局
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //利用回调中的参数LayoutInflater对象导入布局文件，并发挥此View
        View view = inflater.inflate(R.layout.fragment_menu_left, container, false);
        rls[0] = (RelativeLayout) view.findViewById(R.id.rl_news);
        rls[1] = (RelativeLayout) view.findViewById(R.id.rl_reading);
        rls[2] = (RelativeLayout) view.findViewById(R.id.rl_local);
        rls[3] = (RelativeLayout) view.findViewById(R.id.rl_commnet);
        rls[4] = (RelativeLayout) view.findViewById(R.id.rl_photo);
        for (int i = 0; i < rls.length; i++) {
            rls[i].setOnClickListener(onClickListener);
        }
        return view;
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            for (int i = 0; i < rls.length; i++) {
                rls[i].setBackgroundColor(0);
            }
            switch (v.getId()) {
                case R.id.rl_news:
                    rls[0].setBackgroundColor(0x33c85555);
                    //((FragmentMain) getActivity()).showFragmentMain();
                    break;
                case R.id.rl_reading:
                    rls[1].setBackgroundColor(0x33c85555);
                    //跳转收藏界面
                    break;
                case R.id.rl_local:
                    rls[2].setBackgroundColor(0x33c85555);
                    break;
                case R.id.rl_commnet:
                    rls[3].setBackgroundColor(0x33c85555);
                    break;
                case R.id.rl_photo:
                    rls[4].setBackgroundColor(0x33c85555);
                    break;
            }
        }
    };

}
