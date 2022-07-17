import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("��ֱ����뽫Ҫ�����һ��ͨʧ���������鼮����");
        int c_num=scanner.nextInt();
        int b_num=scanner.nextInt();
        int t_num=c_num+b_num;
        Lost[] losts=new Lost[t_num];
        for(int i=0;i<c_num;i++){
            System.out.println("����������һ��ͨ����ʧ�����ݣ�ʱ�䣬�ص㣬һ��ͨid����˳��");
            int time=scanner.nextInt();
            String place=scanner.next();
            String id=scanner.next();
           losts[i]=new CardLost(time,place,id);
        }
        for(int i=c_num;i<t_num;i++){
            System.out.println("�����������鼮ʧ�����ݣ�ʱ�䣬�ص㣬�鼮���֣���˳��");
            int time=scanner.nextInt();
            String place=scanner.next();
            String book_name=scanner.next();
            losts[i]=new BookLost(time,place,book_name);
        }
        while(true){
            System.out.println("��ѡ���ܣ�0���˳���1������2���ؼ��ֲ���");
            int s=scanner.nextInt();
            if(s==0){
                break;
            }
            if(s==1){
                sortLost(losts,t_num);
            }
            if(s==2){
                System.out.println("������ؼ��֣�");
                String keyword=scanner.next();
                selectByKeyword(losts,t_num,keyword);
            }
        }

    }
    public static void sortLost(Lost[] losts,int t_num){
        int a=1;
        String b="apple";
        Lost temp=new Lost(a,b);
        for(int i=0;i<t_num-1;i++){
            for(int j=0;j<t_num-1-i;j++){
                if(losts[j].time>losts[j+1].time){
                    temp=losts[j];
                    losts[j]=losts[j+1];
                    losts[j+1]=losts[j];
                }
            }
        }
        for(int i=0;i<t_num;i++){
            System.out.println("ʧ��ʱ�䣺"+losts[i].time+"  "+"ʧ�����ƣ�"+losts[i].get());
        }
    }
    public static void selectByKeyword(Lost[] losts,int t_num,String keyword){
        int k=0;
        for(int i=0;i<t_num;i++){
            if(losts[i].place.contains(keyword)){
                System.out.println(losts[i].place+"  "+losts[i].get());
            }
            k=1;
        }
        if(k==0){
            System.out.println("�޹ؼ��֣�����������");
        }
    }

}
class Lost{
    protected int time;
    //2021-10-08
    protected String place;
    public Lost(int time,String place){
        this.time=time;
        this.place=place;
    }
    public String get(){
        return this.place;
    }

}
class CardLost extends Lost{
    private String id;
    public CardLost(int time,String place,String id){
        super(time,place);
        this.id=id;
    }
    public String get(){
        return this.id;
    }
}
class BookLost extends  Lost{
    private String book_name;
    public BookLost(int time,String place,String book_name){
        super(time,place);
        this.book_name=book_name;
    }
    public String get(){
        return book_name;
    }
}




