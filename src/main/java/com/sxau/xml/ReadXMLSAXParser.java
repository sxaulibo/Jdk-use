package com.sxau.xml;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class ReadXMLSAXParser {
    public static String name = "";
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            ModuleHandler handler = new ModuleHandler(ModuleHandler.ModuleTypeEnum.IMPORTANT.value());
            saxParser.parse(new File("src/com/example/java/xml/moudles.xml"), handler);
            // Get Users list
            List<Module> modules = handler.getEmpList();
            // print user information
            for (Module module : modules) {
                System.out.println(module);
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    public static class Out{
        public String age;
    }
}
