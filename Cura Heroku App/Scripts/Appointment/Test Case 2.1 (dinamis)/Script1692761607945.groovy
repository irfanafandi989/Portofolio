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

WebUI.callTestCase(findTestCase('Login/Test Case 1.1 (Script)'), [('Username') : username, ('Password') : password], FailureHandling.STOP_ON_FAILURE)

WebUI.selectOptionByValue(findTestObject('Make Appointment/Select Drop Down Facility'), facility, false)

if (hospital_readmission.toString().equalsIgnoreCase('yes')) {
    WebUI.check(findTestObject('Make Appointment/Checkbox apply for hospital readmission'))
}

if (healthcare_program.toString().equalsIgnoreCase('Medicare')) {
    WebUI.check(findTestObject('Object Repository/Make Appointment/Radio Medicare programs'))
} else if (healthcare_program.toString().equalsIgnoreCase('Medicaid')) {
    WebUI.check(findTestObject('Object Repository/Make Appointment/Radio Medicaid programs'))
} else {//none
    WebUI.check(findTestObject('Object Repository/Make Appointment/Radio None programs'))
}

WebUI.setText(findTestObject('Make Appointment/input Visit Date (Required)'), visit_date)

WebUI.setText(findTestObject('Make Appointment/Text Area Comment'), comment)

WebUI.click(findTestObject('Make Appointment/button Book Appointment'))

WebUI.verifyElementPresent(findTestObject('Make Appointment/Tittle Appointment Confirmation'), 10)

hasilFacility = WebUI.getText(findTestObject('Object Repository/Make Appointment/Hasil facility'))

hasilReadmission = WebUI.getText(findTestObject('Make Appointment/Hasil apply for hospital'))

hasilhealtcare = WebUI.getText(findTestObject('Make Appointment/Hasil healtcare program'))

hasilVisitdate = WebUI.getText(findTestObject('Make Appointment/Hasil visit date'))

hasilComment = WebUI.getText(findTestObject('Make Appointment/Hasil comment'))

assert hasilFacility.trim().equalsIgnoreCase(facility.trim())
assert hasilReadmission.trim().equalsIgnoreCase(hospital_readmission.trim())
assert hasilhealtcare.trim().equalsIgnoreCase(healthcare_program.trim())
assert hasilVisitdate.trim().equalsIgnoreCase(visit_date.trim())
assert hasilComment.trim().equalsIgnoreCase(comment.trim())

