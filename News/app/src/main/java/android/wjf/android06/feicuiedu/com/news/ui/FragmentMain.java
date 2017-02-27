package android.wjf.android06.feicuiedu.com.news.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.wjf.android06.feicuiedu.com.news.R;

/**
 * Created by ad06-wjf on 2016/11/28.
 */

/**
 * 新闻列表界面
 **/
public class FragmentMain extends Fragment {

    private View view;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_newslist, container, false);
        return view;
    }
}