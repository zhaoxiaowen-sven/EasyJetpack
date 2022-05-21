package com.example.easyjetpack.livedata

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.os.SystemClock
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.*
import com.example.easyjetpack.MainActivity
import com.example.easyjetpack.R
import com.example.easyjetpack.viewmodel.UserModel
import com.example.easyjetpack.viewmodel.ViewModelActivity

class LiveDataActivity : AppCompatActivity() {
    companion object {
       const val TAG = "LiveDataActivity"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_livedata)
//        // 1、创建 mutableLiveData
//        val mutableLiveData = MutableLiveData<String>()
//
//        // 2、observer，需要传入 LifecycleOwner 对象，这里使用的是this
//        mutableLiveData.observe(
//            this,
//            object : Observer<String> {
//                override fun onChanged(it: String?) {
//                    Log.d(TAG,"onChanged:$it" )
//                    Toast.makeText(this@LiveDataActivity,it,Toast.LENGTH_LONG).show()
//                }
//            }
//        )
//
//        // 3、更新源数据
//        mutableLiveData.postValue("Hello LiveData")

//
//        val mutableLiveData = MutableLiveData<String>()
//        mutableLiveData.observe(this) {
//            Log.d(TAG, "onChanged:$it")
//            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
//        }
//        //LiveData返回值实例转换
//        val transformedLiveData = Transformations.map(mutableLiveData) { name ->
//            "${name}LiveData is great"
//        }
//        transformedLiveData.observe(this){
//            Log.d(TAG,"onChange2$it")
//        }
//        mutableLiveData.postValue("Hello LiveData ")
//
//
//        val userId: MutableLiveData<String> = MutableLiveData<String>()
//        val user = Transformations.switchMap(userId) { id -> getUser(id) }
//        userId.observe(this) {
//            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
//        }
//
//        user.observe(this) {
//            Toast.makeText(this@LiveDataActivity, it.toString(), Toast.LENGTH_SHORT).show()
//        }
//        userId.value = "id10"

//        val mediatorLiveData : MediatorLiveData<String> = MediatorLiveData()
//        val livedata1 = MutableLiveData<String>()
//        val livedata2 = MutableLiveData<String>()
//
//        mediatorLiveData.addSource(livedata1) {
//            Log.i(TAG, "livedata1 change $it")
//        }
//        mediatorLiveData.addSource(livedata2) {
//            Log.i(TAG, "livedata2 change $it")
//        }
//
//        mediatorLiveData.observe(this) {
//            Log.i(TAG,"onChanged:$it")
//        }
//
//        livedata1.value = "1"
//        livedata2.value = "2"

        val lvModel: LiveDataVModel = ViewModelProvider(this)[LiveDataVModel::class.java]
//        lvModel.lvData.observe(this) {
//            Thread{
//                SystemClock.sleep(3000)
//                val intent = Intent(LiveDataActivity@this, ViewModelActivity::class.java);
//                startActivity(intent)
//            }.start()
//        }
//

        lvModel.unFlowLiveData.observe(this) {
            Thread{
                SystemClock.sleep(3000)
                val intent = Intent(LiveDataActivity@this, ViewModelActivity::class.java);
                startActivity(intent)
            }.start()
        }

        findViewById<Button>(R.id.bt01).setOnClickListener {
            // lvModel.lvData.value = 3
            lvModel.unFlowLiveData.value = 3
        }

//        lvModel.lvData.observe(this) {
//            Log.i(TAG, "ret = $it")
//        }
//        lvModel.lvData.postValue(100)
//        lvModel.lvData.postValue(200)


        //        lvModel.liveEvent.observe(this) {
//            Thread{
//                SystemClock.sleep(3000)
//                val intent = Intent(LiveDataActivity@this, ViewModelActivity::class.java);
//                startActivity(intent)
//            }.start()
//        }
//
//        findViewById<Button>(R.id.bt01).setOnClickListener {
//            // lvModel.lvData.value = 3
//            lvModel.liveEvent.value = 3
//        }

//        lvModel.lvData.observe(this) {
//            Log.i(TAG, "ret = $it")
//        }
//        lvModel.lvData.postValue(100)
//        lvModel.lvData.postValue(200)

        lvModel.busevent.observe(this) {
            Thread{
                SystemClock.sleep(3000)
                val intent = Intent(LiveDataActivity@this, ViewModelActivity::class.java);
                startActivity(intent)
            }.start()
        }

        findViewById<Button>(R.id.bt01).setOnClickListener {
            // lvModel.lvData.value = 3
            lvModel.busevent.value = 3
        }
    }

    private fun getUser(id: String): LiveData<User> {
        return MutableLiveData(User("zxw", 20))
    }
}

data class User(val name : String, val age : Int) {

}
