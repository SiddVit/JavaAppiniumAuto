package lib.ui;

import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class MyListsPageObject extends MainPageObject {
    protected static String
            FOLDER_BY_NAME_TPL,
            ARTICLE_BY_TITLE_TPL;

    public MyListsPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    public static String getFolderXpathByName(String name_of_folder) {
        return FOLDER_BY_NAME_TPL.replace("{FOLDER_NAME}", name_of_folder);
    }

    public static String getSaveArticleXpathByTitle(String article_title) {
        return ARTICLE_BY_TITLE_TPL.replace("{TITLE}", article_title);
    }

    public void openFolderByName(String name_of_folder) {
        this.waitForElementAndClick(
                getFolderXpathByName(name_of_folder),
                "Cannot find folder by name " + name_of_folder,
                5);
    }

    public void openArticleByName(String name_of_article) {
        this.waitForElementAndClick(
                getFolderXpathByName(name_of_article),
                "Cannot find article by name " + name_of_article,
                5);
    }

    public void swipeByArticleToDelete(String article_title) {
        this.waitForArticleToAppearByTitle(article_title);
        this.swipeElementToLeft(
                getSaveArticleXpathByTitle(article_title),
                "Cannot find saved article");
        if (Platform.getInstance().isIOS()) {
            this.clickElementToTheRightUpperCorner(article_title, "Cannot find article ");
        }
        this.waitForArticleToDisappearByTitle(article_title);
    }

    public void waitForArticleToDisappearByTitle(String article_title) {
        this.waitForElementNotPresent(
                getSaveArticleXpathByTitle(article_title),
                "Saved article still present with title " + article_title,
                15);
    }

    public void waitForArticleToAppearByTitle(String article_title) {
        this.waitForElementPresent(
                getSaveArticleXpathByTitle(article_title),
                "Cannot find saved article by title " + article_title,
                15);
    }
}
