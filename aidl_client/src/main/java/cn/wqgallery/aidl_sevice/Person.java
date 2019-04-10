package cn.wqgallery.aidl_sevice;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 2019/4/9.
 * 注意客户端定义的bean 包名必须和服务端定义的包名一致
 */

public class Person implements Parcelable {
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }

    private String name;
    private int grade;

    @Override
    public int describeContents() {
        return 0;
    }


    //注意需要在含parcel的构造方法里面把数据读出来才能打印数据
    public Person(Parcel dest) {
        this.name = dest.readString();
        this.grade = dest.readInt();
    }

    public Person(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    /**
     * 读readFromParcel
     * 要支持out，inout,需要实现下面方法
     * 注意读的数据顺序要和writeToParcel数据顺序一致
     */
    public void readFromParcel(Parcel dest) {
        this.name = dest.readString();
        this.grade = dest.readInt();
    }

    /**
     * 写writeToParcel
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeInt(this.grade);
    }


    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel source) {
            return new Person(source);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };
}
