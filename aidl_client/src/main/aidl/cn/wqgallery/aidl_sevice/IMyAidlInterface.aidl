// IMyAidlInterface.aidl
package cn.wqgallery.aidl_sevice;

//定义服务端 接口
// 注意同包，也要导包
//写完注意编译

import cn.wqgallery.aidl_sevice.Person;
interface IMyAidlInterface {
//定义方法 支持Java基本数据类型，list map 和实现parcelable的bean对象(对象需要给个tag（in ,out,inout）)

void addPerson(in Person person);//添加person方法

List<Person> getPersonList();//获取person集合方法


}
