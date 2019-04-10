package cn.wqgallery.aidl_sevice;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 2019/4/9.
 */

public class Person implements Parcelable {
    private String name;
    private int grade;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

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


    public static final Parcelable.Creator<Person> CREATOR = new Parcelable.Creator<Person>() {
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
