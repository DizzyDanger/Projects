package jaimesportfolio.com.interactivestory.model;

/**
 * Created by Jaime on 8/20/2016.
 */
public class Page {

    //variables
    private int mImageId;
    private String mText;
    private Choice mChoice1;
    private Choice mChoice2;
    private boolean mIsFinal = false;
    private int mImageID;


    public Page(int id, String text, Choice choice1, Choice choice2) {
        mImageId = id;
        mText = text;
        mChoice1 = choice1;
        mChoice2 = choice2;

    }

    public Page(int id, String text){

        mImageId = id;
        mText = text;
        mChoice1 = null;
        mChoice2 = null;

    }

    public boolean isFinal() {
        return mIsFinal;
    }

    public void setFinal(boolean aFinal) {
        mIsFinal = aFinal;
    }

    public int getImageId() {

         return mImageId;

    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }

    public Choice getChoice1() {
        return mChoice1;
    }

    public void setChoice1(Choice choice1) {
        mChoice1 = choice1;
    }

    public Choice getChoice2() {
        return mChoice2;
    }

    public void setChoice2(Choice choice2) {
        mChoice2 = choice2;
    }

    public void setImageId(int id){

        mImageId = id;


    }

    public int getImageID() {
        return mImageID;
    }
}
