package com.feicuiedu.android.uploaddemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;

import cz.msebera.android.httpclient.Header;

public class FileUploadActivity extends Activity implements OnClickListener {

	protected static final int SUCCESS = 2;
	protected static final int FAILD = 3;
	protected static int RESULT_LOAD_FILE = 1;
	private TextView cancel;
	private TextView upload;
	private EditText pathView;
	private Button buttonLoadImage;
	private String picturePath;
	private View show;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_file_upload);
		initView();
		initData();
	}

	private Handler mHandler = new Handler(new Handler.Callback() {

		@Override
		public boolean handleMessage(Message msg) {
			switch (msg.what) {

			case SUCCESS:
				show.setVisibility(View.INVISIBLE);
				picturePath = "";
				pathView.setText(picturePath);
				Toast.makeText(getApplicationContext(), "上传成功！",
						Toast.LENGTH_LONG).show();
				break;
			case FAILD:
				show.setVisibility(View.INVISIBLE);
				Toast.makeText(getApplicationContext(), "上传失败！",
						Toast.LENGTH_LONG).show();
				break;
			default:
				break;
			}
			return false;
		}

	});

	private void initView() {
		cancel = (TextView) findViewById(R.id.cancel);
		upload = (TextView) findViewById(R.id.upload);
		buttonLoadImage = (Button) findViewById(R.id.buttonLoadPicture);
		cancel.setOnClickListener(this);
		upload.setOnClickListener(this);
		buttonLoadImage.setOnClickListener(this);
		show = findViewById(R.id.show);
		pathView = (EditText) findViewById(R.id.file_path);
		pathView.setKeyListener(null);
	}

	private void initData() {
		picturePath = "";
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
			uploadFile();
			break;
		default:
			break;
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == RESULT_LOAD_FILE && resultCode == RESULT_LOAD_FILE
				&& data != null) {
			picturePath = data.getStringExtra("path");
			pathView.setText(picturePath);
		}
	}

	private void uploadFile() {
		show.setVisibility(View.VISIBLE);

		// okhttp xutil
		// 使用adb命令  adb push /develop/1373721409463.jpg  /sdcard/Pictures
		// /develop/1373721409463.jpg 本地文件絕對路徑
		// /sdcard/Pictures  模擬器上的絕對路徑
		// 進入到 sdk/platform-tools 路徑 使用adb指令  adb shell 就可以進入模擬器系統的命令控制臺
		// http://192.168.1.250:8080/appserver/UploadFile/
		AsyncHttpClient client = new AsyncHttpClient();
		RequestParams rp = new RequestParams();
		File file = new File(picturePath);
		try {
			
			if (file.isFile()) {
				
				rp.put("abc", file);
			}
			else {
				Log.d("upload", "This is not a File");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		client.post("http://192.168.1.250:8080/appserver/SrvUpload", rp, new JsonHttpResponseHandler(){
			
			@Override
			public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
				Log.d("JsonHttpResponseHandler", "JSONArray:"+response.toString());
				super.onSuccess(statusCode, headers, response);
			}
			
			@Override
			public void onSuccess(int statusCode, Header[] headers, String responseString) {
				Log.d("JsonHttpResponseHandler", "String:"+responseString);
				super.onSuccess(statusCode, headers, responseString);
			}
			
			@Override
			public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
				Log.d("JsonHttpResponseHandler", "JSONObject:"+response.toString());
				super.onSuccess(statusCode, headers, response);

				String strRtn = null;
				try {
					strRtn = response.getString("url");
				} catch (JSONException e) {
					e.printStackTrace();
				}
				show.setVisibility(View.INVISIBLE);
				picturePath = strRtn;
				pathView.setText(picturePath);
				Toast.makeText(getApplicationContext(), "上传成功！",
						Toast.LENGTH_LONG).show();
			}

			@Override
			public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
				super.onFailure(statusCode, headers, responseString, throwable);
				show.setVisibility(View.INVISIBLE);
				pathView.setText(picturePath);

				Toast.makeText(getApplicationContext(), "上传失败！"+responseString,
						Toast.LENGTH_LONG).show();
			}

			@Override
			public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
				super.onFailure(statusCode, headers, throwable, errorResponse);
				show.setVisibility(View.INVISIBLE);
				pathView.setText(picturePath);
				Toast.makeText(getApplicationContext(), "上传失败！"+errorResponse.toString(),
						Toast.LENGTH_LONG).show();
			}

			@Override
			public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONArray errorResponse) {
				super.onFailure(statusCode, headers, throwable, errorResponse);
				show.setVisibility(View.INVISIBLE);
				pathView.setText(picturePath);
				Toast.makeText(getApplicationContext(), "上传失败！"+errorResponse.toString(),
						Toast.LENGTH_LONG).show();
			}
		});
	
	}

	@Override
	protected void onDestroy() {
		show.setVisibility(View.INVISIBLE);
		super.onDestroy();
	}
	
}
