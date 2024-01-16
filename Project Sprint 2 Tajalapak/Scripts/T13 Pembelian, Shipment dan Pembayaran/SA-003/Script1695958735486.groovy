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

HashMap<String, Object> data = WebUI.callTestCase(findTestCase('T13 Pembelian, Shipment dan Pembayaran/SA-002'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('admin/Penjualan ke konsumen/buttom scroldown'))

WebUI.click(findTestObject('admin/Penjualan ke konsumen/Proses'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForAlert(5, FailureHandling.OPTIONAL)

WebUI.acceptAlert()

inv = data.get('invoice')

WebUI.setText(findTestObject('admin/Penjualan ke konsumen/Search'), inv)

WebUI.verifyElementText(findTestObject('PROSES PENJUALAN/Proses'), 'Proses')

prosesadmin = WebUI.getText(findTestObject('PROSES PENJUALAN/Proses'))

data.put('statusAdmin', prosesadmin)

return data

