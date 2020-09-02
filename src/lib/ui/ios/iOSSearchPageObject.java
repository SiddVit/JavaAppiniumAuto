package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.SearchPageObject;

public class iOSSearchPageObject extends SearchPageObject {
    static {
        SEARCH_INIT_ELEMENT = "xpath://XCUIElementTypeSearchField[@name='Search Wikipedia']";
        SEARCH_INPUT = "xpath://XCUIElementTypeSearchField[@value='Search Wikipedia']";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://XCUIElementTypeLink[contains(@name, '{SUBSTRING}')]";
        SEARCH_RESULT_BY_TITLE_AND_DESCRIPTION = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@class='android.widget.LinearLayout']";
        SEARCH_CANCEL_BUTTON = "id:Close";
        SEARCH_RESULT_ELEMENT = "xpath://*[@resource-id='org.wikipedia:id/search_results_list']/*[@resource-id='org.wikipedia:id/page_list_item_container']";
        SEARCH_EMPTY_RESULT_ELEMENT = "xpath://XCUIElementStaticText[@name='No results found']";
        SEARCH_INPUT_TEXT = "xpath://*[@resource-id='org.wikipedia:id/search_container']//*[@class='android.widget.TextView']";
        SEARCH_RESULTS_ELEMENTS = "xpath://XCUIElementTypeLink";
        SEARCH_RESULTS_DESCRIPTION = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_description']";
    }

    public iOSSearchPageObject(AppiumDriver driver) {
        super(driver);
    }
}
