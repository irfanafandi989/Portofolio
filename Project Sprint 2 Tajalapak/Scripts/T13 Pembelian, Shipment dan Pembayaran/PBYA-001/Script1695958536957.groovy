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

HashMap<String, Object> data = WebUI.callTestCase(findTestCase('T13 Pembelian, Shipment dan Pembayaran/PBY-004'), 
    [:], FailureHandling.STOP_ON_FAILURE)

WebUI.navigateToUrl('https://10.9.2.63/ecommerce/administrator/')

WebUI.verifyElementPresent(findTestObject('admin/Tittle ADMIN Login'), 0)

WebUI.setText(findTestObject('admin/Username'), 'admin')

WebUI.setText(findTestObject('admin/Password'), '123admin123')

WebUI.click(findTestObject('admin/Remember Me'))

WebUI.delay(10)

WebUI.click(findTestObject('admin/buttom submit'))

WebUI.verifyElementPresent(findTestObject('admin/Konf order konsumen/Tittle Dashboard'), 0)

WebUI.click(findTestObject('admin/Konf order konsumen/Menu Transaksi Market'))

WebUI.click(findTestObject('admin/Konf order konsumen/Menu Konf. Order Konsumen'))

WebUI.verifyElementPresent(findTestObject('admin/Konf order konsumen/Tittle Data Konfirmasi Pembayaran Konsumen'), 0)

inv = data.get('invoice')

WebUI.setText(findTestObject('admin/Konf order konsumen/Search'), inv)

WebUI.verifyElementText(findTestObject('admin/Konf order konsumen/Keterangan Lunas'), 'Lunas')

return data

