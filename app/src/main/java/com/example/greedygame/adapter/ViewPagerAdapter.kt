package com.example.greedygame.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStateManagerControl
import androidx.fragment.app.FragmentStatePagerAdapter

class ViewPagerAdapter(fm: FragmentManager):FragmentStatePagerAdapter(fm) {

    private var list= arrayListOf<Fragment>()
    private var title= arrayListOf<String>()

    fun addto(f:Fragment,heading:String){
        list.add(f)
        title.add(heading)
    }


    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Fragment {
         return list[position]
    }

    override fun getPageTitle(position: Int): CharSequence? {
          return title[position]
    }
}