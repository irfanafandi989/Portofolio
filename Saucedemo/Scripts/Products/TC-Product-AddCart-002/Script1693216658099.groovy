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

HashMap<String, Object> data = WebUI.callTestCase(findTestCase('Products/TC-Product-AddCart-001'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Products/button_Add to cart 2'))

WebUI.verifyElementPresent(findTestObject('Products/button_Remove'), 0)

WebUI.verifyElementPresent(findTestObject('Keranjang/Notifikasi add cart 2'), 2)

name = WebUI.findWebElement(findTestObject('Object Repository/Name Products/Nama barang2')).text

desc = WebUI.findWebElement(findTestObject('Object Repository/Name Products/Deskripsi 2')).text

price = WebUI.findWebElement(findTestObject('Object Repository/Name Products/harga barang 2')).text

//Deklarasi List/Array kosong dengan dengan nama variabel nameproductsList
List<WebElement> nameProductList = new ArrayList()
nameProductList.add(data.get('nama_barang'))
nameProductList.add(name)

//ambil indeks ke 0
println(nameProductList.get(0))

List<WebElement> descProductList = new ArrayList()
descProductList.add(data.get('deskrispi_barang'))
descProductList.add(desc)

List<WebElement> priceProductList = new ArrayList()
priceProductList.add(data.get('price_barang'))
priceProductList.add(price)

data.put('Product_name', nameProductList)
data.put('deskrispi_barang', descProductList)
data.put('price_barang', priceProductList)

return data

