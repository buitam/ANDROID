package com.t3h.bai2QuanLyThongTinNguoiDung;

import java.util.ArrayList;

public class Manager {
    private ArrayList<User> userArrayList = new ArrayList<>();

    public int kiemTra(String userName){
        for (int i = 0; i < userArrayList.size() ; i++) {
            if(userArrayList.get(i).getUserName().equals(userName)) {
                return i;
            }
        }
        return -1;
    }

    public void dangKi(User newUser){
      if(kiemTra(newUser.getUserName())==-1){
          userArrayList.add(newUser);
          System.out.println("Đăng kí thành công");
      }
      else {
          System.out.println("Đăng kí thất bại");
      }
    }

    public int login(String userName, String pass){
        int count =0;
        for (int i = 0; i <userArrayList.size() ; i++) {
            count+=1;
            if(userArrayList.get(i).getUserName().equals(userName) && userArrayList.get(i).getPassword().equals(pass)){
                System.out.println("User thứ: " + count);
                return 1;
            }
        }
        return 0;
    }
    public void managerChangePass(String userName, String Oldpass, String newPass){
        for (int i = 0; i <userArrayList.size() ; i++) {
            if(userArrayList.get(i).getUserName().equals(userName) && userArrayList.get(i).getPassword().equals(Oldpass)){
                Oldpass = newPass ;
                System.out.println("cập nhật mật khẩu thành công \n Mật khẩu mới: " + newPass);
            }
        }
    }

    public void deleteUser(String userName, String pass){
        for (int i = 0; i <userArrayList.size() ; i++) {
        if(userArrayList.get(i).getUserName().equals(userName) && userArrayList.get(i).getPassword().equals(pass)){
            userArrayList.remove(i);
            System.out.println("xóa user thành công");
            }
        }
    }

    public void findInforUser(String userName){
        for (int i = 0; i < userArrayList.size() ; i++) {
            if(userArrayList.get(i).getUserName().equals(userName)) {
                userArrayList.get(i).showInfor();
            }
        }
    }

    public void inAllUser(){
        for (User user:userArrayList) {
            user.showInfor();
            System.out.println("----------------");
        }
    }
}
