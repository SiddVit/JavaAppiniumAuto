package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePageObject;

public class iOSArticlePageObject extends ArticlePageObject {
    static {
        TITLE = "id:Java (programming language)";
        FOOTER_ELEMENT = "id:View article in browser";
        ADD_TO_MY_LIST_BUTTON = "id:Save for later";
        CLOSE_ARTICLE_BUTTON = "id:Back";
        MORE_OPTIONS = "xpath://android.widget.ImageView[@content-desc='More options']";
        ADD_TO_READING_LIST = "xpath://*[@text='Add to reading list']";
        GOT_IT_BUTTON = "id:org.wikipedia:id/onboarding_button";
        INPUT_NAME_OF_FOLDER = "id:org.wikipedia:id/text_input";
        OK_BUTTON = "xpath://*[@text='OK']";
        FOLDER_TITLE = "id:org.wikipedia:id/item_title";
    }

    public iOSArticlePageObject(AppiumDriver driver) {
        super(driver);
    }
}
