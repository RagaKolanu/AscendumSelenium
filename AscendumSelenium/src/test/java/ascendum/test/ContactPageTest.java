package ascendum.test;

import java.io.IOException;
import org.testng.annotations.Test;

import ascendum.base.BaseActions;
import ascendum.base.TestBase;
import ascendum.pageActions.ContactPageActions;
import ascendum.pageLocators.HomePageLocators;

public class ContactPageTest extends TestBase {

	ContactPageActions contactPageActions = new ContactPageActions();

	BaseActions baseActions = new BaseActions();

	@Test
	public void verifyContact() throws InterruptedException, IOException {
		baseActions.clickLinksAndButtons(HomePageLocators.link_contact);
		contactPageActions.verifyContactPage();
	}

}
