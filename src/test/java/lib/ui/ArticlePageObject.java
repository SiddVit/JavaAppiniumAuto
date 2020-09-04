package lib.ui;

import lib.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class ArticlePageObject extends MainPageObject {
    protected static String
            TITLE,
            FOOTER_ELEMENT,
            OPTIONS_BUTTON,
            ADD_TO_MY_LIST_BUTTON,
            ADD_TO_MY_LIST_OVERLAY,
            MY_LIST_NAME_INPUT,
            MY_LIST_OK_BUTTON,
            CLOSE_ARTICLE_BUTTON,
            MORE_OPTIONS,
            ADD_TO_READING_LIST,
            GOT_IT_BUTTON,
            INPUT_NAME_OF_FOLDER,
            OK_BUTTON,
            FOLDER_TITLE,
            AUTH_CLOSE,
            CLEAR_MINI;
    ;

    public ArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }

    public static String getSaveArticleXpathByTitle(String article_title) {
        return TITLE.replace("{TITLE}", article_title);
    }

    private static String getFolderXpathByName(String nameOfFolder) {
        return FOLDER_TITLE.replace("{FOLDER_TITLE}", nameOfFolder);
    }

    public WebElement waitForTitleElement(String nameTitle) {
        if (Platform.getInstance().isAndroid()) {
            return this.waitForElementPresent(TITLE, "Cannot find article title on page", 10);
        } else {
            return this.waitForElementPresent(getSaveArticleXpathByTitle(nameTitle), "Cannot find article title on page", 10);
        }
    }

    public String getArticleTitle(String nameTitle) {
        WebElement titleElement = waitForTitleElement(nameTitle);
        if (Platform.getInstance().isAndroid()) {
            return titleElement.getAttribute("text");
        } else {
            return titleElement.getAttribute("name");
        }
    }

    public void swipeToFooter() {
        if (Platform.getInstance().isAndroid()) {
            this.swipeUpToFindElement(FOOTER_ELEMENT, "Cannot find the end of article", 40);
        } else {
            this.swipeUpIsElementAppear(FOOTER_ELEMENT, "Cannot find the end of article", 40);
        }
    }

    public void addArticleToMyList(String name_of_folder) {
        this.waitForElementAndClick(OPTIONS_BUTTON, "Cannot find button to open article options", 5);
        this.waitForElementAndClick(ADD_TO_MY_LIST_BUTTON, "Cannot find option to add article to reading list", 5);
        this.waitForElementAndClick(ADD_TO_MY_LIST_OVERLAY, "Cannot find 'Got it' tip overlay", 5);
        this.waitForElementAndClear(MY_LIST_NAME_INPUT, "Cannot find input to set name of articles folder", 5);
        this.waitForElementAndSendKeys(MY_LIST_NAME_INPUT, name_of_folder, "Cannot find input to set name of articles folder", 5);
        this.waitForElementAndClick(MY_LIST_OK_BUTTON, "Cannot press OK button", 5);
    }

    public void closeArticle() {
        this.waitForElementAndClick(CLOSE_ARTICLE_BUTTON, "Cannot find button X button and tap they", 5);
    }


    public void clickMoreOptions() {
        this.waitForElementAndClick(MORE_OPTIONS, "Cannot find button to open article options", 5);
    }

    public void clickAddToReadingList() {
        this.waitForElementAndClick(ADD_TO_READING_LIST, "Cannot find option to add article to reading list", 5);
    }

    public void clickGotItButton() {
        this.waitForElementAndClick(GOT_IT_BUTTON, "Cannot find 'Got it' tip overlay", 5);
    }

    public void sendKeysToNameOfArticlesFolder(String name_of_folder) {
        this.waitForElementAndClear(INPUT_NAME_OF_FOLDER, "Cannot find input to set name of articles folder", 5);
        this.waitForElementAndSendKeys(INPUT_NAME_OF_FOLDER, name_of_folder, "Cannot find input to set name of articles folder", 5);
    }

    public void clickOk() {
        this.waitForElementAndClick(OK_BUTTON, "Cannot press OK button", 5);
    }

    public void clickAddToFolder() {
        this.waitForElementAndClick(FOLDER_TITLE, "Cannot find my list and click by them", 5);
    }

    public void addArticleToMySaved() {
        this.waitForElementAndClick(ADD_TO_MY_LIST_BUTTON, "Cannot find option to add article to reading list", 5);
    }

    public void addArticleToMyExistingList(String nameOfFolder) {
        this.waitForElementAndClick(OPTIONS_BUTTON, "Cannot find button to open article options", 5);
        this.waitForElementAndClick(ADD_TO_MY_LIST_BUTTON, "Cannot find option to add article to reading list", 5);
        this.waitForElementAndClick(getFolderXpathByName(nameOfFolder), "Cannot find and click folder by name " + nameOfFolder, 5);
    }

    public void iosAuthClose() {
        this.waitForElementAndClick(AUTH_CLOSE, "Cannot find and click by close", 5);
    }

    public void iosClearSearchString() {
        this.waitForElementAndClick(CLEAR_MINI, "Cannot find and click by close", 5);
    }
}
