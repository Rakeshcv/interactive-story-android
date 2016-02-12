package com.rv.interactivestory.ui;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.rv.interactivestory.R;
import com.rv.interactivestory.model.Choice;
import com.rv.interactivestory.model.Page;
import com.rv.interactivestory.model.Story;

public class StoryActivity extends AppCompatActivity {

    private Story mStory = new Story();
    private ImageView mImageView;
    private TextView mTextView;
    private Button mChoice1;
    private Button mChoice2;
    private String mName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        Intent intent = getIntent();
        mName = intent.getStringExtra(getString(R.string.key_name));
        Toast.makeText(this, mName, Toast.LENGTH_SHORT).show();

        mImageView = (ImageView) findViewById(R.id.storyImageView);
        mTextView = (TextView) findViewById(R.id.storyTextView);
        mChoice1 = (Button) findViewById(R.id.choiceButton1);
        mChoice2 = (Button) findViewById(R.id.choiceButton2);

        loadPage();
    }

    private void loadPage() {
        Page page = mStory.getPage(0);

        Drawable drawable = getResources().getDrawable(page.getImageId());
        mImageView.setImageDrawable(drawable);

        String pageText = page.getText();

        //Add the name if placeholder is included.
        pageText = String.format(pageText,mName);

        mTextView.setText(pageText);

        mChoice1.setText(page.getChoice1().getText());

        mChoice2.setText(page.getChoice2().getText());
    }

}
