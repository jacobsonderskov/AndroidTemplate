package com.sonderskov.androidtemplate.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.inject.Inject;
import com.sonderskov.androidtemplate.BaseFragment;
import com.sonderskov.androidtemplate.R;

import roboguice.inject.InjectView;


public class FrontPageFragment extends BaseFragment {

    private static final String ARG_TEXT = "text";

    @InjectView(R.id.text)
    private TextView mTextView;


    private FrontPagePresenter.View mView = new FrontPagePresenter.View() {
        @Override
        public void setText(String text) {
            mTextView.setText(text);
        }
    };

    @Inject
    private FrontPagePresenter mPresenter;

    private String mText;

    public FrontPageFragment() {
        // Required empty public constructor
    }

    public static FrontPageFragment newInstance(String text) {
        FrontPageFragment fragment = new FrontPageFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TEXT, text);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mText = getArguments().getString(ARG_TEXT);
        }

        mPresenter.init(mText);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_frontpage, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Set up any event listeners (e.g. onClickListener)
        // ...

        // Attach the view, when the view is ready.
        mPresenter.setView(mView);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mPresenter.setNavigation(((MainActivity) getActivity()).getNavigation());
    }

    @Override
    public void onStart() {
        super.onStart();
        mPresenter.onStart();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }
}
