package android.wjf.android06.feicuiedu.com.newsapp.ui;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.wjf.android06.feicuiedu.com.newsapp.R;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

/**
 * Created by chenyan on 2016/11/23.
 */

public class RightFragment extends Fragment {

    private SlidingMenu menu;

    private String title = "";
    private IResponse3 iResponse3;

    public RightFragment(SlidingMenu menu, IResponse3 iResponse3) {
        this.menu = menu;
        this.iResponse3 = iResponse3;
    }

    public SlidingMenu getMenu() {

        return menu;
    }

    public void setMenu(SlidingMenu menu) {
        this.menu = menu;
    }

    private ImageView imageViewLogin;
    private TextView textViewLogin;
    private LinearLayout llBottom;

    private Activity fromActivity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_right, container, false);

        fromActivity = getActivity();

        imageViewLogin = (ImageView) view.findViewById(R.id.image_view_login);
        textViewLogin = (TextView) view.findViewById(R.id.text_view_login);
        llBottom = (LinearLayout) view.findViewById(R.id.bottom);

        imageViewLogin.setOnClickListener(ocl);
        textViewLogin.setOnClickListener(ocl);
        llBottom.setOnClickListener(ocl);

        return view;
    }

    View.OnClickListener ocl = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            menu.toggle();

            switch (view.getId()) {

                case R.id.image_view_login:
                case R.id.text_view_login:
                    title = "用户登录";
                    Toast.makeText(fromActivity, "用户登录", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.bottom:
                    title = "分享";
                    Toast.makeText(fromActivity, "分享", Toast.LENGTH_SHORT).show();
                    break;


            }
            iResponse3.onReturn(title);
        }
    };

    public interface IResponse3 {
        public void onReturn(String result);
    }
}
