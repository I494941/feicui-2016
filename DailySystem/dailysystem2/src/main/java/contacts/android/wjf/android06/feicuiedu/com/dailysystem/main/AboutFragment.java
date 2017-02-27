package contacts.android.wjf.android06.feicuiedu.com.dailysystem.main;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import contacts.android.wjf.android06.feicuiedu.com.dailysystem.R;

/**
 * Created by ad06-wjf on 2016/11/24.
 */

public class AboutFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.layout_about,container,false);

        return view;

    }
}
