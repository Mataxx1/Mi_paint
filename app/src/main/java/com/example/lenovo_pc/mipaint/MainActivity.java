package com.example.lenovo_pc.mipaint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;


public class MainActivity extends ActionBarActivity {
    public float x = 50;
    public float y = 50;
    String accion = "accion";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SpecialView myView = new SpecialView(this);
        setContentView(myView);
    }

    class SpecialView extends View{

        Path path = new Path();
        public SpecialView(Context context){
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawColor(Color.rgb(255, 255, 150));
            Paint paint = new Paint();
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(6);
            paint.setColor(Color.BLUE);
            if(accion == "down"){
                path.moveTo(x,y);
            }
            if(accion=="move"){
                path.lineTo(x,y);
            }
            canvas.drawPath(path,paint);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        x=event.getX();
        y=event.getY();
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            accion="down";
        }
        if(event.getAction() == MotionEvent.ACTION_MOVE){
            accion="move";
        }

        return true;
    }
}
