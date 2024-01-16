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

HashMap<String, Object> data = WebUI.callTestCase(findTestCase('T13 Pembelian, Shipment dan Pembayaran/PBL-001'), 
    [:], FailureHandling.STOP_ON_FAILURE)

WebUI.mouseOver(findTestObject('beli barang/keranjang'))

WebUI.click(findTestObject('beli barang/Lihat Sekarang'))

WebUI.verifyElementPresent(findTestObject('keranjang/li_Keranjang Belanja'), 0)

NamaKeranjang = WebUI.getText(findTestObject('verifikasi/Nama keranjang'))

HargaKeranjang = WebUI.getText(findTestObject('verifikasi/Harga Keranjang'))

if(warna.toString().equalsIgnoreCase('Merah')) {
	WebUI.check(findTestObject('Object Repository/keranjang/input_Warna_variasi101'))
}else if(warna.toString().equalsIgnoreCase('Biru')) {
	WebUI.check(findTestObject('Object Repository/keranjang/input_Warna_variasi101'))
}else(warna.toString().equalsIgnoreCase('Kuning')) {
	WebUI.check(findTestObject('Object Repository/keranjang/input_Warna_variasi101'))
}
	
if (ukuran.toString().equalsIgnoreCase('Menengah')) {
	WebUI.check(findTestObject('Object Repository/keranjang/input_Ukuran_variasi201'))
}else if  (ukuran.toString().equalsIgnoreCase('Dalam')) {
	WebUI.check(findTestObject('Object Repository/keranjang/input_Ukuran_variasi201'))
}


data.put('Warna', warna)
data.put('Ukuran', ukuran)


WebUI.click(findTestObject('keranjang/button_Lanjut ke Pembayaran'))

WebUI.verifyElementPresent(findTestObject('checkout/Tittle Checkout Order'), 0)

name_product = data.get('nama_barang')

price_product = data.get('price_barang')


assert name_product == NamaKeranjang
assert price_product == HargaKeranjang

return data

