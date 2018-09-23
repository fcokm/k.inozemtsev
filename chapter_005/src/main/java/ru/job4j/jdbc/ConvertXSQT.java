package ru.job4j.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.*;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;

/**
 * Class StoreXML
 *
 * @author Konstantin Inozemcev (9715791@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class ConvertXSQT {

    private Handler handler;

    /**
     * Ссылка на логер
     */
    private static Logger logger = LoggerFactory.getLogger(StoreSQL.class);

    /**
     * Метод читает файл source и преобразовывает его в
     * файл dest за счет XSTL схемы scheme.
     *
     * @param source файл с данными
     * @param dest   файл для записи преобразованных данных
     * @param scheme файл XSTL схемы
     */
    public void convert(File source, File dest, File scheme) {
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = null;
        try {
            transformer = factory.newTransformer(new StreamSource(new BufferedInputStream(
                    new FileInputStream(scheme))));
            transformer.transform(new StreamSource(new BufferedInputStream(new FileInputStream(source))),
                    new StreamResult(dest));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }


    /**
     * Метод сохраняет данные в файл target.
     *
     * @param file
     */
    public void parserXml(File file) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        this.handler = new Handler();
        SAXParser saxParser;
        try {
            saxParser = factory.newSAXParser();
            saxParser.parse(file, handler);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    /**
     * Class Handler реализует обработку событий SAX2
     */
    private class Handler extends DefaultHandler {
        /**
         * Cумма данных
         */
        private int sumField = 0;
        /**
         * Элемент данных
         */
        private String element;

        @Override
        public void startElement(String uri, String localName, String qName,
                                 Attributes attr) {
            element = qName;
            if (element.equals("entry")) {
                sumField += Integer.valueOf(attr.getValue("field"));
            }
        }

        /**
         * Метод возвращает  сумму данных
         * @return sumField
         */
       public int getSumField() {
            return sumField;
        }
    }

    /**
     * Метод возвращает  сумму данных
     * @return сумма данных
     */
    public int getSum() {
        return this.handler.getSumField();
    }

}
