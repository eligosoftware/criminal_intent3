package com.eligosoftware.criminalintent3;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import java.text.SimpleDateFormat;

/**
 * Created by mragl on 14.10.2017.
 */

public class CrimeFragment extends Fragment {
    private Crime mCrime;
    private EditText mTitleView;
    private Button mDateButton;
    private CheckBox mSolvedCheckBox;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCrime=new Crime();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_crime,container,false);
        mTitleView=(EditText) v.findViewById(R.id.crime_title);
        mTitleView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mCrime.setTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        mDateButton=(Button)v.findViewById(R.id.crime_date);
//        String day_w=(new SimpleDateFormat("EEE").format(mCrime.getDate()));
//        day_w=day_w.toLowerCase();
//        day_w=day_w.substring(0,1).toUpperCase()+day_w.substring(1);
//        String month=(new SimpleDateFormat("MMM").format(mCrime.getDate()));
//        month=month.toLowerCase();
//        month=month.substring(0,1).toUpperCase()+month.substring(1);
     //   SimpleDateFormat sdf=new SimpleDateFormat("d, Y");
//        mDateButton.setText(day_w+", "+month+" "+sdf.format(mCrime.getDate()));
        SimpleDateFormat sdf=new SimpleDateFormat("EEE, MMM d, Y");
        mDateButton.setText(sdf.format(mCrime.getDate()));
        mDateButton.setEnabled(false);
        //mDateButton.setTransformationMethod(null);
        mSolvedCheckBox=(CheckBox)v.findViewById(R.id.crime_solved);
        mSolvedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mCrime.setSolved(isChecked);
            }
        });
        return v;
    }
}
