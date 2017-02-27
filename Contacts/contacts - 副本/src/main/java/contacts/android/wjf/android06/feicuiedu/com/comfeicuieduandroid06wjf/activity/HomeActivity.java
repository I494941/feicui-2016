package contacts.android.wjf.android06.feicuiedu.com.comfeicuieduandroid06wjf.activity;


import android.view.View;

import contacts.android.wjf.android06.feicuiedu.com.comfeicuieduandroid06wjf.R;
import contacts.android.wjf.android06.feicuiedu.com.comfeicuieduandroid06wjf.base.BaseActivity;

/**
 * Created by ad06-wjf on 2016/11/4.
 */

/**
 * 0 * 主页面 * * @author dell *
 */
public class HomeActivity extends BaseActivity {
    /**
     * 按键监听方法
     */
    public void hitHomeitem(View view) {
        int viewID = view.getId();
        switch (viewID) {
            case R.id.ll_rocket:
                //跳转到手机加速页面
                startActivity(SpeedupActivity.class, R.anim.in_down, R.anim.out_up);
                break;
            case R.id.ll_softmgr:
                //跳转到软件管理页面
                startActivity(SoftmgrActivity.class, R.anim.in_down, R.anim.out_up);
                break;
            case R.id.ll_phonemgr:
                //跳转到手机检测页面
                startActivity(PhonemgrActivity.class, R.anim.in_down, R.anim.out_up);
                break;
            case R.id.ll_telmgr:
                //跳转到通信大全页面
                startActivity(TelmgrActivity.class, R.anim.in_down, R.anim.out_up);
                break;
            case R.id.ll_filemgr:
                //跳转到文件管理页面
                startActivity(FilemgrActivity.class, R.anim.in_down, R.anim.out_up);
                break;
            case R.id.ll_sdclean:
                //跳转到垃圾清理页面
                startActivity(ClearActivity.class, R.anim.in_down, R.anim.out_up);
                break;
        }
    }
}
