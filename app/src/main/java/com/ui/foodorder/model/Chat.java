package com.ui.foodorder.model;

/** used chat adapter
 * used notify option adapter
 * */
public class Chat {
    private int image;
    private String title;
    private String subTitle;
    private boolean isStatus;

    public Chat(int image, String title, String subTitle, boolean isStatus) {
        this.image = image;
        this.title = title;
        this.subTitle = subTitle;
        this.isStatus = isStatus;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public boolean isStatus() {
        return isStatus;
    }

    public void setStatus(boolean status) {
        isStatus = status;
    }
}
