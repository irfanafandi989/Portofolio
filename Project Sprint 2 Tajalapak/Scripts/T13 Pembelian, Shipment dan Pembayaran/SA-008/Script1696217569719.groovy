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

WebUI.click(findTestObject('Edit Detail Data Transaksi/buttom edit'))

WebUI.verifyElementPresent(findTestObject('Edit Detail Data Transaksi/Edit Detail Transaksi Penjualan'), 0)

WebUI.click(findTestObject('Edit Detail Data Transaksi/buttom edit detail'))

WebUI.setText(findTestObject('Edit Detail Data Transaksi/input_Action_dd'), jumlah)

WebUI.click(findTestObject('Edit Detail Data Transaksi/button_Action_centang'))

edit2 = WebUI.getText(findTestObject('Edit Detail Data Transaksi/edit detail 2'))

WebUI.click(findTestObject('Edit Detail Data Transaksi/buttom simpan data'))

WebUI.click(findTestObject('Edit Detail Data Transaksi/buttom Selesai'))

inv = data.get('invoice')

WebUI.setText(findTestObject('admin/Penjualan ke konsumen/Search'), inv)

assert jumlah == edit2

//data.put('statusPending', pending)
return data

