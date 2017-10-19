package softveloper.com.resume

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var callButton: Button
    lateinit var emailButton: Button
    lateinit var workHistoryButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        callButton = findViewById(R.id.callButton) as Button
        emailButton = findViewById(R.id.emailButton) as Button
        workHistoryButton = findViewById(R.id.workHistoryButton) as Button

        callButton.setOnClickListener({
            val phone = Uri.parse("tel:+66")
            val intent = Intent(Intent.ACTION_DIAL, phone)
            startActivity(intent)
        })

        emailButton.setOnClickListener({
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "plain/text"
            intent.putExtra(Intent.EXTRA_EMAIL, "")
            intent.putExtra(Intent.EXTRA_SUBJECT, "Two's Resume")
            intent.putExtra(Intent.EXTRA_TEXT, "I really like your resume!")
            startActivity(intent)
        })

        workHistoryButton.setOnClickListener({
            val intent = Intent(applicationContext, WorkHistoryActivity::class.java)
            startActivity(intent)
        })
    }
}
