package org.androidtown.building_control;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
    ImageView imageView;
    ImageView imageView2;
    ImageView imageView3;
    int index=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        imageView = (ImageView) findViewById(R.id.imageView);
        imageView2= (ImageView) findViewById(R.id.imageView2);
        imageView3= (ImageView) findViewById(R.id.imageView3);


        Button button = (Button) findViewById(R.id.btn_back);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "이전 화면으로 돌아갑니다", Toast.LENGTH_SHORT).show();

                finish();
            }
        });
    }

    public void onButtontempClicked(View v){
        index+=1;
        if(index>2){
            index=0;
        }

        if(index==0){
            imageView3.setVisibility(View.VISIBLE);
            imageView2.setVisibility(View.INVISIBLE);
            imageView.setVisibility(View.INVISIBLE);
        }
        else if(index==1){
            imageView3.setVisibility(View.INVISIBLE);
            imageView2.setVisibility(View.VISIBLE);
            imageView.setVisibility(View.INVISIBLE);
        }
        else{
            imageView3.setVisibility(View.INVISIBLE);
            imageView2.setVisibility(View.INVISIBLE);
            imageView.setVisibility(View.VISIBLE);
        }
    }

}