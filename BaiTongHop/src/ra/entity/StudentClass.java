package ra.entity;

import java.util.Scanner;

public class StudentClass implements IStudentManagenment {
    private String classID;
    private String className;
    private String descriptions;
    private int classStatus;

    public StudentClass() {
    }

    public StudentClass(String classID, String className, String descriptions, int classStatus) {
        this.classID = classID;
        this.className = className;
        this.descriptions = descriptions;
        this.classStatus = classStatus;
    }

    public String getClassID() {
        return classID;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public int getClassStatus() {
        return classStatus;
    }

    public void setClassStatus(int classStatus) {
        this.classStatus = classStatus;
    }

    @Override
    public void inputData() {
        System.out.println(" ");
        Scanner sc = new Scanner(System.in);
        // ID Class
        System.out.print(" Nhập ID class    : ");
        String idClass = sc.nextLine();
        char result = idClass.charAt(0);
        while (idClass.trim().length() != 5 || result != 'J') {
            System.out.print(" Tên không hợp lệ ! Nhập lại : ");
            idClass = sc.nextLine();
            result = idClass.charAt(0);
        }
        this.classID = idClass;

        // Ten Class
        System.out.print(" Nhập tên classs  : ");
        String className = sc.nextLine();
        while (className.trim().length() > 10) {
            System.out.println(" Tên không hợp lệ ! Nhập lại : !");
            className = sc.nextLine();
        }
        this.className = className;

        //Mo ta
        System.out.print(" Nhập mô tả class : ");
        this.descriptions = sc.nextLine();

        //Trang thai cua lop
        System.out.print(" Nhập trạng thái của lớp : ");
        int status = Integer.parseInt(sc.nextLine());
//        if(status == 0 ){
//            this.classStatus = ""
//
//        }
    }

    @Override
    public void displayData() {
        System.out.println(
                " StudentClass {" +
                        "  classID ='" + classID + '\'' +
                        ", className ='" + className + '\'' +
                        ", descriptions ='" + descriptions + '\'' +
                        ", classStatus =" + classStatus +
                        '}'


        );
    }

}
