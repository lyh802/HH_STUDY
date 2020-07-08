package main;

import loadandsaveData.DataOperate;
import model.Resume;
import service.HrService;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        ArrayList<Resume> resumeList=new ArrayList<Resume>();
        Scanner input = new Scanner(System.in);
        DataOperate.loadData(resumeList);//下载所有简历
        HrService hrService=new HrService();
        while(true)
        {

            System.out.println("-----欢迎进入HR招聘系统-----");
            System.out.println("添加简历信息请按----1");
            System.out.println("删除简历信息请按----2");
            System.out.println("修改简历信息请按----3");
            System.out.println("查询简历信息请按----4");
            System.out.println("退出请按--------5");


            int choice=input.nextInt();
            boolean flag=false;
            switch (choice){
                case 1:
                    hrService.addResume(resumeList);
                    break;
                case 2:
                    hrService.deleteResume(resumeList);
                    break;
                case 3:
                    hrService.updateResume(resumeList);
                    break;
                case 4:
                    hrService. searchResume(resumeList);
                    break;
                case 5:
                    flag=true;
                    DataOperate.saveData(resumeList);
                    break;
                default:
                    System.out.println("输入错误，请重新输入");
                    break;
            }
            if(flag){
                System.out.println("您已退出图书管理系统");
                break;
            }

        }
    }
}