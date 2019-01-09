package com.simba.db.util;

import org.junit.Test;

public class DBUtilTest {
    @Test
    public void testInsertSQL() throws Exception {
        VosAreaView view = new VosAreaView();
        view.setAreaCode("AreaCode");
        view.setAreaName("Fujian");
        view.setCompanyId("Anta");
        System.out.println(DBUtil.generateInsertSQL(view));
        System.out.println(DBUtil.generateUpdateSQL(view));
    }
}
