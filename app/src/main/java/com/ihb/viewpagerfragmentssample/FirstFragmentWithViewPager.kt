package com.ihb.viewpagerfragmentssample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_first.*

class FirstFragmentWithViewPager : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button)
            .setOnClickListener {
                fragmentManager
                    ?.beginTransaction()
                    ?.replace(R.id.fragments_container, SecondFragment())
                    ?.addToBackStack("")
                    ?.commit()
            }

        viewPager.adapter = FragmentsAdapter(childFragmentManager)

        view.post {
            (viewPager.adapter as FragmentsAdapter).pageTitles = listOf("PAGE 1", "PAGE 2")
            (viewPager.adapter as FragmentsAdapter).notifyDataSetChanged()
//            viewPager.setCurrentItem(1, true)
            viewPager.setCurrentItem(1, false)
        }
    }
}