package linkedlist;

/**
 * @ProjectName: DataStructures
 * @ClassName: SingleLikedListDemo1
 * @Author: NoNO
 * @Description:
 * @tel: 13408937760  3407137458@qq.com
 * @Date: 2020/6/26 12:40
 */
public class SingleLikedListDemo1 {
    public static void main(String[] args) {
        SingleLikedList1 singleLikedList1 =new SingleLikedList1();
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        singleLikedList1.add2(hero1);
        singleLikedList1.add2(hero2);
        singleLikedList1.add2(hero3);
        singleLikedList1.add2(hero4);
        System.out.println("添加");
        singleLikedList1.list();
        HeroNode hero5= new HeroNode(4, "李逵", "黑旋风");
        singleLikedList1.update(hero5);
        System.out.println("修改");
        singleLikedList1.list();
        System.out.println("删除");
        singleLikedList1.delete(1);
        singleLikedList1.list();
    }
}


class SingleLikedList1 {
    private  HeroNode head =new HeroNode(0,"","");
    //添加节点  方式1：直接在单链表的最后一个位置添加元素
    public void add(HeroNode heroNode) {
        HeroNode temp =head;
        while (true){
            if (temp.next==null){
                break;
            };
            temp=temp.next;
        }
       temp.next=heroNode;
    }

//    要求按照指定的顺序添加
    public void add2(HeroNode heroNode){
        HeroNode temp =head;
        boolean flag =false;
        while (true){
            if (temp.next==null){
                break;
            }
            else if(temp.next.no>heroNode.no){
                break;
            }
            else if(temp.next.no==heroNode.no){
                //二者相等，表示数据已经存在，表示添加失败
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if (flag==true){
            System.out.println("数据已经存在，无法进行添加操作");
        }else{
            heroNode.next=temp.next;
            temp.next=heroNode;
        }


    }

//    遍历单链表
    public  void list(){
        if (head.next==null){
            System.out.println("单链表没有数据");
            return;
        }
        HeroNode temp =head.next;
        while (true){
            if (temp==null){
                break;
            }
            System.out.println(temp);
            temp =temp.next;
        }
    }

//根据编号修改元素
    public void update(HeroNode heroNode){
        if(head.next==null){
            System.out.println("单链表为空，找不到要修改的位置");
            return;
        }
        HeroNode temp =head.next;
        boolean flag =false;

        while (true){
            if (temp==null){
                break;
            }
            if (temp.no==heroNode.no){
                flag=true;
                break;
            }
            temp=temp.next;
        }

        if (flag==false){
            System.out.println("遍历数组结束，数组中没有该元素");
        }else{
            temp.no=heroNode.no;
            temp.name=heroNode.name;
            temp.nickname=heroNode.nickname;
        }
    }

//    删除节点
    public void delete(int no ){
     HeroNode temp =head;
     boolean flag =false;
     while (true){
         if (temp.next==null){
             return;
         }
         if (temp.next.no==no){
             flag =true;
             break;
         }
         temp =temp.next;
     }

     if (flag==true){
         temp.next =temp.next.next;
     }

    }


}

class HeroNode1 {
    public int no;
    public String name;
    public String nickname;
    public HeroNode heroNode;

    public HeroNode1(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", heroNode=" + heroNode +
                '}';
    }
}