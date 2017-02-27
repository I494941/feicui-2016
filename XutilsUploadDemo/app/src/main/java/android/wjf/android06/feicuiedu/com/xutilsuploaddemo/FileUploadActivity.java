package android.wjf.android06.feicuiedu.com.xutilsuploaddemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * Created by ad06-wjf on 2016/12/16.
 */
@ContentView(R.layout.activity_file_upload)
public class FileUploadActivity extends AppCompatActivity implements View.OnClickListener {

    @ViewInject(R.id.cancel)
    private TextView cancel;
    @ViewInject(R.id.upload)
    private TextView upload;
    @ViewInject(R.id.buttonLoadPicture)
    private Button buttonLoadImage;
    @ViewInject(R.id.show)
    private View show;
    @ViewInject(R.id.file_path)
    private EditText pathView;

    private String picturePath;

    protected static final int SUCCESS = 2;
    protected static final int FAILD = 3;
    protected static int RESULT_LOAD_FILE = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        initView();
        initData();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cancel:
                finish();
                break;
            case R.id.buttonLoadPicture:
                Intent intent = new Intent(getApplicationContext(),
                        FileSelectActivity.class);

                startActivityForResult(intent, RESULT_LOAD_FILE);
                break;
            case R.id.upload:
               // uploadFile();
                break;
            default:
                break;
        }
    }

    private void initView() {
        cancel.setOnClickListener(this);
        upload.setOnClickListener(this);
        buttonLoadImage.setOnClickListener(this);
    }

    private void initData() {
        picturePath = "";
    }
}
