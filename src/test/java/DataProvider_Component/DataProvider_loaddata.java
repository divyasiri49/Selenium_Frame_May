package DataProvider_Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import Generic_Component.ExcelRW;

public class DataProvider_loaddata {
	
	@DataProvider(name="dp_InvalidLogin")
	public static Iterator<Object[]> getInvalidLoginData() throws IOException
	{
		return common_dplogic("Login","InvalidLogin");
	}
	
	@DataProvider(name="dp_ValidLogin")
	public static Iterator<Object[]> getValidLoginData() throws IOException
	{
		return common_dplogic("Login","ValidLogin");
	}
	@DataProvider(name="dp_ValidSearch")
	public static Iterator<Object[]> getValidSearchData() throws IOException
	{
		return common_dplogic("Search","ValidSearch");
	}
	@DataProvider(name="dp_InvalidSearch")
	public static Iterator<Object[]> getInvalidSearchData() throws IOException
	{
		return common_dplogic("Search","InvalidSearch");
	}
	@DataProvider(name="dp_Addcart")
	public static Iterator<Object[]> getAddCart() throws IOException
	{
		return common_dplogic("Cart","AddCart");
	}

	
	public static Iterator<Object[]> common_dplogic(String sheetName, String scriptName) throws IOException
	{
		ExcelRW excelRW = new ExcelRW("D:\\SkillBytes\\Selenium_Proj_Framework\\TestData\\TestData.xlsx");
		int rowCount = excelRW.getRowCount(sheetName);
		//System.out.println("Row Count is "+rowCount);
		
		int colCount= excelRW.getColCount(sheetName);
		//System.out.println("Column Count is "+colCount);
		
		List<Object[]> arr_list = new ArrayList<Object[]>();
		
		for(int i=1;i<=rowCount;i++)
		{
			String execute_flag = excelRW.readCell(sheetName, i, 2);
			String script_name = excelRW.readCell(sheetName, i, 3);
			
			if((execute_flag.equalsIgnoreCase("Y"))&& (script_name.equals(scriptName)))
			{
				Object[] obj_arr = new Object[1];
				Map<String,String> dMap = new HashMap<String, String>();
				
				for(int j=0;j<colCount;j++)
				{
					String sKey = excelRW.readCell(sheetName, 0, j);
					String value = excelRW.readCell(sheetName,i , j);
					
					dMap.put(sKey, value);
				}
				obj_arr[0]=dMap;
				arr_list.add(obj_arr);
			}			
			
		}
		return arr_list.iterator();
	}

}
