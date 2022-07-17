import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("请分别输入将要登入的一卡通失物数量、书籍数量");
        int c_num=scanner.nextInt();
        int b_num=scanner.nextInt();
        int t_num=c_num+b_num;
        Lost[] losts=new Lost[t_num];
        for(int i=0;i<c_num;i++){
            System.out.println("请输入您的一卡通类型失物数据：时间，地点，一卡通id（按顺序）");
            int time=scanner.nextInt();
            String place=scanner.next();
            String id=scanner.next();
           losts[i]=new CardLost(time,place,id);
        }
        for(int i=c_num;i<t_num;i++){
            System.out.println("请输入您的书籍失物数据：时间，地点，书籍名字（按顺序）");
            int time=scanner.nextInt();
            String place=scanner.next();
            String book_name=scanner.next();
            losts[i]=new BookLost(time,place,book_name);
        }
        while(true){
            System.out.println("请选择功能：0、退出，1、排序，2、关键字查找");
            int s=scanner.nextInt();
            if(s==0){
                break;
            }
            if(s==1){
                sortLost(losts,t_num);
            }
            if(s==2){
                System.out.println("请输入关键字：");
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
            System.out.println("失物时间："+losts[i].time+"  "+"失物名称："+losts[i].get());
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
            System.out.println("无关键字，请重新输入");
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




