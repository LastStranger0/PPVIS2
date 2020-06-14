package com.company.Control;

import com.company.Model.StudentData;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.ArrayList;
import java.util.List;

public class Sax {
    public enum ValidParams {
        NAME, STRUCTURE, POSITION, TITLE, TYPE, CATEGORY
    }

    private static List<StudentData> students = new ArrayList<>();
    private StudentData student;

    private String name;
    private String struct;
    private String position;
    private int title;
    private String typeSport;
    private String category;

    private String endElement;


    public void parse(String filename){
        try{
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            DefaultHandler handler = new DefaultHandler(){
                boolean bName = false;
                boolean bStruct = false;
                boolean bPosition = false;
                boolean bTitle = false;
                boolean bTypeSport = false;
                boolean bCategory = false;

                public void startElement(String uri, String localName, String queryName, Attributes attributes) throws SAXException {
                    if (queryName.equalsIgnoreCase(ValidParams.NAME.toString())) {
                        bName = true;
                    }
                    if (queryName.equalsIgnoreCase(ValidParams.STRUCTURE.toString())) {
                        bStruct = true;
                    }
                    if (queryName.equalsIgnoreCase(ValidParams.POSITION.toString())) {
                        bPosition = true;
                    }
                    if (queryName.equalsIgnoreCase(ValidParams.TITLE.toString())) {
                        bTitle = true;
                    }
                    if (queryName.equalsIgnoreCase(ValidParams.TYPE.toString())) {
                        bTypeSport = true;
                    }
                    if (queryName.equalsIgnoreCase(ValidParams.CATEGORY.toString())) {
                        bCategory = true;
                    }
                }

                public void endElement(String uri, String localName, String qName) throws SAXException {
                    endElement = qName;
                }

                public void characters(char[] ch, int start, int length) throws SAXException {
                    if(bName){
                        System.out.println("name" + new String(ch, start, length));
                        setName(new String(ch, start, length));
                        bName = false;
                    } else if(bStruct){
                        System.out.println("structure" + new String(ch, start, length));
                        setStruct(new String(ch, start, length));
                        bStruct = false;
                    } else if(bPosition){
                        System.out.println("position" + new String(ch, start, length));
                        setPosition(new String(ch, start, length));
                        bPosition = false;
                    } else if(bTitle){
                        System.out.println("title" + new String(ch, start, length));
                        setTitle(Integer.parseInt(new String(ch, start, length)));
                        bTitle = false;
                    } else if(bTypeSport){
                        System.out.println("type sport" + new String(ch, start, length));
                        setTypeSport(new String(ch, start, length));
                        bTypeSport = false;
                    } else if(bCategory){
                        System.out.println("category" + new String(ch, start, length));
                        setCategory(new String(ch, start, length));
                        bCategory = false;
                        StudentData stud = new StudentData();
                        stud.setName(getName());
                        stud.setStruct(getStruct());
                        stud.setPosition(getPosition());
                        stud.setTitle(getTitle());
                        stud.setTypeSport(getTypeSport());
                        stud.setCategory(getCategory());
                        students.add(stud);
                    }
                }
            };

            parser.parse(filename, handler);

        } catch (Exception e){
            e.printStackTrace();
        }
    }


    public static List<StudentData> getStudents() {
        return students;
    }

    public StudentData getStudent() {
        return student;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String Name){
        this.name = Name;
    }

    public String getStruct(){
        return this.struct;
    }

    public void setStruct(String Struct){
        this.struct = Struct;
    }

    public String getPosition(){
        return this.position;
    }

    public void setPosition(String Position){
        this.position = Position;
    }

    public int getTitle() {
        return this.title;
    }

    public void setTitle(int title) {
        this.title = title;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTypeSport() {
        return this.typeSport;
    }

    public void setTypeSport(String typeSport) {
        this.typeSport = typeSport;
    }
}
