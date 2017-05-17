package com.plter.rr;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by plter on 5/17/17.
 */
public class Main {

    public static void main(String[] args) {

        //声明在反射调用过程中会使用到的类
        Class[] importedClasses = new Class[]{Hello.class, Hi.class};

        //定义解析xml文件的作用域
        Map<String, Object> scope = new HashMap<>();

        try {
            //构造xml文档对象
            Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File("app.xml"));
            //获取根子节点
            Node root = document.getFirstChild();
            //获取代码执行部分的第一个节点
            Node node = root.getFirstChild();

            NamedNodeMap attributes;

            do {
                switch (node.getNodeName()) {
                    case "create":
                        //获取该节点的所有属性
                        attributes = node.getAttributes();
                        //获取类定义的完全限定名称节点
                        Node namedItem = attributes.getNamedItem("class");
                        //获取类的完全限定名称
                        String classNameString = namedItem.getNodeValue();
                        //获取引用名称
                        String refNameString = attributes.getNamedItem("ref").getNodeValue();
                        try {
                            //根据类的完全限定名称获取该类的定义
                            Class clazz = Class.forName(classNameString);
                            //创建类的实例，并将其添加到该xml文件的作用域中
                            scope.put(refNameString, clazz.newInstance());
                        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
                            e.printStackTrace();
                            throw new RuntimeException(String.format("Class %s not found", classNameString));
                        }
                        break;
                    case "call":
                        //获取要执行的方法定义的所有属性
                        attributes = node.getAttributes();
                        //获取该实例在xml作用域中的名称
                        String key = attributes.getNamedItem("name").getNodeValue();
                        //根据名称获取该类的实例
                        Object instance = scope.get(key);
                        //读取方法名称
                        String methodName = attributes.getNamedItem("method").getNodeValue();
                        try {
                            //根据方法名称获取该方法的定义
                            Method method = instance.getClass().getMethod(methodName);
                            //执行该方法
                            method.invoke(instance);
                        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                            e.printStackTrace();
                            throw new RuntimeException(String.format("Method %s not found", methodName));
                        }
                        break;
                }
            } while ((node = node.getNextSibling()) != null);

        } catch (SAXException | ParserConfigurationException | IOException e) {
            e.printStackTrace();
        }
    }
}
