package cn.edu.swu.takeout.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import cn.edu.swu.takeout.R
import cn.edu.swu.takeout.ui.fragment.HomeFragment
import cn.edu.swu.takeout.ui.fragment.MeFragment
import cn.edu.swu.takeout.ui.fragment.SetFragment

//import kotlinx.android.synthetic.main.activity_main

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val main_bottom_bar = findViewById<LinearLayout>(R.id.main_bottom_bar)
        initBottomBar()
        changeIndex(0)
    }

    private val fragments: List<Fragment> = listOf<Fragment>(HomeFragment(), SetFragment(), MeFragment())
//        listOf<Fragment>(HomeFragment())


    private fun initBottomBar() {
        val main_bottom_bar = findViewById<LinearLayout>(R.id.main_bottom_bar)
        for (i in 0 until main_bottom_bar.childCount){
//            main_bottom_bar.getChildAt(i).setOnClickListener(object: OnClickListener{
//
//            })
            main_bottom_bar.getChildAt(i).setOnClickListener(){
                View -> changeIndex(i)
            }
        }
    }

    private fun changeIndex(index: Int) {
        val main_bottom_bar = findViewById<LinearLayout>(R.id.main_bottom_bar)
        for (i in 0 until main_bottom_bar.childCount){
            val child = main_bottom_bar.getChildAt(i)
            if (i == index){
                // stop
//                child.isEnabled = false
                setEnable(child, false)
            }else{
                // start enable = true
//                child.isEnabled = true
                setEnable(child, true)
            }
        }
//        fragmentManager.beginTransaction().replace(R.id.main_content, fragments[index]).commit()
        supportFragmentManager.beginTransaction().replace(R.id.main_content, fragments[index]).commit()
    }

    private fun setEnable(child: View, isEnable: Boolean) {
        child.isEnabled = isEnable
        if (child is ViewGroup){
            for (i in 0 until child.childCount){
                child.getChildAt(i).isEnabled = isEnable
            }
        }
    }
}