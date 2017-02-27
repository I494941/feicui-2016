package contacts.android.wjf.android06.feicuiedu.com.dailysystem.main;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import contacts.android.wjf.android06.feicuiedu.com.dailysystem.R;
import contacts.android.wjf.android06.feicuiedu.com.dailysystem.db.DailyHelper;
import contacts.android.wjf.android06.feicuiedu.com.dailysystem.main1.LoginActivity;

/**
 * Created by ad06-wjf on 2016/11/24.
 */

public class WriteFragment extends Fragment {

    private Context context;

    Intent intent;

    private EditText etSF;
    private EditText etHF;
    private EditText etUR;
    private EditText etQAA;
    private EditText etNDP;

    private Button btnSave;
    private Button btnTurn;

    private DailyHelper dailyHelper;
    private SQLiteDatabase dabase;

    String strSF;
    String strHF;
    String strUR;
    String strQAA;
    String strNDP;


    private View.OnClickListener ocl = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btn_save:
                    Toast.makeText(context, "保存", Toast.LENGTH_SHORT).show();

                    String dailyId = String.valueOf(System.currentTimeMillis());
                    String time = null;
                    Calendar calendar = Calendar.getInstance();

                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    String currentDate = sdf.format(calendar.getTime());
                    String strSql = "insert into daily_(d_id,d_create_date,d_should_finished,d_have_finished,d_unfinished_reason,d_queson_and_answer,d_next_day_plan) values(?,?,?,?,?,?,?)";
                    dailyHelper = new DailyHelper(context);
                    dabase = dailyHelper.getWritableDatabase();
                    dabase.execSQL(strSql, new String[]{dailyId,currentDate, strSF, strHF,strUR,strQAA,strNDP});
                    Toast.makeText(context, "保存成功!", Toast.LENGTH_SHORT).show();

                    break;
                case R.id.btn_turn:
                    Toast.makeText(context, "返回", Toast.LENGTH_SHORT).show();

                    intent = new Intent();
                    intent.setClass(context, MainActivity.class);
                    startActivity(intent);

                    break;
            }


        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.daily_item_layout,container,false);

        context = getActivity();

        etSF = (EditText) view.findViewById(R.id.et_should_finished_work);
        etHF = (EditText) view.findViewById(R.id.et_have_finished_work);
        etUR = (EditText) view.findViewById(R.id.et_unfinished_reason);
        etQAA = (EditText) view.findViewById(R.id.et_question_and_answer);
        etNDP = (EditText) view.findViewById(R.id.et_next_day_plan);

        btnSave = (Button) view.findViewById(R.id.btn_save);
        btnTurn = (Button) view.findViewById(R.id.btn_turn);

        strSF = String.valueOf(etSF.getText());
        strHF = String.valueOf(etHF.getText());
        strUR = String.valueOf(etUR.getText());
        strQAA = String.valueOf(etQAA.getText());
        strNDP = String.valueOf(etNDP.getText());

        btnSave.setOnClickListener(ocl);
        btnTurn.setOnClickListener(ocl);

        return view;

    }


}
