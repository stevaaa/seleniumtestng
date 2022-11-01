package utils;

import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.lang.reflect.Method;

public class TestDataProvider {

    ReadExcelData excelUtil  = new ReadExcelData();

    @DataProvider(name="incorrectCreds")
    public String[][] getDataFor(Method m) throws IOException {
        return excelUtil.getData(m.getName());
    }
}
