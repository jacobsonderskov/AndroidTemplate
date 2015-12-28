package com.sonderskov.androidtemplate.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.inject.Inject;
import com.sonderskov.androidtemplate.ui.BaseFragment;
import com.sonderskov.androidtemplate.R;
import com.sonderskov.androidtemplate.ui.BasePresenter;
import com.sonderskov.androidtemplate.ui.DialogHelper;

import roboguice.inject.InjectView;


public class FrontPageFragment extends BaseFragment<FrontPagePresenter.View> {

    @InjectView(R.id.text)
    private TextView mTextView;
    @InjectView(R.id.api_text)
    private TextView mApiTextView;

    private FrontPagePresenter.View mView = new FrontPagePresenter.View() {
        @Override
        public DialogHelper getDialogHelper() {
            return FrontPageFragment.this;
        }

        @Override
        public void setText(String text) {
            mTextView.setText(text);
        }

        @Override
        public void setApiText(String apiText) {
            mApiTextView.setText(apiText);
        }
    };

    @Inject
    protected FrontPagePresenter mPresenter;

    @Override
    protected FrontPagePresenter.View getViewImplementation() {
        return mView;
    }

    @Override
    protected BasePresenter getPresenter() {
        return mPresenter;
    }

    public FrontPageFragment() {
        // Required empty public constructor
    }

    public static FrontPageFragment newInstance(String text) {
        FrontPageFragment fragment = new FrontPageFragment();
        Bundle args = new Bundle();
        args.putString(FrontPagePresenter.ARG_TEXT, text);
        fragment.setArguments(args);
        return fragment;
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
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mPresenter.setNavigation(((MainActivity) getActivity()).getNavigation());
    }
}
