package com.jimmie.vote.Controller;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jimmie.vote.util.ExcelUtil;


@RestController  
public class UserController {  
    
	public static Map<Integer,List<String>> prizeMap = new HashMap<Integer,List<String>>();
	
/*	static{
		List<String> list1 = new ArrayList<String>();
		list1.add("李四");
		list1.add("jond");
		prizeMap.put(1, list1);
		
		List<String> list2 = new ArrayList<String>();
		list2.add("Wagnsu");
		list2.add("忘五");
		prizeMap.put(2, list2);
	}
	*/
    @SuppressWarnings("unchecked")
	@RequestMapping("/getAll")  
    public List<String> getAll() {  
    	List<String> pList = new ArrayList<String>();
    	pList = (List<String>) ExcelUtil.getList();
    	return pList;
    }  
  
    @RequestMapping("/record")  
    public int record(String name,int count) {
    	List<String> list = prizeMap.get(count);
    	if(list==null){
    		list = new ArrayList<String>();
    	}
    	list.add(name);
    	prizeMap.put(count, list);
    	return 1;
    }  
    
	@RequestMapping("/excel")  
    public int excel() {  
		
				int count = prizeMap.size();
				if(count==0){
					return 0;
				}
				int rows = 2;
				String prizeName = System.getProperty("prize");
				Workbook wb = null;
				//创建HSSFWorkbook对象(excel的文档对象)
				// 根据文件格式(2003或者2007)来初始化,			  
				if (prizeName.endsWith("xlsx"))
					wb = new XSSFWorkbook();
				else
					wb = new HSSFWorkbook();

		      //建立新的sheet对象（excel的表单）
		      Sheet sheet=wb.createSheet("获奖名单");
			//在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个
			Row row1=sheet.createRow(0);
			//创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个
			Cell cell=row1.createCell(0);
			      //设置单元格内容
			cell.setCellValue("获奖名单");
			//合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列
			sheet.addMergedRegion(new CellRangeAddress(0,0,0,3));
			//在sheet里创建第二行
			
			
			for(int i=1;i<=count;i++){
				Row rowtemp=sheet.createRow(rows);
				Cell celltemp=rowtemp.createCell(0);
				celltemp.setCellValue("第"+i+"轮抽奖的中奖名单");
				//合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列
				sheet.addMergedRegion(new CellRangeAddress(rows,rows,0,2));
				List<String> listTemp =  prizeMap.get(i);
				rows = rows+1;
				for(String nameT:listTemp){
					Row rowName=sheet.createRow(rows);    
					rowName.createCell(0).setCellValue(nameT);
					rows=rows+1;
				}
				rows = rows+1;//空出一行
			}
			
			//输出Excel文件
			      try  
			        {  
//			            FileOutputStream fout = new FileOutputStream("E:/获奖名单xls");  
			            FileOutputStream fout = new FileOutputStream(System.getProperty("prize"));  
			            wb.write(fout);  
			            fout.close();  
			        }  
			        catch (Exception e)  
			        { 
			        	System.out.println("chucuole出错了草");
			        	System.out.println(e.getMessage());
			        	System.out.println(e.getLocalizedMessage());
			            e.printStackTrace();  
			            return 0;
			        }  
		    	return 1;
    }  
    
}  