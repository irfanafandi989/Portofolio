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
import org.openqa.selenium.Keys
import org.openqa.selenium.WebElement 

HashMap<String,Object> data = WebUI.callTestCase(findTestCase('Keranjang/TC-Cart-Show-003'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Checkout/button_Checkout'))

WebUI.verifyElementPresent(findTestObject('Checkout/span_Checkout Your Information'), 0)

WebUI.setText(findTestObject('Checkout/input firstName'), 'irfan')

WebUI.setText(findTestObject('Checkout/input lastName'), 'afandi')

WebUI.setText(findTestObject('Checkout/input postalCode'), '12345')

WebUI.click(findTestObject('Checkout/input continue checkout'))

WebUI.verifyElementPresent(findTestObject('Checkout/span_Checkout Overview'), 0)


List<WebElement> sourceProductTitleList = WebUI.findWebElements(findTestObject('Object Repository/2 Barang Checkout/Nama 2 Barang'),10)
List<WebElement> sourceProductDescList = WebUI.findWebElements(findTestObject('Object Repository/2 Barang Checkout/Dekripsi 2 Barang'),10)
List<WebElement> sourceProductPriceList = WebUI.findWebElements(findTestObject('Object Repository/2 Barang Checkout/Harga 2 Barang'),10)

sourceProductItemtotalList = WebUI.findWebElement(findTestObject('Object Repository/2 Barang Checkout/Item total 39.98'),10).text
sourceProductTaxList = WebUI.findWebElement(findTestObject('Object Repository/2 Barang Checkout/Tax 3.20'),10).text
sourceProductTotalBarangList = WebUI.findWebElement(findTestObject('Object Repository/2 Barang Checkout/Total 2 Barang 43.18'),10).text


List<String> productTitleList = new ArrayList();
List<String> productDescList = new ArrayList();
List<String> productPriceList = new ArrayList();

String[] arrsourceProductItemtotalList = sourceProductItemtotalList.split('\\$')
String[] arrsourceProductTaxList = sourceProductTaxList.split('\\$')
String[] arrsourceProductTotalBarangList = sourceProductTotalBarangList.split('\\$')

println arrsourceProductItemtotalList;



HargaBarang = 0;

for(int i = 0; i< sourceProductTitleList.size(); i++) {
	ProductTitleText = sourceProductTitleList.get(i).text
	ProductDescText = sourceProductDescList.get(i).text
	ProductPriceText = sourceProductPriceList.get(i).text

	productTitleList.add(ProductTitleText)
	productDescList.add(ProductDescText)
	productPriceList.add(ProductPriceText)
	
	
	HargaBarang = HargaBarang + Double.parseDouble(sourceProductPriceList.get(i).text.replace('$', ''))
	

}

println HargaBarang;

//verifikasi tax
tax = HargaBarang * 0.08

angkaSignifikan = 2
temp = Math.pow(10, angkaSignifikan)
tax = (double) Math.round(tax*temp)/temp

println tax;


//verifikasi total
total =  HargaBarang + tax
println total;


assert data.get('Product_name') == productTitleList
assert data.get('deskrispi_barang') == productDescList
assert data.get('price_barang') == productPriceList
assert HargaBarang == Double.parseDouble(arrsourceProductItemtotalList[1])
assert tax == Double.parseDouble(arrsourceProductTaxList[1])
assert total == Double.parseDouble(arrsourceProductTotalBarangList[1])


WebUI.click(findTestObject('Checkout/button_Finish'))

WebUI.verifyElementPresent(findTestObject('Checkout/span_Checkout Complete'), 0)

