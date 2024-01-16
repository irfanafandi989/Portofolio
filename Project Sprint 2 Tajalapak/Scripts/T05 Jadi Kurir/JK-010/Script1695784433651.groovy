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

WebUI.callTestCase(findTestCase('T05 Jadi Kurir/JK-001'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Jadi kurir/a_Daftar  Edit Data'))

WebUI.verifyElementPresent(findTestObject('Jadi kurir/li_Profile Kurir'), 0)

WebUI.selectOptionByValue(findTestObject('Jadi kurir/select_- Pilih Kendaraan -Roda 2Roda 4'), Jenis, false)

WebUI.setText(findTestObject('Jadi kurir/input_Merek Kendaraan'), Merek_Kendaraan)

WebUI.setText(findTestObject('Jadi kurir/input_Plat Nomor'), Plat_Nomor)

WebUI.setText(findTestObject('Jadi kurir/textarea_Keterangan'), Keterangan)

WebUI.uploadFile(findTestObject('Object Repository/Jadi kurir/input_Choose files_uploadFile'), Berkas)

WebUI.click(findTestObject('Jadi kurir/button_Simpan Perubahan'))

WebUI.verifyTextPresent('"plat nomor tidak terdaftar diseluruh wilayah SAMSAT indonesia', false)

