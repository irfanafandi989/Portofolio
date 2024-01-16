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

HashMap<String, Object> data = WebUI.callTestCase(findTestCase('T13 Pembelian, Shipment dan Pembayaran/PBL-005'), [('Kurir') : 'Roda 2', ('tf') : 'transfer'], 
    FailureHandling.STOP_ON_FAILURE)

Invoice = WebUI.getText(findTestObject('pembayaran/nomor invoice'))

NamaPemesan = WebUI.getText(findTestObject('Konfirmasi pesanan shop/Nama pemesan'))

data.put('invoice', Invoice)

Nama = WebUI.getText(findTestObject('pembayaran/Nama barang'))

Harga = WebUI.getText(findTestObject('pembayaran/Harga barang'))

name_product = data.get('nama_barang')

price_product = data.get('price_barang')

assert name_product.contains(Nama)

assert price_product.contains(Harga)

warnaa = WebUI.getText(findTestObject('pembayaran/warna'))

ukurann = WebUI.getText(findTestObject('pembayaran/ukuran'))

// verifikasi warna dan ukuran
warna1 = data.get('Warna')

ukuran1 = data.get('Ukuran')

assert warnaa == warna1

assert ukurann == ukuran1

OngkosKirim = WebUI.getText(findTestObject('pembayaran/ongkos kirim'))

Ongkos = OngkosKirim.substring(3, OngkosKirim.size())

rep = Ongkos.replace(',', '')

Integer Ongkos_kirimm = Integer.parseInt(rep)

println(Ongkos_kirimm)

FeeAdmin = WebUI.getText(findTestObject('pembayaran/fee admin'))

Fee_Admin = FeeAdmin.substring(3, FeeAdmin.size())

fee = Fee_Admin.replace(',', '')

Integer fee_adminn = Integer.parseInt(fee)

println(fee_adminn)

Subtotal = WebUI.getText(findTestObject('pembayaran/subtotal'))

sub_total = Subtotal.substring(3, Subtotal.size())

sub = sub_total.replace(',', '')

Integer sub_totall = Integer.parseInt(sub)

println(sub_totall)

unik = WebUI.getText(findTestObject('pembayaran/kode unik'))

unikk = unik.replace('+', '')

Integer kode_unik = Integer.parseInt(unikk)

println(kode_unik)

Total = WebUI.getText(findTestObject('pembayaran/total'))

total = Total.replace(',', '')

Integer totalll = Integer.parseInt(total)

println(totalll)

// verifikasi perhitungan
Total_Hargaa = (((Ongkos_kirimm + fee_adminn) + sub_totall) + kode_unik)

println(Total_Hargaa)

//verifikasi total
assert totalll == Total_Hargaa

//verifikasi konfirmasi
data.put('total', Total)

data.put('nama', NamaPemesan)

return data

