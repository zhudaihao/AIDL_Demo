package cn.wqgallery.aidl_client;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.util.List;

import cn.wqgallery.aidl_sevice.IMyAidlInterface;
import cn.wqgallery.aidl_sevice.Person;

public class MainActivity extends AppCompatActivity {
    private IMyAidlInterface iMyAidlInterface;

    private ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            iMyAidlInterface=IMyAidlInterface.Stub.asInterface(service);

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //客户端 ,绑定服务端的服务
        bindService();
    }

    private void bindService() {
        Intent intent = new Intent();
        //ComponentName参数（绑定的service的包名，包名+类名）
        intent.setComponent(new ComponentName("cn.wqgallery.aidl_sevice", "cn.wqgallery.aidl_sevice.AidlService"));
        bindService(intent, conn, BIND_AUTO_CREATE);
    }

    //点击
    public void send(View view) {
        try {
            iMyAidlInterface.addPerson(new Person("张三",1));
            List<Person> personList = iMyAidlInterface.getPersonList();
            Log.e("AGT","--------"+personList.toString());
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }
}
