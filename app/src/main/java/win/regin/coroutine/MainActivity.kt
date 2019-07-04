package win.regin.coroutine

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*
import win.regin.coroutine.net.ViewState

class MainActivity : AppCompatActivity() {

    private val mViewModel: MainModel by lazy { ViewModelProviders.of(this).get(MainModel::class.java) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {
            mViewModel.getWxSubscription()
        }

        mViewModel.mWxSubscription.observe(this, Observer { viewState ->
            when (viewState) {
                is ViewState.Success -> {
                    textView.text = viewState.results?.toString()
                }
            }

        })
    }
}
