package com.shekhar.kotlin.ui.link

import android.content.ClipData
import android.content.ClipboardManager
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.browser.customtabs.CustomTabsClient
import androidx.browser.customtabs.CustomTabsIntent
import androidx.browser.customtabs.CustomTabsServiceConnection
import androidx.browser.customtabs.CustomTabsSession
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.shekhar.kotlin.dagger.R
import com.shekhar.kotlin.dagger.databinding.FragmentLinkBinding
import com.shekhar.kotlin.data.dto.DataModel
import com.shekhar.kotlin.data.dto.HomeResponse
import com.shekhar.kotlin.data.remote.CommonResponse
import com.shekhar.kotlin.data.repository.Resource
import com.shekhar.kotlin.ui.base.BaseFragment
import com.shekhar.kotlin.ui.base.listeners.RecyclerItemListener
import com.shekhar.kotlin.ui.link.adapter.ListAdapter
import com.shekhar.kotlin.utils.display.LoaderFragmentUtil
import com.shekhar.kotlin.utils.display.ScreenUtils
import com.shekhar.kotlin.utils.observe
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LinkFragment : BaseFragment<FragmentLinkBinding>()  {

    private val viewModel: LinkViewModel by viewModels()
    private lateinit var recentAdapter: ListAdapter
    private lateinit var topLinksAdapter: ListAdapter
    private var whatsappNumber = ""

    val CUSTOM_TAB_PACKAGE_NAME = "com.android.chrome";
    private var mCustomTabsServiceConnection: CustomTabsServiceConnection? = null
    private var mClient: CustomTabsClient? = null
    private var mCustomTabsSession: CustomTabsSession? = null
    private val loaderFragmentUtil = LoaderFragmentUtil().newInstance()



    override fun observeViewModel() {
        observe(viewModel.homeResponseLiveData,::handleHomeData)

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getHomeData()


        mCustomTabsServiceConnection = object : CustomTabsServiceConnection() {
            override fun onCustomTabsServiceConnected(componentName: ComponentName, customTabsClient: CustomTabsClient) {
                //Pre-warming
                mClient = customTabsClient
                mClient?.warmup(0L)
                mCustomTabsSession = mClient?.newSession(null)
            }

            override fun onServiceDisconnected(name: ComponentName) {
                mClient = null
            }
        }

        CustomTabsClient.bindCustomTabsService(requireActivity(), CUSTOM_TAB_PACKAGE_NAME,
            mCustomTabsServiceConnection as CustomTabsServiceConnection
        );



        recentAdapter = ListAdapter(viewModel, emptyList(), requireActivity(),object :
            RecyclerItemListener {
            override fun onItemCopy(item: DataModel, position: Int) {


                showToastMessage("Link copied to clipboard")
                val clipboard = context!!.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                val clip = ClipData.newPlainText("Copied Link", item.webLink)
                clipboard.setPrimaryClip(clip)

            }

            override fun onItemClick(item: DataModel, position: Int) {
                loadCustomTabForSite(item.webLink)
            }
        })

        topLinksAdapter = ListAdapter(viewModel, emptyList(), requireActivity(),object :
            RecyclerItemListener {
            override fun onItemCopy(item: DataModel, position: Int) {

                showToastMessage("Link copied to clipboard")

                val clipboard = context!!.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                val clip = ClipData.newPlainText("Copied Link", item.webLink)
                clipboard.setPrimaryClip(clip)
            }

            override fun onItemClick(item: DataModel, position: Int) {
                loadCustomTabForSite(item.webLink)
            }
        })


        mViewBinding.recyclerRecentData.adapter = recentAdapter
        mViewBinding.recyclerTopData.adapter = topLinksAdapter


        mViewBinding.layoutWhatsapp.setOnClickListener {
            val url = "https://api.whatsapp.com/send?phone=$whatsappNumber"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }

        mViewBinding.ivSetting.setOnClickListener {
            showToastMessage("Coming Soon")
        }

        mViewBinding.tvDate.setOnClickListener {
            showToastMessage("Filter coming Soon")
        }

        mViewBinding.tvViewAnalytics.setOnClickListener {
            showToastMessage("Coming Soon")
        }

        mViewBinding.ivSearch.setOnClickListener {
            showToastMessage("Coming Soon")
        }

        mViewBinding.layoutViewAllLink.setOnClickListener {
            showToastMessage("Coming Soon")
        }

        mViewBinding.layoutFaq.setOnClickListener {
            showToastMessage("Coming Soon")
        }

        mViewBinding.tvTopLinks.setOnClickListener {
            mViewBinding.tvTopLinks.setTextColor(resources.getColor(R.color.white))
            mViewBinding.tvRecentLinks.setTextColor(resources.getColor(R.color.grey))
            mViewBinding.tvTopLinks.setBackgroundResource(R.drawable.bg_rounded_blue)
            mViewBinding.tvRecentLinks.setBackgroundResource(0)
            mViewBinding.recyclerRecentData.visibility = View.GONE
            mViewBinding.recyclerTopData.visibility = View.VISIBLE

        }


        mViewBinding.tvRecentLinks.setOnClickListener {
            mViewBinding.tvRecentLinks.setTextColor(resources.getColor(R.color.white))
            mViewBinding.tvTopLinks.setTextColor(resources.getColor(R.color.grey))
            mViewBinding.tvRecentLinks.setBackgroundResource(R.drawable.bg_rounded_blue)
            mViewBinding.tvTopLinks.setBackgroundResource(0)
            mViewBinding.recyclerRecentData.visibility = View.VISIBLE
            mViewBinding.recyclerTopData.visibility = View.GONE

        }

        mViewBinding.tvGreeting.text = ScreenUtils.getGreetings()

    }

    override fun getViewBinding(): FragmentLinkBinding {
        return FragmentLinkBinding.inflate(layoutInflater)
    }

    private fun handleHomeData(status: Resource<HomeResponse>) {
        when (status) {
            is Resource.Loading -> showLoader()
            is Resource.Success -> status.data?.let {
                hideLoader()
                val homeResponse = it as HomeResponse

                val topLinks: List<DataModel> = homeResponse.data.topLinks!!
                val recentLinks: List<DataModel> = homeResponse.data.recentLinks!!

                recentAdapter.updateList(recentLinks)
                topLinksAdapter.updateList(topLinks)

                if (homeResponse.totalClicks == "")
                {
                    mViewBinding.tvClicks.text = "-"
                }
                else
                {
                    mViewBinding.tvClicks.text = homeResponse.todayClicks
                }

                if (homeResponse.topLocation == "")
                {
                    mViewBinding.tvLocation.text = "-"
                }
                else
                {
                    mViewBinding.tvLocation.text = homeResponse.topLocation

                }

                if (homeResponse.topSource == "")
                {
                    mViewBinding.tvSource.text = "-"
                }
                else
                {
                    mViewBinding.tvSource.text = homeResponse.topSource
                }

                if (homeResponse.startTime == "")
                {
                    mViewBinding.tvTime.text = "-"
                }
                else
                {
                    mViewBinding.tvTime.text = homeResponse.startTime
                }

                whatsappNumber = homeResponse.supportWhatsappNumber

                val dataMap = homeResponse.data.overallUrlChart

                //  Dummy Data
//                entries.add(Entry(1f, 2f))
//                entries.add(Entry(2f, 5f))
//                entries.add(Entry(3f, 6f))
//                entries.add(Entry(4f, 11f))
//                entries.add(Entry(5f, 13f))
//                entries.add(Entry(6f, 11f))
//                entries.add(Entry(7f, 15f))
//                entries.add(Entry(8f, 9f))
//                entries.add(Entry(9f, 6f))
//                entries.add(Entry(10f, 14f))
//                entries.add(Entry(11f, 10f))

                if (dataMap.isNotEmpty())
                {
                    val entries = ArrayList<Entry>()

                    for ( i in dataMap)
                    {
                        entries.add(Entry(i.key.substring(0,2).toFloat(), i.value.toFloat()))
                    }

                    val lineData = LineDataSet(entries, "")

                    lineData.setDrawValues(false)
                    lineData.setDrawFilled(true)
                    lineData.setDrawCircles(false)
                    lineData.color = ContextCompat.getColor(requireContext(), R.color.colorPrimaryDark)
                    lineData.fillDrawable =  ContextCompat.getDrawable(requireContext(), R.drawable.bg_chart_gradient)
                    lineData.lineWidth = 3f

                    mViewBinding.chart.xAxis.labelRotationAngle = 0f
                    mViewBinding.chart.xAxis.position = XAxis.XAxisPosition.BOTTOM
                    mViewBinding.chart.data = LineData(lineData)
                    mViewBinding.chart.axisRight.isEnabled = false
                    mViewBinding.chart.setTouchEnabled(true)
                    mViewBinding.chart.legend.isEnabled = false
                    mViewBinding.chart.setDrawGridBackground(true)
                    mViewBinding.chart.setDrawBorders(false)
                    mViewBinding.chart.setGridBackgroundColor(resources.getColor(R.color.white))
                    mViewBinding.chart.setPinchZoom(false)
                    mViewBinding.chart.description.text = ""
                    mViewBinding.chart.setNoDataText("No data available.")
                    mViewBinding.chart.animateX(1800, Easing.EaseInExpo)
                }

            }

            is Resource.DataError -> {
                status.data?.let {
                    hideLoader()
                    val commonResponse = it as CommonResponse
                    showToastMessage(commonResponse.message)
                }
            }
            else -> {}
        }
    }


    private fun showLoader()
    {
        if (!loaderFragmentUtil.isAdded)
        {
            loaderFragmentUtil.show(requireActivity().supportFragmentManager, "")
            loaderFragmentUtil.isCancelable = false
        }
    }

    private fun hideLoader()
    {
        loaderFragmentUtil.dismiss()
    }


    private fun showToastMessage(message: String)
    {
        Toast.makeText(requireContext(),message,Toast.LENGTH_SHORT).show()
    }



    //Logic to open url in chrome custom tabs
    fun loadCustomTabForSite(url: String) {
        val customTabsIntent = CustomTabsIntent.Builder(mCustomTabsSession)
            .setToolbarColor(resources.getColor(R.color.colorPrimaryDark))
            .setShowTitle(true)
            .build()

        customTabsIntent.launchUrl(requireActivity(), Uri.parse(url))
    }







}