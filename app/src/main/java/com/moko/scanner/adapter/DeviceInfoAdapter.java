package com.moko.scanner.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.moko.scanner.R;
import com.moko.support.entity.DeviceInfo;

public class DeviceInfoAdapter extends BaseQuickAdapter<DeviceInfo, BaseViewHolder> {
    public DeviceInfoAdapter() {
        super(R.layout.item_devices);
    }

    @Override
    protected void convert(BaseViewHolder helper, DeviceInfo item) {
        helper.setText(R.id.tv_device_name, item.name);
        helper.setText(R.id.tv_device_rssi, item.rssi + "");
    }
}