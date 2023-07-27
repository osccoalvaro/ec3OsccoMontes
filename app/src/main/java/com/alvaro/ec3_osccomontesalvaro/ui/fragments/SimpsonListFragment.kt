package com.alvaro.ec3_osccomontesalvaro.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.alvaro.ec3_osccomontesalvaro.databinding.FragmentSimpsonListBinding
import com.alvaro.ec3_osccomontesalvaro.ui.viewmodels.SimpsonListViewModel

class SimpsonListFragment : Fragment() {

    private lateinit var binding: FragmentSimpsonListBinding
    private lateinit var viewModel: SimpsonListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[SimpsonListViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSimpsonListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = RVNoteListAdapter(listOf())
        binding.rvNoteList.adapter = adapter
        viewModel.notes.observe(requireActivity()) {
            adapter.simpsons = it
            adapter.notifyDataSetChanged()
        }
        viewModel.getNotesFromService()
    }

}