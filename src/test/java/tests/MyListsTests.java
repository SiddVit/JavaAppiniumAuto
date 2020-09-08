package tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.*;
import lib.ui.factory.ArticlePageObjectFactory;
import lib.ui.factory.MyListsPageObjectFactory;
import lib.ui.factory.NavigationUIFactory;
import lib.ui.factory.SearchPageObjectFactory;
import org.junit.Test;

public class MyListsTests extends CoreTestCase {
    private static final String name_of_folder = "Learning programming";
    private static final String search_line = "Java";
    private static final String full_article_title = "Java (programming language)";
    public static final String login = "sidvit";
    public static final String password = "qqwerty122";


    @Test
    public void testSaveFirstArticleToMyList() {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.clickByArticleWithSubstring("bject-oriented programming language");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.waitForTitleElement(full_article_title);

        String article_title = ArticlePageObject.getArticleTitle(full_article_title);

        if (Platform.getInstance().isAndroid()) {
            ArticlePageObject.addArticleToMyList(name_of_folder);
        } else {
            ArticlePageObject.addArticleToMySaved();
        }
        if (Platform.getInstance().isMW()) {
            AuthorizationPageObject authorizationPageObject = new AuthorizationPageObject(driver);
            authorizationPageObject.clickAuthButton();
            authorizationPageObject.enterLoginData(login, password);
            authorizationPageObject.submitForm();

            ArticlePageObject.waitForTitleElement(full_article_title);
            assertEquals("We are not on the same page after login", article_title, ArticlePageObject.getArticleTitle(full_article_title));

            ArticlePageObject.addArticleToMySaved();
        }
        ArticlePageObject.closeArticle();

        NavigationUI navigationUI = NavigationUIFactory.get(driver);
        navigationUI.openNavigation();
        navigationUI.clickMyLists();

        MyListsPageObject myListsPageObject = MyListsPageObjectFactory.get(driver);
        if (Platform.getInstance().isAndroid()) {
            myListsPageObject.openFolderByName(name_of_folder);
        }
        myListsPageObject.swipeByArticleToDelete(article_title);
    }

    @Test
    public void testTwoArticlesToMyList() {
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine(search_line);
        searchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

        ArticlePageObject articlePageObject = ArticlePageObjectFactory.get(driver);
        articlePageObject.waitForTitleElement(full_article_title);

        String first_article_title = articlePageObject.getArticleTitle(full_article_title);
        if (Platform.getInstance().isAndroid()) {
            articlePageObject.addArticleToMyList(name_of_folder);
        } else if (Platform.getInstance().isIOS()) {
            articlePageObject.addArticleToMySaved();
            articlePageObject.iosAuthClose();
        } else {
            articlePageObject.addArticleToMySaved();
        }

        if (Platform.getInstance().isMW()) {
            AuthorizationPageObject authorizationPageObject = new AuthorizationPageObject(driver);
            authorizationPageObject.clickAuthButton();
            authorizationPageObject.enterLoginData(login, password);
            authorizationPageObject.submitForm();

            articlePageObject.waitForTitleElement(full_article_title);
            assertEquals("We are not on the same page after login", first_article_title, articlePageObject.getArticleTitle(full_article_title));

            articlePageObject.addArticleToMySaved();
        }

        articlePageObject.closeArticle();

        searchPageObject.initSearchInput();
        if (Platform.getInstance().isIOS()) {
            articlePageObject.iosClearSearchString();
        }

        searchPageObject.typeSearchLine(search_line);
        searchPageObject.clickByArticleWithSubstring("Island of Indonesia");

        articlePageObject.waitForTitleElement(search_line);

        String second_article_title = articlePageObject.getArticleTitle(search_line);

        if (Platform.getInstance().isAndroid()) {
            articlePageObject.addArticleToMyExistingList(name_of_folder);
        } else if (Platform.getInstance().isIOS()) {
            articlePageObject.addArticleToMySaved();
        } else {
            articlePageObject.addArticleToMySaved();
        }
        articlePageObject.closeArticle();

        NavigationUI navigationUI = NavigationUIFactory.get(driver);
        navigationUI.clickMyLists();

        MyListsPageObject myListPageObject = MyListsPageObjectFactory.get(driver);

        if (Platform.getInstance().isAndroid()) {
            myListPageObject.openFolderByName(name_of_folder);
        }

        myListPageObject.swipeByArticleToDelete(first_article_title);
        myListPageObject.waitForArticleToAppearByTitle(second_article_title);
    }
}
