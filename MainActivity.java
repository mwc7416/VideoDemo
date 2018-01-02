package com.ace.videodemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private FrameLayout container;
    private SurfaceView sur_0, sur_1, sur_2, sur_3, sur_4;
    private List<SurfaceView> surfaces;
    private List<FrameLayout.LayoutParams> paramses;
    private int mainPos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //无title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        surfaces = new ArrayList<>();
        paramses = new ArrayList<>();

        container = (FrameLayout) findViewById(R.id.frame_container);
        sur_0 = new SurfaceView(this);
        sur_0.setZOrderOnTop(false);
        sur_0.setBackgroundColor(getColor(R.color.colorAccent));
        sur_1 = new SurfaceView(this);
        sur_1.setZOrderOnTop(true);
        sur_1.setBackgroundColor(getColor(R.color.colorPrimary));
        sur_2 = new SurfaceView(this);
        sur_2.setZOrderOnTop(true);
        sur_2.setBackgroundColor(getColor(R.color.colorPrimaryDark));
        sur_3 = new SurfaceView(this);
        sur_3.setZOrderOnTop(true);
        sur_3.setBackgroundColor(getColor(R.color.red));
        sur_4 = new SurfaceView(this);
        sur_4.setZOrderOnTop(true);
        sur_4.setBackgroundColor(getColor(R.color.black));

        sur_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click(0);
            }
        });
        sur_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click(1);
            }
        });
        sur_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click(2);
            }
        });
        sur_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click(3);
            }
        });
        sur_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click(4);
            }
        });


        FrameLayout.LayoutParams params_0 = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        FrameLayout.LayoutParams params_1 = new FrameLayout.LayoutParams(150, 150);
        FrameLayout.LayoutParams params_2 = new FrameLayout.LayoutParams(150, 150);
        FrameLayout.LayoutParams params_3 = new FrameLayout.LayoutParams(150, 150);
        FrameLayout.LayoutParams params_4 = new FrameLayout.LayoutParams(150, 150);

        params_1.setMargins(0, 0, 0, 0);
        params_2.setMargins(0, 150, 0, 0);
        params_3.setMargins(0, 300, 0, 0);
        params_4.setMargins(0, 450, 0, 0);

        sur_0.setLayoutParams(params_0);
        sur_1.setLayoutParams(params_1);
        sur_2.setLayoutParams(params_2);
        sur_3.setLayoutParams(params_3);
        sur_4.setLayoutParams(params_4);

        container.addView(sur_0);
        container.addView(sur_1);
        container.addView(sur_2);
        container.addView(sur_3);
        container.addView(sur_4);

        surfaces.add(sur_0);
        surfaces.add(sur_1);
        surfaces.add(sur_2);
        surfaces.add(sur_3);
        surfaces.add(sur_4);

        paramses.add(params_0);
        paramses.add(params_1);
        paramses.add(params_2);
        paramses.add(params_3);
        paramses.add(params_4);

    }

    @Override
    protected void onResume() {
        super.onResume();
        fullScreen();
    }

    /**
     * 初始化主题,全屏
     */
    protected void fullScreen() {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        getSupportActionBar().hide();
    }


    private void click(int pos) {
        Log.i("Main", "click: " + pos);
        Toast.makeText(this, "pos" + pos, Toast.LENGTH_SHORT).show();
//        surfaces.get(pos).setLayoutParams(paramses.get(0));
//        surfaces.get(mainPos).setLayoutParams(paramses.get(pos));
//
//        surfaces.get(pos).setZOrderOnTop(false);
//        surfaces.get(pos).setZOrderOnTop(true);
//
//        mainPos = pos;
    }
}
