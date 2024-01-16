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

WebUI.openBrowser('https://10.9.2.63/ecommerce/')

WebUI.maximizeWindow()

WebUI.mouseOver(findTestObject('beli barang/i_Mulai Belanja_icon-menu'))

WebUI.click(findTestObject('beli barang/a_Fashion  Busana Wanita'))

NamaSebelum = WebUI.getText(findTestObject('verifikasi/Nama sebelum'))

HargaSebelum = WebUI.getText(findTestObject('verifikasi/Harga sebelum'))

WebUI.mouseOver(findTestObject('beli barang/barang mouse over'))

WebUI.click(findTestObject('beli barang/buttom add to cart'))

NamaSesudah = WebUI.getText(findTestObject('verifikasi/Nama sesudah'))

HargaSesudah = WebUI.getText(findTestObject('verifikasi/Harga sesudah'))

assert NamaSesudah.contains(NamaSebelum)

assert HargaSesudah.contains(HargaSebelum)

WebUI.click(findTestObject('Beli tanpa akun/button_Beli Sekarang'))

HashMap<String, Object> data = new HashMap<String, Object>()

data.put('nama_barang', NamaSesudah)

data.put('price_barang', HargaSesudah)

WebUI.verifyElementPresent(findTestObject('keranjang/li_Keranjang Belanja'), 0)

NamaKeranjang = WebUI.getText(findTestObject('verifikasi/Nama keranjang'))

HargaKeranjang = WebUI.getText(findTestObject('verifikasi/Harga Keranjang'))

if (warna.toString().equalsIgnoreCase('Merah')) {
    WebUI.check(findTestObject('Object Repository/keranjang/input_Warna_variasi101'))
} else if (warna.toString().equalsIgnoreCase('Biru')) {
    WebUI.check(findTestObject('Object Repository/keranjang/input_Warna_variasi101'))
} else {
    warna.toString().equalsIgnoreCase('Kuning').call({ 
            WebUI.check(findTestObject('Object Repository/keranjang/input_Warna_variasi101'))
        })
}

if (ukuran.toString().equalsIgnoreCase('Menengah')) {
    WebUI.check(findTestObject('Object Repository/keranjang/input_Ukuran_variasi201'))
} else if (ukuran.toString().equalsIgnoreCase('Dalam')) {
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

