package ra.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student implements IStudentManagenment, Comparable<Student> {
    private String studentId;
    private String studentName;
    private int age;
    private Boolean sex;
    private StudentClass studentClass;
    private List<Float> listMarkJavaScript = new ArrayList<>();
    private List<Float> listMarkJavaCore = new ArrayList<>();
    private List<Float> listMarkJavaWeb = new ArrayList<>();
    private float avgMark;
    private String gPA;
    private Boolean studentStatus;

    public Student() {
    }

    public Student(String studentId, String studentName,
                   int age, Boolean sex, StudentClass studentClass,
                   List<Float> listMarkJavaScript,
                   List<Float> listMarkJavaCore,
                   List<Float> listMarkJavaWeb,
                   float avgMark,
                   String gPA,
                   Boolean studentStatus) {

        this.studentId = studentId;
        this.studentName = studentName;
        this.age = age;
        this.sex = sex;
        this.studentClass = studentClass;
        this.listMarkJavaScript = listMarkJavaScript;
        this.listMarkJavaCore = listMarkJavaCore;
        this.listMarkJavaWeb = listMarkJavaWeb;
        this.avgMark = avgMark;
        this.gPA = gPA;
        this.studentStatus = studentStatus;
    }

    public static void inputMark(List<Float> listMark) {
        int cnt = 1;
        Scanner mark = new Scanner(System.in);
        do {
            System.out.printf(" Nhập điểm thi lần : ", cnt);
            listMark.add(Float.parseFloat(mark.nextLine()));
            cnt++;
            System.out.print(" Bạn có muốn nhập lại ko ? \n 1.CÓ \n 2.Không ");
            int pick = Integer.parseInt(mark.nextLine());
            if (pick != 1) {
                break;
            }
        } while (true);
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public StudentClass getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(StudentClass studentClass) {
        this.studentClass = studentClass;
    }

    public List<Float> getListMarkJavaScript() {
        return listMarkJavaScript;
    }

    public void setListMarkJavaScript(List<Float> listMarkJavaScript) {
        this.listMarkJavaScript = listMarkJavaScript;
    }

    public List<Float> getListMarkJavaCore() {
        return listMarkJavaCore;
    }

    public void setListMarkJavaCore(List<Float> listMarkJavaCore) {
        this.listMarkJavaCore = listMarkJavaCore;
    }

    public List<Float> getListMarkJavaWeb() {
        return listMarkJavaWeb;
    }

    public void setListMarkJavaWeb(List<Float> listMarkJavaWeb) {
        this.listMarkJavaWeb = listMarkJavaWeb;
    }

    public float getAvgMark() {
        return avgMark;
    }

    public void setAvgMark(float avgMark) {
        this.avgMark = avgMark;
    }

    public String getgPA() {
        return gPA;
    }

    public void setgPA(String gPA) {
        this.gPA = gPA;
    }

    public Boolean getStudentStatus() {
        return studentStatus;
    }

    public void setStudentStatus(Boolean studentStatus) {
        this.studentStatus = studentStatus;
    }

    @Override
    public void inputData() {
        Scanner sc = new Scanner(System.in);
        // MA SINH VIEN
        System.out.print(" Nhap vao ma sinh vien : ");
        String idStudent = sc.nextLine();
        char result = idStudent.charAt(0);
        while (idStudent.trim().length() != 6 || result != 'S') {
            System.out.print(" Vui long nhap lai : ");
            idStudent = sc.nextLine();
            result = idStudent.charAt(0);
        }
        this.studentId = idStudent;
        // TEN SINH VIEN
        System.out.print(" Nhap ten sinh vien        : ");
        this.studentName = sc.nextLine();

        //GIOI TINH
        System.out.print(" Nhap vao gioi tinh        : ");
        this.sex = Boolean.parseBoolean(sc.nextLine());
        // NHAP TUOI
        System.out.print(" Nhập tuổi sinh viên       : ");
        do {
            this.age = Integer.parseInt(sc.nextLine());
            if (this.age >= 18) {
                break;
            } else {
                System.out.println("Vui lòng nhập tuổi trên 18");
            }
        } while (true);
        //TRANG THAI SINH VIEN
        System.out.print(" Nhập trạng thái sinh viên :");
        this.studentStatus = Boolean.parseBoolean(sc.nextLine());
        // NHAP DIEM THI
        System.out.print(" Nhập điểm thi JS          :");
        inputMark(listMarkJavaScript);
        System.out.print(" Nhập điểm thi Java        :");
        inputMark(listMarkJavaCore);
        System.out.print(" Nhập điểm thi JavaWeb     :");
        inputMark(listMarkJavaWeb);
    }

    // TINH DIEM
    public void calAvgMark() {
        this.avgMark = (this.listMarkJavaScript.get(listMarkJavaScript.size() - 1)
                + listMarkJavaCore.get(listMarkJavaCore.size() - 1)
                + listMarkJavaWeb.get(listMarkJavaWeb.size() - 1)) / 3;
    }

    public void getGPA() {
        if (this.avgMark < 5) {
            this.gPA = "Yếu";
        } else if (this.avgMark < 7) {
            this.gPA = "Trung Bình";
        } else if (this.avgMark < 9) {
            this.gPA = "Khá";
        } else {
            this.gPA = "Giỏi";
        }

    }

    @Override
    public void displayData() {
        System.out.println(
                "Student{" +
                        "  Id = " + this.studentId +
                        ", Tên = " + this.studentName +
                        ", Tuổi = " + this.age +
                        ", Lớp = " + this.studentClass.getClassName() +
                        ", Xếp loại = " + this.gPA +
                        ", Trạng thái = " + this.studentStatus +
                        ", Giới tính = " + this.sex +
                        '}'
        );
    }


    @Override
    public int compareTo(Student o) {
        return ((int) this.getAvgMark() - (int) o.getAvgMark());
    }
}
