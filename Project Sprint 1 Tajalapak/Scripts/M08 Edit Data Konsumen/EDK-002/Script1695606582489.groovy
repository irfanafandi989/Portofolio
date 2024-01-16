import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import java.text.SimpleDateFormat as SimpleDateFormat
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
import sun.security.provider.JavaKeyStore.JKS as JKS
import org.openqa.selenium.Keys as Keys

WebUI.callTestCase(findTestCase('M08 Edit Data Konsumen/EDK-001'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('file baru/search'))

WebUI.setText(findTestObject('file baru/search'), 'udin pan')

WebUI.click(findTestObject('file baru/buttom edit'))

WebUI.verifyElementPresent(findTestObject('Edit Data konsumen/tittle Edit Data Konsumen'), 0)

WebUI.setText(findTestObject('Edit Data konsumen/ganti password/input_Ganti Password'), password)

WebUI.setText(findTestObject('Edit Data konsumen/input_Nama Lengkap'), nama_lengkap)

WebUI.setText(findTestObject('Edit Data konsumen/Input Alamat email/input Alamat Email'), email)

WebUI.setText(findTestObject('Edit Data konsumen/Input no Hp/input No Hp'), no_hp)

WebUI.uploadFile(findTestObject('upload foto/input_Ganti Foto_gg'), foto)

if (jk.toString().equalsIgnoreCase('Laki-laki')) {
    WebUI.check(findTestObject('Object Repository/Edit Data konsumen/Radio buttom jenis_kelamin/Laki_laki/Radio buttom Laki_laki'))
} else if (jk.toString().equalsIgnoreCase('Perempuan')) {
    WebUI.check(findTestObject('Object Repository/Edit Data konsumen/Radio buttom jenis_kelamin/perempuan/Radio buttom Perempuan'))
}

WebUI.setText(findTestObject('Edit Data konsumen/input tanggal lahir/input_Tanggal Lahir'), tanggal_lahir)

WebUI.setText(findTestObject('Edit Data konsumen/Alamat/input_Alamat'), Alamat)

WebUI.click(findTestObject('Edit Data konsumen/button_Update'))

WebUI.verifyElementPresent(findTestObject('Edit Data konsumen/Ttitle Detail Data Konsumen'), 0)

nama = WebUI.getText(findTestObject('hasil edit konsumen/hasil edit nama'))

emaill = WebUI.getText(findTestObject('hasil edit konsumen/hasil edit email'))

nomorHp = WebUI.getText(findTestObject('hasil edit konsumen/hasil edit no_hp'))

jenis_kelamin = WebUI.getText(findTestObject('Edit Data konsumen/Jenis_Kelamin/Hasil edit Jenis_kelamin'))

tgl_lahir_show = WebUI.getText(findTestObject('hasil edit konsumen/hasil edit tgl_lahir'))

alamat = WebUI.getText(findTestObject('hasil edit konsumen/hasil edit alamat'))

foto1 = WebUI.getAttribute(findTestObject('Object Repository/Edit Data konsumen/Edit foto/hasil edit foto'), 'src').split(
    '/')

println(foto1)

fotoUrl = (foto1[(foto1.size() - 1)]).replace('.png', '')

println(fotoUrl)

foto_sebelumEdit = foto.split('\\\\')

println(foto_sebelumEdit)

urlfoto = (foto_sebelumEdit[(foto_sebelumEdit.size() - 1)]).replace('.png', '')

println(urlfoto)

assert fotoUrl.contains(urlfoto)

SimpleDateFormat sdf = new SimpleDateFormat('yyyy-MM-dd')

Date parsedDate = null

String SentDate = tanggal_lahir

parsedDate = sdf.parse(SentDate)

SimpleDateFormat print = new SimpleDateFormat('dd MMM yyyy')

String tanggal_lahir = print.format(parsedDate)

assert nama_lengkap.toString().trim().equalsIgnoreCase(nama.trim())

assert email.toString().trim().equalsIgnoreCase(emaill.trim())

assert no_hp.toString().trim().equalsIgnoreCase(nomorHp.trim())

assert jk.toString().trim().equalsIgnoreCase(jenis_kelamin.trim())

assert tanggal_lahir.trim().equalsIgnoreCase(tgl_lahir_show.trim())

assert Alamat.toString().trim().equalsIgnoreCase(alamat.trim())

