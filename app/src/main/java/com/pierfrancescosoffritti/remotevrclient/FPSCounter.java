package com.pierfrancescosoffritti.remotevrclient;

import android.widget.TextView;

import com.pierfrancescosoffritti.remotevrclient.utils.LoggerBus;
import com.pierfrancescosoffritti.remotevrclient.utils.PerformanceMonitor;
import com.squareup.otto.Subscribe;

/**
 * Created by  Pierfrancesco on 06/03/2016.
 */
public class FPSCounter implements ILogger {

    private TextView mView;

    public FPSCounter(TextView view) {
        mView = view;
    }

    @Subscribe
    @Override
    public void onLog(LoggerBus.Log log) {
        if(log.getSender().equals(PerformanceMonitor.LOG_NAME)) {
            if (log.getType() == LoggerBus.Log.STATS_INST)
                mView.setText(log.getMessage());
        }
    }

    public void register() {
        LoggerBus.getInstance().register(this);
    }

    public void unregister() {
        LoggerBus.getInstance().unregister(this);
    }
}