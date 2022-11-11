package com.example.a3912_sqlite;

public class Student {
        private int _id;
        private String _studentname;
        private String _Department;
        public Student() {
        }
        public Student(int id, String studentname,String Department) {
            this._id = id;
            this._studentname = studentname;
            this._Department=Department;
        }
        public void setID(int id) {
            this._id = id;
        }
        public int getID() {
            return this._id;
        }
        public void setStudentName(String studentname) {
            this._studentname = studentname;
        }
        public String getStudentName() {
            return this._studentname;
        }

}
