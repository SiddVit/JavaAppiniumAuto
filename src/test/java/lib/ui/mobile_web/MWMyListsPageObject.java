package lib.ui.mobile_web;

import lib.ui.MyListsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWMyListsPageObject extends MyListsPageObject {
    static {
        ARTICLE_BY_TITLE_TPL = "xpath://ul[contains(@class, 'watchlist')]//h3[contains(text(), '{TITLE}')]";
        REMOVE_FROM_SAVED_BUTTON = "xpath://ul[contains(@class, 'watchlist')]//h3[contains(text(), '{TITLE}')]//../..//a[@class='mw-ui-icon mw-ui-icon-wikimedia-unStar-progressive mw-ui-icon-element   watch-this-article watched']";
    }

    public MWMyListsPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
