package com.sonderskov.androidtemplate.ui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sonderskov.androidtemplate.R;
import com.sonderskov.androidtemplate.ui.NullFragment;

import roboguice.inject.InjectView;

public class PlaceHolderFragment extends NullFragment {

    private static final String ARG_PLACEHOLDER_TEXT = "PlaceholderText";
    @InjectView(R.id.placeholder_text)
    private TextView mPlaceHolderText;

    private String mText = "";

    public static PlaceHolderFragment newInstance(String text) {
        PlaceHolderFragment fragment = new PlaceHolderFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PLACEHOLDER_TEXT, text);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getArguments() != null) {
            mText = getArguments().getString(ARG_PLACEHOLDER_TEXT, "???");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_placeholder, null);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPlaceHolderText.setText(mText);
    }
}
