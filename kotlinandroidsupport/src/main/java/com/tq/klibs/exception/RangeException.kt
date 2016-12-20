/*
 * ******************************************************************************
 *  Copyright Ⓒ 2016. TrinhQuan. All right reserved
 *  Author: TrinhQuan. Created on 2016/12/20
 *  Contact: trinhquan.171093@gmail.com
 * ******************************************************************************
 */

package com.tq.klibs.exception

class RangeException : RuntimeException {
    constructor() {
    }

    constructor(detailMessage: String) : super(detailMessage) {
    }

    constructor(detailMessage: String, throwable: Throwable) : super(detailMessage, throwable) {
    }

    constructor(throwable: Throwable) : this("Invalid range", throwable) {
    }
}
