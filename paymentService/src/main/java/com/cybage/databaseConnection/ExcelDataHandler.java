package com.cybage.databaseConnection;

import com.cybage.model.*;
import com.cybage.model.Record;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class ExcelDataHandler {

    private static String recordFile;

    Logger logger = LogManager.getLogger(getClass());

    public ExcelDataHandler() throws FileNotFoundException, IOException {
        this.recordFile = "record1.xlsx";

        onInit();
    }

    private void onInit() {

        try {
            File newFile = new File("recordFile");

            if (newFile.createNewFile()) {
                System.out.println("File is ready to write  record");
                logger.info(" File is ready to write ");
            } else {
                logger.info("File is already present");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Record> readData() {

        List<Record> records = new ArrayList<>();

        try{
            XSSFWorkbook workbook = new XSSFWorkbook(recordFile);
            XSSFSheet sheet = workbook.getSheetAt(0);

            Iterator<Row> rowIterator = sheet.iterator();

            rowIterator.next();

            while(rowIterator.hasNext()){

                Row row = rowIterator.next();

                Iterator<Cell> cellIterator = row.cellIterator();

                int transactionId = (int) cellIterator.next().getNumericCellValue();
//                String accountNumber = cellIterator.next().getStringCellValue();
//                String accountHolderName = cellIterator.next().getStringCellValue();
//                int accountBalance = (int) cellIterator.next().getNumericCellValue();
                String cardNumber = cellIterator.next().getStringCellValue();
                String cardHolderName = cellIterator.next().getStringCellValue();
                Date cardExpirDate = cellIterator.next().getDateCellValue();
                int cvv = (int) cellIterator.next().getNumericCellValue();
                int charge = (int) cellIterator.next().getNumericCellValue();
                int customerId = (int) cellIterator.next().getNumericCellValue();
                String customerName = cellIterator.next().getStringCellValue();
                int merchantId = (int) cellIterator.next().getNumericCellValue();
                String merchantName = cellIterator.next().getStringCellValue();

                CardDetails cardDetails = new CardDetails(cardNumber,cardHolderName,cardExpirDate,cvv,charge);
                //Account account = new Account(accountNumber,accountHolderName,accountBalance,cardDetails);
                Merchant merchant = new Merchant(merchantId, merchantName);
                Customer customer = new Customer (customerId, customerName);
                Record record = new Record(transactionId,cardDetails,merchant,customer);

                records.add(record);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return records;
    }

    private void appendData(List<Record>records){

        XSSFWorkbook workbook;
        try(FileInputStream file = new FileInputStream(recordFile)){

            workbook = new XSSFWorkbook(file);

            XSSFSheet sheet = workbook.getSheetAt(0);

            int rowNum = sheet.getLastRowNum() +1;
            for (Record record : records){

                Row row = sheet.createRow(rowNum++);

                row.createCell(0).setCellValue(record.getTransactionId());
//                row.createCell(1).setCellValue(record.account.getAccountNumber());
//                row.createCell(2).setCellValue(record.account.getAccountHolderName());
//                row.createCell(3).setCellValue(record.account.getAccountBalance());
                row.createCell(4).setCellValue(record.cardDetails.getCardNumber());
                row.createCell(5).setCellValue(record.cardDetails.getCardHoldersName());
                row.createCell(6).setCellValue(record.cardDetails.getCardExpirDate());
                row.createCell(7).setCellValue(record.cardDetails.getCvv());
                row.createCell(8).setCellValue(record.cardDetails.getCharge());
                row.createCell(9).setCellValue(record.customer.getCustomerId());
                row.createCell(10).setCellValue(record.customer.getCustomerName());
                row.createCell(11).setCellValue(record.merchant.getMerchantId());
                row.createCell(12).setCellValue(record.merchant.getMerchantName());


            }
            try(FileOutputStream newData = new FileOutputStream(recordFile)){

                workbook.write(newData);

                workbook.close();



            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
