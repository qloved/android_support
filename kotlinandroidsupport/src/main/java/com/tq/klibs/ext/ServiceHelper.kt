/*
 * ******************************************************************************
 *  Copyright Ⓒ 2016. TrinhQuan. All right reserved
 *  Author: TrinhQuan. Created on 2016/12/20
 *  Contact: trinhquan.171093@gmail.com
 * ******************************************************************************
 */

package com.tq.klibs.ext

import android.app.Service
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import com.tq.klibs.annotation.BindServiceFlag
import com.tq.klibs.exception.ParameterException


@Throws(ParameterException::class)
fun Context.bindToService(clazz: Class<out Service>,
                          connection: ServiceConnection,
                          @BindServiceFlag flag: Int = Context.BIND_AUTO_CREATE) {
    checkNotNull(clazz)
    checkNotNull(connection)
    val intent = Intent(this, clazz)
    this.bindService(intent, connection, flag)
}
