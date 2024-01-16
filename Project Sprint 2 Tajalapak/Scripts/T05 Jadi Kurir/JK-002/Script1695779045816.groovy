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

WebUI.callTestCase(findTestCase('T05 Jadi Kurir/JK-001'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Jadi kurir/a_Daftar  Edit Data'))

WebUI.verifyElementPresent(findTestObject('Jadi kurir/li_Profile Kurir'), 0)

WebUI.selectOptionByLabel(findTestObject('Jadi kurir/select_- Pilih Kendaraan -Roda 2Roda 4'), Jenis, false)

WebUI.setText(findTestObject('Jadi kurir/input_Merek Kendaraan'), Merek_Kendaraan)

WebUI.setText(findTestObject('Jadi kurir/input_Plat Nomor'), Plat_Nomor)

WebUI.setText(findTestObject('Jadi kurir/textarea_Keterangan'), Keterangan)

WebUI.waitForPageLoad(3)

WebUI.delay(2)

WebUI.uploadFile(findTestObject('Jadi kurir/input_Choose files_uploadFile'), Berkas)

WebUI.delay(3)

WebUI.click(findTestObject('Jadi kurir/button_Simpan Perubahan'))

WebUI.verifyElementPresent(findTestObject('Jadi kurir/li_Profile Kurir'), 0)

Hasil_Jenis = WebUI.getText(findTestObject('Hasil Edit/div_Roda 4'))

Hasil_Merek = WebUI.getText(findTestObject('Hasil Edit/div_toyota supra'))

Hasil_Plat = WebUI.getText(findTestObject('Hasil Edit/div_AB 1 S'))

Hasil_Ket = WebUI.getText(findTestObject('Hasil Edit/div_mau daftar dong bang'))

berkas1 = WebUI.getAttribute(findTestObject('Object Repository/Hasil Edit/Hasil edit berkas'), 'href').split('/')

println(berkas1)

berkasUrl = (berkas1[(berkas1.size() - 1)]).replace('.pdf', '')

println(berkasUrl)

berkas_sebelumEdit = Berkas.split('\\\\')

println(berkas_sebelumEdit)

urlBerkas = (berkas_sebelumEdit[(berkas_sebelumEdit.size() - 1)]).replace('.pdf', '')

println(urlBerkas)

assert berkasUrl.contains(urlBerkas)

assert Hasil_Jenis.trim().equalsIgnoreCase(Jenis.trim())

assert Hasil_Merek.trim().equalsIgnoreCase(Merek_Kendaraan.trim())

assert Hasil_Plat.trim().equalsIgnoreCase(Plat_Nomor.trim())

assert Hasil_Ket.trim().equalsIgnoreCase(Keterangan.trim())

