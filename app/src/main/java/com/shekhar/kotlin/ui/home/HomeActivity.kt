package com.shekhar.kotlin.ui.home

import android.os.Bundle
import com.shekhar.kotlin.dagger.R
import com.shekhar.kotlin.dagger.databinding.ActivityHomeBinding
import com.shekhar.kotlin.ui.base.BaseActivity
import com.shekhar.kotlin.ui.campaign.CampaignFragment
import com.shekhar.kotlin.ui.course.CourseFragment
import com.shekhar.kotlin.ui.link.LinkFragment
import com.shekhar.kotlin.ui.profile.ProfileFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity  : BaseActivity() {

    private lateinit var binding: ActivityHomeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.bottomNavigationView.background = null

        binding.bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.link -> {
                    // Handle Link click here
                    supportFragmentManager.beginTransaction().replace(R.id.navigationHost, LinkFragment()).commit()

                    true
                }
                R.id.courses -> {
                    // Handle Courses click here
                    supportFragmentManager.beginTransaction().replace(R.id.navigationHost, CourseFragment()).commit()

                    true
                }
                R.id.campaign -> {
                    // Handle Campaign click here
                    supportFragmentManager.beginTransaction().replace(R.id.navigationHost, CampaignFragment()).commit()

                    true
                }
                R.id.profile -> {
                    // Handle profile click here
                    supportFragmentManager.beginTransaction().replace(R.id.navigationHost, ProfileFragment()).commit()

                    true
                }
                else -> false
            }
        }

        binding.bottomNavigationView.selectedItemId = R.id.link





    }
    override fun observeViewModel() {

    }

    override fun initViewBinding() {
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }











}
