package LowHR1;
import java.util.ArrayList;
import java.util.Scanner;

import bean.Resume;

public class HRS {
    private boolean iscndb=false;//�Ƿ�������ݿ�
    private int MAXSIZE=100;
//�������ʼ����ʱ������������Ĵ�С����û�б�ķ�ʽ�����أ�
//    private HR[] HRList=new HR[MAXSIZE];
//��listʵ�ֶ�̬����
    ArrayList<Resume> ResumeArrayList=new ArrayList<>();
//�����ʼ��
//	int[]  shuzu=new int[1];
//	int[] shuzu1={1,2,3};
//	int[] shuzu3=new  int[]{1,2,3};

    private int HRCount=0;//������������ķ��գ����÷�ֹԽ�磻
    //��ȡ��׼������
    private Scanner input=new Scanner(System.in);
    HRS(){
        while(true)
        {

            System.out.println("-----��ӭ����qhr��HR����ϵͳ-----");
            System.out.println("���Ӽ����밴----1");
            System.out.println("ɾ�������밴----2");
            System.out.println("�޸ļ����밴----3");
            System.out.println("��ѯ�����밴----4");
            System.out.println("�˳��밴--------5");
            int choice=input.nextInt();
            //������if ������switch��ʽʵ���߼��ж�
            switch (choice){
                case 1:
                    addHR();
                    continue;
                case 2:
                    deleteHR();
                    continue;
                case 3:
                    updateHR();
                    continue;
                case 4:
                    searchHR();
                    continue;
                case 5:
                    input.close();//���� ���Ӱ� ��Щ���� ����ǵùأ�Ҫô�ǵû�����ôʲô�ط�����Ҫ���ģ�ʲô�ط��ǹصģ���
                    System.out.println("���Ѿ��˳���������ϵͳ");
                    break;
                default:
                    System.out.println("�����������������");
            }
        }
    }

    //���Ӽ���
    void addHR()
    {
        System.out.println("��ӭ�������Ӽ�������");
        if(HRCount<MAXSIZE)//�жϼ�������ϵͳ�Ƿ�δ��
        {
            Scanner input=new Scanner(System.in);
            System.out.println("������������Ҫ���Ӽ���������������֤�ţ�ѧУ������״̬");
            String ReName=input.nextLine();
            String ReId=input.nextLine();
            String ReSchool=input.nextLine();
            Integer ReProcess=input.nextInt();
//          Integer ReDeleteStatus=input.nextInt();
            //get/SET
            Resume Resume=new Resume(ReName,ReId,ReSchool,ReProcess);
            Resume.setProcess(ReProcess);
//            Resume.setDeleteStatus(ReDeleteStatus);
            //������ʱ���Ѿ���79�����ˣ���ô��79�����λ����78
            ResumeArrayList.add(HRCount,Resume);
            HRCount++;
            System.out.println("���Ѿ��ɹ����Ӽ���");
            showHR();
        }
        else{
            System.out.println("��������ϵͳ�������޷����Ӽ���");
        }
    }

