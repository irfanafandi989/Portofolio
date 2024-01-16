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

WebUI.callTestCase(findTestCase('T05 Pencarian Toko/PT-002'), [:], FailureHandling.STOP_ON_FAILURE)

verified1 = WebUI.findWebElement(findTestObject('Object Repository/Nama toko detail 1 Tajalapak/Verified1')).text

nama_toko1 = WebUI.findWebElement(findTestObject('Object Repository/Nama toko detail 1 Tajalapak/h4_Verified  Kerupuk husna')).text

nama_toko = nama_toko1.substring(9, nama_toko1.size())

no_hp1 = WebUI.findWebElement(findTestObject('Object Repository/Nama toko detail 1 Tajalapak/nomor hp')).text

WebUI.click(findTestObject('Fitur search/button Kunjungi Toko'))

WebUI.verifyElementPresent(findTestObject('Fitur search/tittle Kerupuk husna'), 0)

verified2 = WebUI.getText(findTestObject('Object Repository/Nama toko detail 2 Tajalapak/Verified2'))

nama_toko2 = WebUI.getText(findTestObject('Object Repository/Nama toko detail 2 Tajalapak/NAMA TOKO 2'))

no_hp2 = WebUI.getText(findTestObject('Nama toko detail 2 Tajalapak/nomor hp detail 2'))


assert verified1.toString().trim().equalsIgnoreCase(verified2.trim())
assert nama_toko.toString().trim().equalsIgnoreCase(nama_toko2.trim())
assert no_hp1.toString().trim().equalsIgnoreCase(no_hp2.trim())


