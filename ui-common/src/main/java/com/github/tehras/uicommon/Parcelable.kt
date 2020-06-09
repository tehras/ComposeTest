package com.github.tehras.uicommon

import android.os.Parcel
import android.os.Parcelable
import com.squareup.workflow.Snapshot
import okio.ByteString

/**
 * Wraps receiver in a [Snapshot] suitable for use with [com.squareup.workflow.StatefulWorkflow].
 * Intended to allow use of `@Parcelize`.
 *
 * Read the [Parcelable] back with [toParcelable].
 */
fun Parcelable.toSnapshot(): Snapshot {
    return Snapshot.write { bufferedSink ->
        val parcel = Parcel.obtain()
        parcel.writeParcelable(this, 0)
        val byteArray = parcel.marshall()
        bufferedSink.write(byteArray)
        parcel.recycle()
    }
}

/**
 * @return a [Parcelable] previously wrapped with [toSnapshot], or `null` if the receiver is empty.
 */
inline fun <reified T : Parcelable> Snapshot.toParcelable(): T? {
    return bytes.takeIf { it.size > 0 }
        ?.toParcelable<T>()
}

inline fun <reified T : Parcelable> ByteString.toParcelable(): T {
    val parcel = Parcel.obtain()
    val byteArray = toByteArray()
    parcel.unmarshall(byteArray, 0, byteArray.size)
    parcel.setDataPosition(0)
    val rtn = parcel.readParcelable<T>(Snapshot::class.java.classLoader)!!
    parcel.recycle()
    return rtn
}