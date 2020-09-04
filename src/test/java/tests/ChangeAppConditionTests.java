package tests;

import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.SearchPageObject;
import lib.ui.factory.ArticlePageObjectFactory;
import lib.ui.factory.SearchPageObjectFactory;
import org.junit.Test;

public class ChangeAppConditionTests extends CoreTestCase {
    private static final String name_of_substring = "Object-oriented programming language";
    private static final String search_line = "Java";
    private static final String full_article_title = "Java (programming language)";

    @Test
    public void testChangeScreenOrientationOnSearchResults() {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.clickByArticleWithSubstring(name_of_substring);

        ArticlePageObject articlePageObject = ArticlePageObjectFactory.get(driver);
        String title_before_rotation = articlePageObject.getArticleTitle(full_article_title);
        this.rotateScreenLandscape();
        String title_after_rotation = articlePageObject.getArticleTitle(full_article_title);
        assertEquals("Article title has been changed after rotation",
                title_before_rotation, title_after_rotation);
        this.rotateScreenPortrait();
        String title_after_second_rotation = articlePageObject.getArticleTitle(full_article_title);
        assertEquals("Article title has been changed after rotation",
                title_after_second_rotation, title_after_rotation);
    }

    @Test
    public void testCheckSearchArticleInBackground() {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.waitForSearchResult(name_of_substring);
        this.backgroundApp(2);
        SearchPageObject.waitForSearchResult(name_of_substring);
    }
}
