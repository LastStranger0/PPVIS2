package com.company.Model;

public class StudentData {
    private String name;
    private String struct;
    private String position;
    private int title;
    private String typeSport;
    private String category;


    public StudentData(){

    }

    public StudentData(String Name, String Struct, String Position, int Title, String TypeSport, String Category){
        this.name = Name;
        this.struct = Struct;
        this.position = Position;
        this.title = Title;
        this.typeSport = TypeSport;
        this.category = Category;
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
