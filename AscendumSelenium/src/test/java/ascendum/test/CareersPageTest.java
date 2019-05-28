package ascendum.test;

import ascendum.base.TestBase;
import ascendum.pageActions.CareersPageActions;
import org.testng.annotations.Test;


public class CareersPageTest extends TestBase {

	CareersPageActions careersPageActions = new CareersPageActions();

	@Test
	public void validateCareersPage() {
		careersPageActions.verifyCareersPage();
		careersPageActions.checkAllLinks();
		
	}

}
