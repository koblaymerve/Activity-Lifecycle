package com.androideduio.activity_lifecycle

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val key = "LifeCycle"

    //Activity oluştuğunda çalışan ilk method
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.e(key, "onCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
    }

    //Arayüz içinde değişiklik olduğunda çalışan method
    //setContentView(), addContentView() metodları sonrasında bu method çağrılır
    override fun onContentChanged() {
        Log.e(key, "onContentChanged")
    }

    //onCreate() ve onRestart() methodları sonrasında çalışır
    override fun onStart() {
        super.onStart()
        Log.e(key, "onStart")
    }

    //savedInstanceState parametresi içinde atanan bir değer varsa onStart() methodu sonrası bu method çağrılır
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.e(key, "onRestoreInstanceState")
    }

    //onStart() ve onRestoreInstanceState() methodlarından sonra sistem sınıflarının değer atamalarını yapması için çağrılır
    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        Log.e(key, "onPostCreate")
    }

    //onRestoreInstanceState(), onRestart() veya onPause() methodları sonrasında çağrılır.Uygulamanın kullanıcı ile etkileşime geçtiğinde çağrılan method
    override fun onResume() {
        super.onResume()
        Log.e(key, "onResume")
    }

    //onResume() methodu sonrasında çağrılan method
    override fun onPostResume() {
        super.onPostResume()
        Log.e(key, "onPostResume")
    }

    //Activity ile ilişkilendirilmiş ana pencere, pencere yöneticisine eklendiğinde çağrılır
    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        Log.e(key, "onAttachedToWindow")
    }

    //Seçenekler menüsünün içeriğinin oluşturulduğu method,bir kez çalıştırılır
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        Log.e(key, "onCreateOptionsMenu")
        return super.onCreateOptionsMenu(menu)
    }

    //Seçenekler menüsünün içeriğinin her görüntülendiğinde güncellemek için çağrılır
    override fun onPrepareOptionsMenu(menu: Menu): Boolean {
        Log.e(key, "onPrepareOptionsMenu")
        return super.onPrepareOptionsMenu(menu)
    }

    //Activity arka plana gönderildiğinde(ama ölmemişken) çağrılan method
    override fun onPause() {
        super.onPause()
        Log.e(key, "onPause")
    }

    /* Activity öldürülmeden önce çağrılan method
     * Mesela arka plana alınan activitynin hafızada yer kaplamaması için sistem tarafından kapatıldığı durumda bu method ile activitynin durumu kaydedilir.Activity tekrar aktif edildiğinde activitynin son durumu geri yüklenebilir
    */
    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        Log.e(key, "onSaveInstanceState")
    }

    //Activity artık kullanıcı tarafından görüntülenemediğinde çağrılan method (activity öldürülür)
    override fun onStop() {
        super.onStop()
        Log.e(key, "onStop")
    }

    //Activity yok edilmeden önce yapılması gereken temizlik işlemleri yapılır
    override fun onDestroy() {
        super.onDestroy()
        Log.e(key, "onDestroy")
    }

    //Activity etkinken kullanıcının ekranda yaptığı herhangi bir etkinlikte bu method çağrılır.
    override fun onUserInteraction() {
        super.onUserInteraction()
        Log.e(key, "onUserInteraction")
    }

    //Home butonuna tıklandığında çağrılan method
    override fun onUserLeaveHint() {
        super.onUserLeaveHint()
        Log.e(key, "onUserLeaveHint")
    }

    //Activty e requestCode kodunu ve ona ait ek verileri alarak başlatmak için çağrılır
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.e(key, "onActivityResult")
    }

    //Etkinliğiniz durdurulduktan sonra, tekrar başlatılmadan önce çağrılan method
    override fun onRestart() {
        super.onRestart()
        Log.e(key, "onRestart")
    }

    //Activity bir fragment eklendiğinde çağrılan method (Uygulamada fragment olmadığı için çalışmadı)
    override fun onAttachFragment(fragment: Fragment?) {
        super.onAttachFragment(fragment)
        Log.e(key, "onAttachFragment")
    }

    //Activity çalışırken cihaz yapılandırması değiştiğinde sistem tarafından çağrılan method
    // Örneğin ekranın döndürülmesi, dil ayarının değiştirilmesi, giriş aygıtlarındaki değişiklikler gibi
    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        Log.e(key, "onConfigurationChanged")
    }

    //Geri tuşuna basıldığında çağrılan method
    override fun onBackPressed() {
        super.onBackPressed()
        Log.e(key, "onBackPressed")
    }

}
