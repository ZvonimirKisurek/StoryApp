package com.zoneproduction.hotelmanager;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class OpenClose {

    public void closeRoom(TextView first, TextView second, TextView third, Context context){
        first.setClickable(false);
        second.setClickable(false);
        third.setClickable(false);
        Animation outro = AnimationUtils.loadAnimation(context, R.anim.outro_anim);
        first.startAnimation(outro);
        second.startAnimation(outro);
        third.startAnimation(outro);
        first.setVisibility(View.INVISIBLE);
        second.setVisibility(View.INVISIBLE);
        third.setVisibility(View.INVISIBLE);
    }

    public void openRoom(TextView first, TextView second, TextView third){
        first.setClickable(true);
        first.setVisibility(View.VISIBLE);
        second.setClickable(true);
        second.setVisibility(View.VISIBLE);
        third.setClickable(true);
        third.setVisibility(View.VISIBLE);
        YoYo.with(Techniques.BounceIn).duration(500).repeat(0).playOn(first);
        YoYo.with(Techniques.BounceIn).duration(500).repeat(0).playOn(second);
        YoYo.with(Techniques.BounceIn).duration(500).repeat(0).playOn(third);
    }

    public void closeRoomFast(Context context, Object... switchOff){
        Animation outro = AnimationUtils.loadAnimation(context, R.anim.outro_anim);
        for(Object item : switchOff){
            Class<?> clazz = item.getClass();
            String s = String.valueOf(clazz);
            if(s.contains("TextView")){
                TextView tv = (TextView) item;
                tv.setClickable(false);
                tv.startAnimation(outro);
                tv.setVisibility(View.INVISIBLE);
            }else if(s.contains("ImageView")){

            }else if(s.contains("LinearLayout")){
                LinearLayout ll = (LinearLayout) item;
                ll.setClickable(false);
                ll.setVisibility(View.INVISIBLE);
            }
        }
    }

    public void openRoomFast(Context context, Object... switchOn){

        for(Object item : switchOn){
            Class<?> clazz = item.getClass();
            String s = String.valueOf(clazz);
            if(s.contains("TextView")){
                TextView tv = (TextView) item;
                tv.setClickable(true);
                YoYo.with(Techniques.BounceIn).duration(500).repeat(0).playOn(tv);
                tv.setVisibility(View.VISIBLE);
            }else if(s.contains("ImageView")){

            }
        }
    }

}
