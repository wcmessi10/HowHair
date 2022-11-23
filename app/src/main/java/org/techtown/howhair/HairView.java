package org.techtown.howhair;

import android.graphics.Bitmap;

public class HairView {

    String type;
    String text;
    Bitmap image;

    public HairView(String type, String text, Bitmap image){
        this.type = type;
        this.text = text;
        this.image = image;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    /*public void setText(String text) {
        this.text = text;
    }*/

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }
}
