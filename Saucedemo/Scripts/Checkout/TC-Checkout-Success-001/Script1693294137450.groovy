import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.text.DecimalFormat

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

HashMap<String, Object> data = WebUI.callTestCase(findTestCase('Keranjang/TC-Cart-Show-002'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Checkout/button_Checkout'))

WebUI.verifyElementPresent(findTestObject('Checkout/span_Checkout Your Information'), 0)

WebUI.setText(findTestObject('Checkout/input firstName'), 'irfan')

WebUI.setText(findTestObject('Checkout/input lastName'), 'afandi')

WebUI.setText(findTestObject('Checkout/input postalCode'), '12345')

WebUI.click(findTestObject('Checkout/input continue checkout'))

WebUI.verifyElementPresent(findTestObject('Checkout/span_Checkout Overview'), 0)

namaBarangCheckout = WebUI.getText(findTestObject('1 Barang Checkout/Nama barang'))

deskBarangCheckout = WebUI.getText(findTestObject('1 Barang Checkout/Deskripsi barang'))

hargaBarangCheckout = WebUI.getText(findTestObject('1 Barang Checkout/Harga 29.99'))

totalBarang = WebUI.getText(findTestObject('1 Barang Checkout/Item total 29.99'))

taxCheckout  = WebUI.getText(findTestObject('1 Barang Checkout/Tax 2.40'))

TotalItemCheckout = WebUI.getText(findTestObject('1 Barang Checkout/Total 32.39'))

println namaBarangCheckout;

assert data.get('nama_barang') == namaBarangCheckout
assert data.get('deskrispi_barang') == deskBarangCheckout
assert data.get('price_barang') == hargaBarangCheckout


hargaBarangCheckout = Double.parseDouble(hargaBarangCheckout.replace('$', ''))

//verifikasi tax
tax = hargaBarangCheckout * 0.08

angkaSignifikan = 2
temp = Math.pow(10, angkaSignifikan)
tax = (double) Math.round(tax*temp)/temp

String[] tempTaxCheckout = taxCheckout.split('\\$')
assert tax == Double.parseDouble(tempTaxCheckout[1])

// verifikasi harga
String[] tempTotalBarang = totalBarang.split('\\$')
assert hargaBarangCheckout == Double.parseDouble(tempTotalBarang[1])

//verifikasi total
total =  hargaBarangCheckout + tax

println total;

String[] tempTotal = TotalItemCheckout.split('\\$')
assert total == Double.parseDouble(tempTotal[1])

WebUI.click(findTestObject('Checkout/button_Finish'))

WebUI.verifyElementPresent(findTestObject('Checkout/span_Checkout Complete'), 0)

