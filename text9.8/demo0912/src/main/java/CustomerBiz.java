import java.util.Scanner;

/**
 * Created by Administrator on 2016/9/13.
 */
public class CustomerBiz {
    String[] List = new String[10];
    int i = 0;
    int j = 0;

    public void addName(String p_name) {
        List[i] = p_name;
        i++;
    }

    public void showName() {
        System.out.println("******************");
        System.out.println("   客户姓名列表： ");
        System.out.println("******************");
        for (; j < i; j++) {
            System.out.print(List[j] + "   ");
        }
        System.out.println("   ");
    }

   /* public boolean search(String name) {

        System.out.println("********查找结果**********");
        int num = 0;
        for (j = 0; j < i; j++) {
            if (List[j].equals(name)) {
                num++;
            }
        }
        if (num > 0) {
            return true;
        } else {
            return false;
        }
    }*/

    public void rename(String name1,String name2) {
        System.out.println("****修改结果****") ;
        int renum = 0;
        int k = 0;
        for (; k < i; k++) {
            if (List[k].equals(name1)) {
                renum++;
                List[k] = name2;
            }
        }
        if(renum>0){
            System.out.println("找到并修改成功") ;
            System.out.println("   修改结果   ") ;
            for (j=0; j < i; j++) {
                System.out.print(List[j] + "   ");
            }
            System.out.println("   ");
        }
        else{
            System.out.println("没找到") ;
        }
    }



    public static void main(String[] args) {
        String inputName;
        String input1;

        CustomerBiz cb = new CustomerBiz();
        Scanner input = new Scanner(System.in);
        do {
            System.out.print("请输入客户姓名: ");
            inputName = input.next();
            cb.addName(inputName);
            System.out.print("继续输入吗？（y/n） ");
            input1 = input.next();
        } while (input1.equals("y"));
        cb.showName();

        /*
        while (true) {
            System.out.print("请输入要查找的客户姓名:");
            String searchName = input.next();

            boolean searchResult = cb.search(searchName);

            if (searchResult) {
                System.out.println("找到了");

            } else {

                System.out.println("客户姓名不存在");
            }

            System.out.print("继续输入吗?(y/n)");
            String isNextInput = input.next();
            if ("n".equals(isNextInput)) {
                break;
            } else if ("y".equals(isNextInput)) {
                continue;
            } else {
                System.out.println("输入错误，请重新输入");
                break;
            }
        }
        */
            String isNextInput2;
            do {
                System.out.print("请输入要修改的客户姓名:");
                String rename = input.next();
                System.out.print("请输入要更新的客户姓名:");
                String newName = input.next();
                cb.rename(rename, newName);
                System.out.print("继续输入吗？（y/n） ");
                 isNextInput2 = input.next();
            }
            while(isNextInput2.equals("y"));



    }
}