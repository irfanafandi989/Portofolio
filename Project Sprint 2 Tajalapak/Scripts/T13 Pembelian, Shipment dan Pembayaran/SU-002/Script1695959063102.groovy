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

HashMap<String, Object> data = WebUI.callTestCase(findTestCase('T13 Pembelian, Shipment dan Pembayaran/SA-003'), 
    [:], FailureHandling.STOP_ON_FAILURE)

WebUI.openBrowser('https://10.9.2.63/ecommerce/')

WebUI.maximizeWindow()

WebUI.verifyElementPresent(findTestObject('Login/Home'), 0)

WebUI.click(findTestObject('Login/a_Login'))

WebUI.verifyElementPresent(findTestObject('Login/Tittle Login'), 0)

WebUI.setText(findTestObject('Login/input_Username, Email atau No. Handphone_a'), 'irfanafandi')

WebUI.setText(findTestObject('Login/input_Password_b'), '12345irfan')

WebUI.click(findTestObject('Login/button_Masuk'))

WebUI.verifyElementPresent(findTestObject('Login/li_Profile'), 0)

WebUI.click(findTestObject('Konfirmasi pesanan shop/Menu Shop'))

WebUI.click(findTestObject('Konfirmasi pesanan shop/Menu Shop'))

WebUI.click(findTestObject('Traking Order/a_Tracking Orders'))

WebUI.verifyElementPresent(findTestObject('Traking Order/Tittle Tracking Order'), 0)

inv = data.get('invoice')

WebUI.setText(findTestObject('Traking Order/input_No Pesanan_a'), inv)

WebUI.setText(findTestObject('Traking Order/input_Alamat E-mail_form-control'), 'irfan@gmail.com')

WebUI.click(findTestObject('Traking Order/button_Lacak Pesanan'))

WebUI.verifyElementPresent(findTestObject('Traking Order/Tittle nomor transaksi'), 0)

Nama = WebUI.getText(findTestObject('Object Repository/Traking Order/status traking/Nama Barang tracking order'))

Harga = WebUI.getText(findTestObject('Object Repository/Traking Order/status traking/Harga Barang'))

name_product = data.get('nama_barang')

price_product = data.get('price_barang')

assert name_product.contains(Nama)

assert price_product.contains(Harga)

warnaa = WebUI.getText(findTestObject('Object Repository/Traking Order/status traking/warna'))

ukurann = WebUI.getText(findTestObject('Object Repository/Traking Order/status traking/Ukuruan'))

// verifikasi warna dan ukuran
warna1 = data.get('Warna')

ukuran1 = data.get('Ukuran')

assert warnaa == warna1

assert ukurann == ukuran1


proses = WebUI.getText(findTestObject('Object Repository/Traking Order/status traking/status Traking Proses'))

//verifikasi status

statusProses = data.get('statusAdmin')

assert proses == statusProses

return data

