package com.simba.db.util;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DBUtilTest {
    Logger logger = LoggerFactory.getLogger(DBUtilTest.class.getName());
    @Test
    public void testInsertSQL() throws Exception {
        VosAreaView view = new VosAreaView();
        view.setAreaCode("AreaCode");
        view.setAreaName("Fujian");
        view.setCompanyId("Anta");
        System.out.println(DBUtil.generateInsertSQL(view));
        System.out.println(DBUtil.generateUpdateSQL(view));
        logger.info(DBUtil.generateUpdateSQL(view));
    }
}
