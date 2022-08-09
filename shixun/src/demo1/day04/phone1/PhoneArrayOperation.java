package demo1.day04.phone1;



import java.util.Random;

// 手机操作类
public class PhoneArrayOperation {
    // 定义一个数组
    private  TelPhone[] phoneArray;

      public TelPhone[] getPhoneArray() {
        return phoneArray;
    }

    public void setPhoneArray(TelPhone[] phoneArray) {
        this.phoneArray = phoneArray;
    }

    public  void autoInputDatas(){
        String[] brandsArray={"iphone","sanxing","huawei","xiaomi","moluoluola","nuojiya"};
        String[] phoneName={"嘻嘻","呵呵","嘿嘿","吼吼","哈哈"};
        double[] phonePrice={1.1,2.1,3.2,4.3,5.4};
        Random random=new Random();
        //生产四个手机类对象
        for(int i=1;i<phoneArray.length;i++){
           phoneArray[i] =new TelPhone(brandsArray[random.nextInt(brandsArray.length)],
                   phonePrice[random.nextInt(phonePrice.length)],// 10 0-9
                   phoneName[random.nextInt(phoneName.length)]);
        }

       // System.out.println("初始化后信息为:"+ Arrays.toString(phoneArray));

    }

    public void showPhoneInfos(){
        System.out.println("手机列表信息如下:");
        StringBuilder builder=new StringBuilder();
        builder.append("[").append("\r\n");
        for(int i=0;i<phoneArray.length;i++){
            // 获得一个手机信息
            TelPhone telPhone=phoneArray[i];
            if(telPhone==null){

                if(i==phoneArray.length-1){
                    builder.append("{}").append("\r\n").append("]");
                }else {
                    builder.append("{}").append(",").append("\r\n");
                }

            }else {
                if(i==phoneArray.length-1){
                    builder.append(telPhone).append("\r\n").append("]");
                }else {
                    builder.append(telPhone).append(",").append("\r\n");
                }
            }

        }
        System.out.println(builder);

    }

    public void sortPhoneByPrice(){
        System.out.println("按照价格从低到高排序后:");
        for(int i=0;i<phoneArray.length-1;i++){
            for(int j=0;j<phoneArray.length-i-1;j++){
                if(phoneArray[j]==null || phoneArray[j+1]==null){
                    System.out.println("有空对象,排序无意义...");
                    return;
                }


                    // 比较相邻的手机的价格
                    if(phoneArray[j].getPrice()>phoneArray[j+1].getPrice()){
                        // 交换
                        TelPhone temp=phoneArray[j];
                        phoneArray[j]=phoneArray[j+1];
                        phoneArray[j+1]=temp;
                    }


            }
        }
        showPhoneInfos();

    }
}
