package com.company.Control;

import com.company.Model.StudentData;
import org.xml.sax.*;
import javax.xml.parsers.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ControlOfData {
    private List<StudentData> DataTable;
    private boolean bName;
    private boolean bTitle;
    private boolean bCategory;
    private boolean bTypeSport;


    public ControlOfData(){
        DataTable = new ArrayList<StudentData>();
    }

    private List<StudentData> TemplateFind(String name, int minTitle, int maxTitle, String typeSport, String category){
        List<StudentData> temp = new ArrayList<>();
        for(StudentData i : DataTable){
            boolean bIsFits = (i.getName().equals(name) || bName)
                    && (i.getTitle() >= minTitle && i.getTitle() <= maxTitle || bTitle)
                    && (i.getTypeSport().equals(typeSport) || bTypeSport)
                    && (i.getCategory().equals(category) || bCategory);
            if(bIsFits){
                temp.add(i);
            }
        }
        return temp;
    }

    public List<StudentData> StudentsFind(String name, int minTitle, int maxTitle, String typeSport, String category){
        bName = (name.equals(""));
        bTitle = (minTitle == 0 && maxTitle == 0);
        if(maxTitle < minTitle){
            maxTitle = minTitle;
        }
        bTypeSport = (typeSport.equals("All"));
        bCategory = (category.equals("All"));

        return TemplateFind(name, minTitle, maxTitle, typeSport, category);
    }

    public int DeleteStudents(String name, int minTitle, int maxTitle, String typeSport, String category){
        bName = name.equals("");
        bTitle = (minTitle == 0 && maxTitle == 0);
        if(maxTitle < minTitle){
            maxTitle = minTitle;
        }
        bTypeSport = (typeSport.equals("All"));
        bCategory = (category.equals("All"));

        List<StudentData> temp = TemplateFind(name, minTitle, maxTitle, typeSport, category);
        int size = temp.size();
        DataTable.removeAll(temp);
        return size;
    }

    public void Add(StudentData stud){
        DataTable.add(stud);
    }

    public void Read(String pathToFile) throws ParserConfigurationException, SAXException, IOException {
        Sax sax = new Sax();
        sax.parse(pathToFile);
        DataTable = Sax.getStudents();
    }

    public void Write(String pathToFile){
        Dom dom = new Dom();
        dom.setStudents(DataTable, pathToFile);
        dom.setXML();
    }

    public StudentData Index(int index){
        return DataTable.get(index);
    }

    public boolean isExist(int index){
        return index < DataTable.size();
    }

    public void setStudent(List<StudentData> data){
        DataTable = data;
    }
}
