package com.sonderskov.androidtemplate.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.inject.Inject;
import com.sonderskov.androidtemplate.R;
import com.sonderskov.androidtemplate.ui.main.FrontPagePresenter;
import com.sonderskov.androidtemplate.ui.main.MainNavigation;

import roboguice.inject.InjectView;


public class NullFragment extends BaseFragment<Object, Object> {

    @InjectView(R.id.text)
    private TextView mTextView;

    @Inject
    protected NullPresenter mPresenter;

    @Override
    protected FrontPagePresenter.View getConcreteView() {
        return null;
    }

    @Override
    protected MainNavigation getConcreteNavigation() {
        return null;
    }

    @Override
    protected BasePresenter getPresenter() {
        return mPresenter;
    }

    public NullFragment() {
        // Required empty public constructor
    }

    public static NullFragment newInstance() {
        NullFragment fragment = new NullFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_frontpage, container, false);
    }

}
