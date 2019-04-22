package ascendum.test;

import ascendum.base.TestBase;
import ascendum.pageActions.HomePageActions;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {

    public static final Logger log = Logger.getLogger(HomePageTest.class.getName());

    HomePageActions homepageactions = new HomePageActions();

    @Test
    public void validateHomepage() {
        homepageactions.verifyHomePageElements();
        homepageactions.checkLinks();
        homepageactions.searchData();
        homepageactions.mouseHoverServiceLink();
    }
}
