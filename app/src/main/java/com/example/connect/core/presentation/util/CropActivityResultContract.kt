package com.example.connect.core.presentation.util

import android.content.Context
import android.content.Intent
import android.content.RestrictionsManager.RESULT_ERROR
import android.net.Uri
import androidx.activity.result.contract.ActivityResultContract
import com.example.connect.core.domain.util.getFileName
import java.io.File

class CropActivityResultContract(
    private val aspectRatioX: Float,
    private val aspectRatioY: Float,
) : ActivityResultContract<Uri, Uri?>() {

    override fun createIntent(context: Context, input: Uri): Intent {
        return UCrop.of(
            input,
            Uri.fromFile(
                File(
                    context.cacheDir,
                    context.contentResolver.getFileName(input)
                )
            )
        )
            .withAspectRatio(aspectRatioX, aspectRatioY)
            .getIntent(context)
    }

    override fun parseResult(resultCode: Int, intent: Intent?): Uri? {
        if (intent == null) {
            return null
        }
        if (resultCode == RESULT_ERROR) {
            val error = UCrop.getError(intent)
            error?.printStackTrace()
        }
        return UCrop.getOutput(intent)
    }
}