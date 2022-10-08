
package ra.run;

import ra.entity.Student;
import ra.entity.StudentClass;

import java.util.*;

import static ra.entity.IStudentManagenment.MARK_PASS;

public class StudentManagement {
    static List<Student> listStudent = new ArrayList<>();
    static List<StudentClass> listClass = new ArrayList<>();

    // DANH SÁCH QUẢN LÝ HỌC VIÊN
    public static void main(String[] args) {
        do {
            System.out.println(" ");
            System.out.println("********** QUẢN LY HỌC VIÊN *********");
            System.out.println(" 1: Quản lý lớp.");
            System.out.println(" 2: Quản lý sinh viên.");
            System.out.println(" 3: Thoát.");
            System.out.println(" \n ");
            Scanner sc = new Scanner(System.in);
            int pick = Integer.parseInt(sc.nextLine());
            switch (pick) {
                case 1:
                    StudentManagement.classManage();
                    break;
                case 2:
                    StudentManagement.studentManage();
                    break;
                case 3:
                    System.exit(0);
                    break;
            }
        } while (true);
    }

    // DANH SÁCH QUẢN LÝ LỚP
    public static void classManage() {
        do {
            System.out.println(" ");
            System.out.println("1: Thêm lớp học mới. ");
            System.out.println("2: Cập nhật thông tin lớp học. ");
            System.out.println("3: Hiển thị thông tin lớp học. ");
            System.out.println("4: Thống kê các lớp học hoạt động. ");
            System.out.println("5: Tìm kiếm lớp học theo tên lớp học.");
            System.out.println("6: Thoát!");
            Scanner sc = new Scanner(System.in);
            int pick = Integer.parseInt(sc.nextLine());
            switch (pick) {
                case 1:
                    System.out.print("Nhập thông tin lớp học mới : ");
                    System.out.print(" Nhập vào số lớp :");
                    int soLop = Integer.parseInt(sc.nextLine());
                    for (int i = 0; i < soLop; i++) {
                        StudentClass studentClass = new StudentClass();
                        studentClass.inputData();
                        listClass.add(studentClass);
                    }
                    break;
                case 2:
                    System.out.print("Nhập vào ID Class muốn cập nhật : ");
                    String idUpdate = sc.nextLine();
                    for (StudentClass sClass : listClass) {
                        if (Objects.equals(sClass.getClassID(), idUpdate)) {
                            System.out.println("Thông tin class cũ : ");
                            sClass.displayData();
                            System.out.println("Nhập mã danh mục mới :");
                            sClass.inputData();
                        }
                    }
                    break;
                case 3:
                    System.out.println("Hiển thị danh sách class ");
                    for (StudentClass sClass : listClass) {
                        sClass.displayData();
                    }
                    break;
                case 4:
                    System.out.println("Các class đang hoạt động là : ");
                    for (StudentClass sClass : listClass) {
                        if (sClass.getClassStatus() == 1) {
                            sClass.displayData();
                        }
                    }
                    break;
                case 5:
                    System.out.print("Nhập vào lớp cần tìm");
                    String search = sc.nextLine();
                    for (StudentClass sClass : listClass) {
                        if (Objects.equals(sClass.getClassName(), search)) {
                            sClass.displayData();
                        } else {
                            System.out.println("Không có thông tin");
                        }
                    }
                    break;
                case 6:
                    return;
            }
        } while (true);
    }

