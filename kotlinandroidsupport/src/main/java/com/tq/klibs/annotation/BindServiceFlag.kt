/*
 * ******************************************************************************
 *  Copyright Ⓒ 2016. TrinhQuan. All right reversed
 *  Author: TrinhQuan. Created on 2016/10/15
 *  Contact: trinhquan.171093@gmail.com
 * ******************************************************************************
 */

package com.tq.klibs.annotation

import android.content.Context
import android.support.annotation.IntDef

@IntDef(0, Context.BIND_AUTO_CREATE.toLong(), Context.BIND_DEBUG_UNBIND.toLong(), Context.BIND_NOT_FOREGROUND.toLong())
@Retention(AnnotationRetention.SOURCE)
annotation class BindServiceFlag