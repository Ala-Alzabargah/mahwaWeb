import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebDriver

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import shahid.Common 


new Common().NavigateTo(GlobalVariable.SVODAsset)
new Common().checkLanguage()
String DeviceName = MobileDriverFactory.getDeviceName()
WebDriver driver = DriverFactory.getWebDriver()

    WebUI.click(findTestObject('Object Repository/HDlogin/' + GlobalVariable.objLanguage + '/LoginButton'))

	WebUI.setText(findTestObject('Object Repository/LoginScreen/usernameField'),  GlobalVariable.TeamUser)
	WebUI.click(findTestObject('Object Repository/loginThreeLanguages/'+GlobalVariable.objLanguage+'/continueButton'))
	WebUI.setText(findTestObject('loginThreeLanguages/passwordField'),  GlobalVariable.TeamUserPassword)
	WebUI.click(findTestObject('Object Repository/loginThreeLanguages/loginButton'))

      new Common().checkLanguage()
	  
	  WebUI.waitForElementPresent(findTestObject('adultDefault'), 10)
	  WebUI.click(findTestObject('adultDefault'), FailureHandling.CONTINUE_ON_FAILURE)
	  new Common().checkLanguage()
	  WebUI.verifyElementPresent(findTestObject('Object Repository/loginThreeLanguages/'+GlobalVariable.objLanguage+'/contentOnlyAvailableOnShahidVIPText'), 4)
	  WebUI.verifyElementPresent(findTestObject('Object Repository/loginThreeLanguages/'+GlobalVariable.objLanguage+'/subscribeAndEnjoyOriginalText'), 4)
	  WebUI.closeBrowser()

