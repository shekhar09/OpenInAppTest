package com.shekhar.kotlin.ui.course

import android.os.Bundle
import android.view.View
import com.shekhar.kotlin.dagger.databinding.FragmentCourseBinding
import com.shekhar.kotlin.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CourseFragment : BaseFragment<FragmentCourseBinding>()  {


//    private val connectViewModel: ConnectViewModel by viewModels()

    override fun observeViewModel() {

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mViewBinding

    }

    override fun getViewBinding(): FragmentCourseBinding {
        return FragmentCourseBinding.inflate(layoutInflater)
    }


}