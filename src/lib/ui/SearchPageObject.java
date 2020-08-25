package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPageObject extends MainPageObject {
    private static final String SEARCH_INIT_ELEMENT = "//*[contains(@text,'Search Wikipedia')]",
            SEARCH_INPUT = "//*[contains(@text,'Search…')]",
            SEARCH_RESULT_BY_SUBSTRING_TPL = "//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='{SUBSTRING}']",
            SEARCH_RESULT_BY_TITLE_AND_DESCRIPTION = "//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@class='android.widget.LinearLayout']",
            SEARCH_CANCEL_BUTTON = "org.wikipedia:id/search_close_btn",
            SEARCH_RESULT_ELEMENT = "//*[@resource-id='org.wikipedia:id/search_results_list']/*[@resource-id='org.wikipedia:id/page_list_item_container']",
            SEARCH_EMPTY_RESULT_ELEMENT = "//*[@text='No results found']",
            SEARCH_INPUT_TEXT = "//*[@resource-id='org.wikipedia:id/search_container']//*[@class='android.widget.TextView']",
            SEARCH_RESULTS_ELEMENTS = "//*[@resource-id='org.wikipedia:id/page_list_item_title']",
            SEARCH_RESULTS_DESCRIPTION = "//*[@resource-id='org.wikipedia:id/page_list_item_description']";


    public SearchPageObject(AppiumDriver driver) {
        super(driver);
    }

    /* TEMPLATES METHODS */
    private static String getResultSearchElement(String substring) {
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
    }

    private List<WebElement> getElementByTitleAndDescription() {
        return this.waitForElementsPresent(By.xpath(SEARCH_RESULT_BY_TITLE_AND_DESCRIPTION),
                "Can't find finding elements", 5);
    }

    public void waitForElementByTitleAndDescription(String title, String description) {
        List<WebElement> elements = this.getElementByTitleAndDescription();
        int i = 0;
        int catcher = 0;
        while (i < elements.size()) {
            if (elements.get(i).findElement(By.xpath(SEARCH_RESULTS_ELEMENTS)).getAttribute("text").equals(title)
                    && elements.get(i).findElement(By.xpath(SEARCH_RESULTS_DESCRIPTION)).getAttribute("text").equals(description)) {
                catcher++;
                break;
            }
            i++;
        }
        if (catcher == 0) {
            Assert.fail(String.format("Can't find '%s' and '%s' in this search result", title, description));
        } else {
            Assert.assertTrue(true);
        }
    }
    /* TEMPLATES METHODS */

    public void initSearchInput() {
        this.waitForElementAndClick(By.xpath(SEARCH_INIT_ELEMENT), "Cannot find and click init search element", 5);
        this.waitForElementPresent(By.xpath(SEARCH_INIT_ELEMENT), "Cannot find search input after clicking search init element");
    }

    public void typeSearchLine(String search_line) {
        this.waitForElementAndSendKeys(By.xpath(SEARCH_INPUT), search_line, "Cannot find and type into search input", 5);
    }

    public void waitForSearchResult(String substring) {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementPresent(By.xpath(search_result_xpath), "Cannot find search result with substring " + substring);
    }

    public void waitForCancelButtonToAppend() {
        this.waitForElementPresent(By.id(SEARCH_CANCEL_BUTTON), "Search cancel button is still present", 5);
    }

    public void clickCancelSearch() {
        this.waitForElementAndClick(By.id(SEARCH_CANCEL_BUTTON), "Cannot find and click search cancel button", 5);
    }

    public void waitForCancelButtonToDisappear() {
        this.waitForElementNotPresent(By.id(SEARCH_CANCEL_BUTTON), "Cannot find search cancel button", 5);
    }

    public void clickByArticleWithSubstring(String substring) {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementAndClick(By.xpath(search_result_xpath), "Cannot find and click search result with substring " + substring, 10);
    }

    public int getAmountOfFoundArticles() {
        this.waitForElementPresent(
                By.xpath(SEARCH_RESULT_ELEMENT),
                "Cannot find anything by request",
                15
        );
        return this.getAmountOfElements(By.xpath(SEARCH_RESULT_ELEMENT));
    }

    public void waitForEmptyResultLabel() {
        this.waitForElementPresent(
                By.xpath(SEARCH_EMPTY_RESULT_ELEMENT),
                "Cannot find empty result element",
                15);
    }

    public void assertThereIsNoResultOfSearch() {
        this.waitForElementNotPresent(
                By.xpath(SEARCH_RESULT_ELEMENT),
                "We supposed not to find any results",
                15);
    }

    public String getTextFromSearchInput() {
        return this.waitForElementAndGetAttribute(By.xpath(SEARCH_INPUT_TEXT), "text",
                "Cannot find search input element", 5);
    }

    public List<WebElement> getSearchedElements() {
        return this.waitForElementsPresent(
                By.xpath(SEARCH_RESULTS_ELEMENTS),
                "Cannot find searched result", 10);
    }
}
