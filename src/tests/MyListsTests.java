package tests;

import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.MyListsPageObject;
import lib.ui.NavigationUI;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class MyListsTests extends CoreTestCase {
    String name_of_folder = "Learning programming";
    String search_line = "Java";

    @Test
    public void testSaveFirstArticleToMyList() {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        ArticlePageObject.waitForTitleElement();

        String article_title = ArticlePageObject.getArticleTitle();

        ArticlePageObject.addArticleToMyList(name_of_folder);
        ArticlePageObject.closeArticle();

        NavigationUI navigationUI = new NavigationUI(driver);
        navigationUI.clickMyLists();

        MyListsPageObject myListsPageObject = new MyListsPageObject(driver);
        myListsPageObject.openFolderByName(name_of_folder);
        myListsPageObject.swipeByArticleToDelete(article_title);
    }

    @Test
    public void testTwoArticlesToMyList() {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        String first_article_title = ArticlePageObject.getArticleTitle();
        ArticlePageObject.waitForTitleElement();
        ArticlePageObject.clickMoreOptions();
        ArticlePageObject.clickAddToReadingList();
        ArticlePageObject.clickGotItButton();
        ArticlePageObject.sendKeysToNameOfArticlesFolder(name_of_folder);
        ArticlePageObject.clickOk();
        ArticlePageObject.closeArticle();

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.clickByArticleWithSubstring("Island of Indonesia");
        String second_article_title = ArticlePageObject.getArticleTitle();

        ArticlePageObject.waitForTitleElement();
        ArticlePageObject.clickMoreOptions();
        ArticlePageObject.clickAddToReadingList();
        ArticlePageObject.clickAddToFolder();
        ArticlePageObject.closeArticle();

        NavigationUI navigationUI = new NavigationUI(driver);
        navigationUI.clickMyLists();

        MyListsPageObject myListsPageObject = new MyListsPageObject(driver);
        myListsPageObject.openFolderByName(name_of_folder);
        myListsPageObject.swipeByArticleToDelete(second_article_title);
        myListsPageObject.waitForArticleToAppearByTitle(first_article_title);
        myListsPageObject.openArticleByName(first_article_title);
        String title_of_article = ArticlePageObject.getArticleTitle();
        assertEquals("Article has been changed after open", first_article_title, title_of_article);
    }
}
