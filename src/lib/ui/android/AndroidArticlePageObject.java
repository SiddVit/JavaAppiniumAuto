package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePageObject;

public class AndroidArticlePageObject extends ArticlePageObject {
    static {
        TITLE = "id:org.wikipedia:id/view_page_title_text";
        FOOTER_ELEMENT = "xpath://*[@text='View page in browser']";
        OPTIONS_BUTTON = "xpath://android.widget.ImageView[@content-desc='More options']";
        ADD_TO_MY_LIST_BUTTON = "xpath://*[@text='Add to reading list']";
        ADD_TO_MY_LIST_OVERLAY = "id:org.wikipedia:id/onboarding_button";
        MY_LIST_NAME_INPUT = "id:org.wikipedia:id/text_input";
        MY_LIST_OK_BUTTON = "xpath://*[@text='OK']";
        CLOSE_ARTICLE_BUTTON = "xpath://android.widget.ImageButton[@content-desc='Navigate up']";
        MORE_OPTIONS = "xpath://android.widget.ImageView[@content-desc='More options']";
        ADD_TO_READING_LIST = "xpath://*[@text='Add to reading list']";
        GOT_IT_BUTTON = "id:org.wikipedia:id/onboarding_button";
        INPUT_NAME_OF_FOLDER = "id:org.wikipedia:id/text_input";
        OK_BUTTON = "xpath://*[@text='OK']";
        FOLDER_TITLE = "id:org.wikipedia:id/item_title";
    }

    public AndroidArticlePageObject(AppiumDriver driver) {
        super(driver);
    }
}
