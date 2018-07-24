package ru.job4j.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;

/**
 * Class StoreXML
 *
 * @author Konstantin Inozemcev (9715791@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class StoreXML {
    /**
     * Фаил для хранения данных
     */
    private File target;


    /**
     * Ссылка на логер
     */
    private static Logger logger = LoggerFactory.getLogger(StoreSQL.class);

    /**
     * Конструктор  - создание нового с параметрами
     * @param target
     */
    public StoreXML(File target) {
        this.target = target;
    }

    /**
     * Метод сохраняет данные в файл target.
     * @param  entry данные
     */
    public void save(Entry entry) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Entry.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
             jaxbMarshaller.marshal(entry, this.target);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

}




