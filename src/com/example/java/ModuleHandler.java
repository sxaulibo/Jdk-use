package com.example.java;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class ModuleHandler extends DefaultHandler {


    private String queryTypeId;

    ModuleHandler() {

    }

    public ModuleHandler(String queryTypeId) {
        this.queryTypeId = queryTypeId;
    }

    enum ModuleTypeEnum {

        CORE("1", "核心参数"),
        IMPORTANT("2", "重要参数"),
        FORMULA("3", "公式参数");

        /**
         * 状态值
         */
        private String value;
        /**
         * 状态的描述
         */
        private String description;

        private ModuleTypeEnum(String value, String description) {
            this.value = value;
            this.description = description;
        }

        public String value() {
            return value;
        }

        public String description() {
            return description;
        }
    }

    private boolean hasParam = false;
    private boolean hasTypeId = false;


    private List<Module> moduleList = null;
    private Module module = null;


    public List<Module> getEmpList() {
        return moduleList;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        System.out.println("qName:" + qName);

        if (qName.equalsIgnoreCase("Module")) {
            // create a new User and put it in Map
            String typeId = attributes.getValue("typeId");
            // initialize User object and set id attribute

            // TODO: 2021/3/29 need fix
            if (queryTypeId == null) {
                module = new Module();
                module.setTypeId(typeId);
            } else if (queryTypeId.equals(typeId)) {
                module = new Module();
                module.setTypeId(typeId);
            }

            // initialize list
            if (moduleList == null) {
                moduleList = new ArrayList<>();
            }
        } else if (qName.equalsIgnoreCase("param")) {
            // set boolean values for fields, will be used in setting User variables
            hasParam = true;
        }

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("Module")) {
            if (module != null) {
                // add User object to list
                moduleList.add(module);
                module = null;
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (module == null) {
            return;
        }
        if (hasParam) {
            // age element, set User age
            module.getParam().add(new String(ch, start, length));
            hasParam = false;
        } else if (hasTypeId) {
            module.setTypeId(new String(ch, start, length));
            hasTypeId = false;
        }
    }
}
