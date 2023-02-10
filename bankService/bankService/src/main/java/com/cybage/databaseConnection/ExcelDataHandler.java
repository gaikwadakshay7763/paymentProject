package com.cybage.databaseConnection;
	import com.cybage.service.AccountServiceImpl;
	import org.apache.commons.collections4.map.HashedMap;
	import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Component;

import com.cybage.model.Account;
import com.cybage.model.CardDetails;
import com.cybage.model.OtpAuth;

import java.io.File;
	import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
	import java.io.IOException;
	import java.util.*;

@Component
	public class ExcelDataHandler {
	private String filePath;
	private static Integer rowNumber;
	private static String accountDBFile;

	// private static Map<account.getAccountNumber(),account> account = new HashedMap<>();
	//private List<Account> objects = new ArrayList<>();


	public ExcelDataHandler() throws FileNotFoundException, IOException {
//	        this.filePath = "accountData.xlsm";
		this.accountDBFile = "book1.xlsx";
		onInit();
	}

	private static void onInit() {

		try {
			File newFile = new File(accountDBFile);


			if (newFile.createNewFile()) {
				System.out.println("New file is ready to write Data ");

			} else {
				System.out.println("File is already present");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
//	    try {
//	    	 //XSSFWorkbook workbook;
//			FileInputStream fileInputStream = new FileInputStream(accountDBFile);
//			
//			String[] headers = new String[] { "Header1", "Header2", "Header3" };
//
//			Workbook workbook = new HSSFWorkbook(fileInputStream);
//			Sheet sheet = workbook.createSheet("EDR Raw Data");
//
//			for (int rn=0; rn<headers.length; rn++) {
//			   Row r = sheet.createRow(rn);
//			   r.createCell(0).setCellValue(headers[rn]);
//			}
//			}
//	    catch (Exception e) {
//				// TODO: handle exception
//			}


	}

//	    private static void onInit() throws FileNotFoundException, IOException {
//	    	
//	    	 XSSFWorkbook workbook;
//	    	 
//	    	 try {
//		  			File newFile = new File(accountDBFile);
//		  			
//		  			if(newFile.createNewFile()) {
//		  				System.out.println("New file is ready to write Data ");
//		  				
//		  			}
//		  			else {
//		  				System.out.println("File is already present");
//		  			}}
//		  		catch(Exception e) {
//		  			e.printStackTrace();
//		  		}
//		        
//		        try (FileInputStream fis = new FileInputStream("accountData.xlsx")) {
//		            workbook = new XSSFWorkbook(fis);
//		        
//
//		        XSSFSheet sheet = workbook.getSheetAt(0);
//		        
//		        Row row = sheet.createRow(0);
//		        
//		        //creating the first row of data file
//		
//	            row.createCell(0).setCellValue("Account Number");
//	            row.createCell(1).setCellValue("Account Holder Name");
//	            row.createCell(2).setCellValue("Card Number");
//	            row.createCell(3).setCellValue("Card Holder Name");
//	            row.createCell(4).setCellValue("Card Expire Date");
//	            row.createCell(5).setCellValue("CVV");
//	           // row.createCell(6).setCellValue("Account Number");
//
//		       
//		        
//
//		        
//		     }
//		        try (FileOutputStream newData = new FileOutputStream("accountData.xlsx")) {
//		            workbook.write(newData);
//		        }
//		        // Close the workbook
//		        workbook.close();
//		        
//		        
//	    	
//	    }


	public List<Account> readData() throws IOException {
		// Open the Excel file

		List<Account> objects = new ArrayList<>();

		//Map<account.getAccountNumber(),account> account = new HashedMap<>();

//	    	accountDBFile = "accountData.xlsx";
//	    	
//	    	  try {
//	  			File newFile = new File(accountDBFile);
//	  			
//	  			if(newFile.createNewFile()) {
//	  				System.out.println("New file is ready to write Data ");
//	  				
//	  			}
//	  			else {
//	  				System.out.println("File is already present");
//	  			}}
//	  		catch(Exception e) {
//	  			e.printStackTrace();
//	  		}

		try (
				XSSFWorkbook workbook = new XSSFWorkbook(accountDBFile)) {

			XSSFSheet sheet = workbook.getSheetAt(0);

			Iterator<Row> rowIterator = sheet.iterator();

			// Skip the first row (the header row)
			rowIterator.next();

			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();

				String accountNumber = cellIterator.next().getStringCellValue();
				String accountHolderName = cellIterator.next().getStringCellValue();
				int accountBalance = (int) cellIterator.next().getNumericCellValue();
				String cardNumber = cellIterator.next().getStringCellValue();
				String cardHolderName = cellIterator.next().getStringCellValue();
				Date cardExpirDate = cellIterator.next().getDateCellValue();
				int cvv = (int) cellIterator.next().getNumericCellValue();
				int charge = (int) cellIterator.next().getNumericCellValue();

				//int otp = (int)cellIterator.next().getNumericCellValue();

				// Account account = new Account(accountNumber, accountHolderName, cardNumber, cardHolderName, cardExpirDate, cvv);
				// objects.add(account);
				CardDetails cardDetails = new CardDetails(cardNumber, cardHolderName, cardExpirDate, cvv, charge);
				//OtpAuth otpAuth = new OtpAuth(otp);
				Account account = new Account(accountNumber, accountHolderName, accountBalance, cardDetails);
				//Account otpAccount = new Account(accountNumber,accountHolderName, cardDetails, otpAuth);
				objects.add(account);
			}
		}
		return objects;


	}

	public void appendData(List<Account> accounts) throws IOException {
		// Open the Excel file
		XSSFWorkbook workbook;

		try (FileInputStream fis = new FileInputStream(accountDBFile)) {
			workbook = new XSSFWorkbook(fis);


			XSSFSheet sheet = workbook.getSheetAt(0);


			// Write the data rows
			int rowNum = sheet.getLastRowNum() + 1;
			for (Account account : accounts) {
				Row row = sheet.createRow(rowNum++);
				row.createCell(0).setCellValue(account.getAccountNumber());
				row.createCell(1).setCellValue(account.getAccountHolderName());
				row.createCell(2).setCellValue(account.getAccountBalance());
				row.createCell(3).setCellValue(account.cardDetails.getCardNumber());
				row.createCell(4).setCellValue(account.cardDetails.getCardHoldersName());
				row.createCell(5).setCellValue(account.cardDetails.getCardExpirDate());
				row.createCell(6).setCellValue(account.cardDetails.getCvv());
				row.createCell(7).setCellValue(account.cardDetails.getCharge());

//	            row.createCell(2).setCellValue(account.getCardNumber());
//	            row.createCell(3).setCellValue(account.getCardHoldersName());
//	            Cell expirDateCell = row.createCell(4);
//	            expirDateCell.setCellValue(account.getCardExpirDate());
//	            //expirDateCell.setCellStyle(createDateCellStyle(workbook));
//	            row.createCell(5).setCellValue(account.getCvv());
			}

//	         Autosize the columns
//	        for (int i = 0; i < 6; i++) {
//	            sheet.autoSizeColumn(i);
//	        }

			// Write the file
			try (FileOutputStream newData = new FileOutputStream("book1.xlsx")) {
				workbook.write(newData);
			}
			// Close the workbook
			workbook.close();
		}
	}

	public void updateAccount(Account account) {
		XSSFWorkbook workbook;

		try (FileInputStream fis = new FileInputStream(accountDBFile)) {
			workbook = new XSSFWorkbook(fis);


			XSSFSheet sheet = workbook.getSheetAt(0);

			//read data from the excel

			int rows = sheet.getPhysicalNumberOfRows();
			for (int i = 0 ; i <rows; i++){
				Row row = sheet.getRow(i);

				Cell accountCell = row.getCell(0);

				String accountNumber = accountCell.getStringCellValue();

				if(accountNumber.equals(account.getAccountNumber())){
					Cell detailCell = row.getCell(2);
					detailCell.setCellValue(account.getAccountBalance());
				}

			}


			//inputStream.close();

			FileOutputStream outputStream = new FileOutputStream("book1.xlsx");
			workbook.write(outputStream);
			outputStream.close();
			workbook.close();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}


