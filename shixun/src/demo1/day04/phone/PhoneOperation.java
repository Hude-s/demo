package demo1.day04.phone;

import java.util.ArrayList;

public class PhoneOperation {

    private Phone[] phones = new Phone[5];

    private ArrayList<Phone> phoneArrayList = new ArrayList<>();

    public Phone[] getPhones() {
        return phones;
    }

    public void setPhones(Phone[] phones) {
        this.phones = phones;
    }

    public void autoInputData() {
    }

    public void showPhoneInfos() {
//        if (phones == null || phones.length == 0) {
//            System.out.println("没有数据。");
//        } else {
//            System.out.println("开始打印数据");
//            for (Phone phone : phones) {
//                System.out.println(phone);
//            }
//        }

        if (phoneArrayList == null || phoneArrayList.size() == 0) {
            System.out.println("没有数据");
        } else {
            for (Phone phone : phoneArrayList) {
                System.out.println(phone);
            }
        }
    }

    public void sortPhoneByPrice() {
//        Collections.sort(phones, new Comparator<Phone>() {
//            @Override
//            public int compare(Phone o1, Phone o2) {
//                return (int) (o1.getPrice() - o2.getPrice());
//            }
//        });
    }

    public void autoInputData(String[] brands, String[] phoneNames, double[] phonePrice) {
        for (int i = 0; i < brands.length; i++) {
            Phone phone = new Phone();
            phone.setBrand(brands[i]);
            phone.setName(phoneNames[i]);
            phone.setPrice(phonePrice[i]);
            this.phones[i] = phone;
            phoneArrayList.add(phone);
        }
    }


//    public <E> void autoInputData(E[] inputArray ) {
//        for (int i = 0; i < inputArray.length; i++) {
//            Phone phone = new Phone();
//
//        }
//    }
}
