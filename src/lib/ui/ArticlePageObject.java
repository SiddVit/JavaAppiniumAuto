package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ArticlePageObject extends MainPageObject {
    private static final String TITLE = "org.wikipedia:id/view_page_title_text",
            FOOTER_ELEMENT = "//*[@text='View page in browser']",
            OPTIONS_BUTTON = "//android.widget.ImageView[@content-desc='More options']",
            ADD_TO_MY_LIST_BUTTON = "//*[@text='Add to reading list']",
            ADD_TO_MY_LIST_OVERLAY = "org.wikipedia:id/onboarding_button",
            MY_LIST_NAME_INPUT = "org.wikipedia:id/text_input",
            MY_LIST_OK_BUTTON = "//*[@text='OK']",
            CLOSE_ARTICLE_BUTTON = "//android.widget.ImageButton[@content-desc='Navigate up']",
            MORE_OPTIONS = "//android.widget.ImageView[@content-desc='More options']",
            ADD_TO_READING_LIST = "//*[@text='Add to reading list']",
            GOT_IT_BUTTON = "org.wikipedia:id/onboarding_button",
            INPUT_NAME_OF_FOLDER = "org.wikipedia:id/text_input",
            OK_BUTTON = "//*[@text='OK']",
            FOLDER_TITLE = "org.wikipedia:id/item_title";

    public ArticlePageObject(AppiumDriver driver) {
        super(driver);
    }

    public WebElement waitForTitleElement() {
        return this.waitForElementPresent(By.id(TITLE), "Cannot find article title on page", 15);
    }

    public String getArticleTitle() {
        WebElement title_element = waitForTitleElement();
        return title_element.getAttribute("text");
    }

    public void swipeToFooter() {
        this.swipeUpToFindElement(By.xpath(FOOTER_ELEMENT),
                "Cannot find the end of article", 20);
    }

    public void addArticleToMyList(String name_of_folder) {
        this.waitForElementAndClick(By.xpath(OPTIONS_BUTTON), "Cannot find button to open article options", 5);
        this.waitForElementAndClick(By.xpath(ADD_TO_MY_LIST_BUTTON), "Cannot find option to add article to reading list", 5);
        this.waitForElementAndClick(By.id(ADD_TO_MY_LIST_OVERLAY), "Cannot find 'Got it' tip overlay", 5);
        this.waitForElementAndClear(By.id(MY_LIST_NAME_INPUT), "Cannot find input to set name of articles folder", 5);
        this.waitForElementAndSendKeys(By.id(MY_LIST_NAME_INPUT), name_of_folder, "Cannot find input to set name of articles folder", 5);
        this.waitForElementAndClick(By.xpath(MY_LIST_OK_BUTTON), "Cannot press OK button", 5);
    }

    public void closeArticle() {
        this.waitForElementAndClick(
                By.xpath(CLOSE_ARTICLE_BUTTON),
                "Cannot find button X button and tap they",
                5);
    }


    public void clickMoreOptions() {
        this.waitForElementAndClick(
                By.xpath(MORE_OPTIONS),
                "Cannot find button to open article options",
                5);
    }

    public void clickAddToReadingList() {
        this.waitForElementAndClick(
                By.xpath(ADD_TO_READING_LIST),
                "Cannot find option to add article to reading list",
                5);
    }

    public void clickGotItButton() {
        this.waitForElementAndClick(
                By.id(GOT_IT_BUTTON),
                "Cannot find 'Got it' tip overlay",
                5);
    }

    public void sendKeysToNameOfArticlesFolder(String name_of_folder) {
        this.waitForElementAndClear(
                By.id(INPUT_NAME_OF_FOLDER),
                "Cannot find input to set name of articles folder",
                5);
        this.waitForElementAndSendKeys(
                By.id(INPUT_NAME_OF_FOLDER),
                name_of_folder,
                "Cannot find input to set name of articles folder",
                5);
    }

    public void clickOk() {
        this.waitForElementAndClick(
                By.xpath(OK_BUTTON),
                "Cannot press OK button",
                5);
    }

    public void clickAddToFolder() {
        this.waitForElementAndClick(
                By.id(FOLDER_TITLE),
                "Cannot find my list and click by them",
                5);
    }
}