    //����ɾ������
    void deleteHR()
    {
        @SuppressWarnings("resource")
        Scanner input=new Scanner(System.in);
        System.out.println("��ӭ����ɾ����������");
        System.out.println("��������Ҫɾ������������������֤����");
        String id=input.nextLine();
        if(HRCount!=0)//��������ϵͳ��Ϊ��
        {
            for(int i=0;i<HRCount;i++)
            {
                if(ResumeArrayList.get(i).getId().equals(id))
                {
//                    for(int j=i;j<HRCount-1;j++)
//                    {
//                        HRList[j]=HRList[j+1];
//                    }
                    ResumeArrayList.remove(i);
                    System.out.println("���Ѿ��ɹ�ɾ��"+id+"�ļ�����Ϣ");
                    HRCount--;
                    break;
                }
                else if(i==HRCount-1) {
                    System.out.println("û���ҵ��ü���");
                }
            }
            showHR();
        }
        else{
            System.out.println("��������ϵͳΪ�գ�û���ҵ��ü���");
        }
//		input.close();
    }
    //�߼�ɾ������
    void deleteHR2()
    {
        @SuppressWarnings("resource")
        Scanner input=new Scanner(System.in);
        System.out.println("��ӭ����ɾ����������");
        System.out.println("��������Ҫɾ������������������֤����");
        String id=input.nextLine();
        if(HRCount!=0)//��������ϵͳ��Ϊ��
        {
            for(int i=0;i<HRCount;i++)
            {
                if(ResumeArrayList.get(i).getId().equals(id))
                {
//
                    ResumeArrayList.get(i).setDeleteStatus(0);
                    System.out.println("���Ѿ��ɹ�ɾ��"+id+"�ļ�����Ϣ");
                    HRCount--;
                    break;
                }
                else if(i==HRCount-1) {
                    System.out.println("û���ҵ��ü���");
                }
            }
            showHR();
        }
        else{
            System.out.println("��������ϵͳΪ�գ�û���ҵ��ü���");
        }
//		input.close();
    }
    //�޸ļ���
    void updateHR()
    {
        Scanner input=new Scanner(System.in);
        System.out.println("��ӭ�����޸ļ�������");
        System.out.println("��������Ҫ�޸ļ���������������֤����");
        String id=input.nextLine();
        if(HRCount!=0)//��������ϵͳ��Ϊ��
        {
            for(int i=0;i<HRCount;i++)
            {
                if(ResumeArrayList.get(i).getId().equals(id))
                {
                    System.out.println("�����������µ�����������֤�ţ�ѧУ������״̬");
                    String newname=input.nextLine();
                    String newreid=input.nextLine();
                    String newschool=input.nextLine();
                    Integer newprocess=input.nextInt();
                    Resume resume=new Resume(newname,newreid,newschool,newprocess);
                    ResumeArrayList.add(i,resume);
                    System.out.println("���Ѿ��޸ĳɹ�");
                    showHR();
                }
                else if(i==HRCount-1||HRCount==0) {
                    System.out.println("û�в��ҵ����鼮");
                }
            }
        }
        else{
            System.out.println("ϵͳΪ�գ�û�в��ҵ����鼮");
        }
//		input.close();
    }

    //��ѯ����
    void searchHR()
    {
        @SuppressWarnings("resource")
        Scanner input=new Scanner(System.in);
        System.out.println("��ӭ�����ѯ��������");
        System.out.println("��������Ҫ��ѯ�ļ�����");
        String id=input.nextLine();
        for(int i=0;i<HRCount;i++)
        {

            if(ResumeArrayList.get(i).getId().equals(id))
            {
                String chProcess []={"������","����ͨ��","����ͨ��","���ͨ��","����ͨ��","��ǩԼ","����ְ"};
                System.out.println("<<"+ResumeArrayList.get(i).getName()+">>"+"\n"+
                        "����֤��"+":"+ResumeArrayList.get(i).getId()+"\n"
                        +"ѧУ"+":"+ResumeArrayList.get(i).getSchool()+"\n"
                        +"����״̬"+":"+ResumeArrayList.get(i).getProcess()+"\n"
                        +"λ�ڵ�"+(i+1)+"λ��");
                break;
            }
            else if(i==HRCount-1) {
                System.out.println("û�в��ҵ����鼮������������");
            }
        }
//		input.close();
    }

    //��������
    void showHR()
    {
        @SuppressWarnings("resource")
        Scanner input=new Scanner(System.in);
        System.out.println("�Ƿ���Ҫ��ӡ���м�������������Y�����ô�ӡ����������");
        String XUANZE=input.nextLine();
        String Y="Y";
        if(XUANZE.equals(Y))
        {
            System.out.println("����������ϵͳ����"+HRCount+"��������Ϣ");
            for(int i=0;i<HRCount;i++) {
                System.out.println("��"+(i+1)+"��1"+"----"+"<<"+ResumeArrayList.get(i).getName()+">>");
            }
        }
//		input.close();
    }

    public static void main(String[] args)
    {
        new HRS();
    }
}