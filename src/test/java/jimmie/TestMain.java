package jimmie;

import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestMain {

	public static void main(String[] args) {
		String prizeName = "E:\\\\prize.xlsx";
		
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



//输出Excel文件
      try  
        {  
//            FileOutputStream fout = new FileOutputStream("E:/获奖名单xls");  
            FileOutputStream fout = new FileOutputStream(prizeName);  
            wb.write(fout);  
            fout.close();  
        }  
        catch (Exception e)  
        {  
            e.printStackTrace();  
        }
	}

}
