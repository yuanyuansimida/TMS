package com.LI;
import java.util.Scanner;
public class Sys {
	private Teacher[] teac = new Teacher[3];//������������ʦ����
	private int index = 0;
	
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Sys sys = new Sys();
		sys.menu();
		Scanner scanner = new Scanner(System.in);
		while(true){
			System.out.print("�����빦�ܱ�ţ�");
			String option = scanner.nextLine();
			switch(option){
				case "1":	//��ѯ������ʦ��Ϣ
				{
					System.out.println("����Ϊ������ʦ����Ϣ��");
					Teacher[] teac = sys.findAll();
					for(int i=0;i<teac.length;i++){
						System.out.println(teac[i]);
					}
					break;
				}
				case "2":	//�����ʦ��Ϣ
				{
						while(true){
						System.out.println("�������ʦ��Ϣ��id#name#subject����������break������һ��Ŀ¼");

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
				{		//ɾ����ʦ��Ϣ
					while(true){
						System.out.println("������Ҫɾ����ʦ�ġ�id���������롾break��������Ŀ¼");
						String idTeac = scanner.nextLine();
						if(idTeac.equals("break")){
							break;
						}
						long id = Long.parseLong(idTeac);
						Teacher teach = sys.findById(id);
						if(teach == null){
							System.out.println("����ʦ�����ڣ�");
							continue;
						}
						sys.deleteById(id);
						System.out.println("ɾ���ɹ���");
					}
					break;
				}
				case "4":
				{		//�޸���ʦ��Ϣ
					while(true){
						System.out.println("������Ҫ�޸���ʦ�ġ�id���������롾break��������Ŀ¼");
						String idTeac = scanner.nextLine();
						if(idTeac.equals("break")){
							break;
						}
						long id = Long.parseLong(idTeac);
						Teacher teach = sys.findById(id);
						if(teach == null){
							System.out.println("����ʦ�����ڣ�");
							continue;
						}
						System.out.println("ԭ����Ϣ��"+teach);
						System.out.println("�������޸ĺ����Ϣ��name#subject��:");
						String teactr = scanner.nextLine();
						
						String[] arr = teactr.split("#");
						String name = arr[0];
						String subject = arr[1];
						Teacher newteach = new Teacher(id,name,subject);
						sys.update(newteach);
						System.out.println("�޸ĳɹ���");
					}
					break;
				}
				case "5":
				{		//��ID��ѯ
					while(true){
						System.out.println("������Ҫ��ѯ��ʦ��id������break������һ��");

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
					System.out.println("��ӭ�ٴ�ʹ��ϵͳ");
					System.exit(0);
				}
				case "help":
				{
					sys.menu();
					break;
				}
				default:
					System.out.println("����������������롣");
			}
		}

	}
	public void menu(){
		System.out.println("**********��ʦ��Ϣ����ϵͳ**********");
		System.out.println("**1. ��ѯ������ʦ��Ϣ");
		System.out.println("**2. �����ʦ��Ϣ");
		System.out.println("**3. ɾ����ʦ��Ϣ");
		System.out.println("**4. �޸���ʦ��Ϣ");
		System.out.println("**5. ����ID��ѯ��ʦ��Ϣ");
		System.out.println("**exit. �˳�ϵͳ");
		System.out.println("**help. ����");
		System.out.println("************************************");
	}

	//������ʦ��Ϣ
	public void save(Teacher teach){
		if(index>=teac.length){
			Teacher[] demo = new Teacher[teac.length+3];
			System.arraycopy(teac,0,demo,0,index);
			teac = demo;
		}
		teac[index++] = teach;
	
	}
	
	
	//��ѯ����
	public Teacher[] findAll(){
		Teacher[] demo = new Teacher[index];
		System.arraycopy(teac,0,demo,0,index);
		return demo;
	}
	
	 //ͨ��ID��ѯ
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
	
	
	//ɾ����ʦ��Ϣ
	public void deleteById(long id){
		int num = findIndexById(id);
		for(int i=num;i<index-1;i++){
			teac[i] = teac[i+1];
		}
		teac[--index] = null;
	}

	//������ʦ��Ϣ
	public void update(Teacher newteach){
		for(int i=0;i<index;i++){
			if(newteach.getID() == teac[i].getID()){
				teac[i].setName(newteach.getName());
				teac[i].setSubject(newteach.getSubject());
			}
		
		}

	}

}
