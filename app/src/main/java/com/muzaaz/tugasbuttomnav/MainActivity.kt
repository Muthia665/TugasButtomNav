package com.muzaaz.tugasbuttomnav

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import com.muzaaz.tugasbuttomnav.UI.ItemFragment
import com.muzaaz.tugasbuttomnav.UI.ProfileFragment
import com.muzaaz.tugasbuttomnav.UI.StoreFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var store_Fragment: StoreFragment
    lateinit var item_Fragment: ItemFragment
    lateinit var profile_Fragment: ProfileFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        store_Fragment = StoreFragment()
        supportFragmentManager.beginTransaction().replace(R.id.frame_layout, store_Fragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()

        bottom_nav.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {

                R.id.store -> {
                    store_Fragment = StoreFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.frame_layout, store_Fragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
                }

                R.id.item -> {
                    item_Fragment = ItemFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.frame_layout, item_Fragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
                }

                R.id.profile -> {
                    profile_Fragment = ProfileFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.frame_layout, profile_Fragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
                }

            }
            // harus mengembalikan nilai
            true

        }
    }
}
