import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.google.api.client.repackaged.org.apache.commons.codec.binary.StringUtils as StringUtils
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.testobject.ResponseObject as ResponseObject
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import org.apache.commons.lang3.StringUtils as StringUtils

CustomKeywords.'Shahid.getSssesion'()

//control json
def slurper = new groovy.json.JsonSlurper()

//Set JWT Into s-ssesion
ResponseObject packageConfigurationRes

String column

for (int j = 0; j < 3; j++) {
    // English Language
    if (j == 0) {
        packageConfigurationRes = WS.sendRequest(findTestObject('Object Repository/Upselling Messages/packageConfiguration', 
                [('ssession') : GlobalVariable.Ssession, ('language') : 'EN', ('acceptLanguage') : 'en']))

        column = 'M'

        CustomKeywords.'Shahid.verifyStatusCode'(packageConfigurationRes, 200)

        def packageConfigurationResBody = slurper.parseText(packageConfigurationRes.getResponseBodyContent())

        CustomKeywords.'sample.upsellingMessages.getPlayerUpsellingMessagesMap'(packageConfigurationResBody, 'SHAHID_VIP_SPORT', 
            'FREE')
    } else if (j == 1) {
        packageConfigurationRes = WS.sendRequest(findTestObject('Object Repository/Upselling Messages/packageConfiguration', 
                [('ssession') : GlobalVariable.Ssession, ('language') : 'AR', ('acceptLanguage') : 'ar']))

        column = 'L'

        CustomKeywords.'Shahid.verifyStatusCode'(packageConfigurationRes, 200)

        def packageConfigurationResBody = slurper.parseText(packageConfigurationRes.getResponseBodyContent())

        CustomKeywords.'sample.upsellingMessages.getPlayerUpsellingMessagesMap'(packageConfigurationResBody, 'SHAHID_VIP_SPORT', 
            'FREE')
    } else {
        packageConfigurationRes = WS.sendRequest(findTestObject('Object Repository/Upselling Messages/packageConfiguration', 
                [('ssession') : GlobalVariable.Ssession, ('language') : 'FR', ('acceptLanguage') : 'fr']))

        column = 'N'

        CustomKeywords.'Shahid.verifyStatusCode'(packageConfigurationRes, 200)

        def packageConfigurationResBody = slurper.parseText(packageConfigurationRes.getResponseBodyContent())

        CustomKeywords.'sample.upsellingMessages.getPlayerUpsellingMessagesMap'(packageConfigurationResBody, 'SHAHID_VIP_SPORT', 
            'FREE')
    }
	if (!((GlobalVariable.catalogMap['icon_1.label']).equals(CustomKeywords.'sample.upsellingMessages.getData'(22, column).toString().trim()))) {
		CustomKeywords.'sample.upsellingMessages.updateUpsellResultSheet'(CustomKeywords.'sample.upsellingMessages.getData'(
				22, 'B'), 'byContent', CustomKeywords.'sample.upsellingMessages.getData'(22, column), GlobalVariable.catalogMap[
			'icon_1.label'])

		KeywordUtil.markFailed((('HDIcons not matche Expected :' + CustomKeywords.'sample.upsellingMessages.getData'(22,
				column)) + 'Actual :') + (GlobalVariable.catalogMap['icon_1.label']).toString().trim())
	}
	
	if (!((GlobalVariable.catalogMap['icon_2.label']).equals(CustomKeywords.'sample.upsellingMessages.getData'(23, column).toString().trim()))) {
		CustomKeywords.'sample.upsellingMessages.updateUpsellResultSheet'(CustomKeywords.'sample.upsellingMessages.getData'(
				23, 'B'), 'byContent', CustomKeywords.'sample.upsellingMessages.getData'(23, column), GlobalVariable.catalogMap[
			'icon_2.label'])

		KeywordUtil.markFailed((('watchOfflineIcons not matche Expected :' + CustomKeywords.'sample.upsellingMessages.getData'(
				23, column).toString().trim()) + 'Actual :') + (GlobalVariable.catalogMap['icon_2.label']).toString().trim())
	}
	
	if (!((GlobalVariable.catalogMap['icon_3.label']).toString().trim().equals(CustomKeywords.'sample.upsellingMessages.getData'(
			24, column).toString().trim()))) {
		CustomKeywords.'sample.upsellingMessages.updateUpsellResultSheet'(CustomKeywords.'sample.upsellingMessages.getData'(
				24, 'B'), 'byContent', CustomKeywords.'sample.upsellingMessages.getData'(24, column), GlobalVariable.catalogMap[
			'icon_3.label'])

		KeywordUtil.markFailed((('watchOnTVIcons not matche Expected :' + CustomKeywords.'sample.upsellingMessages.getData'(
				24, column)) + 'Actual :') + (GlobalVariable.catalogMap['icon_3.label']).toString().trim())
	}
}