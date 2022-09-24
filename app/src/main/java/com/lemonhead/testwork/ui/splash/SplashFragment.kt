package com.lemonhead.testwork.ui.splash

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import com.lemonhead.testwork.R
import com.lemonhead.testwork.model.ErrorViewModel
import com.lemonhead.testwork.ui.appactivity.AppActivity
import com.lemonhead.testwork.ui.map.MapFragment
import com.lemonhead.testwork.utils.OnNavigateListener
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class SplashFragment : MvpAppCompatFragment(R.layout.fragment_splash), SplashView {

    lateinit var llLoading: LinearLayout

    private var onNavigateListener: OnNavigateListener? = null
    private val getFile = requireActivity().activityResultRegistry.register(
        SELECT_FILE_KEY,
        ActivityResultContracts.OpenDocument(),
    ) {
        presenter.loadFromFile(it.toString())
    }

    private val presenter by moxyPresenter { SplashPresenter() }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        onNavigateListener = context as AppActivity
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        llLoading = view.findViewById(R.id.ll_loading)
    }

    override fun onShowDialog(error: ErrorViewModel) {
        val alertDialog = AlertDialog.Builder(requireContext()).create()
        alertDialog.setTitle(error.title)
        alertDialog.setMessage(getString(error.message))
        alertDialog.setButton(
            AlertDialog.BUTTON_NEUTRAL,
            getString(error.okBtn),
        ) { _, _ ->
            getFile.launch(arrayOf("text/*"))
            alertDialog.dismiss()

        }
        alertDialog.setButton(
            AlertDialog.BUTTON_NEGATIVE,
            getString(error.cancelBtn),
        ) { _, _ ->
            openMapScreen()
            alertDialog.dismiss()
        }
        alertDialog.show()
    }

    override fun onOpenMapScreen() {
        openMapScreen()
    }

    private fun openMapScreen() {
        onNavigateListener?.onNavigateExclusive(
            MapFragment(),
            MapFragment.TAG,
        )
    }

    companion object {
        const val TAG = "SplashFragment"
        private const val SELECT_FILE_KEY = "select_file_key"
    }
}