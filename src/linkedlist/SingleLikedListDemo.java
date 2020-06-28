package linkedlist;

import javax.xml.ws.Holder;

/**
 * @ProjectName: DataStructures
 * @ClassName: SingleLikedListDemo
 * @Author: NoNO
 * @Description: 单链表测试
 * @tel: 13408937760  3407137458@qq.com
 * @Date: 2020/6/25 15:23
 */
public class SingleLikedListDemo {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
//按照顺序添加
        SingleLinked singleLinked = new SingleLinked();
        singleLinked.add2(hero1);
        singleLinked.add2(hero2);
        singleLinked.add2(hero3);
        singleLinked.add2(hero4);
        singleLinked.list();

//        修改节点
        HeroNode hero5 =new HeroNode(2,"李逵","黑旋风");
        singleLinked.update(hero5);
        singleLinked.list();
        System.out.println("删除节点测试");

       singleLinked.delete(1);
        System.out.println("第一次删除遍历");
        singleLinked.list();
        singleLinked.delete(4);
        System.out.println("第二次删除遍历");
        singleLinked.list();
        singleLinked.delete(3);
        System.out.println("第三次删除遍历");
        singleLinked.list();
        singleLinked.delete(2);
        System.out.println("第四次删除遍历");
        singleLinked.list();
    }
}


//SingleLinked 用于管理英雄
class SingleLinked {
    //初始化一个头结点，表示单链表的头 ,不存放具体的数据
    private HeroNode head = new HeroNode(0, "", "");

//    添加节点到单链表

    /**
     * 添加节点到单链表中，需要遍历到最后一个节点为null,
     */
    public void addNOde(HeroNode heroNode) {
//        由于头节点不能改变，所以我们需要一个辅助变量遍历列表
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
    }

//    第二种添加英雄方式，不按照顺序，将数据插入到指定位置

    public void add2(HeroNode heroNode) {
//         1.判断单链表是否为null
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > heroNode.no) {
                break;
            } else if (temp.next.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next; //后移，遍历当前链表
        }
        if (flag) {
            System.out.println("该英雄已经存在，不能加入");
        } else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }


    //遍历链表
    public void list() {
        if (head.next == null) {
            System.out.println("链表为null,没有数据。。。");
            return;
        }
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }

    }

    //    根据编号修改节点信息
    public void update(HeroNode newheroNode) {
//        判断链表是否为null
        if (head.next == null) {
            System.out.println("链表为null");
            return;
        }
        HeroNode temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) { //表示遍历结束，但是数组中没有改数据
//                System.out.println("遍历结束，但是链表中没有该数据编号，无法修改~~");
                break;
            }
            if (temp.no == newheroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag == false) {
            System.out.println("你想要修改的数据编号不存在，请先添加");
        } else {
            temp.no = newheroNode.no;
            temp.name = newheroNode.name;
            temp.nickname = newheroNode.nickname;
        }
    }

//    删除指定节点

    public  void  delete(int no ){
        HeroNode temp =head;
        boolean flag =false;

        while (true){
            if (temp.next==null){
                break;//表示遍历结束，但是没有找到节点
            }
            if (temp.next.no==no){
                flag=true;
                break;
            }
            temp =temp.next;
        }

        if (flag==false){
            System.out.println("表示没有找到该节点~~~~");
        }else{
            temp.next=temp.next.next;
        }



    }
}



//每一个英雄表示一个节点
class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    public HeroNode(int no, String name, String nickname) {
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
                '}';
    }
}