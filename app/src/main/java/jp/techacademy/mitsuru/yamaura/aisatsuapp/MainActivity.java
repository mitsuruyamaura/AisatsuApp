package jp.techacademy.mitsuru.yamaura.aisatsuapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import android.widget.TextView;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.app.TimePickerDialog;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //  メンバ変数を定義
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  findViewByIdを使ってbutton1インスタンスを代入
        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        //  findViewByIdを使ってmtextViewインスタンスを代入
        mTextView = (TextView) findViewById(R.id.textView);
    }

    @Override
    public void onClick(View v){

        //  idがbutton1ならTimePickerメソッドを呼び出す
        if(v.getId == R.id.button1){
            showTimePickerDialog();
        }
    }

    private void showTimePickerDialog(){

        //  thisでActivityを与える
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {    //  時刻を設定したときにonTimeSetメソッドを呼ぶ
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                        //  ２４時間表示（true）なので、時間だけ比べればよい
                        if (2 < hourOfDay && hourOfDay < 10){
                            //
                            mTextView.setText("「おはよう」");
                        }else if(10 < hourOfDay && hourOfDay <18){

                            mTextView.setText("「こんにちは」");
                        }else {

                            mTextView.setText("「こんばんは」");
                        }
                },
                5,
                22,
                true);
        timePickerDialog.show();

        }
    }
}
