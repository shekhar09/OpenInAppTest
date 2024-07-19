package com.shekhar.kotlin.ui.link


import androidx.annotation.VisibleForTesting
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.shekhar.kotlin.data.dto.HomeResponse
import com.shekhar.kotlin.data.repository.DataRepository
import com.shekhar.kotlin.data.repository.Resource
import com.shekhar.kotlin.ui.base.BaseViewModel
import com.shekhar.kotlin.utils.wrapEspressoIdlingResource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LinkViewModel @Inject constructor(private val dataRepository: DataRepository) :
        BaseViewModel() {

        @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
        val homeResponseLiveDataPrivate = MutableLiveData<Resource<HomeResponse>>()
        val homeResponseLiveData: LiveData<Resource<HomeResponse>> get() = homeResponseLiveDataPrivate




        fun getHomeData() {
                viewModelScope.launch {
                        homeResponseLiveDataPrivate.value = Resource.Loading()
                        wrapEspressoIdlingResource {
                                dataRepository.requestHomeData().collect {
                                        homeResponseLiveDataPrivate.value = it
                                }
                        }
                }
        }
}
