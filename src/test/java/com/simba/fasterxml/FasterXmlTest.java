package com.simba.fasterxml;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.text.SimpleDateFormat;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class FasterXmlTest {
    @Test
    public void readJson(){
        String jsonString = "{\"tag\":1,\"msg\":{\"Data\":[{\"RowNumber\":1,\"Code\":\"A96\",\"Name\":\"青岛XX来贸易发展有限公司\",\"ParentCode\":\"A196\",\"LineNum\":\"1340164\",\"TrandingFlag\":1,\"WsType\":1},{\"RowNumber\":2,\"Code\":\"A120\",\"Name\":\"苏州市有限公司\",\"ParentCode\":\"A120\",\"LineNum\":\"1340168\",\"TrandingFlag\":1,\"WsType\":1}],\"TotalCount\":65,\"PageIndex\":0,\"PageCount\":100,\"LimitNum\":\"0\"}}";
        System.out.println(jsonString);
        ObjectMapper mapper = new ObjectMapper();

        try {
            JsonRootBean json = mapper.readValue(jsonString, JsonRootBean.class);
            Assert.assertEquals(2, json.getMsg().getData().size());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void readDate(){
        String jsonString = "{\"birth\" : \"1985-02-01 09:00:00\", \"hireDate\" : \"1995-02-01\"}";
        ObjectMapper mapper = new ObjectMapper();
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        //mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        try {
            DateVo json = mapper.readValue(jsonString, DateVo.class);
            Assert.assertNotNull(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
