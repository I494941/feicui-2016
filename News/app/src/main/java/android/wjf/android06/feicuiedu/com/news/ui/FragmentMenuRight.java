package android.wjf.android06.feicuiedu.com.news.ui;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.wjf.android06.feicuiedu.com.news.R;
import android.wjf.android06.feicuiedu.com.news.common.CommonUtil;
import android.wjf.android06.feicuiedu.com.news.common.LogUtil;
import android.wjf.android06.feicuiedu.com.news.receiver.DownloadCompleteReceiver;

import junit.runner.Version;

import org.apache.http.Header;

/**
 * Created by ad06-wjf on 2016/11/30.
 */

/**
 * 右边侧拉界面
 **/
public class FragmentMenuRight extends Fragment {
    /*略*/
    private View view;
    private RelativeLayout relativeLayout_logined;
    private RelativeLayout relativeLayout_unlogin;
    private ImageView imageView1;
    private TextView textView1, updateTv;

   /* //重写onCreateView方法，设置当前的布局
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //利用回调中的参数LayoutInflater对象导入布局文件，并发挥此View
        view = inflater.inflate(R.layout.fragment_menu_right, container, false);
        relativeLayout_unlogin = (RelativeLayout) view.findViewById(R.id.relativelayout_unlogin);
        relativeLayout_logined = (RelativeLayout) view.findViewById(R.id.relativelayout_logined);

        imageView1 = (ImageView) view.findViewById(R.id.imageView1);
        textView1 = (TextView) view.findViewById(R.id.textView1);
        updateTv = (TextView) view.findViewById(R.id.update_version);
        *//*略*//*
        relativeLayout_logined.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ActivityUser.class);
                startActivity(intent);
            }
        });
        receiver = new DownloadCompleteReceiver();//创建下载完毕接收器
        // 版本更新
        updateTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateManager.judgeUpdate(new TextHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, String responseString) {
                        //解析返回json数据
                        Version version = ParserVersion.parserJson(responseString);
                        //判断本地版本与服务器版本
                        if (CommonUtil.getVersionCode(FragmentMenuRight.this.getActivity()) < Integer.parseInt(version.getVersion())) {
                            //执行下载请求
                            Toast.makeText(getActivity(), "正在下载最新版本.", 0).show();
                            UpdateManager.downLoad(getActivity(), version.getLink());
                        } else {
                            Toast.makeText(getActivity(), "当前已是最新版本", 0).show();
                        }
                        LogUtil.d(LogUtil.TAG, "执行版本更新返回数据：" + responseString);
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                        Toast.makeText(getActivity(), "更新失败", 0).show();
                    }
                }, SystemUtils.getIMEI(getActivity()), "package-name", CommonUtil.VERSION_CODE + "");
            }
        });
        return view;
    }*/
}

