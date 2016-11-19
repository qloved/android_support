/*
 * ******************************************************************************
 *  Copyright Ⓒ 2016. TrinhQuan. All right reversed
 *  Author: TrinhQuan. Created on 2016/10/15
 *  Contact: trinhquan.171093@gmail.com
 * ******************************************************************************
 */

package com.tq.klibs.activity

import android.app.Activity
import android.app.ProgressDialog
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.annotation.CheckResult
import android.support.annotation.MainThread
import android.support.annotation.StringRes
import android.support.annotation.UiThread
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.WindowManager
import com.tq.klibs.annotation.BindServiceFlag
import com.tq.klibs.service.ServiceConnector

@CheckResult
fun Activity.bindToService(serviceClass: Class<out Service>,
                           @BindServiceFlag flag: Int = Context.BIND_AUTO_CREATE): ServiceConnector {
    val serviceConnector = ServiceConnector(this, flag)
    serviceConnector.bindService(serviceClass)
    return serviceConnector
}

fun Activity.navigateToActivity(activity: Class<out Activity>,
                                data: Bundle? = null,
                                flag: Int = 0) {
    val intent = Intent(this, activity)
    intent.addFlags(flag)
    if (data != null) {
        intent.putExtras(data)
    }
    startActivity(intent)
}

fun Activity.navigateToActivityForResult(activity: Class<out Activity>,
                                         data: Bundle? = null,
                                         requestCode: Int) {
    val intent = Intent(this, activity)
    if (data != null) {
        intent.putExtras(data)
    }
    startActivityForResult(intent, requestCode)
}

fun Activity.showAlert(title: String, message: String) {
    val builder = AlertDialog.Builder(this)
    builder.setTitle(title).setMessage(message).setPositiveButton("OK", null).show()
}

fun Activity.hideAllSystemUI() {
    window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
    if (Build.VERSION.SDK_INT > 11 && Build.VERSION.SDK_INT < 19) {
        window.decorView.systemUiVisibility = View.GONE
    } else if (Build.VERSION.SDK_INT >= 19) {
        val uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        window.decorView.systemUiVisibility = uiOptions
    }
}

abstract class AbsActivity : AppCompatActivity() {

    @MainThread
    @UiThread
    protected fun showProgress(@StringRes strRes: Int) {
        showProgress(getString(strRes))
    }

    private var mProgressDialog: ProgressDialog? = null

    @MainThread
    @UiThread
    protected fun showProgress(msg: String) {
        if (mProgressDialog == null) {
            mProgressDialog = ProgressDialog.show(this, null, msg, false, true)
        }
        mProgressDialog?.setMessage(msg)
        mProgressDialog?.show()
    }

    @MainThread
    @UiThread
    protected fun hideProgress() {
        mProgressDialog?.dismiss()
    }

    override fun onDestroy() {
        super.onDestroy()
        hideProgress()
    }
}