package lib.ui.android;

import lib.ui.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidSearchPageObject extends SearchPageObject {
    static {
        SEARCH_INIT_ELEMENT = "xpath://*[contains(@text,'Search Wikipedia')]";
        SEARCH_INPUT = "xpath://*[contains(@text,'Search�')]";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_container']//*[contains(text(), '{SUBSTRING}')]";
        SEARCH_RESULT_BY_TITLE_AND_DESCRIPTION = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@class='android.widget.LinearLayout']";
        SEARCH_CANCEL_BUTTON = "id:org.wikipedia:id/search_close_btn";
        SEARCH_RESULT_ELEMENT = "xpath://*[@resource-id='org.wikipedia:id/search_results_list']/*[@resource-id='org.wikipedia:id/page_list_item_container']";
        SEARCH_EMPTY_RESULT_ELEMENT = "xpath://*[@text='No results found']";
        SEARCH_INPUT_TEXT = "xpath://*[@resource-id='org.wikipedia:id/search_container']//*[@class='android.widget.TextView']";
        SEARCH_RESULTS_ELEMENTS = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_title']";
        SEARCH_RESULTS_DESCRIPTION = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_description']";
    }

    public AndroidSearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
