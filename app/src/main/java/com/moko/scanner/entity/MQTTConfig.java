package com.moko.scanner.entity;


import android.content.Context;
import android.text.TextUtils;

import com.moko.scanner.R;
import com.moko.scanner.utils.ToastUtils;

import java.io.Serializable;

public class MQTTConfig implements Serializable {
    public String host = "";
    public String port = "1883";
    public boolean cleanSession = true;
    public int connectMode;
    public int qos = 1;
    public int keepAlive = 60;
    public String clientId = "";
    public String uniqueId = "";
    public String username = "";
    public String password = "";
    public String caPath;
    public String clientKeyPath;
    public String clientCertPath;
    public String topicSubscribe;
    public String topicPublish;

    public boolean isError(Context context) {
        if (context == null) {
            return TextUtils.isEmpty(host)
                    || TextUtils.isEmpty(port)
                    || keepAlive == 0;
        } else {
            if (TextUtils.isEmpty(host)) {
                ToastUtils.showToast(context, context.getString(R.string.mqtt_verify_host));
                return true;
            }
            if (TextUtils.isEmpty(port)) {
                ToastUtils.showToast(context, context.getString(R.string.mqtt_verify_port_empty));
                return true;
            }
            if (Integer.parseInt(port) > 65535) {
                ToastUtils.showToast(context, context.getString(R.string.mqtt_verify_port));
                return true;
            }
            if (keepAlive < 10 || keepAlive > 120) {
                ToastUtils.showToast(context, context.getString(R.string.mqtt_verify_keep_alive));
                return true;
            }
//            if (TextUtils.isEmpty(username)) {
//                ToastUtils.showToast(context, context.getString(R.string.mqtt_verify_username));
//                return true;
//            }
//            if (TextUtils.isEmpty(password)) {
//                ToastUtils.showToast(context, context.getString(R.string.mqtt_verify_password));
//                return true;
//            }
        }
        return false;
    }

    public void reset() {
        host = "";
        port = "1883";
        cleanSession = true;
        connectMode = 0;
        qos = 1;
        keepAlive = 60;
        clientId = "";
        username = "";
        password = "";
        caPath = "";
        clientKeyPath = "";
        clientCertPath = "";
        topicSubscribe = "";
        topicPublish = "";
    }
}