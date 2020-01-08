package com.web.config;

import com.jfinal.core.ActionReporter;
import io.jboot.core.listener.JbootAppListenerBase;

public class AppConfig extends JbootAppListenerBase {

    @Override
    public void onStartBefore() {
        //日志配置
        ActionReporter actionReporter = new ActionReporter();
        LogConfig actionToLog4j = new LogConfig();
        actionReporter.setWriter(actionToLog4j);
        super.onStartBefore();
    }
}