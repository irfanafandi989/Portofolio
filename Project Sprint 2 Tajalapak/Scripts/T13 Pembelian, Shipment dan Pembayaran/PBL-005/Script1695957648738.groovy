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

HashMap<String, Object> data = WebUI.callTestCase(findTestCase('T13 Pembelian, Shipment dan Pembayaran/PBL-002'), 
    [:], FailureHandling.STOP_ON_FAILURE)

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

WebUI.selectOptionByLabel(findTestObject('checkout/select - Kirim via Kurir Lokal'), Kurir, false)

WebUI.click(findTestObject('checkout/Kendaraan Kurir'))

OngkosKirim = WebUI.getText(findTestObject('Object Repository/verifikasi/Ongkos Kirim checkout'))

Ongkos = OngkosKirim.substring(3, OngkosKirim.size())

rep = Ongkos.replace(',', '.')

Double Ongkos_kirim = Double.parseDouble(rep)

println(Ongkos_kirim)

FeeAdmin = WebUI.getText(findTestObject('verifikasi/Fee Admin checkout'))

Fee_Admin = FeeAdmin.substring(12, FeeAdmin.size())

fee = Fee_Admin.replace(',', '.')

Double fee_admin = Double.parseDouble(fee)

println(fee_admin)

Subtotal = WebUI.getText(findTestObject('verifikasi/subtotal checkout'))

sub_total = Subtotal.substring(12, Subtotal.size())

sub = sub_total.replace(',', '.')

Double sub_total = Double.parseDouble(sub)

println(sub_total)

Total = WebUI.getText(findTestObject('verifikasi/Total checkout'))

totall = Total.substring(3, Total.size())

total = totall.replace(',', '.')

Double totall = Double.parseDouble(total)

println(totall)

// verifikasi perhitungan
Total_Harga = ((Ongkos_kirim + fee_admin) + sub_total)

println(Total_Harga)

//cara buletin
TotalHarga = (Math.round(Total_Harga * 1000) / 1000)

println(TotalHarga)

//verifikasi total
assert totall == TotalHarga


WebUI.click(findTestObject('Object Repository/checkout/metode pembayaran'))

WebUI.click(findTestObject('checkout/button_Proses Pembayaran'))

WebUI.verifyElementPresent(findTestObject('pembayaran/Tittle nomor invoice'), 0)

return data

