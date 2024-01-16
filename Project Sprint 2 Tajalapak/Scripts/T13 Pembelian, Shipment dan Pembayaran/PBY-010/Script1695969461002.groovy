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

HashMap<String, Object> data = WebUI.callTestCase(findTestCase('T13 Pembelian, Shipment dan Pembayaran/PBY-001'), [:], FailureHandling.STOP_ON_FAILURE)

inv = data.get('invoice')

Total = data.get('total')

NamaPemesan = data.get('nama')

WebUI.click(findTestObject('Konfirmasi pesanan shop/Menu Shop'))

WebUI.click(findTestObject('Konfirmasi pesanan shop/Menu Shop'))

WebUI.click(findTestObject('Konfirmasi pesanan shop/Konfirmasi Orders'))

WebUI.verifyElementPresent(findTestObject('Konfirmasi pesanan shop/Tittle Konfirmasi Pesanan'), 0)

WebUI.setText(findTestObject('Konfirmasi pesanan shop/input_No Pesanan'), inv)

WebUI.setText(findTestObject('Konfirmasi pesanan shop/input_Alamat E-mai'), 'irfan@gmail.com')

WebUI.click(findTestObject('Konfirmasi pesanan shop/button_Submit'))

WebUI.verifyElementPresent(findTestObject('Konfirmasi pesanan shop/Tittle nomor invoice'), 0)

WebUI.setText(findTestObject('Konfirmasi pesanan shop/input_Total TagihanTransfer_b'), Total)

WebUI.selectOptionByValue(findTestObject('Konfirmasi pesanan shop/select_Bank'), '4', false)

WebUI.setText(findTestObject('Konfirmasi pesanan shop/input_Nama Pengirim_d'), NamaPemesan)

WebUI.uploadFile(findTestObject('keranjang/konfirmasi/input_Upload Bukti Transfer_f'), 'C:\\Users\\IRFAN\\Videos\\katalon\\video.mp4')

WebUI.click(findTestObject('Konfirmasi pesanan shop/button_Konfirmasi Pembayaran'))

WebUI.verifyTextPresent('Please upload an valid file.', false)

return data

