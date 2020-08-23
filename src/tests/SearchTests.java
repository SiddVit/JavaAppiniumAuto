package tests;

import lib.CoreTestCase;
import lib.ui.SearchPageObject;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchTests extends CoreTestCase {
    @Test
    public void testSearch() {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResult("Object-oriented programming language");
    }

    @Test
    public void testCancelSearch() {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.waitForCancelButtonToAppend();
        SearchPageObject.clickCancelSearch();
        SearchPageObject.waitForCancelButtonToDisappear();
    }

    @Test
    public void testCheckTextInSearchInput() {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        assertEquals("Incorrect text in searching input", "Search Wikipedia", SearchPageObject.getTextFromSearchInput());
    }

    @Test
    public void testAmountOfNotEmptySearch() {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Linkin Park Discography");
        int amount_of_search_elements = SearchPageObject.getAmountOfFoundArticles();
        assertTrue(
                "We found too few results!",
                amount_of_search_elements > 0
        );
    }

    @Test
    public void testAmountOfEmptySearch() {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("zxcvasdfqwer");
        SearchPageObject.waitForEmptyResultLabel();
        SearchPageObject.assertThereIsNoResultOfSearch();
    }

    @Test
    public void testCancelSearchAfterFind() {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.getAmountOfFoundArticles();

        assertEquals("Incorrect value between waiting and actual data", 4, SearchPageObject.getAmountOfFoundArticles());

        SearchPageObject.clickCancelSearch();
        SearchPageObject.assertThereIsNoResultOfSearch();
    }

    @Test
    public void testCheckedSearchResults() {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");

        List<WebElement> searched_elements = SearchPageObject.getSearchedElements();

        for (int i = 0; i < searched_elements.size(); i++) {
            assertTrue(
                    String.format("In %s index of elements hasn't word Java, but has %s", i, searched_elements.get(i).getAttribute("text")),
                    searched_elements.get(i).getAttribute("text").contains("Java"));
        }
    }
}
