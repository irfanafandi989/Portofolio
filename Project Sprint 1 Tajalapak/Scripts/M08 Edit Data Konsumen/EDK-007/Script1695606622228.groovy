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
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.By as By
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebDriver as WebDriver

WebUI.callTestCase(findTestCase('M08 Edit Data Konsumen/EDK-001'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('file baru/search'))

WebUI.setText(findTestObject('file baru/search'), 'udin padinding oii')

WebUI.click(findTestObject('file baru/buttom edit'))

WebUI.verifyElementPresent(findTestObject('Edit Data konsumen/tittle Edit Data Konsumen'), 0)

WebUI.setText(findTestObject('Edit Data konsumen/Input no Hp/input No Hp'), 'e')

WebUI.click(findTestObject('Edit Data konsumen/button_Update'))

//Membuat objek Web driver
WebDriver webDriver = DriverFactory.getWebDriver()

//Mengambil Objek inputan NO_HP dulu
field_noHP = webDriver.findElement(By.xpath('//input[@name="k"]'))

//Mengambil Error Messge
error_message = ((webDriver) as JavascriptExecutor).executeScript('return arguments[0].validationMessage', field_noHP)

println(error_message)

//verifikasi apakah error message sesuai
assert error_message == 'Please enter a number.'

