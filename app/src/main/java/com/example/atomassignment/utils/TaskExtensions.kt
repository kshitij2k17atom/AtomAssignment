package com.example.atomassignment.utils

import com.google.android.gms.tasks.Task
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

suspend fun <T> Task<T>.await(): T = suspendCancellableCoroutine { continuation ->
    this.addOnSuccessListener { result ->
        continuation.resume(result)
    }
    this.addOnFailureListener { error ->
        continuation.resumeWithException(error)
    }
    this.addOnCanceledListener {
        continuation.cancel()
    }
}