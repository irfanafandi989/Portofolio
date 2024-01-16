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
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword as WebUIAbstractKeyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

//1.open browser
WebUI.openBrowser('https://katalon-demo-cura.herokuapp.com/')

//2.verifikasi Tittle Home Page
WebUI.verifyElementPresent(findTestObject('Object Repository/Login/Tittle_Home_Page'), 10)

//3.Clik burger
WebUI.click(findTestObject('Object Repository/Login/Menu Burger'))

//4.Clik menu home
WebUI.click(findTestObject('Object Repository/Login/Menu Login'))

//5.verifikasi tiitle login page
WebUI.verifyElementPresent(findTestObject('Object Repository/Login/Tittle Login'), 10)

//6.input username
WebUI.setText(findTestObject('Object Repository/Login/Input Username'), Username)

//7.Input password
WebUI.setEncryptedText(findTestObject('Object Repository/Login/Input Password'), Password)

//8.Clik tombol login
WebUI.click(findTestObject('Object Repository/Login/Button Login'))

//9.Tittle make Appointment
WebUI.verifyElementPresent(findTestObject('Object Repository/Login/Tittle Make Appointment'), 10)

