package dev.skyit.elearning.student.ui.profile

import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import com.github.mikephil.charting.utils.ColorTemplate
import com.github.ramiz.nameinitialscircleimageview.NameInitialsCircleImageView
import dev.skyit.elearning.R
import dev.skyit.elearning.databinding.FragmentProfileBinding
import dev.skyit.elearning.student.cache.CacheManager
import kotlinx.android.synthetic.main.fragment_profile.*
import org.koin.android.ext.android.bind
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.compat.ScopeCompat.viewModel
import thinkit.redesign.ui.generic.ActivityDestination
import thinkit.redesign.ui.generic.navigate

class StudentProfileFragment: Fragment(R.layout.fragment_profile) {

    private val binding: FragmentProfileBinding by viewBinding()

    private val cache: CacheManager by inject()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.accEmail.text = cache.email
        val imageUrl = "http://i.imgur.com/DvpvklR.png"
        //image info config with valid image url so this should display image
        val imageInfo: NameInitialsCircleImageView.ImageInfo = NameInitialsCircleImageView.ImageInfo
            .Builder(cache.email.take(2))
            .setTextColor(android.R.color.primary_text_dark)
            .setTextFont(R.font.montserrat)
            .setImageUrl(imageUrl)
            .setCircleBackgroundColorRes(android.R.color.holo_orange_dark)
            .build()
        initialsCircleImageView.setImageInfo(imageInfo)

        this.setHasOptionsMenu(true)
        setUpPieChartData()

    }

    private fun setUpPieChartData() {
        val yVals = ArrayList<PieEntry>()
        yVals.add(PieEntry(30f, "Algebra"))
        yVals.add(PieEntry(2f, "Geometrie"))
        yVals.add(PieEntry(4f, "Matematica"))
        yVals.add(PieEntry(22f, "Fizica"))
        yVals.add(PieEntry(12.5f, "Chimia"))

//        val dataSet = PieDataSet(yVals, "")
//        dataSet.valueTextSize=0f
//        val colors = java.util.ArrayList<Int>()
//        colors.add(Color.GRAY)
//        colors.add(Color.BLUE)
//        colors.add(Color.RED)
//        colors.add(Color.GREEN)
//        colors.add(Color.MAGENTA)
//
//        dataSet.setColors(colors)
//        val data = PieData(dataSet)
//        pieChart.data = data
//        pieChart.centerTextRadiusPercent = 0f
//        pieChart.isDrawHoleEnabled = false
//        pieChart.legend.isEnabled = false
//        pieChart.description.isEnabled = false

        pieChart.setUsePercentValues(true)
        pieChart.description.isEnabled = false
        pieChart.setExtraOffsets(-10f, -20f, -10f, -10f)

        pieChart.dragDecelerationFrictionCoef = 0.95f
        pieChart.isDrawHoleEnabled = true
        pieChart.setHoleColor(Color.WHITE)
        pieChart.transparentCircleRadius = 61f
        pieChart.setUsePercentValues(true)

        pieChart.legend.isEnabled = false

        pieChart.centerText = ""

        pieChart.animateY(1000, Easing.EaseInOutCubic)

        val dataSet = PieDataSet(yVals, "")
        dataSet.valueFormatter = PercentFormatter(pieChart)
        pieChart.setUsePercentValues(true)
        dataSet.sliceSpace = 3f
        dataSet.selectionShift = 25f
        dataSet.setColors(*ColorTemplate.JOYFUL_COLORS)

        val data = PieData(dataSet)
        data.setValueTextSize(20f)
        data.setValueTextColor(Color.BLACK)

        pieChart.setDrawEntryLabels(true)
        pieChart.setEntryLabelColor(Color.BLACK)
        pieChart.data = data

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.log_out_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.log_out_btn) {
            cache.isFirstTime = true;
            cache.loginToken = "";
            activity?.navigate(ActivityDestination.AUTH)
        }
        return super.onOptionsItemSelected(item)
    }
}