package jaimesportfolio.com.interactivestory.UI;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import jaimesportfolio.com.interactivestory.R;
import jaimesportfolio.com.interactivestory.model.Page;
import jaimesportfolio.com.interactivestory.model.Story;

public class StoryActivity extends AppCompatActivity {

    //variable defined in the class
    public static final String TAG = StoryActivity.class.getSimpleName();

    private Story mStory = new Story();
    private ImageView mImageView;
    private Button mChoice2;
    private Button mChoice1;
    private TextView mTextView;
    private String mName;
    private Page mCurrentPage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        Intent intent = getIntent();
        //String name = intent.getStringExtra("name");
        //key_name refrences strings.xml file in Res>Values
        mName = intent.getStringExtra(getString(R.string.key_name));

        if (mName == null) {

            mName = "Friend";

        }
        Log.d(TAG, mName);

        mImageView = (ImageView) findViewById(R.id.storeImageView);
        mTextView = (TextView) findViewById(R.id.storyTextView);
        mChoice1 = (Button) findViewById(R.id.choiceButton1);
        mChoice2 = (Button) findViewById(R.id.choiceButton2);

        mChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int nextPage = mCurrentPage.getChoice1().getNextPage();
                loadPage(nextPage);

            }
        });
        mChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int nextPage = mCurrentPage.getChoice2().getNextPage();
                loadPage(nextPage);

            }
        });
    }



    private void loadPage(int choice){
        mCurrentPage = mStory.getPage(choice);

        //Drawable drawable = getResources().getDrawable(page.getImageId());
        //Drawable drawable = ContextCompat.getDrawable(this, page.getImageID());
        //Drawable drawable = ContextCompat.getDrawable(context, R.drawable.***);
        Drawable drawable = ResourcesCompat.getDrawable(getResources(), mCurrentPage.getImageId(), null);
        mImageView.setImageDrawable(drawable);

        String pageText = mCurrentPage.getText();
        pageText = String.format(pageText, mName);

        mTextView.setText(pageText);

        if (mCurrentPage.isFinal()) {
            mChoice1.setVisibility(View.INVISIBLE);
            mChoice2.setText("PLAY AGAIN");
            mChoice2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }else {
            mChoice1.setText(mCurrentPage.getChoice1().getText());
            mChoice2.setText(mCurrentPage.getChoice2().getText());

    }
};
}


