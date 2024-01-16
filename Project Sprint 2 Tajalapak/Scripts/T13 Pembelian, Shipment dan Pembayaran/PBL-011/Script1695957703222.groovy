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

HashMap<String, Object> data = WebUI.callTestCase(findTestCase('T13 Pembelian, Shipment dan Pembayaran/PBL-010'), 
    [('warna') : 'Merah', ('ukuran') : 'Menengah'], FailureHandling.STOP_ON_FAILURE)

warnaa = WebUI.getText(findTestObject('verifikasi/warna Merah'))

ukurann = WebUI.getText(findTestObject('verifikasi/Ukuran Menengah'))

warna1 = data.get('Warna')

ukuran1 = data.get('Ukuran')

assert warnaa == warna1

assert ukurann == ukuran1

NamaCheckout = WebUI.getText(findTestObject('verifikasi/NamaCheckout'))

HargaCheckout = WebUI.getText(findTestObject('verifikasi/HargaCheckout'))

name_product = data.get('nama_barang')

price_product = data.get('price_barang')

assert name_product.contains(NamaCheckout)

assert price_product.contains(HargaCheckout)

WebUI.setText(findTestObject('Beli tanpa akun/input_Nama anda_nama'), 'irfan')

WebUI.setText(findTestObject('Beli tanpa akun/input_Kontak_telpon'), '0811212121')

WebUI.setText(findTestObject('Beli tanpa akun/input_Kontak_email'), 'fan@gmail.com')

WebUI.selectOptionByLabel(findTestObject('Beli tanpa akun/select_Provinsi'), 'Sumatera Barat', false)

WebUI.selectOptionByLabel(findTestObject('Beli tanpa akun/select_Kota  Kabupaten'), 'Kota Bukittinggi', false)

WebUI.selectOptionByLabel(findTestObject('Beli tanpa akun/select_Kecamatan'), 'Guguk Panjang (Guguak Panjang)', false)

WebUI.setText(findTestObject('Beli tanpa akun/input_Alamat Kirim_alamat'), 'guguk')

WebUI.click(findTestObject('checkout/COD'))

WebUI.click(findTestObject('verifikasi/COD - Panjang BanaTarif'))

WebUI.click(findTestObject('checkout/button_Proses Pembayaran'))

WebUI.verifyTextPresent('mohon login akun terlebih dahulu', false)

return data

