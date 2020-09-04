package lib.ui.ios;

import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class iOSArticlePageObject extends ArticlePageObject {
    static {
        TITLE = "id:{TITLE}";
        FOOTER_ELEMENT = "id:View article in browser";
        ADD_TO_MY_LIST_BUTTON = "id:Save for later";
        CLOSE_ARTICLE_BUTTON = "id:Back";
        AUTH_CLOSE = "id:places auth close";
        CLEAR_MINI = "id:clear mini";
    }

    public iOSArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
