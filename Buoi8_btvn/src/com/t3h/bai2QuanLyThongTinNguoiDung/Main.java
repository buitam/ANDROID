package com.t3h.bai2QuanLyThongTinNguoiDung;

public class Main {
    public static void main(String[] args) {
        User user = new User("Tam01","1234","Bùi Tâm","1998",21,"Sinh viên");
        User user2 = new User("Tam02","1234","Bùi Tâm","1998",21,"Sinh viên");
        User user3 = new User("Tam03","1234","Bùi Tâm","1998",21,"Sinh viên");
        //user.showInfor();
        //user.changePassword("1234");

        Manager manager = new Manager();
        manager.dangKi(user);
        manager.dangKi(user2);
        manager.dangKi(user3);

        if(manager.login("Tam03","1234") == 1){
            System.out.println("Login thành công");
        } else {
            System.out.println("Login ko thành công");
        }

        manager.findInforUser("Tam03");
        manager.managerChangePass("Tam03","1234","123456");
        manager.deleteUser("Tam03","1234");
        manager.inAllUser();


    }

}
