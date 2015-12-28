package com.sonderskov.androidtemplate.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.widget.Toast;

import com.google.inject.Inject;
import com.sonderskov.androidtemplate.R;

import java.util.LinkedList;

import roboguice.activity.RoboActionBarActivity;

public class BaseActivity extends RoboActionBarActivity implements DialogHelper {

    @Inject
    private Resources mResources;

    private LinkedList<Fragment> mFragmentStack = new LinkedList<>();
    private boolean mIsFragmentManagerStable = true;

    protected Fragment getCurrentFragment() {
        return mFragmentStack != null && !mFragmentStack.isEmpty() ? mFragmentStack.getLast() : null;
    }

    protected void addToBackStack(final Fragment fragment) {
        mFragmentStack.add(fragment);
    }

    protected void removeFromBackStack(final Fragment fragment) {
        mFragmentStack.remove(fragment);
    }

    protected void pushFragment(final Fragment fragment) {
        pushFragment(fragment, false);
    }

    protected void pushFragment(final Fragment fragment, boolean singleTop) {
        if(!mIsFragmentManagerStable) return;

        final FragmentManager fragmentManager = getSupportFragmentManager();
        final Fragment currentFragment = getCurrentFragment();
        final String tag = getTag(fragment);

        if(singleTop) {
            if(currentFragment != null && tag.equals(currentFragment.getTag())) {
                fragmentManager.popBackStack(tag, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            }
        }

        fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment, tag)
                .addToBackStack(tag)
                .commit();
    }

    protected String getTag(final Fragment fragment) {
        return fragment != null ? fragment.getClass().getName() : null;
    }

    // Guards against FragmentManager instability - avoid IllegalStateExceptions.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mIsFragmentManagerStable = true;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mIsFragmentManagerStable = false;
    }

    @Override
    public void showErrorDialog(Object error) {
        // TODO: Implement however you want.
        Toast.makeText(this, mResources.getText(R.string.dialog_error_unknown), Toast.LENGTH_SHORT).show();
    }
}
