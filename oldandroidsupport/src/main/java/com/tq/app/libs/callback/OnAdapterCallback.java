/*
 * Copyright Ⓒ 2016. TrinhQuan. All right reversed
 * Author: TrinhQuan. Created on 2016/3/26
 * Contact: trinhquan.171093@gmail.com
 */

package com.tq.app.libs.callback;

import com.tq.app.libs.data.IDataWrapper;

public interface OnAdapterCallback {
    void onAdapterEventPerformed(String adapterID, int eventID, IDataWrapper data);
}