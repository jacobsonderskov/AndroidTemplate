package com.sonderskov.androidtemplate.ui.main;

public class FrontPageModel {

    private String mText;

    public void init(String text) {
        mText = text;
    }

    // Purely as a proof of concept.
    public String getText() {
        return String.format("%s Galactic President Superstar McAwesomeville ", mText);
    }
}
