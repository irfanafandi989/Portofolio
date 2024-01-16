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

WebUI.openBrowser('https://the-internet.herokuapp.com/tables')

WebUI.click(findTestObject('Sorting/TH Last Name 1'))
WebUI.click(findTestObject('Sorting/TH Last Name 1'))

//Ambil semua element dari Last Name
List<WebElement> dataList = WebUI.findWebElements(findTestObject('Object Repository/Sorting/Data List Last Name 1'),10)

//Deklarasi 2 array
String[] arrLastNameOri = new String [dataList.size()]
String[] arrLastNameSort = new String [dataList.size()]

//isi array yang ori dan sort
for( int i=0; i < dataList.size(); i++) {
	text = dataList.get(i).text
	arrLastNameOri[i] = text
	arrLastNameSort[i] = text
	
}

//Sort Array
Arrays.sort(arrLastNameSort, Collections.reverseOrder())

//verifikasi array yang sudah disort
assert arrLastNameOri == arrLastNameSort


