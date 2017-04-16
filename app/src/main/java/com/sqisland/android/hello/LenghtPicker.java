package com.sqisland.android.hello;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by navee on 16/04/2017.
 */

public class LenghtPicker extends LinearLayout {
    private TextView mTextView;
    private Button mPlusButton;
    private Button mMinusButton;
    private int mNumInches;
    public LenghtPicker(Context context) {
        super(context);
        init();
    }

    public LenghtPicker(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();

    }

    public LenghtPicker(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    public void init()
    {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        inflater.inflate(R.layout.lengh_picker,this);
        mTextView = (TextView)findViewById(R.id.text);
        mMinusButton = (Button)findViewById(R.id.minus_button);
        mPlusButton = (Button)findViewById(R.id.plus_button);

        updateControls();
        View.OnClickListener listener = (v)-> {
            switch (v.getId())
            {
                case R.id.minus_button :
                    mNumInches--;
                    updateControls();
                    break;
                case R.id.plus_button :
                    mNumInches++;
                    updateControls();
                    break;
            }
        };
        mMinusButton.setOnClickListener(listener);
        mPlusButton.setOnClickListener(listener);
    }

    private void updateControls() {
        int feets = mNumInches/12;
        int inches = mNumInches%12;
        String value = String.format("%d' %d\"", feets, inches);
        if(feets == 0)
            value = String.format("%d\"", inches);
        else
        if(inches == 0)
            value = String.format("%d'",feets);
        mTextView.setText(value);
        mMinusButton.setEnabled(mNumInches>0);
    }
}