    // DANH SÁCH HỌC VIÊN
    public static void studentManage() {
        do {
            System.out.println(" ");
            System.out.println("********** QUẢN LÝ SINH VIÊN *********");
            System.out.println("1: Thêm sinh viên mới. ");
            System.out.println("2: Cập nhật thông tin sinh viên. ");
            System.out.println("3: Hiển thị thông tin sinh viên. ");
            System.out.println("4: Tính điểm trung bình. ");
            System.out.println("5: Xếp loại sinh viên.");
            System.out.println("6: Sắp xếp sinh viên theo điểm tăng.");
            System.out.println("7: Tìm kiếm sinh viên theo tên.");
            System.out.println("8: Thống kê học lực");
            System.out.println("9: Thống kê các sinh viên Pass");
            System.out.println("10: Thoát!");
            Scanner sc = new Scanner(System.in);
            int pick = Integer.parseInt(sc.nextLine());
            switch (pick) {
                case 1:
                    System.out.print("Nhập ID Class bạn muốn thêm sinh viên : ");
                    for (StudentClass sClass : listClass) {
                        System.out.print("ID " + sClass.getClassID());
                        System.out.println(" : " + sClass.getClassName());
                    }
                    String iDclass = sc.nextLine();
                    for (StudentClass sClass : listClass) {
                        if (Objects.equals(iDclass, sClass.getClassID())) {
                            System.out.print("Nhập số sinh viên muốn thêm : ");
                            int studentNumber = Integer.parseInt(sc.nextLine());
                            for (int i = 0; i < studentNumber; i++) {
                                Student students = new Student();
                                students.inputData();
                                students.setStudentClass(sClass);
                                listStudent.add(students);
                            }
                        }
                    }
                    break;
                case 2:
                    System.out.print("Nhập ID sinh viên muốn cập nhật :");
                    String iDstudent = sc.nextLine();
                    for (Student sStudent : listStudent) {
                        if (Objects.equals(iDstudent, sStudent.getStudentId())) {
                            System.out.println("Thông tin sinh viên cũ là : ");
                            sStudent.displayData();
                            System.out.print("Nhập thông tin cập nhật");
                            sStudent.inputData();
                        }
                    }
                    System.out.print("Đã được cập nhật");
                    break;
                case 3:
                    System.out.println("Thông tin các sinh viên là : ");
                    for (Student sStudent : listStudent) {
                        sStudent.displayData();
                    }
                    break;
                case 4:
                    System.out.println("Điểm trung bình của sinh viên là : ");
                    for (Student sMark : listStudent) {
                        sMark.calAvgMark();
                        System.out.println(sMark.getStudentName() + " : " + sMark.getAvgMark());
                    }
                    break;
                case 5:
                    System.out.println("Bảng xếp loại học sinh : ");
                    for (Student sMark : listStudent) {
                        sMark.getGPA();
                        System.out.println(sMark.getStudentName() + " : " + sMark.getgPA());
                    }
                    break;
                case 6:
                    System.out.println("Bảng xếp hạng sinh viên : ");
                    Collections.sort(listStudent);
                    for (Student sMark : listStudent) {
                        System.out.println(sMark.getStudentName() + " : " + sMark.getAvgMark());
                    }
                    break;
                case 7:
                    System.out.println("Nhập tên sinh viên cần tìm kiếm : ");
                    String nameStudent = sc.nextLine();
                    for (Student nStudent : listStudent) {
                        if (Objects.equals(nameStudent, nStudent.getStudentName())) {
                            nStudent.displayData();
                        } else {
                            System.out.println("Không có thông tin !");
                        }
                    }
                    break;
                case 8:
                    System.out.println("Bảng thống kê danh hiệu sinh viên :");
                    int gioi = 0;
                    int kha = 0;
                    int trungBinh = 0;
                    int yeu = 0;
                    for (Student nStudent : listStudent) {

                        if (Objects.equals(nStudent.getgPA(), "Giỏi")) {
                            gioi++;
                        }

                        if (Objects.equals(nStudent.getgPA(), "Khá")) {
                            kha++;
                        }
                        if (Objects.equals(nStudent.getgPA(), "Trung Bình")) {
                            trungBinh++;
                        }
                        if (Objects.equals(nStudent.getgPA(), "Yếu")) {
                            yeu++;
                        }
                    }
                    System.out.println(
                            "Giỏi        : " + gioi + "\n" +
                                    "Khá         : " + kha + "\n" +
                                    "Trung bình  : " + trungBinh + "\n" +
                                    "Yếu         : " + yeu);
                    break;
                case 9:
                    System.out.println("Bảng thống kê sinh viên PASS :");

                    for (Student nStudent : listStudent) {
                        if (nStudent.getAvgMark() > MARK_PASS) {
                            System.out.println(nStudent.getStudentName() + " Pass ");
                        }
                    }
                    break;
                case 10:
                    return;

            }
        } while (true);

    }
}