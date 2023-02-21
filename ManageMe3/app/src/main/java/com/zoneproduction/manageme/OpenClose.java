package com.zoneproduction.manageme;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OpenClose {

    public void closeRoom(TextView first, TextView second, TextView third, Context context) {
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

    public void openRoom(TextView first, TextView second, TextView third) {
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

    public void addClean(Context context, ImageButton setOff, TextView[] textViews, Object... switchOn) {
        setOff.setClickable(false);
        Animation outro = AnimationUtils.loadAnimation(context, R.anim.outro_anim);
        setOff.setVisibility(View.INVISIBLE);
        for (TextView tv : textViews) {
            tv.setVisibility(View.INVISIBLE);
            tv.setClickable(false);
            tv.startAnimation(outro);
        }
        for (Object o : switchOn) {
            objectIteratorOn(o, context);
        }
    }

    public void addOstalo(Context context, ImageButton setOff, TextView[] textViews, ImageView ugasiti, Object... switchOn) {
        setOff.setClickable(false);
        Animation outro = AnimationUtils.loadAnimation(context, R.anim.outro_anim);
        setOff.setVisibility(View.INVISIBLE);
        ugasiti.setVisibility(View.INVISIBLE);
        ugasiti.setClickable(false);
        for (TextView tv : textViews) {
            tv.setVisibility(View.INVISIBLE);
            tv.setClickable(false);
            tv.startAnimation(outro);
        }
        for (Object o : switchOn) {
            objectIteratorOn(o, context);
        }
    }

    public void closeRoomFast(Context context, Object... switchOff) {
        Animation outro = AnimationUtils.loadAnimation(context, R.anim.outro_anim);
        for (Object item : switchOff) {
            objectIteratorOff(item, context);
        }
    }

    public void closeDropDowns(Context context, Object... switchOff) {
        for (Object item : switchOff) {
            if (item != null) {
                objectIteratorOff(item, context);
            }
        }
    }

    public void openRoomFast(Context context, Object... switchOn) {
        for (Object item : switchOn) {
            if (item != null) {
                objectIteratorOn(item, context);
            }
        }
    }

    public void objectIteratorOn(Object o, Context context) {
        Animation outro = AnimationUtils.loadAnimation(context, R.anim.outro_anim);
        Class<?> clazz = o.getClass();
        String s = String.valueOf(clazz);
        if (s.contains("TextView")) {
            TextView tv = (TextView) o;
            tv.setClickable(true);
            YoYo.with(Techniques.BounceIn).duration(500).repeat(0).playOn(tv);
            tv.setVisibility(View.VISIBLE);
        } else if (s.contains("ImageView")) {
            ImageView iv = (ImageView) o;
            iv.setClickable(true);
            iv.startAnimation(outro);
            iv.setVisibility(View.VISIBLE);
        } else if (s.contains("LinearLayout")) {
            LinearLayout ll = (LinearLayout) o;
            ll.setClickable(true);
            ll.setVisibility(View.VISIBLE);
            YoYo.with(Techniques.BounceIn).duration(500).repeat(0).playOn(ll);
        } else if (s.contains("ConstraintLayout")) {
            ConstraintLayout cl = (ConstraintLayout) o;
            cl.setClickable(true);
            cl.setVisibility(View.VISIBLE);
            YoYo.with(Techniques.BounceIn).duration(500).repeat(0).playOn(cl);
        } else if (s.contains("ImageButton")) {
            ImageButton ib = (ImageButton) o;
            ib.setClickable(true);
            ib.startAnimation(outro);
            ib.setVisibility(View.VISIBLE);
        }
    }

    public void objectIteratorOff(Object o, Context context) {
        Animation outro = AnimationUtils.loadAnimation(context, R.anim.outro_anim);
        Class<?> clazz = o.getClass();
        String s = String.valueOf(clazz);
        if (s.contains("TextView")) {
            TextView tv = (TextView) o;
            tv.setClickable(false);
            tv.startAnimation(outro);
            tv.setVisibility(View.INVISIBLE);
        } else if (s.contains("ImageView")) {
            ImageView iv = (ImageView) o;
            iv.setClickable(false);
            iv.startAnimation(outro);
            iv.setVisibility(View.INVISIBLE);
        } else if (s.contains("LinearLayout")) {
            LinearLayout ll = (LinearLayout) o;
            ll.setClickable(false);
            YoYo.with(Techniques.BounceInUp).duration(500).repeat(0).playOn(ll);
            ll.setVisibility(View.INVISIBLE);
        } else if (s.contains("ConstraintLayout")) {
            ConstraintLayout cl = (ConstraintLayout) o;
            cl.setClickable(false);
            cl.startAnimation(outro);
            cl.setVisibility(View.INVISIBLE);
        } else if (s.contains("ImageButton")) {
            ImageButton ib = (ImageButton) o;
            ib.setClickable(false);
            ib.startAnimation(outro);
            ib.setVisibility(View.INVISIBLE);
        }
    }

    public void setTime(TextView tv) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
        LocalDateTime now = LocalDateTime.now();
        tv.setText(now.format(dtf));
    }

    public void checkIfAddJobIsEmpty(TextView odabranaUsluga, TextView terminUsluge, ImageButton potvrdi) {
        if (odabranaUsluga.getText().toString().equals("Izaberite uslugu") || terminUsluge.getText().toString().equals("Termin")) {
            potvrdi.setVisibility(View.INVISIBLE);
        } else {
            potvrdi.setVisibility(View.VISIBLE);
        }
    }

}
