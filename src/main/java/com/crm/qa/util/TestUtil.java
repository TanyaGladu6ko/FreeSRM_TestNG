package com.crm.qa.util;

import com.crm.qa.base.TestBase;

/**
 * Created by Tanya on 1/26/2018.
 */
public class TestUtil extends TestBase {

    public final static long PAGE_LOAD_TIMEOUT = 20;
    public final static long IMPLICIT_WAIT = 10;

    public void switchToFrame(){
        driver.switchTo().frame("mainpanel");
    }

}
