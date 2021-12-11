package com.asep.tugas_final_android.ui.ListBerita

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.asep.tugas_final_android.R
import com.asep.tugas_final_android.model.Article
import com.asep.tugas_final_android.ui.DetailBerita.DetailBeritaFragment
import kotlinx.android.synthetic.main.fragment_list_berita.*
import kotlinx.coroutines.launch

class ListBeritaFragment : Fragment() {

    private lateinit var viewModel: ListBeritaViewModel
    private lateinit var adapter: BeritaAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        viewModel = ViewModelProvider(this)[ListBeritaViewModel::class.java]
        return inflater.inflate(R.layout.fragment_list_berita, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = BeritaAdapter(object : BeritaAdapter.Listener {
            override fun onBeritaClick(article: Article) {
                DetailBeritaFragment.selectedBerita = article
                findNavController().navigate(R.id.action_listBeritaFragment_to_detailBeritaFragment)
            }
        })

        rcView_list_berita.setHasFixedSize(true)
        rcView_list_berita.layoutManager = LinearLayoutManager(requireContext())
        rcView_list_berita.adapter = adapter

        lifecycleScope.launch {
            viewModel.getBerita(adapter)
        }

    }

    companion object {

        @JvmStatic
        fun newInstance() = ListBeritaFragment()
    }
}