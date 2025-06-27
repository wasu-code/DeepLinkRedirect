
package io.github.wasu_code.deeplinkredirect

import android.content.Intent
import android.net.Uri
import android.app.Activity
import android.widget.Toast


class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(null)
        handleIntent(intent)
        finish() // Close immediately after processing
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        handleIntent(intent)
    }

    private fun handleIntent(intent: Intent?) {
        intent?.data?.let { uri ->
            val deepLink = extractDeepLink(uri)
            deepLink?.let {
                openDeepLink(it)
            }
        }
    }

    private fun extractDeepLink(uri: Uri): String? {
        // Get everything after the domain (e.g., after "example.com")
        val pathAndQuery = uri.toString().substringAfter("${uri.scheme}://${uri.host}/")
        return pathAndQuery.ifEmpty { null }
    }

    private fun openDeepLink(deepLink: String) {
        try {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(deepLink))
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(this, "Failed to open deep link: $deepLink", Toast.LENGTH_SHORT).show()
        }
    }
}
