package com.example.webtoon

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(private val mainActivity: MainActivity): FragmentStateAdapter(mainActivity) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0->{
                return WebViewFragment(position,"https://comic.naver.com/index").apply {
                    listener = mainActivity
                }
            }
            1->{
                return WebViewFragment(position,"https://ridibooks.com/webtoon/recommendation").apply {
                    listener = mainActivity
                }
            }
            else->{
                return WebViewFragment(position,"https://webtoon.kakao.com/").apply {
                    listener = mainActivity
                }
            }
        }
    }
}