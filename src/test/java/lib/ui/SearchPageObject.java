package lib.ui;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;

abstract public class SearchPageObject extends MainPageObject {
    protected static String SEARCH_INIT_ELEMENT,
            SEARCH_INPUT,
            SEARCH_RESULT_BY_SUBSTRING_TPL,
            SEARCH_RESULT_BY_TITLE_AND_DESCRIPTION,
            SEARCH_CANCEL_BUTTON,
            SEARCH_RESULT_ELEMENT,
            SEARCH_EMPTY_RESULT_ELEMENT,
            SEARCH_INPUT_TEXT,
            SEARCH_RESULTS_ELEMENTS,
            SEARCH_RESULTS_DESCRIPTION;


    public SearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    /* TEMPLATES METHODS */
    private static String getResultSearchElement(String substring) {
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
    }

    private List<WebElement> getElementByTitleAndDescription() {
        return this.waitForElementsPresent(SEARCH_RESULT_BY_TITLE_AND_DESCRIPTION,
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
        this.waitForElementAndClick(SEARCH_INIT_ELEMENT, "Cannot find and click init search element", 5);
        this.waitForElementPresent(SEARCH_INIT_ELEMENT, "Cannot find search input after clicking search init element");
    }

    public void typeSearchLine(String search_line) {
        this.waitForElementAndSendKeys(SEARCH_INPUT, search_line, "Cannot find and type into search input", 5);
    }

    public void waitForSearchResult(String substring) {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementPresent(search_result_xpath, "Cannot find search result with substring " + substring);
    }

    public void waitForCancelButtonToAppend() {
        this.waitForElementPresent(SEARCH_CANCEL_BUTTON, "Search cancel button is still present", 5);
    }

    public void clickCancelSearch() {
        this.waitForElementAndClick(SEARCH_CANCEL_BUTTON, "Cannot find and click search cancel button", 5);
    }

    public void waitForCancelButtonToDisappear() {
        this.waitForElementNotPresent(SEARCH_CANCEL_BUTTON, "Cannot find search cancel button", 5);
    }

    public void clickByArticleWithSubstring(String substring) {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementAndClick(search_result_xpath, "Cannot find and click search result with substring " + substring, 10);
    }

    public int getAmountOfFoundArticles() {
        this.waitForElementPresent(
                SEARCH_RESULT_ELEMENT,
                "Cannot find anything by request",
                15
        );
        return this.getAmountOfElements(SEARCH_RESULT_ELEMENT);
    }

    public void waitForEmptyResultLabel() {
        this.waitForElementPresent(
                SEARCH_EMPTY_RESULT_ELEMENT,
                "Cannot find empty result element",
                15);
    }

    public void assertThereIsNoResultOfSearch() {
        this.waitForElementNotPresent(
                SEARCH_RESULT_ELEMENT,
                "We supposed not to find any results",
                15);
    }

    public String getTextFromSearchInput() {
        return this.waitForElementAndGetAttribute(SEARCH_INPUT_TEXT, "text",
                "Cannot find search input element", 5);
    }

    public List<WebElement> getSearchedElements() {
        return this.waitForElementsPresent(
                SEARCH_RESULTS_ELEMENTS,
                "Cannot find searched result", 10);
    }
}
