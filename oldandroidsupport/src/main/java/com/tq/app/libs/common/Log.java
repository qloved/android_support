/*
 * Copyright Ⓒ 2016. TrinhQuan. All right reversed
 * Author: TrinhQuan. Created on 2016/3/26
 * Contact: trinhquan.171093@gmail.com
 */

package com.tq.app.libs.common;

public interface Log {
    void l(String msg);

    void l(String msg, Throwable e);
}