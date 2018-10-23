package sample.janken

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gu.setOnClickListener { onJankenButtonTapped(it) }
        choki.setOnClickListener { onJankenButtonTapped(it) }
        pa.setOnClickListener { onJankenButtonTapped(it) }

        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val editor = pref.edit()
        editor.clear().apply()
    }

    override fun onStart() {
        super.onStart()
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val gameCount = pref.getInt("GAME_COUNT", 1)

        gameCountLabel.text = gameCount.toString()
    }

    private fun onJankenButtonTapped(view: View?) {
        startActivity<ResultActivity>("MY_HAND" to view?.id)
    }
}
