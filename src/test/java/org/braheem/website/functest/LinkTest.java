package org.braheem.website.functest;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(JUnitParamsRunner.class)
public class LinkTest extends BaseSeleniumTestCase {
	
	@Test
	public void test1Links() {
		//test navbar link for all pages, starting with Home Page
		testPageLink(PageId.Home.getValue(),"homephoto");
		testPageLink(PageId.Projects.getValue(), "projectsLink");
		testPageLink(PageId.Resume.getValue(), "resumeFrame");
		testPageLink(PageId.About.getValue(), "aboutPg");
		testPageLink(PageId.Contact.getValue(), "contactForm");
		testPageLink(PageId.Skills.getValue(), "skillHeader");
	}
	
	@Test
	@FileParameters("src/test/resources/skillsList.csv")
	public void test2ValidateSkillTable(String skillName, String competency) {
		Assert.assertTrue(testSkillNameValue(skillName,competency));
	}
}
