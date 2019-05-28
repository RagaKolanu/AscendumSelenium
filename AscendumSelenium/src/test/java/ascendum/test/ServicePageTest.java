package ascendum.test;

import ascendum.base.BaseActions;
import ascendum.pageLocators.HomePageLocators;
import org.testng.annotations.Test;

import ascendum.base.BaseActions;
import ascendum.pageLocators.HomePageLocators;

public class ServicePageTest {

	BaseActions baseActions = new BaseActions();

	@Test(priority = 7)
	public void validateServicePage() {
		baseActions.clickLinksAndButtons(HomePageLocators.link_contact);
		baseActions.checkAllAnchorTags();
	}

}
