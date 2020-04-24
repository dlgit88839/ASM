package com.example.asm;

import android.util.Log;
import android.view.View;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

public class DoubleClickHelper {
    public static long intervalTime=200L;
    private static final WeakHashMap<View, Long> viewWeakHashMap = new WeakHashMap<>();
    public static boolean shouldDoClick(View targetView) {
        Log.e(DoubleClickHelper.class.getName(),"调用");
        Long last = viewWeakHashMap.get(targetView);
        final long now = now();
        if (last == null) {
            last=new Long(now);
            viewWeakHashMap.put(targetView, last);
            return true;
        }
        if (now >= last+intervalTime) {
            viewWeakHashMap.put(targetView, now);
            return true;
        }
        return false;
    }

    private static long now() {
        return TimeUnit.NANOSECONDS.toMillis(System.nanoTime());
    }





}
