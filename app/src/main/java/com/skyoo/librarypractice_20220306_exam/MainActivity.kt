package com.skyoo.librarypractice_20220306_exam

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.normal.TedPermission
import kotlinx.android.synthetic.main.activity_main.*
import java.time.Instant

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setEvents()
        setValues()
    }

    fun setEvents() {

        btnCall.setOnClickListener {
//            권한이 있는지 확인하고 진행해야 됨
//            확인은 획득 또는 거부 상황에 따라 다른 행동을 해야 함.
//            TedPermission 라이브러리의 PermissionListener{} 사용
//            object에 2가지 함수를 추가해야 함
//            자동 생성 되는 투두(...)은 앱이 죽기 때문에 지운다.
            val pl = object : PermissionListener {
                override fun onPermissionGranted() {
//      onPermissionGranted()은 권한이 허가 되었을때 작동하는 행동(함수)

//    아래 중갈호에 있던 전화걸기 코드를 여기로 옮겨 옴. 여기서는 실제 권한이 있을때 CALL 기능 실제 활용 됨
//            임시로 Call 기능을 넣어 본다 => 앱이 죽을 예정. 권한이 아직 없으므로
                    val myUri = Uri.parse( "tel:010-5555-6666")
                    val myIntent = Intent(Intent.ACTION_CALL, myUri)
                    startActivity(myIntent)

                }

                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
//      onPermissionDenied 은 권한이 거절 되었을때 작동하는 행동(함수). 보통 토스트로 메세지 알림.
                    Toast.makeText(this@MainActivity, "권한이 거부되어 전화 연결이 불가능합니다.", Toast.LENGTH_SHORT).show()

                }

            }

//            실제로 권한을 물어보자.
            TedPermission.create()
                .setPermissionListener(pl)
                .setPermissions(Manifest.permission.CALL_PHONE)
                .check()

        }

        imgProfile.setOnClickListener {

//            사진 크게 보는 화면으로 넘어가자. 단, 그전에 ViewPhotoActivity.kt라는 액티비티를 만들어야 함.
            val myIntent = Intent(this, ViewPhotoActivity::class.java)
            startActivity(myIntent)

        }

    }

    fun setValues() {

//       인터넷상의 이미지를 곧바로 이미지뷰에 반영.

    }
}