import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
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

response = WS.sendRequest(findTestObject('Object Repository/GET ALL COMMENTS by POSTID API',
	["postId" : varPostId]
	))


WS.verifyElementPropertyValue(response, "[0].postId", varPostId)

WS.verifyResponseStatusCode(response, 200)

for(i=0; i < 5; i++) {
id = WS.getElementPropertyValue(response, "["+ i +"]")
name = WS.getElementPropertyValue(response, "["+ i +"]")
email = WS.getElementPropertyValue(response, "["+ i +"]")
body = WS.getElementPropertyValue(response, "["+ i +"]")


assert id != null && id != "";
assert name != null && name != "";
assert email != null && email != "";
assert body != null && body != "";

}