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
import org.supercsv.cellprocessor.ParseDouble

WebUI.callTestCase(findTestCase('Products/TC-Product-Show-001'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.selectOptionByValue(findTestObject('Products/select_Name (A to Z)Name (Z to A)Price (low to high)Price (high to low)'), 
    'lohi', false)

List<WebElement> dataList = WebUI.findWebElements(findTestObject('Object Repository/Products/Sorting/Sorting harga'),10)

Double[] arrHargaOri = new Double [dataList.size()]

Double[] arrHargaSort  = new Double [dataList.size()]

for (int i = 0; i < dataList.size(); i++) {
	text = dataList.get(i).text.replace('$','')

	Double hasil = Double.valueOf(text)
	
	arrHargaOri [i] = hasil
	arrHargaSort [i] = hasil

}
println arrHargaOri
println arrHargaSort


Arrays.sort(arrHargaSort)

assert arrHargaOri == arrHargaSort