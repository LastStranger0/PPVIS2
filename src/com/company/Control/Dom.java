package com.company.Control;

import java.io.File;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import com.company.Model.StudentData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Dom {

    private String pathToFile;
    private List<StudentData> students;


    public List<StudentData> getStudents(){
        return students;
    }

    public void setStudents(List<StudentData> students, String path){
        this.students = students;
        this.pathToFile = path;
    }

    public void addStudents(StudentData student){
        students.add(student);
    }


    private Node createElem(Document doc, String name, String valuename){
        Element element = doc.createElement(name);
        element.appendChild(doc.createTextNode(valuename));
        return element;
    }

    private Node createChild(Document doc, String name, String struct, String position, int title, String typeSport, String category){
        Element element = doc.createElement("student");
        element.appendChild(createElem(doc, "name", name));
        element.appendChild(createElem(doc, "structure", struct));
        element.appendChild(createElem(doc,"position", position));
        element.appendChild(createElem(doc, "title", String.valueOf(title)));
        element.appendChild(createElem(doc, "type",typeSport));
        element.appendChild(createElem(doc, "category", category));
        return element;
    }

    public void setXML(){
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element root = document.createElement("Students");
            document.appendChild(root);
            for(StudentData i : students){
                root.appendChild(createChild(document, i.getName(), i.getStruct(), i.getPosition(), i.getTitle(), i.getTypeSport(), i.getCategory()));
            }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = null;
            try{
                transformer = transformerFactory.newTransformer();
                transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

                DOMSource source = new DOMSource(document);
                File file = new File(pathToFile);
                StreamResult streamResult = new StreamResult(file);

                transformer.transform(source, streamResult);
            }
            catch (TransformerException e){
                e.printStackTrace();
            }
        } catch (ParserConfigurationException e){
            e.printStackTrace();
        }
    }
}
