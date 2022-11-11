package com.coderdianxia.con005simpledateformat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName: Simpledateformat01Test
 * @Description:普通调用Simpledateformat不出现线程安全问题
 * @Author:coderDianxia
 * @Date: 2022/11/9 9:52
 */
public class Simpledateformat01Test {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = format.parse("2022-10-12");
        System.out.println(parse);
    }
}
