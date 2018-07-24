package ru.job4j.jdbc;

import org.junit.Before;
import org.junit.Test;
import java.io.File;
import java.math.BigDecimal;
import java.math.MathContext;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class StoreSQLTest {
    private Config config;
    private File source;
    private File dest;
    private File schem;
    private StoreSQL storeSQL;
    private StoreXML storeXML;
    private ConvertXSQT convert;

    @Before
    public void setUp(){
        config = new Config();
        source = new File("/Users/writer/source.xml");
        dest = new File("/Users/writer/dest.xml");
        schem = new File("/Users/writer/schem.xml");
        storeSQL = StoreSQL.getInstance(config);
        storeXML = new StoreXML(source);
        convert = new ConvertXSQT();

    }


    @Test
    public void whenXMLTest() {
        storeSQL.generate(100);
        storeXML.save(storeSQL.getEntries());
        convert.convert(source, dest, schem);
        convert.parserXml(dest);
        System.out.println(convert.getSum());
        assertThat(convert.getSum(), is(5050));
    }

}
