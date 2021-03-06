/*
 * ******************************************************************************
 *  Copyright Ⓒ 2016. TrinhQuan. All right reserved
 *  Author: TrinhQuan. Created on 2016/12/20
 *  Contact: trinhquan.171093@gmail.com
 * ******************************************************************************
 */

package com.tq.app.libs.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;

import com.tq.app.libs.R;

public class SquareTextView extends AppCompatTextView {
    private static final int DEFAULT_RELATIVE = 0; //0 width, 1 height
    private int mRelative = DEFAULT_RELATIVE;

    public SquareTextView(Context context) {
        this(context, null);
    }

    public SquareTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        loadStateFromAttrs(attrs);
    }

    public SquareTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        loadStateFromAttrs(attrs);
    }

    private void loadStateFromAttrs(AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        TypedArray a = null;
        try {
            a = getContext().obtainStyledAttributes(attributeSet, R.styleable.SquareView);
            mRelative = a.getInteger(R.styleable.SquareView_relative_to,
                    DEFAULT_RELATIVE);
        } finally {
            if (a != null) {
                a.recycle();
            }
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (mRelative == 0) {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredWidth());
        } else {
            setMeasuredDimension(getMeasuredHeight(), getMeasuredHeight());
        }
    }
}
