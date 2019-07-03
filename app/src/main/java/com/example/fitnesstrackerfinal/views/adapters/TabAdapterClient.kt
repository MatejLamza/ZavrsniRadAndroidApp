package com.example.fitnesstrackerfinal.views.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import javax.annotation.Nullable

class TabAdapterClient(fm: FragmentManager?) : FragmentStatePagerAdapter(fm) {

    private var fragmentList: ArrayList<Fragment> = arrayListOf()
    private var fragmentTitleList: ArrayList<String> = arrayListOf()

    override fun getItem(pos: Int): Fragment  = fragmentList[pos]

    override fun getCount(): Int = fragmentList.size

    fun addFragment(fragment:Fragment, title:String){
        fragmentList.add(fragment)
        fragmentTitleList.add(title)
    }

    override fun getPageTitle(pos: Int):CharSequence{
        return fragmentTitleList[pos]
    }

}