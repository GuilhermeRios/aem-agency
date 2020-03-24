package com.adobe.aem.agency.core.entities;

public class Slide {
    private String title;
    private String paragraph;
    private String content;
    private String background;
    private boolean showButton;
    private String buttonText;
    private String buttonLink;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getParagraph() {
        return paragraph;
    }

    public void setParagraph(String paragraph) {
        this.paragraph = paragraph;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public boolean isShowButton() {
        return showButton;
    }

    public void setShowButton(boolean showButton) {
        this.showButton = showButton;
    }

    public String getButtonText() {
        return buttonText;
    }

    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }

    public String getButtonLink() {
        return buttonLink;
    }

    public void setButtonLink(String buttonLink) {
        this.buttonLink = buttonLink;
    }
}
