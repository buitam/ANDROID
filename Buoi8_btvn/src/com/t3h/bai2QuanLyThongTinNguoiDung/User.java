package com.t3h.bai2QuanLyThongTinNguoiDung;

public class User {
    private String userName;
    private String password;
    private String name;
    private String dateOfBirth;
    private int age;
    private String job;

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public int getAge() {
        return age;
    }

    public String getJob() {
        return job;
    }

    public User(String userName, String password, String name, String dateOfBirth, int age, String job) {
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.age = age;
        this.job = job;
    }
    public void  showInfor(){
        System.out.println("Name: " + name);
        System.out.println("User Name: " + userName);
        System.out.println("Password: " + password);
        System.out.println("Date Of Birth: " + dateOfBirth);
        System.out.println("Age: " + age);
        System.out.println("Job: " + job);
    }

    public void changePassword(String newPassword) {
        boolean soSanh = password.equals(newPassword);
        if(soSanh == true){
            System.out.println("Password bị trùng");
        } else {
            newPassword = password;
            System.out.println("cập nhật password thành công");
        }
    }
}
