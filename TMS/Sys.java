package com.LI;
import java.util.Scanner;
public class Sys {
	private Teacher[] teac = new Teacher[3];//定义数组存放老师个数
	private int index = 0;
	
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Sys sys = new Sys();
		sys.menu();
		Scanner scanner = new Scanner(System.in);
		while(true){
			System.out.print("请输入功能编号：");
			String option = scanner.nextLine();
			switch(option){
				case "1":	//查询所有老师信息
				{
					System.out.println("以下为所有老师的信息：");
					Teacher[] teac = sys.findAll();
					for(int i=0;i<teac.length;i++){
						System.out.println(teac[i]);
					}
					break;
				}
				case "2":	//添加老师信息
				{
						while(true){
						System.out.println("请输入教师信息【id#name#subject】或者输入break返回上一级目录");

						String teactr = scanner.nextLine();
						if(teactr.equals("break")){
							break;
						}
						String[] teacArr = teactr.split("#");
						long id = Long.parseLong(teacArr[0]);
						String name = teacArr[1];
						String subject = teacArr[2];
						Teacher teach = new Teacher(id,name,subject);
						sys.save(teach);
					}
					break;
				}
				case "3":
				{		//删除老师信息
					while(true){
						System.out.println("请输入要删除老师的【id】或者输入【break】返回主目录");
						String idTeac = scanner.nextLine();
						if(idTeac.equals("break")){
							break;
						}
						long id = Long.parseLong(idTeac);
						Teacher teach = sys.findById(id);
						if(teach == null){
							System.out.println("该老师不存在！");
							continue;
						}
						sys.deleteById(id);
						System.out.println("删除成功！");
					}
					break;
				}
				case "4":
				{		//修改老师信息
					while(true){
						System.out.println("请输入要修改老师的【id】或者输入【break】返回主目录");
						String idTeac = scanner.nextLine();
						if(idTeac.equals("break")){
							break;
						}
						long id = Long.parseLong(idTeac);
						Teacher teach = sys.findById(id);
						if(teach == null){
							System.out.println("该老师不存在！");
							continue;
						}
						System.out.println("原来信息："+teach);
						System.out.println("请输入修改后的信息【name#subject】:");
						String teactr = scanner.nextLine();
						
						String[] arr = teactr.split("#");
						String name = arr[0];
						String subject = arr[1];
						Teacher newteach = new Teacher(id,name,subject);
						sys.update(newteach);
						System.out.println("修改成功！");
					}
					break;
				}
				case "5":
				{		//按ID查询
					while(true){
						System.out.println("请输入要查询老师的id或输入break返回上一级");

						String idTeac = scanner.nextLine();
						if(idTeac.equals("break")){
							break;
						}
						long id = Long.parseLong(idTeac);
						Teacher teac = sys.findById(id);
						System.out.println(teac==null?"sorry not found!":teac);
					}
					break;
				}
				case "exit":
				{
					System.out.println("欢迎再次使用系统");
					System.exit(0);
				}
				case "help":
				{
					sys.menu();
					break;
				}
				default:
					System.out.println("输入出错！请重新输入。");
			}
		}

	}
	public void menu(){
		System.out.println("**********老师信息管理系统**********");
		System.out.println("**1. 查询所有老师信息");
		System.out.println("**2. 添加老师信息");
		System.out.println("**3. 删除老师信息");
		System.out.println("**4. 修改老师信息");
		System.out.println("**5. 根据ID查询老师信息");
		System.out.println("**exit. 退出系统");
		System.out.println("**help. 帮助");
		System.out.println("************************************");
	}

	//保存老师信息
	public void save(Teacher teach){
		if(index>=teac.length){
			Teacher[] demo = new Teacher[teac.length+3];
			System.arraycopy(teac,0,demo,0,index);
			teac = demo;
		}
		teac[index++] = teach;
	
	}
	
	
	//查询所有
	public Teacher[] findAll(){
		Teacher[] demo = new Teacher[index];
		System.arraycopy(teac,0,demo,0,index);
		return demo;
	}
	
	 //通过ID查询
	public Teacher findById(long id){
		int num = findIndexById(id);
		return num==-1?null:teac[num];
	}
	public int findIndexById(long id){
		int num = -1;
		for(int i=0;i<index;i++){
			if(teac[i].getID() == id){
				num = i;
				break;
			}
		}
		return num;
	}
	
	
	//删除老师信息
	public void deleteById(long id){
		int num = findIndexById(id);
		for(int i=num;i<index-1;i++){
			teac[i] = teac[i+1];
		}
		teac[--index] = null;
	}

	//更新老师信息
	public void update(Teacher newteach){
		for(int i=0;i<index;i++){
			if(newteach.getID() == teac[i].getID()){
				teac[i].setName(newteach.getName());
				teac[i].setSubject(newteach.getSubject());
			}
		
		}

	}

}
