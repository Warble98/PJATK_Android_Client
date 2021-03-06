package eu.warble.pjappkotlin.mvp.studentinfo

import android.os.Bundle
import android.util.SparseArray
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import eu.warble.pjappkotlin.R
import eu.warble.pjappkotlin.mvp.BaseFragment
import eu.warble.pjappkotlin.mvp.studentinfo.about.StudentAboutFragment
import eu.warble.pjappkotlin.mvp.studentinfo.fees.StudentFeesFragment
import eu.warble.pjappkotlin.mvp.studentinfo.marks.StudentMarksFragment
import kotlinx.android.synthetic.main.fragment_student_info.view.tabLayout
import kotlinx.android.synthetic.main.fragment_student_info.view.viewPager

class StudentInfoFragment : BaseFragment() {

    override val TAG: String = "fragment_student"

    private val childViews = SparseArray<BaseFragment>().apply {
        put(0, StudentAboutFragment.newInstance())
        put(1, StudentFeesFragment.newInstance())
        put(2, StudentMarksFragment.newInstance())
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_student_info, container, false)
        initTabs(view)
        return view
    }

    private fun initTabs(view: View) {
        val adapter = TabsFragmentAdapter(mContext, childViews, childFragmentManager)
        view.viewPager.adapter = adapter
        view.tabLayout.setupWithViewPager(view.viewPager)
    }

    companion object {

        fun newInstance() = StudentInfoFragment()

    }
}