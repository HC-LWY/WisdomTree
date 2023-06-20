package com.qf.wisdomTree;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.qf.wisdomTree.dto.TUser;
import com.qf.wisdomTree.mapper.TUserMapper;
import com.qf.wisdomTree.sevice.impl.TUserServiceImpl;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class ApplicationTest {

    @Autowired
    TUserServiceImpl tUserService;

    @Test
    void test() throws IOException {
//        List<TUser> tUsers = tUserService.list();
//        System.out.println(tUsers);
//        ExportParams exportParams=new ExportParams("学生信息","sheet1");
//        Workbook sheets = ExcelExportUtil.exportExcel(exportParams, TUser.class, tUsers);
//        String fileName="学生信息.xls";
//        OutputStream outputStream=new FileOutputStream("D:\\idea\\WisdomTree\\business\\test\\src\\main\\java\\com\\qf\\wisdomTree\\file\\"+fileName);
//        sheets.write(outputStream);

        ImportParams importParams=new ImportParams();
        importParams.setTitleRows(1);
        File file=new File("D:\\idea\\WisdomTree\\business\\test\\src\\main\\java\\com\\qf\\wisdomTree\\file\\学生信息.xls");
        List<Object> objects = ExcelImportUtil.importExcel(file, TUser.class, importParams);

        System.out.println(objects);
    }
}