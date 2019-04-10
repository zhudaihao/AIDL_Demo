package cn.wqgallery.aidl_sevice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/4/9.
 */

public class AidlService extends Service {
    private List<Person> list;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        list = new ArrayList<>();
        return iBinder;
    }

    private IBinder iBinder = new IMyAidlInterface.Stub() {
        @Override
        public void addPerson(Person person) throws RemoteException {
            //服务端逻辑处理
            list.add(person);
        }

        @Override
        public List<Person> getPersonList() throws RemoteException {
            return list;
        }
    };

}
