package android.wjf.android06.feicuiedu.com.newsapp.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.wjf.android06.feicuiedu.com.newsapp.R;

/**
 * Created by wangjinfei on 16/12/6.
 */

public class FragmentRead extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_read, container, false);
        return view;
    }
}
