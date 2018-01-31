package org.androidtown.building_control;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {

    public static final String TAG="MainActivity";
    Button button3;
    TextView textView;

    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button)findViewById(R.id.light_button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"현재 전등 상태",Toast.LENGTH_LONG).show();

                Intent intent = new Intent(getApplicationContext(),Main2Activity.class);
                startActivity(intent);
            }
        });

        Button button2 = (Button)findViewById(R.id.trashcan_button);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"쓰레기통이 채워진 정도",Toast.LENGTH_LONG).show();

                Intent intent = new Intent(getApplicationContext(),Main3Activity.class);
                startActivity(intent);
            }
        });

        textView = (TextView)findViewById(R.id.textView);

        button3 = (Button)findViewById(R.id.temp_humid_button);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"현 온도 / 습도",Toast.LENGTH_LONG).show();

                Intent intent = new Intent(getApplicationContext(),Main4Activity.class);
                startActivity(intent);

                RequestThread thread = new RequestThread();
                thread.start();


            }
        });

        handler = new Handler();

    }

    class RequestThread extends Thread{
        public void run(){
            request();
        }
    }

    public void request(){
        try {
            while(true) {
                Socket socket = new Socket("192.168.0.153", 5001);      //서버를 5001에서 대기를 하게 만든다.
                appendText("client started    : localhost,5001");

                //client니까 while이 필요가 없다. 한번만 보내고 한번만 받는다.


                ObjectOutputStream outstream = new ObjectOutputStream(socket.getOutputStream());
                outstream.writeUTF("app data sent");
                outstream.flush();


                appendText("completed.");


                ObjectInputStream instream = new ObjectInputStream(socket.getInputStream());   //다시 서버에서 보내오는게 있으면 inputstream으로 받아서 찍는다.
                String inStr = instream.readUTF();

                appendText("inStr from server" + inStr);

                socket.close();
            }


        }catch(IOException e) {
            e.printStackTrace();
        }

    }

    public void appendText(String msg){
        final String inMsg = msg;
        handler.post(new Runnable() {
            @Override
            public void run() {
                textView.append(inMsg+ "\n");
            }
        });

    }


}

